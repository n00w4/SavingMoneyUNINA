package oo.smu.Controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import oo.smu.Entity.Income;
import oo.smu.Entity.Expense;
import oo.smu.Entity.Card;
import oo.smu.Entity.Portfolio;
import oo.smu.DAO.TransactionDAO;

public class TransactionController {
	private TransactionDAO transactionDAO;
	
	public TransactionController(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
	
	public boolean saveIncome(Income income, Card card, Portfolio portfolio) throws SQLException {
		return transactionDAO.insertIncome(income, card, portfolio);
	}
	
	public boolean saveExpense(Expense expense, Card card, Portfolio portfolio) throws SQLException {
		return transactionDAO.insertExpense(expense, card, portfolio);
	}
	
	public boolean deleteTransaction(Card card, Portfolio portfolio) throws SQLException {
		return transactionDAO.delete(card, portfolio);
	}
	
	public List<Income> findIncomeByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException {
		return transactionDAO.findIncomeByDateCardCategory(dateA, dateB, cardNumber, keyword, taxCode);
	}
	
	public List<Expense> findExpenseByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException {
		return transactionDAO.findExpenseByDateCardCategory(dateA, dateB, cardNumber, keyword, taxCode);
	}
	
	public Income findMaxIncome(String cardNumber) throws SQLException {
		return transactionDAO.findMaxIncome(cardNumber);
	}
	
	public Income findMinIncome(String cardNumber) throws SQLException {
		return transactionDAO.findMinIncome(cardNumber);
	}
	
	public Float findAvgIncome(String cardNumber) throws SQLException {
		return transactionDAO.findAvgIncome(cardNumber);
	}
	
	public Expense findMaxExpense(String cardNumber) throws SQLException {
		return transactionDAO.findMaxExpense(cardNumber);
	}
	
	public Expense findMinExpense(String cardNumber) throws SQLException {
		return transactionDAO.findMinExpense(cardNumber);
	}
	
	public Float findAvgExpense(String cardNumber) throws SQLException {
		return transactionDAO.findAvgExpense(cardNumber);
	}
}
