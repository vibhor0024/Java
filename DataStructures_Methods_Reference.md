import java.util.*;

public class MethodsCheatSheet {
public static void main(String[] args) {

        /**
         * ==========================================
         * 1. ARRAYS (Fixed Size)
         * Utility Class: java.util.Arrays
         * ==========================================
         */
        int[] arr = {4, 1, 3, 2};
        
        // Attributes
        int len = arr.length; // ATTRIBUTE: Returns total capacity (Note: no parentheses!)

        // Manipulation Methods
        Arrays.sort(arr); // Method: Sorts in ascending order in-place -> {1, 2, 3, 4}
        Arrays.fill(arr, 9); // Method: Overwrites entire array with the number 9
        
        // Copying Methods
        int[] copy = Arrays.copyOf(arr, 10); // Method: Copies array, pads with zeros up to new size 10
        int[] range = Arrays.copyOfRange(arr, 0, 2); // Method: Copies elements from index 0 up to (but not including) 2
        
        // Comparison & Conversion
        boolean isEqual = Arrays.equals(arr, copy); // Method: Compares actual contents of two arrays
        String arrStr = Arrays.toString(arr); // Method: Converts array to readable string "[1, 2, 3, 4]"


        /**
         * ==========================================
         * 2. STRINGS (Immutable Text)
         * ==========================================
         */
        String str = "Hello World";

        int sLen = str.length(); // Method: Number of characters (Note: requires parentheses!)
        char ch = str.charAt(0); // Method: Gets character at specific index ('H')
        String sub = str.substring(0, 5); // Method: Extracts "Hello" (end index 5 is exclusive)
        
        String[] parts = str.split(" "); // Method: Splits string into an array -> ["Hello", "World"]
        String replaced = str.replace("World", "Java"); // Method: Swaps text -> "Hello Java"
        
        boolean hasText = str.contains("llo"); // Method: Boolean check for substring
        boolean starts = str.startsWith("He"); // Method: Boolean check for prefix
        char[] charArray = str.toCharArray(); // Method: Converts string into a primitive char array


        /**
         * ==========================================
         * 3. LISTS (ArrayList / LinkedList)
         * ==========================================
         */
        List<String> list = new ArrayList<>();
        
        // Adding & Modifying
        list.add("A"); // Method: Appends to the very end
        list.add(0, "B"); // Method: Inserts exactly at index, shifts everything else right
        list.set(0, "C"); // Method: Overwrites the value at the given index
        
        // Retrieving & Checking
        String val = list.get(0); // Method: Retrieves value at index
        int lSize = list.size(); // Method: Current number of active elements (not capacity)
        boolean isEmp = list.isEmpty(); // Method: Returns true if size == 0
        boolean hasA = list.contains("A"); // Method: Linear search check
        
        // Removing
        list.remove("A"); // Method: Removes FIRST occurrence of this exact object
        list.remove(0); // Method: Removes whatever is at this index
        list.clear(); // Method: Wipes the entire list clean
        
        // Utilities
        Collections.sort(list); // Method: Sorts list alphabetically/numerically
        Collections.reverse(list); // Method: Flips the list upside down


        /**
         * ==========================================
         * 4. SETS (HashSet / TreeSet)
         * ==========================================
         */
        Set<Integer> set = new HashSet<>();
        set.add(1); // Method: Adds item. Returns false if it's already in the Set.
        set.contains(1); // Method: O(1) lightning-fast lookup check
        set.remove(1); // Method: Deletes the item

        // TreeSet Specific Methods (Since it's sorted)
        TreeSet<Integer> tree = new TreeSet<>(Arrays.asList(10, 20, 30));
        int first = tree.first(); // Method: Returns lowest element (10)
        int last = tree.last(); // Method: Returns highest element (30)
        int higher = tree.higher(15); // Method: Returns next highest element strictly greater than 15 (returns 20)


        /**
         * ==========================================
         * 5. MAPS (HashMap / TreeMap)
         * ==========================================
         */
        Map<String, String> map = new HashMap<>();
        
        // Adding & Updating
        map.put("Key", "Value"); // Method: Adds pair. If "Key" already exists, overwrites value.
        map.putIfAbsent("Key", "New"); // Method: Adds ONLY if key does not currently exist.
        
        // Retrieving & Checking
        String mVal = map.get("Key"); // Method: Retrieves value. Returns 'null' if missing!
        String defVal = map.getOrDefault("Bad", "Default"); // Method: Safe retrieval. Returns "Default" if missing.
        boolean hasKey = map.containsKey("Key"); // Method: Checks if key exists (Fast)
        boolean hasVal = map.containsValue("Value"); // Method: Checks if value exists (Slow, requires searching)
        
        // Removing & Extracting
        map.remove("Key"); // Method: Deletes the key-value pair
        Set<String> keys = map.keySet(); // Method: Extracts all Keys into a Set
        Collection<String> vals = map.values(); // Method: Extracts all Values into a Collection


        /**
         * ==========================================
         * 6. STACKS & QUEUES
         * ==========================================
         */
        // STACK (LIFO)
        Stack<Integer> stack = new Stack<>();
        stack.push(5); // Method: Adds to top
        stack.pop(); // Method: Removes and returns top
        stack.peek(); // Method: Looks at top without removing

        // QUEUE (FIFO)
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5); // Method: Adds to tail (safer than .add() which throws exceptions)
        queue.poll(); // Method: Removes and returns head (returns null if empty)
        queue.peek(); // Method: Looks at head without removing
    }
}