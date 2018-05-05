package ge.mziuri.util.db;

import ge.mziuri.util.properies.PropertiesUtil;

public class DataBaseUtil {

    private static final String DATABASE_URL_KEY = "DataBase_url";

    private static final String DATABASE_USERNAME_KEY = "DataBase_username";

    private static final String DATABASE_PASSWORD_KEY = "DataBase_password";

    public static final String url = PropertiesUtil.getProperty(DATABASE_URL_KEY);

    public static final String username = PropertiesUtil.getProperty(DATABASE_USERNAME_KEY);

    public static final String password = PropertiesUtil.getProperty(DATABASE_PASSWORD_KEY);
}

