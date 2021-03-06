package DatenbankPerson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DatenbankPerson.DBConnection;

public class DBConnection {

	private static DBConnection dbconnection = null;

	private final String dbURL = "jdbc:mysql://localhost:3306/adressbuch";
	private final String dbUser = "root";
	private final String dbPW = "1234";

	private Connection connection = null;

	private DBConnection() {
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

	public static DBConnection getInstance() {
		if (dbconnection == null) {
			dbconnection = new DBConnection();
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

