import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRental {
    private List<Vehicle> fleet;
    private List<Customer> customers;
    private List<Rental> rentals;

    public List<Customer> getCustomers() {
        return customers;
    }

    public CarRental(List<Vehicle> fleet, List<Customer> customers, List<Rental> rentals) {
        this.fleet = fleet;
        this.customers = customers;
        this.rentals = rentals;
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public void addNewRental(Rental rental) {
        rentals.add(rental);
    }

    public void returnVehicleAndEndRental(Vehicle vehicle) {
        rentals.removeIf(rental -> rental.getVehicle() == vehicle);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public List<Vehicle> listAvailableVehiclesFromDates(LocalDate startDate, LocalDate endDate) {
        List<Vehicle> rentedVehicles = rentals.stream().map(Rental::getVehicle).collect(Collectors.toList());
        List<Vehicle> notRentedVehicles = fleet.stream().filter(Predicate.not(rentedVehicles::contains)).collect(Collectors.toList());

        List<Vehicle> availableRentedVehicles = rentals.stream()
                .filter(rental -> !(rental.getStartDate().isBefore(endDate) && startDate.isBefore(rental.getEndDate())))
                .map(Rental::getVehicle).collect(Collectors.toList());

        return Stream.concat(notRentedVehicles.stream(), availableRentedVehicles.stream())
                .collect(Collectors.toList());
    }

    public void addNewVehicleToFleet(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void removeVehicleFromFleet(Vehicle vehicleToRemove) {
        fleet.removeIf(vehicle -> vehicle == vehicleToRemove);
    }

    public void displayAllVehicles() {
        System.out.println(fleet);
    }
}
