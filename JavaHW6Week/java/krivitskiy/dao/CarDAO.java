package krivitskiy.dao;

import krivitskiy.model.Car;

import java.sql.SQLException;

/**
 * Created by Денис on 28.02.2017.
 */
public interface CarDAO {
    void addCar(Car car) throws SQLException;
    void updateCar(Car car) throws SQLException;
    Car getCarById(long car_id) throws SQLException;
    void deleteCar(Car car) throws SQLException;
}
