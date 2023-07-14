package parking.vehicles;

import parking.User;
import parking.utils.ParkingSpotCategory;

public class Car extends Vehicle {
    public Car(User user) {
        super(user,ParkingSpotCategory.MEDIUM);
    }
}
