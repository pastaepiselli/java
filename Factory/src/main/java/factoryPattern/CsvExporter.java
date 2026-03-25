package factoryPattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter implements DataExport {
	
	private static CsvExporter instance;
	
	public CsvExporter(){
	}
	
	public static CsvExporter getInstance() {
		if (instance == null) {
			instance = new CsvExporter();
		}
		return instance;
	}

	@Override
	public void export(List<String> data, String fileName) {
		String stringaFinale = "";
		for (String string : data) {
			stringaFinale += string + ", \n";
		}
		
		// scrittura in file
		try {
			BufferedWriter bf = 
					new BufferedWriter(new FileWriter("csvfile.txt", true));
			bf.write(stringaFinale);
			bf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getMime() {
		return "txt/cvs";
	}

}
