import java.util.Objects;

public class Vehicle {
    private Integer id;
    private String make;
    private String model;
    private Integer numberOfSeats;
    private String licensePlate;

    public Vehicle(Integer id, String make, String model, Integer numberOfSeats, String licensePlate) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", make='" + make + '\'' + ", model='" + model + '\'' + ", numberOfSeats=" + numberOfSeats + ", licensePlate='" + licensePlate + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model) && Objects.equals(numberOfSeats, vehicle.numberOfSeats) && Objects.equals(licensePlate, vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, numberOfSeats, licensePlate);
    }

    public Integer getId() {
        return id;
    }
}
