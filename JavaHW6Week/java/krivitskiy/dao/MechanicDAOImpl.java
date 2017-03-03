package krivitskiy.dao;

import krivitskiy.model.Mechanic;
import krivitskiy.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by Денис on 28.02.2017.
 */
public class MechanicDAOImpl implements MechanicDAO {
    @Override
    public void addMechanic(Mechanic mechanic) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(mechanic);
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
    public void updateMechanic(Mechanic mechanic) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(mechanic);
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
    public Mechanic getMechanicById(long mechanic_id) throws SQLException {
        Session session = null;
        Mechanic mechanic = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            mechanic = (Mechanic) session.get(Mechanic.class, mechanic_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return mechanic;
    }

    @Override
    public void deleteMechanic(Mechanic mechanic) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(mechanic);
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
