package parking.vehicles;

import parking.User;
import parking.utils.ParkingSpotCategory;

public class Motocycle extends Vehicle {
    public Motocycle(User user) {
        super(user,ParkingSpotCategory.SMALL);
    }
}
