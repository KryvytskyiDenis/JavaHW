package krivitskiy.dao;

import krivitskiy.model.*;
import krivitskiy.model.ServiceStation;
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
public class MechanicDAOImplTest {
    MechanicDAO mechanicDAO = null;
    Mechanic mechanic = null;
    ServiceStation serviceStation = null;
    Car car = null;
    Session session = null;

    @Before
    public void setUp() {
        mechanicDAO = new MechanicDAOImpl();
        mechanic = new Mechanic();

        //Добавим информацию
        mechanic.setId(1L);
        mechanic.setName("Mark");
        mechanic.setSurname("Twain");

        //создаем необходимые объекты для объекта mechanic
        serviceStation = new ServiceStation();
        serviceStation.setId(3);
        serviceStation.setAddress("Шевченка 25");
        Set<Car> cars = new HashSet<>();
//        Set<ServiceStation> sto = new HashSet<>();
//        sto.add(serviceStation);
        car = new Car();
        car.setId(3L);
        //car.setServiceStations(sto);
        cars.add(car);
        serviceStation.setCars(cars);
        mechanic.setServiceStation(serviceStation);
    }

    @After
    public void cleanData() {
        MechanicDAO mechanicDAO = null;
        Mechanic mechanic = null;
        ServiceStation serviceStation = null;
        Car car = null;
        Session session = null;
    }

    @Test
    public void testAddMechanic() throws Exception {
        try {
            //Добавляем в БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.save(serviceStation);
            session.getTransaction().commit();
            session.close();

            //Добавляем запись в БД
            mechanicDAO.addMechanic(mechanic);

            //Проверяем, добавилась ли запись
            session = HibernateUtil.getSessionFactory().openSession();
            //сравниваем два обьекта
            Mechanic mechanicTest = session.get(Mechanic.class, mechanic.getId());
            assertEquals("Не совпадают!", mechanic, mechanicTest);
            session.close();

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(mechanic);
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
    public void testUpdateMechanic() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Добавляем в БД
            session.beginTransaction();
            session.save(car);
            session.save(serviceStation);
            session.save(mechanic);
            session.getTransaction().commit();
            session.close();

            //Меняем данные
            mechanic.setName("Denis");

            //Обновляем данные в БД
            mechanicDAO.updateMechanic(mechanic);

            //Проверяем обновление данных
            //сравниваем два обьекта
            session = HibernateUtil.getSessionFactory().openSession();
            assertEquals("Объекты не совпадают!", mechanic, session.get(Mechanic.class, mechanic.getId()));
            session.close();

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(mechanic);
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
    public void testGetMechanicById() throws Exception {
        try {
            //добавляем в БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.save(serviceStation);
            session.save(mechanic);
            session.getTransaction().commit();
            session.close();

            //получаем из БД по id
            Mechanic mechanicTest = mechanicDAO.getMechanicById(mechanic.getId());

            assertEquals("объекты не совпали!", mechanic, mechanicTest);

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(mechanic);
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
    public void deleteMechanic() throws Exception {
        try {
            //добавляем в БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.save(serviceStation);
            session.save(mechanic);
            session.getTransaction().commit();
            session.close();

            //удаляем данные из БД
            mechanicDAO.deleteMechanic(mechanic);

            //проверяем удалились ли данные из БД
            //совпадения не должно быть
            session = HibernateUtil.getSessionFactory().openSession();
            assertNotEquals("Объекты совпали!", mechanic, session.get(Mechanic.class, mechanic.getId()));
            session.close();

            //Удаляем запись из БД
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.delete(serviceStation);
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