import java.util.*;
import java.util.concurrent.*;

/**
 * COMPREHENSIVE HASHMAP VS TREEMAP DEMONSTRATION
 * Complete with internal working comments and all methods
 */
public class MapComparison {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("HASHMAP VS TREEMAP - COMPLETE COMPARISON");
        System.out.println("=".repeat(80));
        
        // SECTION 1: Basic Creation and Insertion
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 1: CREATION AND INSERTION");
        System.out.println("#".repeat(60));
        demonstrateCreation();
        
        // SECTION 2: Ordering Demonstration
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 2: ORDERING DEMONSTRATION");
        System.out.println("#".repeat(60));
        demonstrateOrdering();
        
        // SECTION 3: Null Handling
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 3: NULL HANDLING");
        System.out.println("#".repeat(60));
        demonstrateNullHandling();
        
        // SECTION 4: Performance Comparison
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 4: PERFORMANCE COMPARISON");
        System.out.println("#".repeat(60));
        demonstratePerformance();
        
        // SECTION 5: TreeMap Specific Methods
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 5: TREEMAP SPECIFIC METHODS");
        System.out.println("#".repeat(60));
        demonstrateTreeMapSpecific();
        
        // SECTION 6: HashMap Specific Features
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 6: HASHMAP SPECIFIC FEATURES");
        System.out.println("#".repeat(60));
        demonstrateHashMapSpecific();
        
        // SECTION 7: Custom Objects
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 7: CUSTOM OBJECTS");
        System.out.println("#".repeat(60));
        demonstrateCustomObjects();
        
        // SECTION 8: Synchronized Versions
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 8: THREAD-SAFE VERSIONS");
        System.out.println("#".repeat(60));
        demonstrateThreadSafe();
        
        // SECTION 9: Common Operations
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 9: COMMON OPERATIONS");
        System.out.println("#".repeat(60));
        demonstrateCommonOperations();
        
