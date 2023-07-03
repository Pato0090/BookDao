package it.betacom.dao;

import java.util.List;
import it.betacom.model.Editore;

public interface EditoreDao {

	List<Editore> getAllEditori();
	Editore getEditoreById(String codiceE);
	void insertEditore(Editore editore);
	void deleteEditore(Editore editore);
	void updateEditore(Editore editore);
	
}
