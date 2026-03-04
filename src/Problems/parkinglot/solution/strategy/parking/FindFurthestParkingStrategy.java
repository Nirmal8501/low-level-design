package Problems.parkinglot.solution.strategy.parking;

import Problems.parkinglot.solution.model.ParkingFloor;
import Problems.parkinglot.solution.model.ParkingSpot;
import Problems.parkinglot.solution.model.Vehicle;

import java.util.*;

// Responsibilities -> Take the vehicle and list of floors and return a parkingSpot
public class FindFurthestParkingStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {
        // it will check from highest floor if any spot is available till the lowest floor and will return first avaialbe spot

        List<ParkingFloor> reversedFloors = parkingFloors.stream()
                .sorted(Comparator.comparing(ParkingFloor::getFloorNumber).reversed())
                .toList();

        for (ParkingFloor floor : reversedFloors) {
            Optional<ParkingSpot> spot = floor.getAvailableParkingSpots(vehicle);
            if (spot.isPresent()) {
                return spot;
            }
        }
        return Optional.empty();
    }
}
