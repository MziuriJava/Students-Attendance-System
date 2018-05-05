package ge.mziuri.util.db;

import ge.mziuri.util.properies.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {

    private static final String CONNECTOR_CLASS_NAME_KEY = "ConnectorClass_name";

    public static Connection getConnection() throws Exception {
        Class.forName(PropertiesUtil.getProperty(CONNECTOR_CLASS_NAME_KEY));
        return DriverManager.getConnection(DataBaseUtil.url, DataBaseUtil.username, DataBaseUtil.password);
    }
}

