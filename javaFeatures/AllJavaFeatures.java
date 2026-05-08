import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.StampedLock;
import java.util.function.*;
import java.util.stream.*;
import java.util.regex.*;
import javax.script.*;
import java.lang.management.*;
import java.util.random.*;
import java.util.spi.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.invoke.*;
import java.lang.reflect.*;
import java.net.http.*;
import java.net.*;
import java.util.logging.*;
import java.text.*;

import java.lang.annotation.Repeatable;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
// Annotation definitions at class level
@Retention(RetentionPolicy.RUNTIME)
@interface Schedule {
    String dayOfWeek();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Schedules {
    Schedule[] value();
}

@Retention(RetentionPolicy.RUNTIME)
// @Repeatable(Schedules.class)
@interface Task {
    String description();
    String day();
}

@Retention(RetentionPolicy.RUNTIME)
@interface NonNull {}

@Retention(RetentionPolicy.RUNTIME)
@interface Readonly {}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Bugs.class)
@interface Bug {
    int id();
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Bugs {
    Bug[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Nullable {}
/**
 * Program to demonstrate all major Java features from Java 8, Java 17, and Java 21+
 */
public class AllJavaFeatures {
    
    public static void main(String[] args) throws Exception {
        System.out.println("=".repeat(100));
        System.out.println("COMPREHENSIVE DEMONSTRATION OF JAVA FEATURES (8, 17, 21+)");
        System.out.println("=".repeat(100));
        
        // ========== JAVA 8 FEATURES ==========
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 1: JAVA 8 FEATURES");
        System.out.println("#".repeat(80));
        
        demonstrateLambdaExpressions();
        demonstrateStreamAPI();
        demonstrateOptionalClass();
        demonstrateNewDateTimeAPI();
        demonstrateDefaultMethods();
        demonstrateFunctionalInterfaces();
        demonstrateMethodReferences();
        demonstrateCompletableFuture();
        demonstrateNashornJavaScript();
        demonstrateBase64Encoding();
        demonstrateStringJoiner();
        demonstrateParallelArraySorting();
        demonstrateStampedLock();
        demonstrateConcurrencyEnhancements();
        demonstrateNIOImprovements();
        // demonstrateRepeatableAnnotations();
        // demonstrateTypeAnnotations();
        // demonstrateReflectionParameters();
        
        // // ========== JAVA 9 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 2: JAVA 9 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateModuleSystem();
        // demonstratePrivateInterfaceMethods();
        // demonstrateTryWithResourcesEnhancement();
        // demonstrateDiamondOperatorEnhancement();
        // demonstrateSafeVarargsEnhancement();
        // demonstrateStreamEnhancements();
        // demonstrateOptionalEnhancements();
        // demonstrateCollectionFactoryMethods();
        // demonstrateCompletableFutureEnhancements();
        // demonstrateProcessAPI();
        // demonstrateStackWalkingAPI();
        // demonstrateVariableHandles();
        // demonstrateSpinWaitHints();
        // demonstrateReactiveStreams();
        // demonstrateHTTP2Client();
        // demonstrateMultiResolutionImage();
        
        // // ========== JAVA 10 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 3: JAVA 10 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateLocalVariableTypeInference();
        // demonstrateUnmodifiableCollections();
        // demonstrateOptionalOrElseThrow();
        // demonstratePerformanceImprovements();
        // demonstrateContainerAwareness();
        // demonstrateRootCertificates();
        // demonstrateThreadLocalHandshakes();
        // demonstrateHeapAllocation();
        // demonstrateGarbageCollectorInterfaces();
        
        // // ========== JAVA 11 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 4: JAVA 11 FEATURES (LTS)");
        // System.out.println("#".repeat(80));
        
        // demonstrateLocalVariableSyntaxForLambda();
        // demonstrateHttpClientAPI();
        // demonstrateStringMethods();
        // demonstrateFilesMethods();
        // demonstrateOptionalIsEmpty();
        // demonstratePredicateNotMethod();
        // demonstrateCollectionToArray();
        // demonstrateInputStreamMethods();
        // demonstrateOutputStreamMethods();
        // demonstrateReaderMethods();
        // demonstrateWriterMethods();
        // demonstrateNestedBasedAccessControl();
        // demonstrateDynamicClassFileConstants();
        // demonstrateEpsilonGarbageCollector();
        // demonstrateZGC();
        // demonstrateFlightRecorder();
        // demonstrateTLS1_3();
        
        // // ========== JAVA 12 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 5: JAVA 12 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateSwitchExpressions();
        // demonstrateStringNewMethods();
        // demonstrateFilesMismatch();
        // demonstrateCompactNumberFormat();
        // demonstrateTeeCollector();
        // demonstrateCompletionStageMethods();
        // demonstrateMicrobenchmarkSuite();
        // demonstrateJVMConstantsAPI();
        
        // // ========== JAVA 13 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 6: JAVA 13 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateTextBlocks();
        // demonstrateSwitchExpressionsYield();
        // demonstrateSocketAPI();
        // demonstrateZGCUncommittingMemory();
        // demonstrateReimplementLegacyAPI();
        
        // // ========== JAVA 14 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 7: JAVA 14 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstratePatternMatchingInstanceOf();
        // demonstrateRecords();
        // demonstrateTextBlocksStandard();
        // demonstrateSwitchExpressionsStandard();
        // demonstrateHelpfulNullPointerExceptions();
        // demonstratePackagingTool();
        // demonstrateNUMAawareMemory();
        // demonstrateJFRStreaming();
        
        // // ========== JAVA 15 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 8: JAVA 15 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateSealedClasses();
        // demonstratePatternMatchingTypeChecks();
        // demonstrateEdDSAAlgorithm();
        // demonstrateHiddenClasses();
        // demonstrateForeignMemoryAccess();
        // demonstrateZGCEnhancements();
        
        // // ========== JAVA 16 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 9: JAVA 16 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateRecordsStandard();
        // demonstratePatternMatchingInstanceOfStandard();
        // demonstrateStreamToList();
        // demonstrateMapMulti();
        // demonstrateDayPeriodSupport();
        // demonstrateUnixDomainSockets();
        // demonstrateForeignLinkerAPI();
        // demonstrateVectorAPI();
        
        // // ========== JAVA 17 FEATURES (LTS) ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 10: JAVA 17 FEATURES (LTS)");
        // System.out.println("#".repeat(80));
        
        // demonstrateSealedClassesFinal();
        // demonstratePatternMatchingSwitch();
        // demonstrateRandomGenerator();
        // demonstrateHexFormatting();
        // demonstrateInstantSource();
        // demonstrateVectorAPIPerformance();
        // demonstrateContextSpecificDeserialization();
        // demonstrateStronglyEncapsulateJDK();
        
        // // ========== JAVA 18 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 11: JAVA 18 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateSimpleWebServer();
        // demonstrateUTF8Charset();
        // demonstrateCodeSnippets();
        // demonstrateReentrantLockEnhancements();
        // demonstrateInternetAddressResolution();
        
        // // ========== JAVA 19 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 12: JAVA 19 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateVirtualThreads();
        // demonstrateStructuredConcurrency();
        // demonstratePatternMatchingRecordPatterns();
        // demonstrateForeignFunctionMemoryAPI();
        // demonstrateVectorAPIIncubator();
        
        // // ========== JAVA 20 FEATURES ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 13: JAVA 20 FEATURES");
        // System.out.println("#".repeat(80));
        
        // demonstrateScopedValues();
        // demonstrateRecordPatterns();
        // demonstrateSwitchPatternMatching();
        // demonstrateVirtualThreadEnhancements();
        
        // // ========== JAVA 21 FEATURES (LTS) ==========
        // System.out.println("\n" + "#".repeat(80));
        // System.out.println("PART 14: JAVA 21 FEATURES (LTS)");
        // System.out.println("#".repeat(80));
        
        // demonstrateVirtualThreadsFinal();
        // demonstrateStructuredConcurrencyFinal();
        // demonstrateScopedValuesFinal();
        // demonstrateSequencedCollections();
        // demonstratePatternMatchingSwitchFinal();
        // demonstrateRecordPatternsFinal();
        // demonstrateStringTemplates();
        // demonstrateKeyEncapsulationMechanism();
        // demonstrateVectorAPIFinal();
        // demonstrateForeignFunctionMemoryAPIFinal();
        // demonstrateUnnamedPatterns();
        // demonstrateUnnamedVariables();
        // demonstrateMainMethodEnhancement();
        // demonstrateStructuredTaskScope();
        // demonstrateMathClamp();
        // demonstrateStringNewMethods21();
        // demonstrateSequencedMap();
        // demonstrateSequencedSet();
        // demonstrateReverseOrderedCollection();
    }
    
    // =========================================================================
    // JAVA 8 FEATURES
    // =========================================================================
    
    private static void demonstrateLambdaExpressions() {
        System.out.println("\n--- Java 8: Lambda Expressions ---");
        
        // Lambda with no parameters
        Runnable r = () -> System.out.println("   Lambda with no parameters");
        r.run();
        
        // Lambda with sclearingle parameter
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("   Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Lambda with multiple parameters
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("   5 + 3 = " + add.apply(5, 3));
        
        // Lambda with block
        BiFunction<Integer, Integer, Integer> max = (x, y) -> {
            if (x > y) return x;
            return y;
        };
        System.out.println("   Max of 10 and 20: " + max.apply(10, 20));
    }
    
    private static void demonstrateStreamAPI() {
        System.out.println("\n--- Java 8: Stream API ---");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter, map, and collect
        List<Integer> evenSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("   Even squares: " + evenSquares);
        
        // Reduce
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("   Sum: " + sum);
        
        // Parallel stream
        long count = numbers.parallelStream()
            .filter(n -> n > 5)
            .count();
        System.out.println("   Numbers > 5: " + count);
        
        // Grouping
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("   Partitioned (even/odd): " + partitioned);
        
        // Statistics
        IntSummaryStatistics stats = numbers.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("   Statistics: sum=" + stats.getSum() + 
                          ", avg=" + stats.getAverage() + 
                          ", max=" + stats.getMax());
    }
    
    private static void demonstrateOptionalClass() {
        System.out.println("\n--- Java 8: Optional Class ---");
        
        // Creating Optional
        Optional<String> empty = Optional.empty();
        Optional<String> nonEmpty = Optional.of("Hello");
        Optional<String> nullable = Optional.ofNullable(null);
        
        // Using Optional
        String result = nonEmpty
            .map(String::toUpperCase)
            .orElse("DEFAULT");
        System.out.println("   Map + orElse: " + result);
        
        // orElseGet with supplier
        String value = empty.orElseGet(() -> "Generated Value");
        System.out.println("   orElseGet: " + value);
        
        // ifPresent
        nonEmpty.ifPresent(s -> System.out.println("   ifPresent: " + s));
        
        // orElseThrow
        try {
            empty.orElseThrow(() -> new RuntimeException("Value absent"));
        } catch (RuntimeException e) {
            System.out.println("   orElseThrow caught: " + e.getMessage());
        }
        
        // filter
        Optional<String> filtered = nonEmpty.filter(s -> s.length() > 3);
        System.out.println("   Filtered present: " + filtered.isPresent());
    }
    
    private static void demonstrateNewDateTimeAPI() {
        System.out.println("\n--- Java 8: New Date/Time API ---");
        
        // LocalDate, LocalTime, LocalDateTime
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        
        System.out.println("   Today: " + today);
        System.out.println("   Now: " + now);
        System.out.println("   DateTime: " + dateTime);
        
        // Creating specific dates
        LocalDate independenceDay = LocalDate.of(2024, Month.AUGUST, 15);
        System.out.println("   Independence Day: " + independenceDay);
        
        // Date manipulation
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("   Next week: " + nextWeek);
        System.out.println("   Last month: " + lastMonth);
        
        // Period and Duration
        Period period = Period.between(independenceDay, today);
        System.out.println("   Period between: " + period.getDays() + " days, " + 
                          period.getMonths() + " months");
        
        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatted = today.format(formatter);
        System.out.println("   Formatted: " + formatted);
        
        // Parsing
        LocalDate parsed = LocalDate.parse("2024-12-25");
        System.out.println("   Parsed: " + parsed);
        
        // Instant (machine time)
        Instant instant = Instant.now();
        System.out.println("   Instant: " + instant);
        
        // ZonedDateTime
        ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("   New York time: " + zoned);
    }
    
    private static void demonstrateDefaultMethods() {
        System.out.println("\n--- Java 8: Default Methods ---");
        
        interface Vehicle {
            default void start() {
                System.out.println("   Vehicle starting...");
            }
            
            default void stop() {
                System.out.println("   Vehicle stopping...");
            }
            
            void move();
        }
        
        class Car implements Vehicle {
            @Override
            public void move() {
                System.out.println("   Car moving...");
            }
            
            // Can override default methods
            @Override
            public void start() {
                System.out.println("   Car starting with key...");
            }
        }
        
        Car car = new Car();
        car.start();
        car.move();
        car.stop();
        
        // Multiple inheritance with default methods
        interface Flyable {
            default void fly() {
                System.out.println("   Flying...");
            }
        }
        
        interface Drivable {
            default void drive() {
                System.out.println("   Driving...");
            }
        }
        
        class FlyingCar implements Flyable, Drivable {
            // No conflict - both have different default methods
        }
        
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.fly();
        flyingCar.drive();
    }
    
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("\n--- Java 8: Functional Interfaces ---");
        
        // Predicate - tests a condition
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("   'Hello' is empty? " + isEmpty.test("Hello"));
        
        // Function - transforms input to output
        Function<String, Integer> lengthFunc = String::length;
        System.out.println("   Length of 'Hello': " + lengthFunc.apply("Hello"));
        
        // Consumer - accepts input, no output
        Consumer<String> printer = System.out::println;
        printer.accept("   Consumer printing: Hello");
        
        // Supplier - supplies a value
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("   Random from supplier: " + randomSupplier.get());
        
        // BiFunction - takes two inputs, produces output
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println("   5 * 3 = " + multiply.apply(5, 3));
        
        // UnaryOperator - special case of Function (same input/output type)
        UnaryOperator<String> toUpper = String::toUpperCase;
        System.out.println("   Uppercase: " + toUpper.apply("hello"));
        
        // BinaryOperator - special case of BiFunction (same input/output types)
        BinaryOperator<Integer> max = Integer::max;
        System.out.println("   Max of 10 and 20: " + max.apply(10, 20));
        
        // Combining predicates
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWithZ = s -> s.endsWith("z");
        Predicate<String> startsAAndEndsZ = startsWithA.and(endsWithZ);
        System.out.println("   'Araz' meets condition? " + startsAAndEndsZ.test("Araz"));
    }
    
    private static void demonstrateMethodReferences() {
        System.out.println("\n--- Java 8: Method References ---");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Static method reference
        names.stream()
            .map(String::toUpperCase)  // equivalent to s -> s.toUpperCase()
            .forEach(System.out::println);  // equivalent to s -> System.out.println(s)
        
        // Instance method reference of a particular object
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
            .map(Integer::toHexString)  // instance method of Integer
            .forEach(s -> System.out.print(" " + s));
        System.out.println();
        
        // Constructor reference
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> newList = listSupplier.get();
        newList.add("Created via constructor reference");
        System.out.println("   " + newList);
        
        // Array constructor reference
        Function<Integer, String[]> arrayCreator = String[]::new;
        String[] array = arrayCreator.apply(5);
        System.out.println("   Array length: " + array.length);
    }
    
    private static void demonstrateCompletableFuture() {
        System.out.println("\n--- Java 8: CompletableFuture ---");
        
        // Run async task
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("   Async task completed");
        });
        
        // Supply async value
        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            return "Hello from async";
        });
        
        // Chain operations
        supplyFuture
            .thenApply(String::toUpperCase)
            .thenApply(s -> s + "!!!")
            .thenAccept(System.out::println)
            .join();  // Wait for completion
        
        // Combine two futures
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
        
        future1.thenCombine(future2, Integer::sum)
               .thenAccept(sum -> System.out.println("   Combined sum: " + sum))
               .join();
        
