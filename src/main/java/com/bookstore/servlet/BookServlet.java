package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get the list of all books from the DAO
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getAllBooks();
        
        // 2. Set the list as an attribute in the request
        request.setAttribute("bookList", bookList);
        
        // 3. Forward the request to the JSP page for display
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}