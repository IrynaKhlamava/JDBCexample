package com.company.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/hotel?autoReconnect=true&useSSL=false";
    private static final String NAME = "root";
    private static final String PASSWORD = "1111";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connector instance;

    private Connection connection;

    private Connector() {
        connect();
    }

    public static Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
