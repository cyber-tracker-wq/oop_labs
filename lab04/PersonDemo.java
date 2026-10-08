public class PersonDemo {
    public static void main(String[] args) {
        Student s = new Student("Tariro", 20, "Software Engineering");
        Teacher t = new Teacher("Mr Vhudzijena", 45, "Technopreneurship");

        // display() is NOT written in Student or Teacher: both use Person's single copy
        s.display();
        t.display();

        System.out.println("Student course: " + s.getCourse());
        System.out.println("Teacher subject: " + t.getSubject());

        Person p = s;       // a Student IS-A Person
        System.out.println("Via Person reference: " + p.getName());
    }
}
