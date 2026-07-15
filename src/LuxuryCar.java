/**
 * CHALLENGE TASK: A brand-new vehicle type added to the fleet.
 * Notice: Vehicle.java, Car.java, Bike.java, ElectricVehicle.java, and Main.java's
 * core processing loop did NOT need to change for this to work. That's the
 * Open-Closed Principle in action - the system is OPEN for extension
 * (new vehicle types) but CLOSED for modification (existing code untouched).
 */
public class LuxuryCar extends Vehicle {

    private boolean chauffeurService;
    private boolean premiumInsurance;

    public LuxuryCar(String vehicleId, String brand, double rentPerDay,
                      boolean chauffeurService, boolean premiumInsurance) {
        super(vehicleId, brand, rentPerDay);
        this.chauffeurService = chauffeurService;
        this.premiumInsurance = premiumInsurance;
    }

    @Override
    public void startVehicle() {
        System.out.println("[LuxuryCar] Keyless ignition engaged. A smooth, silent start.");
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Type         : Luxury Car");
        System.out.println("Chauffeur    : " + (chauffeurService ? "Included" : "Not included"));
        System.out.println("Insurance    : " + (premiumInsurance ? "Premium" : "Standard"));
    }

    public void requestChauffeur() {
        System.out.println("[LuxuryCar] Chauffeur has been assigned and is en route.");
    }
}
