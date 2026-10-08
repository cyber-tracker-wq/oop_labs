public class StackDemo {
    public static void main(String[] args) {
        BadStack<String> bad = new BadStack<>();
        bad.push("A");
        bad.push("B");
        bad.push("C");
        bad.add(0, "SNEAKY");       // inherited method breaks the LIFO rule
        bad.remove(1);              // removes from the middle
        System.out.println("BadStack after illegal operations: " + bad);
        System.out.println("bad.get(0) reads the BOTTOM: " + bad.get(0));

        GoodStack<String> good = new GoodStack<>();
        good.push("A");
        good.push("B");
        good.push("C");
        // good.add(0, "X");        // COMPILE ERROR: no such method
        System.out.println("GoodStack pop: " + good.pop() + ", peek: " + good.peek());
    }
}

/*
WHAT THE INHERITANCE VERSION WRONGLY EXPOSES
  extends ArrayList makes every ArrayList method public on a Stack: add(index, x),
  remove(index), get(index), set, sort, clear, iterator, and so on. Anyone can insert or
  remove in the middle and break the last-in-first-out rule. It also locks the class
  to ArrayList forever (the "is-a" claim is false: a stack is not a list). Composition
  keeps the list private and exposes only push/pop/peek/isEmpty/size.
*/
