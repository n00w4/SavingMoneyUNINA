package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oo.smu.DAO.PortfolioDAO;
import oo.smu.Entity.Category;
import oo.smu.Entity.Portfolio;
import oo.smu.Entity.User;

public class PgPortfolioDAO implements PortfolioDAO {
	private Connection connection;
	
	public PgPortfolioDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}
	
	@Override
	public boolean insert(Portfolio portfolio, User user, Category category) throws SQLException {
		String sql = "INSERT INTO Portfolio VALUES (?, ?, ?, NULL, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, portfolio.getName());
			statement.setString(2, portfolio.getDescription());
			statement.setString(3, user.getTaxCode());
			statement.setString(4, category.getKeyword());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Portfolio portfolio, User user) throws SQLException {
		String sql = "DELETE FROM Portfolio WHERE name = ? AND description = ? AND taxCode = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, portfolio.getName());
			statement.setString(2, portfolio.getDescription());
			statement.setString(3, user.getTaxCode());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
