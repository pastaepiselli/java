package factoryPattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factoryPattern.database.Database;


public class Statistiche {

    private DataExport exporter;

    public Statistiche(String exporter) {
        this.exporter = FactoryDataExport.getExporter(exporter);
    }

    public void exportCategory() {
    	
    	String sql = "select idcategory, description from category";
    	List<String> data = new ArrayList<String>();
    	
    	try (Connection conn = Database.getConnection();
    			PreparedStatement ps = conn.prepareStatement(sql);
    			ResultSet rs = ps.executeQuery();){
    		while (rs.next()) {
    			data.add("ID:" + rs.getInt("idcategory") + ", Description: " + rs.getString("description"));
    			
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	exporter.export(data, "esportazione.txt");

        
    }

    public void exportCity() {

        List<String> data = new ArrayList<>();
        data.add("City:Roma");
        data.add("Region:Lazio");

        exporter.export(data, "city.txt");
    }
}