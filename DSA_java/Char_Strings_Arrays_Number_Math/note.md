
import java.util.*;

public class SecondHighest{
  public static void main (String[] args) {
    /* code */
    // Method-1
    // int[] arr = {12, 35, 34, 1, 10};
    // int SecondHighest=Integer.MIN_VALUE;
    // int Highest=Integer.MIN_VALUE;
    // for (int num: arr ){
    //   if (num >Highest) {
    //     SecondHighest=Highest;
    //     Highest=num;
    //   }
    //   else if (num>SecondHighest && num!= Highest) {
    //     SecondHighest=num;
    //   }
    // }
    // System.out.println(SecondHighest);
    
    // Method-2
    int[] arr1 = {12, 35, 34, 1, 10};
    int SecondNo = Arrays.stream(arr1)
    .boxed()
    .distinct()
    .sorted((a,b)->b-a) //.sorted(Collections.reverseOrder())//
    .skip(1)
    .findFirst()
    .orElseThrow(() -> new RuntimeException("No second highest found"));
    // .orElse(null);
    System.out.println("Second Highest: " + SecondNo);

  }
}

// public class SecondHighest {
//     public static int findSecondHighest(int[] arr) {
//         if (arr == null || arr.length < 2) {
//             throw new IllegalArgumentException("Array must have at least 2 elements");
//         }
        
//         int highest = Integer.MIN_VALUE;
//         int secondHighest = Integer.MIN_VALUE;
        
//         for (int num : arr) {
//             if (num > highest) {
//                 secondHighest = highest;
//                 highest = num;
//             } 
//             else if (num > secondHighest && num != highest) {
//                 secondHighest = num;
//             }
//         }
        
//         if (secondHighest == Integer.MIN_VALUE) {
//             throw new RuntimeException("No second highest element found");
//         }
        
//         return secondHighest;
//     }
    
//     public static void main(String[] args) {
//         int[] arr = {12, 35, 34, 1, 10};
//         System.out.println("Second Highest: " + findSecondHighest(arr));
//     }
// }
// import java.util.*;

// public class ReverseArrayCollections {
//     // public static void reverse(Integer[] arr) {
//     //     Collections.reverse(Arrays.asList(arr));
//     // }
    
//     public static void main(String[] args) {
//         Integer[] arr = {1, 2, 3, 4, 5};
        
//         System.out.print("Original: ");
//         System.out.println(Arrays.toString(arr));
        
//         // reverse(arr);
//         Collections.reverse(Arrays.asList(arr));
//         System.out.print("Reversed: ");
//         System.out.println(Arrays.toString(arr));
//     }
// }




// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.stream.Collectors;

public class CompleteFirstNonRepeating {
    
    // Method 1: HashMap (Best for general use)
    public static Character method1HashMap(String str) {
        if (str == null || str.isEmpty()) return null;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return null;
    }
    
    // Method 2: Array (Fastest for ASCII)
    public static Character method2Array(String str) {
        if (str == null || str.isEmpty()) return null;
        
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) return str.charAt(i);
        }
        return null;
    }
    
    // Method 3: LinkedHashMap (Maintains order)
    public static Character method3LinkedHashMap(String str) {
        if (str == null || str.isEmpty()) return null;
        
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return null;
    }
    
    // Method 4: Using indexOf/lastIndexOf (No extra space)
    public static Character method4IndexOf(String str) {
        if (str == null || str.isEmpty()) return null;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) return c;
        }
        return null;
    }
    
    // // Method 5: Using Stream API
    public static Character method5Stream(String str) {
        if (str == null || str.isEmpty()) return null;
        
        return str.chars()
                .mapToObj(c -> (char) c)
               .collect(
                 Collectors.groupingBy(
                    c->c,//Function.identity(), //c->c,
                    LinkedHashMap::new,
                    Collectors.counting()
                  )
                 )
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "swiss",           // w
            "aabbcc",          // null
            "loveleetcode",    // l
            "aabccdde",        // e
            "aaabccc",         // b
            "racecar",         // e
            "abca",            // b
            "aabb",            // null
            "a",               // a
            "",                // null
            null,              // null
            "geeksforgeeks"    // f
        };
        
        System.out.println("=== First Non-Repeating Character ===\n");
        System.out.println("String\t\t\t\tResult");
        System.out.println("------\t\t\t\t------");
        
        for (String test : testCases) {
            Character result = method1HashMap(test);
            // Character result = method2Array(test);
            // Character result = method4IndexOf(test);
            // Character result = method1HashMap(test);
            // Character result = method1HashMap(test);
            System.out.printf("%-20s → %s%n", 
                test != null ? test : "null", 
                result != null ? result : "none");
      
        }
        // Performance comparison
        System.out.println("\n=== Performance Comparison ===");
        String largeString = "a".repeat(100000) + "b";
        
        long start = System.nanoTime();
        method1HashMap(largeString);
        long time1 = System.nanoTime() - start;
        
        start = System.nanoTime();
        method2Array(largeString);
        long time2 = System.nanoTime() - start;
        
        start = System.nanoTime();
        method4IndexOf(largeString);
        long time3 = System.nanoTime() - start;
        
       
        System.out.println("HashMap: " + time1/1000 + " μs");
        System.out.println("Array: " + time2/1000 + " μs");
        System.out.println("indexOf: " + time3/1000 + " μs");
    }
}