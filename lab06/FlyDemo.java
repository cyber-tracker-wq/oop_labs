public class FlyDemo {
    public static void main(String[] args) {
        // Bird and Aeroplane share NO superclass, only the Flyable contract
        Flyable[] things = { new Bird(), new Aeroplane() };
        for (Flyable f : things) f.fly();
    }
}
