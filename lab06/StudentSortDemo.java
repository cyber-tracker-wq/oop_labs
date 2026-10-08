import java.util.*;

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Tariro", 82), new Student("Farai", 67),
            new Student("Rudo", 91), new Student("Anesu", 67)));

        Collections.sort(list);                          // uses compareTo (name)
        System.out.println("By name       : " + list);

        list.sort(Student.BY_MARKS_DESC);                // uses the Comparator
        System.out.println("By marks desc : " + list);

        list.sort(Student.BY_MARKS_DESC.thenComparing(Comparator.naturalOrder()));
        System.out.println("Marks, then name: " + list);
    }
}
