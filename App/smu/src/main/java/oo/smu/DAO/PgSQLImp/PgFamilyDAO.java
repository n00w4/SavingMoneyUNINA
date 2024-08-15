package oo.smu.DAO.PgSQLImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oo.smu.DAO.FamilyDAO;
import oo.smu.Entity.Family;

public class PgFamilyDAO implements FamilyDAO {
	private Connection connection;
	
	public PgFamilyDAO(Connection dbConnection) {
		this.connection = dbConnection;
	}

	@Override
	public boolean insert(Family family) throws SQLException {
		String sql = "INSERT INTO smu.Family VALUES (?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, family.getFamilyName());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Family family) throws SQLException {
		String sql = "DELETE FROM smu.Family WHERE familyName = ? AND idFamily = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, family.getFamilyName());
			statement.setInt(2, family.getId());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
