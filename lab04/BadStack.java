import java.util.ArrayList;

// INHERITANCE version (poor design): a Stack IS-NOT-REALLY an ArrayList.
public class BadStack<T> extends ArrayList<T> {
    public void push(T item) { add(item); }
    public T pop()           { return remove(size() - 1); }
    public T peek()          { return get(size() - 1); }
}
