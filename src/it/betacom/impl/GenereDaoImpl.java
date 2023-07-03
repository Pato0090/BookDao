package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.connection.DBHandler;
import it.betacom.dao.GenereDao;
import it.betacom.model.Genere;

public class GenereDaoImpl implements GenereDao {
	
	private List<Genere> listaGeneri;
	
	DBHandler handler;
	Connection con;
	
	public GenereDaoImpl() {
		super();
		listaGeneri = new ArrayList<Genere>();
		
		handler = DBHandler.getInstance();
		con = handler.getConnection();
	}

	@Override
	public List<Genere> getAll() {
		
		Statement stm;
		
		try {
			stm = handler.getConnection().createStatement();
			String query = "select * from genere";
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				
				String codiceG = rs.getString("CodiceG");
				String descrizione = rs.getString("descrizione");
				
				Genere nuovoGenere = new Genere(codiceG, descrizione);
				listaGeneri.add(nuovoGenere);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return listaGeneri;
	}

	@Override
	public void insertGenere(Genere genere) {

		String codiceG = genere.getCodiceG();
	    String descrizione = genere.getDescrizione();

	    PreparedStatement pstmt = null;

	    try {
	        String query = "INSERT INTO genere (CodiceG, descrizione) VALUES (?, ?);";
	        pstmt = handler.getConnection().prepareStatement(query);
	        pstmt.setString(1, codiceG);
	        pstmt.setString(2, descrizione);

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
	public Genere getGenereById(String codiceG) {

		Statement stm;
		
		try {
			stm = handler.getConnection().createStatement();
			String query = "select descrizione from genere where codiceG =" + codiceG + ";";
			
			ResultSet rs = stm.executeQuery(query);
			
			if(rs.next()) {
				String descrizione = rs.getString("descrizione");
				Genere nuovoGenere = new Genere(codiceG, descrizione);
				return nuovoGenere;
				
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
		
	}

	@Override
	public void updateGenere(Genere genere) {
		String codiceG = genere.getCodiceG();
		String descrizione = genere.getDescrizione();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "UPDATE genere SET descrizione = ? WHERE codiceG = ?";
		    pstmt = handler.getConnection().prepareStatement(query);
		    pstmt.setString(1, descrizione);
		    pstmt.setString(2, codiceG);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteGenere(Genere genere) {

		String descrizione = genere.getDescrizione();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROM genere WHERE descrizione =  ?;";
		    pstmt = handler.getConnection().prepareStatement(query);
		    pstmt.setString(1, descrizione);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
