
    import java.util.*;
    import java.util.stream.*;
    
    public class mapTo_Methods {
        
        public static void main(String[] args) {
            System.out.println("=".repeat(60));
            System.out.println("mapToInt() EXAMPLES");
            System.out.println("=".repeat(60));
            
            List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
            
            // Example 1: Get length of each string
            System.out.println("\n1. Get length of each string:");
            IntStream lengths = words.stream().mapToInt(String::length);
            lengths.forEach(len -> System.out.print(len + " "));
            // Output: 5 6 6 4 9
            
            // Example 2: Calculate sum of all lengths
            System.out.println("\n\n2. Sum of all lengths:");
            int totalLength = words.stream()
                .mapToInt(String::length)
                .sum();
            System.out.println("Total length: " + totalLength); // 30
            
            // Example 3: Find average length
            System.out.println("\n3. Average length:");
            OptionalDouble avgLength = words.stream()
                .mapToInt(String::length)
                .average();
            System.out.println("Average: " + avgLength.orElse(0)); // 6.0
            
            // Example 4: Get statistics
            System.out.println("\n4. Length statistics:");
            IntSummaryStatistics stats = words.stream()
                .mapToInt(String::length)
                .summaryStatistics();
            System.out.println(stats);
            
            // Example 5: Convert objects to integers based on custom logic
            System.out.println("\n5. Custom mapping - extract numeric values:");
            List<String> mixed = Arrays.asList("abc123", "def456", "ghi789");
            mixed.stream()
                .mapToInt(s -> Integer.parseInt(s.replaceAll("[^0-9]", "")))
                .forEach(n -> System.out.print(n + " "));
            // Output: 123 456 789
            
            // Example 6: Find maximum length
            System.out.println("\n\n6. Maximum length:");
            OptionalInt maxLength = words.stream()
                .mapToInt(String::length)
                .max();
            System.out.println("Max: " + maxLength.orElse(0)); // 9
        }
    }



//     import java.util.*;
// import java.util.stream.*;

// public class MapToLongExamples {
    
//     public static void main(String[] args) {
//         System.out.println("=".repeat(60));
//         System.out.println("mapToLong() EXAMPLES");
//         System.out.println("=".repeat(60));
        
//         List<String> numbers = Arrays.asList("1000000", "2000000", "3000000", "4000000");
        
//         // Example 1: Parse strings to long
//         System.out.println("\n1. Parse strings to long:");
//         LongStream longStream = numbers.stream().mapToLong(Long::parseLong);
//         longStream.forEach(n -> System.out.print(n + " "));
//         // Output: 1000000 2000000 3000000 4000000
        
//         // Example 2: Calculate sum of large numbers
//         System.out.println("\n\n2. Sum of large numbers:");
//         long sum = numbers.stream()
//             .mapToLong(Long::parseLong)
//             .sum();
//         System.out.println("Sum: " + sum); // 10000000
        
//         // Example 3: Nano time measurements
//         System.out.println("\n3. Time measurements in nanoseconds:");
//         List<Runnable> tasks = Arrays.asList(
//             () -> { for(int i=0; i<1000; i++); },
//             () -> { for(int i=0; i<2000; i++); },
//             () -> { for(int i=0; i<3000; i++); }
//         );
        
//         LongStream times = tasks.stream().mapToLong(task -> {
//             long start = System.nanoTime();
//             task.run();
//             return System.nanoTime() - start;
//         });
        
//         times.forEach(t -> System.out.print(t + " "));
        
//         // Example 4: File sizes
//         System.out.println("\n\n4. File sizes in bytes:");
//         List<java.io.File> files = Arrays.asList(
//             new java.io.File("file1.txt"),
//             new java.io.File("file2.txt"),
//             new java.io.File("file3.txt")
//         );
        
//         // Note: This is just an example - files may not exist
//         files.stream()
//             .mapToLong(java.io.File::length)
//             .forEach(size -> System.out.print(size + " "));
//     }
// }


// import java.util.*;
// import java.util.stream.*;

// public class MapToDoubleExamples {
    
//     public static void main(String[] args) {
//         System.out.println("=".repeat(60));
//         System.out.println("mapToDouble() EXAMPLES");
//         System.out.println("=".repeat(60));
        
//         List<Product> products = Arrays.asList(
//             new Product("Laptop", 999.99),
//             new Product("Mouse", 29.99),
//             new Product("Keyboard", 79.99),
//             new Product("Monitor", 299.99)
//         );
        
