package com.bookstore.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.bookstore.dao.UserDAO;
import com.bookstore.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.loginUser(username, password);

        if (user != null) {
            // Login successful: Create a session to "remember" the user
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            
            // Redirect to the home page
            response.sendRedirect("index.jsp");
        } else {
            // Login failed: Send an error message back to the login page
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}