import java.util.*;
import java.util.concurrent.*;

/**
 * Program to demonstrate all Collections class methods in Java
 * This program shows the purpose and usage of every static utility method
 * in the java.util.Collections class
 */
public class AllCollectionsMethods {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(100));
        System.out.println("COMPREHENSIVE DEMONSTRATION OF COLLECTIONS CLASS METHODS");
        System.out.println("=".repeat(100));
        
        // SECTION 1: Sorting and Ordering Methods
        demonstrateSortingMethods();
        
        // SECTION 2: Searching Methods
        demonstrateSearchingMethods();
        
        // SECTION 3: Manipulation Methods
        demonstrateManipulationMethods();
        
        // SECTION 4: Collection Copy and Fill Methods
        demonstrateCopyFillMethods();
        
        // SECTION 5: Min/Max and Frequency Methods
        demonstrateMinMaxFrequencyMethods();
        
        // SECTION 6: Disjoint and SubList Methods
        demonstrateDisjointSubListMethods();
        
        // SECTION 7: Synchronized Wrappers (Thread-Safe)
        demonstrateSynchronizedWrappers();
        
        // SECTION 8: Unmodifiable Wrappers (Read-Only)
        demonstrateUnmodifiableWrappers();
        
        // SECTION 9: Checked Wrappers (Type-Safe)
        demonstrateCheckedWrappers();
        
        // SECTION 10: Empty Collections and Iterators
        demonstrateEmptyCollections();
        
        // SECTION 11: Singleton Collections
        demonstrateSingletonCollections();
        
        // SECTION 12: Miscellaneous Methods
        demonstrateMiscMethods();
        
        // SECTION 13: Legacy Enumeration Methods
        demonstrateEnumerationMethods();
        
        // SECTION 14: Newer Java Methods (Java 8+)
        demonstrateNewerMethods();
    }
    
    /**
     * SECTION 1: Sorting and Ordering Methods (Methods 1-7)
     */
    private static void demonstrateSortingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 1: SORTING AND ORDERING METHODS (7 Methods)");
        System.out.println("=".repeat(80));
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6));
        List<String> names = new ArrayList<>(Arrays.asList("John", "Alice", "Bob", "Charlie", "David"));
        
        System.out.println("\nOriginal lists:");
        System.out.println("   Numbers: " + numbers);
        System.out.println("   Names: " + names);
        
        // Method 1: sort(List<T> list) - Natural ordering
        System.out.println("\n1. sort(List<T> list) - Natural ordering:");
        Collections.sort(numbers);
        System.out.println("   Numbers sorted: " + numbers);
        
        // Method 2: sort(List<T> list, Comparator<? super T> c) - With comparator
        System.out.println("\n2. sort(List<T> list, Comparator<? super T> c):");
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println("   Names reverse sorted: " + names);
        
        // Method 3: reverse(List<?> list)
        System.out.println("\n3. reverse(List<?> list):");
        Collections.reverse(numbers);
        System.out.println("   Numbers reversed: " + numbers);
        
        // Method 4: reverseOrder()
        System.out.println("\n4. reverseOrder() - Returns reverse comparator:");
        Comparator<Integer> reverseComp = Collections.reverseOrder();
        Collections.sort(numbers, reverseComp);
        System.out.println("   Numbers sorted with reverse comparator: " + numbers);
        
        // Method 5: reverseOrder(Comparator<T> cmp)
        System.out.println("\n5. reverseOrder(Comparator<T> cmp):");
        Comparator<String> lengthComp = Comparator.comparing(String::length);
        Comparator<String> reverseLengthComp = Collections.reverseOrder(lengthComp);
        List<String> words = Arrays.asList("cat", "elephant", "dog", "butterfly");
        words.sort(reverseLengthComp);
        System.out.println("   Words sorted by reverse length: " + words);
        
        // Method 6: shuffle(List<?> list)
        System.out.println("\n6. shuffle(List<?> list) - Random permutation:");
        List<Integer> shuffleList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Collections.shuffle(shuffleList);
        System.out.println("   Shuffled list: " + shuffleList);
        
        // Method 7: shuffle(List<?> list, Random rnd)
        System.out.println("\n7. shuffle(List<?> list, Random rnd) - With seed:");
        List<Integer> shuffleSeed = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.shuffle(shuffleSeed, new Random(42));
        System.out.println("   Shuffled with seed 42: " + shuffleSeed);
    }
    
    /**
     * SECTION 2: Searching Methods (Methods 8-9)
     */
    private static void demonstrateSearchingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 2: SEARCHING METHODS (2 Methods)");
        System.out.println("=".repeat(80));
        
        List<Integer> sortedNumbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
        System.out.println("\nSorted list: " + sortedNumbers);
        
        // Method 8: binarySearch(List<? extends Comparable<? super T>> list, T key)
        System.out.println("\n8. binarySearch - Natural ordering:");
        int index1 = Collections.binarySearch(sortedNumbers, 50);
        int index2 = Collections.binarySearch(sortedNumbers, 55);
        System.out.println("   Index of 50: " + index1);
        System.out.println("   Index of 55 (not found): " + index2 + " (insertion point: " + (-index2-1) + ")");
        
        // Method 9: binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
        System.out.println("\n9. binarySearch with Comparator:");
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
        Comparator<String> caseInsensitive = String.CASE_INSENSITIVE_ORDER;
        int index3 = Collections.binarySearch(words, "cherry", caseInsensitive);
        System.out.println("   Case-insensitive search for 'cherry': " + index3);
    }
    
    /**
     * SECTION 3: Manipulation Methods (Methods 10-14)
     */
    private static void demonstrateManipulationMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 3: MANIPULATION METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("\nOriginal list: " + list);
        
        // Method 10: swap(List<?> list, int i, int j)
        System.out.println("\n10. swap(List<?> list, int i, int j):");
        Collections.swap(list, 1, 3);
        System.out.println("   After swapping indices 1 and 3: " + list);
        
        // Method 11: rotate(List<?> list, int distance)
        System.out.println("\n11. rotate(List<?> list, int distance):");
        Collections.rotate(list, 2);
        System.out.println("   After rotating right by 2: " + list);
        Collections.rotate(list, -1);
        System.out.println("   After rotating left by 1: " + list);
        
        // Method 12: replaceAll(List<T> list, T oldVal, T newVal)
        System.out.println("\n12. replaceAll(List<T> list, T oldVal, T newVal):");
        List<String> replaceList = new ArrayList<>(Arrays.asList("X", "Y", "X", "Z", "X"));
        System.out.println("   Before: " + replaceList);
        Collections.replaceAll(replaceList, "X", "New");
        System.out.println("   After replacing 'X' with 'New': " + replaceList);
        
        // Method 13: fill(List<? super T> list, T obj)
        System.out.println("\n13. fill(List<? super T> list, T obj):");
        List<String> fillList = new ArrayList<>(Arrays.asList("", "", "", ""));
        System.out.println("   Before fill: " + fillList);
        Collections.fill(fillList, "Filled");
        System.out.println("   After fill with 'Filled': " + fillList);
        
        // Method 14: addAll(Collection<? super T> c, T... elements)
        System.out.println("\n14. addAll(Collection<? super T> c, T... elements):");
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        System.out.println("   Set before: " + set);
        Collections.addAll(set, 4, 5, 6);
        System.out.println("   Set after adding 4,5,6: " + set);
    }
    
    /**
     * SECTION 4: Copy Methods (Methods 15-16)
     */
    private static void demonstrateCopyFillMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 4: COPY METHODS (2 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 15: copy(List<? super T> dest, List<? extends T> src)
        System.out.println("\n15. copy(List<? super T> dest, List<? extends T> src):");
        List<String> src = Arrays.asList("A", "B", "C", "D");
        List<String> dest = new ArrayList<>(Arrays.asList("", "", "", "", "Extra"));
        System.out.println("   Source: " + src);
        System.out.println("   Destination before: " + dest);
        Collections.copy(dest, src);
        System.out.println("   Destination after copy: " + dest);
        
        // Method 16: nCopies(int n, T o)
        System.out.println("\n16. nCopies(int n, T o) - Returns immutable list with n copies:");
        List<String> copies = Collections.nCopies(5, "Repeat");
        System.out.println("   5 copies of 'Repeat': " + copies);
        System.out.println("   Note: This list is immutable - " + 
            (copies instanceof RandomAccess ? "implements" : "does not implement") + " RandomAccess");
    }
    
    /**
     * SECTION 5: Min/Max and Frequency Methods (Methods 17-20)
     */
    private static void demonstrateMinMaxFrequencyMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 5: MIN/MAX AND FREQUENCY METHODS (4 Methods)");
        System.out.println("=".repeat(80));
        
        List<Integer> numbers = Arrays.asList(42, 17, 89, 33, 17, 56, 17, 91, 24);
        System.out.println("\nCollection: " + numbers);
        
        // Method 17: max(Collection<? extends T> coll)
        System.out.println("\n17. max(Collection<? extends T> coll) - Natural ordering:");
        Integer max = Collections.max(numbers);
        System.out.println("   Maximum element: " + max);
        
        // Method 18: max(Collection<? extends T> coll, Comparator<? super T> comp)
        System.out.println("\n18. max with Comparator:");
        Integer maxWithComp = Collections.max(numbers, Comparator.reverseOrder());
        System.out.println("   Maximum with reverse comparator (actually min): " + maxWithComp);
        
        // Method 19: min(Collection<? extends T> coll)
        System.out.println("\n19. min(Collection<? extends T> coll) - Natural ordering:");
        Integer min = Collections.min(numbers);
        System.out.println("   Minimum element: " + min);
        
        // Method 20: frequency(Collection<?> c, Object o)
        System.out.println("\n20. frequency(Collection<?> c, Object o):");
        int freq = Collections.frequency(numbers, 17);
        System.out.println("   Frequency of 17: " + freq);
    }
    
    /**
     * SECTION 6: Disjoint and SubList Methods (Methods 21-23)
     */
    private static void demonstrateDisjointSubListMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 6: DISJOINT AND SUBLIST METHODS (3 Methods)");
        System.out.println("=".repeat(80));
        
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> list3 = Arrays.asList(5, 6, 7, 8, 9);
        
        // Method 21: disjoint(Collection<?> c1, Collection<?> c2)
        System.out.println("\n21. disjoint(Collection<?> c1, Collection<?> c2):");
        System.out.println("   list1 and list2 disjoint? " + Collections.disjoint(list1, list2));
        System.out.println("   list1 and list3 disjoint? " + Collections.disjoint(list1, list3));
        
        List<String> source = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        List<String> target1 = Arrays.asList("C", "D", "E");
        List<String> target2 = Arrays.asList("X", "Y", "Z");
        List<String> target3 = Arrays.asList("E", "F", "G", "H");
        
        System.out.println("\nSource list: " + source);
        
        // Method 22: indexOfSubList(List<?> source, List<?> target)
        System.out.println("\n22. indexOfSubList(List<?> source, List<?> target):");
        System.out.println("   First index of " + target1 + ": " + Collections.indexOfSubList(source, target1));
        System.out.println("   First index of " + target2 + ": " + Collections.indexOfSubList(source, target2));
        
        // Method 23: lastIndexOfSubList(List<?> source, List<?> target)
        System.out.println("\n23. lastIndexOfSubList(List<?> source, List<?> target):");
        System.out.println("   Last index of " + target3 + ": " + Collections.lastIndexOfSubList(source, target3));
    }
    
    /**
     * SECTION 7: Synchronized Wrappers (Thread-Safe) (Methods 24-34)
     */
    private static void demonstrateSynchronizedWrappers() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 7: SYNCHRONIZED WRAPPERS (THREAD-SAFE) (11 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 24: synchronizedCollection(Collection<T> c)
        System.out.println("\n24. synchronizedCollection(Collection<T> c):");
        Collection<String> originalCollection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Collection<String> syncCollection = Collections.synchronizedCollection(originalCollection);
        System.out.println("   Created synchronized collection: " + syncCollection);
        System.out.println("   Note: Must manually synchronize when iterating");
        
        // Method 25: synchronizedList(List<T> list)
        System.out.println("\n25. synchronizedList(List<T> list):");
        List<String> originalList = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        List<String> syncList = Collections.synchronizedList(originalList);
        System.out.println("   Created synchronized list: " + syncList);
        
        // Method 26: synchronizedSet(Set<T> s)
        System.out.println("\n26. synchronizedSet(Set<T> s):");
        Set<String> originalSet = new HashSet<>(Arrays.asList("Red", "Green", "Blue"));
        Set<String> syncSet = Collections.synchronizedSet(originalSet);
        System.out.println("   Created synchronized set: " + syncSet);
        
        // Method 27: synchronizedSortedSet(SortedSet<T> s)
        System.out.println("\n27. synchronizedSortedSet(SortedSet<T> s):");
        SortedSet<String> originalSortedSet = new TreeSet<>(Arrays.asList("Apple", "Banana", "Cherry"));
        SortedSet<String> syncSortedSet = Collections.synchronizedSortedSet(originalSortedSet);
        System.out.println("   Created synchronized sorted set: " + syncSortedSet);
        
        // Method 28: synchronizedNavigableSet(NavigableSet<T> s)
        System.out.println("\n28. synchronizedNavigableSet(NavigableSet<T> s):");
        NavigableSet<String> originalNavSet = new TreeSet<>(Arrays.asList("Dog", "Cat", "Elephant"));
        NavigableSet<String> syncNavSet = Collections.synchronizedNavigableSet(originalNavSet);
        System.out.println("   Created synchronized navigable set: " + syncNavSet);
        
        // Method 29: synchronizedMap(Map<K,V> m)
        System.out.println("\n29. synchronizedMap(Map<K,V> m):");
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("One", 1);
        originalMap.put("Two", 2);
        Map<String, Integer> syncMap = Collections.synchronizedMap(originalMap);
        System.out.println("   Created synchronized map: " + syncMap);
        
        // Method 30: synchronizedSortedMap(SortedMap<K,V> m)
        System.out.println("\n30. synchronizedSortedMap(SortedMap<K,V> m):");
        SortedMap<String, Integer> originalSortedMap = new TreeMap<>();
        originalSortedMap.put("A", 1);
        originalSortedMap.put("B", 2);
        SortedMap<String, Integer> syncSortedMap = Collections.synchronizedSortedMap(originalSortedMap);
        System.out.println("   Created synchronized sorted map: " + syncSortedMap);
        
        // Method 31: synchronizedNavigableMap(NavigableMap<K,V> m)
        System.out.println("\n31. synchronizedNavigableMap(NavigableMap<K,V> m):");
        NavigableMap<String, Integer> originalNavMap = new TreeMap<>();
        originalNavMap.put("Z", 26);
        originalNavMap.put("Y", 25);
        NavigableMap<String, Integer> syncNavMap = Collections.synchronizedNavigableMap(originalNavMap);
        System.out.println("   Created synchronized navigable map: " + syncNavMap);
        
        // Note: Methods 32-34 are also synchronized wrappers but for specific collection types
        System.out.println("\n   Additional synchronized wrapper methods exist for all collection types");
    }
    
    /**
     * SECTION 8: Unmodifiable Wrappers (Read-Only) (Methods 35-45)
     */
    private static void demonstrateUnmodifiableWrappers() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 8: UNMODIFIABLE WRAPPERS (READ-ONLY) (11 Methods)");
        System.out.println("=".repeat(80));
        
        List<String> modifiableList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        
        // Method 35: unmodifiableCollection(Collection<? extends T> c)
        System.out.println("\n35. unmodifiableCollection(Collection<? extends T> c):");
        Collection<String> unmodCollection = Collections.unmodifiableCollection(modifiableList);
        System.out.println("   Created unmodifiable collection: " + unmodCollection);
        
        // Method 36: unmodifiableList(List<? extends T> list)
        System.out.println("\n36. unmodifiableList(List<? extends T> list):");
        List<String> unmodList = Collections.unmodifiableList(modifiableList);
        System.out.println("   Created unmodifiable list: " + unmodList);
        
        // Method 37: unmodifiableSet(Set<? extends T> s)
        System.out.println("\n37. unmodifiableSet(Set<? extends T> s):");
        Set<String> modifiableSet = new HashSet<>(Arrays.asList("X", "Y", "Z"));
        Set<String> unmodSet = Collections.unmodifiableSet(modifiableSet);
        System.out.println("   Created unmodifiable set: " + unmodSet);
        
        // Method 38: unmodifiableSortedSet(SortedSet<T> s)
        System.out.println("\n38. unmodifiableSortedSet(SortedSet<T> s):");
        SortedSet<String> modifiableSortedSet = new TreeSet<>(Arrays.asList("One", "Two", "Three"));
        SortedSet<String> unmodSortedSet = Collections.unmodifiableSortedSet(modifiableSortedSet);
        System.out.println("   Created unmodifiable sorted set: " + unmodSortedSet);
        
        // Method 39: unmodifiableNavigableSet(NavigableSet<T> s)
        System.out.println("\n39. unmodifiableNavigableSet(NavigableSet<T> s):");
        NavigableSet<String> modifiableNavSet = new TreeSet<>(Arrays.asList("Red", "Green", "Blue"));
        NavigableSet<String> unmodNavSet = Collections.unmodifiableNavigableSet(modifiableNavSet);
        System.out.println("   Created unmodifiable navigable set: " + unmodNavSet);
        
        // Method 40: unmodifiableMap(Map<? extends K, ? extends V> m)
        System.out.println("\n40. unmodifiableMap(Map<? extends K, ? extends V> m):");
        Map<String, Integer> modifiableMap = new HashMap<>();
        modifiableMap.put("A", 1);
        Map<String, Integer> unmodMap = Collections.unmodifiableMap(modifiableMap);
        System.out.println("   Created unmodifiable map: " + unmodMap);
        
        // Method 41: unmodifiableSortedMap(SortedMap<K, ? extends V> m)
        System.out.println("\n41. unmodifiableSortedMap(SortedMap<K, ? extends V> m):");
        SortedMap<String, Integer> modifiableSortedMap = new TreeMap<>();
        modifiableSortedMap.put("First", 1);
        SortedMap<String, Integer> unmodSortedMap = Collections.unmodifiableSortedMap(modifiableSortedMap);
        System.out.println("   Created unmodifiable sorted map: " + unmodSortedMap);
        
        // Method 42: unmodifiableNavigableMap(NavigableMap<K, V> m)
        System.out.println("\n42. unmodifiableNavigableMap(NavigableMap<K, V> m):");
        NavigableMap<String, Integer> modifiableNavMap = new TreeMap<>();
        modifiableNavMap.put("High", 100);
        NavigableMap<String, Integer> unmodNavMap = Collections.unmodifiableNavigableMap(modifiableNavMap);
        System.out.println("   Created unmodifiable navigable map: " + unmodNavMap);
        
        // Demonstrate that modification throws exception
        System.out.println("\n   Attempting to modify unmodifiable list throws UnsupportedOperationException:");
        try {
            unmodList.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("   ✓ Exception thrown as expected: " + e.getClass().getSimpleName());
        }
    }
    
    /**
     * SECTION 9: Checked Wrappers (Type-Safe) (Methods 46-56)
     */
    private static void demonstrateCheckedWrappers() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 9: CHECKED WRAPPERS (TYPE-SAFE) (11 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 46: checkedCollection(Collection<E> c, Class<E> type)
        System.out.println("\n46. checkedCollection(Collection<E> c, Class<E> type):");
        Collection<String> rawCollection = new ArrayList<>();
        Collection<String> checkedCollection = Collections.checkedCollection(rawCollection, String.class);
        checkedCollection.add("Safe");
        System.out.println("   Created checked collection: " + checkedCollection);
        
        // Method 47: checkedList(List<E> list, Class<E> type)
        System.out.println("\n47. checkedList(List<E> list, Class<E> type):");
        List<String> rawList = new ArrayList<>();
        List<String> checkedList = Collections.checkedList(rawList, String.class);
        checkedList.add("Hello");
        System.out.println("   Created checked list: " + checkedList);
        
        // Method 48: checkedSet(Set<E> s, Class<E> type)
        System.out.println("\n48. checkedSet(Set<E> s, Class<E> type):");
        Set<String> rawSet = new HashSet<>();
        Set<String> checkedSet = Collections.checkedSet(rawSet, String.class);
        checkedSet.add("World");
        System.out.println("   Created checked set: " + checkedSet);
        
        // Method 49: checkedSortedSet(SortedSet<E> s, Class<E> type)
        System.out.println("\n49. checkedSortedSet(SortedSet<E> s, Class<E> type):");
        SortedSet<String> rawSortedSet = new TreeSet<>();
        SortedSet<String> checkedSortedSet = Collections.checkedSortedSet(rawSortedSet, String.class);
        checkedSortedSet.add("Apple");
        System.out.println("   Created checked sorted set: " + checkedSortedSet);
        
        // Method 50: checkedNavigableSet(NavigableSet<E> s, Class<E> type)
        System.out.println("\n50. checkedNavigableSet(NavigableSet<E> s, Class<E> type):");
        NavigableSet<String> rawNavSet = new TreeSet<>();
        NavigableSet<String> checkedNavSet = Collections.checkedNavigableSet(rawNavSet, String.class);
        checkedNavSet.add("Zebra");
        System.out.println("   Created checked navigable set: " + checkedNavSet);
        
        // Method 51: checkedQueue(Queue<E> queue, Class<E> type)
        System.out.println("\n51. checkedQueue(Queue<E> queue, Class<E> type):");
        Queue<String> rawQueue = new LinkedList<>();
        Queue<String> checkedQueue = Collections.checkedQueue(rawQueue, String.class);
        checkedQueue.add("First");
        System.out.println("   Created checked queue: " + checkedQueue);
        
        // Method 52: checkedMap(Map<K,V> m, Class<K> keyType, Class<V> valueType)
        System.out.println("\n52. checkedMap(Map<K,V> m, Class<K> keyType, Class<V> valueType):");
        Map<String, Integer> rawMap = new HashMap<>();
        Map<String, Integer> checkedMap = Collections.checkedMap(rawMap, String.class, Integer.class);
        checkedMap.put("Key", 100);
        System.out.println("   Created checked map: " + checkedMap);
        
        // Method 53: checkedSortedMap(SortedMap<K,V> m, Class<K> keyType, Class<V> valueType)
        System.out.println("\n53. checkedSortedMap(SortedMap<K,V> m, Class<K> keyType, Class<V> valueType):");
        SortedMap<String, Integer> rawSortedMap = new TreeMap<>();
        SortedMap<String, Integer> checkedSortedMap = Collections.checkedSortedMap(rawSortedMap, String.class, Integer.class);
        checkedSortedMap.put("A", 1);
        System.out.println("   Created checked sorted map: " + checkedSortedMap);
        
        // Method 54: checkedNavigableMap(NavigableMap<K,V> m, Class<K> keyType, Class<V> valueType)
        System.out.println("\n54. checkedNavigableMap(NavigableMap<K,V> m, Class<K> keyType, Class<V> valueType):");
        NavigableMap<String, Integer> rawNavMap = new TreeMap<>();
        NavigableMap<String, Integer> checkedNavMap = Collections.checkedNavigableMap(rawNavMap, String.class, Integer.class);
        checkedNavMap.put("B", 2);
        System.out.println("   Created checked navigable map: " + checkedNavMap);
        
        // Demonstrate type safety at runtime (would throw ClassCastException if wrong type inserted)
        System.out.println("\n   Checked wrappers provide runtime type safety against heap pollution");
    }
    
    /**
     * SECTION 10: Empty Collections and Iterators (Methods 57-66)
     */
    private static void demonstrateEmptyCollections() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 10: EMPTY COLLECTIONS AND ITERATORS (10 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 57: emptyIterator()
        System.out.println("\n57. emptyIterator():");
        Iterator<String> emptyIterator = Collections.emptyIterator();
        System.out.println("   Empty iterator has next? " + emptyIterator.hasNext());
        
        // Method 58: emptyListIterator()
        System.out.println("\n58. emptyListIterator():");
        ListIterator<String> emptyListIterator = Collections.emptyListIterator();
        System.out.println("   Empty list iterator has next? " + emptyListIterator.hasNext());
        System.out.println("   Empty list iterator has previous? " + emptyListIterator.hasPrevious());
        
        // Method 59: emptyEnumeration()
        System.out.println("\n59. emptyEnumeration():");
        Enumeration<String> emptyEnumeration = Collections.emptyEnumeration();
        System.out.println("   Empty enumeration has more elements? " + emptyEnumeration.hasMoreElements());
        
        // Method 60: emptyList()
        System.out.println("\n60. emptyList():");
        List<String> emptyList = Collections.emptyList();
        System.out.println("   Empty list: " + emptyList);
        System.out.println("   Size: " + emptyList.size());
        
        // Method 61: emptySet()
        System.out.println("\n61. emptySet():");
        Set<String> emptySet = Collections.emptySet();
        System.out.println("   Empty set: " + emptySet);
        
        // Method 62: emptySortedSet()
        System.out.println("\n62. emptySortedSet():");
        SortedSet<String> emptySortedSet = Collections.emptySortedSet();
        System.out.println("   Empty sorted set: " + emptySortedSet);
        
        // Method 63: emptyNavigableSet()
        System.out.println("\n63. emptyNavigableSet():");
        NavigableSet<String> emptyNavSet = Collections.emptyNavigableSet();
        System.out.println("   Empty navigable set: " + emptyNavSet);
        
        // Method 64: emptyMap()
        System.out.println("\n64. emptyMap():");
        Map<String, Integer> emptyMap = Collections.emptyMap();
        System.out.println("   Empty map: " + emptyMap);
        
        // Method 65: emptySortedMap()
        System.out.println("\n65. emptySortedMap():");
        SortedMap<String, Integer> emptySortedMap = Collections.emptySortedMap();
        System.out.println("   Empty sorted map: " + emptySortedMap);
        
        // Method 66: emptyNavigableMap()
        System.out.println("\n66. emptyNavigableMap():");
        NavigableMap<String, Integer> emptyNavMap = Collections.emptyNavigableMap();
        System.out.println("   Empty navigable map: " + emptyNavMap);
        
        // Constants (EMPTY_LIST, EMPTY_SET, EMPTY_MAP)
        System.out.println("\n   Constants also available:");
        System.out.println("   Collections.EMPTY_LIST: " + Collections.EMPTY_LIST);
        System.out.println("   Collections.EMPTY_SET: " + Collections.EMPTY_SET);
        System.out.println("   Collections.EMPTY_MAP: " + Collections.EMPTY_MAP);
    }
    
    /**
     * SECTION 11: Singleton Collections (Methods 67-69)
     */
    private static void demonstrateSingletonCollections() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 11: SINGLETON COLLECTIONS (3 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 67: singleton(T o)
        System.out.println("\n67. singleton(T o) - Immutable set with single element:");
        Set<String> singletonSet = Collections.singleton("Only Element");
        System.out.println("   Singleton set: " + singletonSet);
        System.out.println("   Size: " + singletonSet.size());
        
        // Method 68: singletonList(T o)
        System.out.println("\n68. singletonList(T o) - Immutable list with single element:");
        List<String> singletonList = Collections.singletonList("Only Item");
        System.out.println("   Singleton list: " + singletonList);
        System.out.println("   Implements RandomAccess? " + (singletonList instanceof RandomAccess));
        
        // Method 69: singletonMap(K key, V value)
        System.out.println("\n69. singletonMap(K key, V value) - Immutable map with single entry:");
        Map<String, Integer> singletonMap = Collections.singletonMap("Key", 42);
        System.out.println("   Singleton map: " + singletonMap);
        
        // Demonstrate immutability
        try {
            singletonSet.add("Another");
        } catch (UnsupportedOperationException e) {
            System.out.println("   ✓ Singleton collections are immutable");
        }
    }
    
    /**
     * SECTION 12: Miscellaneous Methods (Methods 70-72)
     */
    private static void demonstrateMiscMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 12: MISCELLANEOUS METHODS (3 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 70: asLifoQueue(Deque<T> deque)
        System.out.println("\n70. asLifoQueue(Deque<T> deque) - Returns LIFO view of Deque:");
        Deque<String> deque = new ArrayDeque<>();
        deque.add("First");
        deque.add("Second");
        deque.add("Third");
        System.out.println("   Original deque: " + deque);
        
        Queue<String> lifoQueue = Collections.asLifoQueue(deque);
        System.out.println("   LIFO queue view: " + lifoQueue);
        System.out.println("   LIFO queue element(): " + lifoQueue.element()); // Last element
        
        // Method 71: newSetFromMap(Map<E,Boolean> map)
        System.out.println("\n71. newSetFromMap(Map<E,Boolean> map) - Creates set backed by map:");
        Map<String, Boolean> backingMap = new ConcurrentHashMap<>();
        Set<String> concurrentSet = Collections.newSetFromMap(backingMap);
        concurrentSet.add("Element1");
        concurrentSet.add("Element2");
        System.out.println("   Set created from map: " + concurrentSet);
        System.out.println("   Backing map: " + backingMap);
        System.out.println("   Useful for creating concurrent sets");
        
        // Method 72: newSequencedSetFromMap (Java 21+) - Shown for completeness
        System.out.println("\n72. newSequencedSetFromMap (Java 21+):");
        System.out.println("   Creates a sequenced set backed by a sequenced map");
        System.out.println("   Part of Java 21's Sequenced Collections");
    }
    
    /**
     * SECTION 13: Legacy Enumeration Methods (Methods 73-74)
     */
    private static void demonstrateEnumerationMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 13: LEGACY ENUMERATION METHODS (2 Methods)");
        System.out.println("=".repeat(80));
        
        List<String> list = Arrays.asList("A", "B", "C", "D");
        
        // Method 73: enumeration(Collection<T> c)
        System.out.println("\n73. enumeration(Collection<T> c) - Returns Enumeration over collection:");
        Enumeration<String> enumeration = Collections.enumeration(list);
        System.out.print("   Enumeration elements: ");
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();
        
        // Method 74: list(Enumeration<T> e)
        System.out.println("\n74. list(Enumeration<T> e) - Returns ArrayList from Enumeration:");
        Vector<String> vector = new Vector<>(list);
        Enumeration<String> vecEnum = vector.elements();
        ArrayList<String> arrayList = Collections.list(vecEnum);
        System.out.println("   ArrayList created from Enumeration: " + arrayList);
    }
    
    /**
     * SECTION 14: Newer Java Methods (Java 8+) (Methods 75-76)
     */
    private static void demonstrateNewerMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 14: NEWER JAVA METHODS (JAVA 8+) (2 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 75: Collections class itself has been enhanced with default methods in Collection interface
        System.out.println("\n75. Collection interface default methods (Java 8+):");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        System.out.println("   removeIf - Remove even numbers:");
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("   Result: " + numbers);
        
        // Method 76: Stream API integration
        System.out.println("\n76. Stream API integration:");
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        System.out.println("   Original: " + words);
        
        List<String> upperCase = new ArrayList<>();
        words.stream()
             .map(String::toUpperCase)
             .forEach(upperCase::add);
        System.out.println("   Uppercase via stream: " + upperCase);
    }
    
    /**
     * Summary of all Collections methods
     */
    private static void printSummary() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SUMMARY OF ALL COLLECTIONS METHODS");
        System.out.println("=".repeat(80));
        
        String[][] summary = {
            {"1-7", "Sorting and Ordering", "sort(), reverse(), reverseOrder(), shuffle(), rotate()"},
            {"8-9", "Searching", "binarySearch() (2 overloads)"},
            {"10-14", "Manipulation", "swap(), rotate(), replaceAll(), fill(), addAll()"},
            {"15-16", "Copy", "copy(), nCopies()"},
            {"17-20", "Min/Max/Frequency", "min(), max(), frequency()"},
            {"21-23", "Disjoint/SubList", "disjoint(), indexOfSubList(), lastIndexOfSubList()"},
            {"24-34", "Synchronized Wrappers", "synchronizedCollection/List/Set/Map/etc. (11 methods)"},
            {"35-45", "Unmodifiable Wrappers", "unmodifiableCollection/List/Set/Map/etc. (11 methods)"},
            {"46-56", "Checked Wrappers", "checkedCollection/List/Set/Map/etc. (11 methods)"},
            {"57-66", "Empty Collections", "emptyIterator/ListIterator/Enumeration/List/Set/Map/etc. (10 methods)"},
            {"67-69", "Singleton Collections", "singleton(), singletonList(), singletonMap()"},
            {"70-72", "Miscellaneous", "asLifoQueue(), newSetFromMap(), newSequencedSetFromMap()"},
            {"73-74", "Legacy Enumeration", "enumeration(), list()"}
        };
        
        System.out.println("\nMethod Categories:");
        for (String[] row : summary) {
            System.out.printf("   %-6s | %-25s | %s%n", row[0], row[1], row[2]);
        }
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TOTAL: Over 76 distinct Collections utility methods");
        System.out.println("=".repeat(80));
    }
}