package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bookstore.model.CartItem;

public class CartDAO {

    private Connection connection;

    public CartDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Adds a book to a user's cart or increments its quantity if it already exists.
     */
    public boolean addToCart(int userId, int bookId) {
        String checkSql = "SELECT * FROM carts WHERE user_id = ? AND book_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(checkSql);
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Item exists, so update the quantity
                String updateSql = "UPDATE carts SET quantity = quantity + 1 WHERE user_id = ? AND book_id = ?";
                ps = connection.prepareStatement(updateSql);
                ps.setInt(1, userId);
                ps.setInt(2, bookId);
                return ps.executeUpdate() > 0;
            } else {
                // Item is new, so insert it
                String insertSql = "INSERT INTO carts (user_id, book_id, quantity) VALUES (?, ?, 1)";
                ps = connection.prepareStatement(insertSql);
                ps.setInt(1, userId);
                ps.setInt(2, bookId);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Fetches all items in a user's cart, joining with the books table to get details.
     */
    public List<CartItem> getCartItemsByUserId(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        String sql = "SELECT b.id, b.title, b.price, b.image_url, c.quantity " +
                     "FROM carts c JOIN books b ON c.book_id = b.id " +
                     "WHERE c.user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem();
                item.setBookId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setPrice(rs.getDouble("price"));
                item.setImageUrl(rs.getString("image_url"));
                item.setQuantity(rs.getInt("quantity"));
                cartItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }
}