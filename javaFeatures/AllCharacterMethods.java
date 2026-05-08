/**
 * Program to demonstrate all Character class methods in Java
 * This program shows the purpose and usage of each Character method
 */
public class AllCharacterMethods {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("COMPREHENSIVE DEMONSTRATION OF CHARACTER CLASS METHODS");
        System.out.println("=".repeat(80));
        
        // 1. Character Constructors (Deprecated but shown for completeness)
        demonstrateConstructors();
        
        // 2. Static Methods for Character Classification
        demonstrateCharClassification();
        
        // 3. Static Methods for Character Conversion
        demonstrateCharConversion();
        
        // 4. Static Methods for Case Operations
        demonstrateCaseOperations();
        
        // 5. Static Methods for Digit/Numeric Operations
        demonstrateNumericOperations();
        
        // 6. Static Methods for Unicode/Code Point Operations
        demonstrateUnicodeOperations();
        
        // 7. Static Methods for Comparison
        demonstrateComparisonMethods();
        
        // 8. Instance Methods of Character Class
        demonstrateInstanceMethods();
        
        // 9. Deprecated Methods (Briefly)
        demonstrateDeprecatedMethods();
        
        // 10. Character Constants
        demonstrateConstants();
        
        // 11. Newer Java 11+ Methods
        demonstrateJava11PlusMethods();
    }
    
    /**
     * Method 1-2: Character Constructors
     * Note: These are deprecated from Java 9 onwards but shown for completeness
     */
    private static void demonstrateConstructors() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("1. CONSTRUCTORS (Deprecated but shown for reference)");
        System.out.println("-".repeat(60));
        
        // Constructor 1: Character(char value)
        Character char1 = Character.valueOf('A'); // Using valueOf instead of constructor
        System.out.println("Character.valueOf('A') = " + char1);
        
        System.out.println("Purpose: Creates Character objects (use Character.valueOf() instead of constructor)");
    }
    
    /**
     * Methods 3-20: Character Classification Methods
     * These methods check what type of character it is
     */
    private static void demonstrateCharClassification() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("2. CHARACTER CLASSIFICATION METHODS");
        System.out.println("-".repeat(60));
        
        // Using regular characters and handling supplementary characters separately
        char[] testChars = {'A', 'a', '5', '$', ' ', '\t', '\n', 'Ы'};
        
        for (char c : testChars) {
            System.out.println("\nTesting character: '" + c + "' (Unicode: " + (int)c + ")");
            
            // Method 3: isLetter(char ch)
            System.out.println("  isLetter(): " + Character.isLetter(c) + 
                " - Checks if character is a letter");
            
            // Method 4: isDigit(char ch)
            System.out.println("  isDigit(): " + Character.isDigit(c) + 
                " - Checks if character is a digit (0-9)");
            
            // Method 5: isLetterOrDigit(char ch)
            System.out.println("  isLetterOrDigit(): " + Character.isLetterOrDigit(c) + 
                " - Checks if character is letter or digit");
            
            // Method 6: isWhitespace(char ch)
            System.out.println("  isWhitespace(): " + Character.isWhitespace(c) + 
                " - Checks if character is whitespace (space, tab, newline)");
            
            // Method 7: isSpaceChar(char ch)
            System.out.println("  isSpaceChar(): " + Character.isSpaceChar(c) + 
                " - Checks if character is Unicode space character");
            
            // Method 8: isISOControl(char ch)
            System.out.println("  isISOControl(): " + Character.isISOControl(c) + 
                " - Checks if character is ISO control character");
            
            // Method 9: isDefined(char ch)
            System.out.println("  isDefined(): " + Character.isDefined(c) + 
                " - Checks if character is defined in Unicode");
            
            // Method 10: isJavaIdentifierStart(char ch)
            System.out.println("  isJavaIdentifierStart(): " + Character.isJavaIdentifierStart(c) + 
                " - Checks if valid start of Java identifier");
            
            // Method 11: isJavaIdentifierPart(char ch)
            System.out.println("  isJavaIdentifierPart(): " + Character.isJavaIdentifierPart(c) + 
                " - Checks if valid part of Java identifier");
            
            // Method 12: isUnicodeIdentifierStart(char ch)
            System.out.println("  isUnicodeIdentifierStart(): " + Character.isUnicodeIdentifierStart(c) + 
                " - Checks if valid start of Unicode identifier");
            
            // Method 13: isUnicodeIdentifierPart(char ch)
            System.out.println("  isUnicodeIdentifierPart(): " + Character.isUnicodeIdentifierPart(c) + 
                " - Checks if valid part of Unicode identifier");
            
            // Method 14: isIdentifierIgnorable(char ch)
            System.out.println("  isIdentifierIgnorable(): " + Character.isIdentifierIgnorable(c) + 
                " - Checks if character should be ignored in identifiers");
        }
        
        // Testing supplementary character separately using code point
        System.out.println("\nTesting supplementary character: '𐍈' (Gothic letter hwair)");
        int gothicCodePoint = 0x10348; // Gothic letter hwair
        System.out.println("  isLetter(0x10348): " + Character.isLetter(gothicCodePoint) + 
            " - Checks if code point is a letter");
        System.out.println("  isDefined(0x10348): " + Character.isDefined(gothicCodePoint) + 
            " - Checks if code point is defined in Unicode");
    }
    
    /**
     * Methods 21-24: Character Conversion Methods
     */
    private static void demonstrateCharConversion() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("3. CHARACTER CONVERSION METHODS");
        System.out.println("-".repeat(60));
        
        // Method 21: digit(char ch, int radix)
        System.out.println("digit('A', 16): " + Character.digit('A', 16) + 
            " - Converts character to numeric value in given radix");
        System.out.println("digit('7', 10): " + Character.digit('7', 10));
        
        // Method 22: forDigit(int digit, int radix)
        System.out.println("forDigit(10, 16): " + Character.forDigit(10, 16) + 
            " - Converts digit to character in given radix");
        System.out.println("forDigit(15, 16): " + Character.forDigit(15, 16));
        
        // Method 23: getNumericValue(char ch)
        System.out.println("getNumericValue('Ⅸ'): " + Character.getNumericValue('Ⅸ') + 
            " - Gets Unicode numeric value (Roman numeral 9)");
        System.out.println("getNumericValue('A'): " + Character.getNumericValue('A'));
        
        // Method 24: getType(char ch)
        System.out.println("getType('A'): " + Character.getType('A') + 
            " (UPPERCASE_LETTER) - Returns general category type");
        System.out.println("getType('5'): " + Character.getType('5') + 
            " (DECIMAL_DIGIT_NUMBER)");
        System.out.println("getType('$'): " + Character.getType('$') + 
            " (CURRENCY_SYMBOL)");
    }
    
    /**
     * Methods 25-30: Case Operations
     */
    private static void demonstrateCaseOperations() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("4. CASE OPERATIONS");
        System.out.println("-".repeat(60));
        
        char letter = 'a';
        char capital = 'A';
        char germanSharpS = 'ß';
        char titleCaseChar = 'ǈ'; // LJ digraph
        
        // Method 25: isLowerCase(char ch)
        System.out.println("isLowerCase('a'): " + Character.isLowerCase(letter) + 
            " - Checks if character is lowercase");
        
        // Method 26: isUpperCase(char ch)
        System.out.println("isUpperCase('A'): " + Character.isUpperCase(capital) + 
            " - Checks if character is uppercase");
        
        // Method 27: toLowerCase(char ch)
        System.out.println("toLowerCase('A'): " + Character.toLowerCase(capital) + 
            " - Converts to lowercase");
        
        // Method 28: toUpperCase(char ch)
        System.out.println("toUpperCase('a'): " + Character.toUpperCase(letter) + 
            " - Converts to uppercase");
        
        // Method 29: toTitleCase(char ch)
        System.out.println("toTitleCase('ß'): " + Character.toTitleCase(germanSharpS) + 
            " - Converts to title case (special for certain characters)");
        
        // Method 30: isTitleCase(char ch)
        System.out.println("isTitleCase('ǈ'): " + Character.isTitleCase(titleCaseChar) + 
            " - Checks if character is title case");
    }
    
    /**
     * Methods 31-36: Numeric Operations
     */
    private static void demonstrateNumericOperations() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("5. NUMERIC OPERATIONS");
        System.out.println("-".repeat(60));
        
        // Method 34: getDirectionality(char ch)
        System.out.println("getDirectionality('A'): " + Character.getDirectionality('A') + 
            " - Gets Unicode directionality property");
        System.out.println("getDirectionality(','): " + Character.getDirectionality(','));
        
        // Method 35: isMirrored(char ch)
        System.out.println("isMirrored('('): " + Character.isMirrored('(') + 
            " - Checks if character has mirrored equivalent (like brackets)");
        System.out.println("isMirrored('A'): " + Character.isMirrored('A') + 
            " - Letters are not mirrored");
    }
    
    /**
     * Methods 37-49: Unicode/Code Point Operations
     */
    private static void demonstrateUnicodeOperations() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("6. UNICODE/CODE POINT OPERATIONS");
        System.out.println("-".repeat(60));
        
        int codePoint = 65; // 'A'
        int gothicCodePoint = 0x10348; // Gothic letter hwair
        int maxValidCodePoint = 0x10FFFF;
        
        // Method 37: isBmpCodePoint(int codePoint)
        System.out.println("isBmpCodePoint(65): " + Character.isBmpCodePoint(codePoint) + 
            " - Checks if code point is in Basic Multilingual Plane");
        
        // Method 38: isSupplementaryCodePoint(int codePoint)
        System.out.println("isSupplementaryCodePoint(0x10348): " + 
            Character.isSupplementaryCodePoint(gothicCodePoint) + 
            " - Checks if code point is supplementary");
        
        // Method 39: isValidCodePoint(int codePoint)
        System.out.println("isValidCodePoint(0x10FFFF): " + 
            Character.isValidCodePoint(maxValidCodePoint) + 
            " - Checks if code point is valid Unicode");
        
        // Method 40: charCount(int codePoint)
        System.out.println("charCount(65): " + Character.charCount(codePoint) + 
            " - Returns number of chars needed for BMP");
        System.out.println("charCount(0x10348): " + Character.charCount(gothicCodePoint) + 
            " - Returns number of chars needed for supplementary");
        
        // Method 41: toChars(int codePoint)
        char[] chars = Character.toChars(gothicCodePoint);
        System.out.println("toChars(0x10348): " + java.util.Arrays.toString(chars) + 
            " - Converts code point to char array (surrogate pair)");
        
        // Method 42: toCodePoint(char high, char low)
        char high = chars[0];
        char low = chars[1];
        System.out.println("toCodePoint(high surrogate, low surrogate): " + 
            Character.toCodePoint(high, low) + 
            " - Converts surrogate pair back to code point");
        
        // Method 43: codePointAt(char[] a, int index)
        char[] charArray = {'A', 'B', high, low, 'C'};
        System.out.println("codePointAt([A,B,surrogate pair,C], 2): " + 
            Character.codePointAt(charArray, 2) + 
            " - Gets code point at index (handles surrogates)");
        
        // Method 44: codePointBefore(char[] a, int index)
        System.out.println("codePointBefore([A,B,surrogate pair,C], 4): " + 
            Character.codePointBefore(charArray, 4) + 
            " - Gets code point before index");
        
        // Method 45: codePointCount(char[] a, int offset, int count)
        System.out.println("codePointCount([A,B,surrogate pair,C], 0, 5): " + 
            Character.codePointCount(charArray, 0, 5) + 
            " - Counts code points in range (surrogate pair counts as one)");
        
        // Method 47: isLowSurrogate(char ch)
        System.out.println("isLowSurrogate(low surrogate): " + Character.isLowSurrogate(low) + 
            " - Checks if char is low surrogate");
        
        // Method 48: isHighSurrogate(char ch)
        System.out.println("isHighSurrogate(high surrogate): " + Character.isHighSurrogate(high) + 
            " - Checks if char is high surrogate");
        
        // Method 49: isSurrogatePair(char high, char low)
        System.out.println("isSurrogatePair(high, low): " + 
            Character.isSurrogatePair(high, low) + 
            " - Checks if chars form valid surrogate pair");
    }
    
    /**
     * Methods 50-54: Comparison Methods
     */
    private static void demonstrateComparisonMethods() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("7. COMPARISON METHODS");
        System.out.println("-".repeat(60));
        
        // Method 50: compare(char x, char y) - Static method
        System.out.println("compare('A', 'B'): " + Character.compare('A', 'B') + 
            " (returns negative if first < second)");
        System.out.println("compare('B', 'A'): " + Character.compare('B', 'A'));
        System.out.println("compare('A', 'A'): " + Character.compare('A', 'A'));
        
        // Method 54: toString(char c) - Static method
        System.out.println("toString('A'): " + Character.toString('A') + 
            " - Converts char to String object");
    }
    
    /**
     * Methods 55-59: Instance Methods of Character Class
     */
    private static void demonstrateInstanceMethods() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("8. INSTANCE METHODS OF CHARACTER CLASS");
        System.out.println("-".repeat(60));
        
        Character charObj = Character.valueOf('Z');
        
        // Method 55: charValue()
        System.out.println("charValue(): " + charObj.charValue() + 
            " - Returns primitive char value");
        
        // Method 56: compareTo(Character anotherCharacter)
        Character other = Character.valueOf('A');
        System.out.println("compareTo('A'): " + charObj.compareTo(other) + 
            " - Compares with another Character object");
        
        // Method 57: equals(Object obj)
        System.out.println("equals('Z'): " + charObj.equals(Character.valueOf('Z')) + 
            " - Checks equality with another object");
        
        // Method 58: hashCode()
        System.out.println("hashCode(): " + charObj.hashCode() + 
            " - Returns hash code (same as ASCII value)");
        
        // Method 59: toString()
        System.out.println("toString(): " + charObj.toString() + 
            " - Converts to String representation");
    }
    
    /**
     * Methods 60-63: Deprecated Methods (Shown for completeness)
     */
    private static void demonstrateDeprecatedMethods() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("9. DEPRECATED METHODS (Java 1.1 style)");
        System.out.println("-".repeat(60));
        
        System.out.println("isJavaLetter (deprecated): Use isJavaIdentifierStart() instead");
        System.out.println("isJavaLetterOrDigit (deprecated): Use isJavaIdentifierPart() instead");
        System.out.println("isSpace (deprecated): Use isWhitespace() instead");
    }
    
    /**
     * Methods 64-70: Character Constants
     */
    private static void demonstrateConstants() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("10. CHARACTER CONSTANTS");
        System.out.println("-".repeat(60));
        
        // Method 64: MIN_VALUE constant
        System.out.println("MIN_VALUE: " + (int)Character.MIN_VALUE + " (0x0000)" + 
            " - Minimum possible char value");
        
        // Method 65: MAX_VALUE constant
        System.out.println("MAX_VALUE: " + (int)Character.MAX_VALUE + " (0xFFFF)" + 
            " - Maximum possible char value");
        
        // Method 66: MIN_RADIX constant
        System.out.println("MIN_RADIX: " + Character.MIN_RADIX + 
            " - Minimum radix (2) for digit conversion");
        
        // Method 67: MAX_RADIX constant
        System.out.println("MAX_RADIX: " + Character.MAX_RADIX + 
            " - Maximum radix (36) for digit conversion");
        
        // Method 68: MIN_SURROGATE constant
        System.out.println("MIN_SURROGATE: " + (int)Character.MIN_SURROGATE + 
            " - Minimum surrogate value");
        
        // Method 69: MAX_SURROGATE constant
        System.out.println("MAX_SURROGATE: " + (int)Character.MAX_SURROGATE + 
            " - Maximum surrogate value");
        
        // Method 70: MIN_SUPPLEMENTARY_CODE_POINT constant
        System.out.println("MIN_SUPPLEMENTARY_CODE_POINT: " + 
            Character.MIN_SUPPLEMENTARY_CODE_POINT + 
            " - Minimum supplementary code point (0x10000)");
    }
    
    /**
     * Methods 71-78: Java 11+ Methods (Code point versions)
     */
    private static void demonstrateJava11PlusMethods() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("11. CODE POINT METHODS (Java 11+)");
        System.out.println("-".repeat(60));
        
        int codePointA = 65; // 'A'
        int codePointSpace = 32;
        int codePointFive = 53; // '5'
        
        // Method 72: isWhitespace(int codePoint) - Code point version
        System.out.println("isWhitespace(32): " + Character.isWhitespace(codePointSpace) + 
            " - Whitespace check using code point");
        
        // Method 73: isDigit(int codePoint) - Code point version
        System.out.println("isDigit(53): " + Character.isDigit(codePointFive) + 
            " - Digit check using code point");
        
        // Method 74: isLetter(int codePoint) - Code point version
        System.out.println("isLetter(65): " + Character.isLetter(codePointA) + 
            " - Letter check using code point");
        
        // Method 75: isLetterOrDigit(int codePoint) - Code point version
        System.out.println("isLetterOrDigit(65): " + Character.isLetterOrDigit(codePointA) + 
            " - Letter/digit check using code point");
        
        // Method 76: toLowerCase(int codePoint) - Code point version
        System.out.println("toLowerCase(65): " + (char)Character.toLowerCase(codePointA) + 
            " - Lowercase conversion using code point");
        
        // Method 77: toUpperCase(int codePoint) - Code point version
        System.out.println("toUpperCase(97): " + (char)Character.toUpperCase(97) + 
            " - Uppercase conversion using code point");
        
        // Method 78: getType(int codePoint) - Code point version
        System.out.println("getType(65): " + Character.getType(codePointA) + 
            " - Get type using code point");
    }
}