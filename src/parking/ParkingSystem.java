package parking;

import exceptions.UnavailableParkingSpotsException;
import parking.vehicles.Vehicle;

public class ParkingSystem {

    private Strategy strategy;
    private TicketDispenser ticketDispenser;

    public ParkingSystem(TicketDispenser ticketDispenser) {
        this.ticketDispenser = ticketDispenser;
    }

    public Ticket issueTicketForVehicle(Vehicle vehicle) throws UnavailableParkingSpotsException {
        return this.strategy.execute(this.ticketDispenser,vehicle);
    }

    public TicketDispenser getTicketDispenser() {
        return ticketDispenser;
    }

    public void setTicketDispenser(TicketDispenser ticketDispenser) {
        this.ticketDispenser = ticketDispenser;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
