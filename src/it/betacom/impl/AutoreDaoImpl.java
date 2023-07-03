package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.connection.DBHandler;
import it.betacom.dao.AutoreDao;
import it.betacom.model.Autore;

public class AutoreDaoImpl implements AutoreDao {
		
	DBHandler handler; 
	Connection con;

	public AutoreDaoImpl() {
		super();
		handler = DBHandler.getInstance();
		con = handler.getConnection();
	}

	@Override
	public List<Autore> getAllAutori() {
		Statement stm;
		
		ArrayList<Autore> nuovaListaAutori = new ArrayList<Autore>();
		
		try {
			stm = handler.getConnection().createStatement();
			String query = "select * from autori";
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String annoNascita = rs.getString("anno_nascita");
				String annoMorte = rs.getString("anno_morte");
				String sesso = rs.getString("sesso");
				String nazione = rs.getString("nazione");
				
				Autore nuovoAutore = new Autore(id, nome, cognome, annoNascita, annoMorte, sesso, nazione);
				
				nuovaListaAutori.add(nuovoAutore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return nuovaListaAutori;
	}

	@Override
	public Autore getAutoreById(String id) {
		PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM autori WHERE id = ? ;";
	        pstmt = handler.getConnection().prepareStatement(query);
	        pstmt.setString(1, id);

	        rs = pstmt.executeQuery();
	        	        
	        if (rs.next()) {
	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String annoNascita = String.valueOf(rs.getInt("anno_nascita"));
	            String annoMorte = String.valueOf(rs.getInt("anno_morte"));
	            String sesso = rs.getString("sesso");
	            String nazione = rs.getString("nazione");
	            
	            Autore nuovoAutore = new Autore(id, nome, cognome, annoNascita, annoMorte, sesso, nazione);
	            //System.out.println(nuovoAutore.toString());
	            return nuovoAutore;
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
	public void insertAutore(Autore autore) {

		String cognome = autore.getCognome();
		String annoNascita = autore.getAnnoNascita();
		String annoMorte = autore.getAnnoMorte();
		String sesso = autore.getSesso();
		String nazione = autore.getNazione();

	    PreparedStatement pstmt = null;

	    try {
	        String query = "INSERT INTO autore (nome, cognome, anno_nascita, anno_morte, sesso, nazione) VALUES (?, ?, ?, ?, ?, ?);";
	        pstmt = handler.getConnection().prepareStatement(query);
	        pstmt.setString(1, autore.getNome());
	        pstmt.setString(2, cognome);
	        pstmt.setString(3, annoNascita);
	        pstmt.setString(4, annoMorte);
	        pstmt.setString(5, sesso);
	        pstmt.setString(6, nazione);


	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	                System.out.println("Inserimento completato");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	@Override
	public void updateAutore(Autore autore) {

		String id = autore.getId();
		String nome = autore.getNome();
		String cognome = autore.getCognome();
		String annoNascita = autore.getAnnoNascita();
		String annoMorte = autore.getAnnoMorte();
		String sesso = autore.getSesso();
		String nazione = autore.getNazione();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "UPDATE autore SET nome = ?, cognome = ?, anno_nascita = ?, anno_morte = ?, sesso = ?, nazione = ? WHERE id = ?";
		    pstmt = handler.getConnection().prepareStatement(query);
		    
		    pstmt.setString(1, nome);
	        pstmt.setString(2, cognome);
	        pstmt.setString(3, annoNascita);
	        pstmt.setString(4, annoMorte);
	        pstmt.setString(5, sesso);
	        pstmt.setString(6, nazione);
	        pstmt.setString(7, id);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAutore(Autore autore) {

		String id = autore.getId();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROM autore WHERE id =  ?;";
		    pstmt = handler.getConnection().prepareStatement(query);
		    pstmt.setString(1, id);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
