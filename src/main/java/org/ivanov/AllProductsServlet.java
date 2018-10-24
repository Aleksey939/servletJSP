package org.ivanov;

import com.mysql.jdbc.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/all_products")
public class AllProductsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do POST ALL ");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do GET All ");
        String connectionString = "jdbc:mysql://localhost:3306" +
                "?characterEncoding=UTF-8" +
                "&useUnicode=true" +
                //"&useJDBCCompliantTimezoneShift=true" +
                //"&useLegacyDatetimeCode=false" +
                "&serverTimezone=Europe/Kiev";

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(connectionString,"root","");
            statement = (Statement) connection.createStatement();
            statement.executeQuery("USE Products");
            ResultSet resultSet = statement.executeQuery("SELECT * from products");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString("Name"));
                System.out.println(resultSet.getString("Description"));
                System.out.println(resultSet.getInt("Price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/all_products.jsp").forward(req,resp);
    }
}
