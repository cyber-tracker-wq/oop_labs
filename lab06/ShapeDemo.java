public class ShapeDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();   // COMPILE ERROR: abstract classes cannot be instantiated
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5), new Square(6) };
        for (Shape s : shapes) System.out.println(s);
    }
}
