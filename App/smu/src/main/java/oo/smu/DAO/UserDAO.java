package oo.smu.DAO;

import oo.smu.Entity.User;
import java.sql.SQLException;

public interface UserDAO {
	/*
	 * Esegue operazione di insert per la classe User
	 * @param User user
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insert(User user) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe User
	 * @param User user
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean updatePassword(User user) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe User
	 * @param User user
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(User user) throws SQLException;
	
	/*
	 * Trova user attraverso username e password
	 * @param String username, String password
	 * @return Ritorna l'utente trovato se esiste, altrimenti null
	 * @throws SQLException
	 */
	User findByUsername(String username) throws SQLException;
}
