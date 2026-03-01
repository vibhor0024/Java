public class KeywordMastery {

    /**
     * ==========================================
     * 1. THE 'static' KEYWORD
     * Use Case: Memory management. Means "belongs to the CLASS, not the object."
     * If you create 100 objects, they all share the exact same static variables/methods.
     * ==========================================
     */
    
    // Static Variable: Shared across all instances. Great for counters or shared state.
    public static int globalEmployeeCount = 0; 

    // Static Block: Runs exactly ONCE when the class is first loaded into memory.
    // Use Case: Complex initialization of static variables or setting up database connections.
    static {
        System.out.println("Class loaded. Initializing static resources...");
        globalEmployeeCount = 100; // Starting point
    }

    // Static Method: Can be called without creating an object (e.g., KeywordMastery.add(5, 5)).
    // Rule: Static methods CANNOT access non-static (instance) variables or 'this'.
    public static int add(int a, int b) {
        return a + b;
    }


    /**
     * ==========================================
     * 2. THE 'final' KEYWORD
     * Use Case: Restriction. Means "cannot be changed" once assigned/defined.
     * ==========================================
     */
    
    // Final Variable (Constant): Value cannot be modified after initialization.
    // Convention: Name constants in ALL_CAPS.
    public final double PI = 3.14159; 

    // Final Method: Cannot be overridden by any child classes.
    // Use Case: Core logic that subclasses shouldn't be allowed to tamper with.
    public final void strictSecurityCheck() {
        System.out.println("Running unalterable security protocol.");
    }

    // Final Class: Cannot be extended (inherited) by any other class.
    // Use Case: Security and immutability (e.g., Java's built-in String class is final).
    final class Vault {
        String secretCode = "1234";
    }


    /**
     * ==========================================
     * 3. THE 'this' KEYWORD
     * Use Case: Disambiguation and object reference. Means "THIS exact object".
     * ==========================================
     */
    
    private String name;
    private int age;

    // Use Case A: Resolving ambiguity between instance variables and parameters
    public KeywordMastery(String name) {
        this.name = name; // 'this.name' is the class variable. 'name' is the argument passed in.
    }

    // Use Case B: Constructor Chaining
    // If someone doesn't provide an age, call the OTHER constructor using this()
    public KeywordMastery() {
        this("Unknown User", 0); // Must be the VERY FIRST line in the constructor
    }

    public KeywordMastery(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Use Case C: Passing the current object to another method
    public void registerUser() {
        Database.save(this); // Passes the entire current 'KeywordMastery' object to the database
    }


    /**
     * ==========================================
     * 4. THE 'super' KEYWORD
     * Use Case: Inheritance. Refers to the direct PARENT class object.
     * ==========================================
     */
    
    class Parent {
        String role = "Admin";
        
        public Parent(String role) {
            this.role = role;
        }

        void printRole() {
            System.out.println("Parent Role: " + role);
        }
    }

    class Child extends Parent {
        String role = "Guest"; // Hides the parent's variable

        // Use Case A: Calling the parent's constructor (Must be first line)
        public Child() {
            super("SuperAdmin"); 
        }

        public void display() {
            // Use Case B: Accessing parent variables hidden by the child
            System.out.println("Child role: " + this.role); // Prints "Guest"
            System.out.println("Parent role: " + super.role); // Prints "SuperAdmin"

            // Use Case C: Calling parent methods that the child might have overridden
            super.printRole(); 
        }
    }
}

// Dummy class to make the 'this' database example compile mentally
class Database {
public static void save(KeywordMastery obj) {
System.out.println("Object saved.");
}
}