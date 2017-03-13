package krivitskiy.servlets;

import krivitskiy.dao.StudentDAOImpl;
import krivitskiy.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Denis on 13.03.2017.
 */
public class StudentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAOImpl dao = new StudentDAOImpl();
        Student student = new Student();

        student.setId(Long.valueOf(request.getParameter("id")));
        student.setName(request.getParameter("name"));
        student.setSurname(request.getParameter("surname"));
        student.setPhoneNumber(request.getParameter("phone"));

        SimpleDateFormat format = new SimpleDateFormat("y-MM-dd");
        Date date = null;
        try {
            date = format.parse(request.getParameter("DOB"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setDateOfBirth(date);

        student.setEmail(request.getParameter("email"));

        try {
            dao.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("HelloPage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAOImpl dao = new StudentDAOImpl();

        try {
            request.setAttribute("student", dao.getStudentById(Long.valueOf(request.getParameter("id"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/student/UpdateStudent.jsp");
        rd.forward(request, response);
    }
}
