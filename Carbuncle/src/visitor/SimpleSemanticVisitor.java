package visitor;

import java.util.Enumeration;

import syntaxtree.Azione;
import syntaxtree.Bersaglio;
import syntaxtree.Invocazione;
import syntaxtree.Magia;
import syntaxtree.Node;
import syntaxtree.NodeList;
import syntaxtree.NodeListOptional;
import syntaxtree.NodeOptional;
import syntaxtree.NodeSequence;
import syntaxtree.NodeToken;
import syntaxtree.Oggetto;
import syntaxtree.S;
import syntaxtree.TecnicaSpeciale;


// questo visitor  implementa una semantica semplificata:
// ogni attacco fisico comporta un danno di 200
// ogni attacco magico un danno di 250
// ogni invocazione un danno di 300
// ogni tecnica speciale un danno di 500
// la magia bianca energia recupera 400
// la pozione recupera 300
// sia dipel che esna annullano tutti gli stati
// le magie di stato modificano gli stati direttamente
// l'antidoto elimina lo stato veleno
// l'erba dell'eco elimina lo stato mutismo
// il collirio elimina lo stato cecità
// l'ago dorato elimina lo stato pietra
// le magie di stato hanno lo stesso effetto che in FF

// in questa prima bozza di prova si usa il depth first visitor come base. si esplora prima il ramo
// dell personaggio, poi quello del bersaglio, infine qeullo dell'azione.
// il visitor ha al suo interno la varibile d'appoggio ambiente di combattimento che punta ai dati di
//tutti i personaggi coinvolti nello scontro, le variabili personaggio e bersaglio nelle quali vengono
// immagazzinati i valori di personaggio e bersaglio per l'azione. E' nel metodo accept dell'azione
//(che viene eseguito per ultimo) che si vanno a modificare i valori dell'ambiente di combattimento 
//(ad esempio modificando stato o HP del bersaglio).


public class SimpleSemanticVisitor implements GJNoArguVisitor{
	private String personaggio;
	private String bersaglio;
	private Object environment;

	@Override
	public Object visit(NodeList n) {
		 Object _ret=null;
	      int _count=0;
	      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	         e.nextElement().accept(this);
	         _count++;
	      }
	      return _ret;
	}

	@Override
	public Object visit(NodeListOptional n) {
		if ( n.present() ) {
	         Object _ret=null;
	         int _count=0;
	         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	            e.nextElement().accept(this);
	            _count++;
	         }
	         return _ret;
	      }
	      else
	         return null;
	}

	@Override
	public Object visit(NodeOptional n) {
		if ( n.present() )
	         return n.node.accept(this);
	      else
	         return null;
	}

	@Override
	public Object visit(NodeSequence n) {
		Object _ret=null;
	      int _count=0;
	      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	         e.nextElement().accept(this);
	         _count++;
	      }
	      return _ret;
	}

	@Override
	public Object visit(NodeToken n) {
		return n.toString();
		
	}

	@Override
	 /**
	    * f0 -> <PERSONAGGIO>
	    * f1 -> Azione()
	    * f2 -> Bersaglio()
	    */
	   public Object visit(S n) {
	      Object _ret=null;
	      personaggio =(String) n.f0.accept(this);
	      // inserire codice per verificare che il nome del personaggio sia stato memorizzato nella variabile 
	      n.f2.accept(this);
	      n.f1.accept(this);
	     
	      return _ret;
	   }

	@Override
	/**
	    * f0 -> <ALLEATI>
	    *       | <NEMICI>
	    *       | <PERSONAGGIO>
	    */
	   public Object visit(Bersaglio n) {
		Object _ret=null;
	      _ret =n.f0.accept(this);
	      bersaglio = (String) _ret;
	      return _ret;
	   }

	   /**
	    * f0 -> <ATTACCO>
	    *       | Magia()
	    *       | Oggetto()
	    *       | Invocazione()
	    *       | TecnicaSpeciale()
	    */
	   public Object visit(Azione n) {
		  
	      n.f0.accept(this);
	      System.out.println(personaggio + " ha attaccato " + bersaglio+ " causando un danno di 200HP");
	      return null;
	   }

	   /**
	    * f0 -> "lancia"
	    * f1 -> ( <ELEMENTALE> | <NONELEMENTALE> | <DISTATO> | <BIANCA> )
	    * f2 -> <SU>
	    */
	   public Object visit(Magia n) {
		  Object _ret=null;
	      n.f0.accept(this);
	      n.f1.accept(this);
	      n.f2.accept(this);
	      return _ret;
	   }

	   /**
	    * f0 -> "usa"
	    * f1 -> <NOMEOGGETTO>
	    * f2 -> <SU>
	    */
	   public Object visit(Oggetto n) {
		  Object _ret=null;
	      n.f0.accept(this);
	      n.f1.accept(this);
	      n.f2.accept(this);
	      return _ret;
	   }

	   /**
	    * f0 -> "invoca"
	    * f1 -> <GF>
	    * f2 -> <SU>
	    */
	   public Object visit(Invocazione n) {
		  Object _ret=null;
	      n.f0.accept(this);
	      n.f1.accept(this);
	      n.f2.accept(this);
	      return _ret;
	   }

	   /**
	    * f0 -> "esegue"
	    * f1 -> <NOMETECNICA>
	    * f2 -> <SU>
	    */
	   public Object visit(TecnicaSpeciale n) {
		  Object _ret=null;
	      n.f0.accept(this);
	      n.f1.accept(this);
	      n.f2.accept(this);
	      return _ret;
	   }

	}
