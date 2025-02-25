import java.util.*;

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "John Doe", 28, 50000),
            new Employee(102, "Jane Smith", 35, 60000),
            new Employee(103, "Alice Brown", 24, 45000)
        );

        employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary))
            .forEach(System.out::println);
    }
}
