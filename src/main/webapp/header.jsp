<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav>
			<div class = "logo">BookLair</div>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="books.jsp">Books</a></li>
				<li><a href="cart.jsp">Cart</a></li>
				
				<c:if test = "${empty sessionScope.loggedInUser}">
					<li><a href = "login.jsp">Login</a></li>
					<li><a href="register.jsp">Register</a></li>
				</c:if>
				
				<c:if test="${not empty sessionScope.loggedInUser}">
                <li><a>Welcome, ${sessionScope.loggedInUser.username}</a></li>
                <li><a href="logout">Logout</a></li>
            	</c:if>
				
			</ul>
		</nav>
	</header>
</body>
</html>