package parking.vehicles;

import parking.User;
import parking.utils.ParkingSpotCategory;

public abstract class Vehicle {
    private User user;
    private ParkingSpotCategory parkingSpotCategory;

    public Vehicle(User user,ParkingSpotCategory parkingSpotCategory)
    {
        this.user = user;
        this.parkingSpotCategory = parkingSpotCategory;
    }

    public ParkingSpotCategory getParkingSpotCategory() {
        return parkingSpotCategory;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
