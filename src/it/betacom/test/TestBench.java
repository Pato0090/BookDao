package it.betacom.test;

import it.betacom.impl.AutoreDaoImpl;
import it.betacom.impl.BookDaoImpl;
import it.betacom.impl.EditoreDaoImpl;
import it.betacom.impl.GenereDaoImpl;
import it.betacom.model.Autore;
import it.betacom.model.Book;
import it.betacom.model.Editore;
import it.betacom.model.Genere;

public class TestBench {

	AutoreDaoImpl istanzaAutori;
	BookDaoImpl istanzaLibri;
	EditoreDaoImpl istanzaEditori;
	GenereDaoImpl istanzaGeneri;
	
	
	public TestBench() {
		istanzaAutori = new AutoreDaoImpl();
		istanzaLibri = new BookDaoImpl();
		istanzaEditori = new EditoreDaoImpl();
		istanzaGeneri = new GenereDaoImpl();
	}
	
	public void stampaDatiTabelle() {
		//System.out.println(istanzaAutori.getAllAutori().toString());
		//System.out.println(istanzaLibri.getAllBooks().toString());
		//System.out.println(istanzaEditori.getAllEditori().toString());
		//System.out.println(istanzaGeneri.getAll().toString());	
		
		for(Autore x : istanzaAutori.getAllAutori()) {
			System.out.println(x);
		}
		
		for(Book x : istanzaLibri.getAllBooks()) {
			System.out.println(x);
		}
		
		for(Editore x : istanzaEditori.getAllEditori()) {
			System.out.println(x);
		}
		
		for(Genere x : istanzaGeneri.getAll()) {
			System.out.println(x);
		}
	}
	
	

}
