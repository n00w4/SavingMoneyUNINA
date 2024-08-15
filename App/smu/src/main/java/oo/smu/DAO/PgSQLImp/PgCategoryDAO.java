package oo.smu.DAO.PgSQLImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oo.smu.DAO.CategoryDAO;
import oo.smu.Entity.Category;

public class PgCategoryDAO implements CategoryDAO {
	private Connection connection;
	
	public PgCategoryDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}

	@Override
	public boolean insert(Category category) throws SQLException {
		String sql = "INSERT INTO smu.Category VALUES (?, ?)";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, category.getName());
		statement.setString(2, category.getKeyword());
		return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) throws SQLException {
		String sql = "UPDATE smu.Category SET name = ? WHERE keyword = ?";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, category.getName());
		statement.setString(2, category.getKeyword());
		return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) throws SQLException {
		String sql = "DELETE FROM smu.Category WHERE name = ? AND keyword = ?";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, category.getName());
		statement.setString(2, category.getKeyword());
		return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
