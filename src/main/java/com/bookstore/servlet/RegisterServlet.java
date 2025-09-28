package com.bookstore.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // 1. Get the data from the registration form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        // 2. Validate the data (e.g., check if passwords match)
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 3. Create a User object and pass it to the DAO
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password); // In a real app, HASH this password!

        UserDAO userDAO = new UserDAO();
        boolean isRegistered = userDAO.registerUser(newUser);

        // 4. Redirect the user based on the result
        if (isRegistered) {
            // Success: redirect to the login page
            response.sendRedirect("login.jsp");
        } else {
            // Failure: send an error message back to the register page
            request.setAttribute("errorMessage", "Registration failed. Username or email may already exist.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}