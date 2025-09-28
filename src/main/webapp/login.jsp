<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login - OnlineBookstore</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@ include file = "header.jsp" %>

    <main>
        <div class="form-container">
            <h2>User Login</h2>
            
            <form action="login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>
                </div>
                
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                
                <button type="submit" class="btn">Login</button>
            </form>
            
            <p style="text-align: center; margin-top: 1rem;">
                Don't have an account? <a href="register.jsp">Register here</a>
            </p>
        </div>
    </main>
</body>
</html>