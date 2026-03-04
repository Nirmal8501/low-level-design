package Problems.parkinglot.solution.model;

import java.time.Instant;
import java.util.UUID;

public class ParkingTicket {

    private String id;
    private Vehicle vehicle;
    private Instant entryTimeStamp;
    private Instant exitTimeStamp;
    private ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTimeStamp = Instant.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Instant getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public void setEntryTimeStamp(Instant entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public Instant getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp(Instant exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
