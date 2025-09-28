package com.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // --- IMPORTANT: Replace with your own database details ---
    private static final String URL = "jdbc:mysql://localhost:3306/online_bookstore";
    private static final String USER = "your_mysql_username"; // e.g., "root"
    private static final String PASSWORD = "your_mysql_password";
    
    private static Connection connection = null;

    /**
     * Creates and returns a single, reusable connection to the database.
     * @return A Connection object.
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // 1. Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // 2. Establish the connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);

            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Failed to connect to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }
}