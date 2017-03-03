package krivitskiy.dao;

import krivitskiy.model.Car;
import krivitskiy.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by Денис on 28.02.2017.
 */
public class CarDAOImpl implements CarDAO {
    @Override
    public void addCar(Car car) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public void updateCar(Car car) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public Car getCarById(long car_id) throws SQLException {
        Session session = null;
        Car car = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            car = (Car) session.get(Car.class, car_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return car;
    }

    @Override
    public void deleteCar(Car car) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }
}
