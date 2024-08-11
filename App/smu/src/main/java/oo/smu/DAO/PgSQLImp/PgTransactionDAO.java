package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oo.smu.DAO.TransactionDAO;
import oo.smu.Entity.Transaction;
import oo.smu.Entity.Income;
import oo.smu.Entity.Expense;
import oo.smu.Entity.Card;
import oo.smu.Entity.Portfolio;

public class PgTransactionDAO implements TransactionDAO {
	private Connection connection;
	
	public PgTransactionDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}

	@Override
	public boolean insertIncome(Income income, Card card, Portfolio portfolio) throws SQLException {
		String sql = "INSERT INTO Transaction VALUES (?, ?, ?, NULL, ?, income, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(1, income.getAmount());
			statement.setObject(2, income.getDateTime());
			statement.setString(3, income.getDescription());
			statement.setString(4, income.getSource());
			statement.setString(5, card.getCardNumber());
			statement.setInt(6, portfolio.getId());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean insertExpense(Expense expense, Card card, Portfolio portfolio) {
		String sql = "INSERT INTO Transaction VALUES (?, ?, ?, ?, NULL, expense, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(1, expense.getAmount());
			statement.setObject(2, expense.getDateTime());
			statement.setString(3, expense.getDescription());
			statement.setString(4, expense.getReceiver());
			statement.setString(5, card.getCardNumber());
			statement.setInt(6, portfolio.getId());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Transaction transaction, Card card, Portfolio portfolio) throws SQLException {
		String sql = "DELETE FROM Transaction WHERE idTransaction = ? AND cardNumber = ? AND idPortfolio = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, transaction.getId());
			statement.setString(2, card.getCardNumber());
			statement.setInt(3, portfolio.getId());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
