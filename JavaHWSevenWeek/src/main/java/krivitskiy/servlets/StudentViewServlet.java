package krivitskiy.servlets;

import krivitskiy.dao.StudentDAOImpl;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Denis on 11.03.2017.
 */
public class StudentViewServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StudentDAOImpl dao = new StudentDAOImpl();

        try {
            request.setAttribute("students", dao.getAllStudents());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/student/ViewStudent.jsp");
        rd.forward(request,response);
    }
}
