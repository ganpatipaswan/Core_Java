import java.util.*;

public class TreeSetTreeMapDemo {
    
    public static void main(String[] args) {
        
        // ========== PART 1: TREESET EXAMPLES ==========
        System.out.println("========== TREESET EXAMPLES ==========\n");
        
        // Example 1: Basic TreeSet with Integers
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(30);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20); // Duplicate - will be ignored
        
        System.out.println("TreeSet of Integers: " + numbers);
        System.out.println("Size: " + numbers.size());
        System.out.println("Sorted Order: Automatically sorted!");
        
        // Example 2: TreeSet with Strings (Alphabetical order)
        TreeSet<String> fruits = new TreeSet<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");
        fruits.add("Apple"); // Duplicate - ignored
        
        System.out.println("\nTreeSet of Strings: " + fruits);
        
        // Example 3: TreeSet with Custom Objects using Comparable
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(new Employee(103, "John", 75000));
        employees.add(new Employee(101, "Alice", 65000));
        employees.add(new Employee(105, "Bob", 85000));
        employees.add(new Employee(102, "Charlie", 70000));
        employees.add(new Employee(104, "David", 80000));
        
        System.out.println("\nTreeSet of Employees (Sorted by ID):");
        for (Employee e : employees) {
            System.out.println(e);
        }
        
        // Example 4: TreeSet with Custom Comparator
        TreeSet<Employee> employeesByName = new TreeSet<>(new NameComparator());
        employeesByName.add(new Employee(103, "John", 75000));
        employeesByName.add(new Employee(101, "Alice", 65000));
        employeesByName.add(new Employee(105, "Bob", 85000));
        employeesByName.add(new Employee(102, "Charlie", 70000));
        
        System.out.println("\nTreeSet of Employees (Sorted by Name):");
        for (Employee e : employeesByName) {
            System.out.println(e);
        }
        
        // ========== PART 2: TREESET NAVIGATION METHODS ==========
        System.out.println("\n========== TREESET NAVIGATION METHODS ==========\n");
        
