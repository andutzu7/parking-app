package parking;

import parking.utils.ParkingSpotStatus;

import java.util.List;

public class ParkingField {

    private List<ParkingSpot> parkingSpotList;

    public ParkingField(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public void updateParkingSpotStatus(ParkingSpot parkingSpot, ParkingSpotStatus newStatus) {
        if (parkingSpotList.contains(parkingSpot)) {
            int elementIndex = parkingSpotList.indexOf(parkingSpot);

            ParkingSpot parkingSpotReference = parkingSpotList.get(elementIndex);
            parkingSpotReference.setStatus(newStatus);
        }
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }


}
