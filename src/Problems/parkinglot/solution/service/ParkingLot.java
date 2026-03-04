package Problems.parkinglot.solution.service;

import Problems.parkinglot.solution.model.ParkingFloor;
import Problems.parkinglot.solution.model.ParkingSpot;
import Problems.parkinglot.solution.model.ParkingTicket;
import Problems.parkinglot.solution.model.Vehicle;
import Problems.parkinglot.solution.strategy.fee.FeeStrategy;
import Problems.parkinglot.solution.strategy.parking.ParkingStrategy;

import java.time.Instant;
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

    // Responsibilities -> ParkVehicle, Release Vehicle, Store active tickets, ParkingStrategy (Find a parking spot) -> So what shd this take as argument ? umm List of floors and does it need to know about vehicle ?, FeeStrategy (Calculate fee, maybe based on Vehicle size, time parked or whatever, endless possiblities)

    public static ParkingLot getParkingLotInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addFloor(ParkingFloor parkingFloor) {
        parkingParkingFloors.add(parkingFloor);
    }

    // Responsibility -> Find spot, Park the vehicle if spot is found and return the ticket.
    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpot = parkingStrategy.findParkingSpot(parkingParkingFloors, vehicle);

        if (parkingSpot.isPresent()) {
            parkingSpot.get().parkVehicle(vehicle);
            ParkingTicket ticket = generateParkingTicket(vehicle, parkingSpot.get());
            System.out.println("Vehicle: " + vehicle + " parked at spot: " + parkingSpot.get() + " Ticket: " + ticket);
            activeTickets.put(ticket.getId(),  ticket);
            return Optional.of(ticket);
        }

        System.out.println("Could not find parking spot for vehicle, unable to park.");
        return Optional.empty();
    }

    // Responsiblity -> Unpark the vehicle and calculate fee and release the ticket
    public Double unparkVehicle(ParkingTicket ticket) {
        ticket.getParkingSpot().unparkVehicle(ticket.getVehicle());
        ticket.setExitTimeStamp(Instant.now());
        activeTickets.remove(ticket.getId());

        // TODO: Checkpoint
    }

    private ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new ParkingTicket(vehicle, parkingSpot);
    }

    // Getters and Setters

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
