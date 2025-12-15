/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cookies;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

/**
 *
 * @author gmaha
 */
@WebServlet(name = "CreateCookieServlet", urlPatterns = {"/CreateCookieServlet"})
public class CreateCookieServlet extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Create a cookie for username
        Cookie user = new Cookie("username", "admin");
        // Create a cookie for password
        Cookie pass = new Cookie("password", "1234");

        // Set the expiration time for both cookies (120 seconds = 2 minutes)
        user.setMaxAge(120);
        pass.setMaxAge(120);

        // Add the cookies to the response
        response.addCookie(user);
        response.addCookie(pass);

        // Set content type and output message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Cookies Created: username and password (expire in 2 minutes)</h3>");
    }
      
    }

