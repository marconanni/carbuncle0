package launcher;

import java.util.*;
import java.io.*;
import parser.*;
import syntaxtree.*;
import visitor.*;
import dati.*;
import exceptions.PersonaggioNonTrovatoException;


public class Main {
	 
	
	public static void main (String[] args){
	Personaggio pers1= new Personaggio ("Marco",1000,1000);
	pers1.aggiungiStato(Stati.haste);
	Personaggio pers2= new Personaggio ("Nerd", 1000,1000);
	Vector<Personaggio> buoni = new Vector<Personaggio> ();
	buoni.add(pers1);
	Vector<Personaggio> cattivi = new Vector<Personaggio> ();
	cattivi.add(pers2);
	Ambiente ambiente = new Ambiente(buoni, cattivi);
	
		
	String pathname="./battle.txt";
	Vector<String> righe = getRighe(pathname);
	if(righe.size()==0){
		System.out.println("Qualcosa non ha funzionato nella lettura del file: il vettore è vuoto");
		}
	
	for(int k=0; k<righe.size();k++){
		String riga = righe.get(k);
		Reader stream= new StringReader(riga);
		ParserCarbuncle parser = new ParserCarbuncle(stream);
		try {
			Node root = parser.S();
			SimpleSemanticVisitor visitor = new SimpleSemanticVisitor ();
			visitor.setAmbiente(ambiente);
			root.accept( visitor);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("Sono il main, la situazione dopo l'azione di Marco è: \n" + ambiente.getPersonaggio("Marco").toString() );
		} catch (PersonaggioNonTrovatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	}

	// metodo che prende il file di testo e ne separa le righe 
	private static Vector<String> getRighe(String pathname) {
		Vector<String> righe = new Vector<String>();;
		try {
		
			BufferedReader reader = new BufferedReader ( new FileReader(pathname));
			String linea=reader.readLine();

			while(linea!=null) {
			       System.out.println("letta riga : " +linea);
			       righe.add(linea);
			       linea=reader.readLine();
			       
			}
			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return righe;
	}
	
	

}
