package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.connection.DBHandler;
import it.betacom.dao.BookDao;
import it.betacom.model.Book;

public class BookDaoImpl implements BookDao {
	 	
	DBHandler handler; 
	Connection con;

	public BookDaoImpl() {
		super();
		handler = DBHandler.getInstance();
		con = handler.getConnection();
	}

	@Override
	public List<Book> getAllBooks() {
		// si connette al db e ottiene la lista dei libri
		
		Statement stm;
		ArrayList<Book> books = new ArrayList<Book>();
;
		
		try {
			stm = handler.getConnection().createStatement();
			String query = "select * from libri";
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				
				String titolo = rs.getString("titolo");
				String isbn = rs.getString("Codice_R");
				String codiceA = rs.getString("Codice_A");;
				String numPag = rs.getString("numero_pagine");;
				String anno = rs.getString("anno");;
				String CodiceG_FK = rs.getString("CodiceG_FK");;
				String CodiceE = rs.getString("CodiceE");;
				
				Book book = new Book(isbn, titolo, codiceA, numPag, anno, CodiceG_FK, CodiceE);				
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return books;
	}

	@Override
	public Book getBookById(String id) {

	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM libri WHERE codice_R = ?;";
	        pstmt = handler.getConnection().prepareStatement(query);
	        pstmt.setString(1, id);

	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	String titolo = rs.getString("titolo");
	        	String isbn = rs.getString("Codice_R");
	        	String codiceA = rs.getString("Codice_A");
	        	String numPag = rs.getString("numero_pagine");
	        	String anno = rs.getString("anno");
	        	String CodiceG_FK = rs.getString("CodiceG_FK");
	        	String CodiceE = rs.getString("CodiceE");
	        	
	        	Book book = new Book(isbn, titolo, codiceA, numPag, anno, CodiceG_FK, CodiceE);	        	
	        	return book;
	        }
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return null;
	}

	@Override
	public void insertBook(Book book) {

	    PreparedStatement pstmt = null;

	    try {
	        String query = "INSERT INTO libri (titolo, codice_A, numero_pagine, anno, CodiceG_FK, CodiceE) VALUES (?, ?, ?, ?, ?, ?);";
	        pstmt = handler.getConnection().prepareStatement(query);
	        pstmt.setString(1, book.getTitolo());
	        pstmt.setString(2, book.getCodiceA());
	        pstmt.setString(3, book.getNumPag());
	        pstmt.setString(4, book.getAnno());
	        pstmt.setString(5, book.getCodiceG_FK());
	        pstmt.setString(6, book.getCodiceE());

	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


	@Override
	public void deleteBook(Book book) {

		String titolo = book.getTitolo();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROM libri WHERE titolo =  ?;";
		    pstmt = handler.getConnection().prepareStatement(query);
		    pstmt.setString(1, titolo);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(Book book) {

		String titolo = book.getTitolo();
		String isbn = book.getIsbn();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "UPDATE libri SET titolo = ? WHERE codice_R = ?";
		    pstmt = handler.getConnection().prepareStatement(query);
		    pstmt.setString(1, titolo);
		    pstmt.setString(2, isbn);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
