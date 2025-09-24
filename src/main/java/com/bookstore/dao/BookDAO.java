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
		List<Book> books
	}
}
