<%-- 
    Document   : registerStudent
    Created on : May 9, 2025, 9:22:10 AM
    Author     : gmaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register as Student</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Student Registration</h2>
    <form action="RegisterServlet" method="post" onsubmit="return validateRegisterForm()">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        Role: <input type="role" name="role" required><br>
        
       
        <input type="hidden" name="role" value="Student">
        <input type="submit" value="Register">
    </form>
    <script src="js/validations.js"></script>
</body>
</html>
