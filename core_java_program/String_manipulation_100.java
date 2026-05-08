import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class String_manipulation_100 {
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        String str = "programming";
        String str2 = "listen";
        String str3 = "silent";
        List<String> strList = Arrays.asList("a", "bb", "ccc", "dd");

        // 1. Reverse the string
        // System.out.println("Reverse String --->" + reverseString(str));
        // 2. check Palindrom
        System.out.println("Reverse String --->" + isPalindrome("madam"));
        System.out.println("Reverse String --->" + isPalindrome(str2));
        // 3. check countCharacters
        System.out.println("Reverse String --->" + countCharacters(str));
        System.out.println("Reverse String --->" + countCharacters(str3));
        // 4. check GroupStringsbyLength
        System.out.println("GroupStringsbyLength String --->" + GroupStringsbyLength(strList));

        // Common Examples
        // "race" and "care"
        // "arc" and "car"
        // "heart" and "earth"
        // 5. check isAnagramSimple
        System.out.println(isAnagramSimple("listen", "silent")); // true
        // 6. check longestSubstring
        System.out.println("Longest Substring: " + longestSubstring("abcabcbb"));
        System.out.println("Longest Substring: " + longestSubstring(str));

        // 7. check longestSubstring
        System.out.println("First Non-Repeating: " + firstNonRepeating("aabbcde"));
        // 8. check longestSubstring
        System.out.println("Reverse Words: " + reverseWords("Java is awesome"));
         // 9. check longestSubstring
        System.out.println("String Compression: " + compress("aaabbc"));
          // 10. check myAtoi
        System.out.println("String to Integer: " + myAtoi(" -42"));
        System.out.println("Input: \"4193 with words\" -> " + myAtoi("4193 with words"));
        System.out.println("Input: \"-91283472332\" -> " + myAtoi("-91283472332"));
       // 11. check myAtoi
        System.out.println("Valid Parentheses: " + isValidParentheses("()[]{}"));
        System.out.println("Valid Parentheses: " + isValidParentheses("([]{}"));

    }

    public static String reverseString(String str) {
        if (str == null || str.isEmpty())
            return "";

        // Method-1 using for loop
        // String reversedString = "";
        // for (int i = str.length()-1; i >= 0; i--) {
        // reversedString += str.charAt(i);
        // }
        // return reversedString;

        // Method-2 using for StringBuilder and StringBuffer
        // return new StringBuilder(str).reverse().toString();
        // return new StringBuffer(str).reverse().toString();
        // Method-3
        // case-1 using reduce method // Complexity O(n2)

        // String rs = str.chars()
        // .mapToObj(c -> (char) c)
        // .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
        // return rs;

        // case -2 using stream of // Complexity O(n)
        // String rs= Stream.of(str)
        // .map(item-> new StringBuilder(item).reverse().toString())
        // .collect(Collectors.joining());
        // return rs;

        // case-3

        return IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - i - 1)) // Get char at reverse index
                .map(String::valueOf) // Convert char to String
                .collect(Collectors.joining()); // Join together
    }

    public static boolean isPalindrome(String str) {
        // Method-1
        // int left = 0, right = str.length() - 1;
        // while (left < right) {
        // if (str.charAt(left++) != str.charAt(right--))
        // return false;
        // }
        // return true;

        // Method-2
        // return str!= null && str.equals(new StringBuilder(str).reverse().toString());

        // Method-3
        return IntStream.range(0, str.length())
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }

    public static Map<Character, Long> countCharacters(String str) {

        // Method-1 HashMap
        // public static Map<Character, Integer> countCharacters(String str) {

        // Map<Character ,Integer> map=new HashMap<>();
        // for(char c: str.toCharArray()){
        // map.put(c,map.getOrDefault(c, 0) +1);
        // }
        // return map;

        // Method-2 Modern Method (Stream API)
        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c, // Function.identity(), // c->c
                        Collectors.counting()));

        return charCount;
    }

    public static Map<Integer, Long> GroupStringsbyLength(List<String> strList) {
        // Method-1
        // return strList.stream()
        // .collect(Collectors.groupingBy(
        // String::length,
        // Collectors.counting()));

        // Method-2
        Map<Integer, Long> result = new HashMap<>();
        for (String s : strList) {
            // Increment the count for this length; default to 0 if not present
            result.put(s.length(), result.getOrDefault(s.length(), 0L) + 1);
        }
        return result;
    }

    public static boolean isAnagramSimple(String s1, String s2) {
        // Method-1
        // // Step 1: Remove spaces and convert to lowercase for uniform comparison
        // s1 = s1.replaceAll("\\s", "").toLowerCase();
        // s2 = s2.replaceAll("\\s", "").toLowerCase();

        // // Step 2: If lengths differ, they can't be anagrams
        // if (s1.length() != s2.length()) return false;

        // // Step 3: Convert to char arrays and sort
        // char[] array1 = s1.toCharArray();
        // char[] array2 = s2.toCharArray();
        // Arrays.sort(array1);
        // Arrays.sort(array2);

        // // Step 4: Compare sorted arrays
        // return Arrays.equals(array1, array2);

        // Method-2

        // if (s1.length() != s2.length()) return false;

        // // Using 256 covers all standard ASCII characters safely
        // int[] count = new int[256];
        // for (int i = 0; i < s1.length(); i++) {
        // count[s1.charAt(i)]++;
        // count[s2.charAt(i)]--;
        // }
        // for (int c : count) {
        // if (c != 0) return false;
        // }
        // return true;

        // Method-3 Java Program (Stream Method)

        Map<Integer, Long> map1 = s1.toLowerCase().chars().boxed()
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()));
        Map<Integer, Long> map2 = s2.toLowerCase().chars().boxed()
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()));
        return map1.equals(map2);
    }

    // 5️⃣ Longest Substring Without Repeating Characters
    public static int longestSubstring(String s) {
        // Method-1 using set Method
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;

        // Method-2 using map Method retun count int value

        // if (s == null || s.length() == 0) return 0;

        // // Map to store the last seen index of each character
        // HashMap<Character, Integer> map = new HashMap<>();
        // int maxLength = 0;
        // int left = 0; // Left boundary of the window

        // for (int right = 0; right < s.length(); right++) {
        // char currentChar = s.charAt(right);

        // // If character is seen before, move left pointer to skip the duplicate
        // if (map.containsKey(currentChar)) {
        // // Ensure left pointer never moves backward
        // left = Math.max(left, map.get(currentChar) + 1);
        // }

        // // Update character's last seen index
        // map.put(currentChar, right);

        // // Calculate current window size and update max
        // maxLength = Math.max(maxLength, right - left + 1);
        // }

        // return maxLength;

        // Method-2 using map Method retun count string value // public static String
        // longestSubstring(String s)
        // if (s == null || s.length() == 0) return "";

        // HashMap<Character, Integer> map = new HashMap<>();
        // int maxLength = 0;
        // int left = 0;
        // int startOfBest = 0; // Tracks where the longest substring starts

        // for (int right = 0; right < s.length(); right++) {
        // char currentChar = s.charAt(right);

        // if (map.containsKey(currentChar)) {
        // left = Math.max(left, map.get(currentChar) + 1);
        // }

        // map.put(currentChar, right);

        // // If we find a new "longest", save its starting position
        // if (right - left + 1 > maxLength) {
        // maxLength = right - left + 1;
        // startOfBest = left;
        // }
        // }

        // // Return the actual string using start index and length
        // return s.substring(startOfBest, startOfBest + maxLength);

        // Method-2 using set Method retun count string value // public static String
        // longestSubstring(String s)

        // if (s == null || s.isEmpty()) return "";

        // Set<Character> set = new HashSet<>();
        // int left = 0, max = 0;
        // int startOfBest = 0; // To store the beginning of the longest word

        // for (int right = 0; right < s.length(); right++) {
        // // If we hit a duplicate, shrink the window from the left
        // while (set.contains(s.charAt(right))) {
        // set.remove(s.charAt(left++));
        // }

        // set.add(s.charAt(right));

        // // When a new record is found, save the length AND the start index
        // if (right - left + 1 > max) {
        // max = right - left + 1;
        // startOfBest = left;
        // }
        // }

        // // Return the actual substring using the saved start index and max length
        // return s.substring(startOfBest, startOfBest + max);
    }

    // 6️⃣ First Non-Repeating Character
    public static char firstNonRepeating(String s) {
        // Method-1 map method
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1)
                return c;
        }
        return '_'; // if not found

        // optional- if you wan to second non-repeating value ?

        // int countNonRepeating = 0;
        // // Pass 2: Iterate through keys (LinkedHashMap preserves order)
        // for (char c : map.keySet()) {
        // if (map.get(c) == 1) {
        // countNonRepeating++;
        // if (countNonRepeating == 2) {
        // return c;
        // }
        // }
        // }

        // Method-2 Stream api

        // return s.chars() // IntStream of characters
        // .mapToObj(c -> (char) c) // Convert to Stream<Character>
        // .collect(Collectors.groupingBy(
        // Function.identity(), // c->c
        // LinkedHashMap::new, // Keeps the order of characters!
        // Collectors.counting()
        // ))
        // .entrySet().stream()
        // .filter(entry -> entry.getValue() == 1)
        // .map(Map.Entry::getKey)
        // .skip(1) //optional find first // find second skip(1)
        // .findFirst() // Gets the first one that matched the filter
        // .orElse(null);
    }
