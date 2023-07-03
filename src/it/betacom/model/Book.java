package it.betacom.model;

public class Book {
	
	private String isbn;
	private String titolo;
	private String codiceA;
	private String numPag;
	private String anno;
	private String CodiceG_FK;
	private String CodiceE;
	
	public Book(String isbn, String titolo,String CodiceA,String numPag,String anno,String CodiceG_FK,String CodiceE) {
		super();
		this.setIsbn(isbn);
		this.setTitolo(titolo);
		this.setCodiceA(CodiceA);
		this.setNumPag(numPag);
		this.setAnno(anno);
		this.setCodiceG_FK(CodiceG_FK);
		this.setCodiceE(CodiceE);
	}

	public Book() {
		super();
	}
	
	public String getCodiceA() {
		return codiceA;
	}

	public void setCodiceA(String codiceA) {
		this.codiceA = codiceA;
	}

	public String getNumPag() {
		return numPag;
	}

	public void setNumPag(String numPag) {
		this.numPag = numPag;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getCodiceG_FK() {
		return CodiceG_FK;
	}

	public void setCodiceG_FK(String codiceG_FK) {
		CodiceG_FK = codiceG_FK;
	}

	public String getCodiceE() {
		return CodiceE;
	}

	public void setCodiceE(String codiceE) {
		CodiceE = codiceE;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Override
	public String toString() {
		
		return String.format("%-8s %-40s %-30s %-10s %-10s %-10s %-10s"
				, this.isbn
				, this.titolo
				, this.codiceA
				, this.numPag
				, this.anno
				, this.CodiceE
				, this.CodiceG_FK);
	}
	
	
	
	

}