//         // Example 1: Extract prices
//         System.out.println("\n1. Extract prices:");
//         DoubleStream prices = products.stream().mapToDouble(Product::getPrice);
//         prices.forEach(p -> System.out.print("$" + p + " "));
//         // Output: $999.99 $29.99 $79.99 $299.99
        
//         // Example 2: Calculate total price
//         System.out.println("\n\n2. Total price:");
//         double total = products.stream()
//             .mapToDouble(Product::getPrice)
//             .sum();
//         System.out.printf("Total: $%.2f%n", total); // $1409.96
        
//         // Example 3: Calculate average price
//         System.out.println("\n3. Average price:");
//         OptionalDouble avg = products.stream()
//             .mapToDouble(Product::getPrice)
//             .average();
//         System.out.printf("Average: $%.2f%n", avg.orElse(0)); // $352.49
        
//         // Example 4: Apply discount
//         System.out.println("\n4. Apply 10% discount:");
//         products.stream()
//             .mapToDouble(p -> p.getPrice() * 0.9)
//             .forEach(p -> System.out.printf("$%.2f ", p));
        
//         // Example 5: Statistics
//         System.out.println("\n\n5. Price statistics:");
//         DoubleSummaryStatistics stats = products.stream()
//             .mapToDouble(Product::getPrice)
//             .summaryStatistics();
//         System.out.println(stats);
        
//         // Example 6: Find expensive products
//         System.out.println("\n6. Products over $100:");
//         products.stream()
//             .filter(p -> p.getPrice() > 100)
//             .mapToDouble(Product::getPrice)
//             .forEach(p -> System.out.printf("$%.2f ", p));
//         // Output: $999.99 $299.99
//     }
    
//     static class Product {
//         private String name;
//         private double price;
        
//         Product(String name, double price) {
//             this.name = name;
//             this.price = price;
//         }
        
//         public double getPrice() { return price; }
//         public String getName() { return name; }
//     }
// }




// import java.util.*;
// import java.util.stream.*;

// public class MapToObjExamples {
    
//     public static void main(String[] args) {
//         System.out.println("=".repeat(60));
//         System.out.println("mapToObj() EXAMPLES");
//         System.out.println("=".repeat(60));
        
//         // Example 1: Convert int to string
//         System.out.println("\n1. Convert int to string:");
//         IntStream.range(1, 6)
//             .mapToObj(i -> "Number " + i)
//             .forEach(System.out::println);
//         /*
//         Number 1
//         Number 2
//         Number 3
//         Number 4
//         Number 5
//         */
        
//         // Example 2: Create objects from primitives
//         System.out.println("\n2. Create Person objects from ints:");
//         List<Person> people = IntStream.rangeClosed(1, 3)
//             .mapToObj(i -> new Person("Person" + i, 20 + i))
//             .collect(Collectors.toList());
//         people.forEach(System.out::println);
//         /*
//         Person{name='Person1', age=21}
//         Person{name='Person2', age=22}
//         Person{name='Person3', age=23}
//         */
        
//         // Example 3: Generate ASCII characters
//         System.out.println("\n3. ASCII characters from 65 to 70:");
//         IntStream.rangeClosed(65, 70)
//             .mapToObj(c -> (char) c)
//             .forEach(ch -> System.out.print(ch + " "));
//         // Output: A B C D E F
        
//         // Example 4: Create array of strings
//         System.out.println("\n\n4. Create array of strings from ints:");
//         String[] strArray = IntStream.range(0, 5)
//             .mapToObj(i -> "Item " + i)
//             .toArray(String[]::new);
//         System.out.println(Arrays.toString(strArray));
//         // Output: [Item 0, Item 1, Item 2, Item 3, Item 4]
        
//         // Example 5: Boxed() is a specialized version of mapToObj
//         System.out.println("\n5. boxed() vs mapToObj:");
//         List<Integer> boxed1 = IntStream.range(1, 5).boxed().collect(Collectors.toList());
//         List<Integer> boxed2 = IntStream.range(1, 5).mapToObj(Integer::valueOf).collect(Collectors.toList());
//         System.out.println("boxed(): " + boxed1);
//         System.out.println("mapToObj: " + boxed2);
//         // Both output: [1, 2, 3, 4]
        
//         // Example 6: Create custom formatting
//         System.out.println("\n6. Custom formatting with mapToObj:");
//         IntStream.range(0, 5)
//             .mapToObj(i -> {
//                 String stars = "*".repeat(i + 1);
//                 return String.format("%d: %s", i, stars);
//             })
//             .forEach(System.out::println);
//         /*
//         0: *
//         1: **
//         2: ***
//         3: ****
//         4: *****
//         */
//     }
    
