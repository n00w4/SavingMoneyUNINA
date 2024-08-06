package oo.smu.DAO;

import oo.smu.Entity.Family;
import java.sql.SQLException;


public interface FamilyDAO {
	/*
	 * Esegue operazione di insert per la classe Family
	 * @param Family family
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insert(Family family) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe Family
	 * @param Family family
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean update(Family family) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe Family
	 * @param Family family
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Family family) throws SQLException;
}
