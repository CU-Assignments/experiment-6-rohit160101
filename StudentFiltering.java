import java.util.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John Doe", 82),
            new Student("Jane Smith", 74),
            new Student("Alice Brown", 90),
            new Student("Bob Williams", 78)
        );

        students.stream()
            .filter(s -> s.getMarks() > 75)
            .sorted(Comparator.comparing(Student::getMarks).reversed())
            .map(Student::getName)
            .forEach(System.out::println);
    }
}
