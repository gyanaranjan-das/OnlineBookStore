package com.bookstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {
	private Connection connection;
	
	public CartDAO() {
		this.connection = DBConnection.getConnection();
	}
	
	public boolean addToCart(int userId, int bookId) {
		String checkSql = "SELECT * FROM carts WHERE user_id=? AND book_id=?";
		try {
			PreparedStatement psCheck = connection.prepareStatement(checkSql);
			psCheck.setInt(1,userId);
			psCheck.setInt(2, bookId);
			ResultSet rs = psCheck.executeQuery();
			
			if(rs.next()) {
				int currentQuantity = rs.getInt("quantity");
				String updateSql = "UPDATE carts SET quantity = ? WHERE user_id = ? AND book_id = ?";
				PreparedStatement psUpdate = connection.prepareStatement(updateSql);
				psUpdate.setInt(1, currentQuantity+1);
				psUpdate.setInt(2, userId);
				psUpdate.setInt(3, bookId);
				return psUpdate.executeUpdate()>0;
			}
			else {
				 String insertSql = "INSERT INTO carts (user_id, book_id, quantity) VALUES (?, ?, 1)";
	                PreparedStatement psInsert = connection.prepareStatement(insertSql);
	                psInsert.setInt(1, userId);
	                psInsert.setInt(2, bookId);
	                return psInsert.executeUpdate() > 0;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
}
