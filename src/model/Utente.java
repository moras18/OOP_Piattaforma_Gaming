package model;

public class Utente {
private String nome;
private String cognome;
private String email;
private String password;
private int gruppo;
private int esperienza;
private int livello;
private int id;
private int progresso;


public Utente (String nome, String cognome, String email, String password, int esperienza) {
	this.nome=nome;
	this.cognome=cognome;
	this.email=email;
	this.password=password;
	this.esperienza=esperienza;
}

public Utente (String nome, String cognome, String email, int gruppo) {
	this.nome=nome;
	this.cognome=cognome;
	this.email=email;
	this.gruppo=gruppo;
}

public Utente (String nome, String cognome, int esperienza, int livello, int progresso, int gruppo) {
	this.nome=nome;
	this.cognome=cognome;
	this.esperienza=esperienza;
	this.livello=livello;
	this.progresso=progresso;
	this.gruppo=gruppo;

	
}

public Utente (int id, String nome, String cognome, int gruppo) {
	this.id=id;
	this.nome=nome;
	this.cognome=cognome;
	this.gruppo=gruppo;
	

	
}


public Utente() {
	// TODO Auto-generated constructor stub
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

public void setEmail (String email) {
	this.email=email;
}

public String getEmail() {
	return email;
}

public void setPassword (String password) {
	this.password=password;
}

public String getPassword() {
	return password;
}

public void setEspereinza (int espereinza) {
	this.esperienza=espereinza;
}

public int getEsperienza() {
	return esperienza;
}

public void setGruppo (int gruppo) {
	this.gruppo=gruppo;
}

public int getGruppo() {
	return gruppo;
}

public void setId (int id) {
	this.id=id;
}

public int getId() {
	return id;
}

public void setLivello (int livello) {
	this.livello=livello;
}

public int getLivello() {
	return livello;
}

public void setProgresso (int progresso) {
	this.progresso=progresso;
}

public int getProgresso() {
	return progresso;
}

}
