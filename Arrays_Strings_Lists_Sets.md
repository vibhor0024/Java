import java.util.*;

public class LinearDataStructures {
public static void main(String[] args) {
// STRINGS (Immutable)
String text = "  Java Programming  "; // Creates string literal in String Pool
String cleaned = text.trim().toUpperCase(); // Chains methods: removes spaces, converts to uppercase ("JAVA PROGRAMMING")
char letter = cleaned.charAt(0); // Retrieves character at index 0 ('J')
boolean isMatch = cleaned.equals("JAVA"); // Compares actual content, NOT memory address (never use == for Strings)

        // ARRAYS (Fixed Size)
        int[] numbers = new int[5]; // Creates array of exactly 5 integers (defaults to 0)
        int capacity = numbers.length; // Returns the total size allocated (5)
        int[] populated = {5, 2, 8, 1, 9}; // Inline initialization
        Arrays.sort(populated); // Sorts array in-place: {1, 2, 5, 8, 9}
        int index = Arrays.binarySearch(populated, 5); // Finds index of '5' (must be sorted first)
        int[] copied = Arrays.copyOf(populated, 10); // Creates new array of size 10, copies old values, pads rest with 0

        // ARRAYLIST (Dynamic Array - Fast Reads)
        List<String> dynamicList = new ArrayList<>(); // Initializes empty dynamic array
        dynamicList.add("Apple"); // Appends to end, O(1) amortized time
        dynamicList.add(0, "Banana"); // Inserts at index 0, shifts rest right O(n) time
        String fruit = dynamicList.get(1); // Retrieves element at index 1 ("Apple"), O(1) time
        dynamicList.remove("Apple"); // Finds and removes first instance of "Apple"

        // LINKEDLIST (Doubly Linked Nodes - Fast Inserts/Deletes)
        LinkedList<String> linkedList = new LinkedList<>(); // Nodes contain data + pointers to next/prev
        linkedList.addFirst("Start"); // Instantly adds to head, O(1) time
        linkedList.addLast("End"); // Instantly adds to tail, O(1) time
        linkedList.removeFirst(); // Instantly removes head, O(1) time

        // SETS (Unique Elements Only)
        Set<Integer> hashSet = new HashSet<>(); // Unordered, backed by HashMap
        boolean added1 = hashSet.add(10); // Returns true (successful addition)
        boolean added2 = hashSet.add(10); // Returns false (duplicate ignored, size stays 1)

        Set<Integer> treeSet = new TreeSet<>(); // Ordered naturally, backed by Red-Black Tree
        treeSet.add(50); // Adds element
        treeSet.add(20); // Adds element
        treeSet.add(80); // Adds element
        // Iterating treeSet guarantees output: 20, 50, 80 (O(log n) sorting time)
    }
}