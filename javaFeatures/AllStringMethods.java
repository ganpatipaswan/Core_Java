/**
 * Program to demonstrate all String class methods in Java
 * This program shows the purpose and usage of each String method
 */
public class AllStringMethods {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(100));
        System.out.println("COMPREHENSIVE DEMONSTRATION OF STRING CLASS METHODS");
        System.out.println("=".repeat(100));
        
        // 1. String Constructors
        demonstrateConstructors();
        
        // 2. Length and Empty Checks
        demonstrateLengthMethods();
        
        // 3. Character Access Methods
        demonstrateCharAccess();
        
        // 4. Comparison Methods
        demonstrateComparisonMethods();
        
        // 5. Search Methods
        demonstrateSearchMethods();
        
        // 6. Substring Methods
        demonstrateSubstringMethods();
        
        // 7. Case Conversion Methods
        demonstrateCaseMethods();
        
        // 8. Trimming and Stripping Methods
        demonstrateTrimMethods();
        
        // 9. Replacement Methods
        demonstrateReplacementMethods();
        
        // 10. Concatenation and Join Methods
        demonstrateConcatenationMethods();
        
        // 11. Format Methods
        demonstrateFormatMethods();
        
        // 12. Conversion Methods
        demonstrateConversionMethods();
        
        // 13. Regular Expression Methods
        demonstrateRegexMethods();
        
        // 14. String Pool/Intern Methods
        demonstrateInternMethods();
        
        // 15. Java 8+ Methods
        demonstrateJava8Methods();
        
        // 16. Java 11+ Methods
        demonstrateJava11Methods();
        
        // 17. Java 12+ Methods
        demonstrateJava12Methods();
        
        // 18. Java 15+ Methods
        demonstrateJava15Methods();
        
        // 19. Miscellaneous Methods
        demonstrateMiscMethods();
    }
    
    /**
     * SECTION 1: STRING CONSTRUCTORS (Methods 1-15)
     * All ways to create String objects
     */
    private static void demonstrateConstructors() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 1: STRING CONSTRUCTORS (15 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 1: String() - Empty string
        String s1 = new String();
        System.out.println("1. String(): '" + s1 + "' - Creates empty string");
        
        // Method 2: String(String original)
        String s2 = new String("Hello");
        System.out.println("2. String(String): '" + s2 + "' - Creates copy of original");
        
        // Method 3: String(char[] value)
        char[] chars = {'J', 'a', 'v', 'a'};
        String s3 = new String(chars);
        System.out.println("3. String(char[]): '" + s3 + "' - From character array");
        
        // Method 4: String(char[] value, int offset, int count)
        char[] chars2 = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        String s4 = new String(chars2, 6, 5);
        System.out.println("4. String(char[], offset, count): '" + s4 + "' - Subset of char array");
        
        // Method 5: String(byte[] bytes)
        byte[] bytes = {72, 101, 108, 108, 111};
        String s5 = new String(bytes);
        System.out.println("5. String(byte[]): '" + s5 + "' - From byte array (platform default charset)");
        
        // Method 6: String(byte[] bytes, Charset charset)
        byte[] bytes2 = {87, 111, 114, 108, 100};
        String s6 = new String(bytes2, java.nio.charset.StandardCharsets.UTF_8);
        System.out.println("6. String(byte[], Charset): '" + s6 + "' - From byte array with specific charset");
        
        // Method 7: String(byte[] bytes, String charsetName)
        try {
            byte[] bytes3 = {74, 97, 118, 97};
            String s7 = new String(bytes3, "UTF-8");
            System.out.println("7. String(byte[], charsetName): '" + s7 + "' - From byte array with charset name");
        } catch (Exception e) {
            System.out.println("7. String(byte[], charsetName): Error - " + e.getMessage());
        }
        
        // Method 8: String(byte[] bytes, int offset, int length)
        byte[] bytes4 = {80, 114, 111, 103, 114, 97, 109, 109, 105, 110, 103};
        String s8 = new String(bytes4, 0, 7);
        System.out.println("8. String(byte[], offset, length): '" + s8 + "' - Subset of byte array");
        
        // Method 9: String(byte[] bytes, int offset, int length, Charset charset)
        byte[] bytes5 = {67, 111, 100, 105, 110, 103};
        String s9 = new String(bytes5, 0, 4, java.nio.charset.StandardCharsets.UTF_8);
        System.out.println("9. String(byte[], offset, length, Charset): '" + s9 + "' - Subset with charset");
        
        // Method 10: String(byte[] bytes, int offset, int length, String charsetName)
        try {
            byte[] bytes6 = {69, 120, 97, 109, 112, 108, 101};
            String s10 = new String(bytes6, 0, 4, "UTF-8");
            System.out.println("10. String(byte[], offset, length, charsetName): '" + s10 + "'");
        } catch (Exception e) {
            System.out.println("10. Error: " + e.getMessage());
        }
        
        // Method 11: String(int[] codePoints, int offset, int count)
        int[] codePoints = {65, 66, 67, 68, 69};
        String s11 = new String(codePoints, 1, 3);
        System.out.println("11. String(int[] codePoints, offset, count): '" + s11 + "' - From Unicode code points");
        
        // Method 12: String(StringBuffer buffer)
        StringBuffer buffer = new StringBuffer("StringBuffer");
        String s12 = new String(buffer);
        System.out.println("12. String(StringBuffer): '" + s12 + "' - From StringBuffer");
        
        // Method 13: String(StringBuilder builder)
        StringBuilder builder = new StringBuilder("StringBuilder");
        String s13 = new String(builder);
        System.out.println("13. String(StringBuilder): '" + s13 + "' - From StringBuilder");
        
        // Method 14: (Deprecated) String(byte[] ascii, int hibyte)
        // This constructor is deprecated, not recommended for use
        
        // Method 15: (Deprecated) String(byte[] ascii, int hibyte, int offset, int count)
        // This constructor is deprecated, not recommended for use
        
        System.out.println("\nNote: Constructors 14-15 are deprecated and not demonstrated.");
    }
    
    /**
     * SECTION 2: LENGTH AND EMPTY CHECKS (Methods 16-18)
     */
    private static void demonstrateLengthMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 2: LENGTH AND EMPTY CHECKS (3 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello World";
        String empty = "";
        String blank = "   ";
        
        // Method 16: length()
        System.out.println("16. length(): " + str.length() + 
            " - Returns number of characters in string");
        
        // Method 17: isEmpty()
        System.out.println("17. isEmpty():");
        System.out.println("   '" + str + "' is empty? " + str.isEmpty());
        System.out.println("   '" + empty + "' is empty? " + empty.isEmpty());
        
        // Method 18: isBlank() (Java 11+)
        System.out.println("18. isBlank():");
        System.out.println("   '" + blank + "' is blank? " + blank.isBlank());
        System.out.println("   '" + empty + "' is blank? " + empty.isBlank());
        System.out.println("   '" + str + "' is blank? " + str.isBlank());
    }
    
    /**
     * SECTION 3: CHARACTER ACCESS METHODS (Methods 19-22)
     */
    private static void demonstrateCharAccess() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 3: CHARACTER ACCESS METHODS (4 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello";
        
        // Method 19: charAt(int index)
        System.out.println("19. charAt(1): '" + str.charAt(1) + 
            "' - Returns character at specified index");
        
        // Method 20: codePointAt(int index)
        System.out.println("20. codePointAt(1): " + str.codePointAt(1) + 
            " - Returns Unicode code point at index");
        
        // Method 21: codePointBefore(int index)
        System.out.println("21. codePointBefore(2): " + str.codePointBefore(2) + 
            " - Returns Unicode code point before index");
        
        // Method 22: codePointCount(int beginIndex, int endIndex)
        System.out.println("22. codePointCount(0, 3): " + str.codePointCount(0, 3) + 
            " - Returns number of code points in range");
        
        // Additional: offsetByCodePoints(int index, int codePointOffset)
        System.out.println("    offsetByCodePoints(0, 2): " + str.offsetByCodePoints(0, 2) + 
            " - Returns index after moving by code points");
    }
    
    /**
     * SECTION 4: COMPARISON METHODS (Methods 23-31)
     */
    private static void demonstrateComparisonMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 4: COMPARISON METHODS (9 Methods)");
        System.out.println("=".repeat(80));
        
        String str1 = "Hello";
        String str2 = "hello";
        String str3 = "Hello";
        String str4 = "Hello World";
        
        // Method 23: equals(Object anObject)
        System.out.println("23. equals():");
        System.out.println("   'Hello' equals 'Hello'? " + str1.equals(str3));
        System.out.println("   'Hello' equals 'hello'? " + str1.equals(str2));
        
        // Method 24: equalsIgnoreCase(String anotherString)
        System.out.println("24. equalsIgnoreCase():");
        System.out.println("   'Hello' equalsIgnoreCase 'hello'? " + str1.equalsIgnoreCase(str2));
        
        // Method 25: compareTo(String anotherString)
        System.out.println("25. compareTo():");
        System.out.println("   'Hello' compareTo 'Hello': " + str1.compareTo(str3));
        System.out.println("   'Hello' compareTo 'hello': " + str1.compareTo(str2));
        System.out.println("   'Hello' compareTo 'Hello World': " + str1.compareTo(str4));
        
        // Method 26: compareToIgnoreCase(String str)
        System.out.println("26. compareToIgnoreCase():");
        System.out.println("   'Hello' compareToIgnoreCase 'hello': " + 
            str1.compareToIgnoreCase(str2));
        
        // Method 27: contentEquals(CharSequence cs)
        System.out.println("27. contentEquals(CharSequence):");
        System.out.println("   'Hello' equals StringBuilder('Hello')? " + 
            str1.contentEquals(new StringBuilder("Hello")));
        
        // Method 28: contentEquals(StringBuffer sb)
        System.out.println("28. contentEquals(StringBuffer):");
        System.out.println("   'Hello' equals StringBuffer('Hello')? " + 
            str1.contentEquals(new StringBuffer("Hello")));
        
        // Method 29: equalsIgnoreCase (already covered)
        
        // Method 30: regionMatches(int toffset, String other, int ooffset, int len)
        System.out.println("30. regionMatches():");
        System.out.println("   'Hello World' regionMatches 6,'World',0,5? " + 
            "Hello World".regionMatches(6, "World", 0, 5));
        
        // Method 31: regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
        System.out.println("31. regionMatches(ignoreCase):");
        System.out.println("   'Hello World' regionMatches true,6,'WORLD',0,5? " + 
            "Hello World".regionMatches(true, 6, "WORLD", 0, 5));
    }
    
    /**
     * SECTION 5: SEARCH METHODS (Methods 32-41)
     */
    private static void demonstrateSearchMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 5: SEARCH METHODS (10 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello World, Hello Universe";
        
        // Method 32: indexOf(int ch)
        System.out.println("32. indexOf(int ch):");
        System.out.println("   First 'o' at: " + str.indexOf('o'));
        
        // Method 33: indexOf(int ch, int fromIndex)
        System.out.println("33. indexOf(int ch, int fromIndex):");
        System.out.println("   First 'o' after index 5: " + str.indexOf('o', 5));
        
        // Method 34: indexOf(String str)
        System.out.println("34. indexOf(String str):");
        System.out.println("   First 'Hello' at: " + str.indexOf("Hello"));
        
        // Method 35: indexOf(String str, int fromIndex)
        System.out.println("35. indexOf(String str, int fromIndex):");
        System.out.println("   Second 'Hello' at: " + str.indexOf("Hello", 10));
        
        // Method 36: lastIndexOf(int ch)
        System.out.println("36. lastIndexOf(int ch):");
        System.out.println("   Last 'o' at: " + str.lastIndexOf('o'));
        
        // Method 37: lastIndexOf(int ch, int fromIndex)
        System.out.println("37. lastIndexOf(int ch, int fromIndex):");
        System.out.println("   Last 'o' before index 10: " + str.lastIndexOf('o', 10));
        
        // Method 38: lastIndexOf(String str)
        System.out.println("38. lastIndexOf(String str):");
        System.out.println("   Last 'Hello' at: " + str.lastIndexOf("Hello"));
        
        // Method 39: lastIndexOf(String str, int fromIndex)
        System.out.println("39. lastIndexOf(String str, int fromIndex):");
        System.out.println("   Last 'Hello' before index 10: " + str.lastIndexOf("Hello", 10));
        
        // Method 40: contains(CharSequence s)
        System.out.println("40. contains():");
        System.out.println("   Contains 'World'? " + str.contains("World"));
        System.out.println("   Contains 'Java'? " + str.contains("Java"));
        
        // Method 41: startsWith(String prefix) and endsWith(String suffix)
        System.out.println("41. startsWith() and endsWith():");
        System.out.println("   Starts with 'Hello'? " + str.startsWith("Hello"));
        System.out.println("   Ends with 'Universe'? " + str.endsWith("Universe"));
        System.out.println("   Starts with 'World' at index 6? " + str.startsWith("World", 6));
    }
    
    /**
     * SECTION 6: SUBSTRING METHODS (Methods 42-45)
     */
    private static void demonstrateSubstringMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 6: SUBSTRING METHODS (4 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello World";
        
        // Method 42: substring(int beginIndex)
        System.out.println("42. substring(int beginIndex):");
        System.out.println("   From index 6: '" + str.substring(6) + "'");
        
        // Method 43: substring(int beginIndex, int endIndex)
        System.out.println("43. substring(int beginIndex, int endIndex):");
        System.out.println("   From 0 to 5: '" + str.substring(0, 5) + "'");
        
        // Method 44: subSequence(int beginIndex, int endIndex)
        System.out.println("44. subSequence():");
        CharSequence seq = str.subSequence(0, 5);
        System.out.println("   From 0 to 5 as CharSequence: '" + seq + "'");
        
        // Method 45: split (covered in regex section) - but substring related
        String[] parts = str.split(" ");
        System.out.println("45. split() related to substring: " + 
            java.util.Arrays.toString(parts));
    }
    
    /**
     * SECTION 7: CASE CONVERSION METHODS (Methods 46-49)
     */
    private static void demonstrateCaseMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 7: CASE CONVERSION METHODS (4 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello World";
        String turkish = "Istanbul";
        
        // Method 46: toLowerCase()
        System.out.println("46. toLowerCase():");
        System.out.println("   Original: '" + str + "'");
        System.out.println("   Lowercase: '" + str.toLowerCase() + "'");
        
        // Method 47: toLowerCase(Locale locale)
        System.out.println("47. toLowerCase(Locale):");
        System.out.println("   Turkish 'I' with default locale: '" + 
            turkish.toLowerCase() + "'");
        System.out.println("   Turkish 'I' with Turkish locale: '" + 
            turkish.toLowerCase(new java.util.Locale("tr", "TR")) + "'");
        
        // Method 48: toUpperCase()
        System.out.println("48. toUpperCase():");
        System.out.println("   Original: '" + str + "'");
        System.out.println("   Uppercase: '" + str.toUpperCase() + "'");
        
        // Method 49: toUpperCase(Locale locale)
        System.out.println("49. toUpperCase(Locale):");
        System.out.println("   Turkish with default locale: '" + 
            turkish.toUpperCase() + "'");
        System.out.println("   Turkish with Turkish locale: '" + 
            turkish.toUpperCase(new java.util.Locale("tr", "TR")) + "'");
    }
    
    /**
     * SECTION 8: TRIMMING AND STRIPPING METHODS (Methods 50-55)
     */
    private static void demonstrateTrimMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 8: TRIMMING AND STRIPPING METHODS (6 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "  \t Hello World  \n";
        
        // Method 50: trim()
        System.out.println("50. trim():");
        System.out.println("   Original: '" + str + "'");
        System.out.println("   Trimmed: '" + str.trim() + "'");
        
        // Method 51: strip() (Java 11)
        System.out.println("51. strip() (Java 11+):");
        System.out.println("   Stripped: '" + str.strip() + "'");
        
        // Method 52: stripLeading() (Java 11)
        System.out.println("52. stripLeading() (Java 11+):");
        System.out.println("   Leading stripped: '" + str.stripLeading() + "'");
        
        // Method 53: stripTrailing() (Java 11)
        System.out.println("53. stripTrailing() (Java 11+):");
        System.out.println("   Trailing stripped: '" + str.stripTrailing() + "'");
        
        // Method 54: stripIndent() (Java 15)
        String indentStr = "    Line1\n    Line2";
        System.out.println("54. stripIndent() (Java 15+):");
        System.out.println("   Original indent:\n" + indentStr);
        System.out.println("   After stripIndent:\n" + indentStr.stripIndent());
        
        // Method 55: translateEscapes() (Java 15)
        String escapes = "Hello\\nWorld\\tTab";
        System.out.println("55. translateEscapes() (Java 15+):");
        System.out.println("   Original: '" + escapes + "'");
        System.out.println("   Translated: '" + escapes.translateEscapes() + "'");
    }
    
    /**
     * SECTION 9: REPLACEMENT METHODS (Methods 56-63)
     */
    private static void demonstrateReplacementMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 9: REPLACEMENT METHODS (8 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello World Hello Java";
        
        // Method 56: replace(char oldChar, char newChar)
        System.out.println("56. replace(char, char):");
        System.out.println("   Replace 'l' with 'L': '" + str.replace('l', 'L') + "'");
        
        // Method 57: replace(CharSequence target, CharSequence replacement)
        System.out.println("57. replace(CharSequence, CharSequence):");
        System.out.println("   Replace 'Hello' with 'Hi': '" + 
            str.replace("Hello", "Hi") + "'");
        
        // Method 58: replaceAll(String regex, String replacement)
        System.out.println("58. replaceAll(String regex, String replacement):");
        System.out.println("   Replace all words: '" + 
            str.replaceAll("\\w+", "WORD") + "'");
        
        // Method 59: replaceFirst(String regex, String replacement)
        System.out.println("59. replaceFirst(String regex, String replacement):");
        System.out.println("   Replace first word: '" + 
            str.replaceFirst("\\w+", "WORD") + "'");
        
        // Method 60: repeat(int count) (Java 11)
        String repeat = "Ha";
        System.out.println("60. repeat(int count) (Java 11+):");
        System.out.println("   'Ha' repeated 3 times: '" + repeat.repeat(3) + "'");
        
        // Method 61: indent(int n) (Java 15)
        String indentStr = "Line1\nLine2";
        System.out.println("61. indent(int n) (Java 15+):");
        System.out.println("   With +4 indent:\n" + indentStr.indent(4));
        
        // Method 62: stripIndent (already covered)
        
        // Method 63: translateEscapes (already covered)
    }
    
    /**
     * SECTION 10: CONCATENATION AND JOIN METHODS (Methods 64-68)
     */
    private static void demonstrateConcatenationMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 10: CONCATENATION AND JOIN METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        String str1 = "Hello";
        String str2 = "World";
        
        // Method 64: concat(String str)
        System.out.println("64. concat(String str):");
        System.out.println("   'Hello'.concat('World'): '" + str1.concat(str2) + "'");
        
        // Method 65: join(CharSequence delimiter, CharSequence... elements)
        System.out.println("65. join(CharSequence delimiter, elements):");
        String joined = String.join("-", "2024", "03", "10");
        System.out.println("   Join with '-': '" + joined + "'");
        
        // Method 66: join(CharSequence delimiter, Iterable elements)
        java.util.List<String> list = java.util.Arrays.asList("A", "B", "C");
        String joinedList = String.join(", ", list);
        System.out.println("66. join with Iterable: '" + joinedList + "'");
        
        // Method 67: + operator (not a method but important)
        System.out.println("67. + operator: '" + str1 + " " + str2 + "'");
        
        // Method 68: formatted(Object... args) (Java 15)
        String format = "Hello %s, you are %d years old";
        System.out.println("68. formatted(Object... args) (Java 15+):");
        System.out.println("   " + format.formatted("John", 25));
    }
    
    /**
     * SECTION 11: FORMAT METHODS (Methods 69-71)
     */
    private static void demonstrateFormatMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 11: FORMAT METHODS (3 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 69: format(String format, Object... args)
        String formatted1 = String.format("Hello %s, score: %d", "John", 95);
        System.out.println("69. format(String format, Object... args):");
        System.out.println("   " + formatted1);
        
        // Method 70: format(Locale locale, String format, Object... args)
        String formatted2 = String.format(java.util.Locale.US, 
            "US format: %,.2f", 1234567.89);
        System.out.println("70. format with Locale:");
        System.out.println("   " + formatted2);
        
        // Method 71: formatted (already covered in section 10)
    }
    
    /**
     * SECTION 12: CONVERSION METHODS (Methods 72-79)
     */
    private static void demonstrateConversionMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 12: CONVERSION METHODS (8 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello";
        
        // Method 72: toCharArray()
        System.out.println("72. toCharArray():");
        char[] chars = str.toCharArray();
        System.out.println("   Character array: " + java.util.Arrays.toString(chars));
        
        // Method 73: getBytes()
        System.out.println("73. getBytes():");
        byte[] bytes = str.getBytes();
        System.out.println("   Bytes: " + java.util.Arrays.toString(bytes));
        
        // Method 74: getBytes(Charset charset)
        byte[] utfBytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        System.out.println("74. getBytes(Charset):");
        System.out.println("   UTF-8 bytes: " + java.util.Arrays.toString(utfBytes));
        
        // Method 75: getBytes(String charsetName)
        try {
            byte[] charsetBytes = str.getBytes("UTF-16");
            System.out.println("75. getBytes(String charsetName):");
            System.out.println("   UTF-16 bytes: " + java.util.Arrays.toString(charsetBytes));
        } catch (Exception e) {
            System.out.println("75. Error: " + e.getMessage());
        }
        
        // Method 76: getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        char[] dest = new char[5];
        str.getChars(0, 5, dest, 0);
        System.out.println("76. getChars():");
        System.out.println("   Destination array: " + java.util.Arrays.toString(dest));
        
        // Method 77: valueOf(boolean b)
        System.out.println("77. valueOf(boolean): " + String.valueOf(true));
        
        // Method 78: valueOf(char c)
        System.out.println("78. valueOf(char): " + String.valueOf('A'));
        
        // Method 79: valueOf(char[] data)
        System.out.println("79. valueOf(char[]): " + String.valueOf(new char[]{'J', 'a', 'v', 'a'}));
        
        // Method 80: valueOf(char[] data, int offset, int count)
        System.out.println("80. valueOf(char[], offset, count): " + 
            String.valueOf(new char[]{'H','e','l','l','o'}, 0, 3));
        
        // Method 81: valueOf(double d)
        System.out.println("81. valueOf(double): " + String.valueOf(3.14159));
        
        // Method 82: valueOf(float f)
        System.out.println("82. valueOf(float): " + String.valueOf(2.718f));
        
        // Method 83: valueOf(int i)
        System.out.println("83. valueOf(int): " + String.valueOf(42));
        
        // Method 84: valueOf(long l)
        System.out.println("84. valueOf(long): " + String.valueOf(123456789L));
        
        // Method 85: valueOf(Object obj)
        // System.out.println("85. valueOf(Object): " + String.valueOf(new Integer(100)));
        System.out.println("85. valueOf(Object): " + String.valueOf(Integer.valueOf(100)));
        // Method 86: copyValueOf(char[] data)
        System.out.println("86. copyValueOf(char[]): " + String.copyValueOf(new char[]{'C','o','p','y'}));
        
        // Method 87: copyValueOf(char[] data, int offset, int count)
        System.out.println("87. copyValueOf(char[], offset, count): " + 
            String.copyValueOf(new char[]{'C','o','p','y'}, 0, 3));
    }
    
    /**
     * SECTION 13: REGULAR EXPRESSION METHODS (Methods 88-92)
     */
    private static void demonstrateRegexMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 13: REGULAR EXPRESSION METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello World Hello Java";
        
        // Method 88: matches(String regex)
        System.out.println("88. matches(String regex):");
        System.out.println("   Matches 'Hello.*'? " + str.matches("Hello.*"));
        System.out.println("   Matches 'Hi.*'? " + str.matches("Hi.*"));
        
        // Method 89: split(String regex)
        System.out.println("89. split(String regex):");
        String[] parts = str.split(" ");
        System.out.println("   Split by space: " + java.util.Arrays.toString(parts));
        
        // Method 90: split(String regex, int limit)
        System.out.println("90. split(String regex, int limit):");
        String[] parts2 = str.split(" ", 2);
        System.out.println("   Split by space (limit 2): " + java.util.Arrays.toString(parts2));
        
        // Method 91: replaceAll (already covered)
        System.out.println("91. replaceAll (covered in replacement section)");
        
        // Method 92: replaceFirst (already covered)
        System.out.println("92. replaceFirst (covered in replacement section)");
        
        // Method 93: splitWithDelimiters (not available - internal method)
    }
    
    /**
     * SECTION 14: STRING POOL/INTERN METHODS (Methods 94-95)
     */
    private static void demonstrateInternMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 14: STRING POOL/INTERN METHODS (2 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 94: intern()
        System.out.println("94. intern():");
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = s1.intern();
        String s4 = "Hello";
        
        System.out.println("   s1 == s2: " + (s1 == s2) + " (different objects)");
        System.out.println("   s1.intern() == s4: " + (s3 == s4) + " (same from string pool)");
        
        // Method 95: isInterned (not a public method)
    }
    
    /**
     * SECTION 15: JAVA 8+ METHODS (Methods 96-98)
     */
    private static void demonstrateJava8Methods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 15: JAVA 8+ METHODS (3 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello\nWorld\nJava";
        
        // Method 96: lines() (Java 8+)
        System.out.println("96. lines() (Java 8+):");
        str.lines().forEach(line -> System.out.println("   Line: " + line));
        
        // Method 97: chars() (Java 8+)
        System.out.println("97. chars() (Java 8+):");
        System.out.print("   Character codes: ");
        "ABC".chars().forEach(c -> System.out.print(c + " "));
        System.out.println();
        
        // Method 98: codePoints() (Java 8+)
        System.out.println("98. codePoints() (Java 8+):");
        System.out.print("   Code points: ");
        "ABC".codePoints().forEach(cp -> System.out.print(cp + " "));
        System.out.println();
    }
    
    /**
     * SECTION 16: JAVA 11+ METHODS (Methods 99-104)
     */
    private static void demonstrateJava11Methods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 16: JAVA 11+ METHODS (6 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 99: isBlank (covered in section 2)
        System.out.println("99. isBlank() (covered in section 2)");
        
        // Method 100: lines (covered in section 15)
        System.out.println("100. lines() (covered in section 15)");
        
        // Method 101: strip (covered in section 8)
        System.out.println("101. strip() (covered in section 8)");
        
        // Method 102: stripLeading (covered in section 8)
        System.out.println("102. stripLeading() (covered in section 8)");
        
        // Method 103: stripTrailing (covered in section 8)
        System.out.println("103. stripTrailing() (covered in section 8)");
        
        // Method 104: repeat (covered in section 9)
        System.out.println("104. repeat() (covered in section 9)");
    }
    
    /**
     * SECTION 17: JAVA 12+ METHODS (Methods 105-106)
     */
    private static void demonstrateJava12Methods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 17: JAVA 12+ METHODS (2 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 105: indent (Java 12 preview, Java 15 final)
        System.out.println("105. indent() (covered in section 9)");
        
        // Method 106: transform (Java 12)
        System.out.println("106. transform(Function):");
        String result = "hello".transform(s -> s.toUpperCase());
        System.out.println("   'hello'.transform(String::toUpperCase): '" + result + "'");
        
        // Additional transform example
        Integer length = "hello".transform(s -> s.length());
        System.out.println("   'hello'.transform(String::length): " + length);
    }
    
    /**
     * SECTION 18: JAVA 15+ METHODS (Methods 107-110)
     */
    private static void demonstrateJava15Methods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 18: JAVA 15+ METHODS (4 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 107: stripIndent (covered)
        System.out.println("107. stripIndent() (covered in section 8)");
        
        // Method 108: translateEscapes (covered)
        System.out.println("108. translateEscapes() (covered in section 8)");
        
        // Method 109: formatted (covered)
        System.out.println("109. formatted() (covered in section 10)");
        
        // Method 110: repeat (already covered)
        System.out.println("110. repeat (covered)");
    }
    
    /**
     * SECTION 19: MISCELLANEOUS METHODS (Methods 111-116)
     */
    private static void demonstrateMiscMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 19: MISCELLANEOUS METHODS (6 Methods)");
        System.out.println("=".repeat(80));
        
        String str = "Hello";
        
        // Method 111: hashCode()
        System.out.println("111. hashCode():");
        System.out.println("   'Hello' hashCode: " + str.hashCode());
        
        // Method 112: toString() (overridden from Object)
        System.out.println("112. toString():");
        System.out.println("   String's toString: '" + str.toString() + "'");
        
        // Method 113: describeConstable() (Java 12+)
        System.out.println("113. describeConstable() (Java 12+):");
        var constable = str.describeConstable();
        System.out.println("   Constable optional: " + constable);
        
        // Method 114: resolveConstantDesc (Java 12+)
        System.out.println("114. resolveConstantDesc():");
        try {
            var resolved = str.resolveConstantDesc(null);
            System.out.println("   Resolved: " + resolved);
        } catch (Exception e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 115: indent (already covered)
        
        // Method 116: stripIndent (already covered)
    }
}

// Note: Some methods like getValue() and coder() are package-private/internal
// and not part of public API, so they are not included