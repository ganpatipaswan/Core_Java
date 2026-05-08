/**
 * Program to demonstrate all Number class methods in Java
 * This program shows the purpose and usage of methods from:
 * - Number abstract class
 * - Integer class
 * - Float class
 * - Double class
 * - Long class
 * - Short class
 * - Byte class
 */
public class AllNumberMethods {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(100));
        System.out.println("COMPREHENSIVE DEMONSTRATION OF NUMBER CLASS METHODS");
        System.out.println("=".repeat(100));
        
        // SECTION 1: Number Abstract Class Methods
        demonstrateNumberAbstractMethods();
        
        // SECTION 2: Integer Class Methods
        demonstrateIntegerMethods();
        
        // SECTION 3: Long Class Methods
        demonstrateLongMethods();
        
        // SECTION 4: Short Class Methods
        demonstrateShortMethods();
        
        // SECTION 5: Byte Class Methods
        demonstrateByteMethods();
        
        // SECTION 6: Float Class Methods
        demonstrateFloatMethods();
        
        // SECTION 7: Double Class Methods
        demonstrateDoubleMethods();
        
        // SECTION 8: Common Number Utility Methods
        demonstrateCommonUtils();
        
        // SECTION 9: Math Context and Rounding Methods
        demonstrateRoundingMethods();
        
        // SECTION 10: Bit Manipulation Methods
        demonstrateBitMethods();
        
        // SECTION 11: Parsing Methods
        demonstrateParsingMethods();
        
        // SECTION 12: Comparison Methods
        demonstrateComparisonMethods();
        
        // SECTION 13: Conversion Methods
        demonstrateConversionMethods();
        
        // SECTION 14: Constant Fields
        demonstrateConstants();
    }
    
    /**
     * SECTION 1: Number Abstract Class Methods (Methods 1-6)
     * These are abstract methods that all numeric wrapper classes implement
     */
    private static void demonstrateNumberAbstractMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 1: NUMBER ABSTRACT CLASS METHODS (6 Methods)");
        System.out.println("=".repeat(80));
        
        // Creating different Number objects
        Number intNum = Integer.valueOf(42);
        Number floatNum = Float.valueOf(3.14f);
        Number doubleNum = Double.valueOf(2.71828);
        Number longNum = Long.valueOf(123456789L);
        Number shortNum = Short.valueOf((short)100);
        Number byteNum = Byte.valueOf((byte)10);
        
        System.out.println("Testing Number objects with different values:");
        System.out.println("  Integer: " + intNum);
        System.out.println("  Float: " + floatNum);
        System.out.println("  Double: " + doubleNum);
        System.out.println("  Long: " + longNum);
        System.out.println("  Short: " + shortNum);
        System.out.println("  Byte: " + byteNum);
        
        // Method 1: intValue()
        System.out.println("\n1. intValue() - Converts to int:");
        System.out.println("   Integer 42 as int: " + intNum.intValue());
        System.out.println("   Float 3.14 as int: " + floatNum.intValue() + " (truncated)");
        System.out.println("   Double 2.718 as int: " + doubleNum.intValue() + " (truncated)");
        
        // Method 2: longValue()
        System.out.println("\n2. longValue() - Converts to long:");
        System.out.println("   Integer 42 as long: " + intNum.longValue());
        System.out.println("   Float 3.14 as long: " + floatNum.longValue());
        System.out.println("   Long 123456789 as long: " + longNum.longValue());
        
        // Method 3: floatValue()
        System.out.println("\n3. floatValue() - Converts to float:");
        System.out.println("   Integer 42 as float: " + intNum.floatValue());
        System.out.println("   Double 2.718 as float: " + doubleNum.floatValue());
        
        // Method 4: doubleValue()
        System.out.println("\n4. doubleValue() - Converts to double:");
        System.out.println("   Integer 42 as double: " + intNum.doubleValue());
        System.out.println("   Float 3.14 as double: " + floatNum.doubleValue());
        
        // Method 5: shortValue()
        System.out.println("\n5. shortValue() - Converts to short:");
        System.out.println("   Integer 42 as short: " + intNum.shortValue());
        System.out.println("   Short 100 as short: " + shortNum.shortValue());
        
        // Method 6: byteValue()
        System.out.println("\n6. byteValue() - Converts to byte:");
        System.out.println("   Integer 42 as byte: " + intNum.byteValue());
        System.out.println("   Byte 10 as byte: " + byteNum.byteValue());
    }
    
    /**
     * SECTION 2: Integer Class Methods (Methods 7-44)
     */
    private static void demonstrateIntegerMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 2: INTEGER CLASS METHODS (38 Methods)");
        System.out.println("=".repeat(80));
        
        int value = 42;
        Integer intObj = Integer.valueOf(42);
        String binaryStr = "101010";
        String hexStr = "2A";
        String octalStr = "52";
        
        // Method 7: Integer.toString(int i)
        System.out.println("\n7. toString(int i): " + Integer.toString(value) + 
            " - Converts int to String");
        
        // Method 8: Integer.toString(int i, int radix)
        System.out.println("8. toString(42, 2): " + Integer.toString(value, 2) + 
            " - Converts to String in given radix");
        System.out.println("   toString(42, 16): " + Integer.toString(value, 16));
        System.out.println("   toString(42, 8): " + Integer.toString(value, 8));
        
        // Method 9: Integer.toBinaryString(int i)
        System.out.println("9. toBinaryString(42): " + Integer.toBinaryString(value) + 
            " - Converts to binary string");
        
        // Method 10: Integer.toOctalString(int i)
        System.out.println("10. toOctalString(42): " + Integer.toOctalString(value) + 
            " - Converts to octal string");
        
        // Method 11: Integer.toHexString(int i)
        System.out.println("11. toHexString(42): " + Integer.toHexString(value) + 
            " - Converts to hex string");
        
        // Method 12: Integer.toUnsignedString(int i) - Java 8+
        System.out.println("12. toUnsignedString(42): " + Integer.toUnsignedString(value) + 
            " - Converts to unsigned string (Java 8+)");
        
        // Method 13: Integer.toUnsignedString(int i, int radix) - Java 8+
        System.out.println("13. toUnsignedString(42, 16): " + 
            Integer.toUnsignedString(value, 16) + " - Unsigned in given radix (Java 8+)");
        
        // Method 14: Integer.parseInt(String s)
        System.out.println("\n14. parseInt('42'): " + Integer.parseInt("42") + 
            " - Parses string to int");
        
        // Method 15: Integer.parseInt(String s, int radix)
        System.out.println("15. parseInt('101010', 2): " + 
            Integer.parseInt(binaryStr, 2) + " - Parses in given radix");
        System.out.println("   parseInt('2A', 16): " + Integer.parseInt(hexStr, 16));
        
        // Method 16: Integer.parseUnsignedInt(String s) - Java 8+
        System.out.println("16. parseUnsignedInt('42'): " + 
            Integer.parseUnsignedInt("42") + " - Parses unsigned int (Java 8+)");
        
        // Method 17: Integer.parseUnsignedInt(String s, int radix) - Java 8+
        System.out.println("17. parseUnsignedInt('101010', 2): " + 
            Integer.parseUnsignedInt(binaryStr, 2) + " - Parses unsigned in radix (Java 8+)");
        
        // Method 18: Integer.valueOf(int i)
        System.out.println("\n18. valueOf(42): " + Integer.valueOf(value) + 
            " - Returns Integer object");
        
        // Method 19: Integer.valueOf(String s)
        System.out.println("19. valueOf('42'): " + Integer.valueOf("42") + 
            " - Parses string to Integer");
        
        // Method 20: Integer.valueOf(String s, int radix)
        System.out.println("20. valueOf('101010', 2): " + 
            Integer.valueOf(binaryStr, 2) + " - Parses with radix to Integer");
        
        // Method 21: Integer.decode(String nm)
        System.out.println("\n21. decode():");
        System.out.println("   decode('42'): " + Integer.decode("42"));
        System.out.println("   decode('0x2A'): " + Integer.decode("0x2A"));
        System.out.println("   decode('#2A'): " + Integer.decode("#2A"));
        System.out.println("   decode('052'): " + Integer.decode("052"));
        
        // Method 22: Integer.bitCount(int i)
        System.out.println("\n22. bitCount(42): " + Integer.bitCount(value) + 
            " - Counts 1-bits in binary (42 binary: 101010 has 3 ones)");
        
        // Method 23: Integer.highestOneBit(int i)
        System.out.println("23. highestOneBit(42): " + Integer.highestOneBit(value) + 
            " - Returns highest one-bit (32)");
        
        // Method 24: Integer.lowestOneBit(int i)
        System.out.println("24. lowestOneBit(42): " + Integer.lowestOneBit(value) + 
            " - Returns lowest one-bit (2)");
        
        // Method 25: Integer.numberOfLeadingZeros(int i)
        System.out.println("25. numberOfLeadingZeros(42): " + 
            Integer.numberOfLeadingZeros(value) + " - Counts leading zeros");
        
        // Method 26: Integer.numberOfTrailingZeros(int i)
        System.out.println("26. numberOfTrailingZeros(42): " + 
            Integer.numberOfTrailingZeros(value) + " - Counts trailing zeros");
        
        // Method 27: Integer.reverse(int i)
        int reversed = Integer.reverse(value);
        System.out.println("27. reverse(42): " + reversed + " (" + 
            Integer.toBinaryString(reversed) + ") - Reverses bit order");
        
        // Method 28: Integer.reverseBytes(int i)
        int reversedBytes = Integer.reverseBytes(value);
        System.out.println("28. reverseBytes(42): " + reversedBytes + 
            " - Reverses byte order");
        
        // Method 29: Integer.rotateLeft(int i, int distance)
        int rotatedLeft = Integer.rotateLeft(value, 2);
        System.out.println("29. rotateLeft(42, 2): " + rotatedLeft + " (" + 
            Integer.toBinaryString(rotatedLeft) + ") - Rotates bits left");
        
        // Method 30: Integer.rotateRight(int i, int distance)
        int rotatedRight = Integer.rotateRight(value, 2);
        System.out.println("30. rotateRight(42, 2): " + rotatedRight + " (" + 
            Integer.toBinaryString(rotatedRight) + ") - Rotates bits right");
        
        // Method 31: Integer.signum(int i)
        System.out.println("\n31. signum():");
        System.out.println("   signum(42): " + Integer.signum(42));
        System.out.println("   signum(0): " + Integer.signum(0));
        System.out.println("   signum(-42): " + Integer.signum(-42));
        
        // Method 32: Integer.max(int a, int b)
        System.out.println("\n32. max(42, 100): " + Integer.max(42, 100) + 
            " - Returns maximum");
        
        // Method 33: Integer.min(int a, int b)
        System.out.println("33. min(42, 100): " + Integer.min(42, 100) + 
            " - Returns minimum");
        
        // Method 34: Integer.sum(int a, int b)
        System.out.println("34. sum(42, 100): " + Integer.sum(42, 100) + 
            " - Returns sum");
        
        // Method 35: Integer.compare(int x, int y)
        System.out.println("\n35. compare(42, 100): " + Integer.compare(42, 100));
        System.out.println("    compare(100, 42): " + Integer.compare(100, 42));
        System.out.println("    compare(42, 42): " + Integer.compare(42, 42));
        
        // Method 36: Integer.compareUnsigned(int x, int y) - Java 8+
        System.out.println("\n36. compareUnsigned(-1, 42): " + 
            Integer.compareUnsigned(-1, 42) + " (unsigned comparison) (Java 8+)");
        
        // Method 37: Integer.divideUnsigned(int dividend, int divisor) - Java 8+
        System.out.println("37. divideUnsigned(42, 3): " + 
            Integer.divideUnsigned(42, 3) + " - Unsigned division (Java 8+)");
        
        // Method 38: Integer.remainderUnsigned(int dividend, int divisor) - Java 8+
        System.out.println("38. remainderUnsigned(42, 5): " + 
            Integer.remainderUnsigned(42, 5) + " - Unsigned remainder (Java 8+)");
        
        // Method 39: Integer.toUnsignedLong(int x) - Java 8+
        System.out.println("39. toUnsignedLong(-1): " + 
            Integer.toUnsignedLong(-1) + " - Converts to unsigned long (Java 8+)");
        
        // Method 40: Integer.hashCode(int value)
        System.out.println("\n40. hashCode(42): " + Integer.hashCode(42) + 
            " - Returns hash code");
        
        // Method 41: Integer.getInteger(String nm)
        System.out.println("\n41. getInteger('java.version'): " + 
            Integer.getInteger("java.version") + " - Gets system property as Integer");
        
        // Method 42: Integer.getInteger(String nm, int val)
        System.out.println("42. getInteger('nonexistent', 100): " + 
            Integer.getInteger("nonexistent", 100) + " - With default value");
        
        // Method 43: Integer.getInteger(String nm, Integer val)
        System.out.println("43. getInteger('nonexistent', Integer.valueOf(200)): " + 
            Integer.getInteger("nonexistent", Integer.valueOf(200)));
        
        // Integer instance methods
        System.out.println("\nInteger Instance Methods:");
        System.out.println("   intValue(): " + intObj.intValue());
        System.out.println("   longValue(): " + intObj.longValue());
        System.out.println("   floatValue(): " + intObj.floatValue());
        System.out.println("   doubleValue(): " + intObj.doubleValue());
        System.out.println("   byteValue(): " + intObj.byteValue());
        System.out.println("   shortValue(): " + intObj.shortValue());
        System.out.println("   toString(): " + intObj.toString());
        System.out.println("   hashCode(): " + intObj.hashCode());
        System.out.println("   compareTo(100): " + intObj.compareTo(100));
        System.out.println("   equals(42): " + intObj.equals(42));
    }
    
    /**
     * SECTION 3: Long Class Methods (Methods 45-74)
     */
    private static void demonstrateLongMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 3: LONG CLASS METHODS (30 Methods)");
        System.out.println("=".repeat(80));
        
        long value = 123456789L;
        Long longObj = Long.valueOf(123456789L);
        
        // Method 45: Long.toString(long i)
        System.out.println("\n45. toString(123456789): " + Long.toString(value));
        
        // Method 46: Long.toString(long i, int radix)
        System.out.println("46. toString(123456789, 16): " + Long.toString(value, 16));
        
        // Method 47: Long.toBinaryString(long i)
        System.out.println("47. toBinaryString(123456789): " + Long.toBinaryString(value));
        
        // Method 48: Long.toOctalString(long i)
        System.out.println("48. toOctalString(123456789): " + Long.toOctalString(value));
        
        // Method 49: Long.toHexString(long i)
        System.out.println("49. toHexString(123456789): " + Long.toHexString(value));
        
        // Method 50: Long.toUnsignedString(long i) - Java 8+
        System.out.println("50. toUnsignedString(123456789): " + Long.toUnsignedString(value) + 
            " (Java 8+)");
        
        // Method 51: Long.parseLong(String s)
        System.out.println("\n51. parseLong('123456789'): " + Long.parseLong("123456789"));
        
        // Method 52: Long.parseLong(String s, int radix)
        System.out.println("52. parseLong('75bcd15', 16): " + 
            Long.parseLong("75bcd15", 16));
        
        // Method 53: Long.parseUnsignedLong(String s) - Java 8+
        System.out.println("53. parseUnsignedLong('123456789'): " + 
            Long.parseUnsignedLong("123456789") + " (Java 8+)");
        
        // Method 54: Long.valueOf(long l)
        System.out.println("\n54. valueOf(123456789): " + Long.valueOf(value));
        
        // Method 55: Long.valueOf(String s)
        System.out.println("55. valueOf('123456789'): " + Long.valueOf("123456789"));
        
        // Method 56: Long.decode(String nm)
        System.out.println("56. decode('0x75bcd15'): " + Long.decode("0x75bcd15"));
        
        // Method 57: Long.bitCount(long i)
        System.out.println("\n57. bitCount(123456789): " + Long.bitCount(value));
        
        // Method 58: Long.highestOneBit(long i)
        System.out.println("58. highestOneBit(123456789): " + Long.highestOneBit(value));
        
        // Method 59: Long.lowestOneBit(long i)
        System.out.println("59. lowestOneBit(123456789): " + Long.lowestOneBit(value));
        
        // Method 60: Long.numberOfLeadingZeros(long i)
        System.out.println("60. numberOfLeadingZeros(123456789): " + 
            Long.numberOfLeadingZeros(value));
        
        // Method 61: Long.numberOfTrailingZeros(long i)
        System.out.println("61. numberOfTrailingZeros(123456789): " + 
            Long.numberOfTrailingZeros(value));
        
        // Method 62: Long.reverse(long i)
        System.out.println("62. reverse(123456789): " + Long.reverse(value));
        
        // Method 63: Long.reverseBytes(long i)
        System.out.println("63. reverseBytes(123456789): " + Long.reverseBytes(value));
        
        // Method 64: Long.signum(long i)
        System.out.println("\n64. signum(123456789): " + Long.signum(value));
        System.out.println("    signum(-123456789): " + Long.signum(-value));
        
        // Method 65: Long.max(long a, long b)
        System.out.println("\n65. max(123456789, 987654321): " + 
            Long.max(value, 987654321L));
        
        // Method 66: Long.min(long a, long b)
        System.out.println("66. min(123456789, 987654321): " + 
            Long.min(value, 987654321L));
        
        // Method 67: Long.sum(long a, long b)
        System.out.println("67. sum(123456789, 876543211): " + 
            Long.sum(value, 876543211L));
        
        // Method 68: Long.compare(long x, long y)
        System.out.println("\n68. compare(123456789, 987654321): " + 
            Long.compare(value, 987654321L));
        
        // Method 69: Long.compareUnsigned(long x, long y) - Java 8+
        System.out.println("69. compareUnsigned(-1, 123456789): " + 
            Long.compareUnsigned(-1L, value) + " (Java 8+)");
        
        // Method 70: Long.divideUnsigned(long dividend, long divisor) - Java 8+
        System.out.println("70. divideUnsigned(123456789, 3): " + 
            Long.divideUnsigned(value, 3L) + " (Java 8+)");
        
        // Method 71: Long.remainderUnsigned(long dividend, long divisor) - Java 8+
        System.out.println("71. remainderUnsigned(123456789, 5): " + 
            Long.remainderUnsigned(value, 5L) + " (Java 8+)");
        
        // Method 72: Long.hashCode(long value)
        System.out.println("\n72. hashCode(123456789): " + Long.hashCode(value));
        
        // Method 73: Long.getLong(String nm)
        System.out.println("\n73. getLong('java.version'): " + 
            Long.getLong("java.version"));
        
        // Method 74: Long.getLong(String nm, long val)
        System.out.println("74. getLong('nonexistent', 999L): " + 
            Long.getLong("nonexistent", 999L));
        
        // Instance methods similar to Integer
        System.out.println("\nLong Instance Methods:");
        System.out.println("   longValue(): " + longObj.longValue());
        System.out.println("   intValue(): " + longObj.intValue() + " (truncated)");
    }
    
    /**
     * SECTION 4: Short Class Methods (Methods 75-92)
     */
    private static void demonstrateShortMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 4: SHORT CLASS METHODS (18 Methods)");
        System.out.println("=".repeat(80));
        
        short value = 12345;
        Short shortObj = Short.valueOf((short)12345);
        
        // Method 75: Short.toString(short s)
        System.out.println("\n75. toString(12345): " + Short.toString(value));
        
        // Method 76: Short.toUnsignedString(short s) - Java 8+ alternative
        System.out.println("76. Unsigned conversion using Short.toUnsignedInt():");
        int unsignedInt = Short.toUnsignedInt(value);
        System.out.println("    toUnsignedInt(12345): " + unsignedInt);
        System.out.println("    toUnsignedInt(-1): " + Short.toUnsignedInt((short)-1));
        
        // Method 77: Short.parseShort(String s)
        System.out.println("\n77. parseShort('12345'): " + Short.parseShort("12345"));
        
        // Method 78: Short.parseShort(String s, int radix)
        System.out.println("78. parseShort('3039', 16): " + Short.parseShort("3039", 16));
        
        // Method 79: Short.parseUnsignedShort - using toUnsignedInt instead
        System.out.println("\n79. Unsigned parsing (using Integer and casting):");
        int parsed = Integer.parseUnsignedInt("65535");
        short unsignedShort = (short) parsed;
        System.out.println("    Unsigned 65535 as short: " + unsignedShort + 
            " (interpreted as -1 in signed)");
        
        // Method 80: Short.valueOf(short s)
        System.out.println("\n80. valueOf(12345): " + Short.valueOf(value));
        
        // Method 81: Short.valueOf(String s)
        System.out.println("81. valueOf('12345'): " + Short.valueOf("12345"));
        
        // Method 82: Short.decode(String nm)
        System.out.println("82. decode('0x3039'): " + Short.decode("0x3039"));
        
        // Method 83: Short.reverseBytes(short i)
        System.out.println("\n83. reverseBytes(12345): " + Short.reverseBytes(value));
        
        // Method 84: Short.compare(short x, short y)
        System.out.println("\n84. compare(12345, 54321): " + 
            Short.compare(value, (short)54321));
        
        // Method 85: Short.compareUnsigned(short x, short y) - Java 8+
        // Using manual implementation
        System.out.println("85. compareUnsigned(-1, 12345): " + 
            "Manual: " + (Short.toUnsignedInt((short)-1) - Short.toUnsignedInt(value)));
        
        // Method 86: Short.toUnsignedInt(short x) - Java 8+
        System.out.println("\n86. toUnsignedInt(12345): " + Short.toUnsignedInt(value));
        System.out.println("    toUnsignedInt(-1): " + Short.toUnsignedInt((short)-1));
        
        // Method 87: Short.toUnsignedLong(short x) - Java 8+
        System.out.println("87. toUnsignedLong(12345): " + Short.toUnsignedLong(value));
        
        // Method 88: Short.hashCode(short value)
        System.out.println("\n88. hashCode(12345): " + Short.hashCode(value));
        
        // Method 89: Short.MAX_VALUE
        System.out.println("\n89. MAX_VALUE: " + Short.MAX_VALUE);
        
        // Method 90: Short.MIN_VALUE
        System.out.println("90. MIN_VALUE: " + Short.MIN_VALUE);
        
        // Method 91: Short.SIZE
        System.out.println("91. SIZE: " + Short.SIZE + " bits");
        
        // Method 92: Short.BYTES - Java 8+
        System.out.println("92. BYTES: " + Short.BYTES + " bytes (Java 8+)");
        
        // Instance methods
        System.out.println("\nShort Instance Methods:");
        System.out.println("   shortValue(): " + shortObj.shortValue());
        System.out.println("   intValue(): " + shortObj.intValue());
        System.out.println("   floatValue(): " + shortObj.floatValue());
    }
    
    /**
     * SECTION 5: Byte Class Methods (Methods 93-110)
     */
    private static void demonstrateByteMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 5: BYTE CLASS METHODS (18 Methods)");
        System.out.println("=".repeat(80));
        
        byte value = 127;
        Byte byteObj = Byte.valueOf((byte)127);
        
        // Method 93: Byte.toString(byte b)
        System.out.println("\n93. toString(127): " + Byte.toString(value));
        
        // Method 94: Byte.toUnsignedString alternative
        System.out.println("94. Unsigned conversion using Byte.toUnsignedInt():");
        int unsignedInt = Byte.toUnsignedInt(value);
        System.out.println("    toUnsignedInt(127): " + unsignedInt);
        System.out.println("    toUnsignedInt(-1): " + Byte.toUnsignedInt((byte)-1));
        
        // Method 95: Byte.parseByte(String s)
        System.out.println("\n95. parseByte('127'): " + Byte.parseByte("127"));
        
        // Method 96: Byte.parseByte(String s, int radix)
        System.out.println("96. parseByte('7F', 16): " + Byte.parseByte("7F", 16));
        
        // Method 97: Byte.parseUnsignedByte alternative
        System.out.println("\n97. Unsigned parsing (using Integer):");
        int parsed = Integer.parseUnsignedInt("255");
        byte unsignedByte = (byte) parsed;
        System.out.println("    Unsigned 255 as byte: " + unsignedByte + 
            " (interpreted as -1 in signed)");
        
        // Method 98: Byte.valueOf(byte b)
        System.out.println("\n98. valueOf(127): " + Byte.valueOf(value));
        
        // Method 99: Byte.valueOf(String s)
        System.out.println("99. valueOf('127'): " + Byte.valueOf("127"));
        
        // Method 100: Byte.decode(String nm)
        System.out.println("100. decode('0x7F'): " + Byte.decode("0x7F"));
        
        // Method 101: Byte.compare(byte x, byte y)
        System.out.println("\n101. compare(127, 100): " + 
            Byte.compare(value, (byte)100));
        
        // Method 102: Byte.compareUnsigned(byte x, byte y) - Java 8+
        System.out.println("102. compareUnsigned(-1, 127): " + 
            "Manual: " + (Byte.toUnsignedInt((byte)-1) - Byte.toUnsignedInt(value)));
        
        // Method 103: Byte.toUnsignedInt(byte x) - Java 8+
        System.out.println("\n103. toUnsignedInt(127): " + Byte.toUnsignedInt(value));
        System.out.println("    toUnsignedInt(-1): " + Byte.toUnsignedInt((byte)-1));
        
        // Method 104: Byte.toUnsignedLong(byte x) - Java 8+
        System.out.println("104. toUnsignedLong(127): " + Byte.toUnsignedLong(value));
        
        // Method 105: Byte.hashCode(byte value)
        System.out.println("\n105. hashCode(127): " + Byte.hashCode(value));
        
        // Method 106: Byte.MAX_VALUE
        System.out.println("\n106. MAX_VALUE: " + Byte.MAX_VALUE);
        
        // Method 107: Byte.MIN_VALUE
        System.out.println("107. MIN_VALUE: " + Byte.MIN_VALUE);
        
        // Method 108: Byte.SIZE
        System.out.println("108. SIZE: " + Byte.SIZE + " bits");
        
        // Method 109: Byte.BYTES - Java 8+
        System.out.println("109. BYTES: " + Byte.BYTES + " bytes (Java 8+)");
        
        // Instance methods
        System.out.println("\nByte Instance Methods:");
        System.out.println("   byteValue(): " + byteObj.byteValue());
        System.out.println("   intValue(): " + byteObj.intValue());
    }
    
    /**
     * SECTION 6: Float Class Methods (Methods 111-136)
     */
    private static void demonstrateFloatMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 6: FLOAT CLASS METHODS (26 Methods)");
        System.out.println("=".repeat(80));
        
        float value = 3.14159f;
        Float floatObj = Float.valueOf(3.14159f);
        float nan = Float.NaN;
        float infinity = Float.POSITIVE_INFINITY;
        
        // Method 111: Float.toString(float f)
        System.out.println("\n111. toString(3.14159f): " + Float.toString(value));
        
        // Method 112: Float.toHexString(float f)
        System.out.println("112. toHexString(3.14159f): " + Float.toHexString(value));
        
        // Method 113: Float.parseFloat(String s)
        System.out.println("\n113. parseFloat('3.14159'): " + Float.parseFloat("3.14159"));
        
        // Method 114: Float.valueOf(float f)
        System.out.println("\n114. valueOf(3.14159f): " + Float.valueOf(value));
        
        // Method 115: Float.valueOf(String s)
        System.out.println("115. valueOf('3.14159'): " + Float.valueOf("3.14159"));
        
        // Method 116: Float.isNaN(float v)
        System.out.println("\n116. isNaN():");
        System.out.println("    isNaN(3.14159): " + Float.isNaN(value));
        System.out.println("    isNaN(NaN): " + Float.isNaN(nan));
        
        // Method 117: Float.isInfinite(float v)
        System.out.println("\n117. isInfinite():");
        System.out.println("    isInfinite(3.14159): " + Float.isInfinite(value));
        System.out.println("    isInfinite(Infinity): " + Float.isInfinite(infinity));
        
        // Method 118: Float.isFinite(float f) (Java 8+)
        System.out.println("\n118. isFinite():");
        System.out.println("    isFinite(3.14159): " + Float.isFinite(value));
        System.out.println("    isFinite(Infinity): " + Float.isFinite(infinity));
        System.out.println("    isFinite(NaN): " + Float.isFinite(nan));
        
        // Method 119: Float.compare(float f1, float f2)
        System.out.println("\n119. compare(3.14159f, 2.71828f): " + 
            Float.compare(value, 2.71828f));
        System.out.println("    compare(NaN, 3.14159): " + Float.compare(nan, value));
        
        // Method 120: Float.max(float a, float b)
        System.out.println("\n120. max(3.14159f, 2.71828f): " + 
            Float.max(value, 2.71828f));
        
        // Method 121: Float.min(float a, float b)
        System.out.println("121. min(3.14159f, 2.71828f): " + 
            Float.min(value, 2.71828f));
        
        // Method 122: Float.sum(float a, float b)
        System.out.println("122. sum(3.14159f, 2.71828f): " + 
            Float.sum(value, 2.71828f));
        
        // Method 123: Float.floatToIntBits(float value)
        int bits = Float.floatToIntBits(value);
        System.out.println("\n123. floatToIntBits(3.14159): " + bits);
        
        // Method 124: Float.floatToRawIntBits(float value)
        int rawBits = Float.floatToRawIntBits(value);
        System.out.println("124. floatToRawIntBits(3.14159): " + rawBits);
        
        // Method 125: Float.intBitsToFloat(int bits)
        float back = Float.intBitsToFloat(bits);
        System.out.println("125. intBitsToFloat(" + bits + "): " + back);
        
        // Method 126: Float.hashCode(float value)
        System.out.println("\n126. hashCode(3.14159f): " + Float.hashCode(value));
        
        // Method 127: Float.NaN constant
        System.out.println("\n127. NaN: " + Float.NaN);
        
        // Method 128: Float.POSITIVE_INFINITY
        System.out.println("128. POSITIVE_INFINITY: " + Float.POSITIVE_INFINITY);
        
        // Method 129: Float.NEGATIVE_INFINITY
        System.out.println("129. NEGATIVE_INFINITY: " + Float.NEGATIVE_INFINITY);
        
        // Method 130: Float.MAX_VALUE
        System.out.println("130. MAX_VALUE: " + Float.MAX_VALUE);
        
        // Method 131: Float.MIN_VALUE
        System.out.println("131. MIN_VALUE: " + Float.MIN_VALUE);
        
        // Method 132: Float.MIN_NORMAL
        System.out.println("132. MIN_NORMAL: " + Float.MIN_NORMAL);
        
        // Method 133: Float.MAX_EXPONENT
        System.out.println("133. MAX_EXPONENT: " + Float.MAX_EXPONENT);
        
        // Method 134: Float.MIN_EXPONENT
        System.out.println("134. MIN_EXPONENT: " + Float.MIN_EXPONENT);
        
        // Method 135: Float.SIZE
        System.out.println("135. SIZE: " + Float.SIZE + " bits");
        
        // Method 136: Float.BYTES - Java 8+
        System.out.println("136. BYTES: " + Float.BYTES + " bytes (Java 8+)");
        
        // Instance methods
        System.out.println("\nFloat Instance Methods:");
        System.out.println("   floatValue(): " + floatObj.floatValue());
        System.out.println("   intValue(): " + floatObj.intValue() + " (truncated)");
        System.out.println("   isNaN(): " + floatObj.isNaN());
        System.out.println("   isInfinite(): " + floatObj.isInfinite());
    }
    
    /**
     * SECTION 7: Double Class Methods (Methods 137-162)
     */
    private static void demonstrateDoubleMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 7: DOUBLE CLASS METHODS (26 Methods)");
        System.out.println("=".repeat(80));
        
        double value = 3.14159265359;
        Double doubleObj = Double.valueOf(3.14159265359);
        double nan = Double.NaN;
        double infinity = Double.POSITIVE_INFINITY;
        
        // Method 137: Double.toString(double d)
        System.out.println("\n137. toString(3.14159265359): " + Double.toString(value));
        
        // Method 138: Double.toHexString(double d)
        System.out.println("138. toHexString(3.14159): " + Double.toHexString(value));
        
        // Method 139: Double.parseDouble(String s)
        System.out.println("\n139. parseDouble('3.14159'): " + Double.parseDouble("3.14159"));
        
        // Method 140: Double.valueOf(double d)
        System.out.println("\n140. valueOf(3.14159): " + Double.valueOf(value));
        
        // Method 141: Double.valueOf(String s)
        System.out.println("141. valueOf('3.14159'): " + Double.valueOf("3.14159"));
        
        // Method 142: Double.isNaN(double v)
        System.out.println("\n142. isNaN():");
        System.out.println("    isNaN(3.14159): " + Double.isNaN(value));
        System.out.println("    isNaN(NaN): " + Double.isNaN(nan));
        
        // Method 143: Double.isInfinite(double v)
        System.out.println("\n143. isInfinite():");
        System.out.println("    isInfinite(3.14159): " + Double.isInfinite(value));
        System.out.println("    isInfinite(Infinity): " + Double.isInfinite(infinity));
        
        // Method 144: Double.isFinite(double d) (Java 8+)
        System.out.println("\n144. isFinite():");
        System.out.println("    isFinite(3.14159): " + Double.isFinite(value));
        System.out.println("    isFinite(Infinity): " + Double.isFinite(infinity));
        
        // Method 145: Double.compare(double d1, double d2)
        System.out.println("\n145. compare(3.14159, 2.71828): " + 
            Double.compare(value, 2.71828));
        
        // Method 146: Double.max(double a, double b)
        System.out.println("\n146. max(3.14159, 2.71828): " + 
            Double.max(value, 2.71828));
        
        // Method 147: Double.min(double a, double b)
        System.out.println("147. min(3.14159, 2.71828): " + 
            Double.min(value, 2.71828));
        
        // Method 148: Double.sum(double a, double b)
        System.out.println("148. sum(3.14159, 2.71828): " + 
            Double.sum(value, 2.71828));
        
        // Method 149: Double.doubleToLongBits(double value)
        long bits = Double.doubleToLongBits(value);
        System.out.println("\n149. doubleToLongBits(3.14159): " + bits);
        
        // Method 150: Double.doubleToRawLongBits(double value)
        long rawBits = Double.doubleToRawLongBits(value);
        System.out.println("150. doubleToRawLongBits(3.14159): " + rawBits);
        
        // Method 151: Double.longBitsToDouble(long bits)
        double back = Double.longBitsToDouble(bits);
        System.out.println("151. longBitsToDouble(" + bits + "): " + back);
        
        // Method 152: Double.hashCode(double value)
        System.out.println("\n152. hashCode(3.14159): " + Double.hashCode(value));
        
        // Method 153: Double.NaN
        System.out.println("\n153. NaN: " + Double.NaN);
        
        // Method 154: Double.POSITIVE_INFINITY
        System.out.println("154. POSITIVE_INFINITY: " + Double.POSITIVE_INFINITY);
        
        // Method 155: Double.NEGATIVE_INFINITY
        System.out.println("155. NEGATIVE_INFINITY: " + Double.NEGATIVE_INFINITY);
        
        // Method 156: Double.MAX_VALUE
        System.out.println("156. MAX_VALUE: " + Double.MAX_VALUE);
        
        // Method 157: Double.MIN_VALUE
        System.out.println("157. MIN_VALUE: " + Double.MIN_VALUE);
        
        // Method 158: Double.MIN_NORMAL
        System.out.println("158. MIN_NORMAL: " + Double.MIN_NORMAL);
        
        // Method 159: Double.MAX_EXPONENT
        System.out.println("159. MAX_EXPONENT: " + Double.MAX_EXPONENT);
        
        // Method 160: Double.MIN_EXPONENT
        System.out.println("160. MIN_EXPONENT: " + Double.MIN_EXPONENT);
        
        // Method 161: Double.SIZE
        System.out.println("161. SIZE: " + Double.SIZE + " bits");
        
        // Method 162: Double.BYTES - Java 8+
        System.out.println("162. BYTES: " + Double.BYTES + " bytes (Java 8+)");
        
        // Instance methods
        System.out.println("\nDouble Instance Methods:");
        System.out.println("   doubleValue(): " + doubleObj.doubleValue());
        System.out.println("   intValue(): " + doubleObj.intValue());
        System.out.println("   isNaN(): " + doubleObj.isNaN());
    }
    
    /**
     * SECTION 8: Common Number Utility Methods (Methods 163-167)
     */
    private static void demonstrateCommonUtils() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 8: COMMON NUMBER UTILITY METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 163: Converting between types
        System.out.println("\n163. Type conversion examples:");
        int i = 42;
        long l = i;  // implicit widening
        float f = i; // implicit widening
        double d = i; // implicit widening
        
        short s = (short)i; // explicit narrowing
        byte b = (byte)i;   // explicit narrowing
        
        System.out.println("   int 42 to long: " + l);
        System.out.println("   int 42 to float: " + f);
        System.out.println("   int 42 to double: " + d);
        System.out.println("   int 42 to short: " + s);
        System.out.println("   int 42 to byte: " + b);
        
        // Method 164: Autoboxing and unboxing
        System.out.println("\n164. Autoboxing/Unboxing:");
        Integer autoBoxed = 42;  // autoboxing
        int autoUnboxed = autoBoxed; // unboxing
        System.out.println("   Autoboxed: " + autoBoxed);
        System.out.println("   Unboxed: " + autoUnboxed);
        
        // Method 165: getClass() from Object
        System.out.println("\n165. getClass() from Object:");
        System.out.println("   Integer class: " + Integer.valueOf(42).getClass());
        System.out.println("   Double class: " + Double.valueOf(3.14).getClass());
        
        // Method 166: wait/notify/notifyAll (from Object)
        System.out.println("\n166. Object methods (wait/notify/notifyAll)");
        System.out.println("   These are available but not typically used on Numbers");
        
        // Method 167: clone() from Object
        System.out.println("\n167. clone() - Number wrappers are immutable, clone not typically used");
    }
    
    /**
     * SECTION 9: Rounding Methods (Methods 168-172)
     */
    private static void demonstrateRoundingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 9: ROUNDING METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        double value = 3.7;
        
        // Method 168: Math.round() for float
        System.out.println("\n168. Math.round(float):");
        System.out.println("   round(3.7f): " + Math.round(3.7f));
        System.out.println("   round(3.2f): " + Math.round(3.2f));
        
        // Method 169: Math.round() for double
        System.out.println("\n169. Math.round(double):");
        System.out.println("   round(3.7): " + Math.round(3.7));
        System.out.println("   round(3.2): " + Math.round(3.2));
        
        // Method 170: Math.floor()
        System.out.println("\n170. Math.floor():");
        System.out.println("   floor(3.7): " + Math.floor(3.7));
        System.out.println("   floor(-3.7): " + Math.floor(-3.7));
        
        // Method 171: Math.ceil()
        System.out.println("\n171. Math.ceil():");
        System.out.println("   ceil(3.2): " + Math.ceil(3.2));
        System.out.println("   ceil(-3.2): " + Math.ceil(-3.2));
        
        // Method 172: Math.rint()
        System.out.println("\n172. Math.rint():");
        System.out.println("   rint(3.5): " + Math.rint(3.5));
        System.out.println("   rint(4.5): " + Math.rint(4.5));
    }
    
    /**
     * SECTION 10: Bit Manipulation Methods (Methods 173-177)
     */
    private static void demonstrateBitMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 10: BIT MANIPULATION METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        int a = 12;  // binary: 1100
        int b = 10;  // binary: 1010
        
        // Method 173: Integer.toBinaryString() - already covered
        System.out.println("\n173. toBinaryString(12): " + Integer.toBinaryString(a));
        
        // Method 174: Bitwise AND
        System.out.println("\n174. Bitwise AND (&):");
        System.out.println("   12 & 10 = " + (a & b) + " (binary: " + 
            Integer.toBinaryString(a & b) + ")");
        
        // Method 175: Bitwise OR
        System.out.println("\n175. Bitwise OR (|):");
        System.out.println("   12 | 10 = " + (a | b) + " (binary: " + 
            Integer.toBinaryString(a | b) + ")");
        
        // Method 176: Bitwise XOR
        System.out.println("\n176. Bitwise XOR (^):");
        System.out.println("   12 ^ 10 = " + (a ^ b) + " (binary: " + 
            Integer.toBinaryString(a ^ b) + ")");
        
        // Method 177: Bitwise Complement (~)
        System.out.println("\n177. Bitwise Complement (~):");
        System.out.println("   ~12 = " + (~a) + " (binary: " + 
            Integer.toBinaryString(~a) + ")");
    }
    
    /**
     * SECTION 11: Parsing Methods (Methods 178-182)
     */
    private static void demonstrateParsingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 11: PARSING METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 178: parseInt with different radices
        System.out.println("\n178. parseInt with different radices:");
        System.out.println("   Binary '1010' = " + Integer.parseInt("1010", 2));
        System.out.println("   Octal '12' = " + Integer.parseInt("12", 8));
        System.out.println("   Decimal '10' = " + Integer.parseInt("10", 10));
        System.out.println("   Hex 'A' = " + Integer.parseInt("A", 16));
        
        // Method 179: parseLong with different radices
        System.out.println("\n179. parseLong with different radices:");
        System.out.println("   Binary '1010' = " + Long.parseLong("1010", 2));
        
        // Method 180: parseFloat
        System.out.println("\n180. parseFloat:");
        System.out.println("   '3.14e2' = " + Float.parseFloat("3.14e2"));
        
        // Method 181: parseDouble
        System.out.println("\n181. parseDouble:");
        System.out.println("   '2.718e-3' = " + Double.parseDouble("2.718e-3"));
        
        // Method 182: decode (handles 0x, 0, # prefixes)
        System.out.println("\n182. decode with prefixes:");
        System.out.println("   '0x1F' = " + Integer.decode("0x1F"));
        System.out.println("   '037' = " + Integer.decode("037"));
        System.out.println("   '#FF' = " + Integer.decode("#FF"));
    }
    
    /**
     * SECTION 12: Comparison Methods (Methods 183-187)
     */
    private static void demonstrateComparisonMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 12: COMPARISON METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 183: compareTo (instance method)
        System.out.println("\n183. compareTo:");
        Integer i1 = 100;
        Integer i2 = 200;
        System.out.println("   100.compareTo(200): " + i1.compareTo(i2));
        
        // Method 184: equals (from Object)
        System.out.println("\n184. equals:");
        System.out.println("   100.equals(100): " + i1.equals(100));
        System.out.println("   100.equals(200): " + i1.equals(200));
        
        // Method 185: == operator vs equals
        System.out.println("\n185. == vs equals:");
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println("   127 == 127: " + (a == b) + " (cached within -128 to 127)");
        System.out.println("   128 == 128: " + (c == d) + " (not cached)");
        System.out.println("   128 equals 128: " + c.equals(d));
        
        // Method 186: compare (static)
        System.out.println("\n186. compare (static):");
        System.out.println("   compare(100, 200): " + Integer.compare(100, 200));
        
        // Method 187: compareUnsigned
        System.out.println("\n187. compareUnsigned (using manual conversion):");
        int unsigned1 = Integer.parseUnsignedInt("4294967295"); // -1 as unsigned
        int unsigned2 = 1;
        System.out.println("   Unsigned compare of -1 and 1: " + 
            Integer.compareUnsigned(-1, 1) + " (Java 8+)");
    }
    
    /**
     * SECTION 13: Conversion Methods (Methods 188-192)
     */
    private static void demonstrateConversionMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 13: CONVERSION METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 188: primitive to wrapper (valueOf)
        System.out.println("\n188. valueOf (primitive to wrapper):");
        Integer i = Integer.valueOf(42);
        Double d = Double.valueOf(3.14);
        System.out.println("   Integer.valueOf(42): " + i);
        
        // Method 189: wrapper to primitive (xxxValue)
        System.out.println("\n189. xxxValue (wrapper to primitive):");
        System.out.println("   intValue(): " + i.intValue());
        System.out.println("   doubleValue(): " + i.doubleValue());
        
        // Method 190: string to primitive (parseXxx)
        System.out.println("\n190. parseXxx (string to primitive):");
        System.out.println("   parseInt('42'): " + Integer.parseInt("42"));
        
        // Method 191: string to wrapper (valueOf)
        System.out.println("\n191. valueOf (string to wrapper):");
        System.out.println("   valueOf('42'): " + Integer.valueOf("42"));
        
        // Method 192: number to string (toString)
        System.out.println("\n192. toString (number to string):");
        System.out.println("   toString(42): " + Integer.toString(42));
    }
    
    /**
     * SECTION 14: Constants (Methods 193-202)
     */
    private static void demonstrateConstants() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 14: NUMBER CONSTANTS (10 Constants)");
        System.out.println("=".repeat(80));
        
        // Method 193: Integer.MIN_VALUE
        System.out.println("\n193. Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        
        // Method 194: Integer.MAX_VALUE
        System.out.println("194. Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        
        // Method 195: Long.MIN_VALUE
        System.out.println("\n195. Long.MIN_VALUE: " + Long.MIN_VALUE);
        
        // Method 196: Long.MAX_VALUE
        System.out.println("196. Long.MAX_VALUE: " + Long.MAX_VALUE);
        
        // Method 197: Short.MIN_VALUE
        System.out.println("\n197. Short.MIN_VALUE: " + Short.MIN_VALUE);
        
        // Method 198: Short.MAX_VALUE
        System.out.println("198. Short.MAX_VALUE: " + Short.MAX_VALUE);
        
        // Method 199: Byte.MIN_VALUE
        System.out.println("\n199. Byte.MIN_VALUE: " + Byte.MIN_VALUE);
        
        // Method 200: Byte.MAX_VALUE
        System.out.println("200. Byte.MAX_VALUE: " + Byte.MAX_VALUE);
        
        // Method 201: Float constants
        System.out.println("\n201. Float constants:");
        System.out.println("    Float.MIN_VALUE: " + Float.MIN_VALUE);
        System.out.println("    Float.MAX_VALUE: " + Float.MAX_VALUE);
        System.out.println("    Float.POSITIVE_INFINITY: " + Float.POSITIVE_INFINITY);
        System.out.println("    Float.NEGATIVE_INFINITY: " + Float.NEGATIVE_INFINITY);
        System.out.println("    Float.NaN: " + Float.NaN);
        
        // Method 202: Double constants
        System.out.println("\n202. Double constants:");
        System.out.println("    Double.MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("    Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("    Double.POSITIVE_INFINITY: " + Double.POSITIVE_INFINITY);
        System.out.println("    Double.NEGATIVE_INFINITY: " + Double.NEGATIVE_INFINITY);
        System.out.println("    Double.NaN: " + Double.NaN);
    }
}