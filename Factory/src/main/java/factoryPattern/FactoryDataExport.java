package factoryPattern;

public class FactoryDataExport {

    public static DataExport getExporter(String className) {

        try {
            Class<?> clazz = Class.forName(className);

            DataExport de = (DataExport) clazz.newInstance();
            return de;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}