public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        ElectricCar e = new ElectricCar("Nissan Leaf", 5, 40);
        e.describe();
        // Constructors run TOP-DOWN: Vehicle -> Car -> ElectricCar, because each
        // constructor's first statement is super(...), which finishes the parent first.
    }
}
