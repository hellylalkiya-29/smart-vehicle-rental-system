public class Car extends Vehicle {

    private boolean hasSunroof;

    public Car(String vehicleId, String brand, double rentPerDay, boolean hasSunroof) {
        super(vehicleId, brand, rentPerDay);
        this.hasSunroof = hasSunroof;
    }

    @Override
    public void startVehicle() {
        System.out.println("[Car] Engine started with a key/push-button ignition. Vroom!");
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Type         : Car");
        System.out.println("Sunroof      : " + (hasSunroof ? "Yes" : "No"));
    }

    // Special method - only Car has this, called only after downcasting
    public void enableAC() {
        System.out.println("[Car] Air Conditioning is now ON. Enjoy the cool ride!");
    }
}