        // Handle errors
        CompletableFuture<Integer> errorFuture = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Error!");
            return 42;
        }).exceptionally(ex -> {
            System.out.println("   Caught: " + ex.getMessage());
            return 0;
        });
        
        errorFuture.join();
    }
    
    private static void demonstrateNashornJavaScript() {
        System.out.println("\n--- Java 8: Nashorn JavaScript Engine ---");
        
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            
            if (engine != null) {
                // Evaluate JavaScript
                Object result = engine.eval("'Hello from JavaScript'.length()");
                System.out.println("   JS result: " + result);
                
                // Bind Java objects to JavaScript
                engine.put("javaList", Arrays.asList("A", "B", "C"));
                engine.eval("print(javaList.get(1))");
                
                // Invoke JavaScript function from Java
                engine.eval("function greet(name) { return 'Hello, ' + name; }");
                Invocable invocable = (Invocable) engine;
                Object greetResult = invocable.invokeFunction("greet", "World");
                System.out.println("   JS function result: " + greetResult);
            } else {
                System.out.println("   Nashorn not available in this Java version");
            }
        } catch (Exception e) {
            System.out.println("   Nashorn error: " + e.getMessage());
        }
    }
    
    private static void demonstrateBase64Encoding() {
        System.out.println("\n--- Java 8: Base64 Encoding ---");
        
        String original = "Hello World!";
        
        // Basic encoder/decoder
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        String decoded = new String(Base64.getDecoder().decode(encoded));
        
        System.out.println("   Original: " + original);
        System.out.println("   Encoded: " + encoded);
        System.out.println("   Decoded: " + decoded);
        
        // URL-safe encoder (uses - and _ instead of + and /)
        String urlSafe = Base64.getUrlEncoder().encodeToString(original.getBytes());
        System.out.println("   URL-safe: " + urlSafe);
        
        // MIME encoder (wraps lines)
        String mimeEncoded = Base64.getMimeEncoder().encodeToString(original.getBytes());
        System.out.println("   MIME: " + mimeEncoded);
        
        // Without padding
        String noPadding = Base64.getEncoder().withoutPadding().encodeToString(original.getBytes());
        System.out.println("   No padding: " + noPadding);
    }
    
    private static void demonstrateStringJoiner() {
        System.out.println("\n--- Java 8: StringJoiner ---");
        
        // Simple joiner with delimiter
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("Apple");
        joiner.add("Banana");
        joiner.add("Cherry");
        System.out.println("   Joined: " + joiner);
        
        // Joiner with prefix and suffix
        StringJoiner fancyJoiner = new StringJoiner(", ", "[", "]");
        fancyJoiner.add("X").add("Y").add("Z");
        System.out.println("   With prefix/suffix: " + fancyJoiner);
        
        // Merging joiners
        StringJoiner joiner1 = new StringJoiner("-", "{", "}");
        joiner1.add("A").add("B");
        
        StringJoiner joiner2 = new StringJoiner("-", "{", "}");
        joiner2.add("C").add("D");
        
        joiner1.merge(joiner2);
        System.out.println("   Merged: " + joiner1);
        
        // Using with Stream
        List<String> items = Arrays.asList("One", "Two", "Three");
        String joined = items.stream()
            .collect(Collectors.joining(", ", "<<", ">>"));
        System.out.println("   Stream joined: " + joined);
    }
    
    private static void demonstrateParallelArraySorting() {
        System.out.println("\n--- Java 8: Parallel Array Sorting ---");
        
        int[] numbers = {9, 3, 7, 1, 8, 2, 6, 4, 5};
        System.out.println("   Original: " + Arrays.toString(numbers));
        
        // Parallel sort
        Arrays.parallelSort(numbers);
        System.out.println("   Parallel sort: " + Arrays.toString(numbers));
        
        // Parallel sort with range
        int[] rangeArray = {9, 3, 7, 1, 8, 2, 6, 4, 5};
        Arrays.parallelSort(rangeArray, 2, 7);
        System.out.println("   Range sort [2-7): " + Arrays.toString(rangeArray));
        
        // Parallel prefix operations
        int[] prefixArray = {1, 2, 3, 4, 5};
        Arrays.parallelPrefix(prefixArray, (x, y) -> x * y);
        System.out.println("   Parallel prefix (product): " + Arrays.toString(prefixArray));
        
        // Parallel set all
        int[] setArray = new int[10];
        Arrays.parallelSetAll(setArray, i -> i * i);
        System.out.println("   Parallel set all (squares): " + Arrays.toString(setArray));
    }
    
    private static void demonstrateStampedLock() {
        System.out.println("\n--- Java 8: StampedLock ---");
        
        class Point {
            private double x, y;
            private final StampedLock lock = new StampedLock();
            
            void move(double deltaX, double deltaY) {
                long stamp = lock.writeLock();
                try {
                    x += deltaX;
                    y += deltaY;
                    System.out.println("   Moved to (" + x + ", " + y + ")");
                } finally {
                    lock.unlockWrite(stamp);
                }
            }
            
            double distanceFromOrigin() {
                long stamp = lock.tryOptimisticRead();
                double currentX = x;
                double currentY = y;
                
                if (!lock.validate(stamp)) {
                    stamp = lock.readLock();
                    try {
                        currentX = x;
                        currentY = y;
                    } finally {
                        lock.unlockRead(stamp);
                    }
                }
                return Math.sqrt(currentX * currentX + currentY * currentY);
            }
        }
        
        Point point = new Point();
        point.move(3, 4);
        System.out.println("   Distance from origin: " + point.distanceFromOrigin());
    }
    
    private static void demonstrateConcurrencyEnhancements() {
        System.out.println("\n--- Java 8: Concurrency Enhancements ---");
        
        // ConcurrentHashMap enhancements
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        
        // forEach
        map.forEach(2, (k, v) -> 
            System.out.println("   Key: " + k + ", Value: " + v));
        
        // search
        String result = map.search(2, (k, v) -> v > 1 ? k : null);
        System.out.println("   Search result: " + result);
        
        // reduce
        Integer sum = map.reduceValues(2, (v1, v2) -> v1 + v2);
        System.out.println("   Sum of values: " + sum);
        
        // Atomic operations
        map.computeIfAbsent("C", k -> 3);
        map.computeIfPresent("A", (k, v) -> v + 10);
        System.out.println("   After compute: " + map);
        
        // LongAdder (better performance than AtomicLong under contention)
        LongAdder adder = new LongAdder();
        adder.increment();
        adder.add(10);
        System.out.println("   LongAdder sum: " + adder.sum());
        
        // LongAccumulator
        LongAccumulator accumulator = new LongAccumulator(Long::max, 0);
        accumulator.accumulate(10);
        accumulator.accumulate(5);
        accumulator.accumulate(20);
        System.out.println("   LongAccumulator max: " + accumulator.get());
    }
    
    private static void demonstrateNIOImprovements() throws IOException {
        System.out.println("\n--- Java 8: NIO Improvements ---");
        
        // Files.find
        Path tempDir = Files.createTempDirectory("test");
        Path file1 = Files.createTempFile(tempDir, "prefix", ".txt");
        Path file2 = Files.createTempFile(tempDir, "another", ".log");
        
        try (Stream<Path> stream = Files.find(tempDir, 1, 
                (path, attrs) -> path.toString().endsWith(".txt"))) {
            System.out.println("   Found .txt files:");
            stream.forEach(p -> System.out.println("     " + p.getFileName()));
        }
        
        // Files.lines
        Files.write(file1, Arrays.asList("Line1", "Line2", "Line3"));
        try (Stream<String> lines = Files.lines(file1)) {
            System.out.println("   File contents:");
            lines.forEach(l -> System.out.println("     " + l));
        }
        
        // Directory stream
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(tempDir, "*.txt")) {
            System.out.println("   Directory stream (txt files):");
            dirStream.forEach(p -> System.out.println("     " + p.getFileName()));
        }
        
        // Clean up
        Files.delete(file1);
        Files.delete(file2);
        Files.delete(tempDir);
    }
    
    // private static void demonstrateRepeatableAnnotations() {
    //     System.out.println("\n--- Java 8: Repeatable Annotations ---");
        
    //     // Define annotations
    //     @interface Schedule {
    //         String dayOfWeek();
    //     }
        
    //     @interface Schedules {
    //         Schedule[] value();
    //     }
        
    //     @Repeatable(Schedules.class)
    //     @interface Task {
    //         String description();
    //         String day();
    //     }
        
    //     // Using repeatable annotation
    //     @Task(description = "Meeting", day = "Monday")
    //     @Task(description = "Report", day = "Friday")
    //     class WorkSchedule {
    //     }
        
    //     // Access repeatable annotations
    //     Task[] tasks = WorkSchedule.class.getAnnotationsByType(Task.class);
    //     System.out.println("   Repeatable tasks:");
    //     for (Task task : tasks) {
    //         System.out.println("     " + task.description() + " on " + task.day());
    //     }
    // }
    
    // private static void demonstrateTypeAnnotations() {
    //     System.out.println("\n--- Java 8: Type Annotations ---");
        
    //     // Type annotation example (conceptual)
    //     @interface NonNull {}
    //     @interface Readonly {}
        
    //     // Can annotate types
    //     class TypeAnnotationExample {
    //         // Constructor with type annotation
    //         // public TypeAnnotationExample() {}
            
    //         // Method with type annotated return
    //         // @Readonly List<@NonNull String> getNames() {
    //         //     return new ArrayList<>();
    //         // }
            
    //         // Generic type annotations
    //         // Map<@NonNull String, @Readonly List<@NonNull Integer>> map;
    //     }
        
    //     System.out.println("   Type annotations can be used on:");
    //     System.out.println("     - Class instance creation");
    //     System.out.println("     - Generic type parameters");
    //     System.out.println("     - Casts");
    //     System.out.println("     - Throws clauses");
    //     System.out.println("     - Type bounds");
    // }
    
    // private static void demonstrateReflectionParameters() throws Exception {
    //     System.out.println("\n--- Java 8: Reflection Parameter Names ---");
        
    //     class ParameterExample {
    //         public void process(String firstName, String lastName, int age) {
    //             // Method body
    //         }
    //     }
        
    //     // Get parameter names via reflection (requires -parameters compiler flag)
    //     Method method = ParameterExample.class.getMethod("process", 
    //         String.class, String.class, int.class);
        
    //     Parameter[] parameters = method.getParameters();
    //     System.out.println("   Method parameters:");
    //     for (Parameter param : parameters) {
    //         System.out.println("     " + param.getName() + " : " + param.getType().getSimpleName());
    //     }
        
    //     System.out.println("   Note: Parameter names are available with -parameters flag");
    // }
    
    // // =========================================================================
    // // JAVA 9 FEATURES
    // // =========================================================================
    
    // private static void demonstrateModuleSystem() {
    //     System.out.println("\n--- Java 9: Module System (Project Jigsaw) ---");
        
    //     // module-info.java example (commented as it's in separate file)
    //     System.out.println("   module-info.java example:");
    //     System.out.println("   module com.example.myapp {");
    //     System.out.println("       requires java.sql;");
    //     System.out.println("       exports com.example.myapp.api;");
    //     System.out.println("       provides com.example.MyService with com.example.MyServiceImpl;");
    //     System.out.println("       uses com.example.MyService;");
    //     System.out.println("   }");
        
    //     // Get module information at runtime
    //     Module module = String.class.getModule();
    //     System.out.println("   String class module: " + module.getName());
    //     System.out.println("   Module is named: " + module.isNamed());
    //     System.out.println("   Module descriptor: " + module.getDescriptor());
        
    //     // Layer information
    //     ModuleLayer layer = ModuleLayer.boot();
    //     System.out.println("   Boot layer modules: " + layer.modules().size());
    // }
    
    // private static void demonstratePrivateInterfaceMethods() {
    //     System.out.println("\n--- Java 9: Private Interface Methods ---");
        
    //     interface Greeting {
    //         default void greet(String name) {
    //             String message = prepareGreeting(name);
    //             System.out.println(message);
    //         }
            
    //         default void greetFormally(String name) {
    //             String message = prepareFormalGreeting(name);
    //             System.out.println(message);
    //         }
            
    //         // Private method in interface
    //         private String prepareGreeting(String name) {
    //             return "Hello, " + name + "!";
    //         }
            
    //         // Private static method
    //         private static String prepareFormalGreeting(String name) {
    //             return "Good day, " + name + ".";
    //         }
    //     }
        
    //     class EnglishGreeting implements Greeting {}
        
    //     EnglishGreeting greeting = new EnglishGreeting();
    //     greeting.greet("John");
    //     greeting.greetFormally("Jane");
    // }
    
    // private static void demonstrateTryWithResourcesEnhancement() {
    //     System.out.println("\n--- Java 9: Try-With-Resources Enhancement ---");
        
    //     // In Java 9, we can use effectively final variables
    //     class Resource implements AutoCloseable {
    //         String name;
    //         Resource(String name) { this.name = name; }
    //         public void close() { 
    //             System.out.println("   Closing resource: " + name); 
    //         }
    //         public void use() { 
    //             System.out.println("   Using resource: " + name); 
    //         }
    //     }
        
    //     Resource r1 = new Resource("Resource1");
    //     Resource r2 = new Resource("Resource2");
        
    //     // Can use variables declared outside try block
    //     try (r1; r2) {
    //         r1.use();
    //         r2.use();
    //     }
        
    //     // Multiple resources in same try
    //     Resource r3 = new Resource("Resource3");
    //     Resource r4 = new Resource("Resource4");
        
    //     try (r3; r4) {
    //         r3.use();
    //         r4.use();
    //     }
    // }
    
    // private static void demonstrateDiamondOperatorEnhancement() {
    //     System.out.println("\n--- Java 9: Diamond Operator Enhancement ---");
        
    //     // Anonymous class with diamond operator (Java 9+)
    //     List<String> list = new ArrayList<>() {
    //         {
    //             add("A");
    //             add("B");
    //         }
            
    //         public void customMethod() {
    //             System.out.println("   Custom method in anonymous class");
    //         }
    //     };
        
    //     list.customMethod();
    //     System.out.println("   List: " + list);
        
    //     // Works with nested classes too
    //     class MyClass<T> {
    //         T value;
    //         MyClass(T value) { this.value = value; }
    //     }
        
    //     MyClass<String> obj = new MyClass<>("Test") {
    //         public void display() {
    //             System.out.println("   Value: " + value);
    //         }
    //     };
    //     obj.display();
    // }
    
    // private static void demonstrateSafeVarargsEnhancement() {
    //     System.out.println("\n--- Java 9: SafeVarargs Enhancement ---");
        
    //     class SafeVarargsExample {
    //         // SafeVarargs can now be used on private methods
    //         @SafeVarargs
    //         private final <T> List<T> createList(T... items) {
    //             return Arrays.asList(items);
    //         }
            
    //         public void demonstrate() {
    //             List<String> list = createList("A", "B", "C");
    //             System.out.println("   List from safe varargs: " + list);
                
    //             // With non-reifiable types
    //             List<Integer> intList = createList(1, 2, 3);
    //             System.out.println("   Integer list: " + intList);
    //         }
    //     }
        
    //     new SafeVarargsExample().demonstrate();
    // }
    
    // private static void demonstrateStreamEnhancements() {
    //     System.out.println("\n--- Java 9: Stream Enhancements ---");
        
    //     List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
    //     // takeWhile - take elements while condition is true
    //     List<Integer> takeWhile = numbers.stream()
    //         .takeWhile(n -> n < 5)
    //         .collect(Collectors.toList());
    //     System.out.println("   takeWhile n<5: " + takeWhile);
        
    //     // dropWhile - drop elements while condition is true, then take the rest
    //     List<Integer> dropWhile = numbers.stream()
    //         .dropWhile(n -> n < 5)
    //         .collect(Collectors.toList());
    //     System.out.println("   dropWhile n<5: " + dropWhile);
        
    //     // ofNullable - creates stream of single element or empty
    //     Stream<String> stream1 = Stream.ofNullable("Hello");
    //     Stream<String> stream2 = Stream.ofNullable(null);
        
    //     System.out.println("   ofNullable non-null: " + stream1.collect(Collectors.toList()));
    //     System.out.println("   ofNullable null count: " + stream2.count());
        
    //     // iterate with predicate (Java 9)
    //     List<Integer> iterate = Stream.iterate(0, i -> i < 10, i -> i + 2)
    //         .collect(Collectors.toList());
    //     System.out.println("   iterate with predicate: " + iterate);
    // }
    
    // private static void demonstrateOptionalEnhancements() {
    //     System.out.println("\n--- Java 9: Optional Enhancements ---");
        
    //     // ifPresentOrElse
    //     Optional<String> opt1 = Optional.of("Hello");
    //     Optional<String> opt2 = Optional.empty();
        
    //     opt1.ifPresentOrElse(
    //         v -> System.out.println("   Value present: " + v),
    //         () -> System.out.println("   No value present")
    //     );
        
    //     opt2.ifPresentOrElse(
    //         v -> System.out.println("   Value present: " + v),
    //         () -> System.out.println("   No value present")
    //     );
        
    //     // or - returns Optional if present, otherwise Optional from supplier
    //     Optional<String> result1 = opt1.or(() -> Optional.of("Default"));
    //     Optional<String> result2 = opt2.or(() -> Optional.of("Default"));
        
    //     System.out.println("   or with present: " + result1.get());
    //     System.out.println("   or with empty: " + result2.get());
        
    //     // stream() - converts Optional to Stream
    //     Stream<String> stream1 = opt1.stream();
    //     Stream<String> stream2 = opt2.stream();
        
    //     System.out.println("   stream from present count: " + stream1.count());
    //     System.out.println("   stream from empty count: " + stream2.count());
    // }
    
    // private static void demonstrateCollectionFactoryMethods() {
    //     System.out.println("\n--- Java 9: Collection Factory Methods ---");
        
    //     // List factory methods (immutable)
    //     List<String> list1 = List.of();
    //     List<String> list2 = List.of("A");
    //     List<String> list3 = List.of("A", "B", "C");
    //     List<String> list4 = List.of("A", "B", "C", "D", "E");
        
    //     System.out.println("   List.of(): " + list1);
    //     System.out.println("   List.of('A'): " + list2);
    //     System.out.println("   List.of('A','B','C'): " + list3);
        
    //     // Set factory methods (immutable)
    //     Set<String> set1 = Set.of();
    //     Set<String> set2 = Set.of("X");
    //     Set<String> set3 = Set.of("X", "Y", "Z");
        
    //     System.out.println("   Set.of(): " + set1);
    //     System.out.println("   Set.of('X'): " + set2);
    //     System.out.println("   Set.of('X','Y','Z'): " + set3);
        
    //     // Map factory methods (immutable)
    //     Map<String, Integer> map1 = Map.of();
    //     Map<String, Integer> map2 = Map.of("key1", 1);
    //     Map<String, Integer> map3 = Map.of("key1", 1, "key2", 2, "key3", 3);
        
    //     System.out.println("   Map.of(): " + map1);
    //     System.out.println("   Map.of('key1',1): " + map2);
    //     System.out.println("   Map.of('key1',1,'key2',2,'key3',3): " + map3);
        
    //     // Map.ofEntries for larger maps
    //     Map<String, Integer> map4 = Map.ofEntries(
    //         Map.entry("A", 1),
    //         Map.entry("B", 2),
    //         Map.entry("C", 3),
    //         Map.entry("D", 4)
    //     );
    //     System.out.println("   Map.ofEntries: " + map4);
        
    //     // Demonstrate immutability
    //     try {
    //         list3.add("D");
    //     } catch (UnsupportedOperationException e) {
    //         System.out.println("   ✓ Factory collections are immutable");
    //     }
    // }
    
    // private static void demonstrateCompletableFutureEnhancements() {
    //     System.out.println("\n--- Java 9: CompletableFuture Enhancements ---");
        
    //     // copy() - creates new CompletableFuture
    //     CompletableFuture<String> original = CompletableFuture.completedFuture("Hello");
    //     CompletableFuture<String> copy = original.copy();
    //     System.out.println("   Copy completed: " + copy.isDone());
        
    //     // completedStage and failedStage
    //     CompletionStage<String> stage = CompletableFuture.completedStage("Stage Value");
    //     CompletionStage<String> failedStage = CompletableFuture.failedStage(new RuntimeException("Failed"));
        
    //     stage.thenAccept(v -> System.out.println("   Completed stage: " + v));
        
    //     // delayedExecutor
    //     Executor delayed = CompletableFuture.delayedExecutor(100, TimeUnit.MILLISECONDS);
    //     CompletableFuture.runAsync(() -> 
    //         System.out.println("   Delayed execution after 100ms"), delayed)
    //         .join();
        
    //     // orTimeout
    //     CompletableFuture<String> timeoutFuture = CompletableFuture.supplyAsync(() -> {
    //         try { Thread.sleep(500); } catch (InterruptedException e) {}
    //         return "Result";
    //     }).orTimeout(100, TimeUnit.MILLISECONDS)
    //       .exceptionally(ex -> {
    //           System.out.println("   Timeout occurred: " + ex.getClass().getSimpleName());
    //           return "Timeout";
    //       });
        
    //     timeoutFuture.join();
    // }
    
    // private static void demonstrateProcessAPI() throws IOException {
    //     System.out.println("\n--- Java 9: Process API ---");
        
    //     // Get current process info
    //     ProcessHandle current = ProcessHandle.current();
    //     System.out.println("   Current PID: " + current.pid());
        
    //     // Process info
    //     ProcessHandle.Info info = current.info();
    //     System.out.println("   Command: " + info.command().orElse("Unknown"));
    //     System.out.println("   Arguments: " + Arrays.toString(info.arguments().orElse(new String[]{})));
    //     System.out.println("   Start time: " + info.startInstant().orElse(null));
    //     System.out.println("   Total CPU time: " + info.totalCpuDuration().orElse(null));
        
    //     // List all processes
    //     System.out.println("   All processes count: " + ProcessHandle.allProcesses().count());
        
    //     // Start a new process (platform dependent)
    //     try {
    //         ProcessBuilder pb = new ProcessBuilder("java", "-version");
    //         Process process = pb.start();
            
    //         // Get process info
    //         ProcessHandle processHandle = process.toHandle();
    //         System.out.println("   Started process PID: " + processHandle.pid());
            
    //         // onExit() - CompletableFuture
    //         processHandle.onExit().thenAccept(p -> 
    //             System.out.println("   Process exited with: " + p.exitValue()));
            
    //         // Wait a bit and destroy
    //         Thread.sleep(100);
    //         process.destroy();
    //     } catch (Exception e) {
    //         System.out.println("   Process start error: " + e.getMessage());
    //     }
    // }
    
    // private static void demonstrateStackWalkingAPI() {
    //     System.out.println("\n--- Java 9: Stack Walking API ---");
        
    //     class StackWalkerExample {
    //         void method1() { method2(); }
    //         void method2() { method3(); }
    //         void method3() {
    //             // Walk the stack
    //             StackWalker walker = StackWalker.getInstance();
                
    //             // Get all stack frames
    //             System.out.println("   Full stack trace:");
    //             walker.forEach(frame -> {
    //                 System.out.println("     " + frame.getClassName() + "." + 
    //                                   frame.getMethodName() + ":" + frame.getLineNumber());
    //             });
                
    //             // Get limited number of frames
    //             System.out.println("\n   First 2 frames:");
    //             walker.walk(s -> s.limit(2).collect(Collectors.toList()))
    //                   .forEach(frame -> System.out.println("     " + frame.getMethodName()));
                
    //             // Find caller class
    //             Class<?> caller = walker.getCallerClass();
    //             System.out.println("\n   Caller class: " + caller.getSimpleName());
    //         }
    //     }
        
    //     new StackWalkerExample().method1();
    // }
    
    // private static void demonstrateVariableHandles() throws Exception {
    //     System.out.println("\n--- Java 9: Variable Handles ---");
        
    //     class Point {
    //         volatile int x;
    //         volatile int y;
    //     }
        
    //     // Get VarHandle instance
    //     VarHandle X_HANDLE;
    //     VarHandle Y_HANDLE;
        
    //     try {
    //         X_HANDLE = MethodHandles.lookup()
    //             .findVarHandle(Point.class, "x", int.class);
    //         Y_HANDLE = MethodHandles.lookup()
    //             .findVarHandle(Point.class, "y", int.class);
            
    //         Point point = new Point();
            
    //         // Set values
    //         X_HANDLE.set(point, 10);
    //         Y_HANDLE.set(point, 20);
    //         System.out.println("   Initial values: x=" + point.x + ", y=" + point.y);
            
    //         // Compare and set
    //         boolean success = X_HANDLE.compareAndSet(point, 10, 15);
    //         System.out.println("   CAS success: " + success + ", x=" + point.x);
            
    //         // Get and add
    //         int oldY = (int) Y_HANDLE.getAndAdd(point, 5);
    //         System.out.println("   GetAndAdd: oldY=" + oldY + ", newY=" + point.y);
            
    //         // Get and set
    //         int oldX = (int) X_HANDLE.getAndSet(point, 30);
    //         System.out.println("   GetAndSet: oldX=" + oldX + ", newX=" + point.x);
            
    //     } catch (Exception e) {
    //         System.out.println("   Error: " + e.getMessage());
    //     }
    // }
    
    // private static void demonstrateSpinWaitHints() {
    //     System.out.println("\n--- Java 9: Spin Wait Hints ---");
        
    //     // Simulate spin-wait scenario
    //     AtomicBoolean flag = new AtomicBoolean(false);
        
    //     // Thread that sets the flag
    //     new Thread(() -> {
    //         try { Thread.sleep(100); } catch (InterruptedException e) {}
    //         flag.set(true);
    //         System.out.println("   Flag set to true");
    //     }).start();
        
    //     // Thread that spins waiting for flag
    //     long start = System.nanoTime();
    //     while (!flag.get()) {
    //         // Hint that this is a spin loop (Java 9+)
    //         Thread.onSpinWait();
    //     }
    //     long duration = System.nanoTime() - start;
        
    //     System.out.println("   Spin wait ended after " + duration/1_000_000 + "ms");
    // }
    
    // private static void demonstrateReactiveStreams() {
    //     System.out.println("\n--- Java 9: Reactive Streams (Flow API) ---");
        
    //     // Simple publisher
    //     class SimplePublisher extends SubmissionPublisher<String> {
    //         public void publishItems() {
    //             for (int i = 0; i < 5; i++) {
    //                 submit("Item " + i);
    //             }
    //             close();
    //         }
    //     }
        
    //     // Simple subscriber
    //     class SimpleSubscriber implements Flow.Subscriber<String> {
    //         private Flow.Subscription subscription;
    //         private String name;
            
    //         SimpleSubscriber(String name) { this.name = name; }
            
    //         @Override
    //         public void onSubscribe(Flow.Subscription subscription) {
    //             this.subscription = subscription;
    //             System.out.println("   " + name + " subscribed");
    //             subscription.request(1);
    //         }
            
    //         @Override
    //         public void onNext(String item) {
    //             System.out.println("   " + name + " received: " + item);
    //             subscription.request(1);
    //         }
            
    //         @Override
    //         public void onError(Throwable throwable) {
    //             System.out.println("   " + name + " error: " + throwable);
    //         }
            
    //         @Override
    //         public void onComplete() {
    //             System.out.println("   " + name + " completed");
    //         }
    //     }
        
    //     // Create publisher and subscribers
    //     SimplePublisher publisher = new SimplePublisher();
        
    //     publisher.subscribe(new SimpleSubscriber("Subscriber1"));
    //     publisher.subscribe(new SimpleSubscriber("Subscriber2"));
        
    //     // Publish items
    //     publisher.publishItems();
        
    //     // Wait for completion
    //     try { Thread.sleep(1000); } catch (InterruptedException e) {}
    // }
    
    // private static void demonstrateHTTP2Client() throws Exception {
    //     System.out.println("\n--- Java 9: HTTP/2 Client (Incubator) ---");
        
    //     // Java 9 had incubator HTTP client, Java 11 standardized it
    //     System.out.println("   HTTP Client introduced in Java 9 as incubator");
    //     System.out.println("   Became standard in Java 11");
        
    //     // Example of what would be in Java 11+
    //     try {
    //         HttpClient client = HttpClient.newHttpClient();
    //         HttpRequest request = HttpRequest.newBuilder()
    //             .uri(new URI("https://httpbin.org/get"))
    //             .GET()
    //             .build();
            
    //         // This would work in Java 11+
    //         // HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    //         // System.out.println("   Response status: " + response.statusCode());
    //     } catch (Exception e) {
    //         System.out.println("   HTTP Client requires Java 11+");
    //     }
    // }
    
    // private static void demonstrateMultiResolutionImage() {
    //     System.out.println("\n--- Java 9: Multi-Resolution Image API ---");
        
    //     // Create multi-resolution image
    //     class MultiResolutionImageExample {
    //         // Simplified example
    //         public void demonstrate() {
    //             System.out.println("   MultiResolutionImage allows loading");
    //             System.out.println("   different resolutions based on DPI");
    //             System.out.println("   Useful for HiDPI displays");
    //         }
    //     }
        
    //     new MultiResolutionImageExample().demonstrate();
    // }
    
    // // =========================================================================
    // // JAVA 10 FEATURES
    // // =========================================================================
    
    // private static void demonstrateLocalVariableTypeInference() {
    //     System.out.println("\n--- Java 10: Local Variable Type Inference (var) ---");
        
    //     // var with different types
    //     var list = new ArrayList<String>();
    //     list.add("Hello");
        
    //     var map = new HashMap<String, List<Integer>>();
    //     map.put("key", List.of(1, 2, 3));
        
    //     var number = 42;
    //     var text = "Hello";
    //     var flag = true;
        
    //     System.out.println("   list type: " + list.getClass().getSimpleName());
    //     System.out.println("   map type: " + map.getClass().getSimpleName());
    //     System.out.println("   number type: " + ((Object)number).getClass().getSimpleName());
        
    //     // var with loops
    //     var numbers = Arrays.asList(1, 2, 3, 4, 5);
    //     for (var n : numbers) {
    //         System.out.print(" " + n);
    //     }
    //     System.out.println();
        
    //     // var with try-with-resources
    //     try (var scanner = new java.util.Scanner("Hello World")) {
    //         var token = scanner.next();
    //         System.out.println("   Scanner token: " + token);
    //     }
        
    //     // Cannot use var without initialization
    //     // var uninitialized; // Error
        
    //     // Cannot use var with null
    //     // var nullVar = null; // Error
    // }
    
    // private static void demonstrateUnmodifiableCollections() {
    //     System.out.println("\n--- Java 10: Unmodifiable Collections ---");
        
    //     var list = new ArrayList<>(Arrays.asList("A", "B", "C"));
    //     var copyList = List.copyOf(list);
        
    //     var set = new HashSet<>(Arrays.asList("X", "Y", "Z"));
    //     var copySet = Set.copyOf(set);
        
    //     var map = new HashMap<String, Integer>();
    //     map.put("One", 1);
    //     map.put("Two", 2);
    //     var copyMap = Map.copyOf(map);
        
    //     System.out.println("   Original list: " + list);
    //     System.out.println("   Unmodifiable copy: " + copyList);
        
    //     // Also Collectors.toUnmodifiableList/Set/Map
    //     var unmodifiableList = list.stream()
    //         .collect(Collectors.toUnmodifiableList());
        
    //     var unmodifiableSet = set.stream()
    //         .collect(Collectors.toUnmodifiableSet());
        
    //     System.out.println("   Stream to unmodifiable: " + unmodifiableList);
        
    //     // Check immutability
    //     try {
    //         copyList.add("D");
    //     } catch (UnsupportedOperationException e) {
    //         System.out.println("   ✓ Copy is immutable");
    //     }
    // }
    
    // private static void demonstrateOptionalOrElseThrow() {
    //     System.out.println("\n--- Java 10: Optional.orElseThrow() ---");
        
    //     Optional<String> present = Optional.of("Value");
    //     Optional<String> empty = Optional.empty();
        
    //     // orElseThrow() without arguments (preferred over get())
    //     var value = present.orElseThrow();
    //     System.out.println("   orElseThrow on present: " + value);
        
    //     try {
    //         var error = empty.orElseThrow();
    //     } catch (NoSuchElementException e) {
    //         System.out.println("   ✓ orElseThrow on empty throws: " + e.getClass().getSimpleName());
    //     }
        
    //     // Compare with get() - orElseThrow() is more descriptive
    //     var oldWay = present.get();
    //     System.out.println("   old get(): " + oldWay);
    // }
    
    // private static void demonstratePerformanceImprovements() {
    //     System.out.println("\n--- Java 10: Performance Improvements ---");
        
    //     System.out.println("   - Parallel Full GC for G1");
    //     System.out.println("   - Improved Container Awareness");
    //     System.out.println("   - Heap Allocation on Alternative Memory Devices");
    //     System.out.println("   - Experimental Java-Based JIT Compiler (Graal)");
    //     System.out.println("   - Consolidation of JDK Forest into Single Repository");
    // }
    
    // private static void demonstrateContainerAwareness() {
    //     System.out.println("\n--- Java 10: Container Awareness ---");
        
    //     // JVM now aware of container limits
    //     System.out.println("   JVM detects container constraints:");
        
    //     // Get runtime info
    //     Runtime runtime = Runtime.getRuntime();
    //     System.out.println("   Available processors: " + runtime.availableProcessors());
    //     System.out.println("   Max memory: " + runtime.maxMemory() / (1024 * 1024) + " MB");
        
    //     // These respect container limits in Java 10+
    //     System.out.println("   JVM respects CPU and memory limits set by containers");
    // }
    
    // private static void demonstrateRootCertificates() {
    //     System.out.println("\n--- Java 10: Root Certificates ---");
        
    //     System.out.println("   - Provided default set of root Certification Authority (CA) certificates");
    //     System.out.println("   - Enabled TLS by default");
    //     System.out.println("   - Improved security out-of-the-box");
    // }
    
    // private static void demonstrateThreadLocalHandshakes() {
    //     System.out.println("\n--- Java 10: Thread-Local Handshakes ---");
        
    //     System.out.println("   - Ability to execute a callback on threads without global VM safepoint");
    //     System.out.println("   - Improves performance for certain operations");
    //     System.out.println("   - Used for biased locking revocation and stack trace sampling");
    // }
    
    // private static void demonstrateHeapAllocation() {
    //     System.out.println("\n--- Java 10: Heap Allocation on Alternative Memory ---");
        
    //     System.out.println("   - Ability to allocate heap on alternative memory devices");
    //     System.out.println("   - Use -XX:AllocateHeapAt=<path> option");
    //     System.out.println("   - Can use NV-DIMM memory for heap");
    // }
    
    // private static void demonstrateGarbageCollectorInterfaces() {
    //     System.out.println("\n--- Java 10: Garbage Collector Interfaces ---");
        
    //     System.out.println("   - Cleaner interfaces for garbage collection");
    //     System.out.println("   - Better isolation of GC code");
    //     System.out.println("   - Easier to add new garbage collectors");
    // }
    
    // // =========================================================================
    // // JAVA 11 FEATURES (LTS)
    // // =========================================================================
    
    // private static void demonstrateLocalVariableSyntaxForLambda() {
    //     System.out.println("\n--- Java 11: Local Variable Syntax for Lambda ---");
        
    //     List<String> list = Arrays.asList("a", "b", "c");
        
    //     // Use var in lambda parameters
    //     list.stream()
    //         .map((@NotNull var s) -> s.toUpperCase())
    //         .forEach(System.out::println);
        
    //     // Benefits: can add annotations
    //     BiFunction<String, String, String> func = 
    //         (@Nullable var x, @NotNull var y) -> x + y;
        
    //     System.out.println("   Allows annotations on lambda parameters");
    // }
    
    // @interface NotNull {}
    // @interface Nullable {}
    
    // private static void demonstrateHttpClientAPI() throws Exception {
    //     System.out.println("\n--- Java 11: HTTP Client API (Standard) ---");
        
    //     // Create HTTP client
    //     HttpClient client = HttpClient.newBuilder()
    //         .version(HttpClient.Version.HTTP_2)
    //         .followRedirects(HttpClient.Redirect.NORMAL)
    //         .connectTimeout(Duration.ofSeconds(10))
    //         .build();
        
    //     // Build request
    //     HttpRequest request = HttpRequest.newBuilder()
    //         .uri(URI.create("https://httpbin.org/get"))
    //         .timeout(Duration.ofSeconds(30))
    //         .header("Content-Type", "application/json")
    //         .GET()
    //         .build();
        
    //     // Send synchronously
    //     try {
    //         HttpResponse<String> response = client.send(request, 
    //             HttpResponse.BodyHandlers.ofString());
            
    //         System.out.println("   Response status: " + response.statusCode());
    //         System.out.println("   Response headers: " + response.headers().map());
    //         System.out.println("   Response body length: " + response.body().length());
    //     } catch (Exception e) {
    //         System.out.println("   HTTP request failed: " + e.getMessage());
    //     }
        
    //     // Async request
    //     CompletableFuture<HttpResponse<String>> futureResponse = 
    //         client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        
    //     futureResponse.thenAccept(response -> 
    //         System.out.println("   Async response status: " + response.statusCode()))
    //         .join();
    // }
    
    // private static void demonstrateStringMethods() {
    //     System.out.println("\n--- Java 11: New String Methods ---");
        
    //     String str = "  Hello World  ";
    //     String empty = "";
    //     String blank = "   ";
        
    //     // isBlank()
    //     System.out.println("   isBlank() on '   ': " + blank.isBlank());
    //     System.out.println("   isBlank() on 'Hello': " + str.isBlank());
        
    //     // lines()
    //     String multiline = "Line1\nLine2\nLine3";
    //     System.out.println("   lines() count: " + multiline.lines().count());
    //     multiline.lines().forEach(l -> System.out.println("     " + l));
        
    //     // strip(), stripLeading(), stripTrailing()
    //     System.out.println("   strip(): '" + str.strip() + "'");
    //     System.out.println("   stripLeading(): '" + str.stripLeading() + "'");
    //     System.out.println("   stripTrailing(): '" + str.stripTrailing() + "'");
        
    //     // repeat()
    //     String repeat = "Ha";
    //     System.out.println("   repeat(3): '" + repeat.repeat(3) + "'");
        
    //     // indent()
    //     String indented = "Hello\nWorld".indent(4);
    //     System.out.println("   indent(4):\n" + indented);
    // }
    
    // private static void demonstrateFilesMethods() throws IOException {
    //     System.out.println("\n--- Java 11: New Files Methods ---");
        
    //     Path tempFile = Files.createTempFile("test", ".txt");
        
    //     // writeString()
    //     Files.writeString(tempFile, "Hello World from Java 11");
    //     System.out.println("   Wrote string to file");
        
    //     // readString()
    //     String content = Files.readString(tempFile);
    //     System.out.println("   Read string: " + content);
        
    //     // isSameFile
    //     Path tempFile2 = Files.createTempFile("test2", ".txt");
    //     System.out.println("   Is same file: " + Files.isSameFile(tempFile, tempFile2));
        
    //     // mismatch()
    //     Files.writeString(tempFile2, "Different content");
    //     long mismatch = Files.mismatch(tempFile, tempFile2);
    //     System.out.println("   Mismatch position: " + mismatch);
        
    //     // Clean up
    //     Files.delete(tempFile);
    //     Files.delete(tempFile2);
    // }
    
    // private static void demonstrateOptionalIsEmpty() {
    //     System.out.println("\n--- Java 11: Optional.isEmpty() ---");
        
    //     Optional<String> present = Optional.of("Hello");
    //     Optional<String> empty = Optional.empty();
        
    //     // isEmpty() - opposite of isPresent()
    //     System.out.println("   present.isEmpty(): " + present.isEmpty());
    //     System.out.println("   empty.isEmpty(): " + empty.isEmpty());
        
    //     // Useful for more readable conditions
    //     if (!present.isEmpty()) {
    //         System.out.println("   Optional is not empty");
    //     }
    // }
    
    // private static void demonstratePredicateNotMethod() {
    //     System.out.println("\n--- Java 11: Predicate.not() ---");
        
    //     List<String> list = Arrays.asList("Apple", "", "Banana", "", "Cherry", "");
        
    //     // Filter out empty strings using ! (old way)
    //     List<String> oldWay = list.stream()
    //         .filter(s -> !s.isEmpty())
    //         .collect(Collectors.toList());
        
    //     // Using Predicate.not() (new way)
    //     List<String> newWay = list.stream()
    //         .filter(Predicate.not(String::isEmpty))
    //         .collect(Collectors.toList());
        
    //     System.out.println("   Original: " + list);
    //     System.out.println("   Old way: " + oldWay);
    //     System.out.println("   Predicate.not(): " + newWay);
    // }
    
    // private static void demonstrateCollectionToArray() {
    //     System.out.println("\n--- Java 11: Collection.toArray() Improvements ---");
        
    //     List<String> list = Arrays.asList("A", "B", "C", "D");
        
    //     // toArray() with generator function
    //     String[] array1 = list.toArray(String[]::new);
    //     System.out.println("   toArray(String[]::new): " + Arrays.toString(array1));
        
    //     // Old way
    //     String[] array2 = list.toArray(new String[0]);
    //     System.out.println("   Old way: " + Arrays.toString(array2));
        
    //     // With different sizes
    //     String[] array3 = list.toArray(size -> new String[size + 5]);
    //     System.out.println("   Custom size array length: " + array3.length);
    // }
    
    // private static void demonstrateInputStreamMethods() throws IOException {
    //     System.out.println("\n--- Java 11: InputStream Methods ---");
        
    //     byte[] data = "Hello World".getBytes();
        
    //     // readAllBytes()
    //     try (InputStream is = new ByteArrayInputStream(data)) {
    //         byte[] allBytes = is.readAllBytes();
    //         System.out.println("   readAllBytes(): " + new String(allBytes));
    //     }
        
    //     // readNBytes()
    //     try (InputStream is = new ByteArrayInputStream(data)) {
    //         byte[] buffer = new byte[5];
    //         int bytesRead = is.readNBytes(buffer, 0, buffer.length);
    //         System.out.println("   readNBytes(5): " + new String(buffer) + 
    //                           " (read " + bytesRead + " bytes)");
    //     }
        
    //     // transferTo()
    //     try (InputStream is = new ByteArrayInputStream(data);
    //          ByteArrayOutputStream os = new ByteArrayOutputStream()) {
    //         long transferred = is.transferTo(os);
    //         System.out.println("   transferTo(): " + os.toString() + 
    //                           " (transferred " + transferred + " bytes)");
    //     }
    // }
    
    // private static void demonstrateOutputStreamMethods() throws IOException {
    //     System.out.println("\n--- Java 11: OutputStream Methods ---");
        
    //     // nullOutputStream() - discards all data
    //     try (OutputStream os = OutputStream.nullOutputStream()) {
    //         os.write("This data is discarded".getBytes());
    //         System.out.println("   nullOutputStream() discards data");
    //     }
    // }
    
    // private static void demonstrateReaderMethods() throws IOException {
    //     System.out.println("\n--- Java 11: Reader Methods ---");
        
    //     String text = "Hello World from Java 11";
        
    //     // nullReader()
    //     try (Reader reader = Reader.nullReader()) {
    //         System.out.println("   nullReader() returns no data");
    //     }
        
    //     // transferTo()
    //     try (Reader reader = new StringReader(text);
    //          Writer writer = new StringWriter()) {
    //         long transferred = reader.transferTo(writer);
    //         System.out.println("   transferTo(): " + writer.toString() + 
    //                           " (transferred " + transferred + " chars)");
    //     }
    // }
    
    // private static void demonstrateWriterMethods() throws IOException {
    //     System.out.println("\n--- Java 11: Writer Methods ---");
        
    //     // nullWriter()
    //     try (Writer writer = Writer.nullWriter()) {
    //         writer.write("This is discarded");
    //         System.out.println("   nullWriter() discards data");
    //     }
    // }
    
    // private static void demonstrateNestedBasedAccessControl() {
    //     System.out.println("\n--- Java 11: Nested-Based Access Control ---");
        
    //     class Outer {
    //         private int outerVar = 42;
            
    //         class Inner {
    //             void accessOuter() {
    //                 // Can access private members of outer class
    //                 System.out.println("   Inner accessing outerVar: " + outerVar);
    //             }
    //         }
            
    //         void accessInner() {
    //             Inner inner = new Inner();
    //             inner.accessOuter();
    //         }
            
    //         // Get nest information
    //         void showNestInfo() {
    //             Class<?> outerClass = this.getClass();
    //             System.out.println("   Outer class: " + outerClass.getSimpleName());
    //             System.out.println("   Nest host: " + outerClass.getNestHost().getSimpleName());
                
    //             Class<?>[] members = outerClass.getNestMembers();
    //             System.out.println("   Nest members: " + Arrays.toString(members));
    //         }
    //     }
        
    //     Outer outer = new Outer();
    //     outer.accessInner();
    //     outer.showNestInfo();
    // }
    
    // private static void demonstrateDynamicClassFileConstants() throws Exception {
    //     System.out.println("\n--- Java 11: Dynamic Class-File Constants ---");
        
    //     System.out.println("   Allows constant pool entries that are dynamically computed");
    //     System.out.println("   Benefits:");
    //     System.out.println("     - More efficient use of constant pool");
    //     System.out.println("     - Better performance for certain operations");
    //     System.out.println("     - Used for invokedynamic and other features");
    // }
    
    // private static void demonstrateEpsilonGarbageCollector() {
    //     System.out.println("\n--- Java 11: Epsilon Garbage Collector ---");
        
    //     System.out.println("   - No-op garbage collector");
    //     System.out.println("   - Handles allocation but does not collect garbage");
    //     System.out.println("   - Used for performance testing and short-lived jobs");
    //     System.out.println("   - Use -XX:+UseEpsilonGC flag");
    // }
    
    // private static void demonstrateZGC() {
    //     System.out.println("\n--- Java 11: Z Garbage Collector (Experimental) ---");
        
    //     System.out.println("   - Scalable low-latency garbage collector");
    //     System.out.println("   - Pause times never exceed 10ms");
    //     System.out.println("   - Handles heaps from 8MB to 16TB");
    //     System.out.println("   - Use -XX:+UseZGC flag");
    //     System.out.println("   - Became production-ready in Java 15");
    // }
    
    // private static void demonstrateFlightRecorder() {
    //     System.out.println("\n--- Java 11: Flight Recorder ---");
        
    //     System.out.println("   - Low-overhead data collection for Java applications");
    //     System.out.println("   - Now open-source in OpenJDK");
    //     System.out.println("   - Can be enabled at runtime");
    //     System.out.println("   - Use -XX:StartFlightRecording option");
    // }
    
    // private static void demonstrateTLS1_3() {
    //     System.out.println("\n--- Java 11: TLS 1.3 ---");
        
    //     System.out.println("   - Enabled by default");
    //     System.out.println("   - Improved security and performance");
    //     System.out.println("   - Reduced round trips for handshake");
    //     System.out.println("   - Removed obsolete cryptographic algorithms");
    // }
    
    // // =========================================================================
    // // JAVA 12 FEATURES
    // // =========================================================================
    
    // private static void demonstrateSwitchExpressions() {
    //     System.out.println("\n--- Java 12: Switch Expressions (Preview) ---");
        
    //     // Traditional switch
    //     String day = "MONDAY";
    //     int numLetters = 0;
        
    //     switch (day) {
    //         case "MONDAY":
    //         case "FRIDAY":
    //         case "SUNDAY":
    //             numLetters = 6;
    //             break;
    //         case "TUESDAY":
    //             numLetters = 7;
    //             break;
    //         default:
    //             numLetters = -1;
    //     }
    //     System.out.println("   Traditional: " + numLetters);
        
    //     // Switch expression (Java 12 preview)
    //     numLetters = switch (day) {
    //         case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
    //         case "TUESDAY" -> 7;
    //         default -> -1;
    //     };
    //     System.out.println("   Switch expression: " + numLetters);
    // }
    
    // private static void demonstrateStringNewMethods() {
    //     System.out.println("\n--- Java 12: New String Methods ---");
        
    //     // indent() - already covered in Java 11
    //     String str = "Hello\nWorld";
    //     System.out.println("   indent(4):\n" + str.indent(4));
        
    //     // transform()
    //     String result = "hello".transform(s -> s + " world")
    //                           .transform(String::toUpperCase);
    //     System.out.println("   transform(): " + result);
        
    //     // transform can change type
    //     Integer length = "hello".transform(s -> s.length());
    //     System.out.println("   transform to Integer: " + length);
        
    //     // describeConstable() and resolveConstantDesc
    //     String constant = "Hello";
    //     var constable = constant.describeConstable();
    //     System.out.println("   describeConstable(): " + constable);
    // }
    
    // private static void demonstrateFilesMismatch() throws IOException {
    //     System.out.println("\n--- Java 12: Files.mismatch() ---");
        
    //     Path file1 = Files.createTempFile("file1", ".txt");
    //     Path file2 = Files.createTempFile("file2", ".txt");
        
    //     Files.writeString(file1, "Hello World");
    //     Files.writeString(file2, "Hello World");
        
    //     // No mismatch
    //     long mismatch1 = Files.mismatch(file1, file2);
    //     System.out.println("   Identical files mismatch: " + mismatch1);
        
    //     Files.writeString(file2, "Hello Java");
    //     long mismatch2 = Files.mismatch(file1, file2);
    //     System.out.println("   Different files mismatch at: " + mismatch2);
        
    //     // Clean up
    //     Files.delete(file1);
    //     Files.delete(file2);
    // }
    
    // private static void demonstrateCompactNumberFormat() {
    //     System.out.println("\n--- Java 12: Compact Number Formatting ---");
        
    //     // SHORT style
    //     NumberFormat shortFormat = NumberFormat.getCompactNumberInstance(
    //         Locale.US, NumberFormat.Style.SHORT);
    //     System.out.println("   Short: " + shortFormat.format(1000));
    //     System.out.println("   Short: " + shortFormat.format(1000000));
    //     System.out.println("   Short: " + shortFormat.format(1000000000));
        
    //     // LONG style
    //     NumberFormat longFormat = NumberFormat.getCompactNumberInstance(
    //         Locale.US, NumberFormat.Style.LONG);
    //     System.out.println("   Long: " + longFormat.format(1000));
    //     System.out.println("   Long: " + longFormat.format(1000000));
    //     System.out.println("   Long: " + longFormat.format(1000000000));
    // }
    
    // private static void demonstrateTeeCollector() {
    //     System.out.println("\n--- Java 12: Collectors.teeing() ---");
        
    //     List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
    //     // Collect both sum and count in one pass
    //     Result result = numbers.stream()
    //         .collect(Collectors.teeing(
    //             Collectors.summingInt(i -> i),
    //             Collectors.counting(),
    //             (sum, count) -> new Result(sum, count)
    //         ));
        
    //     System.out.println("   Sum: " + result.sum);
    //     System.out.println("   Count: " + result.count);
    //     System.out.println("   Average: " + result.sum / result.count);
        
    //     // Another example - min and max
    //     MinMax minMax = numbers.stream()
    //         .collect(Collectors.teeing(
    //             Collectors.minBy(Integer::compareTo),
    //             Collectors.maxBy(Integer::compareTo),
    //             (min, max) -> new MinMax(min.orElse(0), max.orElse(0))
    //         ));
        
    //     System.out.println("   Min: " + minMax.min);
    //     System.out.println("   Max: " + minMax.max);
    // }
    
    // static class Result {
    //     int sum; long count;
    //     Result(int sum, long count) { this.sum = sum; this.count = count; }
    // }
    
    // static class MinMax {
    //     int min, max;
    //     MinMax(int min, int max) { this.min = min; this.max = max; }
    // }
    
    // private static void demonstrateCompletionStageMethods() {
    //     System.out.println("\n--- Java 12: CompletionStage Methods ---");
        
    //     CompletableFuture<String> future = CompletableFuture.completedFuture("Hello");
        
    //     // exceptionallyAsync
    //     CompletableFuture<String> withExceptionHandling = future
    //         .thenApply(s -> { throw new RuntimeException("Error"); })
    //         .exceptionallyAsync(ex -> {
    //             System.out.println("   Async exception handling");
    //             return "Recovered";
    //         });
        
    //     System.out.println("   Result: " + withExceptionHandling.join());
        
    //     // exceptionallyCompose
    //     CompletableFuture<String> composed = CompletableFuture
    //         .failedFuture(new RuntimeException("Failed"))
    //         .exceptionallyCompose(ex -> CompletableFuture.completedFuture("Composed recovery"));
        
    //     System.out.println("   exceptionallyCompose: " + composed.join());
    // }
    
    // private static void demonstrateMicrobenchmarkSuite() {
    //     System.out.println("\n--- Java 12: Microbenchmark Suite ---");
        
    //     System.out.println("   - Added microbenchmarks to JDK source code");
    //     System.out.println("   - Based on Java Microbenchmark Harness (JMH)");
    //     System.out.println("   - Helps measure performance of JDK components");
    //     System.out.println("   - Located in test/micro directory");
    // }
    
    // private static void demonstrateJVMConstantsAPI() {
    //     System.out.println("\n--- Java 12: JVM Constants API ---");
        
    //     // Constants API in java.lang.constant package
    //     System.out.println("   - Provides API for describing loadable constants");
    //     System.out.println("   - Used for classes like String, Integer, Float, etc.");
    //     System.out.println("   - Helps with bytecode generation tools");
        
    //     // Example (simplified)
    //     // ConstantDesc desc = "Hello".describeConstable().get();
    //     // System.out.println("   Constant descriptor: " + desc);
    // }
    
    // // =========================================================================
    // // JAVA 13 FEATURES
    // // =========================================================================
    
    // private static void demonstrateTextBlocks() {
    //     System.out.println("\n--- Java 13: Text Blocks (Preview) ---");
        
    //     // Old way - messy with escape sequences
    //     String oldJson = "{\n" +
    //                      "  \"name\": \"John\",\n" +
    //                      "  \"age\": 30,\n" +
    //                      "  \"city\": \"New York\"\n" +
    //                      "}";
        
    //     // Text blocks (Java 13 preview, Java 15 standard)
    //     String newJson = """
    //         {
    //           "name": "John",
    //           "age": 30,
    //           "city": "New York"
    //         }
    //         """;
        
    //     System.out.println("   Old JSON:\n" + oldJson);
    //     System.out.println("   New JSON with text blocks:\n" + newJson);
        
    //     // SQL example
    //     String sql = """
    //         SELECT id, name, email
    //         FROM users
    //         WHERE status = 'ACTIVE'
    //         ORDER BY name
    //         """;
    //     System.out.println("   SQL query:\n" + sql);
        
    //     // HTML example
    //     String html = """
    //         <html>
    //             <body>
    //                 <h1>Hello, World!</h1>
    //             </body>
    //         </html>
    //         """;
    //     System.out.println("   HTML:\n" + html);
    // }
    
    // private static void demonstrateSwitchExpressionsYield() {
    //     System.out.println("\n--- Java 13: Switch Expressions with yield ---");
        
    //     String day = "WEDNESDAY";
        
    //     // Switch expression with yield (Java 13)
    //     int numLetters = switch (day) {
    //         case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
    //         case "TUESDAY" -> 7;
    //         case "THURSDAY", "SATURDAY" -> {
    //             System.out.println("   It's " + day);
    //             yield 8; // yield returns value from block
    //         }
    //         case "WEDNESDAY" -> {
    //             yield 9;
    //         }
    //         default -> {
    //             yield 0;
    //         }
    //     };
        
    //     System.out.println("   Number of letters: " + numLetters);
    // }
    
    // private static void demonstrateSocketAPI() {
    //     System.out.println("\n--- Java 13: Socket API ---");
        
    //     System.out.println("   - Re-implemented legacy Socket API");
    //     System.out.println("   - New implementation called NioSocketImpl");
    //     System.out.println("   - Better performance and maintainability");
    //     System.out.println("   - Use -Djdk.net.usePlainSocketImpl to fallback");
    // }
    
    // private static void demonstrateZGCUncommittingMemory() {
    //     System.out.println("\n--- Java 13: ZGC Uncommitting Memory ---");
        
    //     System.out.println("   - ZGC now returns unused heap memory to operating system");
    //     System.out.println("   - Better memory footprint");
    //     System.out.println("   - Useful for environments with memory constraints");
    // }
    
    // private static void demonstrateReimplementLegacyAPI() {
    //     System.out.println("\n--- Java 13: Reimplement Legacy API ---");
        
    //     System.out.println("   - Reimplemented java.net.Socket and java.net.ServerSocket");
    //     System.out.println("   - New implementation based on NIO");
    //     System.out.println("   - Better maintainability and performance");
    // }
    
    // // =========================================================================
    // // JAVA 14 FEATURES
    // // =========================================================================
    
    // private static void demonstratePatternMatchingInstanceOf() {
    //     System.out.println("\n--- Java 14: Pattern Matching for instanceof ---");
        
    //     Object obj = "Hello World";
        
    //     // Old way
    //     if (obj instanceof String) {
    //         String s = (String) obj;
    //         System.out.println("   Old way length: " + s.length());
    //     }
        
    //     // New way - with pattern matching (Java 14 preview, Java 16 standard)
    //     if (obj instanceof String s) {
    //         System.out.println("   Pattern matching length: " + s.length());
    //     }
        
    //     // With conditions
    //     if (obj instanceof String s && s.length() > 5) {
    //         System.out.println("   String longer than 5: " + s);
    //     }
        
    //     // With different types
    //     Object[] objects = {"Hello", 42, 3.14, "World"};
    //     for (Object o : objects) {
    //         if (o instanceof String s) {
    //             System.out.println("   String: " + s);
    //         } else if (o instanceof Integer i) {
    //             System.out.println("   Integer: " + i);
    //         } else if (o instanceof Double d) {
    //             System.out.println("   Double: " + d);
    //         }
    //     }
    // }
    
    // private static void demonstrateRecords() {
    //     System.out.println("\n--- Java 14: Records (Preview) ---");
        
    //     // Define record (compact data carrier)
    //     record Point(int x, int y) {}
    //     record Person(String name, int age) {}
        
    //     // Create records
    //     Point p1 = new Point(10, 20);
    //     Point p2 = new Point(10, 20);
    //     Person person = new Person("Alice", 30);
        
    //     // Auto-generated methods
    //     System.out.println("   Point: " + p1);
    //     System.out.println("   Person: " + person);
        
    //     // Accessors
    //     System.out.println("   x: " + p1.x() + ", y: " + p1.y());
    //     System.out.println("   name: " + person.name() + ", age: " + person.age());
        
    //     // equals, hashCode
    //     System.out.println("   p1 equals p2: " + p1.equals(p2));
    //     System.out.println("   p1 hashCode: " + p1.hashCode());
        
    //     // Custom methods in records
    //     record Rectangle(int width, int height) {
    //         public int area() {
    //             return width * height;
    //         }
            
    //         // Compact constructor
    //         public Rectangle {
    //             if (width <= 0 || height <= 0) {
    //                 throw new IllegalArgumentException("Dimensions must be positive");
    //             }
    //         }
    //     }
        
    //     Rectangle rect = new Rectangle(5, 3);
    //     System.out.println("   Rectangle area: " + rect.area());
    // }
    
    // private static void demonstrateTextBlocksStandard() {
    //     System.out.println("\n--- Java 14: Text Blocks (Second Preview) ---");
        
    //     // Text blocks with escape sequences
    //     String text = """
    //         This is a text block
    //         with "quotes" and new lines
    //         It preserves indentation\
    //         but can escape newlines \
    //         like this.
    //         """;
        
    //     System.out.println("   Text block:\n" + text);
        
    //     // New escape sequences
    //     String escaped = """
    //         Line 1
    //         Line 2 \s (with trailing space)
    //         Line 3 \s\s (with two spaces)
    //         """;
    //     System.out.println("   With \\s escapes:\n" + escaped);
    // }
    
    // private static void demonstrateSwitchExpressionsStandard() {
    //     System.out.println("\n--- Java 14: Switch Expressions (Standard) ---");
        
    //     enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }
        
    //     Day day = Day.WEDNESDAY;
        
    //     // Switch expression with arrow syntax
    //     String type = switch (day) {
    //         case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
    //         case SATURDAY, SUNDAY -> "Weekend";
    //     };
        
    //     System.out.println("   " + day + " is a " + type);
        
    //     // With yield and multiple statements
    //     int numLetters = switch (day) {
    //         case MONDAY, FRIDAY, SUNDAY -> 6;
    //         case TUESDAY -> 7;
    //         case THURSDAY, SATURDAY -> 8;
    //         case WEDNESDAY -> {
    //             System.out.println("   It's hump day!");
    //             yield 9;
    //         }
    //     };
        
    //     System.out.println("   " + day + " has " + numLetters + " letters");
    // }
    
    // private static void demonstrateHelpfulNullPointerExceptions() {
    //     System.out.println("\n--- Java 14: Helpful NullPointerExceptions ---");
        
    //     class Address {
    //         String street;
    //         String city;
    //     }
        
    //     class Person {
    //         String name;
    //         Address address;
    //     }
        
    //     Person person = new Person();
    //     person.name = "John";
    //     person.address = null; // Null address
        
    //     try {
    //         // This will throw NPE with helpful message in Java 14+
    //         int length = person.address.street.length();
    //     } catch (NullPointerException e) {
    //         System.out.println("   NPE message: " + e.getMessage());
    //         System.out.println("   (Java 14+ shows which variable was null)");
    //     }
    // }
    
    // private static void demonstratePackagingTool() {
    //     System.out.println("\n--- Java 14: Packaging Tool (jpackage) ---");
        
    //     System.out.println("   - jpackage tool for creating native installers");
    //     System.out.println("   - Supports Windows, macOS, and Linux");
    //     System.out.println("   - Creates .exe, .dmg, .deb, .rpm packages");
    //     System.out.println("   - Bundles JVM with application");
    // }
    
    // private static void demonstrateNUMAawareMemory() {
    //     System.out.println("\n--- Java 14: NUMA-Aware Memory Allocation ---");
        
    //     System.out.println("   - Improved G1 GC performance on NUMA systems");
    //     System.out.println("   - Better memory locality");
    //     System.out.println("   - Use -XX:+UseNUMA flag");
    // }
    
    // private static void demonstrateJFRStreaming() {
    //     System.out.println("\n--- Java 14: JFR Event Streaming ---");
        
    //     System.out.println("   - Continuous monitoring of JFR events");
    //     System.out.println("   - Access events without dumping to disk");
    //     System.out.println("   - Real-time event consumption");
    // }
    
    // =========================================================================
    // JAVA 15 FEATURES
    // =========================================================================
    
    // private static void demonstrateSealedClasses() {
    //     System.out.println("\n--- Java 15: Sealed Classes (Preview) ---");
        
    //     // Sealed classes restrict which classes can extend them
    //     sealed interface Vehicle permits Car, Truck, Motorcycle {}
        
    //     final class Car implements Vehicle {
    //         String model = "Sedan";
    //     }
        
    //     final class Truck implements Vehicle {
    //         int capacity = 1000;
    //     }
        
    //     final class Motorcycle implements Vehicle {
    //         boolean hasSidecar = false;
    //     }
        
    //     // Using sealed classes
    //     Vehicle vehicle = new Car();
        
    //     String description = switch (vehicle) {
    //         case Car c -> "Car: " + c.model;
    //         case Truck t -> "Truck capacity: " + t.capacity;
    //         case Motorcycle m -> "Motorcycle has sidecar: " + m.hasSidecar;
    //     };
        
    //     System.out.println("   " + description);
    // }
    
    // private static void demonstratePatternMatchingTypeChecks() {
    //     System.out.println("\n--- Java 15: Pattern Matching (Second Preview) ---");
        
    //     record Point(int x, int y) {}
        
    //     Object obj = new Point(10, 20);
        
    //     // Deconstruction in instanceof (Java 19+)
    //     if (obj instanceof Point(int x, int y)) {
    //         System.out.println("   Point coordinates: " + x + ", " + y);
    //     }
        
    //     // With guards
    //     if (obj instanceof Point(int x, int y) && x > 0) {
    //         System.out.println("   Point with positive x: " + x);
    //     }
    // }
    
    // private static void demonstrateEdDSAAlgorithm() {
    //     System.out.println("\n--- Java 15: EdDSA Algorithm ---");
        
    //     System.out.println("   - Edwards-Curve Digital Signature Algorithm");
    //     System.out.println("   - More secure and faster than existing schemes");
    //     System.out.println("   - Implemented in java.security package");
    // }
    
    // private static void demonstrateHiddenClasses() {
    //     System.out.println("\n--- Java 15: Hidden Classes ---");
        
    //     System.out.println("   - Classes that cannot be used directly by bytecode of other classes");
    //     System.out.println("   - Used by frameworks that generate classes dynamically");
    //     System.out.println("   - Improve efficiency of dynamic languages on JVM");
    // }
    
    // private static void demonstrateForeignMemoryAccess() {
    //     System.out.println("\n--- Java 15: Foreign-Memory Access (Incubator) ---");
        
    //     System.out.println("   - Safe API for accessing foreign memory");
    //     System.out.println("   - Alternative to sun.misc.Unsafe");
    //     System.out.println("   - Part of Project Panama");
    // }
    
    // private static void demonstrateZGCEnhancements() {
    //     System.out.println("\n--- Java 15: ZGC Enhancements ---");
        
    //     System.out.println("   - ZGC is now production-ready");
    //     System.out.println("   - Supports all platform features");
    //     System.out.println("   - Better performance and scalability");
    // }
    
    // // =========================================================================
    // // JAVA 16 FEATURES
    // // =========================================================================
    
    // private static void demonstrateRecordsStandard() {
    //     System.out.println("\n--- Java 16: Records (Standard) ---");
        
    //     // Records are now standard (no preview)
    //     record Employee(String name, int id, double salary) {}
        
    //     Employee emp = new Employee("Jane Doe", 12345, 75000.0);
        
    //     System.out.println("   Employee: " + emp);
    //     System.out.println("   Name: " + emp.name());
    //     System.out.println("   ID: " + emp.id());
        
    //     // Local records
    //     record Pair<T>(T first, T second) {}
        
    //     Pair<String> pair = new Pair<>("left", "right");
    //     System.out.println("   Pair: " + pair);
    // }
    
    // private static void demonstratePatternMatchingInstanceOfStandard() {
    //     System.out.println("\n--- Java 16: Pattern Matching (Standard) ---");
        
    //     Object obj = "Hello Java 16";
        
    //     // Pattern matching is now standard
    //     if (obj instanceof String s) {
    //         System.out.println("   String length: " + s.length());
    //     }
        
    //     // With more complex patterns
    //     List<Object> items = List.of("Hello", 42, 3.14, new int[]{1,2,3});
        
    //     for (Object item : items) {
    //         switch (item) {
    //             case String s -> System.out.println("   String: " + s);
    //             case Integer i -> System.out.println("   Integer: " + i);
    //             case Double d -> System.out.println("   Double: " + d);
    //             case int[] arr -> System.out.println("   Array length: " + arr.length);
    //             default -> System.out.println("   Unknown: " + item);
    //         }
    //     }
    // }
    
    // private static void demonstrateStreamToList() {
    //     System.out.println("\n--- Java 16: Stream.toList() ---");
        
    //     List<String> original = List.of("a", "b", "c", "d");
        
    //     // Old way - creates mutable list
    //     List<String> oldWay = original.stream()
    //         .map(String::toUpperCase)
    //         .collect(Collectors.toList());
        
    //     // New way - creates immutable list
    //     List<String> newWay = original.stream()
    //         .map(String::toUpperCase)
    //         .toList();
        
    //     System.out.println("   Original: " + original);
    //     System.out.println("   Old way (collect): " + oldWay);
    //     System.out.println("   New way (toList): " + newWay);
        
    //     // toList() returns unmodifiable list
    //     try {
    //         newWay.add("E");
    //     } catch (UnsupportedOperationException e) {
    //         System.out.println("   ✓ toList() returns immutable list");
    //     }
    // }
    
    // private static void demonstrateMapMulti() {
    //     System.out.println("\n--- Java 16: Stream.mapMulti() ---");
        
    //     List<List<Integer>> listOfLists = List.of(
    //         List.of(1, 2, 3),
    //         List.of(4, 5, 6),
    //         List.of(7, 8, 9)
    //     );
        
    //     // flatMap version
    //     List<Integer> flatMapResult = listOfLists.stream()
    //         .flatMap(List::stream)
    //         .collect(Collectors.toList());
        
    //     // mapMulti version (more flexible)
    //     List<Integer> mapMultiResult = listOfLists.stream()
    //         .<Integer>mapMulti((list, consumer) -> {
    //             for (Integer i : list) {
    //                 if (i % 2 == 0) { // only even numbers
    //                     consumer.accept(i);
    //                 }
    //             }
    //         })
    //         .collect(Collectors.toList());
        
    //     System.out.println("   flatMap all: " + flatMapResult);
    //     System.out.println("   mapMulti even: " + mapMultiResult);
        
    //     // Another example - filtering and transforming
    //     List<String> words = List.of("Hello", "World", "Java", "16");
        
    //     List<String> result = words.stream()
    //         .<String>mapMulti((word, consumer) -> {
    //             if (word.length() > 3) {
    //                 consumer.accept(word.toUpperCase());
    //             }
    //             consumer.accept(word.toLowerCase());
    //         })
    //         .collect(Collectors.toList());
        
    //     System.out.println("   mapMulti transform: " + result);
    // }
    
    // private static void demonstrateDayPeriodSupport() {
    //     System.out.println("\n--- Java 16: Day Period Support ---");
        
    //     // DateTimeFormatter with day period (e.g., "in the morning")
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B", Locale.US);
        
    //     LocalTime morning = LocalTime.of(9, 0);
    //     LocalTime afternoon = LocalTime.of(15, 0);
    //     LocalTime evening = LocalTime.of(20, 0);
        
    //     System.out.println("   9:00 AM: " + morning.format(formatter));
    //     System.out.println("   3:00 PM: " + afternoon.format(formatter));
    //     System.out.println("   8:00 PM: " + evening.format(formatter));
        
    //     // With different locales
    //     DateTimeFormatter frFormatter = DateTimeFormatter.ofPattern("h B", Locale.FRANCE);
    //     System.out.println("   French 9:00: " + morning.format(frFormatter));
    // }
    
    // private static void demonstrateUnixDomainSockets() {
    //     System.out.println("\n--- Java 16: Unix-Domain Socket Channels ---");
        
    //     System.out.println("   - Support for Unix-domain sockets (AF_UNIX)");
    //     System.out.println("   - Faster local communication than TCP loopback");
    //     System.out.println("   - Available in java.nio.channels package");
        
    //     // Example (simplified)
    //     // UnixDomainSocketAddress addr = UnixDomainSocketAddress.of("/tmp/socket");
    //     // SocketChannel channel = SocketChannel.open(StandardProtocolFamily.UNIX);
    //     // channel.connect(addr);
    // }
    
    // private static void demonstrateForeignLinkerAPI() {
    //     System.out.println("\n--- Java 16: Foreign Linker API (Incubator) ---");
        
    //     System.out.println("   - Access native code without JNI");
    //     System.out.println("   - Part of Project Panama");
    //     System.out.println("   - Safer and more efficient than JNI");
    // }
    
    // private static void demonstrateVectorAPI() {
    //     System.out.println("\n--- Java 16: Vector API (Incubator) ---");
        
    //     System.out.println("   - SIMD (Single Instruction Multiple Data) operations");
    //     System.out.println("   - Express vector computations at runtime");
    //     System.out.println("   - Compiles to optimal vector instructions");
        
    //     // Conceptual example
    //     // float[] a = {1, 2, 3, 4};
    //     // float[] b = {5, 6, 7, 8};
    //     // var va = FloatVector.fromArray(SPECIES_128, a, 0);
    //     // var vb = FloatVector.fromArray(SPECIES_128, b, 0);
    //     // var vc = va.add(vb);
    //     // vc.intoArray(c, 0);
    // }
    
    // // =========================================================================
    // // JAVA 17 FEATURES (LTS)
    // // =========================================================================
    
    // private static void demonstrateSealedClassesFinal() {
    //     System.out.println("\n--- Java 17: Sealed Classes (Final) ---");
        
    //     // Sealed classes are now final (no preview)
    //     sealed interface Shape permits Circle, Rectangle, Triangle {}
        
    //     record Circle(double radius) implements Shape {}
    //     record Rectangle(double width, double height) implements Shape {}
    //     record Triangle(double base, double height) implements Shape {}
        
    //     // Compile-time exhaustive checking
    //     double area = switch (createShape()) {
    //         case Circle c -> Math.PI * c.radius() * c.radius();
    //         case Rectangle r -> r.width() * r.height();
    //         case Triangle t -> 0.5 * t.base() * t.height();
    //     };
        
    //     System.out.println("   Area: " + area);
    // }
    
    // private static Shape createShape() {
    //     return new Circle(5);
    // }
    
    // private static void demonstratePatternMatchingSwitch() {
    //     System.out.println("\n--- Java 17: Pattern Matching for switch (Preview) ---");
        
    //     Object obj = "Hello World";
        
    //     // Pattern matching in switch (Java 17 preview)
    //     String result = switch (obj) {
    //         case Integer i -> "Integer: " + i;
    //         case String s -> "String length: " + s.length();
    //         case Double d -> "Double: " + d;
    //         case null -> "Null value";
    //         default -> "Unknown type";
    //     };
        
    //     System.out.println("   " + result);
        
    //     // With guards
    //     Object num = 42;
    //     String description = switch (num) {
    //         case Integer i when i < 0 -> "Negative integer";
    //         case Integer i when i == 0 -> "Zero";
    //         case Integer i -> "Positive integer: " + i;
    //         default -> "Not an integer";
    //     };
        
    //     System.out.println("   " + description);
    // }
    
    // private static void demonstrateRandomGenerator() {
    //     System.out.println("\n--- Java 17: RandomGenerator Interface ---");
        
    //     // New RandomGenerator interface
    //     RandomGenerator random = RandomGenerator.getDefault();
        
    //     System.out.println("   Random int: " + random.nextInt());
    //     System.out.println("   Random double: " + random.nextDouble());
    //     System.out.println("   Random int in range: " + random.nextInt(1, 100));
        
    //     // Different algorithms
    //     RandomGenerator lcg = RandomGenerator.of("L32X64MixRandom");
    //     System.out.println("   LCG random: " + lcg.nextInt());
        
    //     // Splittable generators
    //     SplittableRandomGenerator splittable = RandomGeneratorFactory
    //         .<SplittableRandomGenerator>of("L64X128MixRandom")
    //         .create();
        
    //     RandomGenerator split = splittable.split();
    //     System.out.println("   Split random: " + split.nextInt());
    // }
    
    // private static void demonstrateHexFormatting() {
    //     System.out.println("\n--- Java 17: Hex Formatting ---");
        
    //     byte[] data = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        
    //     // Format bytes to hex
    //     String hex = HexFormat.of().formatHex(data);
    //     System.out.println("   Bytes to hex: " + hex);
        
    //     // With delimiter
    //     HexFormat withDelimiter = HexFormat.of().withDelimiter(":");
    //     String hexDelim = withDelimiter.formatHex(data);
    //     System.out.println("   With delimiter: " + hexDelim);
        
    //     // With uppercase
    //     HexFormat upper = HexFormat.of().withUpperCase();
    //     String hexUpper = upper.formatHex(data);
    //     System.out.println("   Uppercase: " + hexUpper);
        
    //     // Parse hex back to bytes
    //     byte[] parsed = HexFormat.of().parseHex(hex);
    //     System.out.println("   Parsed back length: " + parsed.length);
        
    //     // For specific types
    //     long value = 0x123456789ABCDEFL;
    //     String longHex = HexFormat.of().toHexDigits(value);
    //     System.out.println("   Long to hex: " + longHex);
    // }
    
    // private static void demonstrateInstantSource() {
    //     System.out.println("\n--- Java 17: InstantSource ---");
        
    //     // Get current instant
    //     InstantSource source = InstantSource.system();
        
    //     Instant instant = source.instant();
    //     System.out.println("   Current instant: " + instant);
        
    //     // Measure elapsed time
    //     long start = source.millis();
    //     // Simulate some work
    //     try { Thread.sleep(10); } catch (InterruptedException e) {}
    //     long end = source.millis();
        
    //     System.out.println("   Elapsed ms: " + (end - start));
        
    //     // Fixed source for testing
    //     Instant fixed = Instant.parse("2024-01-01T00:00:00Z");
    //     InstantSource fixedSource = InstantSource.fixed(fixed);
    //     System.out.println("   Fixed source: " + fixedSource.instant());
        
    //     // Tick source
    //     InstantSource tickSource = source.withZone(ZoneOffset.UTC).tick(Duration.ofSeconds(1));
    //     System.out.println("   Tick source: " + tickSource.instant());
    // }
    
    // private static void demonstrateVectorAPIPerformance() {
    //     System.out.println("\n--- Java 17: Vector API (Incubator) ---");
        
    //     System.out.println("   - Second incubator of Vector API");
    //     System.out.println("   - Performance improvements");
    //     System.out.println("   - Better cross-platform support");
        
    //     // Conceptual vector operation
    //     // float[] a = {1, 2, 3, 4};
    //     // float[] b = {5, 6, 7, 8};
    //     // var species = FloatVector.SPECIES_128;
    //     // var va = FloatVector.fromArray(species, a, 0);
    //     // var vb = FloatVector.fromArray(species, b, 0);
    //     // var vc = va.mul(vb);
    //     // vc.intoArray(c, 0);
    // }
    
    // private static void demonstrateContextSpecificDeserialization() {
    //     System.out.println("\n--- Java 17: Context-Specific Deserialization Filters ---");
        
    //     System.out.println("   - Allow configuring deserialization filters per-stream");
    //     System.out.println("   - Better security for deserialization");
    //     System.out.println("   - Prevent deserialization attacks");
        
    //     // Example (conceptual)
    //     // ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("!*;java.base/*;maxbytes=1024");
    //     // ObjectInputStream ois = new ObjectInputStream(inputStream);
    //     // ois.setObjectInputFilter(filter);
    // }
    
    // private static void demonstrateStronglyEncapsulateJDK() {
    //     System.out.println("\n--- Java 17: Strongly Encapsulate JDK Internals ---");
        
    //     System.out.println("   - Most internal APIs are now strongly encapsulated");
    //     System.out.println("   - sun.misc.Unsafe still accessible but discouraged");
    //     System.out.println("   - Use --illegal-access=warn|debug|deny flags");
    //     System.out.println("   - Breaking change for libraries using internal APIs");
    // }
    
    // // =========================================================================
    // // JAVA 18 FEATURES
    // // =========================================================================
    
    // private static void demonstrateSimpleWebServer() throws IOException {
    //     System.out.println("\n--- Java 18: Simple Web Server ---");
        
    //     // Create a simple HTTP file server
    //     var server = SimpleFileServer.createFileServer(
    //         new InetSocketAddress(8080),
    //         Path.of("."),
    //         SimpleFileServer.OutputLevel.VERBOSE
    //     );
        
    //     System.out.println("   Simple web server created on port 8080");
    //     System.out.println("   Serving current directory: " + Path.of(".").toAbsolutePath());
        
    //     // Start server in background
    //     server.start();
        
    //     // Stop after demonstration
    //     server.stop(0);
    //     System.out.println("   Server stopped");
    // }
    
    // private static void demonstrateUTF8Charset() {
    //     System.out.println("\n--- Java 18: UTF-8 by Default ---");
        
    //     System.out.println("   - UTF-8 is now the default charset");
    //     System.out.println("   - Consistent behavior across platforms");
        
    //     // Get default charset
    //     System.out.println("   Default charset: " + Charset.defaultCharset());
        
    //     // No more need to specify UTF-8 explicitly
    //     String text = "Hello 世界";
    //     byte[] bytes = text.getBytes(); // Uses UTF-8 by default
    //     String decoded = new String(bytes); // Uses UTF-8 by default
        
    //     System.out.println("   Original: " + text);
    //     System.out.println("   Decoded: " + decoded);
    // }
    
    // private static void demonstrateCodeSnippets() {
    //     System.out.println("\n--- Java 18: @snippet Tag for Javadoc ---");
        
    //     System.out.println("   - New @snippet tag for Javadoc");
    //     System.out.println("   - Better code examples in documentation");
    //     System.out.println("   - Syntax highlighting in generated docs");
        
    //     // Example of how it would look in Javadoc
    //     System.out.println("   /**");
    //     System.out.println("    * Example usage:");
    //     System.out.println("    * {@snippet :");
    //     System.out.println("    *   var list = List.of(1, 2, 3);");
    //     System.out.println("    *   list.stream().forEach(System.out::println);");
    //     System.out.println("    * }");
    //     System.out.println("    */");
    // }
    
    // private static void demonstrateReentrantLockEnhancements() {
    //     System.out.println("\n--- Java 18: ReentrantLock Enhancements ---");
        
    //     ReentrantLock lock = new ReentrantLock();
        
    //     // New methods for monitoring
    //     System.out.println("   Has queued threads: " + lock.hasQueuedThreads());
    //     System.out.println("   Is locked: " + lock.isLocked());
    //     System.out.println("   Hold count: " + lock.getHoldCount());
        
    //     // More detailed queue information
    //     // lock.getQueueLength();
    //     // lock.hasWaiters(condition);
    // }
    
    // private static void demonstrateInternetAddressResolution() {
    //     System.out.println("\n--- Java 18: Internet Address Resolution SPI ---");
        
    //     System.out.println("   - Service-provider interface for hostname resolution");
    //     System.out.println("   - Custom resolvers for different environments");
    //     System.out.println("   - Better integration with container networks");
    // }
    
    // // =========================================================================
    // // JAVA 19 FEATURES
    // // =========================================================================
    
    // private static void demonstrateVirtualThreads() {
    //     System.out.println("\n--- Java 19: Virtual Threads (Preview) ---");
        
    //     System.out.println("   - Lightweight threads for high concurrency");
    //     System.out.println("   - Part of Project Loom");
        
    //     // Create and start virtual thread
    //     Thread virtualThread = Thread.startVirtualThread(() -> {
    //         System.out.println("   Running in virtual thread: " + Thread.currentThread());
    //         try {
    //             Thread.sleep(100);
    //         } catch (InterruptedException e) {}
    //         System.out.println("   Virtual thread completed");
    //     });
        
    //     try {
    //         virtualThread.join();
    //     } catch (InterruptedException e) {}
        
    //     // Builder pattern
    //     Thread.Builder builder = Thread.ofVirtual().name("my-virtual-thread");
    //     Thread thread = builder.start(() -> {
    //         System.out.println("   Named virtual thread");
    //     });
        
    //     // Executor with virtual threads
    //     try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    //         Future<String> future = executor.submit(() -> {
    //             Thread.sleep(50);
    //             return "Virtual thread result";
    //         });
    //         System.out.println("   " + future.get());
    //     } catch (Exception e) {}
        
    //     // Virtual thread count
    //     System.out.println("   Virtual threads are much lighter than platform threads");
    // }
    
    // private static void demonstrateStructuredConcurrency() {
    //     System.out.println("\n--- Java 19: Structured Concurrency (Preview) ---");
        
    //     // StructuredTaskScope for managing concurrent tasks
    //     try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            
    //         // Fork subtasks
    //         Future<String> user = scope.fork(() -> fetchUser());
    //         Future<Integer> order = scope.fork(() -> fetchOrder());
            
    //         // Wait for all to complete or fail
    //         scope.join();
    //         scope.throwIfFailed();
            
    //         // Combine results
    //         String result = user.resultNow() + " has " + order.resultNow() + " orders";
    //         System.out.println("   " + result);
            
    //     } catch (InterruptedException | ExecutionException e) {}
    // }
    
    // private static String fetchUser() {
    //     try { Thread.sleep(50); } catch (InterruptedException e) {}
    //     return "User123";
    // }
    
    // private static Integer fetchOrder() {
    //     try { Thread.sleep(30); } catch (InterruptedException e) {}
    //     return 5;
    // }
    
    // private static void demonstratePatternMatchingRecordPatterns() {
    //     System.out.println("\n--- Java 19: Record Patterns (Preview) ---");
        
    //     record Point(int x, int y) {}
    //     record Line(Point start, Point end) {}
        
    //     Object obj = new Line(new Point(1, 2), new Point(3, 4));
        
    //     // Deconstruct records in patterns
    //     if (obj instanceof Line(Point(int x1, int y1), Point(int x2, int y2))) {
    //         System.out.println("   Line from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
    //     }
        
    //     // Nested patterns
    //     List<Object> shapes = List.of(
    //         new Point(5, 6),
    //         new Line(new Point(1, 1), new Point(2, 2))
    //     );
        
    //     for (Object shape : shapes) {
    //         switch (shape) {
    //             case Point(int x, int y) -> 
    //                 System.out.println("   Point at " + x + "," + y);
    //             case Line(Point(var x1, var y1), Point(var x2, var y2)) ->
    //                 System.out.println("   Line from " + x1 + "," + y1 + " to " + x2 + "," + y2);
    //             default -> {}
    //         }
    //     }
    // }
    
    // private static void demonstrateForeignFunctionMemoryAPI() {
    //     System.out.println("\n--- Java 19: Foreign Function & Memory API (Preview) ---");
        
    //     System.out.println("   - Access native code and memory");
    //     System.out.println("   - Replacement for JNI");
    //     System.out.println("   - Safer and more efficient");
        
    //     // Conceptual example
    //     // try (Arena arena = Arena.openConfined()) {
    //     //     MemorySegment segment = arena.allocate(100);
    //     //     segment.set(ValueLayout.JAVA_INT, 0, 42);
    //     //     int value = segment.get(ValueLayout.JAVA_INT, 0);
    //     // }
    // }
    
    // private static void demonstrateVectorAPIIncubator() {
    //     System.out.println("\n--- Java 19: Vector API (Fourth Incubator) ---");
        
    //     System.out.println("   - Further enhancements to Vector API");
    //     System.out.println("   - Better performance");
    //     System.out.println("   - More operations supported");
    // }
    
    // // =========================================================================
    // // JAVA 20 FEATURES
    // // =========================================================================
    
    // private static void demonstrateScopedValues() {
    //     System.out.println("\n--- Java 20: Scoped Values (Preview) ---");
        
    //     // Define scoped value
    //     ScopedValue<String> USER = ScopedValue.newInstance();
        
    //     // Run with scoped value
    //     ScopedValue.runWhere(USER, "admin", () -> {
    //         System.out.println("   Inside scoped: " + USER.get());
            
    //         // Virtual threads can access the same scoped value
    //         Thread.startVirtualThread(() -> {
    //             System.out.println("   Virtual thread: " + USER.get());
    //         }).join();
    //     });
        
    //     try {
    //         // Outside scope - throws exception
    //         USER.get();
    //     } catch (NoSuchElementException e) {
    //         System.out.println("   Outside scope: value not bound");
    //     }
    // }
    
    // private static void demonstrateRecordPatterns() {
    //     System.out.println("\n--- Java 20: Record Patterns (Second Preview) ---");
        
    //     record Person(String name, Address address) {}
    //     record Address(String street, String city) {}
        
    //     Object obj = new Person("Alice", new Address("123 Main St", "Springfield"));
        
    //     // Nested record patterns
    //     if (obj instanceof Person(var name, Address(var street, var city))) {
    //         System.out.println("   " + name + " lives on " + street + " in " + city);
    //     }
        
    //     // With var
    //     if (obj instanceof Person(var name, var address)) {
    //         System.out.println("   Person: " + name + ", address: " + address);
    //     }
    // }
    
    // private static void demonstrateSwitchPatternMatching() {
    //     System.out.println("\n--- Java 20: Pattern Matching for switch (Fifth Preview) ---");
        
    //     record Box<T>(T content) {}
        
    //     Object obj = Box.of("Hello");
        
    //     // Type patterns with generics
    //     String result = switch (obj) {
    //         case Box<String>(var s) -> "Box with string: " + s;
    //         case Box<Integer>(var i) -> "Box with integer: " + i;
    //         case Box<?>(var content) -> "Box with unknown: " + content;
    //         case null -> "Null value";
    //         default -> "Other: " + obj;
    //     };
        
    //     System.out.println("   " + result);
        
    //     // Exhaustive switch with sealed types
    //     sealed interface Expr permits Constant, Add {}
    //     record Constant(int value) implements Expr {}
    //     record Add(Expr left, Expr right) implements Expr {}
        
    //     Expr expr = new Add(new Constant(2), new Constant(3));
        
    //     int eval = switch (expr) {
    //         case Constant(var v) -> v;
    //         case Add(var l, var r) -> eval(l) + eval(r);
    //     };
        
    //     System.out.println("   Evaluation result: " + eval);
    // }
    
    // private static int eval(Expr expr) {
    //     return switch (expr) {
    //         case Constant(var v) -> v;
    //         case Add(var l, var r) -> eval(l) + eval(r);
    //     };
    // }
    
    // private static void demonstrateVirtualThreadEnhancements() {
    //     System.out.println("\n--- Java 20: Virtual Thread Enhancements ---");
        
    //     System.out.println("   - More stable virtual thread implementation");
    //     System.out.println("   - Better integration with existing APIs");
    //     System.out.println("   - Improved debugging and monitoring");
        
    //     // Create many virtual threads
    //     var threads = new ArrayList<Thread>();
    //     for (int i = 0; i < 10; i++) {
    //         int index = i;
    //         Thread thread = Thread.ofVirtual()
    //             .name("worker-" + i)
    //             .unstarted(() -> {
    //                 System.out.println("   Thread " + index + " running");
    //                 try {
    //                     Thread.sleep(10);
    //                 } catch (InterruptedException e) {}
    //             });
    //         threads.add(thread);
    //         thread.start();
    //     }
        
    //     // Wait for completion
    //     for (Thread t : threads) {
    //         try {
    //             t.join();
    //         } catch (InterruptedException e) {}
    //     }
        
    //     System.out.println("   All virtual threads completed");
    // }
    
    // // =========================================================================
    // // JAVA 21 FEATURES (LTS)
    // // =========================================================================
    
    // private static void demonstrateVirtualThreadsFinal() {
    //     System.out.println("\n--- Java 21: Virtual Threads (Final) ---");
        
    //     System.out.println("   Virtual threads are now production-ready");
        
    //     // Create virtual thread
    //     Thread vThread = Thread.startVirtualThread(() -> {
    //         System.out.println("   Virtual thread running: " + Thread.currentThread());
    //     });
        
    //     try {
    //         vThread.join();
    //     } catch (InterruptedException e) {}
        
    //     // Thread factory
    //     ThreadFactory factory = Thread.ofVirtual().factory();
    //     Thread thread = factory.newThread(() -> {
    //         System.out.println("   Virtual thread from factory");
    //     });
    //     thread.start();
        
    //     try {
    //         thread.join();
    //     } catch (InterruptedException e) {}
        
    //     // Executor with virtual threads
    //     try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
    //         List<Future<String>> futures = new ArrayList<>();
    //         for (int i = 0; i < 5; i++) {
    //             int taskId = i;
    //             futures.add(executor.submit(() -> {
    //                 Thread.sleep(10);
    //                 return "Task " + taskId + " completed";
    //             }));
    //         }
            
    //         for (Future<String> future : futures) {
    //             System.out.println("   " + future.get());
    //         }
    //     } catch (Exception e) {}
        
    //     // Virtual threads are cheap
    //     System.out.println("   Can create millions of virtual threads");
    // }
    
    // private static void demonstrateStructuredConcurrencyFinal() throws Exception {
    //     System.out.println("\n--- Java 21: Structured Concurrency (Final) ---");
        
    //     // StructuredTaskScope for managing subtasks
    //     try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            
    //         // Fork subtasks
    //         Future<String> user = scope.fork(() -> {
    //             Thread.sleep(50);
    //             return "user123";
    //         });
            
    //         Future<Integer> balance = scope.fork(() -> {
    //             Thread.sleep(30);
    //             return 1000;
    //         });
            
    //         Future<List<String>> orders = scope.fork(() -> {
    //             Thread.sleep(20);
    //             return List.of("order1", "order2");
    //         });
            
    //         // Wait for all tasks to complete
    //         scope.join();
    //         scope.throwIfFailed();
            
    //         // Get results
    //         String result = String.format(
    //             "User %s has balance %d and orders %s",
    //             user.resultNow(), balance.resultNow(), orders.resultNow()
    //         );
            
    //         System.out.println("   " + result);
    //     }
        
    //     // ShutdownOnSuccess scope
    //     try (var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
    //         scope.fork(() -> {
    //             Thread.sleep(100);
    //             return "Slow result";
    //         });
            
    //         scope.fork(() -> {
    //             Thread.sleep(50);
    //             return "Fast result";
    //         });
            
    //         String firstResult = scope.join().result();
    //         System.out.println("   First successful result: " + firstResult);
    //     }
    // }
    
    // private static void demonstrateScopedValuesFinal() {
    //     System.out.println("\n--- Java 21: Scoped Values (Final) ---");
        
    //     // Define scoped values
    //     ScopedValue<String> USER_ID = ScopedValue.newInstance();
    //     ScopedValue<String> SESSION_ID = ScopedValue.newInstance();
        
    //     // Bind multiple scoped values
    //     ScopedValue.where(USER_ID, "user-001")
    //               .where(SESSION_ID, "session-abc")
    //               .run(() -> {
    //                   System.out.println("   User: " + USER_ID.get());
    //                   System.out.println("   Session: " + SESSION_ID.get());
                      
    //                   // Inherited by virtual threads
    //                   Thread.startVirtualThread(() -> {
    //                       System.out.println("   Virtual thread sees: " + USER_ID.get());
    //                   }).join();
    //               });
        
    //     // Callable with scoped values
    //     try {
    //         String result = ScopedValue.where(USER_ID, "user-002")
    //             .call(() -> {
    //                 return "Processing for " + USER_ID.get();
    //             });
    //         System.out.println("   " + result);
    //     } catch (Exception e) {}
        
    //     // Scoped values are immutable per thread
    //     System.out.println("   Scoped values are safer than ThreadLocal");
    // }
    
    // private static void demonstrateSequencedCollections() {
    //     System.out.println("\n--- Java 21: Sequenced Collections ---");
        
    //     // SequencedCollection (List, Deque, etc.)
    //     SequencedCollection<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));
        
    //     System.out.println("   Original list: " + list);
    //     System.out.println("   First: " + list.getFirst());
    //     System.out.println("   Last: " + list.getLast());
        
    //     // Add at both ends
    //     list.addFirst("First");
    //     list.addLast("Last");
    //     System.out.println("   After addFirst/addLast: " + list);
        
    //     // Remove from both ends
    //     String first = list.removeFirst();
    //     String last = list.removeLast();
    //     System.out.println("   Removed: " + first + ", " + last);
    //     System.out.println("   After removal: " + list);
        
    //     // Reverse order
    //     SequencedCollection<String> reversed = list.reversed();
    //     System.out.println("   Reversed: " + reversed);
    // }
    
    // private static void demonstratePatternMatchingSwitchFinal() {
    //     System.out.println("\n--- Java 21: Pattern Matching for switch (Final) ---");
        
    //     record Pair<T>(T a, T b) {}
        
    //     Object obj = new Pair<>("Hello", 42); // Mixed types
        
    //     // Type patterns with when clauses
    //     String result = switch (obj) {
    //         case null -> "Null";
    //         case String s -> "String: " + s;
    //         case Integer i when i > 0 -> "Positive int: " + i;
    //         case Integer i -> "Int: " + i;
    //         case Pair<String>(String a, String b) -> "Pair of strings: " + a + "," + b;
    //         case Pair<?>(var a, var b) -> "Pair of mixed: " + a + "," + b;
    //         default -> "Other: " + obj;
    //     };
        
    //     System.out.println("   " + result);
        
    //     // Exhaustiveness with sealed classes
    //     sealed interface Node permits Leaf, Branch {}
    //     record Leaf(int value) implements Node {}
    //     record Branch(Node left, Node right) implements Node {}
        
    //     Node tree = new Branch(new Leaf(1), new Leaf(2));
        
    //     int sum = switch (tree) {
    //         case Leaf(var v) -> v;
    //         case Branch(var l, var r) -> sum(l) + sum(r);
    //     };
        
    //     System.out.println("   Tree sum: " + sum);
    // }
    
    // private static int sum(Node node) {
    //     return switch (node) {
    //         case Leaf(var v) -> v;
    //         case Branch(var l, var r) -> sum(l) + sum(r);
    //     };
    // }
    
    // private static void demonstrateRecordPatternsFinal() {
    //     System.out.println("\n--- Java 21: Record Patterns (Final) ---");
        
    //     record Person(String name, int age, Address address) {}
    //     record Address(String street, String city, String zip) {}
        
    //     Object obj = new Person("Bob", 30, new Address("123 Oak St", "Boston", "02108"));
        
    //     // Nested record deconstruction
    //     if (obj instanceof Person(var name, var age, Address(var street, var city, var zip))) {
    //         System.out.println("   " + name + " (" + age + ")");
    //         System.out.println("   " + street + ", " + city + " " + zip);
    //     }
        
    //     // With var and named patterns
    //     if (obj instanceof Person(String n, int a, Address(var s, var c, var z))) {
    //         System.out.println("   Pattern with named variables: " + n);
    //     }
        
    //     // Switch with record patterns
    //     List<Object> items = List.of(
    //         new Person("Alice", 25, new Address("1 First St", "NYC", "10001")),
    //         new Address("2 Second St", "LA", "90001"),
    //         "Hello"
    //     );
        
    //     for (Object item : items) {
    //         String description = switch (item) {
    //             case Person(var n, var a, Address(var s, var c, var z)) ->
    //                 n + " from " + c;
    //             case Address(var s, var c, var z) ->
    //                 "Address in " + c;
    //             case String s -> "String: " + s;
    //             default -> "Other";
    //         };
    //         System.out.println("   " + description);
    //     }
    // }
    
    // private static void demonstrateStringTemplates() {
    //     System.out.println("\n--- Java 21: String Templates (Preview) ---");
        
    //     String name = "Alice";
    //     int age = 30;
        
    //     // STR template processor
    //     String message = STR."Hello \{name}, you are \{age} years old";
    //     System.out.println("   STR template: " + message);
        
    //     // Expressions in templates
    //     String math = STR."100 + 200 = \{100 + 200}";
    //     System.out.println("   Math: " + math);
        
    //     // Method calls
    //     String upper = STR."Uppercase: \{name.toUpperCase()}";
    //     System.out.println("   " + upper);
        
    //     // Multiline templates
    //     String json = STR."""
    //         {
    //             "name": "\{name}",
    //             "age": \{age},
    //             "isAdult": \{age >= 18}
    //         }
    //         """;
    //     System.out.println("   JSON template:\n" + json);
        
    //     // FMT template processor for formatting
    //     // String formatted = FMT."Price: %5.2f\{price}";
        
    //     // RAW template processor
    //     StringTemplate template = RAW."Hello \{name}";
    //     String processed = STR.process(template);
    //     System.out.println("   RAW template: " + processed);
    // }
    
    // private static void demonstrateKeyEncapsulationMechanism() throws Exception {
    //     System.out.println("\n--- Java 21: Key Encapsulation Mechanism (KEM) ---");
        
    //     System.out.println("   - Modern key encapsulation for secure communication");
    //     System.out.println("   - Post-quantum cryptography ready");
        
    //     // Simplified example (conceptual)
    //     // KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
    //     // KeyPair kp = kg.generateKeyPair();
        
    //     // // Sender encapsulates secret
    //     // KEM kemSender = KEM.getInstance("RSA-KEM");
    //     // KEM.Encapsulator e = kemSender.newEncapsulator(kp.getPublic());
    //     // KEM.Encapsulated enc = e.encapsulate();
        
    //     // // Receiver decapsulates
    //     // KEM kemReceiver = KEM.getInstance("RSA-KEM");
    //     // KEM.Decapsulator d = kemReceiver.newDecapsulator(kp.getPrivate());
    //     // byte[] secret = d.decapsulate(enc.encapsulation());
    // }
    
    // private static void demonstrateVectorAPIFinal() {
    //     System.out.println("\n--- Java 21: Vector API (Final) ---");
        
    //     System.out.println("   - Vector API is now final");
    //     System.out.println("   - SIMD operations for performance");
        
    //     // Conceptual example
    //     // float[] a = new float[1024];
    //     // float[] b = new float[1024];
    //     // float[] c = new float[1024];
        
    //     // var species = FloatVector.SPECIES_256;
        
    //     // for (int i = 0; i < a.length; i += species.length()) {
    //     //     var va = FloatVector.fromArray(species, a, i);
    //     //     var vb = FloatVector.fromArray(species, b, i);
    //     //     var vc = va.add(vb);
    //     //     vc.intoArray(c, i);
    //     // }
    // }
    
    // private static void demonstrateForeignFunctionMemoryAPIFinal() {
    //     System.out.println("\n--- Java 21: Foreign Function & Memory API (Final) ---");
        
    //     System.out.println("   - Final version of FFM API");
    //     System.out.println("   - Safe native memory access");
        
    //     // Allocate off-heap memory
    //     // try (Arena arena = Arena.openConfined()) {
    //     //     MemorySegment segment = arena.allocate(100);
    //     //     segment.set(ValueLayout.JAVA_INT, 0, 42);
    //     //     int value = segment.get(ValueLayout.JAVA_INT, 0);
    //     // }
        
    //     // Call C function
    //     // Linker linker = Linker.nativeLinker();
    //     // SymbolLookup stdlib = linker.defaultLookup();
    //     // MethodHandle strlen = linker.downcallHandle(
    //     //     stdlib.find("strlen").get(),
    //     //     FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
    //     // );
    // }
    
    // private static void demonstrateUnnamedPatterns() {
    //     System.out.println("\n--- Java 21: Unnamed Patterns (Preview) ---");
        
    //     record Point(int x, int y) {}
    //     record Line(Point start, Point end) {}
        
    //     Object obj = new Line(new Point(1, 2), new Point(3, 4));
        
    //     // Unnamed pattern with _
    //     if (obj instanceof Line(Point(var x1, var y1), _)) {
    //         System.out.println("   Start point: (" + x1 + "," + y1 + ")");
    //     }
        
    //     // Multiple unnamed patterns
    //     if (obj instanceof Line(_, Point(var x2, var y2))) {
    //         System.out.println("   End point: (" + x2 + "," + y2 + ")");
    //     }
        
    //     // In switch
    //     List<Object> items = List.of(
    //         new Point(5, 6),
    //         new Line(new Point(7, 8), new Point(9, 10))
    //     );
        
    //     for (Object item : items) {
    //         String desc = switch (item) {
    //             case Point(var x, var y) -> "Point at " + x + "," + y;
    //             case Line(Point(var x1, var y1), _) -> "Line from " + x1 + "," + y1;
    //             default -> "Unknown";
    //         };
    //         System.out.println("   " + desc);
    //     }
    // }
    
    // private static void demonstrateUnnamedVariables() {
    //     System.out.println("\n--- Java 21: Unnamed Variables (Preview) ---");
        
    //     // Unnamed variable in lambda
    //     map.entrySet().stream()
    //         .mapToInt(entry -> {
    //             // Only need value, not key
    //             var (_, value) = entry;
    //             return value;
    //         });
        
    //     // Unnamed in try-with-resources
    //     try (var _ = new Resource()) {
    //         System.out.println("   Resource ignored");
    //     } catch (Exception _) {
    //         System.out.println("   Exception ignored");
    //     }
        
    //     // Unnamed in catch
    //     try {
    //         throw new RuntimeException("Error");
    //     } catch (RuntimeException _) {
    //         System.out.println("   Caught but not using exception");
    //     }
        
    //     // Unnamed in for loop
    //     for (int i = 0, _ = expensiveComputation(); i < 10; i++) {
    //         System.out.print(" " + i);
    //     }
    //     System.out.println();
        
    //     // Multiple unnamed
    //     record Pair(int a, int b, int c) {}
    //     var pair = new Pair(1, 2, 3);
    //     var (first, _, _) = pair; // Only need first
    // }
    
    // private static int expensiveComputation() {
    //     return 42;
    // }
    
    // static class Resource implements AutoCloseable {
    //     public void close() {}
    // }
    
    // private static void demonstrateMainMethodEnhancement() {
    //     System.out.println("\n--- Java 21: Unnamed Classes and Instance Main (Preview) ---");
        
    //     System.out.println("   Simplified main method:");
    //     System.out.println("   // In Java 21, you can write:");
    //     System.out.println("   void main() {");
    //     System.out.println("       System.out.println(\"Hello\");");
    //     System.out.println("   }");
        
    //     // Traditional main still works
    //     System.out.println("   Traditional main still supported");
    // }
    
    // private static void demonstrateStructuredTaskScope() throws Exception {
    //     System.out.println("\n--- Java 21: StructuredTaskScope Enhancements ---");
        
    //     // Custom shutdown policy
    //     class CustomScope extends StructuredTaskScope<String> {
    //         private final List<String> results = new CopyOnWriteArrayList<>();
            
    //         @Override
    //         protected void handleComplete(Future<String> future) {
    //             if (future.state() == Future.State.SUCCESS) {
    //                 results.add(future.resultNow());
    //             }
    //         }
            
    //         public List<String> results() {
    //             return List.copyOf(results);
    //         }
    //     }
        
    //     try (var scope = new CustomScope()) {
    //         scope.fork(() -> {
    //             Thread.sleep(30);
    //             return "Task1";
    //         });
            
    //         scope.fork(() -> {
    //             Thread.sleep(10);
    //             return "Task2";
    //         });
            
    //         scope.fork(() -> {
    //             Thread.sleep(20);
    //             throw new RuntimeException("Failed");
    //         });
            
    //         scope.join();
            
    //         System.out.println("   Successful results: " + scope.results());
    //     }
    // }
    
    // private static void demonstrateMathClamp() {
    //     System.out.println("\n--- Java 21: Math.clamp() ---");
        
    //     // Clamp int values
    //     System.out.println("   clamp(5, 1, 10): " + Math.clamp(5, 1, 10));
    //     System.out.println("   clamp(0, 1, 10): " + Math.clamp(0, 1, 10));
    //     System.out.println("   clamp(15, 1, 10): " + Math.clamp(15, 1, 10));
        
    //     // Clamp long values
    //     System.out.println("   clamp(100L, 1L, 1000L): " + Math.clamp(100L, 1L, 1000L));
        
    //     // Clamp double values
    //     System.out.println("   clamp(3.14, 0.0, 1.0): " + Math.clamp(3.14, 0.0, 1.0));
    //     System.out.println("   clamp(0.5, 0.0, 1.0): " + Math.clamp(0.5, 0.0, 1.0));
        
    //     // Clamp float values
    //     System.out.println("   clamp(2.5f, 1.0f, 2.0f): " + Math.clamp(2.5f, 1.0f, 2.0f));
    // }
    
    // private static void demonstrateStringNewMethods21() {
    //     System.out.println("\n--- Java 21: String New Methods ---");
        
    //     String str = "Hello World";
        
    //     // indexOf with range
    //     int index = str.indexOf('o', 0, 5);
    //     System.out.println("   indexOf('o', 0, 5): " + index);
        
    //     // splitWithDelimiters
    //     String[] parts = str.splitWithDelimiters(" ", 0);
    //     System.out.println("   splitWithDelimiters: " + Arrays.toString(parts));
        
    //     // New repeat variants
    //     String repeated = str.repeat(2, 3); // Repeat 2 times with offset 3
    //     System.out.println("   repeat(2,3): " + repeated);
    // }
    
    // private static void demonstrateSequencedMap() {
    //     System.out.println("\n--- Java 21: SequencedMap ---");
        
    //     SequencedMap<String, Integer> map = new LinkedHashMap<>();
    //     map.put("A", 1);
    //     map.put("B", 2);
    //     map.put("C", 3);
        
    //     System.out.println("   Original map: " + map);
        
    //     // First and last entries
    //     System.out.println("   First entry: " + map.firstEntry());
    //     System.out.println("   Last entry: " + map.lastEntry());
        
    //     // Add at beginning
    //     map.putFirst("Z", 0);
    //     System.out.println("   After putFirst: " + map);
        
    //     // Add at end
    //     map.putLast("D", 4);
    //     System.out.println("   After putLast: " + map);
        
    //     // Remove from both ends
    //     Map.Entry<String, Integer> first = map.pollFirstEntry();
    //     Map.Entry<String, Integer> last = map.pollLastEntry();
    //     System.out.println("   Removed first: " + first + ", last: " + last);
    //     System.out.println("   After removal: " + map);
        
    //     // Reverse order
    //     SequencedMap<String, Integer> reversed = map.reversed();
    //     System.out.println("   Reversed: " + reversed);
    // }
    
    // private static void demonstrateSequencedSet() {
    //     System.out.println("\n--- Java 21: SequencedSet ---");
        
    //     SequencedSet<String> set = new LinkedHashSet<>();
    //     set.add("A");
    //     set.add("B");
    //     set.add("C");
        
    //     System.out.println("   Original set: " + set);
        
    //     // First and last elements
    //     System.out.println("   First: " + set.getFirst());
    //     System.out.println("   Last: " + set.getLast());
        
    //     // Add at beginning
    //     set.addFirst("Z");
    //     System.out.println("   After addFirst: " + set);
        
    //     // Add at end
    //     set.addLast("D");
    //     System.out.println("   After addLast: " + set);
        
    //     // Remove from both ends
    //     String first = set.removeFirst();
    //     String last = set.removeLast();
    //     System.out.println("   Removed first: " + first + ", last: " + last);
    //     System.out.println("   After removal: " + set);
        
    //     // Reverse order
    //     SequencedSet<String> reversed = set.reversed();
    //     System.out.println("   Reversed: " + reversed);
    // }
    
    // private static void demonstrateReverseOrderedCollection() {
    //     System.out.println("\n--- Java 21: Reverse Ordered Collection ---");
        
    //     // List - SequencedCollection
    //     List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));
    //     System.out.println("   List: " + list);
    //     System.out.println("   List reversed: " + list.reversed());
        
    //     // Deque - SequencedCollection
    //     Deque<String> deque = new ArrayDeque<>(List.of("1", "2", "3"));
    //     System.out.println("   Deque: " + deque);
    //     System.out.println("   Deque reversed: " + deque.reversed());
        
    //     // NavigableSet - SequencedSet
    //     NavigableSet<String> navSet = new TreeSet<>(List.of("X", "Y", "Z"));
    //     System.out.println("   NavigableSet: " + navSet);
    //     System.out.println("   NavigableSet descending: " + navSet.descendingSet());
        
    //     // SequencedMap reversed
    //     SequencedMap<String, Integer> seqMap = new LinkedHashMap<>();
    //     seqMap.put("A", 1);
    //     seqMap.put("B", 2);
    //     seqMap.put("C", 3);
    //     System.out.println("   SequencedMap reversed: " + seqMap.reversed());
    // }
}