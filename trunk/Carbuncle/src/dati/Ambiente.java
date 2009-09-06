package dati;

import java.util.*;

import exceptions.PersonaggioNonTrovatoException;

public class Ambiente {
	
	private Vector<Personaggio> teamGiocatore;
	private Vector<Personaggio> teamAI;
	public Vector<Personaggio> getTeamGiocatore() {
		return teamGiocatore;
	}
	public Vector<Personaggio> getTeamAI() {
		return teamAI;
	}
	public Ambiente(Vector<Personaggio> teamGiocatore,
			Vector<Personaggio> teamAI) {
		super();
		this.teamGiocatore = teamGiocatore;
		this.teamAI = teamAI;
	}
	
	public Personaggio getPersonaggio (String nome) throws  PersonaggioNonTrovatoException{
		int k;
		for (k=0; k<teamGiocatore.size(); k++){
			if (teamGiocatore.get(k).getNome().compareTo(nome)==0)
				return teamGiocatore.get(k);
		}
		for (k=0; k<teamAI.size(); k++){
			if (teamAI.get(k).getNome().compareTo(nome)==0)
				return teamAI.get(k);
		}
		throw new PersonaggioNonTrovatoException ("Impossibile trovare il personaggio "+ nome);
		
		
	}
	
	public List<Personaggio> getAlleati(String nome)throws  PersonaggioNonTrovatoException{
		if(teamAI.contains(this.getPersonaggio(nome))) // nota: se il nome del personaggio non è presente in nessuno dei due team viene rilanciata l'eccezione creata dal metodo getPersonaggio. Se passo questo controllo, sono quindi sicuro che il personaggio ci sia in uno dei due team
			return getTeamAI();
		else
			return getTeamGiocatore();
		
	}
	
	public List<Personaggio> getNemici(String nome)throws  PersonaggioNonTrovatoException{
		if(teamAI.contains(this.getPersonaggio(nome))) // nota: se il nome del personaggio non è presente in nessuno dei due team viene rilanciata l'eccezione creata dal metodo getPersonaggio. Se passo questo controllo, sono quindi sicuro che il personaggio ci sia in uno dei due team
			return getTeamGiocatore();
		else
			return getTeamAI();
		
	}

}
