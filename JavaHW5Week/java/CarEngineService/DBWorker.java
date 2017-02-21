package CarEngineService;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DBWorker {
    private static final String URL = "jdbc:postgresql://localhost:5432/javaHW5Week";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "1357";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    //Команды SQL
    private final String INSERT_CAR = "INSERT INTO public.car(id, model, make, id_engine, price) VALUES(?, ?, ?, ?, ?)";
    private final String INSERT_ENGINE = "INSERT INTO engine(id, displacement, power) VALUES(?, ?, ?)";
    private final String GET_CAR_BY_ID = "SELECT * FROM car WHERE id = " ;
    private final String GET_ENGINE_BY_ID = "SELECT * FROM engine WHERE id = ";
    private final String GET_CAR_BY_ID_ENGINE = "SELECT c.id, c.model, c.make, c.price FROM car c WHERE id_engine = ";

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //главный метод получения авто по id и заполнение поля Engine. Возвращает объект типа Car
    public Car getCarById(int id){
        Car car;//обьект который будет содержать полученные данные

        car = justGetCarById(id);//получаем авто по id из БД

        return car;
    }

    //вспомогательный метод для получения авто. Вызывается из метода getCarById
    private Car justGetCarById(int id){
        Car car = new Car(0, "", "", null, 0);

        try{
            //получаем Car по id
            resultSet = statement.executeQuery(GET_CAR_BY_ID + id);

            while(resultSet.next()){
                car.setId(resultSet.getInt(1));
                car.setModel(resultSet.getString(2));
                car.setMake(resultSet.getString(3));
                car.setEngine(getEngineById_Engine(resultSet.getInt(4)));//получаем двигатель по полученному id_engine
                car.setPrice(resultSet.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }
        return car;
    }

    //вспомогательный метод для получения объекта типа Engine по переданному id_engine. Вызывается из метода getCarById
    private Engine getEngineById_Engine(int id_engine){
        Engine engine = new Engine(0, 0, 0);

        try(Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(GET_ENGINE_BY_ID + id_engine);

            while(res.next()){
                engine.setId(res.getInt(1));
                engine.setDisplacement(res.getDouble(2));
                engine.setPower(res.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }
        return engine;

    }

    //главный метод получения объекта Engine по id
    public Engine getEngineById(int id){
        Engine engine;

        engine = helpGetEngineById(id);//получаем engine по id

        engine.setSetCars(getCarByIdEngine(engine.getId()));//получаем set<Car> по id_engine

        return engine;
    }

    //Вспомогательный метод. Получаем объект типа Engine по id. Вызывается из метода getEngineById
    private Engine helpGetEngineById(int id){
        Engine engine = new Engine(0, 0, 0);

        try {
            resultSet = statement.executeQuery(GET_ENGINE_BY_ID + id);

            while(resultSet.next()){
                engine.setId(resultSet.getInt(1));
                engine.setDisplacement(resultSet.getDouble(2));
                engine.setPower(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }
        return engine;
    }

    //Вспомогательный метод. Получаем список авто по id_engine. Метод вызывается из метода getEngineById
    private Set<Car> getCarByIdEngine(int id_engine){
        Set<Car> setCars= new HashSet<>();
        try{
            //получаем Car по id_engine
            resultSet = statement.executeQuery(GET_CAR_BY_ID_ENGINE + id_engine);

            while(resultSet.next()){
                Car car = new Car(0, "", "", null, 0);//создаем новый объект типа Car
                //заполняем его поля даннім из БД
                car.setId(resultSet.getInt(1));
                car.setModel(resultSet.getString(2));
                car.setMake(resultSet.getString(3));
                car.setEngine(getEngineById_Engine(id_engine));
                car.setPrice(resultSet.getInt(5));

                setCars.add(car);//помещаем заполненный объект в список
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }

        return setCars;
    }

    public void insertCar(Car car){
        try {
            Engine engine = car.getEngine();//получаем двигатель автомобиля

            preparedStatement = connection.prepareStatement(INSERT_CAR);
            preparedStatement.setInt(1, car.getId());//id
            preparedStatement.setString(2, car.getModel());//модель авто
            preparedStatement.setString(3, car.getMake());//производитель

            if(engine != null){
                preparedStatement.setInt(4, engine.getId());//двигатель
            }else {
                //если двигатель не указан, то id_engine = 0;
                preparedStatement.setInt(4, 0);//двигатель
            }
            preparedStatement.setInt(5, car.getPrice());//стоимость авто
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error_insert_car!");
        }
    }

    public void insertEngine(Engine engine){
        try {
            preparedStatement = connection.prepareStatement(INSERT_ENGINE);

            preparedStatement.setInt(1, engine.getId());
            preparedStatement.setDouble(2, engine.getDisplacement());
            preparedStatement.setInt(3, engine.getPower());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error_insert_engine!");
        }
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
}
