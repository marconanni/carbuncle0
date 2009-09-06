package visitor;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

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
// il collirio elimina lo stato cecit�
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
	      if (action != null && action.equals("attacca")){
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
	      String nomemagia = (String)n.f1.accept(this); // nota: sono sicuro che il nome della magia sia un nome valido perch� ha gi� svolto il controllo il parser
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
		
	      n.f0.accept(this);
	      String nomeoggetto=(String)n.f1.accept(this);
	      n.f2.accept(this);
	      calcolaOggetto(nomeoggetto);
	      return null;
	   }

	   

	/**
	    * f0 -> "invoca"
	    * f1 -> <GF>
	    * f2 -> <SU>
	    */
	   public Object visit(Invocazione n) { 
		  
	      n.f0.accept(this);
	      String nomeGF=(String)n.f1.accept(this);
	      n.f2.accept(this);
	      calcolaInvocazione(nomeGF);
	      return null;
	   }

	   

	/**
	    * f0 -> "esegue"
	    * f1 -> <NOMETECNICA>
	    * f2 -> <SU>
	    */
	   public Object visit(TecnicaSpeciale n) {
		  
	      n.f0.accept(this);
	      String nometecnica = (String)n.f1.accept(this);
	      n.f2.accept(this);
	      calcolaTecnicaSpeciale(nometecnica);
	      return null;
	   }
	   
	  

	private void calcolaAttacco() {  // nota: si pu� attaccare un bersaglio solo.
			
		   
			
			if((bersaglio.compareTo("alleati")==0)||(bersaglio.compareTo("nemici")==0))
				System.out.println("� possibile attaccare fisicamente un bersaglio singolo");
			else
			{
				Personaggio target = null;
				try {
					 target = ambiente.getPersonaggio(this.bersaglio);
				} catch (PersonaggioNonTrovatoException e) {
					// TODO Auto-generated catch block
					System.out.println("il bersaglio indicato: " + bersaglio+" non � un personaggio");
				}
				
				target.modificaHP(-200);
				System.out.println("L'attacco di "+ personaggio+ " ha causato 200Hp di danno a " + bersaglio);
				
			}
			
	   
	   }
		
	   private void calcolaMagia(String nomemagia) { // non � possible lanciare magie su tutta una squadra
		   if((bersaglio.compareTo("alleati")==0)||(bersaglio.compareTo("nemici")==0))
				System.out.println("� possibile lanciare magie solo su un bersaglio singolo");
		   
		   else{
			   Personaggio target = null;
			   try {
				 target = ambiente.getPersonaggio(bersaglio);
			} catch (PersonaggioNonTrovatoException e) {
				System.out.println("il bersaglio indicato: " + bersaglio+" non � un personaggio");
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
			
			if(magiaStati.containsKey(nomemagia)) // se � una magia si stato applico il rispettivo stato
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
							if(nomemagia.equals("reiz")){// se il personaggio � morto lo riporta in vita con il 20% dellHp max
								if(target.getHP()<=0)
									target.setHP(target.getHPMax()*20/100);
								else
									System.out.println(" usare reiz su un bersaglio con HP maggiore di zero non causa alcun effettto");
							}
							else 
								if(nomemagia.equals("areiz")){// se il personaggio � morto lo riporta in vita con l'Hp al massimo
									if(target.getHP()<=0)
										target.setHP(target.getHPMax());
									else
										System.out.println("usare areiz su un bersaglio con HP maggiore di zero non causa alcun effetto");
								}
								else{
									// controllo che nomemagia � tra le  magie rimaste ( visto che ci ha pensato il parser a controllare la validit� della frase)
									// tutte le altre magie comportano un danno di 250 HP
									target.modificaHP(-250);
								}
			   
		   }// fine else principale
		   
			
		}// fine calcolaMagia();

	   
	   
	   private void calcolaOggetto(String nomeoggetto) { // anche gli oggetti si possono usare su un bersaglio singolo
		   
		   if((bersaglio.compareTo("alleati")==0)||(bersaglio.compareTo("nemici")==0))
				System.out.println("� possibile usare oggetti solo su un bersaglio singolo");
		   
		   else{
			   Personaggio target = null;
			   try {
				 target = ambiente.getPersonaggio(bersaglio);
			} catch (PersonaggioNonTrovatoException e) {
				System.out.println("il bersaglio indicato: " + bersaglio+" non � un personaggio");
			}
		   
		   
			// tabella degli oggetti che curano gli stati alterati
		   Hashtable<String,Stati> oggettiStatiRimossi = new Hashtable<String,Stati>();
		   oggettiStatiRimossi.put("antidoto", Stati.veleno);
		   oggettiStatiRimossi.put("erbaDellEco", Stati.mutismo);
		   oggettiStatiRimossi.put("Collirio", Stati.cecità);
		   oggettiStatiRimossi.put("AgoDorato", Stati.pietra);
		   if(oggettiStatiRimossi.containsKey(nomeoggetto)){
			  target.rimuoviStato(oggettiStatiRimossi.get(nomeoggetto));
		   }
		   else if (nomeoggetto.equals("pozione"))
			   target.modificaHP(300);
		   else { // pozione: anche se si usano pozioni su bersagli con Hp positivo non si ha efferro ( sono come la magia reiz)
			   if(target.getHP()<=0)
					target.setHP(target.getHPMax()*20/100);
				else
					System.out.println(" usare una pozione su un bersaglio con HP maggiore di zero non causa alcun effettto");

		   }
		   
		   } // fine else principale (attacco su bersaglio singolo
			
		} // fine metodo calcolaOggetto
	   
	   private void calcolaInvocazione(String nomeGF) { // � possibile invocare un GF anche su tutto un team; il nome del GF non viene sfruttato perch� in questa semplice implementazione producono tutti lo stesso danno anche se autolesionistico si possono usare i GF anche contro il proprio team
			List<Personaggio> targets = null;
			try{
				if (bersaglio.equals("alleati"))
					targets=ambiente.getAlleati(bersaglio);
				else if (bersaglio.equals("nemici"))
					targets=ambiente.getNemici(bersaglio);
				else{
					targets = new Vector <Personaggio> ();
					targets.add(ambiente.getPersonaggio(bersaglio));
				}
				for(int k =0; k<targets.size(); k++){
					targets.get(k).modificaHP(-300);
				}
			}
			
			catch (PersonaggioNonTrovatoException e) {
				System.out.println("il bersaglio indicato: " + bersaglio+" non � un personaggio");
			}
		}
		
	   private void calcolaTecnicaSpeciale(String nometecnica) {  // qui, come per le invocazioni si possono attaccare anche tutte le squadre ( sia quella nemica che quella alleata, tuttavia le tecniche speciali sono eseguibili solo da personaggi con Hp inferiori al 20%
		   Personaggio character = null;
		   try {
				 character = ambiente.getPersonaggio(personaggio);
				
			} catch (PersonaggioNonTrovatoException e) {
				System.out.println("il pesonaggio indicato: " + personaggio+" non � un personaggio valido");
			}
			
			if(character.getHP()<character.getHPMax()*20/100 && character.getHP()>0){
				
				List<Personaggio> targets = null;
				try{
					if (bersaglio.equals("alleati"))
						targets=ambiente.getAlleati(bersaglio);
					else if (bersaglio.equals("nemici"))
						targets=ambiente.getNemici(bersaglio);
					else{
						targets = new Vector <Personaggio> ();
						targets.add(ambiente.getPersonaggio(bersaglio));
					}
					for(int k =0; k<targets.size(); k++){
						targets.get(k).modificaHP(-500);
					}
				}
				
				catch (PersonaggioNonTrovatoException e) {
					System.out.println("il bersaglio indicato: " + bersaglio+" non � un personaggio");
				}
			}
			else 
				System.out.println("un personaggio pu� eseguire tecniche speciali solo se il suo Hp � inferiore al 20% del suo Hp massimo");

			
		}

	}
