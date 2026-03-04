package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

	public static List<LibroDTO> findAll() throws SQLException{

		// select con order by id
		String sqlSelect = "select id, titolo, autore, prezzo from libro order by id";
		List<LibroDTO> libri = new ArrayList<>();
		Connection conn = null;

		try {conn = Database.getConnection();
		// viene preparata la query
		PreparedStatement psInsert = conn.prepareStatement(sqlSelect);
		
		// esegue la query
		ResultSet rs = psInsert.executeQuery();
		while(rs.next()) {
			// per ogni riga istanzia un libro
			LibroDTO l = new LibroDTO(rs.getInt("id"), 
					rs.getString("titolo"),
					rs.getString("autore"), 
					rs.getDouble("prezzo"));
			
			// e lo aggiunge a libri
			libri.add(l);
			
		}

		} catch(SQLException e) {
			System.out.println("Errore nella lettura dei libri " + e.getMessage());
		} finally {
			if (conn != null) { // alla fine se la connessone e stata apert
				conn.close(); // viene chiusa
			}
		}
		return libri;
	}

	public boolean insert(LibroDTO l) {

		int chiave = -1;

		// creiamo insert
		String insertSql = "Insert into libro (titolo,autore,prezzo) values(?,?,?)";
		try (Connection conn = Database.getConnection(); // prendiamo connessione
				PreparedStatement psInsert = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
			psInsert.setString(1, l.getTitolo()); // posizone + value
			psInsert.setString(2, l.getAutore());
			psInsert.setDouble(3, l.getPrezzo());
			int righe = psInsert.executeUpdate();

			// se non fa righe (non inserito) va in eccezione
			if (righe == 0) {
				throw new SQLException("Non è ststa inserita nessuna riga");
			}


			try (ResultSet keys = psInsert.getGeneratedKeys()) {
				if (keys.next()) {
					System.out.println("Id libro " + keys.getInt(1));
					chiave = keys.getInt(1);
					l.setId(chiave);
					return true;
				}
			}
			throw new SQLException("Non ho recuperato l'id");

		} catch (SQLException e) {
			System.out.println("Errore nell'inserimento");
			return false;

		}
	}
}
