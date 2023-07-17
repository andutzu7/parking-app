package parking;

import exceptions.UnavailableParkingSpotsException;
import parking.utils.ParkingSpotCategory;
import parking.utils.ParkingSpotStatus;
import parking.utils.UserType;
import parking.vehicles.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParkingSystem {

    private TicketDispenser ticketDispenser;

    public ParkingSystem(TicketDispenser ticketDispenser) {
        this.ticketDispenser = ticketDispenser;
    }

    public Ticket issueTicketForVehicle(Vehicle vehicle){

        Ticket result = new Ticket();

        User user = vehicle.getUser();
        UserType userType = user.getType();

        ParkingSpotCategory parkingSpotCategory = vehicle.getParkingSpotCategory();
        if(userType == UserType.REGULAR) {
            try {
                result = this.ticketDispenser.issueTicket(parkingSpotCategory);
            }catch (UnavailableParkingSpotsException e){
                System.out.println(e.getMessage());
            }
            }
        if(userType == UserType.VIP){
                List<ParkingSpotCategory> vipParkingSpotCategories= computeVIPParkingSpotsCategoriesArray(parkingSpotCategory);
                for (ParkingSpotCategory category : vipParkingSpotCategories){
                    try {
                        result = this.ticketDispenser.issueTicket(category);
                        if (result != null){
                            break;
                        }
                    }catch (UnavailableParkingSpotsException e){
                        System.out.println(e.getMessage());
                    }

                }
        }
        return result;
    }

    public List<ParkingSpotCategory> computeVIPParkingSpotsCategoriesArray(ParkingSpotCategory parkingSpotCategory){
        ParkingSpotCategory[] parkingSpotCategories = ParkingSpotCategory.values();
        return Arrays.asList(parkingSpotCategories).subList(parkingSpotCategory.ordinal(),parkingSpotCategories.length);
    }
    public TicketDispenser getTicketDispenser() {
        return ticketDispenser;
    }

    public void setTicketDispenser(TicketDispenser ticketDispenser) {
        this.ticketDispenser = ticketDispenser;
    }

}
