import java.util.*;

public class AdvancedDataStructures {
public static void main(String[] args) {
// HASHMAP (Key-Value Pairs)
Map<String, Integer> inventory = new HashMap<>(); // Unordered dictionary, O(1) average lookup
inventory.put("Laptop", 5); // Stores key "Laptop" with value 5
inventory.put("Mouse", 20); // Stores another pair
inventory.put("Laptop", 10); // Overwrites previous value for "Laptop" (keys must be unique)
int stock = inventory.getOrDefault("Keyboard", 0); // Returns 0 instead of null if key doesn't exist

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) { // Best way to iterate a Map
            String itemName = entry.getKey(); // Extracts the key
            Integer itemCount = entry.getValue(); // Extracts the value
        }

        // TREEMAP (Sorted Key-Value Pairs)
        TreeMap<String, Integer> sortedMap = new TreeMap<>(); // Keys are automatically sorted alphabetically
        sortedMap.put("Zebra", 1); // Added to map
        sortedMap.put("Ape", 2); // Added and sorted to the front

        // STACK (LIFO: Last-In-First-Out)
        Stack<String> browserHistory = new Stack<>(); // Extends Vector, synchronized
        browserHistory.push("google.com"); // Pushes to the top of the stack
        browserHistory.push("github.com"); // Pushes to the top
        String currentSite = browserHistory.peek(); // Looks at top ("github.com") without removing it
        String previousSite = browserHistory.pop(); // Removes and returns "github.com", stack is now just ["google.com"]

        // QUEUE (FIFO: First-In-First-Out)
        Queue<String> printQueue = new LinkedList<>(); // LinkedList implements Queue interface
        printQueue.offer("Document_1.pdf"); // Adds to the tail of the queue
        printQueue.offer("Document_2.pdf"); // Adds to the tail
        String nextToPrint = printQueue.poll(); // Removes and returns "Document_1.pdf" from the head

        // PRIORITY QUEUE (Min-Heap / Max-Heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Smallest element is always at the head
        minHeap.addAll(Arrays.asList(99, 1, 50)); // Adds multiple elements
        int smallest = minHeap.poll(); // Always removes and returns 1, regardless of insertion order

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Reverses logic to Max-Heap
        maxHeap.addAll(Arrays.asList(99, 1, 50)); // Adds multiple elements
        int largest = maxHeap.poll(); // Always removes and returns 99
    }
}