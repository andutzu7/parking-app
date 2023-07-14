package parking.vehicles;

import parking.User;
import parking.utils.ParkingSpotCategory;

public class Truck extends Vehicle {
    public Truck(User user) {
        super(user,ParkingSpotCategory.LARGE);
    }
}
