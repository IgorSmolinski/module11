package com.igor.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private Connection conn;
    private static DBManager dbManagerInstance;

    private DBManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "szmata5");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/first?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }


    public static DBManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DBManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}