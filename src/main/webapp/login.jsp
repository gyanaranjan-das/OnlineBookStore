<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login - OnlineBookstore</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="login-container">
        <h2>User Login</h2>
        
        <%-- <c:if test="${not empty errorMessage}"><p class="error-message">${errorMessage}</p></c:if> --%>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit" class="login-button">Login</button>
        </form>
        
        <p class="register-link">
            Don't have an account? <a href="register.jsp">Register here</a>
        </p>
    </div>
</body>
</html>