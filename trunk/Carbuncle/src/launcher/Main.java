package launcher;

import java.util.*;
import java.io.*;
import parser.*;
import syntaxtree.*;
import visitor.*;
public class Main {
	 
	
	public static void main (String[] args){
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
			root.accept(new PrintDepthFirstVisitor());
		} catch (ParseException e) {
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
