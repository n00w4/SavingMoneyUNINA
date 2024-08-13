package oo.smu.Controller;

import java.sql.SQLException;

import oo.smu.Entity.Transaction;
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
	
	public boolean deleteTransaction(Transaction transaction, Card card, Portfolio portfolio) throws SQLException {
		return transactionDAO.delete(transaction, card, portfolio);
	}
}
