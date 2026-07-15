public class ElectricVehicle extends Vehicle {

    private int batteryPercentage;

    public ElectricVehicle(String vehicleId, String brand, double rentPerDay, int batteryPercentage) {
        super(vehicleId, brand, rentPerDay);
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public void startVehicle() {
        System.out.println("[EV] Silent start-up complete. Ready to glide.");
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Type         : Electric Vehicle");
        System.out.println("Battery      : " + batteryPercentage + "%");
    }

    // Special method - only ElectricVehicle has this
    public void checkBatteryHealth() {
        if (batteryPercentage < 20) {
            System.out.println("[EV] WARNING: Battery low (" + batteryPercentage + "%). Please charge soon.");
        } else {
            System.out.println("[EV] Battery health OK (" + batteryPercentage + "%).");
        }
    }
}
