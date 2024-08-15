package oo.smu.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgSQL {
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=smu";
	private String user = "postgres";
	private String password = "postgres";
	private static Connection connection;
	
	private PgSQL() throws SQLException {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) { e.printStackTrace(); }
	}
	
	/**
	 * Apre una connessione e la ritorna,
	 * mentre in caso di errori viene chiusa,
	 * riaprendone una nuova.
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			new PgSQL();
		}
		return connection;
	}
	
	
}
