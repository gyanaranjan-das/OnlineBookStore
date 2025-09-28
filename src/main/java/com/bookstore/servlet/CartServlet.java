package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.bookstore.dao.CartDAO;
import com.bookstore.model.CartItem;
import com.bookstore.model.User;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests to display the shopping cart page.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("loggedInUser") : null;

        if (user == null) {
            response.sendRedirect("login.jsp"); // Must be logged in to see cart
            return;
        }

        CartDAO cartDAO = new CartDAO();
        List<CartItem> cartItems = cartDAO.getCartItemsByUserId(user.getId());
        
        double totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getSubtotal();
        }

        request.setAttribute("cartItems", cartItems);
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    /**
     * Handles POST requests to add an item to the shopping cart.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("loggedInUser") : null;
        
        if (user == null) {
            response.sendRedirect("login.jsp"); // Must be logged in to add items
            return;
        }
        
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        int userId = user.getId();
        
        CartDAO cartDAO = new CartDAO();
        cartDAO.addToCart(userId, bookId);
        
        response.sendRedirect("books"); // Redirect back to the book list
    }
}