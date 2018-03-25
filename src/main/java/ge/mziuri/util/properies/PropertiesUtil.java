package ge.mziuri.util.properies;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static String PROPERTIES_FILE_PATH = "C:/sas/sas.properties";

    private static Properties properties;

    public static String getProperty(String key) {
        if (properties == null) {
            try {
                File file = new File(PROPERTIES_FILE_PATH);
                FileInputStream fileInput = new FileInputStream(file);
                properties = new Properties();
                properties.load(fileInput);
                fileInput.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}
