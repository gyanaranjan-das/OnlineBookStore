package com.bookstore.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bookstore.dao.UserDAO;
import com.bookstore.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletResponse response,HttpsServletRequest request) 
   	throws ServletException,IOException{
	   
	   //1. Get username and password from login form
	   String username = request.getParameter("username");
	   String password = request.getParameter("password");
	   
	   UserDAO userDAO = new UserDAO();
	   User user = userDAO.loginUser(username, password);
	   
	   if(user!=null) {
		   HttpSession session = request.getSession();
		   
		   session.setAttribute("loggedInUser",user);
		   response.sendRedirect("index.jsp");
	   }else {
		   request.setAttribute("error Message","Invalid username or password.");
		   request.getRequestDispatcher("login.jsp").forward(request,response);
	   }
   }

}
