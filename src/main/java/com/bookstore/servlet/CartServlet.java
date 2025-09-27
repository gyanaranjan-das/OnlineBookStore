package com.bookstore.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;

import com.bookstore.dao.CartDAO;
import com.bookstore.model.User;

/**
  implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    HttpSession session = request.getSession(false);
	    User user = (session != null) ? (User) session.getAttribute("loggedInUser") : null;

	    if (user == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    CartDAO cartDAO = new CartDAO();
	    List<CartItem> cartItems = cartDAO.getCartItemsByUserId(user.getId());
	    
	    // Calculate total price
	    double totalPrice = 0;
	    for (CartItem item : cartItems) {
	        totalPrice += item.getSubtotal();
	    }

	    request.setAttribute("cartItems", cartItems);
	    request.setAttribute("totalPrice", totalPrice);
	    request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException{
    	
    	HttpSession session = request.getSession(false);
    	User user = (session != null) ? (User) seesion.getAttribute("loggedInUser"):null;
    	
    	if (user==null) {
    		response.sendRedirect("login.jsp");
    		return;
    	}
    	
    	int bookId = Integer.parseInt(request.getParameter("book_id"));
    	int userId = user.getId();
    	
    	CartDAO cartDAO = new CartDAO();
    	cartDAO.addToCart(userId, bookId);
    	
    	response.sendRedirect("books");
    }
}