//     static class Person {
//         String name;
//         int age;
        
//         Person(String name, int age) {
//             this.name = name;
//             this.age = age;
//         }
        
//         @Override
//         public String toString() {
//             return String.format("Person{name='%s', age=%d}", name, age);
//         }
//     }
// }






// import java.util.*;
// import java.util.stream.*;

// public class StudentGradeAnalysis {
    
//     static class Student {
//         String name;
//         int score;
        
//         Student(String name, int score) {
//             this.name = name;
//             this.score = score;
//         }
        
//         public int getScore() { return score; }
//         public String getName() { return name; }
        
//         @Override
//         public String toString() {
//             return name + "(" + score + ")";
//         }
//     }
    
//     public static void main(String[] args) {
//         List<Student> students = Arrays.asList(
//             new Student("Alice", 85),
//             new Student("Bob", 92),
//             new Student("Charlie", 78),
//             new Student("Diana", 95),
//             new Student("Eve", 88)
//         );
        
//         System.out.println("Students: " + students);
        
//         // Using mapToInt for statistics
//         System.out.println("\n--- Using mapToInt() ---");
//         IntSummaryStatistics stats = students.stream()
//             .mapToInt(Student::getScore)
//             .summaryStatistics();
        
//         System.out.println("Score Statistics:");
//         System.out.println("  Count: " + stats.getCount());
//         System.out.println("  Sum: " + stats.getSum());
//         System.out.println("  Min: " + stats.getMin());
//         System.out.println("  Max: " + stats.getMax());
//         System.out.println("  Average: " + stats.getAverage());
        
//         // Using mapToDouble for percentage calculations
//         System.out.println("\n--- Using mapToDouble() ---");
//         students.stream()
//             .mapToDouble(s -> (s.getScore() / 100.0) * 100)
//             .mapToObj(p -> String.format("Percentage: %.1f%%", p))
//             .forEach(System.out::println);
        
//         // Using mapToLong for hypothetical population projection
//         System.out.println("\n--- Using mapToLong() ---");
//         students.stream()
//             .mapToLong(s -> s.getScore() * 1000000L)
//             .forEach(p -> System.out.println("Population projection: " + p));
        
//         // Using mapToObj to create grade letters
//         System.out.println("\n--- Using mapToObj() for grades ---");
//         List<String> grades = students.stream()
//             .mapToInt(Student::getScore)
//             .mapToObj(score -> {
//                 if (score >= 90) return "A";
//                 else if (score >= 80) return "B";
//                 else if (score >= 70) return "C";
//                 else return "F";
//             })
//             .collect(Collectors.toList());
        
//         System.out.println("Grades: " + grades);
        
//         // Combine all mapTo methods
//         System.out.println("\n--- Combined Analysis ---");
//         students.stream()
//             .peek(s -> System.out.println("Processing: " + s))
//             .mapToInt(Student::getScore)
//             .mapToObj(score -> {
//                 String grade = score >= 90 ? "A" : 
//                                score >= 80 ? "B" : "C";
//                 return new AbstractMap.SimpleEntry<>(grade, score);
//             })
//             .forEach(entry -> 
//                 System.out.println("Grade: " + entry.getKey() + 
//                                  ", Score: " + entry.getValue()));
//     }
// }




// import java.util.*;
// import java.util.stream.*;

// public class MapToPerformance {
    
//     public static void main(String[] args) {
//         List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
//             .boxed()
//             .collect(Collectors.toList());
        
//         // Using Stream<Integer> - with boxing
//         System.out.println("Using Stream<Integer> (with boxing):");
//         long start = System.currentTimeMillis();
//         long sum1 = numbers.stream()
//             .mapToInt(Integer::intValue)
//             .sum();
//         long time1 = System.currentTimeMillis() - start;
//         System.out.println("  Sum: " + sum1);
//         System.out.println("  Time: " + time1 + "ms");
        
//         // Using IntStream directly - no boxing
//         System.out.println("\nUsing IntStream directly (no boxing):");
//         start = System.currentTimeMillis();
//         long sum2 = IntStream.rangeClosed(1, 10_000_000)
//             .sum();
//         long time2 = System.currentTimeMillis() - start;
//         System.out.println("  Sum: " + sum2);
//         System.out.println("  Time: " + time2 + "ms");
        
//         System.out.println("\n✅ mapToInt() helps avoid boxing overhead!");
//     }
// }