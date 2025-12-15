 package shopping;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "GMAgma2002#");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("products", products);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
