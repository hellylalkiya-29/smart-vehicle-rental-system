/**
 * Parent class for the DriveEasy Rentals system.
 * Declared abstract because a generic "Vehicle" should never be rented out directly —
 * only concrete types (Car, Bike, ElectricVehicle, ...) can be instantiated.
 * This is what makes Runtime Polymorphism meaningful: every real object stored in a
 * Vehicle reference MUST be one of the subclasses, and each provides its own behavior.
 */
public abstract class Vehicle {

    protected String vehicleId;
    protected String brand;
    protected double rentPerDay;

    public Vehicle(String vehicleId, String brand, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
    }

    // Every subclass MUST provide its own startVehicle() -> Method Overriding
    public abstract void startVehicle();

    // Common business logic shared by all vehicles - no need to override this
    public double calculateRent(int days) {
        return rentPerDay * days;
    }

    // Every subclass overrides this to show its own extra details
    public void showDetails() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Brand        : " + brand);
        System.out.println("Rent/Day     : Rs. " + rentPerDay);
    }

    public String getVehicleId() {
        return vehicleId;
    }
}
