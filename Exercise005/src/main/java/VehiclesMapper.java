

import java.util.ArrayList;
import java.util.List;

public class VehiclesMapper {
    public List<Vehicle> mapFrom(List<List<String>> rawVehicles) {
        List<List<String>> rawVehiclesWithoutHeaders = rawVehicles.subList(1, rawVehicles.size());

        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        for (List<String> rawVehicle : rawVehiclesWithoutHeaders) {
            var id = Integer.parseInt(rawVehicle.get(0));
            var make = rawVehicle.get(1);
            var model = rawVehicle.get(2);
            var seats = Integer.parseInt(rawVehicle.get(3));
            var licensePlate = rawVehicle.get(4);

            Vehicle vehicle = new Vehicle(id, make, model, seats, licensePlate);
            vehicles.add(vehicle);
        }
        return vehicles;
    }
}
