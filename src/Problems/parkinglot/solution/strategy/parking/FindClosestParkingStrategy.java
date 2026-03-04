package Problems.parkinglot.solution.strategy.parking;

import Problems.parkinglot.solution.model.ParkingFloor;
import Problems.parkinglot.solution.model.ParkingSpot;
import Problems.parkinglot.solution.model.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindClosestParkingStrategy implements  ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {
        // it will check from highest floor if any spot is available till the lowest floor and will return first avaialbe spot

        List<ParkingFloor> floors = parkingFloors.stream()
                .sorted(Comparator.comparing(ParkingFloor::getFloorNumber))
                .toList();

        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.getAvailableParkingSpots(vehicle);
            if (spot.isPresent()) {
                return spot;
            }
        }
        return Optional.empty();
    }
}
