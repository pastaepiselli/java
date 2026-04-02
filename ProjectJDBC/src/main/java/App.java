import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class App {
	private static final String url = "jdbc:postgresql://localhost:5432/valorant";
	private static final String user = "postgres";
	private static final String passw = "postgres";
	public static void main(String[] args) throws SQLException {
		/* per connettermi al db utilizzo il metodo statico getConnection() di DriverManager
		 * questo metodo ritorna un interfaccia connection
		 */
		
		
		Connection connection = DriverManager.getConnection(url, user, passw);
		
		/*
		 * ora che ho la connection (sessione di dialogo con il db)
		 * posso preparare le query, creare Statement
		 */
		
		Statement statement = connection.createStatement();
		
	
		
		/*
		 * con l'interfaccia statement posso eseguire query
		 */
		
		// executeUpdate() utilizzato per DELETE, INSERT, UPDATE
//		String querySql = "insert into valorant "
//				+ "(enemy_team, my_team, agent, kill, death, assist, mappa, some1_afk, id)"
//				+ "values("
//				+ "array['clove', 'fade', 'phoenix', 'sage', 'reyna'],"
//				+ "array['vyse', 'miks', 'reyna', 'iso', 'skye'],"
//				+ "'skye',"
//				+ "5, 9, 5, 'Pearl', false, 1)";
//		
//		
//		statement.executeUpdate(querySql);
		
		/* executeQuery() utilizzato per select
		 * restituisce un oggetto ResultSet, un cursore per navigare la tabella ritornata
		 */
		
		String querySql = "select * from valorant";
		
		
		ResultSet rs = statement.executeQuery(querySql);
		
//		while (rs.next()) {
//			System.out.println(rs.getArray("enemy_team"));
//			System.out.println(rs.getArray("my_team"));
//			
//		}
		
		/*
		 * con PreparedStatement viene inviato lo scheletro della query  con'?' 
		 * es. select agente from valorant where agente = ?;
		 * 1) evita sql injection
		 * 2) evita concatenazione manuale di java con + o 
		 */
		String querySql1 = "select id from valorant where agent = ?";
		
		PreparedStatement ps = connection.prepareStatement(querySql1);
		ps.setString(1, "jett");
		ResultSet rs1 = ps.executeQuery();
		
		while (rs1.next()) {
			System.out.println(rs1.getInt("id"));
		}
		
	
		
		
		
		
		
	}
}
