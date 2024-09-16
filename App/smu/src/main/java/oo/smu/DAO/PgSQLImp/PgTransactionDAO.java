package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oo.smu.DAO.TransactionDAO;
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
		String sql = "INSERT INTO smu.Transaction VALUES (?, ?, ?, NULL, ?, income, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(1, income.getAmount());
			statement.setObject(2, income.getDateTime());
			statement.setString(3, income.getDescription());
			statement.setString(4, income.getSender());
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
		String sql = "INSERT INTO smu.Transaction VALUES (?, ?, ?, ?, NULL, expense, ?, ?)";
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
	public boolean delete(Card card, Portfolio portfolio) throws SQLException {
		String sql = "DELETE FROM smu.Transaction WHERE cardNumber = ? AND idPortfolio = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(2, card.getCardNumber());
			statement.setInt(3, portfolio.getId());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Income> findIncomeByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException {
		String sql = "SELECT t.* FROM smu.Transaction t JOIN smu.Card c ON t.cardNumber = c.cardNumber JOIN smu.Portfolio p ON t.idPortfolio = p.idPortfolio\n"
				+ "JOIN smu.User u ON p.taxCode = u.taxCode JOIN smu.Category cat ON p.keyword = cat.keyword\n"
				+ "WHERE t.dateTime BETWEEN ? AND ? AND t.cardNumber = ?  AND t.typeTransaction = 'income' AND cat.keyword = ? AND u.taxCode = ?";
		List<Income> transactions = new ArrayList<Income>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, dateA);
			statement.setObject(2, dateB);
			statement.setString(3, cardNumber);
			statement.setString(4, keyword);
			statement.setString(5, taxCode);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
	            float amount = rs.getFloat("amount");
	            LocalDateTime date = rs.getTimestamp("dateTime").toLocalDateTime();
	            String description = rs.getString("description");
	            String sender = rs.getString("sender");
	            
	            Income income = new Income(amount, date, description, sender);
	            transactions.add(income);
			}
			return transactions;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@Override
	public List<Expense> findExpenseByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException {
		String sql = "SELECT t.* FROM smu.Transaction t JOIN smu.Card c ON t.cardNumber = c.cardNumber JOIN smu.Portfolio p ON t.idPortfolio = p.idPortfolio\n"
				+ "JOIN smu.User u ON p.taxCode = u.taxCode JOIN smu.Category cat ON p.keyword = cat.keyword\n"
				+ "WHERE t.dateTime BETWEEN ? AND ? AND t.cardNumber = ?  AND t.typeTransaction = 'expense' AND cat.keyword = ? AND u.taxCode = ?";
		List<Expense> transactions = new ArrayList<Expense>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, dateA);
			statement.setObject(2, dateB);
			statement.setString(3, cardNumber);
			statement.setString(4, keyword);
			statement.setString(5, taxCode);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
	            float amount = rs.getFloat("amount");
	            LocalDateTime date = rs.getTimestamp("dateTime").toLocalDateTime();
	            String description = rs.getString("description");
	            String receiver = rs.getString("receiver");
	            
	            Expense expense = new Expense(amount, date, description, receiver);
	            transactions.add(expense);
			}
			return transactions;
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	
	@Override
	public Income findMaxIncome(String cardNumber) throws SQLException {
	
		
		String sql = "SELECT t.* FROM smu.Transaction t"
				+"WHERE t.typeTransaction = 'income' AND t.cardNumber = ? ORDER BY amount DESC LIMIT 1";
				

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				float amount = rs.getFloat("amount");
	            LocalDateTime date = rs.getTimestamp("dateTime").toLocalDateTime();
	            String description = rs.getString("description");
	            String sender = rs.getString("sender");
	            
	            Income income = new Income(amount, date, description, sender);
			}
			return income;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@Override
	public Income findMinIncome(String cardNumber) throws SQLException {
		String sql = "SELECT t.* FROM smu.Transaction t"
				+"WHERE t.typeTransaction = 'income' AND t.cardNumber = ? ORDER BY amount ASC LIMIT 1";
				

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				float amount = rs.getFloat("amount");
	            LocalDateTime date = rs.getTimestamp("dateTime").toLocalDateTime();
	            String description = rs.getString("description");
	            String sender = rs.getString("sender");
	            
	            Income income = new Income(amount, date, description, sender);
			}
			return income;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	
	@Override
	public Float findAvgIncome(String cardNumber) throws SQLException {
		String sql = "SELECT AVG(t.amount) AS averageIncome FROM smu.Transaction t"
				+"JOIN smu.Card C ON t.cardNumber = c.cardNumber"
				+"JOIN smu.BankAccount b ON c.ibanBankAccount = b.ibanBankAccount"
				+ "JOIN smu.User u ON b.taxCode = u.taxCode"
				+ "WHERE t.typeTransaction = 'income' AND cardNumber = ?"
				+ "GROUP BY u.taxCode;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Float averageIncome = rs.getFloat("averageIncome");
				return averageIncome;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;		
	}
	
	@Override
	public Expense findMaxExpense(String cardNumber) throws SQLException {
		String sql = "SELECT t.* FROM smu.Transaction t"
				+"WHERE t.typeTransaction = 'expense' AND t.cardNumber = ? ORDER BY amount DESC LIMIT 1";
				

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				float amount = rs.getFloat("amount");
	            LocalDateTime date = rs.getTimestamp("dateTime").toLocalDateTime();
	            String description = rs.getString("description");
	            String receiver = rs.getString("receiver");
	            
	            Expense expense = new Expense(amount, date, description, receiver);
			}
			return expense;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	
	@Override
	public Expense findMinExpense(String cardNumber) throws SQLException {
		String sql = "SELECT t.* FROM smu.Transaction t"
				+"WHERE t.typeTransaction = 'expense' AND t.cardNumber = ? ORDER BY amount ASC LIMIT 1";
				
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				float amount = rs.getFloat("amount");
	            LocalDateTime date = rs.getTimestamp("dateTime").toLocalDateTime();
	            String description = rs.getString("description");
	            String receiver = rs.getString("receiver");
	            
	            Expense expense = new Expense(amount, date, description, receiver);
			}
			return expense;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	
	@Override
	public Float findAvgExpense(String cardNumber) throws SQLException {
		String sql = "SELECT AVG(t.amount) AS averageExpense FROM smu.Transaction t"
				+"JOIN smu.Card C ON t.cardNumber = c.cardNumber"
				+"JOIN smu.BankAccount b ON c.ibanBankAccount = b.ibanBankAccount"
				+ "JOIN smu.User u ON b.taxCode = u.taxCode"
				+ "WHERE t.typeTransaction = 'expense' AND cardNumber = ?"
				+ "GROUP BY u.taxCode;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Float averageExpense = rs.getFloat("averageExpense");
				return averageExpense;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@Override
	public Float calculateInitialBalanceFromCardNumber(String cardNumber, LocalDateTime initialDate, LocalDateTime finalDate) {
		
		String sql = "WITH initialBalance AS ( SELECT t,amount. t. typeTransaction, t. dateTime "
				+ "FROM smu.Transaction t WHERE  t.cardNumber = ? "
				+ "AND t.dateTime >= ? "
				+ "AND t.dateTime < ? "
				+ "SELECT SUM(CASE WHEN typeTransaction = 'income' THEN amount ELSE -amount END) AS initialAmount "
				+ "FROM initialBalance WHERE dateTime = (SELECT MIN(dateTime) FROM initialBalance);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			statement.setObject(2, initialDate);
			statement.setObject(3, finalDate);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				Float initialBalance = rs.getFloat("initialBalance");
				return initialBalance;
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}		
		
		return null;
	}
	
	@Override
	public Float calculateFinalBalanceFromCardNumber(String cardNumber, LocalDateTime initialDate, LocalDateTime finalDate) {
		
		String sql = "WITH finalBalance AS ( SELECT t,amount. t. typeTransaction, t. dateTime "
				+ "FROM smu.Transaction t WHERE  t.cardNumber = ? "
				+ "AND t.dateTime >= ? "
				+ "AND t.dateTime < ? "
				+ "SELECT SUM(CASE WHEN typeTransaction = 'income' THEN amount ELSE -amount END) AS finalAmount "
				+ "FROM finalBalance WHERE dateTime = (SELECT MAX(dateTime) FROM finalBalance);";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			statement.setObject(2, initialDate);
			statement.setInt(3, finalDate);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				Float finalAmount = rs.getFloat("finalAmount");
				return finalAmount;
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
			return null;
		}		
		
		return null;
	}
}
