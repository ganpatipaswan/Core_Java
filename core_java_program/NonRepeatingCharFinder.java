import java.util.*;
import java.util.stream.Collectors;

public class NonRepeatingCharFinder {
    
    public static void main(String[] args) {
        // Test cases
        String[] testStrings = {
            "madam",        // First non-repeating: 'd'
            "hello",        // First non-repeating: 'h'
            "aabbcc",       // No non-repeating: null
            "java",         // First non-repeating: 'j'
            "programming",  // First non-repeating: 'p'
            "a"             // First non-repeating: 'a'
        };
        
        for (String test : testStrings) {
            Character result = findFirstNonRepeating(test);
            System.out.printf("'%s' → First non-repeating: %s%n", 
                             test, result == null ? "None" : "'" + result + "'");
        }
    }
    
    public static Character findFirstNonRepeating(String str) {
        return str.chars()                    // IntStream of ASCII
                  .mapToObj(c -> (char) c)     // Stream<Character>
                  .collect(Collectors.groupingBy(
                      c -> c,                   // Group by character
                      LinkedHashMap::new,        // Preserve order
                      Collectors.counting()      // Count occurrences
                  ))
                  .entrySet()                   // Set of entries
                  .stream()                      // Stream of entries
                  .filter(e -> e.getValue() == 1) // Keep count=1
                  .map(Map.Entry::getKey)        // Get the character
                  .findFirst()                   // First match
                  .orElse(null);                  // None found
    }
}

// output
// 'madam' → First non-repeating: 'd'
// 'hello' → First non-repeating: 'h'
// 'aabbcc' → First non-repeating: None
// 'java' → First non-repeating: 'j'
// 'programming' → First non-repeating: 'p'
// 'a' → First non-repeating: 'a'


// Online Java Compiler
// Use this editor to write, compile and run your Java code online

// import java.util.*;
// import java.util.stream.Collectors;

// public class Main {
//     public static void main(String[] args) {

//         String st = "madam";
//         for(char ch:st.toCharArray()){
//                   System.out.println(ch);
 
//         };
//         System.out.println(st.toCharArray());
//         // System.out.println(Arrays.toString(st.split("")));
// // Map<Character, Long> result = st.chars()
// //                 .mapToObj(c -> (char) c)
// //                 .collect(Collectors.groupingBy(
// //                         c -> c,
// //                         LinkedHashMap::new,   // Maintain insertion order
// //                         Collectors.counting()
// //                 ));

// // Set<Map.Entry<Character, Long>> result 
// // Set<Character> result= st.chars()
// //     .mapToObj(c -> (char) c)
// //     .collect(Collectors.groupingBy(
// //         c -> c,
// //         LinkedHashMap::new, 
// //         Collectors.counting()
// //     )) // NO semicolon here
// //     .entrySet()
// //     .stream()
// //     .filter(entry -> entry.getValue() == 1)
// //     .map(Map.Entry::getKey)
// //     .collect(Collectors.toSet());
    
//         Character result = st.chars()
//                 .mapToObj(c -> (char) c)
//                 .collect(Collectors.groupingBy(
//                         c -> c,
//                         LinkedHashMap::new,   // Maintain insertion order
//                         Collectors.counting()
//                 ))
//                 .entrySet()
//                 .stream()
//                 .filter(entry -> entry.getValue() == 1)
//                 .map(Map.Entry::getKey)
//                 .findFirst()
//                 .orElse(null);

//         System.out.println("Output: " + result);

//     }
// }