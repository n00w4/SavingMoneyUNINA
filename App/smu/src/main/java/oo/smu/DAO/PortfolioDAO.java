package oo.smu.DAO;

import oo.smu.Entity.Portfolio;
import java.sql.SQLException;

public interface PortfolioDAO {
	/*
	 * Esegue operazione di insert per la classe Portfolio
	 * @param Portfolio portfolio
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insert(Portfolio portfolio) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe Portfolio
	 * @param Portfolio portfolio
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean update(Portfolio portfolio) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe Portfolio
	 * @param Portfolio portfolio
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Portfolio portfolio) throws SQLException;
}