        // SECTION 10: Interview Questions
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 10: INTERVIEW QUESTIONS & ANSWERS");
        System.out.println("#".repeat(60));
        demonstrateInterviewQuestions();
    }
    
    // =========================================================================
    // SECTION 1: CREATION AND INSERTION
    // =========================================================================
    
    private static void demonstrateCreation() {
        System.out.println("\n📌 HashMap Creation:");
        // Default (capacity 16, load factor 0.75)
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Cherry", 30);
        System.out.println("   HashMap: " + hashMap);
        
        // With initial capacity
        HashMap<String, Integer> hashMap2 = new HashMap<>(32);
        
        // With load factor
        HashMap<String, Integer> hashMap3 = new HashMap<>(16, 0.8f);
        
        // From another map
        HashMap<String, Integer> hashMap4 = new HashMap<>(hashMap);
        System.out.println("   HashMap from existing: " + hashMap4);
        
        System.out.println("\n📌 TreeMap Creation:");
        // Default (natural ordering)
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Apple", 10);
        treeMap.put("Banana", 20);
        treeMap.put("Cherry", 30);
        System.out.println("   TreeMap: " + treeMap);
        
        // With custom comparator (reverse order)
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(Comparator.reverseOrder());
        treeMap2.put("Apple", 10);
        treeMap2.put("Banana", 20);
        treeMap2.put("Cherry", 30);
        System.out.println("   TreeMap (reverse order): " + treeMap2);
        
        // From another map
        TreeMap<String, Integer> treeMap3 = new TreeMap<>(hashMap);
        System.out.println("   TreeMap from HashMap: " + treeMap3);
    }
    
    // =========================================================================
    // SECTION 2: ORDERING DEMONSTRATION
    // =========================================================================
    
    private static void demonstrateOrdering() {
        // HashMap - No ordering
        System.out.println("\n📌 HashMap (No ordering):");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(5, "Five");
        hashMap.put(1, "One");
        hashMap.put(4, "Four");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        System.out.println("   HashMap: " + hashMap);
        System.out.println("   Order unpredictable: " + hashMap.keySet());
        
        // TreeMap - Sorted order
        System.out.println("\n📌 TreeMap (Sorted order):");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "Five");
        treeMap.put(1, "One");
        treeMap.put(4, "Four");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        System.out.println("   TreeMap: " + treeMap);
        System.out.println("   Sorted keys: " + treeMap.keySet());
        
        // LinkedHashMap - Insertion order
        System.out.println("\n📌 LinkedHashMap (Insertion order):");
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(5, "Five");
        linkedMap.put(1, "One");
        linkedMap.put(4, "Four");
        linkedMap.put(2, "Two");
        linkedMap.put(3, "Three");
        System.out.println("   LinkedHashMap: " + linkedMap);
        System.out.println("   Insertion order preserved: " + linkedMap.keySet());
    }
    
    // =========================================================================
    // SECTION 3: NULL HANDLING
    // =========================================================================
    
    private static void demonstrateNullHandling() {
        System.out.println("\n📌 HashMap Null Handling:");
        HashMap<String, String> hashMap = new HashMap<>();
        
        // HashMap allows one null key
        hashMap.put(null, "Null Key Value");
        hashMap.put("A", null);
        hashMap.put("B", null);
        
        System.out.println("   HashMap with null key: " + hashMap.get(null));
        System.out.println("   HashMap with null values: " + hashMap.get("A") + ", " + hashMap.get("B"));
        System.out.println("   Complete HashMap: " + hashMap);
        
        System.out.println("\n📌 TreeMap Null Handling:");
        TreeMap<String, String> treeMap = new TreeMap<>();
        
        try {
            treeMap.put(null, "This will fail");
        } catch (NullPointerException e) {
            System.out.println("   ❌ TreeMap doesn't allow null keys: " + e);
        }
        
        // TreeMap allows null values
        treeMap.put("A", null);
        treeMap.put("B", null);
        System.out.println("   TreeMap with null values: " + treeMap);
    }
    
    // =========================================================================
    // SECTION 4: PERFORMANCE COMPARISON
    // =========================================================================
    
    private static void demonstratePerformance() {
        int size = 1_000_000;
        Random random = new Random(123);
        
        // HashMap Performance
        System.out.println("\n📌 HashMap Performance (O(1)):");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, random.nextInt());
        }
        long putTime = System.nanoTime() - start;
        System.out.println("   Put " + size + " entries: " + putTime / 1_000_000 + "ms");
        
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            hashMap.get(random.nextInt(size));
        }
        long getTime = System.nanoTime() - start;
        System.out.println("   Get 1000 random entries: " + getTime / 1_000 + "μs");
        
        // TreeMap Performance
        System.out.println("\n📌 TreeMap Performance (O(log n)):");
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            treeMap.put(i, random.nextInt());
        }
        putTime = System.nanoTime() - start;
        System.out.println("   Put " + size + " entries: " + putTime / 1_000_000 + "ms");
        
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            treeMap.get(random.nextInt(size));
        }
        getTime = System.nanoTime() - start;
        System.out.println("   Get 1000 random entries: " + getTime / 1_000 + "μs");
    }
    
    // =========================================================================
    // SECTION 5: TREEMAP SPECIFIC METHODS
    // =========================================================================
    
    private static void demonstrateTreeMapSpecific() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "One");
        treeMap.put(3, "Three");
        treeMap.put(5, "Five");
        treeMap.put(7, "Seven");
        treeMap.put(9, "Nine");
        treeMap.put(2, "Two");
        treeMap.put(4, "Four");
        treeMap.put(6, "Six");
        treeMap.put(8, "Eight");
        treeMap.put(10, "Ten");
        
        System.out.println("\n📌 TreeMap: " + treeMap);
        
        // Navigation methods
        System.out.println("\n📌 Navigation Methods:");
        System.out.println("   firstKey(): " + treeMap.firstKey());
        System.out.println("   lastKey(): " + treeMap.lastKey());
        System.out.println("   firstEntry(): " + treeMap.firstEntry());
        System.out.println("   lastEntry(): " + treeMap.lastEntry());
        
        // Lower/Higher
        System.out.println("\n📌 Lower/Higher Methods:");
        System.out.println("   lowerKey(5): " + treeMap.lowerKey(5));     // < 5
        System.out.println("   floorKey(5): " + treeMap.floorKey(5));     // <= 5
        System.out.println("   ceilingKey(5): " + treeMap.ceilingKey(5)); // >= 5
        System.out.println("   higherKey(5): " + treeMap.higherKey(5));   // > 5
        
        System.out.println("   lowerEntry(5): " + treeMap.lowerEntry(5));
        System.out.println("   floorEntry(5): " + treeMap.floorEntry(5));
        System.out.println("   ceilingEntry(5): " + treeMap.ceilingEntry(5));
        System.out.println("   higherEntry(5): " + treeMap.higherEntry(5));
        
        // Submaps
        System.out.println("\n📌 Submap Methods:");
        System.out.println("   headMap(5): " + treeMap.headMap(5));           // < 5
        System.out.println("   headMap(5, true): " + treeMap.headMap(5, true)); // <= 5
        
        System.out.println("   tailMap(5): " + treeMap.tailMap(5));           // >= 5
        System.out.println("   tailMap(5, false): " + treeMap.tailMap(5, false)); // > 5
        
        System.out.println("   subMap(3, 7): " + treeMap.subMap(3, 7));       // 3 to 6
        System.out.println("   subMap(3, true, 7, false): " + 
                          treeMap.subMap(3, true, 7, false)); // 3 to 6
        
        // Poll methods (remove and return)
        System.out.println("\n📌 Poll Methods:");
        System.out.println("   pollFirstEntry(): " + treeMap.pollFirstEntry());
        System.out.println("   pollLastEntry(): " + treeMap.pollLastEntry());
        System.out.println("   After polling: " + treeMap);
        
        // Descending views
        System.out.println("\n📌 Descending Views:");
        System.out.println("   descendingKeySet(): " + treeMap.descendingKeySet());
        System.out.println("   descendingMap(): " + treeMap.descendingMap());
    }
    
    // =========================================================================
    // SECTION 6: HASHMAP SPECIFIC FEATURES
    // =========================================================================
    
    private static void demonstrateHashMapSpecific() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D", 4);
        
        System.out.println("\n📌 HashMap: " + hashMap);
        
        // Java 8+ HashMap enhancements
        System.out.println("\n📌 Java 8+ HashMap Methods:");
        
        // compute
        hashMap.compute("A", (k, v) -> v == null ? 0 : v * 10);
        System.out.println("   compute('A', multiply by 10): " + hashMap.get("A"));
        
        // computeIfAbsent
        hashMap.computeIfAbsent("E", k -> 5);
        System.out.println("   computeIfAbsent('E'): " + hashMap.get("E"));
        
        // computeIfPresent
        hashMap.computeIfPresent("B", (k, v) -> v + 100);
        System.out.println("   computeIfPresent('B'): " + hashMap.get("B"));
        
        // merge
        hashMap.merge("C", 10, (oldVal, newVal) -> oldVal + newVal);
        System.out.println("   merge('C', 10): " + hashMap.get("C"));
        
        // getOrDefault
        System.out.println("   getOrDefault('X', 999): " + 
                          hashMap.getOrDefault("X", 999));
        
        // putIfAbsent
        hashMap.putIfAbsent("A", 1000); // Won't change because key exists
        hashMap.putIfAbsent("F", 6);    // Will add because key doesn't exist
        System.out.println("   putIfAbsent('A', 1000): " + hashMap.get("A"));
        System.out.println("   putIfAbsent('F', 6): " + hashMap.get("F"));
        
        // replace methods
        hashMap.replace("B", 102); // Replace regardless
        hashMap.replace("B", 102, 202); // Replace only if current value is 102
        System.out.println("   replace('B'): " + hashMap.get("B"));
        
        // forEach
        System.out.println("\n📌 forEach iteration:");
        hashMap.forEach((k, v) -> System.out.println("   " + k + " -> " + v));
    }
    
    // =========================================================================
    // SECTION 7: CUSTOM OBJECTS
    // =========================================================================
    
    static class Employee {
        int id;
        String name;
        
        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        // Proper equals and hashCode for HashMap
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee emp = (Employee) o;
            return id == emp.id && Objects.equals(name, emp.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
        
        // Natural ordering for TreeMap (implements Comparable)
        static class ComparableEmployee extends Employee implements Comparable<ComparableEmployee> {
            ComparableEmployee(int id, String name) {
                super(id, name);
            }
            
            @Override
            public int compareTo(ComparableEmployee o) {
                return Integer.compare(this.id, o.id);
            }
        }
        
        @Override
        public String toString() {
            return "Emp{" + id + ":" + name + "}";
        }
    }
    
    private static void demonstrateCustomObjects() {
        System.out.println("\n📌 HashMap with Custom Object (requires hashCode/equals):");
        HashMap<Employee, String> empMap = new HashMap<>();
        
        Employee e1 = new Employee(101, "John");
        Employee e2 = new Employee(102, "Jane");
        Employee e3 = new Employee(101, "John"); // Same as e1
        
        empMap.put(e1, "Developer");
        empMap.put(e2, "Manager");
        empMap.put(e3, "Lead"); // This will replace e1 because equals/hashCode works
        
        System.out.println("   HashMap size: " + empMap.size());
        System.out.println("   Map: " + empMap);
        System.out.println("   Get e1: " + empMap.get(e1));
        
        System.out.println("\n📌 TreeMap with Custom Object (requires Comparable/Comparator):");
        
        // Using Comparator
        TreeMap<Employee, String> empTreeMap = new TreeMap<>(
            (empA, empB) -> Integer.compare(empA.id, empB.id)
        );
        
        empTreeMap.put(new Employee(5, "Eve"), "QA");
        empTreeMap.put(new Employee(2, "Bob"), "Dev");
        empTreeMap.put(new Employee(8, "Alice"), "HR");
        empTreeMap.put(new Employee(1, "Charlie"), "Ops");
        
        System.out.println("   TreeMap with Comparator (sorted by id): " + empTreeMap);
        
        // Using Comparable
        TreeMap<Employee.ComparableEmployee, String> comparableMap = new TreeMap<>();
        comparableMap.put(new Employee.ComparableEmployee(5, "Eve"), "QA");
        comparableMap.put(new Employee.ComparableEmployee(2, "Bob"), "Dev");
        comparableMap.put(new Employee.ComparableEmployee(8, "Alice"), "HR");
        comparableMap.put(new Employee.ComparableEmployee(1, "Charlie"), "Ops");
        
        System.out.println("   TreeMap with Comparable (sorted by id): " + comparableMap);
    }
    
    // =========================================================================
    // SECTION 8: THREAD-SAFE VERSIONS
    // =========================================================================
    
    private static void demonstrateThreadSafe() {
        System.out.println("\n📌 Synchronized HashMap:");
        Map<String, String> syncHashMap = Collections.synchronizedMap(new HashMap<>());
        syncHashMap.put("A", "Apple");
        syncHashMap.put("B", "Banana");
        System.out.println("   Synchronized HashMap: " + syncHashMap);
        
        System.out.println("\n📌 ConcurrentHashMap (better performance):");
        ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", "Apple");
        concurrentMap.put("B", "Banana");
        System.out.println("   ConcurrentHashMap: " + concurrentMap);
        
        // ConcurrentHashMap specific methods
        concurrentMap.putIfAbsent("C", "Cherry");
        concurrentMap.replace("A", "Apple", "Apricot");
        System.out.println("   After putIfAbsent/replace: " + concurrentMap);
        
        System.out.println("\n📌 Synchronized TreeMap:");
        SortedMap<String, String> syncTreeMap = Collections.synchronizedSortedMap(new TreeMap<>());
        syncTreeMap.put("C", "Cat");
        syncTreeMap.put("A", "Apple");
        syncTreeMap.put("B", "Ball");
        System.out.println("   Synchronized TreeMap (sorted): " + syncTreeMap);
        
        System.out.println("\n📌 ConcurrentSkipListMap (concurrent version of TreeMap):");
        ConcurrentSkipListMap<String, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put("C", "Cat");
        skipListMap.put("A", "Apple");
        skipListMap.put("B", "Ball");
        System.out.println("   ConcurrentSkipListMap: " + skipListMap);
        System.out.println("   firstEntry(): " + skipListMap.firstEntry());
    }
    
    // =========================================================================
    // SECTION 9: COMMON OPERATIONS
    // =========================================================================
    
    private static void demonstrateCommonOperations() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        
        System.out.println("\n📌 Common Map Operations:");
        
        // size and isEmpty
        System.out.println("   size(): " + hashMap.size());
        System.out.println("   isEmpty(): " + hashMap.isEmpty());
        
        // containsKey and containsValue
        System.out.println("   containsKey('A'): " + hashMap.containsKey("A"));
        System.out.println("   containsValue(2): " + hashMap.containsValue(2));
        
        // get and getOrDefault
        System.out.println("   get('A'): " + hashMap.get("A"));
        System.out.println("   getOrDefault('Z', 0): " + hashMap.getOrDefault("Z", 0));
        
        // keySet, values, entrySet
        System.out.println("   keySet(): " + hashMap.keySet());
        System.out.println("   values(): " + hashMap.values());
        System.out.println("   entrySet(): " + hashMap.entrySet());
        
        // remove
        hashMap.remove("B");
        System.out.println("   remove('B'): " + hashMap);
        
        // clear
        HashMap<String, Integer> tempMap = new HashMap<>(hashMap);
        tempMap.clear();
        System.out.println("   clear(): " + tempMap);
        
        // putAll
        HashMap<String, Integer> newMap = new HashMap<>();
        newMap.put("X", 100);
        newMap.put("Y", 200);
        hashMap.putAll(newMap);
        System.out.println("   putAll(): " + hashMap);
        
        // Iteration methods
        System.out.println("\n📌 Iteration Methods:");
        
        System.out.println("   Using keySet():");
        for (String key : treeMap.keySet()) {
            System.out.println("     " + key + " -> " + treeMap.get(key));
        }
        
        System.out.println("   Using entrySet():");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("     " + entry.getKey() + " -> " + entry.getValue());
        }
        
        System.out.println("   Using forEach() (Java 8+):");
        treeMap.forEach((k, v) -> System.out.println("     " + k + " -> " + v));
        
        System.out.println("   Using iterator:");
        Iterator<Map.Entry<String, Integer>> it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("     " + entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    // =========================================================================
    // SECTION 10: INTERVIEW QUESTIONS & ANSWERS
    // =========================================================================
    
    private static void demonstrateInterviewQuestions() {
        System.out.println("\n📌 Q1: How does HashMap handle collisions?");
        System.out.println("   A: HashMap uses chaining. When multiple keys hash to same bucket,");
        System.out.println("      they're stored as linked list. After threshold (8), converts to tree.");
        
        System.out.println("\n📌 Q2: What's the initial capacity and load factor?");
        System.out.println("   A: Initial capacity = 16, Load factor = 0.75");
        System.out.println("      Resizes when size > capacity * load factor");
        
        System.out.println("\n📌 Q3: How does TreeMap maintain order?");
        System.out.println("   A: Uses Red-Black tree, self-balancing binary search tree.");
        System.out.println("      Insertions and deletions maintain sorted order.");
        
        System.out.println("\n📌 Q4: When to use HashMap vs TreeMap?");
        System.out.println("   A: HashMap for fast O(1) operations, no order needed");
        System.out.println("      TreeMap when sorted order required, O(log n) operations");
        
        System.out.println("\n📌 Q5: Can HashMap store duplicate keys?");
        System.out.println("   A: No, keys are unique. New value overwrites old one.");
        
        // Demonstration of key uniqueness
        HashMap<String, String> demo = new HashMap<>();
        demo.put("key", "value1");
        demo.put("key", "value2");
        System.out.println("   Demo: " + demo); // Shows {key=value2}
        
        System.out.println("\n📌 Q6: How to make HashMap thread-safe?");
        System.out.println("   A: 1. Collections.synchronizedMap(new HashMap<>())");
        System.out.println("      2. ConcurrentHashMap (better performance)");
        
        System.out.println("\n📌 Q7: What's the difference between HashMap and Hashtable?");
        System.out.println("   A: - Hashtable is synchronized, HashMap is not");
        System.out.println("      - Hashtable doesn't allow null keys/values");
        System.out.println("      - HashMap allows one null key, multiple null values");
        
        System.out.println("\n📌 Q8: How does computeIfAbsent() work?");
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent("numbers", k -> new ArrayList<>()).add(42);
        System.out.println("   computeIfAbsent: " + map);
        
        System.out.println("\n📌 Q9: What's the time complexity of operations?");
        System.out.println("   HashMap: get/put - O(1) average, O(n) worst case");
        System.out.println("   TreeMap: get/put - O(log n) always");
        
        System.out.println("\n📌 Q10: Can TreeMap have null keys?");
        System.out.println("   A: No, throws NullPointerException");
        try {
            new TreeMap<>().put(null, "value");
        } catch (NullPointerException e) {
            System.out.println("      ✓ Throws NullPointerException");
        }
    }
}



