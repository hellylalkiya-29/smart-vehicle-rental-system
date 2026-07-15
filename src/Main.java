import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        divider("TASK 1: Runtime Polymorphism");
        // Same reference type (Vehicle), but the JVM decides at RUNTIME
        // which overridden startVehicle() to actually run, based on the
        // real object type. This is Dynamic Method Dispatch.
        Vehicle v1 = new Car("C101", "Hyundai Creta", 2500, true);
        Vehicle v2 = new Bike("B201", "Royal Enfield", 800, true);
        Vehicle v3 = new ElectricVehicle("E301", "Tata Nexon EV", 3000, 85);

        v1.startVehicle();
        v2.startVehicle();
        v3.startVehicle();

        divider("TASK 2: Object Polymorphism");
        // One array of type Vehicle[] holds THREE different object types.
        // We never need to know the exact subclass to call showDetails()/calculateRent().
        Vehicle[] vehicles = { v1, v2, v3 };

        for (Vehicle v : vehicles) {
            v.showDetails();
            System.out.println("3-day rent   : Rs. " + v.calculateRent(3));
            System.out.println("-----------------------------");
        }

        divider("TASK 3: Upcasting");
        // Child -> Parent reference. Allowed automatically & implicitly because
        // every Car IS-A Vehicle. Only Vehicle's methods are accessible through
        // this reference (enableAC() is NOT visible here) - but the version that
        // EXECUTES is still Car's overridden version, because Java binds
        // overridden methods at runtime based on the actual object, not the
        // reference type.
        Vehicle vehicle = new Car("C102", "Honda City", 2200, false);
        vehicle.startVehicle();   // Runs Car's startVehicle() - proof of dynamic dispatch
        // vehicle.enableAC();    // <-- Would NOT compile: enableAC() isn't part of Vehicle

        divider("TASK 4: Downcasting");
        // Parent -> Child reference, done explicitly with a cast.
        // Needed because enableAC() only exists on Car, not on Vehicle.
        Car car = (Car) vehicle;
        car.enableAC();

        divider("TASK 5: Safe Downcasting (instanceof)");
        // Without instanceof, casting a Vehicle that ISN'T actually a Car
        // (e.g., a Bike or EV) would throw a ClassCastException at runtime.
        // instanceof lets us check the real object type BEFORE casting.
        checkAndUseSpecialFeature(v1); // real type: Car
        checkAndUseSpecialFeature(v2); // real type: Bike
        checkAndUseSpecialFeature(v3); // real type: ElectricVehicle

        demonstrateUnsafeCastFailure();

        divider("BUSINESS SCENARIO: Daily Fleet Report");
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(v1);
        fleet.add(v2);
        fleet.add(v3);
        fleet.add(new LuxuryCar("L401", "Mercedes S-Class", 15000, true, true)); // Challenge task type
        generateDailyReport(fleet);

        divider("CHALLENGE TASK: LuxuryCar added with ZERO changes to existing logic");
        System.out.println("LuxuryCar was just processed above in the SAME loop as Car/Bike/EV,");
        System.out.println("using the SAME Vehicle reference type. No existing method was touched.");
        System.out.println("This proves the design follows the Open-Closed Principle (OCP).");
    }

    /**
     * TASK 5 helper: performs a SAFE downcast using instanceof, then calls
     * the special method appropriate to that vehicle type.
     */
    private static void checkAndUseSpecialFeature(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car c = (Car) vehicle;
            c.enableAC();
        } else if (vehicle instanceof Bike) {
            Bike b = (Bike) vehicle;
            b.provideHelmet();
        } else if (vehicle instanceof ElectricVehicle) {
            ElectricVehicle ev = (ElectricVehicle) vehicle;
            ev.checkBatteryHealth();
        } else if (vehicle instanceof LuxuryCar) {
            LuxuryCar lc = (LuxuryCar) vehicle;
            lc.requestChauffeur();
        }
    }

    /**
     * Deliberately shows WHY instanceof matters: casting a Bike to Car
     * without checking first throws ClassCastException at runtime.
     */
    private static void demonstrateUnsafeCastFailure() {
        System.out.println("\nDemonstrating an UNSAFE downcast on purpose:");
        Vehicle bikeAsVehicle = new Bike("B202", "Bajaj Pulsar", 700, true);
        try {
            Car wrongCast = (Car) bikeAsVehicle; // no instanceof check - will throw
            wrongCast.enableAC();
        } catch (ClassCastException e) {
            System.out.println("Caught expected ClassCastException: " + e.getMessage());
            System.out.println("This is exactly why instanceof must be checked before downcasting.");
        }
    }

    /**
     * Business Scenario Extension: process an entire fleet through the
     * common Vehicle interface, then use instanceof + downcasting to
     * trigger each vehicle's special feature.
     */
    private static void generateDailyReport(List<Vehicle> fleet) {
        for (Vehicle v : fleet) {
            v.showDetails();
            v.startVehicle();
            checkAndUseSpecialFeature(v);
            System.out.println("===============================");
        }
    }

    private static void divider(String title) {
        System.out.println("\n========== " + title + " ==========");
    }
}
