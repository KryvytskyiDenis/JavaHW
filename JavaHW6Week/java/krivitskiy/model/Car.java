package krivitskiy.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Денис on 28.02.2017.
 */
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "make")
    private String make;

    @Column(name = "id_engine")
    private int idEngine;

    @Column(name = "price")
    private Double price;

    @Column(name = "date")
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "car_service_stations", joinColumns = {
        @JoinColumn(name = "car_id", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name = "service_stations_id", nullable = false, updatable = false)})
    private Set<ServiceStation> serviceStations = new HashSet<ServiceStation>();

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getIdEngine() {
        return idEngine;
    }

    public void setIdEngine(int idEngine) {
        this.idEngine = idEngine;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<ServiceStation> getServiceStations() {
        return serviceStations;
    }

    public void setServiceStations(Set<ServiceStation> serviceStations) {
        this.serviceStations = serviceStations;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (idEngine != car.idEngine) return false;
        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (price != null ? !price.equals(car.price) : car.price != null) return false;
        if (date != null ? !date.equals(car.date) : car.date != null) return false;
        return serviceStations != null ? serviceStations.equals(car.serviceStations) : car.serviceStations == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + idEngine;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (serviceStations != null ? serviceStations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", idEngine=" + idEngine +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
