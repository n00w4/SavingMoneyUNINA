package oo.smu.DAO;

import oo.smu.Entity.Category;
import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {
	/*
	 * Esegue operazione di insert per la classe Category
	 * @param Category category
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insert(Category category) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe Category
	 * @param Category category
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean update(Category category) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe Category
	 * @param Category category
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Category category) throws SQLException;
	
	/*
	 * Trova i nomi di tutte le categorie disponibili
	 * @return Ritorna la lista dei nomi di tutte le categorie
	 * @throws SQLException
	 */
	List<String> findAllCategoryNames() throws SQLException;
}
