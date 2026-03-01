import java.util.*;
import java.util.stream.*;

/**
 * ==========================================
 * FILE 5: MODERN STREAMS, LAMBDAS & FUNCTIONAL JAVA
 * ==========================================
 */

// Package-private class so it can live in the same file
class Employee {
    String name;
    String department;
    double salary;

    public Employee(String n, String d, double s) {
        this.name = n; this.department = d; this.salary = s;
    }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class StreamProcessor {
    public static void main(String[] args) {

        List<Employee> staff = Arrays.asList(
                new Employee("Alice", "IT", 85000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "IT", 95000),
                new Employee("Diana", "Sales", 75000)
        );

        /**
         * MAP, FILTER, REDUCE PIPELINE
         * Streams do not change the original data structure. They are processed in a pipeline:
         * Source -> Intermediate Ops (lazy) -> Terminal Op (triggers the work)
         */

        // Goal: Get the total salary of all IT employees
        double totalItSalary = staff.stream()
                // INTERMEDIATE: Keeps only Employee objects where dept is "IT"
                .filter(e -> e.getDepartment().equals("IT"))
                // INTERMEDIATE: Extracts the salary double from the objects (Method Reference)
                .mapToDouble(Employee::getSalary)
                // TERMINAL: Combines all salaries starting from 0.0
                .reduce(0.0, (sum, salary) -> sum + salary);

        /**
         * COLLECTORS: Transforming Data
         * Goal: Get a list of just the names of employees earning over 70k, sorted alphabetically
         */
        List<String> highEarners = staff.stream()
                .filter(e -> e.getSalary() > 70000) // Removes Bob
                .map(Employee::getName) // Transforms Stream<Employee> into Stream<String>
                .sorted() // Sorts the strings alphabetically natural order
                .collect(Collectors.toList()); // TERMINAL: Packages results back into a new List

        /**
         * COLLECTORS: GroupingBy
         * Goal: Create a Map where Key = Department, Value = List of Employees in it
         */
        Map<String, List<Employee>> employeesByDept = staff.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        /**
         * LAMBDA FOREACH
         * Goal: Print the high earners list efficiently
         */
        highEarners.forEach(name -> System.out.println("High Earner: " + name));
    }
}