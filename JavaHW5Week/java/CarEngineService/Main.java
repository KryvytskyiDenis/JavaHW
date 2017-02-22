package CarEngineService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private static DBWorker worker = new DBWorker();

    //создае новый Engine и лобавляем в БД
    public static Engine addEngine(int id, double displacement, int power){
        Engine engine = new Engine(id, displacement, power);//Создаем объект типа Engine
        worker.insertEngine(engine);//Добавляем двигатель в БД

        return engine;
    }

    //создаем новый Car и добавляем в БД
    public static void addCar(int id, String model, String make, Engine engine, int price){
        Car car = new Car(id, model, make, engine, price);//Создаем новый объект типа Car
        engine.setCars.add(car);//добавляем авто в список авто объекта engine
        worker.insertCar(car);//добавляем авто в БД
    }

    public static void main(String[] args) {
        //Добавим 3 двигателя
        Engine engine1 = addEngine(1, 5.2, 610);
        Engine engine2 = addEngine(2, 3.6, 400);
        Engine engine3 = addEngine(3, 2.5, 300);

        //Добавим автомобили
        addCar(1, "Bmw i8", "Bmw", engine1, 141700);
        addCar(2, "Bmw m5", "Bmw",  engine2, 112000);
        addCar(3, "Bmw m6", "Bmw",  engine3, 70600);
        addCar(4, "Audi a6", "Audi",  engine2, 84000);
        addCar(5, "S-Class Coupe", "Mercedes-Benz",  engine3, 122750);
        addCar(6, "Ferrari 488 GTB", "Ferrari",  engine1, 249000);
        addCar(7, "Lamborghini Huracan", "Lamborghini",  engine1, 329000);

        //Получаем авто по id и выводим всю информацию о нем на экран
        for (int i = 1; i <= 7; i++) {
            System.out.println(worker.getCarById(i));
        }

        //Выводим на экран какие двигатели в каких авто используются

        for (int i = 1; i <= 3 ; i++) {
            Engine engine = worker.getEngineById(i);
            System.out.println("Двигатель с индексом " + engine.getId() + " установлен в автомобили:\n" + engine.getSetCars());
        }

        //Закрываем обьекты Connection, Statement, ResultSet и PreparedStatement
        worker.getResultSet();
        try {
            worker.getPreparedStatement().close();
            worker.getStatement().close();
            worker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
