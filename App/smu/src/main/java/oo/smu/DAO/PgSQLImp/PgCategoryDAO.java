package oo.smu.DAO.PgSQLImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public List<String> findAllCategoryNames() throws SQLException {
		String sql = "SELECT name FROM smu.Category";
		List<String> categoryNames = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
		            String name = rs.getString("name");
		            categoryNames.add(name);
		     }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return categoryNames;
	}
	
	@Override
	public String findCategoryKeywordByName(String name) throws SQLException {
		String sql = "SELECT keyword FROM smu.Category WHERE name = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String keyword = rs.getString("keyword");
				return keyword;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
