package it.betacom.model;

public class Editore {
	
	private String codiceE;
	private String nome;
	
	public Editore(String codiceE, String nome) {
		this.setCodiceE(codiceE);
		this.setNome(nome);
	}
	
	public String getCodiceE() {
		return codiceE;
	}
	public void setCodiceE(String codiceE) {
		this.codiceE = codiceE;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-30s", this.codiceE, this.nome);
	}

}
