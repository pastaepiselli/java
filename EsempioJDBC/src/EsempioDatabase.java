import java.sql.Connection;
import java.sql.DriverManager;

public class EsempioDatabase {
	private Connection con;
	private final String url = "";
	private final String user = "";
	private final String psw = "";
	
	public static void main(String[] args) {
		
	}
	
	private Connection getConnection() {
		if (con == null) {
			Connection c = DriverManager.getConnection(null)
		}
	}
}
