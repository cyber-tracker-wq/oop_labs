public class Animal {
    protected final String name;

    // Only ONE constructor, and it needs an argument.
    // Because we wrote a constructor, Java does NOT generate the hidden no-arg one.
    public Animal(String name) {
        this.name = name;
    }
}
