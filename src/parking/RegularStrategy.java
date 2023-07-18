package parking;

import exceptions.UnavailableParkingSpotsException;
import parking.vehicles.Vehicle;

public class RegularStrategy implements Strategy{
    @Override
    public Ticket execute(TicketDispenser ticketDispenser, Vehicle vehicle) throws UnavailableParkingSpotsException {
        return ticketDispenser.issueTicket(vehicle.getParkingSpotCategory());
    }
}
