package krivitskiy.dao;

import krivitskiy.model.ServiceStation;
import krivitskiy.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by Денис on 28.02.2017.
 */
public class ServiceStationsDAOImpl implements ServiceStationsDAO {
    @Override
    public void addServiceStation(ServiceStation serviceStation) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(serviceStation);
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
    public void updateServiceStation(ServiceStation serviceStation) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(serviceStation);
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
    public ServiceStation getServiceStationById(long serviceStation_id) throws SQLException {
        Session session = null;
        ServiceStation serviceStation = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            serviceStation = (ServiceStation) session.get(ServiceStation.class, serviceStation_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return serviceStation;
    }

    @Override
    public void deleteServiceStation(ServiceStation serviceStation) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
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
