package parking;

import exceptions.UnavailableParkingSpotsException;
import parking.utils.ParkingSpotCategory;
import parking.utils.ParkingSpotStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicketDispenser {

    private ParkingField parkingField;
    public TicketDispenser(ParkingField parkingField) {
        this.parkingField = parkingField;
    }


    public Ticket issueTicket(ParkingSpotCategory parkingSpotCategory) throws UnavailableParkingSpotsException {
        Ticket parkingTicket;

        ParkingSpot parkingSpot = getFirstAvailableParkingSpot(parkingSpotCategory);
        if (parkingSpot != null) {
            parkingTicket = initializeTicket(parkingSpot);
            this.parkingField.updateParkingSpotStatus(parkingSpot, ParkingSpotStatus.OCCUPIED);
        } else {
            throw new UnavailableParkingSpotsException("No more parking spots of category " + parkingSpotCategory + " available");
        }
        return parkingTicket;
    }

    public Ticket initializeTicket(ParkingSpot parkingSpot) {
        Ticket ticket = new Ticket();
        String ticketBody = buildTicketBody(parkingSpot);
        ticket.setBody(ticketBody);
        return ticket;
    }

    public String buildTicketBody(ParkingSpot parkingSpot) {
        String ticketBody = "Newly granted parking spot. Parking spot id: " + parkingSpot.getId();
        return ticketBody;
    }

    private ParkingSpot getFirstAvailableParkingSpot(ParkingSpotCategory parkingSpotCategory) {

        List<ParkingSpot> availableParkingSpotList = this.parkingField.getParkingSpotList().stream()
                .filter(parkingSpot -> parkingSpot.getCategory() == parkingSpotCategory)
                .filter(parkingSpot -> parkingSpot.getStatus() == ParkingSpotStatus.FREE)
                .collect(Collectors.toList());
        if (availableParkingSpotList.size() != 0) {
            return availableParkingSpotList.get(0);
        } else {
            return null;
        }

    }

    public ParkingField getParkingField() {
        return parkingField;
    }

    public void setParkingField(ParkingField parkingField) {
        this.parkingField = parkingField;
    }
}
