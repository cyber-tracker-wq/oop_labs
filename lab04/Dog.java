/*
WHY THIS FAILS TO COMPILE
    class Dog extends Animal {
        Dog() { }                  // or no constructor at all
    }
    error: constructor Animal in class Animal cannot be applied to given types;

Every constructor must start with a call to a superclass constructor. If you do not write
super(...), the compiler silently inserts super() (no arguments). Animal has no no-arg
constructor (it was removed when Animal(String) was written), so super() cannot be resolved.

FIX: call an Animal constructor explicitly (the version below).
*/
public class Dog extends Animal {
    public Dog(String name) {
        super(name);               // explicit super(...) satisfies the compiler
    }

    public void bark() { System.out.println(name + " says Woof!"); }
}
