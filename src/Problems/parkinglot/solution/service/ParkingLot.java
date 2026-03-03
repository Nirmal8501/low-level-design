package Problems.parkinglot.solution.service;

import Problems.parkinglot.solution.model.ParkingFloor;
import Problems.parkinglot.solution.model.ParkingTicket;
import Problems.parkinglot.solution.model.Vehicle;
import Problems.parkinglot.solution.strategy.FeeStrategy;
import Problems.parkinglot.solution.strategy.ParkingStrategy;

import java.util.*;

public class ParkingLot {

    private static ParkingLot parkingLot;

    private ParkingStrategy parkingStrategy;
    private FeeStrategy feeStrategy;
    private List<ParkingFloor> parkingParkingFloors;
    private Map<String, ParkingTicket> activeTickets;

    private ParkingLot() {
//        TODO: Inititialize Constructor
//        parkingFloors = new ArrayList<>();
//        activeTickets = new HashMap<>();
//        this.feeStrategy = new FlatRateFeeStrategy();
//        this.parkingStrategy = new BestFitStrategy();
//        this.activeTickets = new ConcurrentHashMap<>();
    }

    public static ParkingLot getParkingLotInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addFloor(ParkingFloor parkingFloor) {
        parkingParkingFloors.add(parkingFloor);
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle){
        return null; // TODO: Concrete implementaion
    }


    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public FeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingParkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingParkingFloors) {
        this.parkingParkingFloors = parkingParkingFloors;
    }

    public Map<String, ParkingTicket> getActiveTickets() {
        return activeTickets;
    }

    public void setActiveTickets(Map<String, ParkingTicket> activeTickets) {
        this.activeTickets = activeTickets;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
