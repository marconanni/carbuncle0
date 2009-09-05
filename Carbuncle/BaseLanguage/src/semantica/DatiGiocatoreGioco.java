package semantica;

public class DatiGiocatoreGioco {
	private String squadra;
    private int ordineBattuta;
    private String nome;
    private String posizione;
    private int numeroValide;
    private int numeroTurniBattuta;
    private int numeroK;
    private int baseAttuale;
    private int numPuntiSegnati;
    private int numeroStrike;
    private int numeroBall;
    private boolean pallaBattuta;
    private int apparizioniAlPiatto=0;//<-necessario per calcolare la media battuta
	
    public DatiGiocatoreGioco(String squadra, int ordineBattuta, String nome, String posizione) {
		
		this.squadra = squadra;
		this.ordineBattuta = ordineBattuta;
		this.nome = nome;
		this.posizione=posizione;
		numeroTurniBattuta=0;
		numeroValide=0;
		numeroK=0;
		baseAttuale=0;
		numPuntiSegnati=0;
		numeroStrike=0;
		numeroBall=0;
		pallaBattuta=false;
		apparizioniAlPiatto=0;
	}
    public String getSquadra(){
    	return squadra;
    }
    public boolean getPallaBattuta(){
    	return pallaBattuta;
    }
    public void setPallaBattuta(boolean b){
    	pallaBattuta=b;
    }
    public void setPunti(int n){
    	numPuntiSegnati=n;
    }
    public void setK(int n){
    	numeroK=n;
    }
    public void setName(String nome){
    	this.nome=nome;
    }
    public void setValide(int n){
    	numeroValide=n;
    }
    public int getNumeroTurniBattuta(){
    	return numeroTurniBattuta;
    }
    public void incNumeroTurniBattuta(){
    	numeroTurniBattuta++;
    }
    public int getNumeroValide(){
    	return numeroValide;
    }
    public void incNumeroValide(){
    	numeroValide++;
    }
    public int getNumeroK(){
    	return numeroK;
    }
    public void incNumeroK(){
    	numeroK++;
    }
    public int getBaseAttuale(){
    	return baseAttuale;
    }
    public void setBaseAttuale(int base){
    	baseAttuale=base;
    }
    public void incPuntiSegnati(){
    	numPuntiSegnati++;
    }
    public int getPuntiSegnati(){
    	return numPuntiSegnati;
    }
    public String getName(){
    	return nome;
    }
    public int getOrdine(){
    	return ordineBattuta;
    }
    public void incNumeroStrike(){
    	numeroStrike++;
    }
    public void incNumeroBall(){
    	numeroBall++;
    }
	public int getNumeroStrike() {
		return numeroStrike;
	}
	public int getNumeroBall() {
		return numeroBall;
	}
	public void setStrike(int n){
		numeroStrike=n;
	}
	public void setBall(int n){
		numeroBall=n;
	}
	public int getOrdineBattuta(){
    	return ordineBattuta;
    }
	public void setOrdine(int n){
		ordineBattuta=n;
	}
	public String getPosizione(){
		return posizione;
	}
	public String getNome(){
		return nome;
	}
	public int getApparizioniAlPiatto(){
		return apparizioniAlPiatto;
	}
	public void incApparizioniAlPiatto(){
		apparizioniAlPiatto++;
	}
	public void decApparizioniAlPiatto(int n){
		apparizioniAlPiatto=apparizioniAlPiatto-n;
	}
}
