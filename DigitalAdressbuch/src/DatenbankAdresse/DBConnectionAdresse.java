package DatenbankAdresse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionAdresse {

	private static DBConnectionAdresse dbconnection = null;

	private final String dbURL = "jdbc:mysql://localhost:3306/adressbuch";
	private final String dbUser = "root";		/*Hier werden die URL, der User und das Passwort des Users definiert*/
	private final String dbPW = "1234";

	private Connection connection = null;	

	private DBConnectionAdresse() {
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

	public static DBConnectionAdresse getInstance() {
		if (dbconnection == null) {
			dbconnection = new DBConnectionAdresse();
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
