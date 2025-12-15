 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <label>Email:</label>
        <input type="email" name="email" required><br><br>
        <label>Password:</label>
        <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">
            <% if (request.getParameter("error").equals("invalidcredentials")) { %>
                Invalid email or password.
            <% } else if (request.getParameter("error").equals("invalidrole")) { %>
                Invalid user role.
            <% } %>
        </p>
    <% } %>
</body>
</html>
