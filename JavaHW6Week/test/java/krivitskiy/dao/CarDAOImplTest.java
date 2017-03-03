package krivitskiy.dao;

import krivitskiy.model.Car;
import krivitskiy.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Денис on 01.03.2017.
 */
public class CarDAOImplTest {
    CarDAO carDAO = null;
    Car car = null;
    Session session = null;

    @Before
    public void setUp() {
        carDAO = new CarDAOImpl();
        car = new Car();

        //Добавим информацию
        car.setId(1L);
        car.setMake("Ferrari");
        car.setModel("456");
        car.setIdEngine(3);
        car.setPrice(250000D);
    }

    @Test
    public void testAddCar() throws Exception {
        try {
            //Добавляем в БД
            carDAO.addCar(car);

            session = HibernateUtil.getSessionFactory().openSession();
            //Проверяем, добавилась ли запись и сравниваем с ожидаемым результатом
            Car carTest = session.get(Car.class, car.getId());
            assertEquals("Не совпадают!", car, carTest);

            //Удаляем добавленные данные
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Test
    public void testUpdateCar() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Добавляем в БД
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
            session.close();

            //Меняем данные
            car.setPrice(280000D);

            //Обновляем данные в БД
            carDAO.updateCar(car);

            //Проверяем обновление данных
            //сравниваем два обьекта
            session = HibernateUtil.getSessionFactory().openSession();
            assertEquals("Объекты не совпадают!", car, session.get(Car.class, car.getId()));
            session.close();

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Test
    public void testGetCarById() throws Exception {
        try {
            //добавляем в БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.save(car);
            session.close();

            //получаем из БД по id
            Car carTest = carDAO.getCarById(car.getId());

            assertEquals("объекты не совпали!", car, carTest);

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Test
    public void testDeleteCar() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.save(car);
            session.close();

            //удаляем данные из БД
            carDAO.deleteCar(car);

            //проверяем удалились ли данные из БД
            //совпадения не должно быть
            session = HibernateUtil.getSessionFactory().openSession();
            assertNotEquals("Объекты совпали!", car, session.get(Car.class, car.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @After
    public void cleanData() {
        CarDAO carDAO = null;
        Car car = null;
        Session session = null;
    }
}