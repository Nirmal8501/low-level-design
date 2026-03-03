package Problems.parkinglot.solution.model;

public abstract class Vehicle {
    private String licenseNumber;
    private VehicleSize type;

    public Vehicle(String licenseNumber, VehicleSize type) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public VehicleSize getType() {
        return type;
    }

    public void setType(VehicleSize type) {
        this.type = type;
    }
}
