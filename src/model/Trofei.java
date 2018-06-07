package model;

public class Trofei {
private String nome;
private int expmax;
private String pathimm;

public Trofei (String nome, int expmax, String pathimm) {
	this.nome=nome;
	this.expmax=expmax;
	this.pathimm=pathimm;
}

public void setNome (String nome) {
	this.nome=nome;
}

public String getNome() {
	return nome;
}

public void setExpMax (int expmax) {
	this.expmax=expmax;
}

public int getExpMax() {
	return expmax;
}

public void setPathImm (String pathimm) {
	this.pathimm=pathimm;
}

public String getPathImm() {
	return pathimm;
}
}
