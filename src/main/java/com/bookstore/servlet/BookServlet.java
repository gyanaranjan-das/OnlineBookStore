package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/books")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		// 1. Create a BookDAO instance
        BookDAO bookDAO = new BookDAO();
        
        // 2. Get the list of all books from the DAO
        List<Book> bookList = bookDAO.getAllBooks();
        
        // 3. Set the book list as an attribute in the request
        request.setAttribute("bookList", bookList);
        
        // 4. Forward the request to the books.jsp page for display
        request.getRequestDispatcher("books.jsp").forward(request, response);
	}
}
