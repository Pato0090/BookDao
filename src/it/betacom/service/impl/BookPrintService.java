package it.betacom.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import it.betacom.impl.AutoreDaoImpl;
import it.betacom.impl.BookDaoImpl;
import it.betacom.impl.EditoreDaoImpl;
import it.betacom.impl.GenereDaoImpl;
import it.betacom.model.Autore;
import it.betacom.model.Book;
import it.betacom.model.Editore;
import it.betacom.model.Genere;
import it.betacom.service.ConfigLoader;
import it.betacom.service.PrintService;

public class BookPrintService implements PrintService<Book> {
	
	BookDaoImpl implBook;
	AutoreDaoImpl implAutore;
	EditoreDaoImpl implEditore;
	GenereDaoImpl implGenere;
	ConfigLoader loader;

	public BookPrintService() {
		
		implBook = new BookDaoImpl();
		implAutore = new AutoreDaoImpl();
		implEditore = new EditoreDaoImpl();
		implGenere = new GenereDaoImpl();
		
		loader = ConfigLoader.getInstance();
	
	}

	@Override
	public void saveListAsPdf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveListAsCsv() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveListAsTxt() {
		
		String userHome = System.getProperty("user.home");
		String documentsPath = userHome + File.separator + "Documents" + File.separator + "Biblioteca";
		String filePath = documentsPath + File.separator + "listaLibri.txt";

		// Crea le cartelle se non esistono
		File directory = new File(documentsPath);
		directory.mkdirs();

		try {
		    // Crea il file se non esiste
		    File file = new File(filePath);
		    if (file.createNewFile()) {
		        System.out.println("File creato con successo");
		    } else {
		        System.out.println("Il file esiste già");
		    }
		    
			FileWriter writer = new FileWriter(filePath);
			
			writer.append("Libri presenti nel database: \n\n");
			writer.append(String.format("%8s %-40s %-30s %-10s %-10s %-15s %-15s %n"
						, "ISBN"
						, "TITOLO"
						, "NOME AUTORE"
						, "N° PAGINE"
						, "ANNO"
						, "EDITORE"
						, "GENERE"));
			
			System.out.print("Elaborazione in corso");


			for(Book x : implBook.getAllBooks()) {
				
				System.out.print('.');
				
				//Crea una stringa con il nome completo dell'autore
				Autore autore = implAutore.getAutoreById(x.getCodiceA());			
				//String nomeAutore = (autore.getNome() + " " + autore.getCognome());
				
				String nomeAutore = "--";
				if (autore != null) {
				    nomeAutore = autore.getNome() + " " + autore.getCognome();
				}
				
				//Crea una stringa con il nome completo dell'editore
				Editore editore = implEditore.getEditoreById(x.getCodiceE());
				
				String nomeEditore = "--";
				if (editore != null) {
				    nomeEditore = editore.getNome();
				}
				
				//Crea stringa genere
				Genere genere = implGenere.getGenereById(x.getCodiceG_FK());
				String nomeGenere = "--";
				
				if(genere != null) {
					nomeGenere = genere.getDescrizione();
				}
				
				String newLine = String.format("%8s %-40s %-30s %-10s %-10s %-15s %-15s %n"
						, x.getIsbn()
						, x.getTitolo()
						, nomeAutore
						, x.getNumPag()
						, x.getAnno()
						, nomeEditore
						, nomeGenere);
				
				
				writer.append(newLine);
			}
			
			writer.close();
			System.out.println("\nFile aggiornato con successo");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveAsPdf(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAsCsv(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAsTxt(Book t) {


		String userHome = System.getProperty("user.home");
		String documentsPath = userHome + File.separator + "Documents" + File.separator + "Biblioteca";
		String filePath = documentsPath + File.separator + t.getTitolo() + ".txt";

		// Crea le cartelle se non esistono
		File directory = new File(documentsPath);
		directory.mkdirs();

		try {
			// Crea il file se non esiste
			File file = new File(filePath);
			if (file.createNewFile()) {
				System.out.println("File creato con successo");
			} else {
				System.out.println("Il file esiste già");
			}

			FileWriter writer = new FileWriter(filePath);

			writer.append("Dettagli libro: \n");
			writer.append(String.format("%8s %-40s %-30s %-10s %-10s %-15s %-15s %n"
					, "ISBN"
					, "TITOLO"
					, "NOME AUTORE"
					, "N° PAGINE"
					, "ANNO"
					, "EDITORE"
					, "GENERE"));

			System.out.print("Elaborazione in corso");

			System.out.print('.');

			//Crea una stringa con il nome completo dell'autore
			Autore autore = implAutore.getAutoreById(t.getCodiceA());			
			//String nomeAutore = (autore.getNome() + " " + autore.getCognome());

			String nomeAutore = "--";
			if (autore != null) {
				nomeAutore = autore.getNome() + " " + autore.getCognome();
			}

			//Crea una stringa con il nome completo dell'editore
			Editore editore = implEditore.getEditoreById(t.getCodiceE());

			String nomeEditore = "--";
			if (editore != null) {
				nomeEditore = editore.getNome();
			}

			//Crea stringa genere
			Genere genere = implGenere.getGenereById(t.getCodiceG_FK());
			String nomeGenere = "--";

			if(genere != null) {
				nomeGenere = genere.getDescrizione();
			}

			String newLine = String.format("%8s %-40s %-30s %-10s %-10s %-15s %-15s %n"
					, t.getIsbn()
					, t.getTitolo()
					, nomeAutore
					, t.getNumPag()
					, t.getAnno()
					, nomeEditore
					, nomeGenere);


			writer.append(newLine);

			writer.close();
			System.out.println("\nFile aggiornato con successo");		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
