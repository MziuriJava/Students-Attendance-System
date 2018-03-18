package ge.mziuri.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDataBaseConnector {

    public static Connection getConnection() throws Exception {
        PropertiesUtil.PROPERTIES_FILE_PATH = "C:/sas/sas_test.properties";
        Class.forName(PropertiesUtil.getProperty("ConnectorClass_name"));

        String url = PropertiesUtil.getProperty("DataBase_url");
        String username = PropertiesUtil.getProperty("DataBase_username");
        String password = PropertiesUtil.getProperty("DataBase_password");
        return DriverManager.getConnection(url, username, password);
    }
}

