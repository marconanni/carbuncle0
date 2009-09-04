package CaTraScaVisitor;
import visitor.*;
import syntaxtree.*;
import java.util.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Costruzione dell'albero sintattico
 * 
 * @author Davide Candeloro
 */
public class CaTraScaTreeVisitor extends DepthFirstVisitor {

   private DefaultMutableTreeNode parentNode;
   private int numAzione = 0;
   private String nome = "";
   private Calendar gc1 = null;
   private Calendar gc2 = null;
   private int giorno = 0;
   private String mese = "";
   private int anno = 0;
   private boolean _continue = false;

    public DefaultMutableTreeNode getTree()
    {
        return parentNode;
    }
   public TreeNode getTreeNode() { return this.parentNode.getRoot(); }

    //
   // User-generated visitor methods below
   //

   
    @Override
    public void visit(NodeList n)
    {
      for (Enumeration<Node> e = n.elements(); e.hasMoreElements();)
         e.nextElement().accept(this);
    }

    @Override
    public void visit(NodeListOptional n)
    {
        if ( n.present() )
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
            e.nextElement().accept(this);
    }

    @Override
    public void visit(NodeOptional n)
    {
         if ( n.present() )
         n.node.accept(this);
    }

    @Override
    public void visit(NodeSequence n)
    {
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
    }

    @Override
    public void visit(NodeToken n){}

    public void print (String str)
    {
       System.out.println(str);
    }

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
      
      parentNode = new DefaultMutableTreeNode("CaTraSca");
      DefaultMutableTreeNode myParent = parentNode;

      n.f1.accept(this);

      if (n.f2.present())
        n.f2.accept(this);

      
      n.f3.accept(this);

      n.f4.accept(this);

      for (Iterator<Node> it = n.f5.nodes.iterator(); it.hasNext();)
      {
          Node nodo = it.next();

          if (!_continue)
              numAzione = 0;

          nodo.accept(this);
          parentNode = myParent;
      }
      
