import java.util.*;

/**
 * ==========================================
 * FILE 7: DATA STRUCTURES METHODS & ATTRIBUTES REFERENCE
 * ==========================================
 */
public class MethodsCheatSheet {
    public static void main(String[] args) {

        // --- 1. ARRAYS ---
        int[] arr = {4, 1, 3, 2};
        // ATTRIBUTE: Returns total capacity. Note: no parentheses!
        int len = arr.length;

        // MANIPULATION
        Arrays.sort(arr); // In-place ascending sort
        Arrays.fill(arr, 9); // Overwrites entire array with 9s
        int[] copy = Arrays.copyOf(arr, 10); // Copies and pads with zeros up to size 10
        int[] range = Arrays.copyOfRange(arr, 0, 2); // Copies elements from index 0 to 1


        // --- 2. STRINGS ---
        String str = "Hello World";
        // METHOD: Number of characters. Note: requires parentheses!
        int sLen = str.length();

        // MANIPULATION
        char ch = str.charAt(0); // Gets character ('H')
        String sub = str.substring(0, 5); // Extracts "Hello" (end index exclusive)
        String[] parts = str.split(" "); // Splits into array -> ["Hello", "World"]
        String replaced = str.replace("World", "Java"); // "Hello Java"
        boolean hasText = str.contains("llo");


        // --- 3. LISTS ---
        List<String> list = new ArrayList<>();
        list.add("A"); // Appends to end
        list.add(0, "B"); // Inserts exactly at index, shifts right
        list.set(0, "C"); // Overwrites value at index

        // RETRIEVAL & UTILS
        String val = list.get(0);
        int lSize = list.size(); // Current active elements (not capacity)
        list.remove("A"); // Removes FIRST occurrence of object
        Collections.sort(list); // Sorts alphabetically
        Collections.reverse(list); // Flips upside down


        // --- 4. SETS ---
        Set<Integer> set = new HashSet<>();
        set.add(1); // Returns false if it's already in the Set
        set.contains(1); // O(1) lightning-fast check

        // TREESET SPECIFIC
        TreeSet<Integer> tree = new TreeSet<>(Arrays.asList(10, 20, 30));
        int first = tree.first(); // Returns lowest (10)
        int higher = tree.higher(15); // Returns next highest strictly > 15 (returns 20)


        // --- 5. MAPS ---
        Map<String, String> map = new HashMap<>();
        map.put("Key", "Value"); // Adds/Overwrites pair
        map.putIfAbsent("Key", "New"); // Adds ONLY if key missing

        // RETRIEVAL
        String mVal = map.get("Key"); // Returns 'null' if missing
        String defVal = map.getOrDefault("Bad", "Default"); // Safe retrieval
        boolean hasKey = map.containsKey("Key"); // Fast O(1) check

        // EXTRACTING
        Set<String> keys = map.keySet(); // Extracts all Keys
        Collection<String> vals = map.values(); // Extracts all Values


        // --- 6. STACKS & QUEUES ---
        Stack<Integer> stack = new Stack<>();
        stack.push(5); // Adds to top
        stack.pop(); // Removes and returns top

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5); // Adds to tail
        queue.poll(); // Removes and returns head (returns null if empty)
    }
}