/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cookies;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Date;

/**
 *
 * @author gmaha
 */
@WebServlet(name = "AutoRefreshServlet", urlPatterns = {"/AutoRefreshServlet"})
public class AutoRefreshServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // Set refresh header to auto-refresh page every 5 seconds
        response.setIntHeader("Refresh", 5);

        // Set content type to HTML
        response.setContentType("text/html");

        // Get writer to print output
        PrintWriter out = response.getWriter();

        // Print current date and time
        out.println("<h3>Current Time: " + new Date() + "</h3>");
    
    }
}
