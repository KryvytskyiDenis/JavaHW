package krivitskiy.dao;

import krivitskiy.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Denis on 11.03.2017.
 */
public interface StudentDAO {
    void addStudent(Student user) throws SQLException;
    void updateStudent(Student user) throws SQLException;
    void deleteStudent(Student user) throws SQLException;
    List<Student> getAllStudents() throws SQLException;
}
