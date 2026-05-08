/**
 * COMPREHENSIVE STRING vs STRINGBUFFER vs STRINGBUILDER COMPARISON
 * All methods demonstrated method-wise with examples
 */
public class StringComparisonComplete {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(100));
        System.out.println("COMPLETE STRING vs STRINGBUFFER vs STRINGBUILDER COMPARISON");
        System.out.println("=".repeat(100));
        
        // SECTION 1: Creation Methods
        demonstrateCreationMethods();
        
        // SECTION 2: Basic Operations
        demonstrateBasicOperations();
        
        // SECTION 3: Character Operations
        demonstrateCharacterOperations();
        
        // SECTION 4: Comparison Methods
        demonstrateComparisonMethods();
        
        // SECTION 5: Search Methods
        demonstrateSearchMethods();
        
        // SECTION 6: Extraction Methods
        demonstrateExtractionMethods();
        
        // SECTION 7: Modification Methods
        demonstrateModificationMethods();
        
        // SECTION 8: Conversion Methods
        demonstrateConversionMethods();
        
        // SECTION 9: Capacity Methods (StringBuffer/StringBuilder only)
        demonstrateCapacityMethods();
        
        // SECTION 10: Thread Safety Demonstration
        demonstrateThreadSafety();
        
        // SECTION 11: Performance Comparison
        demonstratePerformance();
        
        // SECTION 12: Real-World Examples
        demonstrateRealWorldExamples();
    }
    
    // =========================================================================
    // SECTION 1: CREATION METHODS
    // =========================================================================
    
    private static void demonstrateCreationMethods() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 1: CREATION METHODS");
        System.out.println("#".repeat(80));
        
        // STRING Creation
        System.out.println("\n📌 STRING Creation Methods:");
        
        // 1. String literal
        String s1 = "Hello";
        System.out.println("1. String literal: " + s1);
        
        // 2. Using new keyword
        String s2 = new String("Hello");
        System.out.println("2. new String(): " + s2);
        
        // 3. From char array
        char[] chars = {'J', 'a', 'v', 'a'};
        String s3 = new String(chars);
        System.out.println("3. From char array: " + s3);
        
        // 4. From byte array
        byte[] bytes = {65, 66, 67, 68};
        String s4 = new String(bytes);
        System.out.println("4. From byte array: " + s4);
        
        // 5. valueOf() methods
        String s5 = String.valueOf(123);
        String s6 = String.valueOf(true);
        System.out.println("5. valueOf(123): " + s5);
        System.out.println("   valueOf(true): " + s6);
        
        // 6. join() - Java 8+
        String s7 = String.join("-", "2024", "03", "18");
        System.out.println("6. join(): " + s7);
        
        // 7. format()
        String s8 = String.format("Hello %s, age %d", "John", 25);
        System.out.println("7. format(): " + s8);
        
        // 8. repeat() - Java 11+
        String s9 = "Ha".repeat(3);
        System.out.println("8. repeat(): " + s9);
        
        // STRINGBUFFER Creation
        System.out.println("\n📌 STRINGBUFFER Creation Methods:");
        
        // 1. Default constructor (capacity 16)
        StringBuffer sb1 = new StringBuffer();
        System.out.println("1. new StringBuffer(): capacity=" + sb1.capacity());
        
        // 2. With initial string
        StringBuffer sb2 = new StringBuffer("Hello");
        System.out.println("2. new StringBuffer(\"Hello\"): " + sb2);
        
        // 3. With custom capacity
        StringBuffer sb3 = new StringBuffer(50);
        System.out.println("3. new StringBuffer(50): capacity=" + sb3.capacity());
        
        // 4. From CharSequence
        StringBuffer sb4 = new StringBuffer("Hello World");
        System.out.println("4. new StringBuffer(\"Hello World\"): " + sb4);
        
        // STRINGBUILDER Creation
        System.out.println("\n📌 STRINGBUILDER Creation Methods:");
        
        // 1. Default constructor
        StringBuilder sbld1 = new StringBuilder();
        System.out.println("1. new StringBuilder(): capacity=" + sbld1.capacity());
        
        // 2. With initial string
        StringBuilder sbld2 = new StringBuilder("Hello");
        System.out.println("2. new StringBuilder(\"Hello\"): " + sbld2);
        
        // 3. With custom capacity
        StringBuilder sbld3 = new StringBuilder(50);
        System.out.println("3. new StringBuilder(50): capacity=" + sbld3.capacity());
    }
    
    // =========================================================================
    // SECTION 2: BASIC OPERATIONS
    // =========================================================================
    
    private static void demonstrateBasicOperations() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 2: BASIC OPERATIONS");
        System.out.println("#".repeat(80));
        
        String str = "Hello World";
        StringBuffer sbf = new StringBuffer("Hello World");
        StringBuilder sbd = new StringBuilder("Hello World");
        
        System.out.println("\n📌 length() - Get length:");
        System.out.println("   String: " + str.length());
        System.out.println("   StringBuffer: " + sbf.length());
        System.out.println("   StringBuilder: " + sbd.length());
        
        System.out.println("\n📌 isEmpty() / length()==0:");
        String empty = "";
        System.out.println("   String empty: " + empty.isEmpty());
        System.out.println("   StringBuffer empty: " + (new StringBuffer().length() == 0));
        
        System.out.println("\n📌 charAt() - Get character at index:");
        System.out.println("   String charAt(0): " + str.charAt(0));
        System.out.println("   StringBuffer charAt(0): " + sbf.charAt(0));
        System.out.println("   StringBuilder charAt(0): " + sbd.charAt(0));
    }
    
    // =========================================================================
    // SECTION 3: CHARACTER OPERATIONS
    // =========================================================================
    
    private static void demonstrateCharacterOperations() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 3: CHARACTER OPERATIONS");
        System.out.println("#".repeat(80));
        
        String str = "Hello World 123";
        
        // STRING Methods
        System.out.println("\n📌 STRING Character Methods:");
        System.out.println("   toUpperCase(): " + str.toUpperCase());
        System.out.println("   toLowerCase(): " + str.toLowerCase());
        System.out.println("   charAt(1): " + str.charAt(1));
        System.out.println("   codePointAt(1): " + str.codePointAt(1));
        System.out.println("   codePointBefore(2): " + str.codePointBefore(2));
        System.out.println("   codePointCount(0,5): " + str.codePointCount(0, 5));
        
        // STRINGBUFFER/STRINGBUILDER Methods
        System.out.println("\n📌 STRINGBUFFER/STRINGBUILDER Character Methods:");
        StringBuffer sbf = new StringBuffer("Hello World");
        StringBuilder sbd = new StringBuilder("Hello World");
        
        // setCharAt() - modifies the original
        sbf.setCharAt(0, 'h');
        sbd.setCharAt(0, 'h');
        System.out.println("   setCharAt(0, 'h') - StringBuffer: " + sbf);
        System.out.println("   setCharAt(0, 'h') - StringBuilder: " + sbd);
        
        // getChars() - copy to array
        char[] dst = new char[5];
        sbf.getChars(0, 5, dst, 0);
        System.out.println("   getChars(0,5): " + java.util.Arrays.toString(dst));
    }
    
    // =========================================================================
    // SECTION 4: COMPARISON METHODS
    // =========================================================================
    
    private static void demonstrateComparisonMethods() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 4: COMPARISON METHODS");
        System.out.println("#".repeat(80));
        
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "hello";
        
        System.out.println("\n📌 equals() - Content comparison:");
        System.out.println("   s1.equals(s2): " + s1.equals(s2));
        System.out.println("   s1.equals(s3): " + s1.equals(s3));
        
        System.out.println("\n📌 equalsIgnoreCase():");
        System.out.println("   s1.equalsIgnoreCase(s3): " + s1.equalsIgnoreCase(s3));
        
        System.out.println("\n📌 compareTo() - Lexicographic comparison:");
        System.out.println("   s1.compareTo(s2): " + s1.compareTo(s2));
        System.out.println("   s1.compareTo(s3): " + s1.compareTo(s3));
        
        System.out.println("\n📌 compareToIgnoreCase():");
        System.out.println("   s1.compareToIgnoreCase(s3): " + s1.compareToIgnoreCase(s3));
        
        System.out.println("\n📌 contentEquals() - Compare with StringBuffer/StringBuilder:");
        System.out.println("   s1.contentEquals(new StringBuffer(\"Hello\")): " + 
                          s1.contentEquals(new StringBuffer("Hello")));
        
        // StringBuffer/StringBuilder comparison
        System.out.println("\n📌 StringBuffer/StringBuilder Comparison (via String):");
        StringBuffer sbf1 = new StringBuffer("Hello");
        StringBuffer sbf2 = new StringBuffer("Hello");
        StringBuilder sbd1 = new StringBuilder("Hello");
        
        System.out.println("   sbf1.toString().equals(sbf2.toString()): " + 
                          sbf1.toString().equals(sbf2.toString()));
        System.out.println("   sbf1.toString().equals(sbd1.toString()): " + 
                          sbf1.toString().equals(sbd1.toString()));
    }
    
    // =========================================================================
    // SECTION 5: SEARCH METHODS
    // =========================================================================
    
    private static void demonstrateSearchMethods() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 5: SEARCH METHODS");
        System.out.println("#".repeat(80));
        
        String str = "Hello World, Hello Java";
        StringBuffer sbf = new StringBuffer(str);
        StringBuilder sbd = new StringBuilder(str);
        
        System.out.println("\n📌 indexOf() - First occurrence:");
        System.out.println("   indexOf('o'): " + str.indexOf('o'));
        System.out.println("   indexOf(\"World\"): " + str.indexOf("World"));
        System.out.println("   indexOf('o', 5): " + str.indexOf('o', 5));
        
        System.out.println("\n📌 lastIndexOf() - Last occurrence:");
        System.out.println("   lastIndexOf('o'): " + str.lastIndexOf('o'));
        System.out.println("   lastIndexOf(\"Hello\"): " + str.lastIndexOf("Hello"));
        System.out.println("   lastIndexOf('o', 10): " + str.lastIndexOf('o', 10));
        
        System.out.println("\n📌 contains() - Check if substring exists:");
        System.out.println("   contains(\"World\"): " + str.contains("World"));
        System.out.println("   contains(\"Java\"): " + str.contains("Java"));
        
        System.out.println("\n📌 startsWith() / endsWith():");
        System.out.println("   startsWith(\"Hello\"): " + str.startsWith("Hello"));
        System.out.println("   endsWith(\"Java\"): " + str.endsWith("Java"));
        System.out.println("   startsWith(\"World\", 6): " + str.startsWith("World", 6));
        
        // Same methods available in StringBuffer/StringBuilder via toString()
        System.out.println("\n📌 StringBuffer/StringBuilder via toString():");
        System.out.println("   sbf.toString().indexOf('o'): " + sbf.toString().indexOf('o'));
    }
    
    // =========================================================================
    // SECTION 6: EXTRACTION METHODS
    // =========================================================================
    
    private static void demonstrateExtractionMethods() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 6: EXTRACTION METHODS");
        System.out.println("#".repeat(80));
        
        String str = "Hello World Java";
        
        System.out.println("\n📌 substring() - Extract part of string:");
        System.out.println("   substring(6): " + str.substring(6));
        System.out.println("   substring(0,5): " + str.substring(0, 5));
        
        System.out.println("\n📌 subSequence() - Returns CharSequence:");
        System.out.println("   subSequence(6,11): " + str.subSequence(6, 11));
        
        System.out.println("\n📌 split() - Split into array:");
        String[] parts = str.split(" ");
        System.out.println("   split(\" \"): " + java.util.Arrays.toString(parts));
        
        System.out.println("\n📌 toCharArray() - Convert to char array:");
        char[] chars = str.toCharArray();
        System.out.println("   toCharArray(): " + java.util.Arrays.toString(chars));
        
        System.out.println("\n📌 getBytes() - Convert to bytes:");
        byte[] bytes = str.getBytes();
        System.out.println("   getBytes() length: " + bytes.length);
        
        // StringBuffer/StringBuilder extraction
        System.out.println("\n📌 StringBuffer/StringBuilder Extraction:");
        StringBuffer sbf = new StringBuffer(str);
        System.out.println("   substring(6): " + sbf.substring(6));
        System.out.println("   substring(0,5): " + sbf.substring(0, 5));
        System.out.println("   subSequence(6,11): " + sbf.subSequence(6, 11));
    }
    
    // =========================================================================
    // SECTION 7: MODIFICATION METHODS
    // =========================================================================
    
    private static void demonstrateModificationMethods() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 7: MODIFICATION METHODS");
        System.out.println("#".repeat(80));
        
        // STRING - Immutable (returns new string)
        System.out.println("\n📌 STRING Modification (returns new string):");
        String str = "Hello World";
        System.out.println("   Original: " + str);
        System.out.println("   concat(\"!\"): " + str.concat("!"));
        System.out.println("   replace('o', 'O'): " + str.replace('o', 'O'));
        System.out.println("   replace(\"World\", \"Java\"): " + str.replace("World", "Java"));
        System.out.println("   replaceAll(\"[aeiou]\", \"*\"): " + str.replaceAll("[aeiou]", "*"));
        System.out.println("   replaceFirst(\"o\", \"O\"): " + str.replaceFirst("o", "O"));
        System.out.println("   toUpperCase(): " + str.toUpperCase());
        System.out.println("   toLowerCase(): " + str.toLowerCase());
        System.out.println("   trim(): '" + "  Hello  ".trim() + "'");
        System.out.println("   strip(): '" + "  Hello  ".strip() + "'"); // Java 11
        System.out.println("   stripLeading(): '" + "  Hello  ".stripLeading() + "'");
        System.out.println("   stripTrailing(): '" + "  Hello  ".stripTrailing() + "'");
        System.out.println("   indent(4):\n" + "Hello\nWorld".indent(4)); // Java 12
        
        // STRINGBUFFER - Mutable (modifies same object)
        System.out.println("\n📌 STRINGBUFFER Modification (modifies same object):");
        StringBuffer sbf = new StringBuffer("Hello World");
        System.out.println("   Original: " + sbf);
        System.out.println("   HashCode: " + System.identityHashCode(sbf));
        
        sbf.append("!");
        System.out.println("   append(\"!\"): " + sbf + " (same object)");
        
        sbf.insert(5, " Beautiful");
        System.out.println("   insert(5, \" Beautiful\"): " + sbf);
        
        sbf.delete(5, 15);
        System.out.println("   delete(5, 15): " + sbf);
        
        sbf.deleteCharAt(5);
        System.out.println("   deleteCharAt(5): " + sbf);
        
        sbf.replace(6, 11, "Java");
        System.out.println("   replace(6, 11, \"Java\"): " + sbf);
        
        sbf.reverse();
        System.out.println("   reverse(): " + sbf);
        sbf.reverse(); // Reverse back
        
        sbf.setLength(5);
        System.out.println("   setLength(5): " + sbf);
        
        // STRINGBUILDER - Mutable (same operations)
        System.out.println("\n📌 STRINGBUILDER Modification (same operations):");
        StringBuilder sbd = new StringBuilder("Hello World");
        System.out.println("   Original: " + sbd);
        
        sbd.append("!");
        System.out.println("   append(\"!\"): " + sbd);
        
        sbd.insert(5, " Beautiful");
        System.out.println("   insert(5, \" Beautiful\"): " + sbd);
        
        sbd.delete(5, 15);
        System.out.println("   delete(5, 15): " + sbd);
        
        sbd.replace(6, 11, "Java");
        System.out.println("   replace(6, 11, \"Java\"): " + sbd);
        
        sbd.reverse();
        System.out.println("   reverse(): " + sbd);
    }
    
    // =========================================================================
    // SECTION 8: CONVERSION METHODS
    // =========================================================================
    
    private static void demonstrateConversionMethods() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 8: CONVERSION METHODS");
        System.out.println("#".repeat(80));
        
        String str = "Hello World";
        
        System.out.println("\n📌 toString() - Convert to String:");
        System.out.println("   String toString(): " + str.toString());
        System.out.println("   StringBuffer toString(): " + new StringBuffer(str).toString());
        System.out.println("   StringBuilder toString(): " + new StringBuilder(str).toString());
        
        System.out.println("\n📌 toCharArray():");
        char[] chars = str.toCharArray();
        System.out.println("   char[]: " + java.util.Arrays.toString(chars));
        
        System.out.println("\n📌 getBytes():");
        byte[] bytes = str.getBytes();
        System.out.println("   byte[] length: " + bytes.length);
        
        System.out.println("\n📌 valueOf() - Convert primitives to String:");
        System.out.println("   valueOf(123): " + String.valueOf(123));
        System.out.println("   valueOf(45.67): " + String.valueOf(45.67));
        System.out.println("   valueOf(true): " + String.valueOf(true));
        System.out.println("   valueOf('A'): " + String.valueOf('A'));
        
        System.out.println("\n📌 format() / formatted():");
        System.out.println("   format(\"Hello %s\", \"John\"): " + 
                          String.format("Hello %s", "John"));
        System.out.println("   \"Hello %s\".formatted(\"John\"): " + 
                          "Hello %s".formatted("John")); // Java 15
        
        System.out.println("\n📌 join() / concat():");
        System.out.println("   join(\"-\", \"A\", \"B\", \"C\"): " + 
                          String.join("-", "A", "B", "C"));
        System.out.println("   concat(\"!\"): " + "Hello".concat("!"));
        
        // String to StringBuffer/StringBuilder
        System.out.println("\n📌 String to StringBuffer/StringBuilder:");
        StringBuffer sbf = new StringBuffer(str);
        StringBuilder sbd = new StringBuilder(str);
        System.out.println("   StringBuffer from String: " + sbf);
        System.out.println("   StringBuilder from String: " + sbd);
    }
    
    // =========================================================================
    // SECTION 9: CAPACITY METHODS (StringBuffer/StringBuilder only)
    // =========================================================================
    
    private static void demonstrateCapacityMethods() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 9: CAPACITY METHODS (StringBuffer/StringBuilder only)");
        System.out.println("#".repeat(80));
        
        StringBuffer sbf = new StringBuffer(10);
        StringBuilder sbd = new StringBuilder(10);
        
        System.out.println("\n📌 capacity() - Get current capacity:");
        System.out.println("   StringBuffer capacity: " + sbf.capacity());
        System.out.println("   StringBuilder capacity: " + sbd.capacity());
        
        sbf.append("1234567890");
        sbd.append("1234567890");
        System.out.println("\n   After appending 10 chars:");
        System.out.println("   StringBuffer capacity: " + sbf.capacity());
        System.out.println("   StringBuilder capacity: " + sbd.capacity());
        
        sbf.append("1");
        sbd.append("1");
        System.out.println("\n   After appending 1 more char (capacity auto-increases):");
        System.out.println("   StringBuffer new capacity: " + sbf.capacity());
        System.out.println("   StringBuilder new capacity: " + sbd.capacity());
        
        System.out.println("\n📌 ensureCapacity() - Ensure minimum capacity:");
        sbf.ensureCapacity(100);
        sbd.ensureCapacity(100);
        System.out.println("   After ensureCapacity(100):");
        System.out.println("   StringBuffer: " + sbf.capacity());
        System.out.println("   StringBuilder: " + sbd.capacity());
        
        System.out.println("\n📌 length() and setLength():");
        System.out.println("   Current length: " + sbf.length());
        sbf.setLength(5);
        sbd.setLength(5);
        System.out.println("   After setLength(5): " + sbf);
        System.out.println("   New length: " + sbf.length());
        
        System.out.println("\n📌 trimToSize() - Reduce capacity to current length:");
        sbf.trimToSize();
        sbd.trimToSize();
        System.out.println("   After trimToSize():");
        System.out.println("   StringBuffer capacity: " + sbf.capacity());
        System.out.println("   StringBuilder capacity: " + sbd.capacity());
    }
    
    // =========================================================================
    // SECTION 10: THREAD SAFETY DEMONSTRATION
    // =========================================================================
    
    private static void demonstrateThreadSafety() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 10: THREAD SAFETY DEMONSTRATION");
        System.out.println("#".repeat(80));
        
        // StringBuffer (Thread-safe)
        System.out.println("\n📌 StringBuffer - Thread Safe (Synchronized):");
        StringBuffer sharedBuffer = new StringBuffer();
        Thread[] threads = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    sharedBuffer.append("a");
                }
            });
        }
        
        for (Thread t : threads) t.start();
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        System.out.println("   Expected length: 10000");
        System.out.println("   Actual length: " + sharedBuffer.length());
        System.out.println("   ✓ StringBuffer is thread-safe");
        
        // StringBuilder (Not thread-safe)
        System.out.println("\n📌 StringBuilder - NOT Thread Safe:");
        StringBuilder sharedBuilder = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    sharedBuilder.append("a");
                }
            });
        }
        
        for (Thread t : threads) t.start();
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        System.out.println("   Expected length: 10000");
        System.out.println("   Actual length: " + sharedBuilder.length());
        System.out.println("   ⚠️ StringBuilder may show data corruption!");
    }
    
    // =========================================================================
    // SECTION 11: PERFORMANCE COMPARISON
    // =========================================================================
    
    private static void demonstratePerformance() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 11: PERFORMANCE COMPARISON");
        System.out.println("#".repeat(80));
        
        int iterations = 100000;
        
        // String
        System.out.println("\n📌 String Performance:");
        long start = System.currentTimeMillis();
        String strResult = "";
        for (int i = 0; i < iterations; i++) {
            strResult += "a";
        }
        long stringTime = System.currentTimeMillis() - start;
        System.out.println("   String (" + iterations + " concats): " + stringTime + "ms");
        
        // StringBuffer
        System.out.println("\n📌 StringBuffer Performance:");
        start = System.currentTimeMillis();
        StringBuffer sbfResult = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbfResult.append("a");
        }
        long bufferTime = System.currentTimeMillis() - start;
        System.out.println("   StringBuffer (" + iterations + " appends): " + bufferTime + "ms");
        
        // StringBuilder
        System.out.println("\n📌 StringBuilder Performance:");
        start = System.currentTimeMillis();
        StringBuilder sbdResult = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbdResult.append("a");
        }
        long builderTime = System.currentTimeMillis() - start;
        System.out.println("   StringBuilder (" + iterations + " appends): " + builderTime + "ms");
        
        System.out.println("\n📊 Performance Comparison:");
        System.out.println("   String is " + (stringTime / (builderTime + 1)) + "x slower than StringBuilder");
        System.out.println("   StringBuffer is " + (bufferTime / (builderTime + 1)) + "x slower than StringBuilder");
    }
    
    // =========================================================================
    // SECTION 12: REAL-WORLD EXAMPLES
    // =========================================================================
    
    private static void demonstrateRealWorldExamples() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("SECTION 12: REAL-WORLD EXAMPLES");
        System.out.println("#".repeat(80));
        
        // Example 1: Building SQL Query
        System.out.println("\n📌 Example 1: Building SQL Query");
        String[] columns = {"id", "name", "email", "created_at"};
        
        // Using String (BAD)
        long start = System.currentTimeMillis();
        String sqlString = "SELECT ";
        for (int i = 0; i < columns.length; i++) {
            sqlString += columns[i];
            if (i < columns.length - 1) sqlString += ", ";
        }
        sqlString += " FROM users WHERE active = true ORDER BY name";
        long stringTime = System.currentTimeMillis() - start;
        
        // Using StringBuilder (GOOD)
        start = System.currentTimeMillis();
        StringBuilder sqlBuilder = new StringBuilder("SELECT ");
        for (int i = 0; i < columns.length; i++) {
            sqlBuilder.append(columns[i]);
            if (i < columns.length - 1) sqlBuilder.append(", ");
        }
        sqlBuilder.append(" FROM users WHERE active = true ORDER BY name");
        long builderTime = System.currentTimeMillis() - start;
        
        System.out.println("   SQL Query: " + sqlBuilder.toString());
        System.out.println("   String time: " + stringTime + "ms");
        System.out.println("   StringBuilder time: " + builderTime + "ms");
        
        // Example 2: Building JSON
        System.out.println("\n📌 Example 2: Building JSON");
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"name\": \"John Doe\",\n");
        json.append("  \"age\": 30,\n");
        json.append("  \"email\": \"john@example.com\",\n");
        json.append("  \"address\": {\n");
        json.append("    \"street\": \"123 Main St\",\n");
        json.append("    \"city\": \"New York\",\n");
        json.append("    \"zip\": \"10001\"\n");
        json.append("  },\n");
        json.append("  \"hobbies\": [\"reading\", \"swimming\", \"coding\"]\n");
        json.append("}");
        
        System.out.println("   JSON:\n" + json.toString());
        
        // Example 3: String manipulation
        System.out.println("\n📌 Example 3: String Manipulation");
        String text = "  Hello World, Welcome to Java Programming  ";
        
        System.out.println("   Original: '" + text + "'");
        System.out.println("   trim(): '" + text.trim() + "'");
        System.out.println("   toUpperCase(): '" + text.toUpperCase().trim() + "'");
        System.out.println("   replace vowels: '" + 
                          text.toLowerCase().replaceAll("[aeiou]", "*").trim() + "'");
        
        // Example 4: CSV Processing
        System.out.println("\n📌 Example 4: CSV Processing");
        String csvData = "John,30,New York\nJane,25,Boston\nBob,35,Chicago";
        String[] lines = csvData.split("\n");
        
        StringBuilder csvOutput = new StringBuilder("Name\tAge\tCity\n");
        csvOutput.append("-".repeat(20)).append("\n");
        
        for (String line : lines) {
            String[] fields = line.split(",");
            csvOutput.append(fields[0]).append("\t")
                     .append(fields[1]).append("\t")
                     .append(fields[2]).append("\n");
        }
        
        System.out.println("   CSV as Table:\n" + csvOutput);
        
        // Example 5: Log message builder
        System.out.println("\n📌 Example 5: Log Message Builder");
        StringBuffer logBuffer = new StringBuffer();
        logBuffer.append("[INFO] ").append(java.time.LocalDateTime.now()).append(" - ");
        logBuffer.append("User ").append("john_doe").append(" ");
        logBuffer.append("logged in from ").append("192.168.1.100");
        
        System.out.println("   Log entry: " + logBuffer);
    }
}


// Summary Table
// Aspect	String	StringBuffer	StringBuilder
// Storage	String pool or heap	Heap	Heap
// Object Creation	New object on modification	Same object modified	Same object modified
// Thread Safety	Yes (immutable)	Yes (synchronized)	No
// Performance	Poor for modifications	Good	Best
// Memory Efficiency	Poor (creates garbage)	Good	Good
// Introduced	Java 1.0	Java 1.0	Java 1.5
// Package	java.lang	java.lang	java.lang
