package CarEngineService;

public class Car {
    private int id;
    private String model;
    private String make;
    private int price;
    private Engine engine;


    public Car(int id, String model, String make, Engine engine, int price) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.price = price;
        this.engine = engine;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        int id_engine = 0;
        if(engine != null){
            id_engine = engine.getId();
        }
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", price=" + price +
                ", id_engine=" + id_engine +
                "}\n";
    }
}
