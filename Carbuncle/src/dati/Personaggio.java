package dati;
import java.util.*;




public class Personaggio {
	private String Nome;
	private int HPMax;
	private int HP;
	private List <Stati> status = new Vector<Stati>();
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getHPMax() {
		return HPMax;
	}
	public void setHPMax(int max) {
		HPMax = max;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hp) {
		HP = hp;
	}
	
	public List<Stati> getStatuts(){
		return status;
	}
	
	public Personaggio(String nome, int max, int hp) {
		super();
		Nome = nome;
		HPMax = max;
		HP = hp;
	}
	
	public boolean checkStato(Stati s){
		
		return status.contains(s);
	}
	public void aggiungiStato(Stati s){
		
		if(!status.contains(s))
			status.add(s);
		
	}
	
	public void rimuoviStato(Stati s){
		
		if(status.contains(s))
			status.remove(s);
		
	}
	
	public void modificaHP(int variazione){ // da aggiungere controllo affinch� non si vada oltre il valoremax e min del tipo int, ma nell'esempio non accadr� mai.
		if (getHP()<0)			
		setHP(getHP()+variazione);
	}
	
	
	
	

}
