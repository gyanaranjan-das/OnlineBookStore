<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to OnlineBookstore</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <header>
        <nav>
            <div class="logo">BookLair</div>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="books.jsp">Books</a></li>
                <li><a href="cart.jsp">Cart</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="hero">
            <h1>Welcome to Your Personal Bookstore</h1>
            <p>Discover your next great read from our vast collection of books.</p>
        </section>

        <h2>Featured Books</h2>
        <div class="book-grid">
            <div class="book-card">
                <img src="https://via.placeholder.com/150x220.png?text=Book+Cover" alt="Book Title 1">
                <h3>The Midnight Library</h3>
                <p class="author">by Matt Haig</p>
                <p class="price">$15.99</p>
                <button class="btn">Add to Cart</button>
            </div>

            <div class="book-card">
                <img src="https://via.placeholder.com/150x220.png?text=Book+Cover" alt="Book Title 2">
                <h3>Atomic Habits</h3>
                <p class="author">by James Clear</p>
                <p class="price">$18.50</p>
                <button class="btn">Add to Cart</button>
            </div>

            <div class="book-card">
                <img src="https://via.placeholder.com/150x220.png?text=Book+Cover" alt="Book Title 3">
                <h3>Project Hail Mary</h3>
                <p class="author">by Andy Weir</p>
                <p class="price">$22.00</p>
                <button class="btn">Add to Cart</button>
            </div>

            <div class="book-card">
                <img src="https://via.placeholder.com/150x220.png?text=Book+Cover" alt="Book Title 4">
                <h3>Dune</h3>
                <p class="author">by Frank Herbert</p>
                <p class="price">$12.75</p>
                <button class="btn">Add to Cart</button>
            </div>
        </div>
    </main>

    <footer>
        <p>&copy; 2025 OnlineBookstore. All Rights Reserved.</p>
    </footer>

</body>
</html>