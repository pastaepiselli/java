import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import database.LibroDAO;
import database.LibroDTO;

public class App {
	public Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// tipo db + porta + database dove vuoi conneterti
		final String url = "jdbc:postgresql://localhost:5432/biblioteca";
		final String user = "postgres";
		final String psw = "postgres";

		// connettiamo al db

		LibroDAO libroDao = new LibroDAO();
//		LibroDTO libro1 = new LibroDTO("Informatica per tutti", "Rob del", 9.99);
//		boolean ok = libroDao.insert(libro1);
//		if (ok) {
//			System.out.println("Libro inserito con id: "+ libro1.getId());
//			
//		}else {
//			System.out.println("Libro non inserito");
//		}
		
		stampaLibri();
		
	


		// creo la query
		//			String insertSql = "Insert into libro(titolo, autore, prezzo) values(?, ?, ?)";
		//			try (PreparedStatement psInsert=conn.prepareStatement(insertSql)){
		//				
		//				// imposto i valori
		//				psInsert.setString(1, "La Bibbia");
		//				psInsert.setString(2, "Sconosciuto");
		//				psInsert.setDouble(3, 40);
		//				
		//				// esegui query 
		//				int righe = psInsert.executeUpdate(); // mi salvo le righe aggiunte
		//				System.out.println("Ho inserito " + righe + " righe");
		//			}
		//			
		// select

		//			String selectSql = "select id, titolo, autore, prezzo from libro"; 
		//			try (PreparedStatement psSelect=conn.prepareStatement(selectSql)){
		//				// result set sarebbe il tipo di dato della tabella
		//				ResultSet rs = psSelect.executeQuery();
		//				
		//				System.out.println("------- Lista Libri --------");
		//				while(rs.next()) {
		//					int id = rs.getInt("id");
		//					String titolo = rs.getString("titolo");
		//					String autore = rs.getString("autore");
		//					double prezzo = rs.getDouble("prezzo");
		//					
		//					System.out.println(id + "-" + titolo + "-" + autore + "-" + prezzo);
		//				}
		//				
		//				
		//			}
		//			insertLibroDb(conn, "La bibbia 2", "Sconosciuto", 50);
		//			selectLibri(conn);
		//			
		//			conn.close();

	}
	
	public static void stampaLibri() {
		try {
			List<LibroDTO> libri = LibroDAO.findAll();
			
			if (libri.isEmpty()) {
				System.out.println("Nessun libro inserito");
			} else {
				for (LibroDTO l : libri) {
					 System.out.println(l);
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	// funzione inserimento
	static void insertLibroDb(Connection conn, String titolo, String autore, double prezzo) throws SQLException { // passo la connessione
		String insertSql = "insert into libro(titolo, autore, prezzo) values (?, ?, ?)";


		PreparedStatement psInsert=conn.prepareStatement(insertSql);
		// imposto i valori
		psInsert.setString(1, titolo);
		psInsert.setString(2, autore);
		psInsert.setDouble(3, prezzo);

		// esegui query 
		int righe = psInsert.executeUpdate(); // mi salvo le righe aggiunte
		System.out.println("Ho inserito " + righe + " righe");


	}

	static void selectLibri(Connection conn) throws SQLException {
		String selectLibri = "select id, titolo, autore, prezzo from libro";

		PreparedStatement psSelect = conn.prepareStatement(selectLibri);

		ResultSet rs = psSelect.executeQuery();
		while (rs.next()) { // finche rs ha un valore successivo
			int id = rs.getInt("id");
			String titolo = rs.getString("titolo");
			String autore = rs.getString("autore");
			double prezzo = rs.getDouble("prezzo");

			System.out.println(id + "-" + titolo + "-" + autore + "-" + prezzo);

		}
	} 

	static void deleteLibro() {

	}

}
