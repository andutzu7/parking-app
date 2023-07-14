import parking.*;
import parking.utils.ParkingSpotCategory;
import parking.utils.ParkingSpotStatus;
import parking.utils.UserType;
import parking.vehicles.Car;
import parking.vehicles.Motocycle;
import parking.vehicles.Truck;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingSpot p1 = new ParkingSpot(ParkingSpotCategory.SMALL, ParkingSpotStatus.FREE);
        ParkingSpot p2 = new ParkingSpot(ParkingSpotCategory.MEDIUM, ParkingSpotStatus.FREE);
        ParkingSpot p3 = new ParkingSpot(ParkingSpotCategory.LARGE, ParkingSpotStatus.FREE);
        ParkingSpot p4 = new ParkingSpot(ParkingSpotCategory.SMALL, ParkingSpotStatus.FREE);
        ParkingSpot p5 = new ParkingSpot(ParkingSpotCategory.MEDIUM, ParkingSpotStatus.FREE);

        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        parkingSpotList.add(p1);
        parkingSpotList.add(p2);
        parkingSpotList.add(p3);
        parkingSpotList.add(p4);
        parkingSpotList.add(p5);

        ParkingField parkingField= new ParkingField(parkingSpotList);
        TicketDispenser ticketDispenser= new TicketDispenser(parkingField);
        ParkingSystem parkingSystem = new ParkingSystem(ticketDispenser);

        User user1 = new User("Ana Luca", UserType.REGULAR);
        Car car1 = new Car(user1);

        User user2 = new User("Artk", UserType.REGULAR);
        Car car2 = new Car(user2);

        User user3 = new User("Asti", UserType.REGULAR);
        Car car3 = new Car(user3);

        User user4 = new User("Calin", UserType.VIP);
        Car car4 = new Car(user4);

        User user5 = new User("Iulia", UserType.REGULAR);
        Motocycle motocycle = new Motocycle(user5);

        User user6 = new User("Paul", UserType.REGULAR);
        Truck truck1 = new Truck(user6);

        Ticket t1 = parkingSystem.issueTicketForVehicle(car1);

        Ticket t2 = parkingSystem.issueTicketForVehicle(car2);

        Ticket t3 = parkingSystem.issueTicketForVehicle(car3);

        Ticket t4 = parkingSystem.issueTicketForVehicle(car4);

        Ticket t5 = parkingSystem.issueTicketForVehicle(motocycle);

        Ticket t6 = parkingSystem.issueTicketForVehicle(truck1);

        System.out.println(t1.getBody());
        System.out.println(t2.getBody());
        System.out.println(t3.getBody());
        System.out.println(t4.getBody());
        System.out.println(t5.getBody());
        System.out.println(t6.getBody());
    }
}