// HashMap vs TreeMap - Complete Interview Guide
// Quick Answer for Interview:
// "HashMap and TreeMap are both implementations of the Map interface in Java,
//  but they differ in ordering, performance, and internal working. 
// HashMap uses hashing for O(1) operations but doesn't maintain order, 
// while TreeMap uses a Red-Black tree for O(log n) operations and maintains keys in sorted order."


// HashMap Internal Working
// java
/**
 * HASHMAP INTERNAL WORKING
 * 
 * Data Structure: Array of Nodes (buckets) + LinkedList/Tree
 * Initial Capacity: 16 buckets
 * Load Factor: 0.75 (when 75% full, resizes)
 * 
 * PUT Operation:
 * 1. Calculate hash code of key: key.hashCode()
 * 2. Apply hash function to find bucket index: index = hash & (n-1)
 * 3. If bucket empty -> create new node and store
 * 4. If bucket has nodes:
 *    - Check if key exists (equals() method)
 *    - If exists, replace value
 *    - If not, add to linked list (or tree if threshold met)
 * 
 * GET Operation:
 * 1. Calculate hash code of key
 * 2. Find bucket index
 * 3. Search in bucket (linked list or tree) using equals()
 * 4. Return value if found, else null
 * 
 * RESIZE Operation:
 * - When size > capacity * load factor
 * - Creates new array with double capacity
 * - Rehashes all entries (recalculates indices)
 */
