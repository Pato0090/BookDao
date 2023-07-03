package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.connection.DBHandler;
import it.betacom.dao.EditoreDao;
import it.betacom.model.Editore;

public class EditoreDaoImpl implements EditoreDao {
		
	DBHandler handler; 
	Connection con;
	
	public EditoreDaoImpl() {
		super();
		handler = DBHandler.getInstance();
		con = handler.getConnection();
	}

	@Override
	public List<Editore> getAllEditori() {

		Statement stm;
		ArrayList<Editore> listaEditori = null;
		try {
			stm = handler.getConnection().createStatement();
			String query = "select * from editore";
			
			ResultSet rs = stm.executeQuery(query);
			
			listaEditori = new ArrayList<Editore>();
			
			while(rs.next()) {
				
				String nome = rs.getString("nome");
				String codiceE = rs.getString("CodiceE");
				
				Editore nuovoEditore = new Editore(codiceE, nome);
				
				listaEditori.add(nuovoEditore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return listaEditori;
	}

	@Override
	public Editore getEditoreById(String codiceE) {
		
		PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM editore WHERE codiceE = ?;";
	        pstmt = handler.getConnection().prepareStatement(query);
	        pstmt.setString(1, codiceE);

	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	String nome = rs.getString("nome");	        	
	        	Editore editore = new Editore(codiceE, nome);
	        	return editore;
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
	public void insertEditore(Editore editore) {

		String codiceE = editore.getCodiceE();
		String nome = editore.getNome();

	    PreparedStatement pstmt = null;

	    try {
	        String query = "INSERT INTO editore (CodiceE, descrizione) VALUES (?, ?);";
	        pstmt = handler.getConnection().prepareStatement(query);
	        pstmt.setString(1, codiceE);
	        pstmt.setString(2, nome);

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
	public void deleteEditore(Editore editore) {

		String nome = editore.getNome();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROM editore WHERE nome =  ?;";
		    pstmt = handler.getConnection().prepareStatement(query);
		    pstmt.setString(1, nome);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateEditore(Editore editore) {


		String codiceE = editore.getCodiceE();
		String nome = editore.getNome();
		
	    PreparedStatement pstmt = null;
		
		try {
			String query = "UPDATE editore SET nome = ? WHERE codiceE = ?";
		    pstmt = handler.getConnection().prepareStatement(query);
		    pstmt.setString(1, nome);
		    pstmt.setString(2, codiceE);

		    pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
