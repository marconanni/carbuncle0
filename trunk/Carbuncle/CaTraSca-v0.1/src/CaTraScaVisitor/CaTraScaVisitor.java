package CaTraScaVisitor;

import visitor.*;
import syntaxtree.*;
import java.util.*;
import javax.swing.JTextArea;
import CaTraSca.*;
import java.awt.Color;

/**
 * Visitor che calcola la giacenza finale in magazzino.
 * 
 * @author Davide Candeloro
 */
public class CaTraScaVisitor extends DepthFirstVisitor
{
   public final String projectName = "CaTraSca";
   private JTextArea valutazioneArea = null;
   private boolean errore = false;
   private String erroreMsg = "";

   private int giorno = 0;
   private String mese = "";
   private int anno = 0;
   private Vector<CaTraSca.DescrizionePeriodo> _periodici = new Vector<CaTraSca.DescrizionePeriodo>();
   private CaTraSca.DescrizionePeriodo _descrizionePeriodo = null;
   private Vector<CaTraSca.Prodotto> prodotti = new Vector<CaTraSca.Prodotto>();
   private CaTraSca.Prodotto prodottoTemp = null;
   private CaTraSca.Magazzino _magazzino = null;
   private Vector<CaTraSca.Magazzino> _magazzini = new Vector<CaTraSca.Magazzino>();
   private CaTraSca.Indirizzo _indirizzo = null;
   private int numCiv = 0;
   private Node temp;
   private int numAzione = 0;
   private boolean _in = false;
   private boolean _giacIni = false;
   private boolean _continue = false;
   private String _nome = "";
   private Calendar c = null;

   public CaTraScaVisitor() { super(); }

   public CaTraScaVisitor(JTextArea area) {
        super();
        valutazioneArea = area;
    }

    //
   // User-generated visitor methods below
   //

   public boolean isErrore()
   {
       if (errore)
       {
           valutazioneArea.setForeground(Color.red);
           return true;
       }
       else
       {
           valutazioneArea.setForeground(Color.black);
           return false;
       }
   }

   public boolean isContinue()
   {
       return _continue;
   }

   public void print(String msg){
        if (valutazioneArea == null)
            System.out.println("" + msg);
        else valutazioneArea.setText(valutazioneArea.getText() + msg + "\n");
    }

    private int esisteArticolo()
    {
            int indice = -1;

            for (Iterator<Articolo> it = _magazzino.getArticoli().iterator(); it.hasNext();)
            {
                Articolo articolo = it.next();

                if (articolo.getProdotto().getMarca().equals(prodottoTemp.getMarca()) && articolo.getProdotto().getModello().equals(prodottoTemp.getModello()))
                    return _magazzino.getArticoli().indexOf(articolo);
            }
            
            return indice;
    }

   private void setError (String msg)
   {
        errore = true;
        erroreMsg = msg;
   }

