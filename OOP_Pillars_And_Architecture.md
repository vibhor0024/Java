// INTERFACE: 100% Abstract contract. Defines "What" it can do.
interface Connectable {
boolean connectToWiFi(String network); // Public and abstract by default
default void disconnect() { // 'default' allows implementation inside an interface (Java 8+)
System.out.println("Disconnected from network."); // Standard logic all implementing classes inherit
}
}

// 1. ABSTRACTION: Base template. Defines "How" things are fundamentally.
abstract class SmartDevice implements Connectable {
// 2. ENCAPSULATION: Data is hidden, only accessible via methods
private String deviceId;
protected boolean isOn; // 'protected' visible to subclasses

    public SmartDevice(String deviceId) {
        this.deviceId = deviceId; // 'this' resolves ambiguity between instance variable and parameter
        this.isOn = false; // Initial state
    }

    public String getDeviceId() { return deviceId; } // Getter for encapsulated data
    
    abstract void performAction(); // Abstract method forces subclasses to define specific behavior
}

// 3. INHERITANCE: SmartLight "is-a" SmartDevice
class SmartLight extends SmartDevice {
private int brightness;

    public SmartLight(String deviceId) {
        super(deviceId); // 'super' calls the parent constructor (SmartDevice) to initialize 'deviceId'
        this.brightness = 0; // Child-specific initialization
    }

    // 4. POLYMORPHISM: Overriding parent/interface methods with specific logic
    @Override
    void performAction() {
        this.isOn = true; // Accessing protected parent variable
        this.brightness = 100; // Accessing local variable
        System.out.println("Light " + getDeviceId() + " is ON at full brightness."); // Specific behavior
    }

    @Override
    public boolean connectToWiFi(String network) {
        System.out.println("Light connecting to 2.4GHz network: " + network); // Interface implementation
        return true; // Returns status
    }
}

public class SmartHomeSystem {
public static void main(String[] args) {
// POLYMORPHISM IN ACTION: Parent reference holding a Child object
SmartDevice livingRoomLight = new SmartLight("LGT-01");

        livingRoomLight.connectToWiFi("HomeNet"); // Calls the overridden method in SmartLight
        livingRoomLight.performAction(); // Dynamically resolves to SmartLight's implementation at runtime
    }
}