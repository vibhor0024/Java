import java.util.*;
import java.util.stream.*;

class Employee {
String name;
String department;
double salary;

    public Employee(String n, String d, double s) { this.name = n; this.department = d; this.salary = s; }
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

        // MAP, FILTER, REDUCE PIPELINE
        // Goal: Get the total salary of all IT employees
        double totalItSalary = staff.stream() // Converts List to Stream for functional processing
            .filter(e -> e.getDepartment().equals("IT")) // INTERMEDIATE: Keeps only Employee objects where dept is "IT"
            .mapToDouble(Employee::getSalary) // INTERMEDIATE: Extracts the salary double from the objects (Method Reference)
            .reduce(0.0, (sum, salary) -> sum + salary); // TERMINAL: Combines all salaries starting from 0.0

        // COLLECTORS: Grouping and Transforming Data
        // Goal: Get a list of just the names of employees earning over 70k, sorted alphabetically
        List<String> highEarners = staff.stream() // Opens stream
            .filter(e -> e.getSalary() > 70000) // INTERMEDIATE: Removes Bob
            .map(Employee::getName) // INTERMEDIATE: Transforms Stream<Employee> into Stream<String>
            .sorted() // INTERMEDIATE: Sorts the strings alphabetically natural order
            .collect(Collectors.toList()); // TERMINAL: Packages the stream results back into a new List

        // COLLECTORS: GroupingBy
        // Goal: Create a Map where the Key is the Department, and Value is a List of Employees in it
        Map<String, List<Employee>> employeesByDept = staff.stream() // Opens stream
            .collect(Collectors.groupingBy(Employee::getDepartment)); // TERMINAL: Organizes objects into a HashMap
            
        // LAMBDA FOREACH
        // Goal: Print the high earners list efficiently
        highEarners.forEach(name -> System.out.println("High Earner: " + name)); // Iterates and executes the lambda for each item
    }
}