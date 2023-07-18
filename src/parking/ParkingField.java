package parking;

import parking.utils.ParkingSpotStatus;

import java.util.List;
import java.util.Optional;

public class ParkingField {

    private List<ParkingSpot> parkingSpotList;

    public ParkingField(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public void updateParkingSpotStatus(ParkingSpot parkingSpot, ParkingSpotStatus newStatus) {

        Optional<ParkingSpot> first = parkingSpotList.stream()
                .filter(parkingSpot1 -> parkingSpot1.equals(parkingSpot))
                .findFirst();
        first.ifPresent(spot -> spot.setStatus(newStatus));

    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }


}
