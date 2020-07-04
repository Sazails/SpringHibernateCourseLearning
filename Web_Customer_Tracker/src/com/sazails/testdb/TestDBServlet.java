package com.sazails.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "TestDBServlet")
public class TestDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "springuser";
        String password = "springuser";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // Connect to database
        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to: " + jdbcUrl);

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            out.println("Connected");

            connection.close();
            out.println("Disconnected");
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
