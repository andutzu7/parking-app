import exceptions.UnavailableParkingSpotsException;
import parking.*;
import parking.utils.ParkingSpotCategory;
import parking.utils.ParkingSpotStatus;
import parking.utils.UserType;
import parking.vehicles.Car;
import parking.vehicles.Motocycle;
import parking.vehicles.Truck;
import parking.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingSpot p1 = new ParkingSpot(1, ParkingSpotCategory.SMALL, ParkingSpotStatus.FREE);
        ParkingSpot p2 = new ParkingSpot(2, ParkingSpotCategory.MEDIUM, ParkingSpotStatus.FREE);
        ParkingSpot p3 = new ParkingSpot(3, ParkingSpotCategory.LARGE, ParkingSpotStatus.FREE);
        ParkingSpot p4 = new ParkingSpot(4, ParkingSpotCategory.SMALL, ParkingSpotStatus.FREE);
        ParkingSpot p5 = new ParkingSpot(5, ParkingSpotCategory.MEDIUM, ParkingSpotStatus.FREE);
        ParkingSpot p6 = new ParkingSpot(6, ParkingSpotCategory.LARGE, ParkingSpotStatus.FREE);

        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        parkingSpotList.add(p1);
        parkingSpotList.add(p2);
        parkingSpotList.add(p3);
        parkingSpotList.add(p4);
        parkingSpotList.add(p5);
        parkingSpotList.add(p6);

        ParkingField parkingField = new ParkingField(parkingSpotList);
        TicketDispenser ticketDispenser = new TicketDispenser(parkingField);
        ParkingSystem parkingSystem = new ParkingSystem(ticketDispenser);

        User user1 = new User("Ana Luca", UserType.REGULAR);
        Car car1 = new Car(user1);

        User user2 = new User("Artk", UserType.REGULAR);
        Car car2 = new Car(user2);

        User user3 = new User("Asti", UserType.REGULAR);
        Car car3 = new Car(user3);

        User user4 = new User("Calin", UserType.REGULAR);
        Car car4 = new Car(user4);

        User user5 = new User("Iulia", UserType.VIP);
        Motocycle motocycle1 = new Motocycle(user5);

        User user6 = new User("Paul", UserType.VIP);
        Truck truck1 = new Truck(user6);

        User user7 = new User("Paula", UserType.VIP);
        Car car5 = new Car(user7);

        RegularStrategy regularStrategy = new RegularStrategy();
        parkingSystem.setStrategy(regularStrategy);

        tryToPark(parkingSystem, car1);
        tryToPark(parkingSystem, car2);
        tryToPark(parkingSystem, car3);
        tryToPark(parkingSystem, car4);

        VIPStrategy vipStrategy = new VIPStrategy();
        parkingSystem.setStrategy(vipStrategy);

        tryToPark(parkingSystem, car5);
        tryToPark(parkingSystem, truck1);
        tryToPark(parkingSystem, motocycle1);

    }

    private static void tryToPark(ParkingSystem parkingSystem, Vehicle vehicle) {
        try {
            Ticket ticket = parkingSystem.issueTicketForVehicle(vehicle);
            System.out.println(ticket.getBody());
        } catch (UnavailableParkingSpotsException e) {
            System.out.println("Couldn't obtain a ticket");
        }
    }
}