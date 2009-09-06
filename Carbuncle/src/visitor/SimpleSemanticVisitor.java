package visitor;

import java.util.Enumeration;
import java.util.Hashtable;

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

import dati.*;
import exceptions.*;


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
	private Ambiente ambiente;

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

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
		  
	      String action =(String) n.f0.accept(this);
	      if (action.equals("attacca")){
	    	  calcolaAttacco(); // metodo che applica i danni dell'attacco;
	      }
	      
	      return null;
	   }

	   

	/**
	    * f0 -> "lancia"
	    * f1 -> ( <ELEMENTALE> | <NONELEMENTALE> | <DISTATO> | <BIANCA> )
	    * f2 -> <SU>
	    */
	   public Object visit(Magia n) {
		  
	      n.f0.accept(this);
	      String nomemagia = (String)n.f1.accept(this); // nota: sono sicuro che il nome della magia sia un nome valido perchè ha già svolto il controllo il parser
	      n.f2.accept(this);
	      calcolaMagia(nomemagia);
	      
	      return null;
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
	   
	   private void calcolaAttacco() {  // nota: si può attaccare un bersaglio solo.
			
		   
			
			if((bersaglio.compareTo("alleati")==0)||(bersaglio.compareTo("nemici")==0))
				System.out.println("è possibile attaccare fisicamente un bersaglio singolo");
			else
			{
				Personaggio target = null;
				try {
					 target = ambiente.getPersonaggio(this.bersaglio);
				} catch (PersonaggioNonTrovatoException e) {
					// TODO Auto-generated catch block
					System.out.println("il bersaglio indicato: " + bersaglio+" non è un personaggio");
				}
				
				target.modificaHP(-200);
				System.out.println("L'attacco di "+ personaggio+ " ha causato 200Hp di danno a " + bersaglio);
				
			}
			
	   
	   }
		
	   private void calcolaMagia(String nomemagia) { // non è possible lanciare magie su tutta una squadra
		   if((bersaglio.compareTo("alleati")==0)||(bersaglio.compareTo("nemici")==0))
				System.out.println("è possibile lanciare magie solo su un bersaglio singolo");
		   
		   else{
			   Personaggio target = null;
			   try {
				 target = ambiente.getPersonaggio(bersaglio);
			} catch (PersonaggioNonTrovatoException e) {
				System.out.println("il bersaglio indicato: " + bersaglio+" non è un personaggio");
			}
			Hashtable<String,Stati> magiaStati = new Hashtable<String,Stati>();
			magiaStati.put("novox", Stati.mutismo);
			magiaStati.put("blind", Stati.cecità);
			magiaStati.put("bio", Stati.veleno);
			magiaStati.put("medusa", Stati.pietra);
			magiaStati.put("slow", Stati.lentezza);
			magiaStati.put("haste", Stati.haste);
			magiaStati.put("protect", Stati.protect);
			magiaStati.put("shell", Stati.shell);
			
			if(magiaStati.containsKey(nomemagia)) // se è una magia si stato applico il rispettivo stato
				target.aggiungiStato(magiaStati.get(nomemagia));
			else // magia bianca, ogni magia ha il suo effetto
				if(nomemagia.equals("energia"))
					target.modificaHP(400);
				else
					if(nomemagia.equals("esna")){// rimuove gli stati negativi
						target.rimuoviStato(Stati.cecità);
						target.rimuoviStato(Stati.lentezza);
						target.rimuoviStato(Stati.mutismo);
						target.rimuoviStato(Stati.pietra);
						target.rimuoviStato(Stati.veleno);
					}
					else 
						if(nomemagia.equals("dispel")){
							target.rimuoviStato(Stati.haste);
							target.rimuoviStato(Stati.protect);
							target.rimuoviStato(Stati.shell);
						}
						else
							if(nomemagia.equals("reiz")){// se il personaggio è morto lo riporta in vita con il 20% dellHp max
								if(target.getHP()<=0)
									target.setHP(target.getHPMax()*20/100);
								else
									System.out.println("Impossibile usare reiz su un bersaglio con HP maggiore di zero");
							}
							else 
								if(nomemagia.equals("areiz")){// se il personaggio è morto lo riporta in vita con l'Hp al massimo
									if(target.getHP()<=0)
										target.setHP(target.getHPMax());
									else
										System.out.println("Impossibile usare areiz su un bersaglio con HP maggiore di zero");
								}
								else{
									// controllo che nomemagia sia tra le  magie rimaste (come dovrebe essere, visto che ci ah pensato il parser a controllare la validità della frase)
									
								}
				
			
			
			
			   
		   }// fine else
		   
			
		}// fine calcolaMagia();
			
		

	}
