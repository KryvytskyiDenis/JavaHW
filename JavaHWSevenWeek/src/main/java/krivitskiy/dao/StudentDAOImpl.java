package krivitskiy.dao;

import krivitskiy.model.Student;
import krivitskiy.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 11.03.2017.
 */
public class StudentDAOImpl implements StudentDAO {
    public void addStudent(Student student) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void updateStudent(Student student) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public Student getStudentById(long student_id) throws SQLException{
        Session session = null;
        Student student = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            student = session.get(Student.class, student_id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    public List<Student> getAllStudents() throws SQLException {
        Session session = null;
        List<Student> students = new ArrayList<Student>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            students = session.createCriteria(Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return students;
    }

    public void deleteStudent(Student student) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
