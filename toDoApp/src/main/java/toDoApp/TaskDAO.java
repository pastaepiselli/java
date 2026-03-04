package toDoApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
	
	
	public static List<TaskDTO> findAllTasks(){
		String selectSql = "select id, task, done from task";
		
		ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();
		Connection conn = null;
		try {
			// ottengo connessione
			conn = Database.getConnection();
			PreparedStatement psSelectAll = conn.prepareStatement(selectSql);
			
			ResultSet rs = psSelectAll.executeQuery();
			
			while(rs.next()) {
				TaskDTO l = new TaskDTO(rs.getInt("id"),
						rs.getString("task"), 
						rs.getBoolean("done"));
				tasks.add(l);
				
				
			} 
		} catch (SQLException e) {
			System.out.println("Errore nella lettura dei libri " + e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tasks;
		
	}
	public boolean insertTask(TaskDTO t) {
		int chiave = -1;

		// creo la query sql
		String insertSql = "Insert into task(task) values (?)";
		
		Connection conn = null;

		try {
			// ottengo la connessione ad db
			conn = Database.getConnection();

			// preparo la query
			PreparedStatement psInsert = conn.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS);
			psInsert.setString(1, t.getTask());

			int righe = psInsert.executeUpdate();

			// se non fa righe (non inserito) va in eccezione
			if (righe == 0) {
				throw new SQLException("Non è ststa inserita nessuna riga");
			}
			// questo ottiene tutte le chiavi inserite da serial nel db
			try (ResultSet keys = psInsert.getGeneratedKeys()) {
				if (keys.next()) {
					System.out.println("Id task " + keys.getInt(1));
					chiave = keys.getInt(1);
					t.setId(chiave);
					return true;
				}
			}
			throw new SQLException("Non ho recuperato l'id");
				
		} catch (SQLException e) {
//			System.out.println("Errore nell'inserimento");
			e.printStackTrace();
			return false;

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
