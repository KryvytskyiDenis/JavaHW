package CarEngineService;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class DBWorkerTest {
    @Test
    public void testGetCarById() throws Exception {
        DBWorker dbWorker = new DBWorker();

        final int testID = 2;//тестовый id
        final String INSERT_CAR = "INSERT INTO car(id, model, make, id_engine, price) VALUES(?, ?, ?, ?, ?)";
        final String INSERT_ENGINE = "INSERT INTO engine(id, displacement, power) VALUES(?, ?, ?)";

        Engine engine = new Engine(3, 6.7, 688);
        Car car = new Car(testID, "GT", "Ford", engine, 100000);

        Connection connection = dbWorker.getConnection();
        Statement statement = connection.createStatement();

        //добавляем новую запись car в БД
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR);

        preparedStatement.setInt(1, car.getId());//id
        preparedStatement.setString(2, car.getModel());//модель авто
        preparedStatement.setString(3, car.getMake());//производитель
        preparedStatement.setInt(4, car.getEngine().getId());//двигатель
        preparedStatement.setInt(5, car.getPrice());//стоимость авто
        preparedStatement.executeUpdate();

        //добавляем новую запись engine в БД
        preparedStatement = connection.prepareStatement(INSERT_ENGINE);

        preparedStatement.setInt(1, engine.getId());
        preparedStatement.setDouble(2, engine.getDisplacement());
        preparedStatement.setInt(3, engine.getPower());
        preparedStatement.executeUpdate();

        //проверяем получение авто по id
        Car carTest = dbWorker.getCarById(testID);

        System.out.println(carTest);
        //сравниваем полученные результаты с ожидаемыми
        assertNotNull(carTest);

        assertEquals("Id не совпадают!", car.getId(), carTest.getId());
        assertEquals("Модели авто не совпадают!", car.getModel(), carTest.getModel());
        assertEquals("Производители не совпадает!", car.getMake(), carTest.getMake());
        assertEquals("Двигатели не совпадают!", car.getEngine().getId(), carTest.getEngine().getId());
        assertEquals("Цены не совпадают!", car.getPrice(), carTest.getPrice());

        //удаляем добавленную запись из БД
        statement.execute("DELETE FROM car WHERE id = " + testID);
    }

    @Test
    public void testGetEngineById() throws Exception {
        DBWorker dbWorker = new DBWorker();
        int testID = 4;

        final String INSERT_ENGINE = "INSERT INTO engine(id, displacement, power) VALUES(?, ?, ?)";
        final String GET_ENGINE_BY_ID = "SELECT * FROM engine WHERE id = " + testID;

        Engine engine = new Engine(testID, 3.8, 500);

        Connection connection = dbWorker.getConnection();

        //добавляем новую запись в БД
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ENGINE);

        preparedStatement.setInt(1, engine.getId());
        preparedStatement.setDouble(2, engine.getDisplacement());
        preparedStatement.setInt(3, engine.getPower());
        preparedStatement.executeUpdate();

        //проверяем получение авто по id
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ENGINE_BY_ID);

        Engine engineTest = new Engine(0, 0, 0);

        //заполняем поля тестового объекта
        while (resultSet.next()) {
            engineTest.setId(resultSet.getInt(1));
            engineTest.setDisplacement(resultSet.getDouble(2));
            engineTest.setPower(resultSet.getInt(3));
        }

        //сравниваем полученные результаты с ожидаемыми
        assertEquals("Id не совпадают!", engine.getId(), engineTest.getId());
        assertEquals("Литраж двигателей не совпадают!", engine.getDisplacement(), engineTest.getDisplacement(), 5);
        assertEquals("Производители не совпадает!", engine.getPower(), engineTest.getPower());


        //удаляем добавленную запись из БД
        statement.execute("DELETE FROM engine WHERE id = " + testID);
    }

    @Test
    public void testInsertCar() throws Exception {
        DBWorker dbWorker = new DBWorker();

        final int testID = 3;//тестовый id
        final String GET_CAR_BY_ID = "SELECT * FROM car WHERE id = " + testID;

        Engine engine = new Engine(5, 2.3, 500);
        Car car = new Car(testID, "Bmw i8", "Bmw", engine, 141700);

        //добавляем запись в БД
        dbWorker.insertCar(car);

        Connection connection = dbWorker.getConnection();

        //проверяем получение авто по id
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_CAR_BY_ID);
        Car carTest = new Car(0, "", "", null, 0);
        Engine engineTest = new Engine(0, 0, 0);

        //заполняем поля тестового объекта
        while (resultSet.next()) {
            carTest.setId(resultSet.getInt(1));
            carTest.setModel(resultSet.getString(2));
            carTest.setMake(resultSet.getString(3));
            engineTest.setId(resultSet.getInt(4));//получаем id двигателя
            carTest.setEngine(engineTest);
            carTest.setPrice(resultSet.getInt(5));
        }

        //сравниваем полученные результаты с ожидаемыми
        assertEquals("Id не совпадают!", car.getId(), carTest.getId());
        assertEquals("Модели авто не совпадают!", car.getModel(), carTest.getModel());
        assertEquals("Производители не совпадает!", car.getMake(), carTest.getMake());
        assertEquals("Двигатели не совпадают!", car.getEngine().getId(), carTest.getEngine().getId());
        assertEquals("Цены не совпадают!", car.getPrice(), carTest.getPrice());

        //удаляем добавленную запись из БД
        statement.execute("DELETE FROM car WHERE id = " + testID);
    }

    @Test
    public void testInsertEngine() throws Exception {
        DBWorker dbWorker = new DBWorker();

        final int testID = 1;//тестовый id
        final String GET_ENGINE_BY_ID = "SELECT * FROM engine WHERE id = " + testID;

        Engine engine = new Engine(testID, 2.0, 210);

        //добавляем запись в БД
        dbWorker.insertEngine(engine);

        Connection connection = dbWorker.getConnection();

        //проверяем получение авто по id
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ENGINE_BY_ID);
        Engine engineTest = new Engine(0, 0, 0);

        //заполняем поля тестового объекта
        while (resultSet.next()) {
            engineTest.setId(resultSet.getInt(1));
            engineTest.setDisplacement(resultSet.getDouble(2));
            engineTest.setPower(resultSet.getInt(3));
        }

        //сравниваем полученные результаты с ожидаемыми
        assertNotNull(engineTest);

        assertEquals("Id не совпадают!", engine.getId(), engineTest.getId());
        assertEquals("Литраж двигателей не совпадают!", engine.getDisplacement(), engineTest.getDisplacement(), 5);
        assertEquals("Производители не совпадает!", engine.getPower(), engineTest.getPower());

        //удаляем добавленную запись из БД
        statement.execute("DELETE FROM engine WHERE id = " + testID);
    }
}