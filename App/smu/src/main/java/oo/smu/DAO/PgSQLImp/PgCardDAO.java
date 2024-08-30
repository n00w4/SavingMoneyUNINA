package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import oo.smu.DAO.CardDAO;
import oo.smu.Entity.Card;
import oo.smu.Entity.CreditCard;
import oo.smu.Entity.DebitCard;
import oo.smu.Entity.BankAccount;

public class PgCardDAO implements CardDAO {
	private Connection connection;

	public PgCardDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}
	
	@Override
	public boolean insertDebitCard(DebitCard debitCard, BankAccount bankAccount) throws SQLException {
		String sql = "INSERT INTO smu.Card VALUES (?, ?, ?, ?, ?, NULL, debitCard, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, debitCard.getCardNumber());
			statement.setString(2, debitCard.getCvv());
			statement.setObject(3, debitCard.getExpirationDate());
			statement.setString(4, debitCard.getIbanCard());
			statement.setFloat(5, debitCard.getBalanceCard());
			statement.setString(6, bankAccount.getIbanBankAccount());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertCreditCard(CreditCard creditCard, BankAccount bankAccount) throws SQLException {
		String sql = "INSERT INTO smu.Card VALUES (?, ?, ?, ?, ?, ?, creditCard, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, creditCard.getCardNumber());
			statement.setString(2, creditCard.getCvv());
			statement.setObject(3, creditCard.getExpirationDate());
			statement.setString(4, creditCard.getIbanCard());
			statement.setFloat(5, creditCard.getBalanceCard());
			statement.setFloat(6, creditCard.getPlafond());
			statement.setString(6, bankAccount.getIbanBankAccount());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Per una DebitCard non è previsto l'update del numero della carta per ragioni di sicurezza
	@Override
	public boolean updateDebitCard(DebitCard debitCard) throws SQLException {
		String sql = "UPDATE smu.Card SET cvv = ?, expirationDate = ?, balanceCard = ? WHERE ibanCard = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, debitCard.getCvv());
			statement.setObject(2, debitCard.getExpirationDate());
			statement.setFloat(3, debitCard.getBalanceCard());
			statement.setString(4, debitCard.getIbanCard());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCreditCard(CreditCard creditCard) throws SQLException {
		String sql = "UPDATE smu.Card SET cvv = ?, expirationDate = ?, balanceCard = ?, plafond = ? WHERE ibanCard = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, creditCard.getCvv());
			statement.setObject(2, creditCard.getExpirationDate());
			statement.setFloat(3, creditCard.getBalanceCard());
			statement.setFloat(4, creditCard.getPlafond());
			statement.setString(5, creditCard.getIbanCard());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateIbanCard(Card card, BankAccount bankAccount) throws SQLException {
		String sql = "UPDATE smu.Card SET ibanCard = ? WHERE cardNumber = ?  AND ibanBankAccount = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, card.getIbanCard());
			statement.setString(2, card.getCardNumber());
			statement.setString(3, bankAccount.getBankName());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteCard(Card card, BankAccount bankAccount) throws SQLException {
		String sql = "DELETE FROM smu.Card WHERE cardNumber = ? AND cvv = ? AND ibanCard = ? AND ibanBankAccount = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, card.getCardNumber());
			statement.setString(2, card.getCvv());
			statement.setString(3, card.getIbanCard());
			statement.setString(4, bankAccount.getIbanBankAccount());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Card findByCardNumber(String cardNumber) throws SQLException {
		String sql = "SELECT * FROM smu.Card WHERE cardNumber = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cardNumber);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String cvv = rs.getString("cvv");
				LocalDate expirationDate = rs.getObject("expirationDate", LocalDate.class);
				String ibanCard = rs.getString("ibanCard");
				float balanceCard = rs.getFloat("balanceCard");
				String ibanBankAccount = rs.getString("ibanBankAccount");
				
				Card card = new Card(cardNumber, cvv, expirationDate, ibanCard, balanceCard, ibanBankAccount);
				return card;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<String> findAllCardNumbersFromTaxCode(String taxCode) throws SQLException {
		String sql = "SELECT c.cardNumber FROM smu.User u JOIN smu.BankAccount b ON u.taxCode = b.taxCode\n"
				+ "JOIN smu.Card c ON b.ibanBankAccount = c.ibanBankAccount WHERE u.taxCode = ?";
		List<String> cardNumbers = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, taxCode);
			ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
		            String cardNumber = rs.getString("cardNumber");
		            cardNumbers.add(cardNumber);
		        }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return cardNumbers;
	}
}
