package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import oo.smu.DAO.UserDAO;
import oo.smu.Entity.User;

public class PgUserDAO implements UserDAO {
	private Connection connection;
	
	public PgUserDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}
	
	@Override
	public boolean insert(User user) throws SQLException {
		String sql = "INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?, NULL)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getSecondName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getTaxCode());
			statement.setObject(7, user.getBirthDate());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Per la classe User attualmente viene permesso l'update dell'attributo password
	@Override
	public boolean updatePassword(User user) throws SQLException {
		String sql = "UPDATE User SET password = ? WHERE taxCode = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getTaxCode());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User user) throws SQLException {
		String sql = "DELETE FROM User WHERE taxCode = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getTaxCode());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public User findByUsername(String username) throws SQLException {
		String sql = "SELECT * FROM User WHERE username = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("firstName");
				String secondName = rs.getString("secondName");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String taxCode = rs.getString("taxCode");
				LocalDate birthDate = rs.getObject("birthDate", LocalDate.class);
				int idFamily = rs.getInt("idFamily");
				
				User user = new User(firstName, secondName, username, password, email, taxCode, birthDate, idFamily);
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
 	}
}
