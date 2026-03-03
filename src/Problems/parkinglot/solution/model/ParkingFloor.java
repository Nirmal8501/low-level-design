package Problems.parkinglot.solution.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingFloor {
    private int floorNumber;
    private Map<String, ParkingSpot> parkingSpots;

//    displayInfo(), getAvailableParkingSpot(): ParkingSpot, addSpot

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingSpots = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.put(parkingSpot.getId(), parkingSpot);
    }

    public Optional<ParkingSpot> getAvailableParkingSpots(Vehicle vehicle) {
        return parkingSpots.values()
                .stream()
                .filter(parkingSpot -> parkingSpot.isAvailable() && parkingSpot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotSize)) // to get smallest possible size to fit the vehicle, but in our case we are mapping spot to vehicle size 1-1 so this wont do anything
                .findFirst(); // or Findany()
    }

    public void displayInfo() {
        System.out.println("Floor Number: " + floorNumber);
        System.out.println("Available Parking Spots:");
        parkingSpots.values()
                .stream()
                .peek(System.out::println);
    }

    public void displayAvailability() {
        System.out.printf("--- Floor %d Availability ---\n", floorNumber);

        Map<VehicleSize, Long> availableCounts = parkingSpots.values().stream()
                .filter(spot -> !spot.getOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getSpotSize, Collectors.counting()));

        for (VehicleSize size : VehicleSize.values()) {
            System.out.printf("  %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }


    public int getFloorNumber(){
        return floorNumber;
    }


}