// TreeMap Internal Working
// java
/**
 * TREEMAP INTERNAL WORKING
 * 
 * Data Structure: Red-Black Tree (self-balancing binary search tree)
 * 
 * Properties of Red-Black Tree:
 * 1. Every node is either red or black
 * 2. Root is always black
 * 3. No two consecutive red nodes
 * 4. Same number of black nodes in all paths
 * 
 * PUT Operation:
 * 1. Start at root
 * 2. Compare keys using compareTo() or Comparator
 * 3. Traverse left if key < current, right if key > current
 * 4. Insert new node (red)
 * 5. Fix violations (recolor and rotate)
 * 
 * GET Operation:
 * 1. Binary search through tree (O(log n))
 * 2. Compare keys at each node
 * 3. Return value when found
 * 
 * ROTATIONS:
 * - Left rotation: Right child becomes parent
 * - Right rotation: Left child becomes parent
 * - Maintains tree balance
 */
// 2. KEY DIFFERENCES - HashMap vs TreeMap
// Feature	HashMap	TreeMap
// Ordering	No order guaranteed	Sorted order (natural or custom)
// Null Keys	One null key allowed	No null keys (throws NPE)
// Null Values	Multiple null values allowed	Multiple null values allowed
// Performance	O(1) for put/get	O(log n) for put/get
// Data Structure	Array of buckets + LinkedList/Tree	Red-Black Tree
// Thread Safety	Not synchronized	Not synchronized
// Comparable	Uses hashCode() and equals()	Uses compareTo() or Comparator
// Memory	Less memory overhead	More memory overhead
// Iteration Order	Unpredictable	Sorted by keys
// Since	Java 1.2	Java 1.2
// Implements	Map	NavigableMap, SortedMap

