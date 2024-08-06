package oo.smu.DAO;

import oo.smu.Entity.Card;
import java.sql.SQLException;


public interface CardDAO {
	/*
	 * Esegue operazione di insert per la classe Card
	 * @param Card card
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insert(Card card) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe Card
	 * @param Card card
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean update(Card card) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe Card
	 * @param Card card
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Card card) throws SQLException;
}
