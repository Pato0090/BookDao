package it.betacom.model;

public class Genere {
	
	private String descrizione;
	private String codiceG;
	
	public Genere(String codiceG, String descrizione) {
		this.setCodiceG(codiceG);
		this.setDescrizione(descrizione);
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCodiceG() {
		return codiceG;
	}
	public void setCodiceG(String codiceG) {
		this.codiceG = codiceG;
	}
	
	@Override
	public String toString() {
		return("Descrizione: "
				+ this.descrizione
				+ "\tCodice genere: "
				+ this.codiceG
				);
	}
}
