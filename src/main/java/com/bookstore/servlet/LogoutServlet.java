package com.bookstore.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get the current session
        HttpSession session = request.getSession(false); // false means do not create a new session
        
        // 2. Invalidate the session if it exists
        if (session != null) {
            session.invalidate();
        }
        
        // 3. Redirect the user to the home page
        response.sendRedirect("index.jsp");
    }
}