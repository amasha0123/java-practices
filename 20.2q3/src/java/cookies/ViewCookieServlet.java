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
@WebServlet(name = "ViewCookieServlet", urlPatterns = {"/ViewCookieServlet"})
public class ViewCookieServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        // Retrieve cookies sent by the browser
        Cookie[] cookies = request.getCookies();

        // Set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if cookies exist
        if (cookies != null) {
            out.println("<h3>Cookies Found:</h3>");
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
            }
        } else {
            out.println("<h3>No Cookies Found</h3>");
        }
    }
        
        
    }

  

