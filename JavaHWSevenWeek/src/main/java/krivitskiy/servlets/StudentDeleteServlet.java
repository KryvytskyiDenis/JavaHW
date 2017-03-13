package krivitskiy.servlets;

import krivitskiy.dao.StudentDAOImpl;
import krivitskiy.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Denis on 13.03.2017.
 */
public class StudentDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAOImpl dao = new StudentDAOImpl();
        Student student = new Student();
        student.setId(Long.valueOf(request.getParameter("id")));

        try {
            dao.deleteStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("HelloPage.jsp");
    }
}
