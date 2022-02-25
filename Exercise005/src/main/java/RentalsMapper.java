//import com.cm.app.model.Rental;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RentalsMapper {

    public List<List<String>> mapToRaw(List<Rental> rentals) {
        List<List<String>> rawVehicles = rentals.stream().map(rental ->
                        List.of(rental.getCustomer().getId(),
                                rental.getVehicle().getId().toString(),
                                rental.getStartDate().toString(),
                                rental.getEndDate().toString()))
                .collect(Collectors.toList());
        rawVehicles.add(0, Arrays.asList("customerId", "vehicleId", "startDate", "endDate"));
        return rawVehicles;
    }
}
