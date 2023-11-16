package com.sql.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Properties;
import java.io.File;
import java.sql.ResultSet;
public class Utils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("information.properties"));
            user = properties.getProperty(user);
            password = properties.getProperty(password);
            url = properties.getProperty(url);
            driver = properties.getProperty(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws Exception {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

