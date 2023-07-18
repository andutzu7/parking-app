package parking;

import exceptions.UnavailableParkingSpotsException;
import parking.utils.ParkingSpotCategory;
import parking.vehicles.Vehicle;

import java.util.Arrays;
import java.util.List;

public class VIPStrategy implements Strategy {
    @Override
    public Ticket execute(TicketDispenser ticketDispenser, Vehicle vehicle) throws UnavailableParkingSpotsException {
        List<ParkingSpotCategory> vipParkingSpotCategories = computeVIPParkingSpotsCategoriesArray(vehicle.getParkingSpotCategory());
        for (ParkingSpotCategory category : vipParkingSpotCategories) {
            try {
                return ticketDispenser.issueTicket(category);
            } catch (UnavailableParkingSpotsException e) {
                //no spot in category
            }
        }
        throw new UnavailableParkingSpotsException("No more available parking spots");
    }

    public List<ParkingSpotCategory> computeVIPParkingSpotsCategoriesArray(ParkingSpotCategory parkingSpotCategory) {
        ParkingSpotCategory[] parkingSpotCategories = ParkingSpotCategory.values();
        return Arrays.asList(parkingSpotCategories).subList(parkingSpotCategory.ordinal(), parkingSpotCategories.length);
    }
}