import java.util.Scanner;
import java.util.InputMismatchException;

public class Fundamentals {
// KEYWORDS AND MEMORY
public static final double PI = 3.14159; // static: belongs to class, shared memory. final: constant, cannot change.
private static int instanceCount = 0; // static: tracks total objects created across all instances

    public Fundamentals() {
        instanceCount++; // Increments the shared class variable every time an object is made
    }

    public static void main(String[] args) {
        // PRIMITIVES & CASTING
        int maxScore = 100; // 32-bit integer
        long globalPopulation = 8000000000L; // 64-bit integer, requires 'L' suffix
        double preciseTemp = 98.6; // 64-bit floating point for precision math
        int truncatedTemp = (int) preciseTemp; // Narrowing cast: forces double to int, loses decimal (becomes 98)

        // OPERATORS & LOGIC
        int remainder = 10 % 3; // Modulo operator: returns 1
        boolean isValid = (maxScore >= 100) && (remainder != 0); // AND (&&), NOT EQUAL (!=) evaluation
        String status = isValid ? "Passed" : "Failed"; // Ternary operator: if true return "Passed", else "Failed"

        // SCANNER & EXCEPTION HANDLING
        Scanner scanner = new Scanner(System.in); // Initializes input stream from console
        try {
            System.out.print("Enter your age: "); // Prints without newline
            int age = scanner.nextInt(); // Reads integer input
            int division = 100 / age; // Potential ArithmeticException if age is 0
        } catch (InputMismatchException e) { // Catches specific error if user types a letter
            System.out.println("Error: Please enter a valid number."); // Graceful error handling
        } catch (ArithmeticException e) { // Catches divide-by-zero
            System.out.println("Error: Age cannot be zero."); // Prevents program crash
        } finally {
            scanner.close(); // Always executes to prevent memory leaks, regardless of success or error
        }
        
        // GARBAGE COLLECTION
        String tempString = new String("Temporary Data"); // Creates object in Heap memory
        tempString = null; // Object is now unreachable; eligible for Garbage Collection
        System.gc(); // Suggests the JVM run the Garbage Collector (execution not guaranteed)
    }
}