        TreeSet<Integer> numSet = new TreeSet<>();
        numSet.addAll(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90));
        
        System.out.println("TreeSet: " + numSet);
        System.out.println("First element: " + numSet.first());
        System.out.println("Last element: " + numSet.last());
        System.out.println("Element >= 35: " + numSet.ceiling(35));
        System.out.println("Element > 35: " + numSet.higher(35));
        System.out.println("Element <= 35: " + numSet.floor(35));
        System.out.println("Element < 35: " + numSet.lower(35));
        System.out.println("Poll first: " + numSet.pollFirst());
        System.out.println("After pollFirst: " + numSet);
        System.out.println("Poll last: " + numSet.pollLast());
        System.out.println("After pollLast: " + numSet);
        
        // Subset operations
        TreeSet<Integer> subset = new TreeSet<>(numSet.subSet(30, true, 70, true));
        System.out.println("Subset (30 to 70 inclusive): " + subset);
        
        // ========== PART 3: TREEMAP EXAMPLES ==========
        System.out.println("\n========== TREEMAP EXAMPLES ==========\n");
        
        // Example 1: Basic TreeMap
        TreeMap<Integer, String> studentMap = new TreeMap<>();
        studentMap.put(103, "John");
        studentMap.put(101, "Alice");
        studentMap.put(105, "Bob");
        studentMap.put(102, "Charlie");
        studentMap.put(104, "David");
        
        System.out.println("TreeMap of Students (Sorted by ID):");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
        
        // Example 2: TreeMap with Custom Objects as Keys
        TreeMap<Employee, String> employeeMap = new TreeMap<>();
        employeeMap.put(new Employee(103, "John", 75000), "IT Department");
        employeeMap.put(new Employee(101, "Alice", 65000), "HR Department");
        employeeMap.put(new Employee(105, "Bob", 85000), "IT Department");
        
        System.out.println("\nTreeMap with Employee Keys (Sorted by ID):");
        for (Map.Entry<Employee, String> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Example 3: TreeMap with Custom Comparator
        TreeMap<Employee, String> employeeMapByName = new TreeMap<>(new NameComparator());
        employeeMapByName.put(new Employee(103, "John", 75000), "IT Department");
        employeeMapByName.put(new Employee(101, "Alice", 65000), "HR Department");
        employeeMapByName.put(new Employee(105, "Bob", 85000), "Finance Department");
        employeeMapByName.put(new Employee(102, "Charlie", 70000), "Operations");
        
        System.out.println("\nTreeMap with Employee Keys (Sorted by Name):");
        for (Map.Entry<Employee, String> entry : employeeMapByName.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // ========== PART 4: TREEMAP NAVIGATION METHODS ==========
        System.out.println("\n========== TREEMAP NAVIGATION METHODS ==========\n");
        
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        
        System.out.println("TreeMap: " + map);
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
        System.out.println("First entry: " + map.firstEntry());
        System.out.println("Last entry: " + map.lastEntry());
        System.out.println("Key >= 25: " + map.ceilingKey(25));
        System.out.println("Value for key >= 25: " + map.ceilingEntry(25));
        System.out.println("Key <= 25: " + map.floorKey(25));
        System.out.println("Key > 25: " + map.higherKey(25));
        System.out.println("Key < 25: " + map.lowerKey(25));
        
        // Submap operations
        System.out.println("\nSubmap (20 to 40 inclusive): " + map.subMap(20, true, 40, true));
        System.out.println("HeadMap (less than 30): " + map.headMap(30));
        System.out.println("TailMap (greater than or equal 30): " + map.tailMap(30));
        
        // ========== PART 5: COMPARISON EXAMPLES ==========
        System.out.println("\n========== COMPARISON: TREESET VS HASHSET ==========\n");
        
        // HashSet - No ordering
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(50, 20, 80, 30, 10, 40));
        System.out.println("HashSet (No order): " + hashSet);
        
        // TreeSet - Sorted order
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList(50, 20, 80, 30, 10, 40));
        System.out.println("TreeSet (Sorted order): " + treeSet);
        
        System.out.println("\n========== COMPARISON: TREEMAP VS HASHMAP ==========\n");
        
        // HashMap - No ordering
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(103, "John");
        hashMap.put(101, "Alice");
        hashMap.put(105, "Bob");
        hashMap.put(102, "Charlie");
        System.out.println("HashMap (No order): " + hashMap);
        
        // TreeMap - Sorted by keys
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(103, "John");
        treeMap.put(101, "Alice");
        treeMap.put(105, "Bob");
        treeMap.put(102, "Charlie");
        System.out.println("TreeMap (Sorted by keys): " + treeMap);
    }
}

