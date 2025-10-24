<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
</head>
<body>
    <%-- Placeholder for dynamic links later --%>
<header>
    <nav>
        <div class="logo">BookLair</div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/books.jsp">Books</a></li>
            <li><a href="${pageContext.request.contextPath}/cart.jsp">Cart</a></li>
            <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/register.jsp">Register</a></li>
            <%-- Add dynamic login/logout links here later using JSTL --%>
        </ul>
    </nav>
</header>
</body>
</html>