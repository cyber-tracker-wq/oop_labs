public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    @Override
    public String toString() {
        return String.format("%-9s area=%8.2f perimeter=%8.2f", getClass().getSimpleName(), area(), perimeter());
    }
}
