package krivitskiy.dao;

import krivitskiy.model.*;
import krivitskiy.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Денис on 01.03.2017.
 */
public class ServiceStationImplTest {
    ServiceStationsDAO serviceStationsDAO = null;
    ServiceStation serviceStation = null;
    Car car = null;
    Session session = null;

    @Before
    public void setUp() {
        serviceStationsDAO = new ServiceStationsDAOImpl();
        serviceStation = new ServiceStation();

        //Добавим информацию
        serviceStation.setId(1L);
        serviceStation.setAddress("Шевченка 10");
        Set<Car> cars = new HashSet<>();
        car = new Car();
        car.setId(1L);
        cars.add(car);
        serviceStation.setCars(cars);
    }

    @After
    public void cleanData() {
        ServiceStationsDAO serviceStationsDAO = null;
        ServiceStation serviceStation = null;
        Car car = null;
        Session session = null;
    }

    @Test
    public void testAddServiceStation() throws Exception {
        try {
            //Добавляем в БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
            session.close();

            //Добавляем запись в БД
            serviceStationsDAO.addServiceStation(serviceStation);

            //Проверяем, добавилась ли запись
            session = HibernateUtil.getSessionFactory().openSession();
            //сравниваем два обьекта
            ServiceStation serviceStationTest = session.get(ServiceStation.class, serviceStation.getId());
            assertEquals("Не совпадают!", serviceStation, serviceStationTest);
            session.close();

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.delete(serviceStation);
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
    public void testUpdateServiceStation() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Добавляем в БД
            session.beginTransaction();
            session.save(car);
            session.save(serviceStation);
            session.getTransaction().commit();
            session.close();

            //Меняем данные
            serviceStation.setAddress("Гоголя 34");

            //Обновляем данные в БД
            serviceStationsDAO.updateServiceStation(serviceStation);

            //Проверяем обновление данных
            //сравниваем два обьекта
            session = HibernateUtil.getSessionFactory().openSession();
            assertEquals("Объекты не совпадают!", serviceStation, session.get(ServiceStation.class, serviceStation.getId()));
            session.close();

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.delete(serviceStation);
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
    public void testGetServiceStationById() throws Exception {
        try {
            //добавляем в БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.save(serviceStation);
            session.getTransaction().commit();
            session.close();

            //получаем из БД по id
            ServiceStation serviceStationTest = serviceStationsDAO.getServiceStationById(serviceStation.getId());

            assertEquals("объекты не совпали!", serviceStation, serviceStationTest);

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.delete(serviceStation);
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
    public void testDeleteServiceStation() throws Exception {
        try {
            //добавляем в БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.save(serviceStation);
            session.getTransaction().commit();
            session.close();

            //удаляем данные из БД
            serviceStationsDAO.deleteServiceStation(serviceStation);

            //проверяем удалились ли данные из БД
            //совпадения не должно быть
            session = HibernateUtil.getSessionFactory().openSession();
            assertNotEquals("Объекты совпали!", serviceStation, session.get(ServiceStation.class, serviceStation.getId()));
            session.close();

            //Удаляем запись из БД
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