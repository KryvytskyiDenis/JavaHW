package CarEngineService;

import java.util.HashSet;
import java.util.Set;

public class Engine {
    private int id;
    private double displacement;//литраж
    private int power;
    public Set<Car> setCars = new HashSet<>();//коллекция автомобилей с данным двигателем

    Engine(int id, double displacement, int power){
        this.id = id;
        this.displacement = displacement;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Set<Car> getSetCars() {
        return setCars;
    }

    public void setSetCars(Set<Car> setCars) {
        this.setCars = setCars;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", displacement=" + displacement +
                ", power=" + power +
                '}';
    }
}
