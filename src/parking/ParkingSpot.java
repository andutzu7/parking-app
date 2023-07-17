package parking;

import parking.utils.ParkingSpotCategory;
import parking.utils.ParkingSpotStatus;

public class ParkingSpot {

    private final int id;
    private final ParkingSpotCategory category;
    private ParkingSpotStatus status;
    public ParkingSpot(int id, ParkingSpotCategory category, ParkingSpotStatus status) {
        this.id = id;
        this.category = category;
        this.status = status;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || obj.getClass()!= this.getClass()) {
            return false;
        }
        ParkingSpot other = (ParkingSpot) obj;
        return (this.getId() == other.getId());

    }

    public ParkingSpotCategory getCategory() {
        return category;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

}
