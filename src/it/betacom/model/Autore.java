package it.betacom.model;

public class Autore {

	private String id;
	private String nome;
	private String cognome;
	private String annoNascita;
	private String annoMorte;
	private String sesso;
	private String nazione;
	
	public Autore(String id,String nome,String cognome,String annoNascita,String annoMorte,String sesso,String nazione) {
		this.setId(id);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setAnnoNascita(annoNascita);
		this.setAnnoMorte(annoMorte);
		this.setSesso(sesso);
		this.setNazione(nazione);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(String annoNascita) {
		this.annoNascita = annoNascita;
	}

	public String getAnnoMorte() {
		return annoMorte;
	}

	public void setAnnoMorte(String annoMorte) {
		this.annoMorte = annoMorte;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	@Override 
	public String toString() {
		
		if(this.annoMorte.isEmpty() || this.annoMorte.equals("0")) {
			return String.format("%-8s %-25s %-25s %-10s %-10s %-15s",
					this.id,
					this.nome,
					this.cognome,
					this.annoNascita,
					"--",
					this.sesso,
					this.nazione);
		}
		
		return String.format("%-8s %-25s %-25s %-10s %-10s %-15s",
				this.id,
				this.nome,
				this.cognome,
				this.annoNascita,
				this.annoMorte,
				this.sesso,
				this.nazione);
		
	}
	
	

}
