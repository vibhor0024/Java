import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * ==========================================
 * FILE 1: PRIMITIVES, LOGIC, MEMORY & EXCEPTIONS
 * ==========================================
 */
public class Fundamentals {

        /**
         * KEYWORDS & MEMORY
         * static: Belongs to the CLASS, not the instance. Shared memory across all objects.
         * final: Constant. Once assigned, the value/reference cannot be changed.
         */
        public static final double PI = 3.14159;
        private static int instanceCount = 0; // Tracks total objects created across all instances

        public Fundamentals() {
                instanceCount++; // Increments the shared class variable every time an object is made
        }

        public static void main(String[] args) {

                // 1. PRIMITIVES & CASTING
                int maxScore = 100; // 32-bit integer for standard whole numbers
                long globalPopulation = 8000000000L; // 64-bit integer. Pointer: Always requires 'L' suffix!
                double preciseTemp = 98.6; // 64-bit floating point for precision math

                // Narrowing cast: forces double to int. Note: It TRUNCATES the decimal, it does NOT round (becomes 98).
                int truncatedTemp = (int) preciseTemp;

                // 2. OPERATORS & LOGIC
                int remainder = 10 % 3; // Modulo operator: returns the remainder (1)

                // AND (&&): Both sides must be true. OR (||): One side must be true. NOT EQUAL (!=)
                boolean isValid = (maxScore >= 100) && (remainder != 0);

                // Ternary operator: Shorthand for if/else -> condition ? "If True" : "If False"
                String status = isValid ? "Passed" : "Failed";

                // 3. SCANNER & EXCEPTION HANDLING
                // Exception handling prevents the program from crashing on unexpected errors.
                Scanner scanner = new Scanner(System.in);
                try {
                        System.out.println("Executing Try-Catch Block...");
                        // int age = scanner.nextInt(); // If user types "Ten", throws InputMismatchException
                        // int division = 100 / age; // If age is 0, throws ArithmeticException
                } catch (InputMismatchException e) {
                        System.out.println("Error: Please enter a valid number."); // Graceful handling
                } catch (ArithmeticException e) {
                        System.out.println("Error: Age cannot be zero.");
                } finally {
                        // Important: This block ALWAYS runs, whether it succeeded or failed.
                        // Used to free up resources / prevent memory leaks.
                        scanner.close();
                }

                // 4. GARBAGE COLLECTION (GC)
                // JVM automatically identifies objects with no references and deletes them from Heap Memory.
                String tempString = new String("Temporary Data");
                tempString = null; // Object is now "unreachable" and eligible for Garbage Collection
                System.gc(); // Suggests the JVM run the GC, but execution is NOT guaranteed.
        }
}