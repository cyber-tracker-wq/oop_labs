import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    public Student(String name, int marks) { this.name = name; this.marks = marks; }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    // NATURAL ORDER: alphabetical by name
    @Override
    public int compareTo(Student other) { return name.compareToIgnoreCase(other.name); }

    // EXTRA ORDER: by marks, highest first
    public static final Comparator<Student> BY_MARKS_DESC =
            Comparator.comparingInt(Student::getMarks).reversed();

    @Override public String toString() { return name + "(" + marks + ")"; }
}
