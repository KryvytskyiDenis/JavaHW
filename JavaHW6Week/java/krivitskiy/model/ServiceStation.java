package krivitskiy.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Денис on 28.02.2017.
 */
@Entity
@Table(name = "service_stations")
public class ServiceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_stations_id")
    private Long id;

    @Column(name = "address")
    private String address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "car_service_stations", joinColumns = {
        @JoinColumn(name = "service_stations_id", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name = "car_id", nullable = false, updatable = false)})
    private Set<Car> cars = new HashSet<Car>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "serviceStation")
    private Set<Mechanic> mechanics = new HashSet<Mechanic>();

    public ServiceStation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceStation that = (ServiceStation) o;

        return  id.equals(that.id) ;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int) getId();
        return result;
    }

    @Override
    public String toString() {
        return "ServiceStation{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", cars=" + cars +
                ", mechanics=" + mechanics +
                '}';
    }
}
