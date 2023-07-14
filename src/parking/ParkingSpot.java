package parking;

import parking.utils.ParkingSpotCategory;
import parking.utils.ParkingSpotStatus;

public class ParkingSpot {
    private ParkingSpotCategory category;
    private ParkingSpotStatus status;
    public ParkingSpot(ParkingSpotCategory category, ParkingSpotStatus status) {
        this.category = category;
        this.status = status;
    }

    public ParkingSpotCategory getCategory() {
        return category;
    }

    public void setCategory(ParkingSpotCategory category) {
        this.category = category;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

}
