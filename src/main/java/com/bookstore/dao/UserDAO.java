package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bookstore.model.User;

public class UserDAO {
	
	private Connection connection;
	
	//constructor to get db connection
	public UserDAO() {
		this.connection = DBConnection.getConnection();
	}
	
	public boolean registerUser(User user) {
		String sql = "INSERT INTO users (username, email, password) VALUES(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2,user.getEmail());
			ps.setString(3, user.getPassword());
			
			int rowsAffected=ps.executeUpdate();
			return rowsAffected > 0;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
				
	}
	
	public User loginUser(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		User user = null;
		
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
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
