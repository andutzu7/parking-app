package parking;

import exceptions.UnavailableParkingSpotsException;
import parking.vehicles.Vehicle;

public interface Strategy {

    public Ticket execute(TicketDispenser ticketDispenser,Vehicle vehicle) throws UnavailableParkingSpotsException;

}
