package oo.smu.DAO;

import oo.smu.Entity.Income;
import oo.smu.Entity.Expense;
import oo.smu.Entity.Card;
import oo.smu.Entity.Portfolio;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionDAO {
	/*
	 * Esegue operazione di insert per la classe Income
	 * @param Income income, Card card, Portfolio portfolio
	 * @return Ritorna true se l'insert è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean insertIncome(Income income, Card card, Portfolio portfolio) throws SQLException;
	
	/*
	 * Esegue operazione di insert per la classe Expense
	 * @param Expense expense, Card card, Portfolio portfolio
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
	 * @param Transaction transaction, Card card, Portfolio portfolio
	 * @return Ritorna true se la delete è possibile, altrimenti false
	 * @throws SQLException
	 */
	boolean delete(Card card, Portfolio portfolio) throws SQLException;
	
	/*
	 * Trova tutte le entrate di un utente per periodo di tempo (dateA e dateB) in base al numero di carta e alla categoria scelta
	 * @param LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode
	 * @return Ritorna le entrate corrispondenti
	 * @throws SQLExceptiom
	 */
	List<Income> findIncomeByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException;
	
	/*
	 * Trova tutte le uscite di un utente per periodo di tempo (dateA e dateB) in base al numero di carta e alla categoria scelta
	 * @param LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode
	 * @return Ritorna le uscite corrispondenti
	 * @throws SQLExceptiom
	 */
	List<Expense> findExpenseByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException;
	
	/*
	 * Trova l'entrata massima di una carta (e quindi di un utente) attraverso le transazioni
	 * @param String cardNumber
	 * @return Ritorna l'entrata corrispondente
	 * @throws SQLException
	 */
	Income findMaxIncome(String cardNumber) throws SQLException;
	
	/*
	 * Trova l'entrata minima di una carta (e quindi di un utente) attraverso le transazioni
	 * @param String cardNumber
	 * @return Ritorna l'entrata corrispondente
	 * @throws SQLException
	 */
	Income findMinIncome(String cardNumber) throws SQLException;
	
	/*
	 * Trova l'entrata media di una carta (e quindi di un utente) attraverso le transazioni
	 * @param String cardNumber
	 * @return Ritorna l'entrata corrispondente
	 * @throws SQLException
	 */
	Float findAvgIncome(String cardNumber) throws SQLException;
	
	/*
	 * Trova la spesa massima di una carta (e quindi di un utente) attraverso le transazioni
	 * @param String cardNumber
	 * @return Ritorna l'entrata corrispondente
	 * @throws SQLException
	 */
	Expense findMaxExpense(String cardNumber) throws SQLException;
	
	/*
	 * Trova la spesa minima di una carta (e quindi di un utente) attraverso le transazioni
	 * @param String cardNumber
	 * @return Ritorna l'entrata corrispondente
	 * @throws SQLException
	 */
	Expense findMinExpense(String cardNumber) throws SQLException;
	
	/*
	 * Trova la spesa media di una carta (e quindi di un utente) attraverso le transazioni
	 * @param String cardNumber
	 * @return Ritorna l'entrata corrispondente
	 * @throws SQLException
	 */
	Float findAvgExpense(String cardNumber) throws SQLException;
	
	/*
	 * Calcola il saldo finale di una carta attraverso le transazioni
	 */
	Float calculateInitialBalanceFromCardNumber(String cardNumber, LocalDateTime initialDate, LocalDateTime finalDate);
	
	/*
	 * Calcola il saldo finale di una carta attraverso le transazioni
	 */
	Float calculateFinalBalanceFromCardNumber(String cardNumber, LocalDateTime initialDate, LocalDateTime finalDate);
}
