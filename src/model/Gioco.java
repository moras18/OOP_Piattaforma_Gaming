package model;

public class Gioco {
private int id;
private String nome;
private String descrizione;
private String pathgioco;
private String logo;

public Gioco (int id, String nome, String descrizione, String pathgioco, String logo) {
	this.id=id;
	this.nome=nome;
	this.descrizione=descrizione;
	this.pathgioco=pathgioco;
	this.logo=logo;
}

public Gioco (int id, String nome, String logo, String descrizione) {
	this.id=id;
	this.nome=nome;
	this.descrizione=descrizione;
	
	this.logo=logo;
}

public Gioco (String nome, String descrizione, String logo) {
	
	this.nome=nome;
	this.descrizione=descrizione;
	
	this.logo=logo;
}

public Gioco (int id, String nome, String logo) {
	this.id=id;
	this.nome=nome;
	this.logo=logo;
}

public void setNome (String nome) {
	this.nome=nome;
}

public String getNome() {
	return nome;
}

public int getId() {
	return id;
}

public void setDescrizione (String descrizione) {
	this.descrizione=descrizione;
}

public String getDescrizione() {
	return descrizione;
}

public void setPathGioco (String pathgioco) {
	this.pathgioco=pathgioco;
}

public String getPathGioco() {
	return pathgioco;
}

public void setLogo (String logo) {
	this.logo=logo;
}

public String getLogo() {
	return logo;
}
}
