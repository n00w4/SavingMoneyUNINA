package oo.smu.DAO;

import oo.smu.Entity.Transaction;
import java.sql.SQLException;

public interface TransactionDAO {
	/*
	 * Esegue operazione di insert per la classe Transaction
	 * @param Transaction transaction
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insert(Transaction transaction) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe Transaction
	 * @param Transaction transaction
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean update(Transaction transaction) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe Transaction
	 * @param Transaction transaction
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Transaction transaction) throws SQLException;
}
