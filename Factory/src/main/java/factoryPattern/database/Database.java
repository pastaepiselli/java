package factoryPattern.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static final String url = "jdbc:postgresql://localhost:5432/factoryPattern";
	private static final String user = "postgres";
	private static final String psw = "postgres";
	
	// metodo statico che ottiene la connessione al database
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, psw);
	}
}
