package it.betacom.dao;

import java.util.List;

import it.betacom.model.Genere;

public interface GenereDao {
	
	List<Genere> getAll();
	Genere getGenereById(String codiceG);
	void insertGenere(Genere genere);
	void updateGenere(Genere genere);
	void deleteGenere(Genere genere);
	

}
