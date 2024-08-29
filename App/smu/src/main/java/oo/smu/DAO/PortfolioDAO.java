package oo.smu.DAO;

import oo.smu.Entity.Portfolio;
import oo.smu.Entity.User;
import oo.smu.Entity.Family;
import oo.smu.Entity.Category;
import java.sql.SQLException;

public interface PortfolioDAO {
	/*
	 * Esegue operazione di insert per la classe Portfolio
	 * @param Portfolio portfolio, User user, Category category
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insertUserPortfolio(Portfolio portfolio, User user, Category category) throws SQLException;
	
	/*
	 * Esegue operazione di insert per la classe Portfolio
	 * @param Portfolio portfolio, Family family, Category category
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insertFamilyPortfolio(Portfolio portfolio, Family family, Category category) throws SQLException; 
	
	/*
	 * L'update di un Portfolio non è permesso, in quanto è più sicuro cancellare il vecchio portfolio ed aggiungerne uno nuovo,
	 * piuttosto che aggiornarlo.
	 */
	
	/*
	 * Esegue operazione di delete per la classe Portfolio
	 * @param Portfolio portfolio
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean deleteUserPortfolio(Portfolio portfolio, User user, Category category) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe Portfolio
	 * @param Portfolio portfolio
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean deleteFamilyPortfolio(Portfolio portfolio, Family family, Category category) throws SQLException;

	/*
	 * Trova un portfolio attraverso il nome e l'user
	 * @param String name, User user
	 * @return Ritorna il portfolio corrispondente
	 * @throws SQLException
	 */
	Portfolio findByName(String name, User user) throws SQLException;
}
