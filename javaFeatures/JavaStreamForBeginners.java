/**
 * Comprehensive Java Stream API Program for Beginners
 * 
 * This program demonstrates all Stream API methods in Java 8+
 * with simple, easy-to-understand examples.
 * 
 * Topics covered:
 * 1. Creating Streams
 * 2. Intermediate Operations (filter, map, etc.)
 * 3. Terminal Operations (collect, forEach, etc.)
 * 4. Short-circuit Operations
 * 5. Numeric Streams
 * 6. Parallel Streams
 * 7. Collectors
 * 8. Stream Utilities
 */

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.*;

public class JavaStreamForBeginners {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("JAVA STREAM API - BEGINNER'S GUIDE");
        System.out.println("=".repeat(80));
        
        // Section 1: Creating Streams
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 1: CREATING STREAMS");
        System.out.println("#".repeat(60));
        demonstrateStreamCreation();
        
        // Section 2: Intermediate Operations
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 2: INTERMEDIATE OPERATIONS");
        System.out.println("#".repeat(60));
        demonstrateIntermediateOperations();
        
        // Section 3: Terminal Operations
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 3: TERMINAL OPERATIONS");
        System.out.println("#".repeat(60));
        demonstrateTerminalOperations();
        
        // Section 4: Short-circuit Operations
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 4: SHORT-CIRCUIT OPERATIONS");
        System.out.println("#".repeat(60));
        demonstrateShortCircuitOperations();
        
        // Section 5: Numeric Streams
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 5: NUMERIC STREAMS (IntStream, LongStream, DoubleStream)");
        System.out.println("#".repeat(60));
        demonstrateNumericStreams();
        
        // Section 6: Collectors
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 6: COLLECTORS (java.util.stream.Collectors)");
        System.out.println("#".repeat(60));
        demonstrateCollectors();
        
        // Section 7: Parallel Streams
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 7: PARALLEL STREAMS");
        System.out.println("#".repeat(60));
        demonstrateParallelStreams();
        
        // Section 8: Advanced Stream Operations
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 8: ADVANCED STREAM OPERATIONS");
        System.out.println("#".repeat(60));
        demonstrateAdvancedOperations();
        
        // Section 9: Stream of Objects
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 9: STREAM OF CUSTOM OBJECTS");
        System.out.println("#".repeat(60));
        demonstrateStreamOfObjects();
        
