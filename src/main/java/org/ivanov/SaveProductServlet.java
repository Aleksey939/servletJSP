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

@WebServlet("/")
public class SaveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do GET ");
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do POST Save ");
        String connectionString = "jdbc:mysql://localhost:3306/" +
                "?characterEncoding=UTF-8" +
                "&useUnicode=true" +
                //"&useJDBCCompliantTimezoneShift=true" +
                //"&useLegacyDatetimeCode=false" +
                "&serverTimezone=Europe/Kiev";

        Connection connection = null;
        Statement statement = null;
        String name = req.getParameter("name");
        String  desc= req.getParameter("desc");
        Double price = (Double.parseDouble(req.getParameter("price")));
        try {
            connection = DriverManager.getConnection(connectionString,"root","");
            statement = (Statement) connection.createStatement();
            statement.execute("use Products");
            statement.execute("INSERT INTO products (Name, Description,Price ) VALUES ('"+name+"','desc',10)");

            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
           // resp.sendRedirect("/WEB-INF/index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();

        }
        finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            }

    }
}
