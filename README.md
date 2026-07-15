# Smart Vehicle Rental Management System

A Java console application built for the **Runtime Polymorphism** assignment (DriveEasy Rentals problem statement). It demonstrates Inheritance, Method Overriding, Runtime Polymorphism, Dynamic Method Dispatch, Object Polymorphism, Upcasting, Downcasting, `instanceof`, `ClassCastException`, and the Open-Closed Principle.

**Live Demo (Replit):** https://replit.com/@hellylalkiya/smart-vehicle-rental-system

**Repository:** https://github.com/hellylalkiya-29/smart-vehicle-rental-system

## Class Design

```
Vehicle (abstract)
 ├── Car             -> enableAC()
 ├── Bike            -> provideHelmet()
 ├── ElectricVehicle -> checkBatteryHealth()
 └── LuxuryCar       -> requestChauffeur()   (Challenge Task - added later, zero changes elsewhere)
```

`Vehicle` holds `vehicleId`, `brand`, `rentPerDay`, and defines `startVehicle()` (abstract), `calculateRent(int days)`, and `showDetails()`. Each child overrides `startVehicle()` and `showDetails()`, and adds one special method only it has.

## How to Run

```bash
cd src
javac *.java
java Main
```

## How the Output Maps to Each Task

| Task | What to look for in the output |
|---|---|
| Task 1 - Runtime Polymorphism | `v1/v2/v3.startVehicle()` each print different text even though all three are typed as `Vehicle` |
| Task 2 - Object Polymorphism | A `Vehicle[]` array loops over 3 different subclasses using one reference type |
| Task 3 - Upcasting | `Vehicle vehicle = new Car(...)` — only `Vehicle`'s methods are accessible, but Car's overridden method still runs |
| Task 4 - Downcasting | `Car car = (Car) vehicle;` then `car.enableAC()` |
| Task 5 - Safe Downcasting | `instanceof` checks before every cast, plus a deliberate unsafe cast that throws `ClassCastException` |
| Business Scenario | `generateDailyReport()` processes a `List<Vehicle>` fleet, calling the right special method per type |
| Challenge Task | `LuxuryCar` flows through the exact same loop with no changes to `Vehicle`, `Car`, `Bike`, `ElectricVehicle`, or the report logic |

## Theory Answers (for the discussion questions)

**Why is `Vehicle vehicle = new Car();` (Upcasting) allowed?**
Because `Car` IS-A `Vehicle` — every Car satisfies the Vehicle contract, so it's always safe to treat it as one implicitly. No cast is needed going from child to parent.

**Which methods are accessible on an upcast reference?**
Only the ones declared in `Vehicle`. `enableAC()` isn't visible through a `Vehicle` reference even though the actual object is a `Car` — the compiler only knows about the reference type.

**Which method actually executes?**
The overridden version from the real object's class. The JVM performs Dynamic Method Dispatch at runtime based on the object's actual type, not the reference type — that's the core of Runtime Polymorphism.

**Why is `instanceof` needed before downcasting?**
Because the compiler only guarantees the reference is a `Vehicle` — it can't confirm at compile time whether the object underneath is actually a `Car`. Casting a `Bike` object to `Car` compiles fine but throws a `ClassCastException` at runtime. `instanceof` checks the real type first, so the cast is guaranteed safe.

**How does the Challenge Task prove OCP?**
`LuxuryCar` was added as a brand-new subclass. Nothing in `Vehicle`, `Car`, `Bike`, `ElectricVehicle`, or the fleet-processing loop in `Main` was modified — the system was *extended*, not *changed*. That's the Open-Closed Principle: open for extension, closed for modification.



## built by Helly Lalkiya
