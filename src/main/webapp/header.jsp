<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
    <nav>
        <div class="logo">BookLair</div>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="books">Books</a></li>
            <li><a href="cart">Cart</a></li>
            
            <c:if test="${empty sessionScope.loggedInUser}">
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </c:if>

            <c:if test="${not empty sessionScope.loggedInUser}">
                <li><a>Welcome, ${sessionScope.loggedInUser.username}</a></li>
                <li><a href="logout">Logout</a></li>
            </c:if>
        </ul>
    </nav>
</header>