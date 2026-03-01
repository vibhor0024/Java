/**
 * ==========================================
 * FILE 4: OOP PILLARS & ARCHITECTURE
 * ==========================================
 */

/**
 * INTERFACE: A 100% abstract contract. Defines "What" a class should do.
 * Multiple inheritance is allowed with interfaces (a class can implement many).
 */
interface Connectable {
    boolean connectToWiFi(String network); // Public and abstract by default

    // 'default' (Java 8+) allows implementation inside an interface without breaking older code
    default void disconnect() {
        System.out.println("Disconnected from network.");
    }
}

/**
 * PILLAR 1: ABSTRACTION
 * Hiding complexity by using an abstract class that acts as a template.
 * Cannot be instantiated directly using 'new'. Defines "How" things are fundamentally.
 */
abstract class SmartDevice implements Connectable {

    /**
     * PILLAR 2: ENCAPSULATION
     * Hiding data from the outside world using 'private' modifiers.
     * Controlled access is provided via Getters and Setters.
     */
    private String deviceId;
    protected boolean isOn; // 'protected' visible to this class and subclasses

    public SmartDevice(String deviceId) {
        this.deviceId = deviceId; // 'this' resolves ambiguity between variable and parameter
        this.isOn = false;
    }

    // Getter for encapsulated data
    public String getDeviceId() { return deviceId; }

    // Abstract method: Forces subclasses to implement their own specific behavior
    abstract void performAction();
}

/**
 * PILLAR 3: INHERITANCE
 * SmartLight "is-a" SmartDevice and inherits its properties and methods.
 * Promotes code reusability.
 */
class SmartLight extends SmartDevice {
    private int brightness;

    public SmartLight(String deviceId) {
        // 'super' calls the constructor of the parent (SmartDevice) class
        super(deviceId);
        this.brightness = 0;
    }

    /**
     * PILLAR 4: POLYMORPHISM
     * "Many forms". Overriding the parent's abstract method with specific logic.
     * The program decides at runtime which specific version of the method to execute.
     */
    @Override
    void performAction() {
        this.isOn = true;
        this.brightness = 100;
        System.out.println("Light " + getDeviceId() + " is ON at full brightness.");
    }

    @Override
    public boolean connectToWiFi(String network) {
        System.out.println("Light connecting to 2.4GHz network: " + network);
        return true;
    }
}

// MAIN EXECUTION
public class SmartHomeSystem {
    public static void main(String[] args) {
        // POLYMORPHISM IN ACTION: A Parent reference holding a Child object!
        SmartDevice livingRoomLight = new SmartLight("LGT-01");

        livingRoomLight.connectToWiFi("HomeNet");
        // Dynamically resolves to SmartLight's implementation at runtime
        livingRoomLight.performAction();
    }
}