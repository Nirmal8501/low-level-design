package Problems.parkinglot.solution.strategy.parking;

import Problems.parkinglot.solution.model.ParkingFloor;
import Problems.parkinglot.solution.model.ParkingSpot;
import Problems.parkinglot.solution.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findParkingSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle);
}
