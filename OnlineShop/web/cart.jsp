<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="shopping.Cart, shopping.Product, java.util.*" %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
%>
<html>
<head><title>Shopping Cart</title></head>
<body>
<h2>Your Cart</h2>
<%
    if (cart == null || cart.getItems().isEmpty()) {
%>
    <p>Your cart is empty.</p>
<%
    } else {
        for (Product p : cart.getItems()) {
%>
        <p><%= p.getName() %> - $<%= p.getPrice() %></p>
<%
        }
%>
        <p>Total: $<%= cart.getTotal() %></p>
        <a href="checkout">Checkout</a>
<%
    }
%>
<a href="products">Back to Products</a>
</body>
</html>
