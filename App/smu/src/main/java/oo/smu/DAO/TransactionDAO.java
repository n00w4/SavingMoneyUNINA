package oo.smu.DAO;

import oo.smu.Entity.Transaction;
import oo.smu.Entity.Income;
import oo.smu.Entity.Expense;
import oo.smu.Entity.Card;
import oo.smu.Entity.Portfolio;
import java.sql.SQLException;

public interface TransactionDAO {
	/*
	 * Esegue operazione di insert per la classe Income
	 * @param Income income
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insertIncome(Income income, Card card, Portfolio portfolio) throws SQLException;
	
	/*
	 * Esegue operazione di insert per la classe Expense
	 * @param Expense expense
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insertExpense(Expense expense, Card card, Portfolio portfolio) throws SQLException;
	
	/*
	 * Non è prevista alcuna operazione di update per una transazione, in quanto è più sicuro cancellarla e
	 * crearne/sincronizzarne una nuova, al fine di non compromettere la veridicità dei dati.
	 */
	
	/*
	 * Esegue operazione di delete per la classe Transaction
	 * @param Transaction transaction
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Transaction transaction, Card card, Portfolio portfolio) throws SQLException;
}
