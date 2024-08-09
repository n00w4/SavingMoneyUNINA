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
	 * L'update di una Family non è permesso, in quanto è più sicuro cancellare la vecchia famiglia/gruppo ed aggiungerne una nuova,
	 * piuttosto che aggiornarla.
	 */
	
	/*
	 * Esegue operazione di delete per la classe Family
	 * @param Family family
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Family family) throws SQLException;
}
