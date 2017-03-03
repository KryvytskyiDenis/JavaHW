package krivitskiy.dao;

import krivitskiy.model.Mechanic;
import java.sql.SQLException;

/**
 * Created by Денис on 28.02.2017.
 */
public interface MechanicDAO {
    void addMechanic(Mechanic mechanic) throws SQLException;
    void updateMechanic(Mechanic mechanic) throws SQLException;
    Mechanic getMechanicById(long mechanic_id) throws SQLException;
    void deleteMechanic(Mechanic mechanic) throws SQLException;
}
