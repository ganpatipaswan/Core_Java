package Char_Strings_Arrays_Number_Math;

import java.util.*;
import java.util.stream.Collectors;

public class String15Problems {
    
    // ==================== 1. REVERSE STRING ====================
    /**
     * Time: O(n), Space: O(n) for char array
     * Interview Tip: Mention in-place using StringBuilder or char array
     */
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) return str;
        
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    // Alternative: Using StringBuilder (Most practical)
    public static String reverseStringSB(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Alternative: Recursive (Demonstrate thinking)
    public static String reverseStringRecursive(String str) {
        if (str.isEmpty()) return str;
        return reverseStringRecursive(str.substring(1)) + str.charAt(0);
    }
    
    // ==================== 2. PALINDROME CHECK ====================
    /**
     * Time: O(n), Space: O(1)
     * Interview Tip: Two-pointer approach, mention ignoring case/special chars
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) return true;
        
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric if needed
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) right--;
            
            if (Character.toLowerCase(str.charAt(left)) != 
                Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // For exact palindrome (without ignoring special chars)
    public static boolean isPalindromeSimple(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    // ==================== 3. COUNT VOWELS ====================
    /**
     * Time: O(n), Space: O(1)
     * Interview Tip: Use HashSet for O(1) lookup or switch-case
     */
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) return 0;
        
        int count = 0;
        String vowels = "aeiouAEIOU";
        
        for (char ch : str.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
    
    // More efficient with Set
    public static int countVowelsOptimized(String str) {
        if (str == null || str.isEmpty()) return 0;
        
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int count = 0;
        
        for (char ch : str.toCharArray()) {
            if (vowels.contains(ch)) count++;
        }
        return count;
    }
    
    // Using Stream API
    public static long countVowelsStream(String str) {
        return str.chars()
                 .mapToObj(ch -> (char) ch)
                 .filter(ch -> "aeiouAEIOU".indexOf(ch) != -1)
                 .count();
    }
    
    // ==================== 4. ANAGRAM CHECK ====================
    /**
     * Time: O(n), Space: O(1) - fixed 26 characters
     * Interview Tip: Multiple approaches - sorting vs frequency array
     */
    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        
        // Using frequency array (most efficient)
        int[] freq = new int[26];
        
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        for (char ch : s2.toCharArray()) {
            freq[ch - 'a']--;
        }
        
        for (int count : freq) {
            if (count != 0) return false;
        }
        
        return true;
    }
    
    // Sorting approach (simpler but O(n log n))
    public static boolean isAnagramSort(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
    
    // Unicode compatible (using HashMap)
    public static boolean isAnagramUnicode(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : s2.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) map.remove(ch);
        }
        
        return map.isEmpty();
    }
    
    // ==================== 5. REMOVE DUPLICATES ====================
    /**
     * Time: O(n), Space: O(n)
     * Interview Tip: Maintain order using LinkedHashSet
     */
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) return str;
        
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (seen.add(ch)) {  // add() returns false if already present
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    // Using boolean array for ASCII
    public static String removeDuplicatesASCII(String str) {
        boolean[] seen = new boolean[256];
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    // Using Stream API
    public static String removeDuplicatesStream(String str) {
        return str.chars()
                 .distinct()
                 .mapToObj(ch -> String.valueOf((char) ch))
                 .collect(Collectors.joining());
    }
    
    // ==================== 6. FIRST NON-REPEATING CHARACTER ====================
    /**
     * Time: O(n), Space: O(1) - fixed 26 or 256
     * Interview Tip: Two-pass solution, mention LinkedHashMap for one-pass
     */
    public static char firstNonRepeatingChar(String str) {
        if (str == null || str.isEmpty()) return '\0';
        
        int[] freq = new int[256];
        
        // First pass: count frequencies
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }
        
        // Second pass: find first non-repeating
        for (char ch : str.toCharArray()) {
            if (freq[ch] == 1) {
                return ch;
            }
        }
        
        return '\0'; // No non-repeating character
    }
    
    // One-pass using LinkedHashMap (maintains insertion order)
    public static char firstNonRepeatingCharOnePass(String str) {
        if (str == null || str.isEmpty()) return '\0';
        
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        
        for (char ch : str.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return '\0';
    }
    
    // ==================== 7. LONGEST SUBSTRING WITHOUT REPEATING CHARS ====================
    /**
     * Time: O(n), Space: O(min(m, n)) where m is charset size
     * Interview Tip: Sliding window with HashMap
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            
            if (charIndex.containsKey(current)) {
                // Move left pointer to max of current left and next position after last occurrence
                left = Math.max(left, charIndex.get(current) + 1);
            }
            
            charIndex.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Return the actual substring
    public static String longestSubstringWithoutRepeating(String s) {
        if (s == null || s.isEmpty()) return "";
        
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            
            if (charIndex.containsKey(current)) {
                left = Math.max(left, charIndex.get(current) + 1);
            }
            
            charIndex.put(current, right);
            
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    // ==================== 8. LONGEST PALINDROMIC SUBSTRING ====================
    /**
     * Time: O(n²), Space: O(1)
     * Interview Tip: Expand around center approach (2n-1 centers)
     * Mention DP approach and Manacher's algorithm for O(n)
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of palindrome
    }
    
    // DP Approach (O(n²) time, O(n²) space)
    public static String longestPalindromeDP(String s) {
        if (s == null || s.length() < 2) return s;
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        // Check substrings of length > 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    // ==================== 9. GROUP ANAGRAMS ====================
    /**
     * Time: O(n * k log k) where n = number of strings, k = max length
     * Space: O(n * k)
     * Interview Tip: Use sorted string as key or character frequency as key
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort characters to create key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    // Optimized: Using character count as key (O(n * k))
    public static List<List<String>> groupAnagramsOptimized(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            
            // Create key from frequency array
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append('#').append(count[i]);
            }
            
            String keyStr = key.toString();
            map.computeIfAbsent(keyStr, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    // ==================== 10. STRING COMPRESSION ====================
    /**
     * Time: O(n), Space: O(n) for result
     * Interview Tip: In-place for char array, handle single digits vs multiple
     */
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) return str;
        
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < str.length(); i++) {
            // If next char is different or end of string
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 1;
            } else {
                count++;
            }
        }
        
        // Return compressed only if it's shorter than original
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
    
    // In-place compression (returns new length)
    public static int compressInPlace(char[] chars) {
        int index = 0; // Position to write
        int i = 0;     // Position to read
        
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            
            // Count consecutive characters
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }
            
            // Write character
            chars[index++] = current;
            
            // Write count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        
        return index;
    }
    
    // ==================== 11. IMPLEMENT strStr() ====================
    /**
     * Time: O(n * m) for naive, O(n + m) for KMP
     * Space: O(1) for naive, O(m) for KMP
     * Interview Tip: Start with naive, then optimize to KMP if asked
     */
    
    // Naive Approach
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.length() < needle.length()) return -1;
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
    
    // KMP Algorithm (Knuth-Morris-Pratt)
    public static int strStrKMP(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        // Build LPS (Longest Proper Prefix which is also Suffix) array
        int[] lps = computeLPSArray(needle);
        
        int i = 0; // Index for haystack
        int j = 0; // Index for needle
        
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            
            if (j == needle.length()) {
                return i - j; // Pattern found
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return -1;
    }
    
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
    
    // ==================== 12. ROMAN TO INTEGER ====================
    /**
     * Time: O(n), Space: O(1)
     * Interview Tip: Process from right to left or use map
     */
    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        int prev = 0;
        
        // Process from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanMap.get(s.charAt(i));
            
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            
            prev = current;
        }
        
        return result;
    }
    
    // ==================== 13. INTEGER TO ROMAN ====================
    /**
     * Time: O(1), Space: O(1)
     * Interview Tip: Use arrays for mapping, process from largest to smallest
     */
    public static String intToRoman(int num) {
        if (num <= 0 || num > 3999) return "";
        
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return result.toString();
    }
    
    // ==================== 14. VALID PARENTHESES ====================
    /**
     * Time: O(n), Space: O(n)
     * Interview Tip: Stack approach, mention all types of brackets
     */
    public static boolean isValidParentheses(String s) {
        if (s == null || s.isEmpty()) return true;
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        
        for (char ch : s.toCharArray()) {
            // If it's a closing bracket
            if (bracketMap.containsKey(ch)) {
                // Get the top element, if stack is empty use dummy character
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                
                // If mapping doesn't match, return false
                if (topElement != bracketMap.get(ch)) {
                    return false;
                }
            } else {
                // It's an opening bracket, push to stack
                stack.push(ch);
            }
        }
        
        // Stack should be empty if all brackets matched
        return stack.isEmpty();
    }
    
    // Alternative implementation with switch-case
    public static boolean isValidParenthesesSwitch(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    // Ignore other characters if needed
                    break;
            }
        }
        
        return stack.isEmpty();
    }
    
    // ==================== 15. MINIMUM WINDOW SUBSTRING ====================
    /**
     * Time: O(|S| + |T|), Space: O(|S| + |T|)
     * Interview Tip: Sliding window with two pointers, one of the hardest string problems
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        
        int required = targetMap.size();
        int formed = 0;
        
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            // Check if current character completes a required character count
            if (targetMap.containsKey(c) && 
                windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }
            
            // Try to contract window from left
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // Remove leftmost character
                windowMap.put(c, windowMap.get(c) - 1);
                if (targetMap.containsKey(c) && 
                    windowMap.get(c).intValue() < targetMap.get(c).intValue()) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    
    // Optimized using array for ASCII (faster for interviews)
    public static String minWindowOptimized(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        
        int[] target = new int[128];
        int[] window = new int[128];
        
        for (char ch : t.toCharArray()) {
            target[ch]++;
        }
        
        int left = 0, right = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int required = 0;
        
        // Count unique chars in target
        for (int count : target) {
            if (count > 0) required++;
        }
        
        int formed = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            
            if (target[c] > 0 && window[c] == target[c]) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                window[c]--;
                if (target[c] > 0 && window[c] < target[c]) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    
    // ==================== MAIN METHOD ====================
    public static void main(String[] args) {
        System.out.println("========== STRING ALGORITHMS DEMONSTRATION ==========\n");
        
        // Test Case 1: Reverse String
        System.out.println("1. REVERSE STRING");
        System.out.println("Input: 'Hello World'");
        System.out.println("Output: " + reverseString("Hello World"));
        System.out.println("(SB): " + reverseStringSB("Hello World"));
        System.out.println();
        
        // Test Case 2: Palindrome Check
        System.out.println("2. PALINDROME CHECK");
        System.out.println("'A man, a plan, a canal: Panama' -> " + 
                          isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("'racecar' -> " + isPalindromeSimple("racecar"));
        System.out.println("'hello' -> " + isPalindromeSimple("hello"));
        System.out.println();
        
        // Test Case 3: Count Vowels
        System.out.println("3. COUNT VOWELS");
        System.out.println("'Hello World' -> " + countVowels("Hello World"));
        System.out.println("'Beautiful' -> " + countVowelsOptimized("Beautiful"));
        System.out.println();
        
        // Test Case 4: Anagram Check
        System.out.println("4. ANAGRAM CHECK");
        System.out.println("'listen', 'silent' -> " + isAnagram("listen", "silent"));
        System.out.println("'hello', 'world' -> " + isAnagram("hello", "world"));
        System.out.println();
        
        // Test Case 5: Remove Duplicates
        System.out.println("5. REMOVE DUPLICATES");
        System.out.println("'programming' -> " + removeDuplicates("programming"));
        System.out.println("'hello world' -> " + removeDuplicatesStream("hello world"));
        System.out.println();
        
        // Test Case 6: First Non-Repeating Character
        System.out.println("6. FIRST NON-REPEATING CHARACTER");
        System.out.println("'leetcode' -> " + firstNonRepeatingChar("leetcode"));
        System.out.println("'aabbcc' -> " + firstNonRepeatingCharOnePass("aabbcc"));
        System.out.println();
        
        // Test Case 7: Longest Substring Without Repeating
        System.out.println("7. LONGEST SUBSTRING WITHOUT REPEATING");
        System.out.println("'abcabcbb' -> " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("'pwwkew' -> " + longestSubstringWithoutRepeating("pwwkew"));
        System.out.println();
        
        // Test Case 8: Longest Palindromic Substring
        System.out.println("8. LONGEST PALINDROMIC SUBSTRING");
        System.out.println("'babad' -> " + longestPalindrome("babad"));
        System.out.println("'cbbd' -> " + longestPalindrome("cbbd"));
        System.out.println();
        
        // Test Case 9: Group Anagrams
        System.out.println("9. GROUP ANAGRAMS");
        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(anagrams));
        System.out.println("Output: " + groupAnagrams(anagrams));
        System.out.println();
        
        // Test Case 10: String Compression
        System.out.println("10. STRING COMPRESSION");
        System.out.println("'aabcccccaaa' -> " + compressString("aabcccccaaa"));
        System.out.println("'abcd' -> " + compressString("abcd"));
        System.out.println();
        
        // Test Case 11: Implement strStr()
        System.out.println("11. IMPLEMENT strStr()");
        System.out.println("'hello', 'll' -> " + strStr("hello", "ll"));
        System.out.println("'aaaaa', 'bba' -> " + strStrKMP("aaaaa", "bba"));
        System.out.println();
        
        // Test Case 12: Roman to Integer
        System.out.println("12. ROMAN TO INTEGER");
        System.out.println("'III' -> " + romanToInt("III"));
        System.out.println("'MCMXCIV' -> " + romanToInt("MCMXCIV"));
        System.out.println();
        
        // Test Case 13: Integer to Roman
        System.out.println("13. INTEGER TO ROMAN");
        System.out.println("1994 -> " + intToRoman(1994));
        System.out.println("58 -> " + intToRoman(58));
        System.out.println();
        
        // Test Case 14: Valid Parentheses
        System.out.println("14. VALID PARENTHESES");
        System.out.println("'()[]{}' -> " + isValidParentheses("()[]{}"));
        System.out.println("'([)]' -> " + isValidParenthesesSwitch("([)]"));
        System.out.println("'{[]}' -> " + isValidParentheses("{[]}"));
        System.out.println();
        
        // Test Case 15: Minimum Window Substring
        System.out.println("15. MINIMUM WINDOW SUBSTRING");
        System.out.println("s='ADOBECODEBANC', t='ABC' -> " + 
                          minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("s='a', t='aa' -> " + 
                          minWindowOptimized("a", "aa"));
        
        System.out.println("\n========== ALL STRING PROBLEMS DEMONSTRATED ==========");
    }
}