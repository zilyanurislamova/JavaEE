package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee",
                    "postgres", "postgres");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title FROM books");

            printWriter.println("<html>");
            while (resultSet.next()) {
                printWriter.println("<h2>" + resultSet.getString("title") + "</h2>");
            }
            printWriter.println("</html>");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