    @Override
    public void visit(NodeList n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ){
          temp = e.nextElement();
          //System.out.println("Node List: " + temp.toString());
          temp.accept(this);
         if (isErrore()) return;
      }
   }

   @Override
   public void visit(NodeListOptional n) {
      if ( n.present() )
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         {
            temp = e.nextElement();
            //System.out.println("Node ListOptional: " + temp.toString());
            temp.accept(this);
         }
   }

   @Override
   public void visit(NodeOptional n) {
      if ( n.present() ){
          //System.out.println("Node Optionalal: " + n.node.toString());
         n.node.accept(this);
   }}

   @Override
   public void visit(NodeSequence n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ){
          temp = e.nextElement();
          //System.out.println("Node Sequence: " + temp.toString());
         temp.accept(this);
   }}

   @Override
   public void visit(NodeToken n) { }

    @Override
    public void visit(Scope n)
    {

        /**
        * f0 -> "CaTraSca"
        * f1 -> "{"
        * f2 -> [ Continue() ]
        * f3 -> Magazzino()
        * f4 -> ";"
        * f5 -> ( DescrizionePeriodo() )+
        * f6 -> "}"
        */

      n.f0.accept(this);
      n.f1.accept(this);

      if (n.f2.present())
        n.f2.accept(this);
      else
        _continue = false;

      n.f3.accept(this);
      n.f4.accept(this);

      int i = 0;
        for (Iterator<Node> it = n.f5.nodes.iterator(); it.hasNext();)
        {
            Node nodo = it.next();
            i++;
            
            if (!_continue)
            {
                _magazzino = new CaTraSca.Magazzino(_nome, _indirizzo, new ArticoloCollection<Articolo>());
                numAzione = 0;
            }
            else
               _magazzino = new CaTraSca.Magazzino(_nome, _indirizzo, _magazzino.copiaArticoli());
            
            _magazzini.add(_magazzino);
            _descrizionePeriodo = new CaTraSca.DescrizionePeriodo();
            _periodici.add(_descrizionePeriodo);
            nodo.accept(this);
        }
      
      n.f6.accept(this);
    }

    @Override
   public void visit(Continue n) {
        /**
        * f0 -> "CONTINUE"
        * f1 -> "="
        * f2 -> <BOOL>
        */

        n.f0.accept(this);
        n.f1.accept(this);

        n.f2.accept(this);
        String str = n.f2.tokenImage;

        if (str.equals("TRUE"))
            _continue = true;
        else if (str.equals("FALSE"))
            _continue = false;
   }

    @Override
   public void visit(syntaxtree.DescrizionePeriodo n)
    {
        /**
        * f0 -> "{"
        * f1 -> Periodo()
        * f2 -> [ Giacenza() ";" ]
        * f3 -> "{"
        * f4 -> ( Azione() )+
        * f5 -> "}"
        * f6 -> "}"
        */
        
        n.f0.accept(this);
        n.f1.accept(this);

        if (n.f2.present())
            if (_continue && _periodici.toArray().length > 1)
                setError("Nel caso CONTINUE=TRUE la giacenza iniziale puo\' essere inserita solo nel primo periodo.");
            else
                n.f2.accept(this);

        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
   }

    @Override
    public void visit(syntaxtree.Periodo n)
    {
        /**
        * f0 -> "DA"
        * f1 -> Data()
        * f2 -> "A"
        * f3 -> Data()
        * f4 -> ";"
        */

        n.f0.accept(this);
        n.f1.accept(this);
        _descrizionePeriodo.setDataInizio(giorno, mese, anno);
        n.f2.accept(this);
        n.f3.accept(this);
        _descrizionePeriodo.setDataFine(giorno, mese, anno);

        if (_descrizionePeriodo.getDataInizio().after(_descrizionePeriodo.getDataFine()))
            setError("La data di fine periodo (" + _descrizionePeriodo.getDataFineString() + ") è precedente a quella di inizio periodo (" + _descrizionePeriodo.getDataInizioString() + ").");

        if (_continue && c != null)
            if (c.after(_descrizionePeriodo.getDataInizio()) ||  (_descrizionePeriodo.getDataInizio().get(5) + "-" + Mese.values()[_descrizionePeriodo.getDataInizio().get(2)] + "-" + _descrizionePeriodo.getDataInizio().get(1)).equals(c.get(5) + "-" + Mese.values()[c.get(2)] + "-" + c.get(1)))
            {
                _descrizionePeriodo.setDataFine(c);
                setError("I diversi periodi devono essere in ordine cronologico e non sovrapposti in quanto si è selezionato l'opzione CONTINUE=TRUE.\n" +
                        "Il periodo che inizia nel " + _descrizionePeriodo.getDataInizioString() + " non puo\' iniziare in questa data ma deve venire dopo del periodo che finisce nel " + _descrizionePeriodo.getDataFineString() + ".");
            }

        c = _descrizionePeriodo.getDataFine();
        n.f4.accept(this);
    }
    
    @Override
    public void visit(syntaxtree.Data n)
    {
        /**
        * f0 -> <NUM>
        * f1 -> "-"
        * f2 -> <MESE>
        * f3 -> "-"
        * f4 -> <NUM>
        */

        n.f0.accept(this);
        giorno = Integer.parseInt(n.f0.tokenImage);

        n.f1.accept(this);

        n.f2.accept(this);
        mese = n.f2.tokenImage;

        n.f3.accept(this);

        n.f4.accept(this);
        anno = Integer.parseInt(n.f4.tokenImage);
    }
    
    @Override
   public void visit(syntaxtree.Magazzino n)
   {
        /**
        * f0 -> "MAGAZZINO"
        * f1 -> NomeComposto()
        * f2 -> [ Indirizzo() ]
        */
        
        n.f0.accept(this);
        n.f1.accept(this);
        String nome = _nome;
        n.f2.accept(this);
        
        if (n.f2.present())
            _magazzino = new CaTraSca.Magazzino(nome,_indirizzo);
        else
            _magazzino = new CaTraSca.Magazzino(nome);
   }

    @Override
    public void visit(syntaxtree.NomeComposto n)
    {
        /**
        * f0 -> <NOME>
        * f1 -> ( <NOME> )*
        */

        _nome = "";
        n.f0.accept(this);
        _nome += n.f0.tokenImage;
        n.f1.accept(this);

        for (Iterator<syntaxtree.Node> it = n.f1.nodes.iterator(); it.hasNext();) {
            syntaxtree.Node nodo = it.next();
            _nome += " " + nodo.toString();
        }
    }

    @Override
   public void visit(syntaxtree.Indirizzo n)
   {
        /**
        * f0 -> ","
        * f1 -> "via"
        * f2 -> NomeComposto()
        * f3 -> [ NumeroCivico() ]
        * f4 -> ","
        * f5 -> NomeComposto()
        * f6 -> NomeComposto()
        */
        
        n.f0.accept(this);
        n.f1.accept(this);

        n.f2.accept(this);
        String via = _nome;
        
        n.f3.accept(this);
        n.f4.accept(this);
        
        n.f5.accept(this);
        int cap = Integer.parseInt(n.f5.tokenImage);

        n.f6.accept(this);
        String citta = _nome;

        if (n.f3.present())
            _indirizzo = new CaTraSca.Indirizzo(via, numCiv, cap, citta);
        else
            _indirizzo = new CaTraSca.Indirizzo(via, cap, citta);
   }

    
    @Override
   public void visit(NumeroCivico n) 
   {
        /**
        * f0 -> ", n"
        * f1 -> <NUM>
        */
        
        n.f0.accept(this);

        n.f1.accept(this);
        numCiv = Integer.parseInt(n.f1.tokenImage);
   }

    @Override
   public void visit(syntaxtree.Giacenza n)
   {
        /**
        * f0 -> "Giacenza iniziale:"
        * f1 -> Residuo()
        * f2 -> ( "," Residuo() )*
        */
        
        n.f0.accept(this);
        _giacIni = true;
        n.f1.accept(this);
        n.f2.accept(this);
        _giacIni = false;
   }

    @Override
   public void visit(syntaxtree.Residuo n)
   {
        /**
        * f0 -> Prodotto()
        * f1 -> "Quantita"
        * f2 -> <NUM>
        */

        n.f0.accept(this);
        n.f1.accept(this);

        n.f2.accept(this);
        int quantita = Integer.parseInt(n.f2.tokenImage);

        int indice = esisteArticolo();
        
        try
        {
        if (indice != -1)
            if (!_giacIni) // si tratta di un Movimento, altrimenti della giacenza iniziale
                ((CaTraSca.Movimento)_descrizionePeriodo.getAzioni().lastElement()).getMovimentiEffettivi().add(new MovimentoEffettivo((_magazzino.getArticoli().get(indice)), quantita));
            else
                (_magazzino.getArticoli().get(indice)).add(quantita);
        else // Creo l'articolo
            if (!_giacIni) // si tratta di un Carico, altrimenti di una giacenza iniziale
                ((CaTraSca.Movimento)_descrizionePeriodo.getAzioni().lastElement()).getMovimentiEffettivi().add(new MovimentoEffettivo(new Articolo(prodottoTemp,quantita), quantita));
            else
                _magazzino.getArticoli().add(new Articolo(prodottoTemp,quantita));
        }
        catch(CaTraScaException e)
        {
            setError(e.getMessage());
            return;
        }
   }

    @Override
   public void visit(syntaxtree.Prodotto n)
   {
        /**
        * f0 -> "Marca"
        * f1 -> NomeComposto()
        * f2 -> "Modello"
        * f3 -> NomeComposto()
        */

        n.f0.accept(this);
        
        n.f1.accept(this);
        String marca = _nome;

        n.f2.accept(this);

        n.f3.accept(this);
        String modello = _nome;

        prodottoTemp = new CaTraSca.Prodotto(marca,modello);

        if (!prodotti.contains(prodottoTemp))
            prodotti.add(prodottoTemp);
   }

    @Override
   public void visit(syntaxtree.Azione n)
   {
        /**
        * f0 -> ( Movimento() | Trasformazione() )
        * f1 -> ";"
        */

        numAzione++;
        
        n.f0.accept(this);
        n.f1.accept(this);
   }
    
    @Override
   public void visit(syntaxtree.Movimento n)
   {
        /**
        * f0 -> <MOVIMENTO>
        * f1 -> ":"
        * f2 -> ( Residuo() )+
        */

        n.f0.accept(this);
    try
    {
        _descrizionePeriodo.getAzioni().add((CaTraSca.Movimento)Class.forName(projectName + "." + n.f0.tokenImage.charAt(0) + n.f0.tokenImage.substring(1).toLowerCase()).newInstance());
    }
    catch(ClassNotFoundException e){setError("ERRORE:\nIl nome dell\'azione n." + numAzione + " non e\' corretto.\n(" + e + ")");}
    catch(InstantiationException e){setError("ERRORE:\nIl nome dell\'azione n." + numAzione + " non e\' corretto.\n(" + e + ")");}
    catch(IllegalAccessException e){setError("ERRORE:\nIl nome dell\'azione n." + numAzione + " non e\' corretto.\n(" + e + ")");}

        n.f1.accept(this);
        n.f2.accept(this);
        
        try { ((CaTraSca.Movimento)_descrizionePeriodo.getAzioni().lastElement()).Fai(_magazzino.getArticoli()); }
        catch(CaTraScaException e) {setError(e.toString());}
    }

    @Override
   public void visit(syntaxtree.Trasformazione n)
   {
        /**
        * f0 -> "Trasformazione:"
        * f1 -> Materia()
        * f2 -> ( "+" Materia() )*
        * f3 -> "="
        * f4 -> Materia()
        * f5 -> ( "+" Materia() )*
        */

        n.f0.accept(this);
        _descrizionePeriodo.getAzioni().add(new CaTraSca.Trasformazione());

        _in = true;
        n.f1.accept(this);
        n.f2.accept(this);
        _in = false;
        
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);

        try
        {
            _descrizionePeriodo.getAzioni().lastElement().Fai(_magazzino.getArticoli());
        }
        catch(CaTraScaException e) {setError(e.toString() + " on visit(Trasformazione n)");}
   }

    @Override
   public void visit(syntaxtree.Materia n)
   {
        /**
        * f0 -> "("
        * f1 -> <NUM>
        * f2 -> Prodotto()
        * f3 -> ")"
        */

        n.f0.accept(this);

        n.f1.accept(this);
        int quantita = Integer.parseInt(n.f1.tokenImage);

        n.f2.accept(this);

        int indice = esisteArticolo();
        try
        {
            if (_in)
                if (indice != -1)
                    ((CaTraSca.Trasformazione)_descrizionePeriodo.getAzioni().lastElement()).getUtilizzi().add(new Utilizzo(_magazzino.getArticoli().get(indice), quantita));
                else
                    ((CaTraSca.Trasformazione)_descrizionePeriodo.getAzioni().lastElement()).getUtilizzi().add(new Utilizzo(new Articolo(prodottoTemp), quantita));
            else
                if (indice != -1)
                    ((CaTraSca.Trasformazione)_descrizionePeriodo.getAzioni().lastElement()).getCreazioni().add(new Creazione(_magazzino.getArticoli().get(indice), quantita));
                else
                    ((CaTraSca.Trasformazione)_descrizionePeriodo.getAzioni().lastElement()).getCreazioni().add(new Creazione(new Articolo(prodottoTemp), quantita));
        }
        catch(CaTraScaException e){errore = true; erroreMsg = e.toString() + " on visit(Materia n)";}

        n.f3.accept(this);
   }

    public Vector<CaTraSca.Magazzino> getRisultato()
    {
        return _magazzini;
    }

    public String getErrore()
    {
        return erroreMsg;
    }

    public Vector<CaTraSca.DescrizionePeriodo> getPeriodici()
    {
        return _periodici;
    }
}