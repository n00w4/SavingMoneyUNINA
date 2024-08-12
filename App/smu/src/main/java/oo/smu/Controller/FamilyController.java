package oo.smu.Controller;

import java.sql.SQLException;

import oo.smu.Entity.Family;
import oo.smu.DAO.FamilyDAO;

public class FamilyController {
	private FamilyDAO familyDAO;
	
	public FamilyController(FamilyDAO familyDAO) {
		this.familyDAO = familyDAO;
	}
	
	public boolean saveFamily(Family family) throws SQLException {
		return familyDAO.insert(family);
	}
	
	public boolean deleteFamily(Family family) throws SQLException {
		return familyDAO.delete(family);
	}
}