        // Section 10: Common Stream Patterns
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 10: COMMON STREAM PATTERNS");
        System.out.println("#".repeat(60));
        demonstrateCommonPatterns();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("🎉 CONGRATULATIONS! You've learned Java Stream API basics!");
        System.out.println("=".repeat(80));
    }
    
    // =========================================================================
    // SECTION 1: CREATING STREAMS
    // =========================================================================
    
    private static void demonstrateStreamCreation() {
        System.out.println("\n📌 Different ways to create streams");
        
        // Method 1: From Collections
        System.out.println("\n1. stream() from Collection:");
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        Stream<String> stream1 = list.stream();
        System.out.println("   Stream from List: " + stream1.count() + " elements");
        
        // Method 2: From Arrays
        System.out.println("\n2. Arrays.stream():");
        String[] array = {"Dog", "Cat", "Bird"};
        Stream<String> stream2 = Arrays.stream(array);
        System.out.println("   Stream from Array: " + stream2.count() + " elements");
        
        // Method 3: Stream.of()
        System.out.println("\n3. Stream.of():");
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        System.out.println("   Stream.of(1,2,3,4,5): " + stream3.collect(Collectors.toList()));
        
        // Method 4: Stream.builder()
        System.out.println("\n4. Stream.builder():");
        Stream<String> stream4 = Stream.<String>builder()
            .add("One")
            .add("Two")
            .add("Three")
            .build();
        System.out.println("   Builder stream: " + stream4.collect(Collectors.toList()));
        
        // Method 5: Stream.iterate() - infinite stream
        System.out.println("\n5. Stream.iterate() (limited):");
        Stream<Integer> stream5 = Stream.iterate(0, n -> n + 2).limit(5);
        System.out.println("   Even numbers (first 5): " + stream5.collect(Collectors.toList()));
        
        // Method 6: Stream.generate() - infinite stream
        System.out.println("\n6. Stream.generate() (limited):");
        Stream<Double> stream6 = Stream.generate(Math::random).limit(3);
        System.out.println("   Random numbers: " + stream6.collect(Collectors.toList()));
        
        // Method 7: IntStream.range()
        System.out.println("\n7. IntStream.range():");
        IntStream range1 = IntStream.range(1, 6); // 1 to 5
        IntStream range2 = IntStream.rangeClosed(1, 5); // 1 to 5 inclusive
        System.out.println("   range(1,6): " + Arrays.toString(range1.toArray()));
        System.out.println("   rangeClosed(1,5): " + Arrays.toString(range2.toArray()));
        
        // Method 8: Empty stream
        System.out.println("\n8. Stream.empty():");
        Stream<String> emptyStream = Stream.empty();
        System.out.println("   Empty stream count: " + emptyStream.count());
        
        // Method 9: Stream.concat()
        System.out.println("\n9. Stream.concat():");
        Stream<String> streamA = Stream.of("A", "B", "C");
        Stream<String> streamB = Stream.of("X", "Y", "Z");
        Stream<String> concatenated = Stream.concat(streamA, streamB);
        System.out.println("   Concatenated: " + concatenated.collect(Collectors.toList()));
        
        // Method 10: Stream.ofNullable() (Java 9+)
        System.out.println("\n10. Stream.ofNullable() (Java 9+):");
        String str = "Hello";
        Stream<String> nullableStream = Stream.ofNullable(str);
        System.out.println("   ofNullable with non-null: " + nullableStream.count());
        
        System.out.println("\n   ✅ Stream creation demonstrated");
    }
    
    // =========================================================================
    // SECTION 2: INTERMEDIATE OPERATIONS
    // =========================================================================
    
    private static void demonstrateIntermediateOperations() {
        System.out.println("\n📌 Intermediate Operations (transform streams)");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<String> duplicates = Arrays.asList("A", "B", "A", "C", "B", "D");
        
        System.out.println("\nOriginal list: " + numbers);
        System.out.println("Original words: " + words);
        
        // Method 1: filter() - keep elements that match predicate
        System.out.println("\n1. filter() - keep even numbers:");
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("   Evens: " + evens);
        
        // Method 2: map() - transform each element
        System.out.println("\n2. map() - square each number:");
        List<Integer> squares = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("   Squares: " + squares);
        
        // Method 3: flatMap() - flatten nested structures
        System.out.println("\n3. flatMap() - flatten lists:");
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
        );
        List<Integer> flattened = nested.stream()
            .flatMap(list -> list.stream())
            .collect(Collectors.toList());
        System.out.println("   Nested: " + nested);
        System.out.println("   Flattened: " + flattened);
        
        // Method 4: distinct() - remove duplicates
        System.out.println("\n4. distinct() - remove duplicates:");
        List<String> distinct = duplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("   Original: " + duplicates);
        System.out.println("   Distinct: " + distinct);
        
        // Method 5: sorted() - sort elements
        System.out.println("\n5. sorted() - sort elements:");
        List<Integer> unsorted = Arrays.asList(5, 2, 8, 1, 9, 3);
        List<Integer> sorted = unsorted.stream()
            .sorted()
            .collect(Collectors.toList());
        List<Integer> reverseSorted = unsorted.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println("   Unsorted: " + unsorted);
        System.out.println("   Sorted: " + sorted);
        System.out.println("   Reverse sorted: " + reverseSorted);
        
        // Method 6: peek() - perform action on each element (debugging)
        System.out.println("\n6. peek() - for debugging:");
        List<Integer> peeked = numbers.stream()
            .peek(n -> System.out.print("   Processing: " + n))
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println(" -> Even: " + n))
            .collect(Collectors.toList());
        System.out.println("   Result: " + peeked);
        
        // Method 7: limit() - limit number of elements
        System.out.println("\n7. limit() - first 3 elements:");
        List<Integer> first3 = numbers.stream()
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("   First 3: " + first3);
        
        // Method 8: skip() - skip first n elements
        System.out.println("\n8. skip() - skip first 3 elements:");
        List<Integer> afterSkip = numbers.stream()
            .skip(3)
            .collect(Collectors.toList());
        System.out.println("   After skip 3: " + afterSkip);
        
        // Method 9: mapToInt/Long/Double - convert to numeric streams
        System.out.println("\n9. mapToInt() - convert to IntStream:");
        int sum = words.stream()
            .mapToInt(String::length)
            .sum();
        System.out.println("   Sum of word lengths: " + sum);
        
        // Method 10: boxed() - convert numeric stream back to object stream
        System.out.println("\n10. boxed() - convert IntStream to Stream<Integer>:");
        List<Integer> intList = IntStream.range(1, 6)
            .boxed()
            .collect(Collectors.toList());
        System.out.println("   Boxed IntStream: " + intList);
        
        // Method 11: takeWhile() - Java 9+ - take while condition true
        System.out.println("\n11. takeWhile() (Java 9+):");
        List<Integer> takeWhileLessThan5 = numbers.stream()
            .takeWhile(n -> n < 5)
            .collect(Collectors.toList());
        System.out.println("   takeWhile(n < 5): " + takeWhileLessThan5);
        
        // Method 12: dropWhile() - Java 9+ - drop while condition true
        System.out.println("\n12. dropWhile() (Java 9+):");
        List<Integer> dropWhileLessThan5 = numbers.stream()
            .dropWhile(n -> n < 5)
            .collect(Collectors.toList());
        System.out.println("   dropWhile(n < 5): " + dropWhileLessThan5);
        
        System.out.println("\n   ✅ Intermediate operations demonstrated");
    }
    
    // =========================================================================
    // SECTION 3: TERMINAL OPERATIONS
    // =========================================================================
    
    private static void demonstrateTerminalOperations() {
        System.out.println("\n📌 Terminal Operations (produce result)");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<Integer> emptyList = Collections.emptyList();
        
        System.out.println("\nOriginal list: " + numbers);
        
        // Method 1: forEach() - perform action for each element
        System.out.println("\n1. forEach():");
        System.out.print("   Numbers: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Method 2: forEachOrdered() - maintain order in parallel streams
        System.out.println("\n2. forEachOrdered():");
        numbers.parallelStream()
            .forEachOrdered(n -> System.out.print(n + " "));
        System.out.println(" (maintains order)");
        
        // Method 3: collect() - accumulate elements into collection
        System.out.println("\n3. collect():");
        Set<Integer> numberSet = numbers.stream()
            .collect(Collectors.toSet());
        System.out.println("   Collected to Set: " + numberSet);
        
        // Method 4: toList() - Java 16+ - shortcut to collect to list
        System.out.println("\n4. toList() (Java 16+):");
        List<Integer> toList = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toList();
        System.out.println("   toList(): " + toList);
        
        // Method 5: reduce() - combine elements to single value
        System.out.println("\n5. reduce():");
        Optional<Integer> sum1 = numbers.stream()
            .reduce((a, b) -> a + b);
        Integer sum2 = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("   Sum with reduce (Optional): " + sum1.orElse(0));
        System.out.println("   Sum with reduce (identity): " + sum2);
        
        // Method 6: count() - count elements
        System.out.println("\n6. count():");
        long count = numbers.stream().count();
        System.out.println("   Count: " + count);
        
        // Method 7: min()/max() - find minimum/maximum
        System.out.println("\n7. min()/max():");
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println("   Min: " + min.orElse(0));
        System.out.println("   Max: " + max.orElse(0));
        
        // Method 8: findFirst() - find first element
        System.out.println("\n8. findFirst():");
        Optional<Integer> first = numbers.stream()
            .filter(n -> n > 5)
            .findFirst();
        System.out.println("   First number > 5: " + first.orElse(null));
        
        // Method 9: findAny() - find any element (useful in parallel)
        System.out.println("\n9. findAny():");
        Optional<Integer> any = numbers.parallelStream()
            .filter(n -> n > 5)
            .findAny();
        System.out.println("   Any number > 5: " + any.orElse(null));
        
        // Method 10: anyMatch() - check if any element matches
        System.out.println("\n10. anyMatch():");
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean hasNegative = numbers.stream().anyMatch(n -> n < 0);
        System.out.println("   Has even number? " + hasEven);
        System.out.println("   Has negative number? " + hasNegative);
        
        // Method 11: allMatch() - check if all elements match
        System.out.println("\n11. allMatch():");
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("   All positive? " + allPositive);
        System.out.println("   All even? " + allEven);
        
        // Method 12: noneMatch() - check if no elements match
        System.out.println("\n12. noneMatch():");
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        boolean noneGreaterThan10 = numbers.stream().noneMatch(n -> n > 10);
        System.out.println("   No negative? " + noneNegative);
        System.out.println("   No > 10? " + noneGreaterThan10);
        
        // Method 13: toArray() - convert to array
        System.out.println("\n13. toArray():");
        Integer[] array = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toArray(Integer[]::new);
        System.out.println("   Array of evens: " + Arrays.toString(array));
        
        // Method 14: iterator() - get iterator
        System.out.println("\n14. iterator():");
        Iterator<Integer> iterator = numbers.stream().iterator();
        System.out.print("   First 3 via iterator: ");
        for (int i = 0; i < 3 && iterator.hasNext(); i++) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Method 15: summaryStatistics() - get statistics
        System.out.println("\n15. summaryStatistics():");
        IntSummaryStatistics stats = numbers.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("   Statistics: " + stats);
        
        System.out.println("\n   ✅ Terminal operations demonstrated");
    }
    
    // =========================================================================
    // SECTION 4: SHORT-CIRCUIT OPERATIONS
    // =========================================================================
    
    private static void demonstrateShortCircuitOperations() {
        System.out.println("\n📌 Short-circuit Operations (stop early)");
        
        // List<Integer> infinite = Stream.iterate(0, n -> n + 1).collect(Collectors.toList());
        List<Integer> list = Stream.iterate(0, i -> i + 1)
                           .limit(10) // Stop after 10 elements
                           .collect(Collectors.toList()); // Now it's safe

        System.out.println("\n1. limit() - stop after n elements:");
        List<Integer> limited = Stream.iterate(1, n -> n + 1)
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("   First 5 natural numbers: " + limited);
        
        System.out.println("\n2. findFirst() - stop when first found:");
        Optional<Integer> firstEven = Stream.iterate(1, n -> n + 1)
            .filter(n -> n % 2 == 0)
            .findFirst();
        System.out.println("   First even number: " + firstEven.orElse(0));
        
        System.out.println("\n3. anyMatch() - stop when match found:");
        boolean found = Stream.iterate(1, n -> n + 1)
            .anyMatch(n -> n > 100);
        System.out.println("   Found number > 100? " + found);
        
        System.out.println("\n4. allMatch() - may stop early on false:");
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 9, 10);
        boolean allEven = numbers.stream()
            .peek(n -> System.out.print("   Checking: " + n))
            .allMatch(n -> n % 2 == 0);
        System.out.println("\n   All even? " + allEven);
        
        System.out.println("\n   ✅ Short-circuit operations demonstrated");
    }
    
    // =========================================================================
    // SECTION 5: NUMERIC STREAMS
    // =========================================================================
    
    private static void demonstrateNumericStreams() {
        System.out.println("\n📌 Numeric Streams (IntStream, LongStream, DoubleStream)");
        
        // Method 1: range() and rangeClosed()
        System.out.println("\n1. range() and rangeClosed():");
        IntStream.range(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println(" (range 1-5)");
        IntStream.rangeClosed(1, 5).forEach(n -> System.out.print(n + " "));
        System.out.println(" (rangeClosed 1-5)");
        
        // Method 2: sum()
        System.out.println("\n2. sum():");
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("   Sum of 1-10: " + sum);
        
        // Method 3: average()
        System.out.println("\n3. average():");
        OptionalDouble avg = IntStream.rangeClosed(1, 10).average();
        System.out.println("   Average of 1-10: " + avg.orElse(0));
        
        // Method 4: min()/max()
        System.out.println("\n4. min()/max():");
        OptionalInt min = IntStream.of(5, 2, 8, 1, 9, 3).min();
        OptionalInt max = IntStream.of(5, 2, 8, 1, 9, 3).max();
        System.out.println("   Min: " + min.orElse(0) + ", Max: " + max.orElse(0));
        
        // Method 5: summaryStatistics()
        System.out.println("\n5. summaryStatistics():");
        IntSummaryStatistics stats = IntStream.of(5, 2, 8, 1, 9, 3).summaryStatistics();
        System.out.println("   Statistics: count=" + stats.getCount() + 
            ", sum=" + stats.getSum() + 
            ", avg=" + stats.getAverage() + 
            ", min=" + stats.getMin() + 
            ", max=" + stats.getMax());
        
        // Method 6: mapToObj()
        System.out.println("\n6. mapToObj() - convert to object stream:");
        List<String> evenOdd = IntStream.rangeClosed(1, 5)
            .mapToObj(n -> n % 2 == 0 ? "Even" : "Odd")
            .collect(Collectors.toList());
        System.out.println("   Even/Odd mapping: " + evenOdd);
        
        // Method 7: boxed()
        System.out.println("\n7. boxed() - convert to Stream<Integer>:");
        List<Integer> boxedList = IntStream.rangeClosed(1, 5)
            .boxed()
            .collect(Collectors.toList());
        System.out.println("   Boxed: " + boxedList);
        
        // Method 8: asDoubleStream()/asLongStream()
        System.out.println("\n8. asDoubleStream():");
        IntStream.rangeClosed(1, 5)
            .asDoubleStream()
            .forEach(d -> System.out.print(d + " "));
        System.out.println(" (as double)");
        
        // Method 9: distinct()
        System.out.println("\n9. distinct():");
        IntStream.of(1, 2, 2, 3, 3, 3, 4, 5)
            .distinct()
            .forEach(n -> System.out.print(n + " "));
        System.out.println(" (unique numbers)");
        
        // Method 10: sorted()
        System.out.println("\n10. sorted():");
        IntStream.of(5, 2, 8, 1, 9, 3)
            .sorted()
            .forEach(n -> System.out.print(n + " "));
        System.out.println(" (sorted)");
        
        // Method 11: flatMap for numeric streams
        System.out.println("\n11. flatMap for numeric streams:");
        List<Integer> pairs = IntStream.rangeClosed(1, 3)
            .flatMap(i -> IntStream.rangeClosed(1, 2).map(j -> i * 10 + j))
            .boxed()
            .collect(Collectors.toList());
        System.out.println("   Multiplications: " + pairs);
        
        System.out.println("\n   ✅ Numeric streams demonstrated");
    }
    
    // =========================================================================
    // SECTION 6: COLLECTORS
    // =========================================================================
    
    private static void demonstrateCollectors() {
        System.out.println("\n📌 Collectors - Terminal operations that collect data");
        
        List<String> items = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "date");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("\nOriginal list: " + items);
        
        // Method 1: toList() - collect to List
        System.out.println("\n1. toList():");
        List<String> list = items.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("   Distinct to List: " + list);
        
        // Method 2: toSet() - collect to Set
        System.out.println("\n2. toSet():");
        Set<String> set = items.stream()
            .collect(Collectors.toSet());
        System.out.println("   To Set: " + set);
        
        // Method 3: toCollection() - collect to specific collection
        System.out.println("\n3. toCollection():");
        LinkedList<String> linkedList = items.stream()
            .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("   To LinkedList: " + linkedList);
        
        // Method 4: joining() - join strings
        System.out.println("\n4. joining():");
        String joined1 = items.stream()
            .collect(Collectors.joining());
        String joined2 = items.stream()
            .collect(Collectors.joining(", "));
        String joined3 = items.stream()
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("   Simple join: " + joined1);
        System.out.println("   Join with delimiter: " + joined2);
        System.out.println("   Join with prefix/suffix: " + joined3);
        
        // Method 5: groupingBy() - group elements
        System.out.println("\n5. groupingBy():");
        Map<Integer, List<String>> byLength = items.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("   Grouped by length: " + byLength);
        
        // Method 6: partitioningBy() - partition into two groups
        System.out.println("\n6. partitioningBy():");
        Map<Boolean, List<Integer>> evenOdd = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("   Even numbers: " + evenOdd.get(true));
        System.out.println("   Odd numbers: " + evenOdd.get(false));
        
        // Method 7: counting() - count elements
        System.out.println("\n7. counting():");
        Long count = items.stream()
            .collect(Collectors.counting());
        System.out.println("   Count: " + count);
        
        // Method 8: summingInt() - sum of integers
        System.out.println("\n8. summingInt():");
        Integer sum = items.stream()
            .collect(Collectors.summingInt(String::length));
        System.out.println("   Sum of lengths: " + sum);
        
        // Method 9: averagingInt() - average of integers
        System.out.println("\n9. averagingInt():");
        Double average = items.stream()
            .collect(Collectors.averagingInt(String::length));
        System.out.println("   Average length: " + average);
        
        // Method 10: summarizingInt() - get all statistics
        System.out.println("\n10. summarizingInt():");
        IntSummaryStatistics stats = items.stream()
            .collect(Collectors.summarizingInt(String::length));
        System.out.println("   Statistics: " + stats);
        
        // Method 11: mapping() - map before collecting
        System.out.println("\n11. mapping():");
        Set<Integer> lengths = items.stream()
            .collect(Collectors.mapping(String::length, Collectors.toSet()));
        System.out.println("   Lengths set: " + lengths);
        
        // Method 12: filtering() - Java 9+ - filter while collecting
        System.out.println("\n12. filtering() (Java 9+):");
        List<String> longWords = items.stream()
            .collect(Collectors.filtering(s -> s.length() > 5, Collectors.toList()));
        System.out.println("   Words length > 5: " + longWords);
        
        // Method 13: flatMapping() - Java 9+ - flatMap while collecting
        System.out.println("\n13. flatMapping() (Java 9+):");
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D"),
            Arrays.asList("E", "F")
        );
        List<String> flatMapped = listOfLists.stream()
            .collect(Collectors.flatMapping(List::stream, Collectors.toList()));
        System.out.println("   flatMapped: " + flatMapped);
        
        // Method 14: toMap() - collect to Map
        System.out.println("\n14. toMap():");
        Map<String, Integer> wordLengthMap = items.stream()
            .distinct()
            .collect(Collectors.toMap(
                word -> word,        // key mapper
                String::length,       // value mapper
                (v1, v2) -> v1       // merge function for duplicates
            ));
        System.out.println("   Word to length map: " + wordLengthMap);
        
        // Method 15: collectingAndThen() - transform after collecting
        System.out.println("\n15. collectingAndThen():");
        Integer unmodifiableSetSize = items.stream()
            .collect(Collectors.collectingAndThen(
                Collectors.toSet(),
                set1 -> set1.size()
            ));
        System.out.println("   Size of collected set: " + unmodifiableSetSize);
        
        // Method 16: teeing() - Java 12+ - collect using two collectors
        System.out.println("\n16. teeing() (Java 12+):");
        class MinMax {
            final int min;
            final int max;
            MinMax(int min, int max) { this.min = min; this.max = max; }
            public String toString() { return "MinMax{min=" + min + ", max=" + max + "}"; }
        }
        
        MinMax minMax = numbers.stream()
            .collect(Collectors.teeing(
                Collectors.minBy(Integer::compare),
                Collectors.maxBy(Integer::compare),
                (min1, max1) -> new MinMax(min1.orElse(0), max1.orElse(0))
            ));
        System.out.println("   Min and Max: " + minMax);
        
        System.out.println("\n   ✅ Collectors demonstrated");
    }
    
    // =========================================================================
    // SECTION 7: PARALLEL STREAMS
    // =========================================================================
    
    private static void demonstrateParallelStreams() {
        System.out.println("\n📌 Parallel Streams (for multi-threaded processing)");
        
        List<Integer> numbers = IntStream.rangeClosed(1, 100)
            .boxed()
            .collect(Collectors.toList());
        
        // Method 1: parallelStream() - create parallel stream
        System.out.println("\n1. parallelStream():");
        long parallelCount = numbers.parallelStream().count();
        System.out.println("   Parallel count: " + parallelCount);
        
        // Method 2: parallel() - convert sequential to parallel
        System.out.println("\n2. parallel() - convert to parallel:");
        long parallelSum = numbers.stream()
            .parallel()
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("   Parallel sum: " + parallelSum);
        
        // Method 3: sequential() - convert back to sequential
        System.out.println("\n3. sequential() - convert back to sequential:");
        long sequentialSum = numbers.parallelStream()
            .sequential()
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("   Sequential sum: " + sequentialSum);
        
        // Method 4: Performance comparison
        System.out.println("\n4. Performance comparison:");
        
        long start = System.currentTimeMillis();
        long seqSum = numbers.stream()
            .map(n -> n * n)
            .filter(n -> n % 2 == 0)
            .count();
        long seqTime = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        long parSum = numbers.parallelStream()
            .map(n -> n * n)
            .filter(n -> n % 2 == 0)
            .count();
        long parTime = System.currentTimeMillis() - start;
        
        System.out.println("   Sequential time: " + seqTime + "ms");
        System.out.println("   Parallel time: " + parTime + "ms");
        System.out.println("   (Parallel may be faster for large datasets)");
        
        // Method 5: isParallel() - check if parallel
        System.out.println("\n5. isParallel():");
        System.out.println("   Stream is parallel? " + numbers.parallelStream().isParallel());
        System.out.println("   Stream after sequential()? " + numbers.parallelStream().sequential().isParallel());
        
        // Method 6: forEachOrdered() - maintain order in parallel
        System.out.println("\n6. forEachOrdered() vs forEach():");
        System.out.print("   forEach (unordered): ");
        numbers.parallelStream()
            .limit(10)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.print("   forEachOrdered: ");
        numbers.parallelStream()
            .limit(10)
            .forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();
        
        // Method 7: Find operations in parallel
        System.out.println("\n7. findAny() in parallel (non-deterministic):");
        Optional<Integer> any = numbers.parallelStream()
            .filter(n -> n > 50)
            .findAny();
        System.out.println("   findAny() result: " + any.orElse(0) + " (may vary)");
        
        Optional<Integer> first = numbers.parallelStream()
            .filter(n -> n > 50)
            .findFirst();
        System.out.println("   findFirst() result: " + first.orElse(0) + " (always same)");
        
        System.out.println("\n   ✅ Parallel streams demonstrated");
    }
    
    // =========================================================================
    // SECTION 8: ADVANCED STREAM OPERATIONS
    // =========================================================================
    
    private static void demonstrateAdvancedOperations() {
        System.out.println("\n📌 Advanced Stream Operations");
        
        // Method 1: reduce() with identity, accumulator, combiner
        System.out.println("\n1. reduce() with combiner:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        Integer parallelSum = numbers.parallelStream()
            .reduce(0,
                (a, b) -> a + b,           // accumulator
                (a, b) -> a + b);           // combiner (for parallel)
        System.out.println("   Parallel reduce sum: " + parallelSum);
        
        // Method 2: mapMulti() - Java 16+ - alternative to flatMap
        System.out.println("\n2. mapMulti() (Java 16+):");
        List<Integer> result = numbers.stream()
            .<Integer>mapMulti((n, consumer) -> {
                if (n % 2 == 0) {
                    consumer.accept(n);
                    consumer.accept(n * 2);
                }
            })
            .collect(Collectors.toList());
        System.out.println("   mapMulti (even and double): " + result);
        
        // Method 3: takeWhile/dropWhile with predicate
        System.out.println("\n3. takeWhile/dropWhile with predicate:");
        List<Integer> sorted = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        List<Integer> taken = sorted.stream()
            .takeWhile(n -> n < 5)
            .collect(Collectors.toList());
        List<Integer> dropped = sorted.stream()
            .dropWhile(n -> n < 5)
            .collect(Collectors.toList());
        
        System.out.println("   takeWhile(n < 5): " + taken);
        System.out.println("   dropWhile(n < 5): " + dropped);
        
        // Method 4: iterate() with predicate (Java 9+)
        System.out.println("\n4. iterate() with predicate:");
        List<Integer> iterated = Stream.iterate(0, n -> n < 10, n -> n + 2)
            .collect(Collectors.toList());
        System.out.println("   iterate(0, n<10, n+2): " + iterated);
        
        // Method 5: ofNullable()
        System.out.println("\n5. ofNullable():");
        Stream<String> nonNull = Stream.ofNullable("Hello");
        Stream<String> nullStream = Stream.ofNullable(null);
        System.out.println("   nonNull count: " + nonNull.count());
        System.out.println("   nullStream count: " + nullStream.count());
        
        // Method 6: concat() with multiple streams
        System.out.println("\n6. concat() multiple streams:");
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> stream3 = Stream.of(7, 8, 9);
        
        Stream<Integer> concat = Stream.concat(Stream.concat(stream1, stream2), stream3);
        System.out.println("   Concatenated: " + concat.collect(Collectors.toList()));
        
        // Method 7: generate() with Supplier
        System.out.println("\n7. generate() with Supplier:");
        List<Double> randoms = Stream.generate(Math::random)
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("   5 random numbers: " + randoms);
        
        // Method 8: iterate() with UnaryOperator
        System.out.println("\n8. iterate() with UnaryOperator:");
        List<Integer> powersOf2 = Stream.iterate(1, n -> n * 2)
            .limit(6)
            .collect(Collectors.toList());
        System.out.println("   First 6 powers of 2: " + powersOf2);
        
        System.out.println("\n   ✅ Advanced operations demonstrated");
    }
    
    // =========================================================================
    // SECTION 9: STREAM OF CUSTOM OBJECTS
    // =========================================================================
    
    static class Person {
        String name;
        int age;
        String city;
        
        Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }
        
        String getName() { return name; }
        int getAge() { return age; }
        String getCity() { return city; }
        
        @Override
        public String toString() {
            return String.format("%s(%d,%s)", name, age, city);
        }
    }
    
    private static void demonstrateStreamOfObjects() {
        System.out.println("\n📌 Stream of Custom Objects");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "New York"),
            new Person("Bob", 30, "London"),
            new Person("Charlie", 35, "New York"),
            new Person("Diana", 28, "Paris"),
            new Person("Eve", 22, "London"),
            new Person("Frank", 40, "New York")
        );
        
        System.out.println("\nPeople list: " + people);
        
        // Filter by age
        System.out.println("\n1. Filter by age (age > 30):");
        List<Person> older = people.stream()
            .filter(p -> p.getAge() > 30)
            .collect(Collectors.toList());
        System.out.println("   " + older);
        
        // Map to names
        System.out.println("\n2. Map to names:");
        List<String> names = people.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
        System.out.println("   " + names);
        
        // Group by city
        System.out.println("\n3. Group by city:");
        Map<String, List<Person>> byCity = people.stream()
            .collect(Collectors.groupingBy(Person::getCity));
        System.out.println("   " + byCity);
        
        // Average age by city
        System.out.println("\n4. Average age by city:");
        Map<String, Double> avgAgeByCity = people.stream()
            .collect(Collectors.groupingBy(
                Person::getCity,
                Collectors.averagingInt(Person::getAge)
            ));
        System.out.println("   " + avgAgeByCity);
        
        // Count by city
        System.out.println("\n5. Count by city:");
        Map<String, Long> countByCity = people.stream()
            .collect(Collectors.groupingBy(
                Person::getCity,
                Collectors.counting()
            ));
        System.out.println("   " + countByCity);
        
        // Oldest person in each city
        System.out.println("\n6. Oldest person in each city:");
        Map<String, Optional<Person>> oldestByCity = people.stream()
            .collect(Collectors.groupingBy(
                Person::getCity,
                Collectors.maxBy(Comparator.comparing(Person::getAge))
            ));
        System.out.println("   " + oldestByCity);
        
        // Sort by multiple fields
        System.out.println("\n7. Sort by age then name:");
        List<Person> sorted = people.stream()
            .sorted(Comparator.comparing(Person::getAge)
                .thenComparing(Person::getName))
            .collect(Collectors.toList());
        System.out.println("   " + sorted);
        
        // Any match
        System.out.println("\n8. Any person from Paris?");
        boolean hasParis = people.stream()
            .anyMatch(p -> p.getCity().equals("Paris"));
        System.out.println("   " + hasParis);
        
        // All match
        System.out.println("\n9. All people older than 18?");
        boolean allAdult = people.stream()
            .allMatch(p -> p.getAge() >= 18);
        System.out.println("   " + allAdult);
        
        // Find first
        System.out.println("\n10. First person from London:");
        Optional<Person> firstLondon = people.stream()
            .filter(p -> p.getCity().equals("London"))
            .findFirst();
        firstLondon.ifPresent(p -> System.out.println("   " + p));
        
        System.out.println("\n   ✅ Stream of objects demonstrated");
    }
    
    // =========================================================================
    // SECTION 10: COMMON STREAM PATTERNS
    // =========================================================================
    
    private static void demonstrateCommonPatterns() {
        System.out.println("\n📌 Common Stream Patterns (Real-world examples)");
        
        // Pattern 1: Convert list to map
        System.out.println("\n1. Convert list to map (id -> value):");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        Map<String, Integer> wordLengths = words.stream()
            .collect(Collectors.toMap(
                word -> word,                // key
                String::length,               // value
                (v1, v2) -> v1                // merge function
            ));
        System.out.println("   " + wordLengths);
        
        // Pattern 2: Find duplicates
        System.out.println("\n2. Find duplicates:");
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 8, 5);
        Set<Integer> duplicates = numbersWithDuplicates.stream()
            .filter(n -> Collections.frequency(numbersWithDuplicates, n) > 1)
            .collect(Collectors.toSet());
        System.out.println("   Duplicates: " + duplicates);
        
        // Pattern 3: Get top N elements
        System.out.println("\n3. Get top 3 largest numbers:");
        List<Integer> numbers = Arrays.asList(45, 12, 78, 34, 90, 23, 67, 89);
        List<Integer> top3 = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("   Top 3: " + top3);
        
        // Pattern 4: Get bottom N elements
        System.out.println("\n4. Get bottom 3 smallest numbers:");
        List<Integer> bottom3 = numbers.stream()
            .sorted()
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("   Bottom 3: " + bottom3);
        
        // Pattern 5: Pagination (skip and limit)
        System.out.println("\n5. Pagination - get page 2 of size 3:");
        List<Integer> page2 = numbers.stream()
            .sorted()
            .skip(3)  // skip first 3 (page 1)
            .limit(3) // take next 3 (page 2)
            .collect(Collectors.toList());
        System.out.println("   Page 2: " + page2);
        
        // Pattern 6: Join strings with conditions
        System.out.println("\n6. Join strings with condition:");
        String longWordsJoined = words.stream()
            .filter(w -> w.length() > 4)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("   Long words: " + longWordsJoined);
        
        // Pattern 7: Check if all elements match
        System.out.println("\n7. Check if all elements are positive:");
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("   All positive? " + allPositive);
        
        // Pattern 8: Get statistics
        System.out.println("\n8. Get statistics of word lengths:");
        IntSummaryStatistics stats = words.stream()
            .mapToInt(String::length)
            .summaryStatistics();
        System.out.println("   Statistics: " + stats);
        
        // Pattern 9: Partition into two groups
        System.out.println("\n9. Partition numbers into even and odd:");
        Map<Boolean, List<Integer>> evenOdd = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("   Even: " + evenOdd.get(true));
        System.out.println("   Odd: " + evenOdd.get(false));
        
        // Pattern 10: Group by first letter
        System.out.println("\n10. Group words by first letter:");
        Map<Character, List<String>> byFirstLetter = words.stream()
            .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println("   " + byFirstLetter);
        
        // Pattern 11: Sum of squares
        System.out.println("\n11. Sum of squares of even numbers:");
        int sumOfSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(n -> n * n)
            .sum();
        System.out.println("   Sum of squares: " + sumOfSquares);
        
        // Pattern 12: Find maximum length word
        System.out.println("\n12. Find word with maximum length:");
        Optional<String> longest = words.stream()
            .max(Comparator.comparing(String::length));
        longest.ifPresent(w -> System.out.println("   Longest: " + w));
        
        // Pattern 13: Flatten list of lists
        System.out.println("\n13. Flatten list of lists:");
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4, 5),
            Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> allNumbers = listOfLists.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("   All numbers: " + allNumbers);
        
        // Pattern 14: Remove nulls
        System.out.println("\n14. Remove null values:");
        List<String> withNulls = Arrays.asList("A", null, "B", null, "C", null, "D");
        List<String> withoutNulls = withNulls.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        System.out.println("   Without nulls: " + withoutNulls);
        
        // Pattern 15: Count frequency
        System.out.println("\n15. Count frequency of each word:");
        List<String> sentence = Arrays.asList("the", "cat", "sat", "on", "the", "mat");
        Map<String, Long> frequency = sentence.stream()
            .collect(Collectors.groupingBy(
                word -> word,
                Collectors.counting()
            ));
        System.out.println("   Frequency: " + frequency);
        
        System.out.println("\n   ✅ Common patterns demonstrated");
    }
}

