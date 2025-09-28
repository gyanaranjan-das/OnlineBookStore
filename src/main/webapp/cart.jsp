<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Shopping Cart</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .cart-table { width: 100%; border-collapse: collapse; margin-bottom: 2rem; }
        .cart-table th, .cart-table td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        .cart-table th { background-color: #f2f2f2; }
        .cart-total { text-align: right; font-size: 1.5rem; font-weight: bold; }
    </style>
</head>
<body>


    <main>
        <h2>Your Shopping Cart</h2>

        <c:if test="${empty cartItems}">
            <p>Your shopping cart is empty. <a href="books">Continue Shopping</a></p>
        </c:if>

        <c:if test="${not empty cartItems}">
            <table class="cart-table">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cartItems}" var="item">
                        <tr>
                            <td>${item.getTitle()}</td>
                            <td>$<fmt:formatNumber value="${item.getPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                            <td>${item.getQuantity()}</td>
                            <td>$<fmt:formatNumber value="${item.getSubtotal()}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="cart-total">
                <p>Total: $<fmt:formatNumber value="${totalPrice}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
                <button class="btn" style="width: auto; padding: 12px 20px;">Proceed to Checkout</button>
            </div>
        </c:if>

    </main>
</body>
</html>