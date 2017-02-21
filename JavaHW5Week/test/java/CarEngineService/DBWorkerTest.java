package CarEngineService;

import org.junit.Test;

import static org.junit.Assert.*;

public class DBWorkerTest {
    @Test
    public void testGetCarById() throws Exception {
        DBWorker dbWorker = new DBWorker();
        Car car = new Car(4, "GT", "Ford", new Engine(3,6.7, 688), 100000);
        dbWorker.insertCar(car);
        assertNotNull(dbWorker.getCarById(4));
    }

    @Test
    public void testGetEngineById() throws Exception {
        DBWorker dbWorker = new DBWorker();
        Engine engine = new Engine(3, 3.2, 450);
        dbWorker.insertEngine(engine);
        assertNotNull(dbWorker.getEngineById(3));
    }

    @Test
    public void testInsertCar() throws Exception {
        DBWorker dbWorker = new DBWorker();
        Car car = new Car(1, "Bmw i8", "Bmw", null, 141700);
        dbWorker.insertCar(car);
        assertNotNull(car);
    }

    @Test
    public void testInsertEngine() throws Exception {
        DBWorker dbWorker = new DBWorker();
        Engine engine = new Engine(6, 3.5, 500);
        dbWorker.insertEngine(engine);
        assertNotNull(engine);
    }

}