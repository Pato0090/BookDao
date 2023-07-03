package it.betacom.main;

import it.betacom.model.Book;
import it.betacom.service.impl.BookPrintService;
//import it.betacom.test.TestBench;

public class Main {

	public static void main(String[] args) {

		//TestBench testBench = new TestBench();
		
		//testBench.stampaDatiTabelle();
		
		
		BookPrintService bookPrintService = new BookPrintService();
		
		bookPrintService.saveListAsTxt();
		
		Book libro = new Book("1234", "titolo", "codiceA", "numPag", "anno", "codiceG", "codiceE");
		
		bookPrintService.saveAsTxt(libro);
		
		//AutoreDaoImpl impl = new AutoreDaoImpl();
		
		//System.out.println(impl.getAutoreById("1"));

		
	}

}
