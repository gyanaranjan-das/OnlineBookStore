<%@ taglib uri = "jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Our Books - OnlineBookstore</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <main>
        <h2>Our Book Collection</h2>
        <div class="book-grid">
            
            <c:forEach items="${bookList}" var="book">
                <div class="book-card">
                    <img src="${book.getImageUrl()}" alt="Cover of ${book.getTitle()}">
                    <h3>${book.getTitle()}</h3>
                    <p class="author">by ${book.getAuthor()}</p>
                    <p class="price">$${book.getPrice()}</p>
                    
                    <form action="cart" method="post">
                        <input type="hidden" name="book_id" value="${book.getId()}">
                        <button type="submit" class="btn">Add to Cart</button>
                    </form>
                </div>
            </c:forEach>
            
            <c:if test="${empty bookList}">
                <p>No books are available at the moment. Please check back later!</p>
            </c:if>

        </div>
    </main>
</body>
</html>