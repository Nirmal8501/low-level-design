package Problems.parkinglot.solution.model;

public class ParkingSpot {

    private String id;
    private VehicleSize spotSize;
    private Boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String id, VehicleSize spotSize) {
        this.id = id;
        this.spotSize = spotSize;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.isOccupied = true;
        this.parkedVehicle = vehicle;
    }

    public void unparkVehicle(Vehicle vehicle) {
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType().equals(this.spotSize); // You can have custom switch case here to accomodate different vehicles in same spot, i am keeping it simple
    }

    public boolean isAvailable() {
        return !this.isOccupied;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(VehicleSize spotSize) {
        this.spotSize = spotSize;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id='" + id + '\'' +
                ", spotSize=" + spotSize +
                ", isOccupied=" + isOccupied +
                ", parkedVehicle=" + parkedVehicle +
                '}';
    }
}
