package krivitskiy.servlets;

import krivitskiy.dao.StudentDAOImpl;
import krivitskiy.model.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Denis on 11.03.2017.
 */
public class StudentCreateServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        Student student = new Student();

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
            studentDAO.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("AddSuccess.html");
    }
}
