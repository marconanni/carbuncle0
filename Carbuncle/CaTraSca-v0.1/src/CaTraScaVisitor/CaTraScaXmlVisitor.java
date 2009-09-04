package CaTraScaVisitor;
import visitor.*;
import syntaxtree.*;

import java.util.*;
import java.io.*;
import org.w3c.dom.Document;

/**
 * Costruzione del file XML
 * 
 * @author Davide Candeloro
 */
public class CaTraScaXmlVisitor extends DepthFirstVisitor
{
    public final static String xmlDeclaration = "<?xml version=\"1.0\"?>";
    
    private boolean _continue = false;
    private String nome = "";

    //
   // User-generated visitor methods below
   //

   FileWriter file;

    public CaTraScaXmlVisitor(File file)
    {
        try
        {
            this.file = new FileWriter(file);
            write(xmlDeclaration);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

   
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

    private void write(String s)
    {
        try { file.write(s + "\n"); }
        catch (IOException e) { e.printStackTrace(); }
    }

    private void close()
    {
        try { file.close(); }
        catch (IOException e) { e.printStackTrace(); }
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

        write("<CaTraSca>");
        n.f0.accept(this);
        n.f1.accept(this);
        
        if (n.f2.present())
            n.f2.accept(this);

        write("<Continue value=\"" + _continue + "\" />");

        write("<Magazzino>");
        n.f3.accept(this);
        write("</Magazzino>");

        n.f4.accept(this);

        for (Iterator<Node> it = n.f5.nodes.iterator(); it.hasNext();)
        {
            Node nodo = it.next();
            nodo.accept(this);
      }
      
      n.f6.accept(this);
      write("</CaTraSca>");
      close();
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
        
        n.f0.accept(this);
        n.f1.accept(this);
        write("<Nome value=\"" + nome + "\"/>");

        if (n.f2.present())
            n.f2.accept(this);
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

        String attributi = "";

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        attributi += " via=\"" + nome + "\"";

        if (n.f3.present())
        {
            n.f3.accept(this);
            attributi += " numeroCivico=\"" + nome + "\"";
        }

        n.f4.accept(this);
        n.f5.accept(this);
        attributi += " cap=\"" + n.f5.tokenImage + "\"";
        n.f6.accept(this);
        attributi += " localita=\"" + nome + "\"";

        write("<Indirizzo " + attributi + "/>");
   }

    @Override
    public void visit(NumeroCivico n)
    {
        /**
        * f0 -> ", N"
        * f1 -> <NUM>
        */

        n.f0.accept(this);
        n.f1.accept(this);
        nome = n.f1.tokenImage;
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

        n.f0.accept(this);
        n.f1.accept(this);
        write("<DescrizionePeriodo" + nome + ">");
        if (n.f2.present())
        {
            write("<Giacenza>");
            n.f2.accept(this);
            write("</Giacenza>");
        }
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        write("</DescrizionePeriodo>");
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

        String localName = "";
        n.f0.accept(this);
        n.f1.accept(this);
        localName += " dataInizio=\"" + nome + "\"";
        n.f2.accept(this);
        n.f3.accept(this);
        localName += " dataFine=\"" + nome + "\"";
        n.f4.accept(this);
        nome = localName;
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
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        nome = n.f0.tokenImage + "-" +  n.f2.tokenImage + "-" + n.f4.tokenImage;
    }
   
    @Override
   public void visit(Giacenza n)
   {
        /**
        * f0 -> "GIACENZA INIZIALE:"
        * f1 -> Residuo()
        * f2 -> ( "," Residuo() )*
        */

        n.f0.accept(this);
        n.f1.accept(this);

        if (n.f2.present())
            n.f2.accept(this);

}

   
    @Override
   public void visit(Residuo n)
   {
        /**
        * f0 -> Prodotto()
        * f1 -> "QUANTITA"
        * f2 -> <NUM>
        */


        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        write(nome + " quantita=\"" + n.f2.tokenImage + "\"/>");

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

        String localName = "<Prodotto";

        n.f0.accept(this);
        n.f1.accept(this);
        localName += " marca=\"" + nome + "\"";
        n.f2.accept(this);
        n.f3.accept(this);
        localName += " modello=\"" + nome + "\"";

        nome = localName;
   }

   
    @Override
   public void visit(Azione n)
   {
        /**
        * f0 -> ( Movimento() | Trasformazione() )
        * f1 -> ";"
        */
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

        n.f0.accept(this);
        String localName = n.f0.tokenImage.substring(0, 1) + n.f0.tokenImage.substring(1).toLowerCase();
        write("<" + localName + ">");
        n.f1.accept(this);
        n.f2.accept(this);
        write("</" + localName + ">");
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

        write("<Trasformazione>");
        n.f0.accept(this);

        write("<ProdottiIngresso>");
        n.f1.accept(this);

        if (n.f2.present())
            n.f2.accept(this);

        write("</ProdottiIngresso>");

        n.f3.accept(this);

        write("<ProdottiUscita>");
        n.f4.accept(this);

        if (n.f5.present())
            n.f5.accept(this);

        write("</ProdottiUscita>");
        write("</Trasformazione>");
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

        n.f0.accept(this);
        n.f2.accept(this);
        n.f1.accept(this);
        n.f3.accept(this);
        write(nome + " quantita=\"" + n.f1.tokenImage + "\"/>");
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

      //write(nome);
   }
}
