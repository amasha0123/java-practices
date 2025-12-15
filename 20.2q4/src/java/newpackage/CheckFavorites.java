
package newpackage;

// CheckFavorites.java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
/**
 *
 * @author gmaha
 */
@WebServlet(name = "CheckFavorites", urlPatterns = {"/CheckFavorites"})
public class CheckFavorites extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String language = request.getParameter("language");
        String ide = request.getParameter("ide");

        if ("Java".equalsIgnoreCase(language) && "NetBeans".equalsIgnoreCase(ide)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Welcome Java Developer!</h2>");
            out.println("<p>Favorite Language: " + language + "</p>");
            out.println("<p>Favorite IDE: " + ide + "</p>");
            out.println("</body></html>");
        } else {
            // If not correct input, return 404 error
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found. Only Java and NetBeans are accepted.");
        }
    
    }


}