/**
 * 📚 BEGINNER'S GUIDE TO JAVA STREAMS
 * =====================================
 * 
 * 1. WHAT ARE STREAMS?
 *    - A sequence of elements supporting sequential and parallel operations
 *    - Not a data structure (doesn't store data)
 *    - Designed for functional-style operations on collections
 *    - Can be used with arrays, collections, or I/O channels
 * 
 * 2. STREAM PIPELINE:
 *    Source → Intermediate Operations → Terminal Operation
 *    ┌────────┐    ┌──────────────────┐    ┌────────────┐
 *    │ Stream │ → │ filter, map, etc. │ → │ collect,   │
 *    │ Source │    │ (0 or more)       │    │ forEach,   │
 *    └────────┘    └──────────────────┘    │ sum, etc.  │
 *                                          └────────────┘
 * 
 * 3. STREAM CHARACTERISTICS:
 *    - Lazy evaluation (operations only execute when terminal operation called)
 *    - Can be infinite
 *    - Consumable (can only use once)
 *    - Parallelizable
 *    - Stateless operations (preferred)
 * 
 * 4. STREAM TYPES:
 *    ┌──────────────┬────────────────────────────────────┐
 *    │ Type         │ Use For                            │
 *    ├──────────────┼────────────────────────────────────┤
 *    │ Stream<T>    │ Object streams                     │
 *    │ IntStream    │ Primitive ints (avoids boxing)     │
 *    │ LongStream   │ Primitive longs                    │
 *    │ DoubleStream │ Primitive doubles                   │
 *    └──────────────┴────────────────────────────────────┘
 * 
 * 5. INTERMEDIATE OPERATIONS (return Stream):
 *    ┌──────────┬────────────────────────────────────────┐
 *    │ Method   │ Purpose                                 │
 *    ├──────────┼────────────────────────────────────────┤
 *    │ filter   │ Keep elements matching predicate       │
 *    │ map      │ Transform elements                     │
 *    │ flatMap  │ Flatten nested structures              │
 *    │ distinct │ Remove duplicates                       │
 *    │ sorted   │ Sort elements                           │
 *    │ peek     │ Perform action (debugging)             │
 *    │ limit    │ Limit number of elements               │
 *    │ skip     │ Skip first n elements                  │
 *    │ takeWhile│ Take while condition true (Java 9+)    │
 *    │ dropWhile│ Drop while condition true (Java 9+)    │
 *    └──────────┴────────────────────────────────────────┘
 * 
 * 6. TERMINAL OPERATIONS (return result):
 *    ┌─────────────┬──────────────────────────────────────┐
 *    │ Method      │ Purpose                               │
 *    ├─────────────┼──────────────────────────────────────┤
 *    │ forEach     │ Perform action for each element      │
 *    │ collect     │ Accumulate into collection           │
 *    │ toList      │ Convert to list (Java 16+)           │
 *    │ reduce      │ Combine elements to single value     │
 *    │ count       │ Count elements                        │
 *    │ min/max     │ Find minimum/maximum                 │
 *    │ findFirst   │ Find first element                    │
 *    │ findAny     │ Find any element (parallel)          │
 *    │ anyMatch    │ Check if any element matches         │
 *    │ allMatch    │ Check if all elements match          │
 *    │ noneMatch   │ Check if no elements match           │
 *    │ toArray     │ Convert to array                      │
 *    │ sum/average │ Numeric operations (numeric streams) │
 *    └─────────────┴──────────────────────────────────────┘
 * 
 * 7. COLLECTORS (Collectors class):
 *    ┌──────────────┬─────────────────────────────────────┐
 *    │ Method       │ Purpose                              │
 *    ├──────────────┼─────────────────────────────────────┤
 *    │ toList()     │ Collect to List                      │
 *    │ toSet()      │ Collect to Set                       │
 *    │ toMap()      │ Collect to Map                       │
 *    │ joining()    │ Join strings                         │
 *    │ groupingBy() │ Group elements                       │
 *    │ partitioningBy│ Partition into two groups           │
 *    │ summingInt() │ Sum of ints                          │
 *    │ averagingInt()│ Average of ints                     │
 *    │ summarizingInt│ Get all statistics                  │
 *    │ mapping()    │ Map before collecting                │
 *    │ filtering()  │ Filter while collecting (Java 9+)   │
 *    │ flatMapping()│ FlatMap while collecting (Java 9+)  │
 *    │ teeing()     │ Collect using two collectors (Java 12+│
 *    └──────────────┴─────────────────────────────────────┘
 * 
 * 8. WHEN TO USE STREAMS:
 *    ✅ Processing collections
 *    ✅ Filtering and transforming data
 *    ✅ Aggregations (sum, average, count)
 *    ✅ Parallel processing of large datasets
 *    ✅ Declarative, readable code
 *    
 *    ❌ Simple loops (for readability)
 *    ❌ When performance is critical (overhead)
 *    ❌ With checked exceptions (cumbersome)
 *    ❌ Modifying source data
 * 
 * 9. PERFORMANCE TIPS:
 *    - Use primitive streams (IntStream, etc.) for numbers
 *    - Use parallel streams for large datasets
 *    - Order operations to reduce data size early
 *    - Avoid stateful lambda expressions
 *    - Be careful with infinite streams (use limit)
 * 
 * 10. COMMON PITFALLS:
 *     ⚠️ Stream can only be used once
 *     ⚠️ Cannot reuse a stream after terminal operation
 *     ⚠️ Parallel streams may not always be faster
 *     ⚠️ Order not guaranteed in parallel streams
 *     ⚠️ Modifying source during stream operation
 */

// 🎯 Quick Reference - Most Used Stream Methods
// Creation Methods

// Stream.of(1, 2, 3)
// Arrays.stream(array)
// list.stream()
// Stream.iterate(0, n -> n + 1)
// Stream.generate(Math::random)
// IntStream.range(1, 10)

// Filtering & Mapping

// .filter(x -> x > 5)
// .map(x -> x * 2)
// .flatMap(list -> list.stream())
// .distinct()
// .limit(5)
// .skip(3)


// Terminal Operations

// .collect(Collectors.toList())
// .forEach(System.out::println)
// .reduce(0, Integer::sum)
// .count()
// .min(Comparator.naturalOrder())
// .findFirst()
// .anyMatch(x -> x > 10)


// Common Collector Patterns

// // To List
// list.stream().collect(Collectors.toList())

// // Joining strings
// list.stream().collect(Collectors.joining(", "))

// // Grouping
// list.stream().collect(Collectors.groupingBy(Function))

// // Partitioning
// list.stream().collect(Collectors.partitioningBy(predicate))

// // Statistics
// list.stream().collect(Collectors.summarizingInt())