package krivitskiy.dao;

import krivitskiy.model.ServiceStation;

import java.sql.SQLException;

/**
 * Created by Денис on 02.03.2017.
 */
public interface ServiceStationsDAO {
    void addServiceStation(ServiceStation serviceStation) throws SQLException;
    void updateServiceStation(ServiceStation serviceStation) throws SQLException;
    ServiceStation getServiceStationById(long serviceStation_id) throws SQLException;
    void deleteServiceStation(ServiceStation serviceStation) throws SQLException;
}
