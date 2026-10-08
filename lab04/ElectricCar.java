public class ElectricCar extends Car {
    private final int batteryKwh;

    public ElectricCar(String make, int doors, int batteryKwh) {
        super(make, doors);
        this.batteryKwh = batteryKwh;
        System.out.println("3. ElectricCar constructor: " + batteryKwh + " kWh");
    }

    public void describe() {
        System.out.println(make + ", " + doors + " doors, " + batteryKwh + " kWh");
    }
}
