package oo.smu.DAO;

import oo.smu.Entity.BankAccount;
import java.sql.SQLException;

public interface BankAccountDAO {
	/*
	 * Esegue operazione di insert per la classe BankAccount
	 * @param BankAccount bankAccount
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insert(BankAccount bankAccount) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe BankAccount
	 * @param BankAccount bankAccount
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean update(BankAccount bankAccount) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe BankAccount
	 * @param BankAccount bankAccount
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(BankAccount bankAccount) throws SQLException;
}
