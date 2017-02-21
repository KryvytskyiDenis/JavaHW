package CarEngineService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static DBWorker worker = new DBWorker();

    private static List<Engine> engines = new ArrayList<>();

    public static void addEngine(int id, double displacement, int power){
        Engine engine = new Engine(id, displacement, power);//Создаем объект типа Engine
        worker.insertEngine(engine);//Добавляем двигатель в БД
        engines.add(engine);//добавляем в список двигателей
    }

    public static void addCar(int id, String model, String make, Engine engine, int price){
        Car car = new Car(id, model, make, engine, price);//Создаем новый объект типа Car
        engine.setCars.add(car);//добавляем авто в список авто объекта engine
        worker.insertCar(car);//добавдяем авто в БД
    }

    public static void main(String[] args) {
        //Добавим 3 двигателя
        addEngine(1, 5.2, 610);
        addEngine(2, 3.6, 400);
        addEngine(3, 2.5, 300);

        //Добавим автомобили
        addCar(1, "Bmw i8", "Bmw", engines.get(0), 141700);
        addCar(2, "Bmw m5", "Bmw",  engines.get(1), 112000);
        addCar(3, "Bmw m6", "Bmw",  engines.get(2), 70600);
        addCar(4, "Audi a6", "Audi",  engines.get(1), 84000);
        addCar(5, "S-Class Coupe", "Mercedes-Benz",  engines.get(2), 122750);
        addCar(6, "Ferrari 488 GTB", "Ferrari",  engines.get(0), 249000);
        addCar(7, "Lamborghini Huracan", "Lamborghini",  engines.get(0), 329000);

        //Получаем авто по id и выводим всю информацию о нем на экран
        for (int i = 1; i <= 7; i++) {
            System.out.println(worker.getCarById(i));
        }

        //Выводим на экран какие двигатели в каких авто используются
        for (int i = 0; i < engines.size(); i++) {
            System.out.println("Двигатель с индексом " + engines.get(i).getId() + " установлен в такие автомобили:");
            System.out.println(engines.get(i).getSetCars());
            System.out.println();
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
