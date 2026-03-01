import java.util.*;

/**
 * ==========================================
 * FILE 3: MAPS, STACKS, QUEUES & HEAPS
 * ==========================================
 */
public class AdvancedDataStructures {
    public static void main(String[] args) {

        /**
         * HASHMAP (Key-Value Pairs)
         * Internals:
         * 1. Takes Key -> calculates hashCode().
         * 2. Uses Hash to find a "Bucket" (array index).
         * 3. Collision: If two keys land in same bucket, it uses a LinkedList or Tree.
         * 4. Uses .equals() to find exact key in the bucket.
         */
        Map<String, Integer> inventory = new HashMap<>(); // Unordered dictionary, O(1) average lookup
        inventory.put("Laptop", 5);
        inventory.put("Mouse", 20);
        inventory.put("Laptop", 10); // Overwrites previous value for "Laptop" (keys must be unique)

        // Pointer: getOrDefault prevents NullPointerException if the key doesn't exist
        int stock = inventory.getOrDefault("Keyboard", 0);

        // Iterating a Map efficiently using entrySet()
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String itemName = entry.getKey();
            Integer itemCount = entry.getValue();
        }

        /**
         * TREEMAP
         * Pointer: Keys are automatically sorted based on natural ordering (alphabetical/numerical).
         */
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Zebra", 1);
        sortedMap.put("Ape", 2); // "Ape" will be sorted to the front automatically

        /**
         * STACK (LIFO: Last-In-First-Out)
         * Pointer: Think of a stack of plates. You add to the top, and remove from the top.
         */
        Stack<String> browserHistory = new Stack<>();
        browserHistory.push("google.com");
        browserHistory.push("github.com");
        String currentSite = browserHistory.peek(); // Looks at top ("github.com") without removing it
        String previousSite = browserHistory.pop(); // Removes and returns "github.com"

        /**
         * QUEUE (FIFO: First-In-First-Out)
         * Pointer: Think of a line at a store. First person in is the first person served.
         */
        Queue<String> printQueue = new LinkedList<>(); // LinkedList implements Queue interface
        printQueue.offer("Doc_1.pdf"); // Adds to the tail (safer than .add() which can throw exceptions)
        printQueue.offer("Doc_2.pdf");
        String nextToPrint = printQueue.poll(); // Removes and returns "Doc_1.pdf" from the head

        /**
         * PRIORITY QUEUE (Min-Heap / Max-Heap)
         * Pointer: Not FIFO. Elements are ordered by priority.
         */
        // MIN-HEAP: Smallest element is always at the head.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(Arrays.asList(99, 1, 50));
        int smallest = minHeap.poll(); // Always removes and returns 1

        // MAX-HEAP: Uses Collections.reverseOrder() to put largest element at head.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(99, 1, 50));
        int largest = maxHeap.poll(); // Always removes and returns 99
    }
}