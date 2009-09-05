package semantica;

import grammar.ParseException;
import java.util.Vector;


public class ControlloDati {
	private Vector<DatiGiocatoreGioco> squadraCasa;
	private Vector<DatiGiocatoreGioco> squadraOspiti;
	private String nomeCasa;
	private String nomeOspiti;
	
	
	public ControlloDati(){
		squadraCasa=new Vector<DatiGiocatoreGioco>();
		squadraOspiti=new Vector<DatiGiocatoreGioco>();
		nomeCasa=null;
		nomeOspiti=null;
		
	 }

	public void reset(){
		squadraCasa.removeAllElements();
		squadraOspiti.removeAllElements();
		nomeCasa=null;
		nomeOspiti=null;
		
	}
	
	public void setNomeSquadra(String nome,boolean casa){
		if(casa)nomeCasa=nome;
		else nomeOspiti=nome;
	}
	
	public boolean addSquadra(DatiGiocatoreGioco g, boolean casa){
		boolean result=controlloNumeriNomePosizione(g, casa);
		if(result){
			if(casa){squadraCasa.add(g);System.out.println("Inserito nella squadra di casa il giocatore: "+g.getNome());}
			else {squadraOspiti.add(g);System.out.println("Inserito nella squadra ospite il giocatore: "+g.getNome());}
		}
		return result;
	}
	
	private boolean controlloNumeriNomePosizione(DatiGiocatoreGioco g, boolean casa)
    {
        if (casa) return controllo(g,squadraCasa);
        else return controllo(g,squadraOspiti);
    }
	private boolean controllo(DatiGiocatoreGioco g, Vector<DatiGiocatoreGioco> vector){//ritorna false se trova un giocatore con stesso nome/numero/posizione nel vettore
		DatiGiocatoreGioco temp;
		for (int i=0;i<vector.size();i++){
			temp=(DatiGiocatoreGioco)vector.get(i);
			if(temp.getNome().equals(g.getNome())||temp.getPosizione().equals(g.getPosizione())||temp.getOrdineBattuta()==g.getOrdineBattuta()) return false;
		}
		return true;
	}
	public String getNome(boolean casa, int indice){
		String result="";
		if(casa){
			for(int i=0;i<squadraCasa.size();i++){
				if(squadraCasa.get(i).getOrdineBattuta()==indice)result=squadraCasa.get(i).getNome();
			}
		}
		else{
			for(int i=0;i<squadraOspiti.size();i++){
				if(squadraOspiti.get(i).getOrdineBattuta()==indice)result=squadraOspiti.get(i).getNome();
			}
		}
		return result;
	}
	public String getPosizione(boolean casa,int indice){
		String result="";
		if(casa){
			for(int i=0;i<squadraCasa.size();i++){
				if(squadraCasa.get(i).getOrdineBattuta()==indice)result=squadraCasa.get(i).getPosizione();
			}
		}
		else{
			for(int i=0;i<squadraOspiti.size();i++){
				if(squadraOspiti.get(i).getOrdineBattuta()==indice)result=squadraOspiti.get(i).getPosizione();
			}
		}
		return result;
	}
	/*
	public boolean controlloAvanzamento(DatiGiocatoreGioco corridore,Vector<DatiGiocatoreGioco> vectorUominiSulleBasi){
		boolean result=true;
		int base=corridore.getBaseAttuale();
		int ordine=corridore.getOrdine();
		for(int i=0;i<vectorUominiSulleBasi.size();i++){
			if(base>=vectorUominiSulleBasi.get(i).getBaseAttuale()&&base!=4&&ordine!=vectorUominiSulleBasi.elementAt(i).getOrdine()){
				result=false;
				System.out.println("CORRIDORE: "+corridore.getName()+", BASE RAGGIUNTA: "+corridore.getBaseAttuale()+" INCONPATIBILITà CON: "+vectorUominiSulleBasi.elementAt(i).getName()+", BASE RAGGIUNTA: "+vectorUominiSulleBasi.elementAt(i).getBaseAttuale());}
		}
		
		return result;
	}
	*/
	public Vector<DatiGiocatoreGioco> aggiungiGiocatoreSuBase(DatiGiocatoreGioco giocatore, Vector<DatiGiocatoreGioco> vectorGiocatoriSulleBasi){
		boolean flag=true;
		for(int i=0;i<vectorGiocatoriSulleBasi.size();i++){
			if(vectorGiocatoriSulleBasi.elementAt(i).getName().equals(giocatore.getName())){
				flag=false;
				vectorGiocatoriSulleBasi.set(i, giocatore);//sostituisco l'oggetto, in questo modo lo aggiorno
			}
		}
		if(flag){//questo giocatore non c'era, lo devo mettere
			vectorGiocatoriSulleBasi.add(giocatore);
		}
				
		return vectorGiocatoriSulleBasi;
	}
	/*
	public void eliminaGiocatoreDaBase(DatiGiocatoreGioco giocatore, Vector<DatiGiocatoreGioco> vectorGiocatoriSulleBasi){
		for(int i=0;i<vectorGiocatoriSulleBasi.size();i++){
			if(vectorGiocatoriSulleBasi.elementAt(i).getName().equals(giocatore.getName())){
				giocatore=vectorGiocatoriSulleBasi.remove(i);
				System.out.println("Rimosso dalle basi il giocatore "+giocatore.getName());
			}
		}
	}
	*/
	public boolean controlloNumeroGiocBase(Vector<DatiGiocatoreGioco> v){//controllo sul numero di giocatori in base
		boolean result;
		//if(v.size()<4)result=true;
		//else result=false;
		int j=0;
		for(int i=0; i<v.size();i++){
			if(v.get(i).getBaseAttuale()!=0&&v.get(i).getBaseAttuale()!=4)j++;
		}
		if(j<4)result=true;
		else result=false;
		return result;
	}
	public boolean controlloConsistenzaGiocBase(Vector<DatiGiocatoreGioco> v){//controllo che più giocatori non condividano la stessa base
		boolean result=true;
		for(int i=0;i<v.size();i++){
			int base=v.elementAt(i).getBaseAttuale();
			for(int j=i+1;j<v.size();j++){
				if(v.elementAt(j).getBaseAttuale()==base&&base!=0&&base!=4)result=false;
			}
		}
		if(result==false){
			System.out.println("GIOCATORI SULLE BASI");
			for(int i=0;i<v.size();i++){
				System.out.println(v.get(i).getName()+" base "+v.get(i).getBaseAttuale());
			}
		}
		return result;		
	}
	public void azzeraStrikeBall(Vector<DatiGiocatoreGioco> v){
		for(int i=0;i<v.size();i++){
			v.get(i).setBall(0);
			v.get(i).setStrike(0);
		}
	}
	
	
}
