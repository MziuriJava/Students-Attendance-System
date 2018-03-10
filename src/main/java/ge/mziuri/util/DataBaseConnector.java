package ge.mziuri.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnector {


        public static Connection getConnection() throws Exception {

            Class.forName(PropertiesUtil.getProperty("ConnectorClass_name"));

            return DriverManager.getConnection(DataBaseUtil.url, DataBaseUtil.username, DataBaseUtil.password);

        }

    }

