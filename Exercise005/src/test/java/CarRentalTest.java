
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRentalTest {
    Vehicle audi = new Vehicle(1, "Audi", "A4", 5, "123ABC");
    Vehicle mercedes = new Vehicle(2, "Mercedes", "C220", 5, "123XYZ");
    Vehicle bmw = new Vehicle(3, "BMW", "X", 5, "123IOP");
    Vehicle vw = new Vehicle(4, "VW", "Golf", 5, "123JKL");
    Vehicle Maserati = new Vehicle(5, "Maserati", "G1344", 5, "123JKL55");

    List<Vehicle> fleet = new ArrayList(Arrays.asList(audi, mercedes, bmw, vw, Maserati));

    Customer john = new Customer("12345678XYZ", "John", "Smith");
    Customer marie = new Customer("12345678ABC", "Marie", "Smith");
    Customer peter = new Customer("12345678QWE", "Peter", "Smith");
    List<Customer> customers = new ArrayList(Arrays.asList(john, marie, peter));

    Rental rental1 = new Rental(marie, bmw, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 5));
    Rental rental2 = new Rental(marie, vw, LocalDate.of(2022, 1, 3), LocalDate.of(2022, 1, 8));
    List<Rental> rentals = new ArrayList(Arrays.asList(rental1, rental2));
    CarRental carRental;

    @BeforeEach
    void before() {
        carRental = new CarRental(fleet, customers, rentals);
    }

    @Test
    void listAllVehicles() {
        var result = carRental.getFleet();

        assertEquals(fleet, result);
    }

    @Test
    void addNewRental() {
        LocalDate startDate = LocalDate.of(2022, 1, 10);
        LocalDate endDate = LocalDate.of(2022, 1, 13);

        var rental = new Rental(john, audi, startDate, endDate);
        carRental.addNewRental(rental);

        List<Rental> expectedRentals = List.of(rental, rental1, rental2);

        assertThat(carRental.getRentals()).hasSameElementsAs(expectedRentals);
    }

    @Test
    void listAllAvailableVehiclesFromPeriodOfTime() {
        LocalDate startDate = LocalDate.of(2022, 1, 12);
        LocalDate endDate = LocalDate.of(2022, 1, 19);

        List<Vehicle> availableVehicles = carRental.listAvailableVehiclesFromDates(startDate, endDate);

        List<Vehicle> expectedResult = List.of(audi, mercedes, bmw, vw, Maserati);
        System.out.println(availableVehicles);
        assertThat(availableVehicles).hasSameElementsAs(expectedResult);
    }

    @Test
    void listAllAvailableVehiclesFromPeriodOfTimeWhenThereIsOverlapping() {
        LocalDate startDate = LocalDate.of(2022, 1, 4);
        LocalDate endDate = LocalDate.of(2022, 1, 10);

        List<Vehicle> availableVehicles = carRental.listAvailableVehiclesFromDates(startDate, endDate);

        List<Vehicle> expectedResult = List.of(audi, mercedes, Maserati);

        assertThat(availableVehicles).hasSameElementsAs(expectedResult);
    }

    @Test
    void addNewVehicleToFleet() {
        Vehicle Maserati = new Vehicle(5, "Maserati", "G1344", 5, "123JKL55");

        carRental.addNewVehicleToFleet(Maserati);

        assertThat(carRental.getFleet()).contains(Maserati);
        System.out.println(carRental.getFleet());
    }

    @Test
    void cancelRental() {
        carRental.removeVehicleFromFleet(bmw);

        assertThat(carRental.getFleet()).doesNotContain(bmw);
    }

    @Test
    void returnVehicleAndEndRental() {
        carRental.returnVehicleAndEndRental(bmw);

        assertThat(carRental.getRentals()).doesNotContain(rental1);
    }
}