      n.f6.accept(this);
    }

    @Override
   public void visit(Continue n) 
   {
        /**
        * f0 -> "CONTINUE"
        * f1 -> "="
        * f2 -> <BOOL>
        */

      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      if (n.f2.tokenImage.equals("TRUE"))
          _continue = true;
      else
          _continue = false;
   }
   
    @Override
   public void visit(Magazzino n)
   {
        /**
        * f0 -> "MAGAZZINO"
        * f1 -> NomeComposto()
        * f2 -> [ Indirizzo() ]
        */
        
        DefaultMutableTreeNode myParent = parentNode;
        DefaultMutableTreeNode magazzinoNode = new DefaultMutableTreeNode("Magazzino");
        myParent.add(magazzinoNode);

        n.f0.accept(this);

        parentNode = new DefaultMutableTreeNode("Nome");
        n.f1.accept(this);
        magazzinoNode.add(parentNode);
        parentNode.add(new DefaultMutableTreeNode(nome));

        if (n.f2.present())
        {
            parentNode = new DefaultMutableTreeNode("Indirizzo");
            n.f2.accept(this);
            magazzinoNode.add(parentNode);
        }
        parentNode = myParent;
   }

   
    @Override
   public void visit(Indirizzo n)
   {
        /**
        * f0 -> ","
        * f1 -> "VIA"
        * f2 -> NomeComposto()
        * f3 -> [ NumeroCivico() ]
        * f4 -> ","
        * f5 -> <NUM>
        * f6 -> NomeComposto()
        */
        DefaultMutableTreeNode myParent = parentNode;
        
        n.f0.accept(this);
        n.f1.accept(this);

        parentNode = new DefaultMutableTreeNode("Via");
        n.f2.accept(this);
        myParent.add(parentNode);
        parentNode.add(new DefaultMutableTreeNode(nome));

        parentNode = myParent;
        
        if (n.f3.present())
            n.f3.accept(this);

        n.f4.accept(this);

        parentNode = new DefaultMutableTreeNode("CAP");
        n.f5.accept(this);
        myParent.add(parentNode);
        parentNode.add(new DefaultMutableTreeNode(n.f5.toString()));

        parentNode = new DefaultMutableTreeNode("Citta\'");
        n.f6.accept(this);
        myParent.add(parentNode);
        parentNode.add(new DefaultMutableTreeNode(nome));

        parentNode = myParent;
   }

    @Override
    public void visit(NumeroCivico n)
    {
        /**
        * f0 -> ", N"
        * f1 -> <NUM>
        */

        DefaultMutableTreeNode myParent = parentNode;

        n.f0.accept(this);
        parentNode = new DefaultMutableTreeNode("Numero civico");
        n.f1.accept(this);
        myParent.add(parentNode);
        parentNode.add(new DefaultMutableTreeNode(n.f1.toString()));

        parentNode = myParent;
    }

    @Override
   public void visit(DescrizionePeriodo n)
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

        DefaultMutableTreeNode myParent = parentNode;
        
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);

        myParent = parentNode;
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

        DefaultMutableTreeNode myParent = parentNode;

        n.f0.accept(this);
        n.f1.accept(this);
        (gc1 = GregorianCalendar.getInstance()).set(anno, CaTraSca.Mese.valueOf(mese).ordinal(), giorno);
        n.f2.accept(this);
        n.f3.accept(this);
        (gc2 = GregorianCalendar.getInstance()).set(anno, CaTraSca.Mese.valueOf(mese).ordinal(), giorno);
        n.f4.accept(this);

        parentNode = new DefaultMutableTreeNode("Da " + gc1.get(5) + "-" + CaTraSca.Mese.values()[gc1.get(2)] + "-" + gc1.get(1) + " al " + gc2.get(5) + "-" + CaTraSca.Mese.values()[gc2.get(2)] + "-" + gc2.get(1));
        myParent.add(parentNode);
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
        giorno = Integer.parseInt(n.f0.toString());

        n.f1.accept(this);

        n.f2.accept(this);
        mese = n.f2.toString();

        n.f3.accept(this);

        n.f4.accept(this);
        anno = Integer.parseInt(n.f4.toString());
    }
   
    @Override
   public void visit(Giacenza n)
   {
        /**
        * f0 -> "GIACENZA INIZIALE:"
        * f1 -> Residuo()
        * f2 -> ( "," Residuo() )*
        */

        DefaultMutableTreeNode myParent = parentNode;
        parentNode = new DefaultMutableTreeNode("Giacenza iniziale");
        n.f0.accept(this);
        n.f1.accept(this);

        if (n.f2.present())
            n.f2.accept(this);

        myParent.add(parentNode);
        parentNode = myParent;
   }

   
    @Override
   public void visit(Residuo n)
   {
        /**
        * f0 -> Prodotto()
        * f1 -> "QUANTITA"
        * f2 -> <NUM>
        */

        DefaultMutableTreeNode myParent = parentNode;
        DefaultMutableTreeNode articoloNode = new DefaultMutableTreeNode("Articolo");
        myParent.add(articoloNode);

        parentNode = new DefaultMutableTreeNode("Prodotto");
        n.f0.accept(this);
        articoloNode.add(parentNode);

        n.f1.accept(this);

        parentNode = new DefaultMutableTreeNode("Quantita\'");
        n.f2.accept(this);
        articoloNode.add(parentNode);
        parentNode.add(new DefaultMutableTreeNode(n.f2.toString()));

        parentNode = myParent;
   }

   
    @Override
   public void visit(Prodotto n)
   {
        /**
        * f0 -> "MARCA"
        * f1 -> NomeComposto()
        * f2 -> "MODELLO"
        * f3 -> NomeComposto()
        */

        DefaultMutableTreeNode myParent = parentNode;
        String subNome = "";
        n.f0.accept(this);
        n.f1.accept(this);
        subNome = nome;
        n.f2.accept(this);
        n.f3.accept(this);
        parentNode.add(new DefaultMutableTreeNode(subNome + " - " + nome));

        parentNode = myParent;
   }

   
    @Override
   public void visit(Azione n)
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
   public void visit(Movimento n)
   {
        /**
        * f0 -> <MOVIMENTO>
        * f1 -> ":"
        * f2 -> ( Residuo() )+
        */

        DefaultMutableTreeNode myParent = parentNode;

        n.f0.accept(this);
        parentNode = new DefaultMutableTreeNode(numAzione + ". " + n.f0.toString());
        myParent.add(parentNode);
        
        n.f1.accept(this);

        n.f2.accept(this);

        parentNode = myParent;
    }
   
    @Override
   public void visit(Trasformazione n)
   {
        /**
        * f0 -> "Trasformazione:"
        * f1 -> Materia()
        * f2 -> ( "+" Materia() )*
        * f3 -> "="
        * f4 -> Materia()
        * f5 -> ( "+" Materia() )*
        */

        DefaultMutableTreeNode myParent = parentNode;

        DefaultMutableTreeNode trasformazioneNode = new DefaultMutableTreeNode(numAzione + ". " + n.f0.toString().substring(0, n.f0.toString().length()-1)); // per eliminare ":"
        n.f0.accept(this);
        parentNode.add(trasformazioneNode);

        parentNode = new DefaultMutableTreeNode("Materiale d\'Ingresso");
        n.f1.accept(this);
        trasformazioneNode.add(parentNode);

        if (n.f2.present())
            n.f2.accept(this);

        n.f3.accept(this);

        parentNode = new DefaultMutableTreeNode("Materiale d\'Uscita");
        n.f4.accept(this);
        trasformazioneNode.add(parentNode);

        if (n.f5.present())
            n.f5.accept(this);

        parentNode = myParent;
   }

   
    @Override
   public void visit(Materia n)
   {
        /**
        * f0 -> "("
        * f1 -> <NUM>
        * f2 -> Prodotto()
        * f3 -> ")"
        */

        DefaultMutableTreeNode myParent = parentNode;
        DefaultMutableTreeNode articoloNode = new DefaultMutableTreeNode("Articolo");
        myParent.add(articoloNode);

        n.f0.accept(this);

        parentNode = new DefaultMutableTreeNode("Prodotto");
        n.f2.accept(this);
        articoloNode.add(parentNode);

        parentNode = new DefaultMutableTreeNode("Quantita\'");
        n.f1.accept(this);
        articoloNode.add(parentNode);
        parentNode.add(new DefaultMutableTreeNode(n.f1.toString()));

        n.f3.accept(this);

        parentNode = myParent;
   }

    @Override
   public void visit(NomeComposto n) {

        /**
        * f0 -> <NOME>
        * f1 -> ( <NOME> )*
        */


        nome = "";
        n.f0.accept(this);
        n.f1.accept(this);

        for (Iterator<Node> it = n.f1.nodes.iterator(); it.hasNext();) {
            Node nodo = it.next();
            nome += " " + nodo.toString();
        }
      nome = n.f0.toString() + " " + nome;
   }
}
