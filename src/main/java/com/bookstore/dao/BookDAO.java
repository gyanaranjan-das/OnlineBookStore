package com.bookstore.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bookstore.model.Book;
public class BookDAO {
	private Connection connection;
	
	public BookDAO() {
		this.connection=DBConnection.getConnection();
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		String sql = "SELECT * FROM books";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setImageUrl(rs.getString("image_url"));
				book.setDescription(rs.getString("description"));
				book.setStock(rs.getInt("stock"));
				books.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
		public Book getBookById(int id) {
	        Book book = null;
	        String sql = "SELECT * FROM books WHERE id = ?";

	        try {
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                book = new Book();
	                book.setId(rs.getInt("id"));
	                book.setTitle(rs.getString("title"));
	                book.setAuthor(rs.getString("author"));
	                book.setPrice(rs.getDouble("price"));
	                book.setImageUrl(rs.getString("image_url"));
	                book.setDescription(rs.getString("description"));
	                book.setStock(rs.getInt("stock"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return book;
	    }
	}

