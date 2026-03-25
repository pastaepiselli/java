package factoryPattern;

public class Setting {

    public static void main(String[] args) {
        String exporterClass = "factoryPattern.CsvExporter";
        Statistiche stats = new Statistiche(exporterClass);
        stats.exportCategory();
   
    }
}