package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {

    private Connection connection;
    private static DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        Properties connProperties = new Properties();
        connProperties.put("user", "kodilla_user");
        connProperties.put("password", "kodilla_password");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False&allowPublicKeyRetrieval=true",
                connProperties);
    }

    public static DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null){
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection(){
        return connection;
    }
}