// 7️⃣ Reverse Words in a String
public static String reverseWords(String s) {
    // Method-1
    // String[] words = s.trim().split("\\s+");
    // Collections.reverse(Arrays.asList(words));
    // return String.join(" ", words);

 // Method-2 stream api
    // return Arrays.stream(s.trim().split("\\s+"))
    //              .collect(Collectors.collectingAndThen(
    //                  Collectors.toList(),
    //                  list -> {
    //                      Collections.reverse(list);
    //                      return list.stream();
    //                  }
    //              ))
    //              .collect(Collectors.joining(" "));

                 // Split by one or more spaces and trim leading/trailing whitespace
    String[] words = s.trim().split("\\s+");
    StringBuilder reversed = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {
        reversed.append(words[i]);
        if (i != 0) reversed.append(" ");
    }

    return reversed.toString();
}

 // 8️⃣ String Compression (Run Length Encoding)
 public static String compress(String s) {
    // Method-1
    // StringBuilder result = new StringBuilder();
    // int count = 1;

    // for (int i = 1; i <= s.length(); i++) {
    //     if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
    //         count++;
    //     } else {
    //         result.append(s.charAt(i - 1)).append(count);
    //         count = 1;
    //     }
    // }
    // return result.toString();

    // Method-2

    return IntStream.range(0, s.length())
        .filter(i -> i == 0 || s.charAt(i) != s.charAt(i - 1))
        .mapToObj(i -> {
            int count = 1;
            while (i + count < s.length() && s.charAt(i) == s.charAt(i + count)) {
                count++;
            }
            return s.charAt(i) + String.valueOf(count);
        })
        .collect(Collectors.joining());
 }

// 9️⃣ String to Integer (atoi)
public static int myAtoi(String s) {
    s = s.trim();
    if (s.isEmpty()) return 0;

    int sign = 1, i = 0;
    long result = 0;

    if (s.charAt(0) == '-' || s.charAt(0) == '+') {
        sign = (s.charAt(0) == '-') ? -1 : 1;
        i++;
    }

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
        result = result * 10 + (s.charAt(i) - '0');

        if (result > Integer.MAX_VALUE)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        i++;
    }

    return (int) result * sign;
}

// 🔟 Valid Parentheses
public static boolean isValidParentheses(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } 
        else {
            if (stack.isEmpty()) return false;

            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == '}' && top != '{') ||
                (c == ']' && top != '[')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
}
