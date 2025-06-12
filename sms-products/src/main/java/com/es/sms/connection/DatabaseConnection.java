package com.es.sms.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sms_prod_mod";
    private static final String USER = "root"; //  database username
    private static final String PASSWORD = "Sa123"; //database password

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

