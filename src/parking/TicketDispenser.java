package parking;

import parking.utils.ParkingSpotCategory;
import parking.utils.ParkingSpotStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicketDispenser {

    private ParkingField parkingField;
    private final String unavailableTicketMessage = "No parking spots available";

    public TicketDispenser(ParkingField parkingField) {
        this.parkingField = parkingField;
    }



    public Ticket issueTicket(ParkingSpotCategory parkingSpotCategory) {
        Ticket parkingTicket = new Ticket();
        if (checkAvailableParkingSpots(parkingSpotCategory)) {
            ParkingSpot parkingSpot = getFirstAvailableParkingSpot(parkingSpotCategory);
            String ticketBody = buildTicketBody();
            parkingTicket.setBody(ticketBody);
            updateParkingField(parkingSpot,ParkingSpotStatus.OCCUPIED);
        } else {
            parkingTicket.setBody(unavailableTicketMessage);
        }
        return parkingTicket;
    }
    public void updateParkingField(ParkingSpot parkingSpot, ParkingSpotStatus parkingSpotStatus){
        this.parkingField.updateParkingSpotStatus(parkingSpot, parkingSpotStatus);
    }
    public String buildTicketBody(){
        String ticketBody = "Newly granted parking spot. ";
        return ticketBody;
    }
    public ParkingSpot getFirstAvailableParkingSpot(ParkingSpotCategory parkingSpotCategory) {

        List<ParkingSpot> parkingFieldList = this.parkingField.getParkingSpotList();
        List<ParkingSpot> requestedCategoryParkingSpots = filterParkingSpotListByCategory(parkingFieldList, parkingSpotCategory);
        List<ParkingSpot> requestedCategoryAvailableSpots = filterParkingSpotListByAvailability(requestedCategoryParkingSpots, ParkingSpotStatus.FREE);
        return requestedCategoryAvailableSpots.get(0);
    }
    public boolean checkAvailableParkingSpots(ParkingSpotCategory parkingSpotCategory) {
        boolean foundAvailableSpots = false;
        List<ParkingSpot> parkingFieldList = this.parkingField.getParkingSpotList();
        List<ParkingSpot> requestedCategoryParkingSpots = filterParkingSpotListByCategory(parkingFieldList, parkingSpotCategory);
        List<ParkingSpot> requestedCategoryAvailableSpots = filterParkingSpotListByAvailability(requestedCategoryParkingSpots, ParkingSpotStatus.FREE);
        if (requestedCategoryAvailableSpots.size() != 0) {
            foundAvailableSpots = true;
        }
        return foundAvailableSpots;

    }

    public List<ParkingSpot> filterParkingSpotListByCategory(List<ParkingSpot> parkingFieldList,
                                                             ParkingSpotCategory parkingSpotCategory) {
        List<ParkingSpot> requestedCategoryParkingSpots = parkingFieldList.stream()
                .filter(parkingSpot -> parkingSpot.getCategory() == parkingSpotCategory).collect(Collectors.toList());
        return requestedCategoryParkingSpots;
    }

    public List<ParkingSpot> filterParkingSpotListByAvailability(List<ParkingSpot> parkingFieldList,
                                                                 ParkingSpotStatus parkingSpotStatus) {
        List<ParkingSpot> requestedCategoryAvailableSpots = parkingFieldList.stream()
                .filter(parkingSpot -> parkingSpot.getStatus() == parkingSpotStatus).collect(Collectors.toList());
        return requestedCategoryAvailableSpots;
    }

    public String getUnavailableTicketMessage() {
        return unavailableTicketMessage;
    }

    public ParkingField getParkingField() {
        return parkingField;
    }

    public void setParkingField(ParkingField parkingField) {
        this.parkingField = parkingField;
    }
}