// INTERVIEW CHEAT SHEET
// HashMap Key Points:
// ✅ O(1) average time complexity

// ✅ Allows one null key, multiple null values

// ✅ Not synchronized

// ✅ No ordering guarantee

// ✅ Uses hashCode() and equals()

// ✅ Initial capacity 16, load factor 0.75

// TreeMap Key Points:
// ✅ O(log n) time complexity

// ✅ No null keys allowed

// ✅ Maintains sorted order

// ✅ Implements NavigableMap

// ✅ Uses compareTo() or Comparator

// ✅ Based on Red-Black tree

// When to Use Which:
// HashMap: Fast lookups, no order needed

// TreeMap: Need sorted keys, range operations

// LinkedHashMap: Need insertion order

// ConcurrentHashMap: Need thread safety with high concurrency

// Common Interview Questions:
// "How does HashMap work internally?" - Array of nodes, hashing, collisions handled by linked list/tree

// "What happens when two keys have same hash?" - Collision, stored in same bucket as linked list

// "When does HashMap resize?" - When size > capacity * load factor (0.75 * 16 = 12)

// "Why is TreeMap slower than HashMap?" - TreeMap maintains order with tree rotations (O(log n))

// "Can we use any object as key?" - Yes, but must properly override equals() and hashCode()