// ========== EMPLOYEE CLASS WITH COMPARABLE ==========
class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;
    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    @Override
    public int compareTo(Employee other) {
        // Natural ordering by ID
        return Integer.compare(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// ========== NAME COMPARATOR FOR CUSTOM SORTING ==========
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}

// TreeSet and TreeMap in Java - Complete Interview Guide
// Quick Answer for Interview
// TreeSet and TreeMap are part of Java Collections Framework that store elements in sorted order. TreeSet stores unique elements in a sorted tree structure, while TreeMap stores key-value pairs sorted by keys. Both are based on Red-Black Tree data structure and provide guaranteed O(log n) time complexity for basic operations.

// 1. TreeSet - Overview
// Definition
// TreeSet implements the Set interface and stores elements in sorted ascending order using a Red-Black tree structure.

// Key Characteristics
// ✅ Stores unique elements (no duplicates)

// ✅ Maintains sorted order automatically

// ✅ Based on Red-Black tree (self-balancing binary search tree)

// ✅ Not synchronized (not thread-safe)

// ✅ Does not allow null (throws NullPointerException)

// ✅ Provides O(log n) time complexity for add, remove, and contains

// 2. TreeMap - Overview
// Definition
// TreeMap implements the Map interface and stores key-value pairs in sorted order based on keys using a Red-Black tree.

// Key Characteristics
// ✅ Keys are unique (no duplicate keys)

// ✅ Maintains sorted order by keys

// ✅ Based on Red-Black tree

// ✅ Not synchronized (not thread-safe)

// ✅ Allows null values but not null keys (throws NullPointerException)

// ✅ Provides O(log n) time complexity for put, get, remove



// 4. Important Methods in TreeSet
// Basic Operations
// java
// TreeSet<String> set = new TreeSet<>();

// set.add("Apple");        // Add element
// set.remove("Apple");     // Remove element
// set.contains("Apple");   // Check if exists
// set.size();              // Get size
// set.isEmpty();           // Check if empty
// set.clear();             // Remove all elements
// Navigation Methods
// java
// set.first();             // Returns first (lowest) element
// set.last();              // Returns last (highest) element
// set.ceiling("M");        // Returns least element >= given element
// set.floor("M");          // Returns greatest element <= given element
// set.higher("M");         // Returns least element > given element
// set.lower("M");          // Returns greatest element < given element
// set.pollFirst();         // Retrieves and removes first element
// set.pollLast();          // Retrieves and removes last element
// Range View Methods
// java
// set.headSet("M");        // Elements < "M"
// set.tailSet("M");        // Elements >= "M"
// set.subSet("A", "M");    // Elements from "A" to "M" (exclusive)
// set.subSet("A", true, "M", true);  // With inclusive boundaries
// 5. Important Methods in TreeMap
// Basic Operations
// java
// TreeMap<Integer, String> map = new TreeMap<>();

// map.put(1, "One");       // Add key-value pair
// map.get(1);              // Get value by key
// map.remove(1);           // Remove by key
// map.containsKey(1);      // Check if key exists
// map.containsValue("One"); // Check if value exists
// map.size();              // Get size
// map.isEmpty();           // Check if empty
// Navigation Methods
// java
// map.firstKey();          // Returns first (lowest) key
// map.lastKey();           // Returns last (highest) key
// map.firstEntry();        // Returns first key-value pair
// map.lastEntry();         // Returns last key-value pair
// map.ceilingKey(5);       // Least key >= given key
// map.floorKey(5);         // Greatest key <= given key
// map.higherKey(5);        // Least key > given key
// map.lowerKey(5);         // Greatest key < given key
// map.pollFirstEntry();    // Removes and returns first entry
// map.pollLastEntry();     // Removes and returns last entry
// Range View Methods
// java
// map.headMap(5);          // Keys < 5
// map.tailMap(5);          // Keys >= 5
// map.subMap(2, 5);        // Keys from 2 to 5 (exclusive)
// map.subMap(2, true, 5, true);  // With inclusive boundaries
// 6. Interview Questions & Answers
// Q1: What is the underlying data structure of TreeSet and TreeMap?
// Answer: Both are based on Red-Black Tree, which is a self-balancing binary search tree. This ensures O(log n) time complexity for basic operations like add, remove, and contains.

// Q2: How does TreeSet maintain uniqueness?
// Answer: TreeSet uses the compareTo() method (or Comparator) to determine equality. If compareTo() returns 0, elements are considered equal, and duplicates are not added. This is different from HashSet which uses equals() and hashCode().

// Q3: Can we store null in TreeSet and TreeMap?
// Answer:

// TreeSet: Does NOT allow null (throws NullPointerException)

// TreeMap: Does NOT allow null keys, but allows null values

// Reason: Since TreeSet/TreeMap use compareTo() for sorting, null cannot be compared with other elements.

// Q4: When to use TreeSet vs HashSet?
// Criteria	TreeSet	HashSet
// Ordering	Sorted order	No order
// Performance	O(log n)	O(1) average
// Null values	Not allowed	Allowed (one null)
// Memory	More memory	Less memory
// Use case	When sorted order needed	When order doesn't matter
// Q5: When to use TreeMap vs HashMap?
// Criteria	TreeMap	HashMap
// Ordering	Sorted by keys	No order
// Performance	O(log n)	O(1) average
// Null keys	Not allowed	Allowed (one null)
// Null values	Allowed	Allowed
// Use case	When keys need sorting	When fast access needed
// Q6: What is the difference between TreeSet and TreeMap?
// Aspect	TreeSet	TreeMap
// Interface	Set	Map
// Storage	Single elements	Key-value pairs
// Uniqueness	Unique elements	Unique keys
// Methods	add(), remove()	put(), get()
// Navigation	first(), last()	firstKey(), lastKey()
// Q7: How does TreeSet handle custom objects?
// Answer: Custom objects must implement Comparable or provide a Comparator at construction time. Otherwise, ClassCastException is thrown.

// java
// // Option 1: Implement Comparable
// class Student implements Comparable<Student> {
//     public int compareTo(Student s) {
//         return this.id - s.id;
//     }
// }

// // Option 2: Provide Comparator
// TreeSet<Student> set = new TreeSet<>((s1, s2) -> s1.name.compareTo(s2.name));
// Q8: What are the performance characteristics?
// Operation	TreeSet/TreeMap	HashSet/HashMap
// Add	O(log n)	O(1) average
// Remove	O(log n)	O(1) average
// Contains	O(log n)	O(1) average
// First/Last	O(log n)	Not available
// Q9: Can we create TreeSet/TreeMap with custom ordering?
// Answer: Yes, by providing a Comparator in the constructor:

// java
// // Descending order
// TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

// // Custom comparator for strings by length
// TreeSet<String> set = new TreeSet<>((s1, s2) -> 
//     Integer.compare(s1.length(), s2.length()));
// Q10: What is the difference between TreeSet and SortedSet?
// Answer: SortedSet is an interface that defines sorted set behavior. TreeSet is a concrete implementation of SortedSet interface.

// 7. Real-World Use Cases
// Use Case 1: Maintaining Leaderboard (Sorted Scores)
// java
// TreeMap<Integer, String> leaderboard = new TreeMap<>(Collections.reverseOrder());
// leaderboard.put(100, "Alice");
// leaderboard.put(95, "Bob");
// leaderboard.put(98, "Charlie");

// // Get top score
// System.out.println("Top scorer: " + leaderboard.firstEntry());
// Use Case 2: Autocomplete/Suggestion System
// java
// TreeSet<String> dictionary = new TreeSet<>();
// dictionary.addAll(Arrays.asList("apple", "application", "apply", "app", "ape"));

// // Get all words starting with "app"
// System.out.println(dictionary.subSet("app", "appz"));
// Use Case 3: Range Queries (Find students in age range)
// java
// TreeMap<Integer, List<Student>> studentsByAge = new TreeMap<>();
// // Add students...
// List<Student> teens = studentsByAge.subMap(13, true, 19, true);
// Use Case 4: Event Scheduler
// java
// TreeMap<Long, String> eventScheduler = new TreeMap<>();
// eventScheduler.put(System.currentTimeMillis(), "Meeting");
// eventScheduler.put(System.currentTimeMillis() + 3600000, "Lunch");

// // Get next upcoming event
// System.out.println("Next event: " + eventScheduler.firstEntry());
// 8. Common Pitfalls to Avoid
// ❌ Pitfall 1: Modifying objects after adding to TreeSet
// java
// Employee emp = new Employee(101, "Alice", 50000);
// TreeSet<Employee> set = new TreeSet<>();
// set.add(emp);
// emp.salary = 60000; // Changing field used in comparison
// // TreeSet order may break!
// ❌ Pitfall 2: Inconsistent compareTo with equals
// java
// // If compareTo() returns 0 but equals() returns false
// // TreeSet will treat them as equal and reject the second
// ❌ Pitfall 3: Using non-comparable objects
// java
// TreeSet<Object> set = new TreeSet<>(); // No comparator provided
// set.add("Hello");
// set.add(123); // ClassCastException - cannot compare String and Integer
// 9. Comparison with Other Collections
// Feature	TreeSet	HashSet	LinkedHashSet
// Order	Sorted	No order	Insertion order
// Time	O(log n)	O(1)	O(1)
// Null	Not allowed	Allowed	Allowed
// Memory	High	Medium	High
// Feature	TreeMap	HashMap	LinkedHashMap
// Order	Sorted by keys	No order	Insertion order
// Time	O(log n)	O(1)	O(1)
// Null keys	Not allowed	Allowed	Allowed
// Null values	Allowed	Allowed	Allowed
// 10. Interview Summary - Key Points
// TreeSet - Quick Summary
// ✅ Stores unique elements in sorted order

// ✅ Based on Red-Black tree (self-balancing BST)

// ✅ O(log n) time complexity for basic operations

// ❌ Does not allow null

// ✅ Provides navigation methods (first, last, ceiling, floor)

// ✅ Must implement Comparable or provide Comparator

// TreeMap - Quick Summary
// ✅ Stores key-value pairs sorted by keys

// ✅ Based on Red-Black tree

// ✅ O(log n) time complexity for put, get, remove

// ❌ Does not allow null keys, but allows null values

// ✅ Provides navigation methods for keys

// ✅ Great for range queries and sorted data

// One-Liner for Interview
// "TreeSet and TreeMap are sorted collections based on Red-Black tree that maintain elements in natural order or custom comparator order, providing O(log n) operations and navigation capabilities, making them ideal for sorted data and range queries."

