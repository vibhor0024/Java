/**
 * ==========================================
 * FILE 6: CORE KEYWORDS DEEP DIVE (static, final, this, super)
 * ==========================================
 */

class ParentProfile {
    String role = "Admin";
    public ParentProfile(String role) { this.role = role; }
    void printRole() { System.out.println("Parent Role: " + role); }
}

class ChildProfile extends ParentProfile {
    String role = "Guest"; // Variable Hiding: Child hides parent's variable

    // SUPER USE CASE 1: Calling parent's constructor (Must be first line)
    public ChildProfile() {
        super("SuperAdmin");
    }

    public void display() {
        // THIS USE CASE 1: Accessing current class variable
        System.out.println("Child role: " + this.role); // "Guest"

        // SUPER USE CASE 2: Accessing parent variables hidden by the child
        System.out.println("Parent role: " + super.role); // "SuperAdmin"

        // SUPER USE CASE 3: Calling parent methods that the child might have overridden
        super.printRole();
    }
}

public class KeywordMastery {

    /**
     * STATIC: "Belongs to the CLASS"
     * Shared across all instances. Can be called without creating an object.
     * Rule: Static methods CANNOT access non-static variables or 'this'.
     */
    public static int globalEmployeeCount = 0;

    /**
     * FINAL: "Cannot be changed"
     * On Variable: Constant value.
     * On Method: Cannot be overridden by child classes.
     * On Class: Cannot be extended (inherited).
     */
    public final double PI = 3.14159;

    private String name;

    // THIS USE CASE 2: Constructor Chaining
    // If someone doesn't provide a name, call the OTHER constructor using this()
    public KeywordMastery() {
        this("Unknown User"); // Must be the VERY FIRST line
    }

    // THIS USE CASE 3: Resolving ambiguity between instance variable and parameter
    public KeywordMastery(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ChildProfile profile = new ChildProfile();
        profile.display();
    }
}