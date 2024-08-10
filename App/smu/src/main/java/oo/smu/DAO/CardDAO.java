package oo.smu.DAO;

import oo.smu.Entity.DebitCard;
import oo.smu.Entity.CreditCard;
import oo.smu.Entity.BankAccount;
import java.sql.SQLException;


public interface CardDAO {
	/*
	 * Esegue operazione di insert per la classe DebitCard
	 * @param DebitCard debitCard
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insertDebitCard(DebitCard debitCard, BankAccount bankAccount) throws SQLException;
	
	/*
	 * Esegue operazione di insert per la classe CreditCard
	 * @param CreditCard creditCard
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insertCreditCard(CreditCard creditCard, BankAccount bankAccount) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe DebitCard
	 * @param DebitCard debitCard
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean updateDebitCard(DebitCard debitCard) throws SQLException;
	
	/*
	 * Esegue operazione di update per la classe CreditCard
	 * @param CreditCard creditCard
	 * @return Ritorna true se l'update è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean updateCreditCard(CreditCard creditCard) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe DebitCard
	 * @param DebitCard debitCard
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean deleteDebitCard(DebitCard debitCard, BankAccount bankAccount) throws SQLException;
	
	/*
	 * Esegue operazione di delete per la classe CreditCard
	 * @param CreditCard creditCard
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean deleteCreditCard(CreditCard creditCard, BankAccount bankAccount) throws SQLException;
}
