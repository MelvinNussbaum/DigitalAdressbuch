package lab01.Datenbank.Termine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionTermine {

	private static DBConnectionTermine dbconnection = null;

	private final String dbURL = "jdbc:mysql://localhost:3306/adressbuch";
	private final String dbUser = "root";
	private final String dbPW = "1234";

	private Connection connection = null;

	private DBConnectionTermine() {
	}

	public Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(dbURL, dbUser, dbPW);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		return connection;
	}

	public static DBConnectionTermine getInstance() {
		if (dbconnection == null) {
			dbconnection = new DBConnectionTermine();
		}
		return dbconnection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
}

