package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oo.smu.DAO.BankAccountDAO;
import oo.smu.Entity.BankAccount;

public class PgBankAccountDAO implements BankAccountDAO {
	
	private Connection connection;
	
	public PgBankAccountDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}

	@Override
	public boolean insert(BankAccount bankAccount) throws SQLException {
		String sql = "INSERT INTO BankAccount VALUES (?, ?, ?)";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, bankAccount.getBankName());
		statement.setString(2, bankAccount.getIbanBankAccount());
		statement.setFloat(3, bankAccount.getBalance());
		return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(BankAccount bankAccount) throws SQLException {
		String sql = "DELETE FROM BankAccount WHERE ibanBankAccount = ?";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(2, bankAccount.getIbanBankAccount());
		return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
