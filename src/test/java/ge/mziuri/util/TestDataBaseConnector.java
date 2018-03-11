package ge.mziuri.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDataBaseConnector {

        public static Connection getConnection() throws Exception {
            Class.forName(PropertiesUtil.getProperty("ConnectorClass_name"));
            return DriverManager.getConnection(TestDataBaseUtil.url, TestDataBaseUtil.username, TestDataBaseUtil.password);
        }
    }

