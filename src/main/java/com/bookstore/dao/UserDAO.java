package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bookstore.model.User;

public class UserDAO {

    private Connection connection;

    // The constructor gets a database connection from our DBConnection class
    public UserDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Saves a new user to the database.
     * @param user The User object with registration details.
     * @return true if registration is successful, false otherwise.
     */
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try {
            // Use PreparedStatement to prevent SQL injection
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            // In a real app, you MUST HASH the password before saving!
            ps.setString(3, user.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks user credentials against the database.
     * @param username The username to check.
     * @param password The password to check.
     * @return A populated User object if credentials are correct, otherwise null.
     */
    public User loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        User user = null;
        
        // --- SECURITY WARNING ---
        // Storing and checking plain text passwords is a major security risk.
        // In a real-world application, you would compare password hashes here.

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}