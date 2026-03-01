import java.util.*;

/**
 * ==========================================
 * FILE 2: ARRAYS, STRINGS, LISTS & SETS
 * ==========================================
 */
public class LinearDataStructures {
    public static void main(String[] args) {

        /**
         * STRINGS
         * Pointer: Strings are Immutable. Methods return a NEW string, the original stays the same.
         * They are stored in a special memory area called the String Pool.
         */
        String text = "  Java Programming  ";
        String cleaned = text.trim().toUpperCase(); // Chains methods: "JAVA PROGRAMMING"
        char letter = cleaned.charAt(0); // Retrieves character at index 0 ('J')

        // Pointer: Always use .equals() for String content comparison. '==' compares memory addresses!
        boolean isMatch = cleaned.equals("JAVA");

        /**
         * ARRAYS
         * Pointer: Fixed size. Cannot grow or shrink after creation.
         */
        int[] numbers = new int[5]; // Creates array of exactly 5 integers (defaults to 0)
        int[] populated = {5, 2, 8, 1, 9}; // Inline initialization

        Arrays.sort(populated); // Sorts array in-place: {1, 2, 5, 8, 9}
        int index = Arrays.binarySearch(populated, 5); // O(log n) search. Pointer: Array MUST be sorted first!

        /**
         * ARRAYLIST (Dynamic Array)
         * Pointer: Best for frequent reading (O(1) access). Worst for inserting in the middle (O(n) shifting).
         * Only stores Reference types (Objects). Use Wrapper classes like Integer, Double.
         */
        List<String> dynamicList = new ArrayList<>();
        dynamicList.add("Apple"); // Appends to end, O(1) amortized time
        dynamicList.add(0, "Banana"); // Inserts at index 0, shifts rest right O(n) time
        String fruit = dynamicList.get(1); // Retrieves element, O(1) time

        /**
         * LINKEDLIST (Doubly Linked Nodes)
         * Pointer: Best for frequent inserts/deletes at the start or end. Elements are connected via pointers.
         */
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("Start"); // Instantly adds to head, O(1) time
        linkedList.addLast("End"); // Instantly adds to tail, O(1) time
        linkedList.removeFirst(); // Instantly removes head, O(1) time

        /**
         * SETS (Unique Elements Only)
         * Pointer: No duplicates allowed. Good for mathematical set operations or ensuring uniqueness.
         */
        // HASHSET: Unordered, backed by a HashMap. O(1) for add/remove/contains.
        Set<Integer> hashSet = new HashSet<>();
        boolean added1 = hashSet.add(10); // Returns true (successful addition)
        boolean added2 = hashSet.add(10); // Returns false (duplicate ignored, size stays 1)

        // TREESET: Ordered naturally, backed by a Red-Black Tree. O(log n) performance.
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        // Iterating treeSet guarantees output: 20, 50, 80
    }
}