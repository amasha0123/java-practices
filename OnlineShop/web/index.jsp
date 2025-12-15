<%-- 
    Document   : index
    Created on : Apr 29, 2025, 9:49:06 PM
    Author     : gmaha
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, shopping.Product" %>
<html>
<head><title>Online Shop</title></head>
<body>
<h2>Product List</h2>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product p : products) {
%>
    <form method="post" action="add-to-cart">
        <%= p.getName() %> - $<%= p.getPrice() %>
        <input type="hidden" name="id" value="<%= p.getId() %>"/>
        <button type="submit">Add to Cart</button>
    </form><br/>
<% } %>
<a href="cart.jsp">View Cart</a>
</body>
</html>
