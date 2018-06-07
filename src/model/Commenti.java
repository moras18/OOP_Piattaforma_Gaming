package model;

public class Commenti {
	private int id;
	private String titolo;
	private String testo;
	private String nome;
	private String cognome;
	private int valutazione;
	private int idgioco;
	private int idutente;
	private int approvato;
	private String nomeg;
	
	public Commenti(int id, String titolo, String testo, String nomeg, int valutazione, int idgioco, int idutente, int approvato){
		this.id=id;
		this.titolo=titolo;
		this.testo=testo;
		this.valutazione=valutazione;
		this.idgioco=idgioco;
		this.idutente=idutente;
		this.approvato=approvato;
		this.nomeg=nomeg;
	}
	
	public Commenti(String nome, String cognome, String titolo, String testo, int valutazione, int approvato){
		
		this.titolo=titolo;
		this.testo=testo;
		this.valutazione=valutazione;
		this.nome=nome;
		this.cognome=cognome;
		this.approvato=approvato;
	}
	
	public Commenti(int id, String nome, String cognome, String nomeg, String titolo, String testo){
		
		this.titolo=titolo;
		this.testo=testo;
		this.id=id;
		this.nome=nome;
		this.cognome=cognome;
		this.nomeg=nomeg;
		System.out.println(nomeg + "nome gioco metodo costruttore");
		
	}
	
	public void setId (int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}
	
	public void setTitolo (String titolo) {
		this.titolo=titolo;
	}

	public String getTitolo() {
		return titolo;
	}
	
	public void setNome (String nome) {
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void setCognome (String cognome) {
		this.cognome=cognome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public void setNomeG (String nomeg) {
		this.nomeg=nomeg;
	}

	public String getNomeG() {
		return nomeg;
	}
	
	public void setTesto (String testo) {
		this.testo=testo;
	}

	public String getTesto() {
		return testo;
	}
	
	public void setValutazione (int valutazione) {
		this.valutazione=valutazione;
	}

	public int getValutazione() {
		return valutazione;
	}
	
	public void setIdGioco (int idgioco) {
		this.idgioco=idgioco;
	}

	public int getIdGioco() {
		return idgioco;
	}
	
	public void setIdUtente (int idutente) {
		this.idutente=idutente;
	}

	public int getIdUtente() {
		return idutente;
	}
	
	public void setApprovato (int approvato) {
		this.approvato=approvato;
	}

	public int getApprovato() {
		return approvato;
	}
	
}
