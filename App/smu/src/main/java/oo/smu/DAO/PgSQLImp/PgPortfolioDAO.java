package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oo.smu.DAO.PortfolioDAO;
import oo.smu.Entity.Portfolio;
import oo.smu.Entity.User;
import oo.smu.Entity.Family;
import oo.smu.Entity.Category;

public class PgPortfolioDAO implements PortfolioDAO {
	private Connection connection;
	
	public PgPortfolioDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}
	
	@Override
	public boolean insertUserPortfolio(Portfolio portfolio, User user, Category category) throws SQLException {
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
	public boolean insertFamilyPortfolio(Portfolio portfolio, Family family, Category category) throws SQLException {
		String sql = "INSERT INTO Portfolio VALUES (?, ?, NULL, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, portfolio.getName());
			statement.setString(2, portfolio.getDescription());
			statement.setInt(3, family.getId());
			statement.setString(4, category.getKeyword());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUserPortfolio(Portfolio portfolio, User user, Category category) throws SQLException {
		String sql = "DELETE FROM Portfolio WHERE idPortfolio = ? AND name = ? AND taxCode = ? AND keyword = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, portfolio.getId());
			statement.setString(2, portfolio.getName());
			statement.setString(3, user.getTaxCode());
			statement.setString(4, category.getKeyword());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteFamilyPortfolio(Portfolio portfolio, Family family, Category category) throws SQLException {
		String sql = "DELETE FROM Portfolio WHERE idPortfolio = ? AND name = ? AND idFamily = ? AND keyword = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, portfolio.getId());
			statement.setString(2, portfolio.getName());
			statement.setInt(3, family.getId());
			statement.setString(4, category.getKeyword());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
