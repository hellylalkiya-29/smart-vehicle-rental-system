public class Bike extends Vehicle {

    private boolean helmetIncluded;

    public Bike(String vehicleId, String brand, double rentPerDay, boolean helmetIncluded) {
        super(vehicleId, brand, rentPerDay);
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public void startVehicle() {
        System.out.println("[Bike] Kick-started! Engine roaring.");
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Type         : Bike");
        System.out.println("Helmet Incl. : " + (helmetIncluded ? "Yes" : "No"));
    }

    // Special method - only Bike has this
    public void provideHelmet() {
        System.out.println("[Bike] Helmet handed over to the rider. Safety first!");
    }
}
