package factoryPattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonExporter implements DataExport {
	
	private static JsonExporter instance;
	
	public JsonExporter() {
	}
	
	public static JsonExporter getInstance() {
		if (instance == null) {
			instance = new JsonExporter();
		}
		return instance;
	}

	@Override
    public void export(List<String> data, String fileName) {

        StringBuilder json = new StringBuilder();
        json.append("{\n");

        for (int i = 0; i < data.size(); i++) {

            String[] parts = data.get(i).split(":", 2);

            json.append("  \"")
                .append(parts[0])
                .append("\": \"")
                .append(parts[1])
                .append("\"");

            if (i < data.size() - 1) {
                json.append(",");
            }

            json.append("\n");
        }

        json.append("}");

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName, true))) {
            bf.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public String getMime() {
		// TODO Auto-generated method stub
		return "application/json";
	}

}
