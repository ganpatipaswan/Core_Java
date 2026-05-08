import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Program to demonstrate all array methods in Java
 * This program shows the purpose and usage of:
 * - Arrays class methods
 * - Array declaration and initialization
 * - Array operations and manipulations
 * - Array streaming methods
 */
public class AllArrayMethods {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(100));
        System.out.println("COMPREHENSIVE DEMONSTRATION OF ARRAY METHODS IN JAVA");
        System.out.println("=".repeat(100));
        
        // SECTION 1: Array Declaration and Initialization
        demonstrateArrayCreation();
        
        // SECTION 2: Arrays Class - Sorting Methods
        demonstrateSortingMethods();
        
        // SECTION 3: Arrays Class - Searching Methods
        demonstrateSearchingMethods();
        
        // SECTION 4: Arrays Class - Comparison Methods
        demonstrateComparisonMethods();
        
        // SECTION 5: Arrays Class - Filling Methods
        demonstrateFillingMethods();
        
        // SECTION 6: Arrays Class - Copying Methods
        demonstrateCopyingMethods();
        
        // SECTION 7: Arrays Class - Conversion Methods
        demonstrateConversionMethods();
        
        // SECTION 8: Arrays Class - Misc Methods
        demonstrateMiscMethods();
        
        // SECTION 9: Array Streaming Methods (Java 8+)
        demonstrateStreamingMethods();
        
        // SECTION 10: Multidimensional Array Methods
        demonstrateMultiDimensionalMethods();
        
        // SECTION 11: Array Utility Methods
        demonstrateArrayUtilities();
        
        // SECTION 12: Parallel Array Methods (Java 8+)
        demonstrateParallelMethods();
        
        // SECTION 13: Legacy Array Methods
        demonstrateLegacyMethods();
    }
    
    /**
     * SECTION 1: Array Declaration and Initialization (Methods 1-15)
     */
    private static void demonstrateArrayCreation() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 1: ARRAY DECLARATION AND INITIALIZATION (15 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 1: Declaration with size
        System.out.println("\n1. Declaration with size:");
        int[] arr1 = new int[5];
        System.out.println("   int[5] created: " + Arrays.toString(arr1));
        
        // Method 2: Declaration with initial values
        System.out.println("\n2. Declaration with initial values:");
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("   int[] arr = {1,2,3,4,5}: " + Arrays.toString(arr2));
        
        // Method 3: Declaration using 'new' with values
        System.out.println("\n3. Declaration using new with values:");
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        System.out.println("   new int[]{1,2,3,4,5}: " + Arrays.toString(arr3));
        
        // Method 4: String array declaration
        System.out.println("\n4. String array declaration:");
        String[] strArr = {"Hello", "World"};
        System.out.println("   String[]: " + Arrays.toString(strArr));
        
        // Method 5: Boolean array
        System.out.println("\n5. Boolean array:");
        boolean[] boolArr = {true, false, true};
        System.out.println("   boolean[]: " + Arrays.toString(boolArr));
        
        // Method 6: Byte array
        System.out.println("\n6. Byte array:");
        byte[] byteArr = {1, 2, 3, 4, 5};
        System.out.println("   byte[]: " + Arrays.toString(byteArr));
        
        // Method 7: Short array
        System.out.println("\n7. Short array:");
        short[] shortArr = {10, 20, 30};
        System.out.println("   short[]: " + Arrays.toString(shortArr));
        
        // Method 8: Long array
        System.out.println("\n8. Long array:");
        long[] longArr = {100L, 200L, 300L};
        System.out.println("   long[]: " + Arrays.toString(longArr));
        
        // Method 9: Float array
        System.out.println("\n9. Float array:");
        float[] floatArr = {1.1f, 2.2f, 3.3f};
        System.out.println("   float[]: " + Arrays.toString(floatArr));
        
        // Method 10: Double array
        System.out.println("\n10. Double array:");
        double[] doubleArr = {1.11, 2.22, 3.33};
        System.out.println("   double[]: " + Arrays.toString(doubleArr));
        
        // Method 11: Char array
        System.out.println("\n11. Char array:");
        char[] charArr = {'A', 'B', 'C'};
        System.out.println("   char[]: " + Arrays.toString(charArr));
        
        // Method 12: Object array
        System.out.println("\n12. Object array:");
        // Object[] objArr = {new Integer(1), "String", new Double(3.14)};
        Object[] objArr = {Integer.valueOf(1), "String", Double.valueOf(3.14)};
        System.out.println("   Object[]: " + Arrays.toString(objArr));
        
        // Method 13: Anonymous array
        System.out.println("\n13. Anonymous array (used inline):");
        printArray(new int[]{1, 2, 3, 4, 5});
        
        // Method 14: Empty array
        System.out.println("\n14. Empty array:");
        int[] emptyArr = {};
        System.out.println("   Empty array length: " + emptyArr.length);
        
        // Method 15: Null array
        System.out.println("\n15. Null array reference:");
        int[] nullArr = null;
        System.out.println("   nullArr = " + nullArr);
    }
    
    private static void printArray(int[] arr) {
        System.out.println("   Anonymous array: " + Arrays.toString(arr));
    }
    
    /**
     * SECTION 2: Arrays Class - Sorting Methods (Methods 16-30)
     */
    private static void demonstrateSortingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 2: ARRAYS CLASS - SORTING METHODS (15 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 16: sort(byte[] a)
        System.out.println("\n16. sort(byte[] a):");
        byte[] byteArr = {5, 2, 7, 1, 9};
        System.out.println("   Before: " + Arrays.toString(byteArr));
        Arrays.sort(byteArr);
        System.out.println("   After: " + Arrays.toString(byteArr));
        
        // Method 17: sort(byte[] a, int fromIndex, int toIndex)
        System.out.println("\n17. sort(byte[] a, int fromIndex, int toIndex):");
        byte[] byteArr2 = {5, 2, 7, 1, 9, 3, 8};
        System.out.println("   Before: " + Arrays.toString(byteArr2));
        Arrays.sort(byteArr2, 2, 5);
        System.out.println("   After sorting indices 2-5: " + Arrays.toString(byteArr2));
        
        // Method 18: sort(char[] a)
        System.out.println("\n18. sort(char[] a):");
        char[] charArr = {'Z', 'A', 'C', 'B', 'Y'};
        System.out.println("   Before: " + Arrays.toString(charArr));
        Arrays.sort(charArr);
        System.out.println("   After: " + Arrays.toString(charArr));
        
        // Method 19: sort(short[] a)
        System.out.println("\n19. sort(short[] a):");
        short[] shortArr = {10, 5, 8, 2, 7};
        Arrays.sort(shortArr);
        System.out.println("   After sort: " + Arrays.toString(shortArr));
        
        // Method 20: sort(int[] a)
        System.out.println("\n20. sort(int[] a):");
        int[] intArr = {42, 17, 8, 99, 23};
        Arrays.sort(intArr);
        System.out.println("   After sort: " + Arrays.toString(intArr));
        
        // Method 21: sort(long[] a)
        System.out.println("\n21. sort(long[] a):");
        long[] longArr = {100L, 50L, 75L, 25L};
        Arrays.sort(longArr);
        System.out.println("   After sort: " + Arrays.toString(longArr));
        
        // Method 22: sort(float[] a)
        System.out.println("\n22. sort(float[] a):");
        float[] floatArr = {3.14f, 1.59f, 2.65f, 9.79f};
        Arrays.sort(floatArr);
        System.out.println("   After sort: " + Arrays.toString(floatArr));
        
        // Method 23: sort(double[] a)
        System.out.println("\n23. sort(double[] a):");
        double[] doubleArr = {2.718, 1.618, 3.142, 0.577};
        Arrays.sort(doubleArr);
        System.out.println("   After sort: " + Arrays.toString(doubleArr));
        
        // Method 24: sort(Object[] a) - natural order
        System.out.println("\n24. sort(Object[] a) - natural order:");
        String[] strArr = {"Banana", "Apple", "Cherry", "Date"};
        System.out.println("   Before: " + Arrays.toString(strArr));
        Arrays.sort(strArr);
        System.out.println("   After: " + Arrays.toString(strArr));
        
        // Method 25: sort(Object[] a, int fromIndex, int toIndex)
        System.out.println("\n25. sort(Object[] a, int fromIndex, int toIndex):");
        String[] strArr2 = {"Banana", "Apple", "Cherry", "Date", "Elderberry"};
        System.out.println("   Before: " + Arrays.toString(strArr2));
        Arrays.sort(strArr2, 1, 4);
        System.out.println("   After sorting indices 1-4: " + Arrays.toString(strArr2));
        
        // Method 26: sort(T[] a, Comparator<? super T> c)
        System.out.println("\n26. sort(T[] a, Comparator<? super T> c):");
        String[] strArr3 = {"Banana", "Apple", "Cherry", "Date"};
        System.out.println("   Before: " + Arrays.toString(strArr3));
        Arrays.sort(strArr3, Comparator.reverseOrder());
        System.out.println("   After reverse order: " + Arrays.toString(strArr3));
        
        // Method 27: sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
        System.out.println("\n27. sort with range and comparator:");
        String[] strArr4 = {"Banana", "Apple", "Cherry", "Date", "Elderberry"};
        System.out.println("   Before: " + Arrays.toString(strArr4));
        Arrays.sort(strArr4, 1, 4, Comparator.reverseOrder());
        System.out.println("   After reverse sort indices 1-4: " + Arrays.toString(strArr4));
        
        // Method 28: parallelSort(byte[] a) - Java 8+
        System.out.println("\n28. parallelSort(byte[] a) (Java 8+):");
        byte[] byteArr3 = {9, 3, 7, 1, 8, 2, 6, 4, 5};
        System.out.println("   Before: " + Arrays.toString(byteArr3));
        Arrays.parallelSort(byteArr3);
        System.out.println("   After parallel sort: " + Arrays.toString(byteArr3));
        
        // Method 29: parallelSort with range
        System.out.println("\n29. parallelSort with range:");
        int[] intArr2 = {9, 3, 7, 1, 8, 2, 6, 4, 5};
        System.out.println("   Before: " + Arrays.toString(intArr2));
        Arrays.parallelSort(intArr2, 2, 7);
        System.out.println("   After parallel sort indices 2-7: " + Arrays.toString(intArr2));
        
        // Method 30: parallelSort with comparator
        System.out.println("\n30. parallelSort with comparator:");
        String[] strArr5 = {"Banana", "Apple", "Cherry", "Date"};
        Arrays.parallelSort(strArr5, Comparator.reverseOrder());
        System.out.println("   After parallel reverse sort: " + Arrays.toString(strArr5));
    }
    
    /**
     * SECTION 3: Arrays Class - Searching Methods (Methods 31-38)
     */
    private static void demonstrateSearchingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 3: ARRAYS CLASS - SEARCHING METHODS (8 Methods)");
        System.out.println("=".repeat(80));
        
        int[] intArr = {10, 20, 30, 40, 50, 60, 70};
        Arrays.sort(intArr); // Binary search requires sorted array
        
        // Method 31: binarySearch(byte[] a, byte key)
        System.out.println("\n31. binarySearch(byte[] a, byte key):");
        byte[] byteArr = {10, 20, 30, 40, 50};
        System.out.println("   Array: " + Arrays.toString(byteArr));
        System.out.println("   Index of 30: " + Arrays.binarySearch(byteArr, (byte)30));
        System.out.println("   Index of 35 (not found): " + Arrays.binarySearch(byteArr, (byte)35));
        
        // Method 32: binarySearch(byte[] a, int fromIndex, int toIndex, byte key)
        System.out.println("\n32. binarySearch with range:");
        System.out.println("   Array: " + Arrays.toString(byteArr));
        System.out.println("   Index of 30 in range 2-5: " + 
            Arrays.binarySearch(byteArr, 2, 5, (byte)30));
        
        // Method 33: binarySearch(char[] a, char key)
        System.out.println("\n33. binarySearch(char[] a, char key):");
        char[] charArr = {'A', 'B', 'C', 'D', 'E'};
        System.out.println("   Index of 'C': " + Arrays.binarySearch(charArr, 'C'));
        
        // Method 34: binarySearch(int[] a, int key)
        System.out.println("\n34. binarySearch(int[] a, int key):");
        System.out.println("   Array: " + Arrays.toString(intArr));
        System.out.println("   Index of 40: " + Arrays.binarySearch(intArr, 40));
        
        // Method 35: binarySearch(long[] a, long key)
        System.out.println("\n35. binarySearch(long[] a, long key):");
        long[] longArr = {100, 200, 300, 400};
        System.out.println("   Index of 300: " + Arrays.binarySearch(longArr, 300L));
        
        // Method 36: binarySearch(short[] a, short key)
        System.out.println("\n36. binarySearch(short[] a, short key):");
        short[] shortArr = {1, 2, 3, 4, 5};
        System.out.println("   Index of 4: " + Arrays.binarySearch(shortArr, (short)4));
        
        // Method 37: binarySearch(Object[] a, Object key)
        System.out.println("\n37. binarySearch(Object[] a, Object key):");
        String[] strArr = {"Apple", "Banana", "Cherry", "Date"};
        Arrays.sort(strArr);
        System.out.println("   Index of 'Cherry': " + Arrays.binarySearch(strArr, "Cherry"));
        
        // Method 38: binarySearch(T[] a, T key, Comparator<? super T> c)
        System.out.println("\n38. binarySearch with comparator:");
        String[] strArr2 = {"Apple", "Banana", "Cherry", "Date"};
        Arrays.sort(strArr2, Comparator.reverseOrder());
        System.out.println("   Array (reverse order): " + Arrays.toString(strArr2));
        System.out.println("   Index of 'Cherry' with reverse comparator: " + 
            Arrays.binarySearch(strArr2, "Cherry", Comparator.reverseOrder()));
    }
    
    /**
     * SECTION 4: Arrays Class - Comparison Methods (Methods 39-46)
     */
    private static void demonstrateComparisonMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 4: ARRAYS CLASS - COMPARISON METHODS (8 Methods)");
        System.out.println("=".repeat(80));
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 6};
        int[] arr4 = {1, 2, 3};
        
        // Method 39: equals(boolean[] a, boolean[] a2)
        System.out.println("\n39. equals(boolean[] a, boolean[] a2):");
        boolean[] bool1 = {true, false, true};
        boolean[] bool2 = {true, false, true};
        boolean[] bool3 = {true, true, false};
        System.out.println("   bool1 equals bool2: " + Arrays.equals(bool1, bool2));
        System.out.println("   bool1 equals bool3: " + Arrays.equals(bool1, bool3));
        
        // Method 40: equals(byte[] a, byte[] a2)
        System.out.println("\n40. equals(byte[] a, byte[] a2):");
        byte[] byte1 = {1, 2, 3};
        byte[] byte2 = {1, 2, 3};
        byte[] byte3 = {1, 2, 4};
        System.out.println("   byte1 equals byte2: " + Arrays.equals(byte1, byte2));
        
        // Method 41: equals(int[] a, int[] a2)
        System.out.println("\n41. equals(int[] a, int[] a2):");
        System.out.println("   arr1 equals arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("   arr1 equals arr3: " + Arrays.equals(arr1, arr3));
        System.out.println("   arr1 equals arr4: " + Arrays.equals(arr1, arr4));
        
        // Method 42: equals(Object[] a, Object[] a2)
        System.out.println("\n42. equals(Object[] a, Object[] a2):");
        String[] str1 = {"A", "B", "C"};
        String[] str2 = {"A", "B", "C"};
        String[] str3 = {"A", "B", "D"};
        System.out.println("   str1 equals str2: " + Arrays.equals(str1, str2));
        System.out.println("   str1 equals str3: " + Arrays.equals(str1, str3));
        
        // Method 43: deepEquals(Object[] a1, Object[] a2)
        System.out.println("\n43. deepEquals(Object[] a1, Object[] a2) - for nested arrays:");
        Object[] nested1 = {new int[]{1,2}, new int[]{3,4}};
        Object[] nested2 = {new int[]{1,2}, new int[]{3,4}};
        Object[] nested3 = {new int[]{1,2}, new int[]{3,5}};
        System.out.println("   deepEquals nested1 and nested2: " + Arrays.deepEquals(nested1, nested2));
        System.out.println("   deepEquals nested1 and nested3: " + Arrays.deepEquals(nested1, nested3));
        
        // Method 44: compare(int[] a, int[] b) - Java 9+
        System.out.println("\n44. compare(int[] a, int[] b) (Java 9+):");
        System.out.println("   compare arr1 and arr2: " + Arrays.compare(arr1, arr2));
        System.out.println("   compare arr1 and arr3: " + Arrays.compare(arr1, arr3));
        System.out.println("   compare arr1 and arr4: " + Arrays.compare(arr1, arr4));
        
        // Method 45: compareUnsigned(int[] a, int[] b) - Java 9+
        System.out.println("\n45. compareUnsigned(int[] a, int[] b) (Java 9+):");
        int[] unsigned1 = {-1, 2, 3}; // -1 is 4294967295 as unsigned
        int[] unsigned2 = {1, 2, 3};
        System.out.println("   compareUnsigned [-1,2,3] and [1,2,3]: " + 
            Arrays.compareUnsigned(unsigned1, unsigned2));
        
        // Method 46: mismatch(int[] a, int[] b) - Java 9+
        System.out.println("\n46. mismatch(int[] a, int[] b) (Java 9+):");
        System.out.println("   mismatch arr1 and arr2: " + Arrays.mismatch(arr1, arr2));
        System.out.println("   mismatch arr1 and arr3: " + Arrays.mismatch(arr1, arr3));
        System.out.println("   mismatch arr1 and arr4: " + Arrays.mismatch(arr1, arr4));
    }
    
    /**
     * SECTION 5: Arrays Class - Filling Methods (Methods 47-54)
     */
    private static void demonstrateFillingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 5: ARRAYS CLASS - FILLING METHODS (8 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 47: fill(boolean[] a, boolean val)
        System.out.println("\n47. fill(boolean[] a, boolean val):");
        boolean[] boolArr = new boolean[5];
        System.out.println("   Before: " + Arrays.toString(boolArr));
        Arrays.fill(boolArr, true);
        System.out.println("   After fill true: " + Arrays.toString(boolArr));
        
        // Method 48: fill(boolean[] a, int fromIndex, int toIndex, boolean val)
        System.out.println("\n48. fill with range:");
        boolean[] boolArr2 = new boolean[5];
        Arrays.fill(boolArr2, 1, 4, true);
        System.out.println("   Fill indices 1-4 with true: " + Arrays.toString(boolArr2));
        
        // Method 49: fill(byte[] a, byte val)
        System.out.println("\n49. fill(byte[] a, byte val):");
        byte[] byteArr = new byte[5];
        Arrays.fill(byteArr, (byte)42);
        System.out.println("   Fill with 42: " + Arrays.toString(byteArr));
        
        // Method 50: fill(char[] a, char val)
        System.out.println("\n50. fill(char[] a, char val):");
        char[] charArr = new char[5];
        Arrays.fill(charArr, 'A');
        System.out.println("   Fill with 'A': " + Arrays.toString(charArr));
        
        // Method 51: fill(int[] a, int val)
        System.out.println("\n51. fill(int[] a, int val):");
        int[] intArr = new int[5];
        Arrays.fill(intArr, 100);
        System.out.println("   Fill with 100: " + Arrays.toString(intArr));
        
        // Method 52: fill(long[] a, long val)
        System.out.println("\n52. fill(long[] a, long val):");
        long[] longArr = new long[5];
        Arrays.fill(longArr, 999L);
        System.out.println("   Fill with 999: " + Arrays.toString(longArr));
        
        // Method 53: fill(float[] a, float val)
        System.out.println("\n53. fill(float[] a, float val):");
        float[] floatArr = new float[5];
        Arrays.fill(floatArr, 3.14f);
        System.out.println("   Fill with 3.14: " + Arrays.toString(floatArr));
        
        // Method 54: fill(Object[] a, Object val)
        System.out.println("\n54. fill(Object[] a, Object val):");
        String[] strArr = new String[5];
        Arrays.fill(strArr, "Hello");
        System.out.println("   Fill with 'Hello': " + Arrays.toString(strArr));
    }
    
    /**
     * SECTION 6: Arrays Class - Copying Methods (Methods 55-64)
     */
    private static void demonstrateCopyingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 6: ARRAYS CLASS - COPYING METHODS (10 Methods)");
        System.out.println("=".repeat(80));
        
        int[] original = {1, 2, 3, 4, 5};
        
        // Method 55: copyOf(boolean[] original, int newLength)
        System.out.println("\n55. copyOf(boolean[] original, int newLength):");
        boolean[] boolOrig = {true, false, true};
        boolean[] boolCopy = Arrays.copyOf(boolOrig, 5);
        System.out.println("   Original: " + Arrays.toString(boolOrig));
        System.out.println("   Copy (length 5): " + Arrays.toString(boolCopy));
        
        // Method 56: copyOf(byte[] original, int newLength)
        System.out.println("\n56. copyOf(byte[] original, int newLength):");
        byte[] byteOrig = {10, 20, 30};
        byte[] byteCopy = Arrays.copyOf(byteOrig, 5);
        System.out.println("   Original: " + Arrays.toString(byteOrig));
        System.out.println("   Copy: " + Arrays.toString(byteCopy));
        
        // Method 57: copyOf(int[] original, int newLength)
        System.out.println("\n57. copyOf(int[] original, int newLength):");
        int[] copy1 = Arrays.copyOf(original, 3);
        int[] copy2 = Arrays.copyOf(original, 7);
        System.out.println("   Original: " + Arrays.toString(original));
        System.out.println("   Copy first 3: " + Arrays.toString(copy1));
        System.out.println("   Copy extended to 7: " + Arrays.toString(copy2));
        
        // Method 58: copyOf(long[] original, int newLength)
        System.out.println("\n58. copyOf(long[] original, int newLength):");
        long[] longOrig = {100, 200, 300};
        long[] longCopy = Arrays.copyOf(longOrig, 5);
        System.out.println("   Copy: " + Arrays.toString(longCopy));
        
        // Method 59: copyOf(float[] original, int newLength)
        System.out.println("\n59. copyOf(float[] original, int newLength):");
        float[] floatOrig = {1.1f, 2.2f, 3.3f};
        float[] floatCopy = Arrays.copyOf(floatOrig, 5);
        System.out.println("   Copy: " + Arrays.toString(floatCopy));
        
        // Method 60: copyOf(double[] original, int newLength)
        System.out.println("\n60. copyOf(double[] original, int newLength):");
        double[] doubleOrig = {1.11, 2.22, 3.33};
        double[] doubleCopy = Arrays.copyOf(doubleOrig, 5);
        System.out.println("   Copy: " + Arrays.toString(doubleCopy));
        
        // Method 61: copyOf(char[] original, int newLength)
        System.out.println("\n61. copyOf(char[] original, int newLength):");
        char[] charOrig = {'A', 'B', 'C'};
        char[] charCopy = Arrays.copyOf(charOrig, 5);
        System.out.println("   Copy: " + Arrays.toString(charCopy));
        
        // Method 62: copyOfRange(int[] original, int from, int to)
        System.out.println("\n62. copyOfRange(int[] original, int from, int to):");
        int[] range = Arrays.copyOfRange(original, 1, 4);
        System.out.println("   Original: " + Arrays.toString(original));
        System.out.println("   Range [1-4): " + Arrays.toString(range));
        
        // Method 63: copyOfRange with different types
        System.out.println("\n63. copyOfRange for other types:");
        String[] strOrig = {"A", "B", "C", "D", "E"};
        String[] strRange = Arrays.copyOfRange(strOrig, 2, 5);
        System.out.println("   String array range [2-5): " + Arrays.toString(strRange));
        
        // Method 64: System.arraycopy (legacy but important)
        System.out.println("\n64. System.arraycopy (native method):");
        int[] source = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        System.arraycopy(source, 1, dest, 2, 3);
        System.out.println("   Source: " + Arrays.toString(source));
        System.out.println("   Destination after copy from source[1] to dest[2] (3 elements): " + 
            Arrays.toString(dest));
    }
    
    /**
     * SECTION 7: Arrays Class - Conversion Methods (Methods 65-72)
     */
    private static void demonstrateConversionMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 7: ARRAYS CLASS - CONVERSION METHODS (8 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 65: asList(T... a)
        System.out.println("\n65. asList(T... a) - Convert array to List:");
        String[] strArr = {"Apple", "Banana", "Cherry"};
        List<String> list = Arrays.asList(strArr);
        System.out.println("   Array: " + Arrays.toString(strArr));
        System.out.println("   List: " + list);
        System.out.println("   Note: List is backed by array (fixed-size)");
        
        // Method 66: toString(boolean[] a)
        System.out.println("\n66. toString(boolean[] a):");
        boolean[] boolArr = {true, false, true};
        System.out.println("   String representation: " + Arrays.toString(boolArr));
        
        // Method 67: toString(byte[] a)
        System.out.println("\n67. toString(byte[] a):");
        byte[] byteArr = {10, 20, 30};
        System.out.println("   String representation: " + Arrays.toString(byteArr));
        
        // Method 68: toString(int[] a)
        System.out.println("\n68. toString(int[] a):");
        int[] intArr = {1, 2, 3, 4, 5};
        System.out.println("   String representation: " + Arrays.toString(intArr));
        
        // Method 69: toString(Object[] a)
        System.out.println("\n69. toString(Object[] a):");
        String[] strArr2 = {"Hello", "World"};
        System.out.println("   String representation: " + Arrays.toString(strArr2));
        
        // Method 70: deepToString(Object[] a)
        System.out.println("\n70. deepToString(Object[] a) - for nested arrays:");
        Object[] nested = {new int[]{1,2}, new int[]{3,4}, "Hello"};
        System.out.println("   Deep string: " + Arrays.deepToString(nested));
        
        // Method 71: setAll (Java 8+)
        System.out.println("\n71. setAll (Java 8+):");
        int[] genArr = new int[5];
        Arrays.setAll(genArr, i -> i * i);
        System.out.println("   setAll with i*i: " + Arrays.toString(genArr));
        
        // Method 72: parallelSetAll (Java 8+)
        System.out.println("\n72. parallelSetAll (Java 8+):");
        int[] parallelGen = new int[5];
        Arrays.parallelSetAll(parallelGen, i -> i * 10);
        System.out.println("   parallelSetAll with i*10: " + Arrays.toString(parallelGen));
    }
    
    /**
     * SECTION 8: Arrays Class - Misc Methods (Methods 73-80)
     */
    private static void demonstrateMiscMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 8: ARRAYS CLASS - MISC METHODS (8 Methods)");
        System.out.println("=".repeat(80));
        
        int[] intArr = {1, 2, 3, 4, 5};
        
        // Method 73: hashCode(boolean[] a)
        System.out.println("\n73. hashCode(boolean[] a):");
        boolean[] boolArr = {true, false, true};
        System.out.println("   Hash code: " + Arrays.hashCode(boolArr));
        
        // Method 74: hashCode(int[] a)
        System.out.println("\n74. hashCode(int[] a):");
        System.out.println("   Hash code of [1,2,3,4,5]: " + Arrays.hashCode(intArr));
        
        // Method 75: hashCode(Object[] a)
        System.out.println("\n75. hashCode(Object[] a):");
        String[] strArr = {"A", "B", "C"};
        System.out.println("   Hash code: " + Arrays.hashCode(strArr));
        
        // Method 76: deepHashCode(Object[] a)
        System.out.println("\n76. deepHashCode(Object[] a) - for nested arrays:");
        Object[] nested = {new int[]{1,2}, new int[]{3,4}};
        System.out.println("   Deep hash code: " + Arrays.deepHashCode(nested));
        
        // Method 77: spliterator (Java 8+)
        System.out.println("\n77. spliterator (Java 8+):");
        Spliterator.OfInt spliterator = Arrays.spliterator(intArr);
        System.out.println("   Spliterator characteristics: " + spliterator.characteristics());
        System.out.println("   Spliterator size: " + spliterator.getExactSizeIfKnown());
        
        // Method 78: stream (Java 8+) - covered in streaming section
        
        // Method 79: parallelPrefix (Java 8+)
        System.out.println("\n79. parallelPrefix (Java 8+):");
        int[] prefixArr = {1, 2, 3, 4, 5};
        System.out.println("   Before: " + Arrays.toString(prefixArr));
        Arrays.parallelPrefix(prefixArr, (x, y) -> x * y);
        System.out.println("   After parallel prefix (multiplication): " + 
            Arrays.toString(prefixArr));
        
        // Method 80: parallelPrefix with range
        System.out.println("\n80. parallelPrefix with range:");
        int[] prefixArr2 = {1, 2, 3, 4, 5};
        Arrays.parallelPrefix(prefixArr2, 1, 4, (x, y) -> x + y);
        System.out.println("   Range [1-4) with addition: " + Arrays.toString(prefixArr2));
    }
    
    /**
     * SECTION 9: Array Streaming Methods (Java 8+) (Methods 81-90)
     */
    private static void demonstrateStreamingMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 9: ARRAY STREAMING METHODS (JAVA 8+) (10 Methods)");
        System.out.println("=".repeat(80));
        
        int[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"Apple", "Banana", "Cherry"};
        
        // Method 81: Arrays.stream(int[] array)
        System.out.println("\n81. Arrays.stream(int[] array):");
        IntStream intStream = Arrays.stream(intArr);
        System.out.println("   Sum via stream: " + intStream.sum());
        
        // Method 82: Arrays.stream(int[] array, int startInclusive, int endExclusive)
        System.out.println("\n82. Arrays.stream with range:");
        IntStream rangeStream = Arrays.stream(intArr, 1, 4);
        System.out.println("   Sum of indices 1-4: " + rangeStream.sum());
        
        // Method 83: Arrays.stream(long[] array)
        System.out.println("\n83. Arrays.stream(long[] array):");
        long[] longArr = {100, 200, 300};
        LongStream longStream = Arrays.stream(longArr);
        System.out.println("   Average: " + longStream.average().orElse(0));
        
        // Method 84: Arrays.stream(double[] array)
        System.out.println("\n84. Arrays.stream(double[] array):");
        double[] doubleArr = {1.1, 2.2, 3.3};
        DoubleStream doubleStream = Arrays.stream(doubleArr);
        System.out.println("   Max: " + doubleStream.max().orElse(0));
        
        // Method 85: Arrays.stream(T[] array)
        System.out.println("\n85. Arrays.stream(T[] array):");
        Stream<String> stringStream = Arrays.stream(strArr);
        System.out.println("   Count: " + stringStream.count());
        
        // Method 86: Stream.of(T... values)
        System.out.println("\n86. Stream.of(T... values):");
        Stream<String> ofStream = Stream.of("X", "Y", "Z");
        System.out.println("   Joined: " + ofStream.reduce("", (a, b) -> a + b));
        
        // Method 87: IntStream.of(int... values)
        System.out.println("\n87. IntStream.of(int... values):");
        IntStream ofInts = IntStream.of(10, 20, 30, 40, 50);
        System.out.println("   Min: " + ofInts.min().orElse(0));
        
        // Method 88: Arrays.stream for Objects with operations
        System.out.println("\n88. Stream operations on array:");
        Arrays.stream(strArr)
              .map(String::toUpperCase)
              .forEach(s -> System.out.println("   " + s));
        
        // Method 89: Stream to array conversion
        System.out.println("\n89. Stream toArray():");
        String[] newArray = Arrays.stream(strArr)
                                  .map(String::toLowerCase)
                                  .toArray(String[]::new);
        System.out.println("   New array from stream: " + Arrays.toString(newArray));
        
        // Method 90: Parallel stream from array
        System.out.println("\n90. parallelStream from array:");
        int sum = Arrays.stream(intArr)
                        .parallel()
                        .map(x -> x * 2)
                        .sum();
        System.out.println("   Parallel sum of doubled values: " + sum);
    }
    
    /**
     * SECTION 10: Multidimensional Array Methods (Methods 91-100)
     */
    private static void demonstrateMultiDimensionalMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 10: MULTIDIMENSIONAL ARRAY METHODS (10 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 91: 2D array declaration
        System.out.println("\n91. 2D array declaration:");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("   3x3 matrix created");
        
        // Method 92: Accessing 2D array elements
        System.out.println("\n92. Accessing 2D array elements:");
        System.out.println("   matrix[1][1] = " + matrix[1][1]);
        
        // Method 93: Ragged array (different row lengths)
        System.out.println("\n93. Ragged array (different row lengths):");
        int[][] ragged = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9}
        };
        System.out.println("   Row 0 length: " + ragged[0].length);
        System.out.println("   Row 1 length: " + ragged[1].length);
        System.out.println("   Row 2 length: " + ragged[2].length);
        
        // Method 94: 3D array
        System.out.println("\n94. 3D array:");
        int[][][] cube = new int[3][3][3];
        cube[1][1][1] = 42;
        System.out.println("   3x3x3 cube created, cube[1][1][1] = " + cube[1][1][1]);
        
        // Method 95: deepToString for 2D array
        System.out.println("\n95. deepToString for 2D array:");
        System.out.println("   Matrix: " + Arrays.deepToString(matrix));
        
        // Method 96: deepEquals for 2D arrays
        System.out.println("\n96. deepEquals for 2D arrays:");
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
        };
        System.out.println("   matrix equals matrix2: " + Arrays.deepEquals(matrix, matrix2));
        System.out.println("   matrix equals matrix3: " + Arrays.deepEquals(matrix, matrix3));
        
        // Method 97: Copy 2D array (shallow)
        System.out.println("\n97. Copy 2D array (shallow):");
        int[][] shallowCopy = matrix.clone();
        System.out.println("   Shallow copy created");
        
        // Method 98: Deep copy 2D array
        System.out.println("\n98. Deep copy 2D array:");
        int[][] deepCopy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            deepCopy[i] = matrix[i].clone();
        }
        System.out.println("   Deep copy created");
        
        // Method 99: Iterate through 2D array
        System.out.println("\n99. Iterate through 2D array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Method 100: Fill 2D array
        System.out.println("\n100. Fill 2D array:");
        int[][] fillMatrix = new int[3][3];
        for (int[] row : fillMatrix) {
            Arrays.fill(row, 5);
        }
        System.out.println("   Filled matrix: " + Arrays.deepToString(fillMatrix));
    }
    
    /**
     * SECTION 11: Array Utility Methods (Methods 101-110)
     */
    private static void demonstrateArrayUtilities() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 11: ARRAY UTILITY METHODS (10 Methods)");
        System.out.println("=".repeat(80));
        
        int[] arr = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        
        // Method 101: Array length property
        System.out.println("\n101. Array length property:");
        System.out.println("   Array length: " + arr.length);
        
        // Method 102: Manual array reversal
        System.out.println("\n102. Manual array reversal:");
        int[] reverseArr = arr.clone();
        for (int i = 0; i < reverseArr.length / 2; i++) {
            int temp = reverseArr[i];
            reverseArr[i] = reverseArr[reverseArr.length - 1 - i];
            reverseArr[reverseArr.length - 1 - i] = temp;
        }
        System.out.println("   Reversed: " + Arrays.toString(reverseArr));
        
        // Method 103: Find min/max manually
        System.out.println("\n103. Find min/max manually:");
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        System.out.println("   Min: " + min + ", Max: " + max);
        
        // Method 104: Calculate sum
        System.out.println("\n104. Calculate sum:");
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("   Sum: " + sum);
        
        // Method 105: Calculate average
        System.out.println("\n105. Calculate average:");
        double average = (double) sum / arr.length;
        System.out.println("   Average: " + average);
        
        // Method 106: Check if array contains element
        System.out.println("\n106. Check if array contains element:");
        int searchFor = 8;
        boolean found = false;
        for (int num : arr) {
            if (num == searchFor) {
                found = true;
                break;
            }
        }
        System.out.println("   Contains " + searchFor + ": " + found);
        
        // Method 107: Find index of element
        System.out.println("\n107. Find index of element:");
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchFor) {
                index = i;
                break;
            }
        }
        System.out.println("   Index of " + searchFor + ": " + index);
        
        // Method 108: Remove element (create new array)
        System.out.println("\n108. Remove element (create new array):");
        int removeIndex = 2;
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, removeIndex);
        System.arraycopy(arr, removeIndex + 1, newArr, removeIndex, arr.length - removeIndex - 1);
        System.out.println("   Array after removing index " + removeIndex + ": " + 
            Arrays.toString(newArr));
        
        // Method 109: Insert element (create new array)
        System.out.println("\n109. Insert element:");
        int insertIndex = 3;
        int insertValue = 99;
        int[] insertArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, insertArr, 0, insertIndex);
        insertArr[insertIndex] = insertValue;
        System.arraycopy(arr, insertIndex, insertArr, insertIndex + 1, arr.length - insertIndex);
        System.out.println("   After inserting 99 at index 3: " + Arrays.toString(insertArr));
        
        // Method 110: Concatenate two arrays
        System.out.println("\n110. Concatenate two arrays:");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] concatenated = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, concatenated, 0, arr1.length);
        System.arraycopy(arr2, 0, concatenated, arr1.length, arr2.length);
        System.out.println("   Concatenated: " + Arrays.toString(concatenated));
    }
    
    /**
     * SECTION 12: Parallel Array Methods (Java 8+) (Methods 111-115)
     */
    private static void demonstrateParallelMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 12: PARALLEL ARRAY METHODS (JAVA 8+) (5 Methods)");
        System.out.println("=".repeat(80));
        
        // Method 111: parallelSort (already covered)
        System.out.println("\n111. parallelSort - already covered");
        
        // Method 112: parallelSetAll (already covered)
        System.out.println("\n112. parallelSetAll - already covered");
        
        // Method 113: parallelPrefix (already covered)
        System.out.println("\n113. parallelPrefix - already covered");
        
        // Method 114: Parallel stream processing
        System.out.println("\n114. Parallel stream processing:");
        int[] largeArray = new int[100];
        Arrays.parallelSetAll(largeArray, i -> i);
        long parallelSum = Arrays.stream(largeArray)
                                 .parallel()
                                 .sum();
        System.out.println("   Sum of 0-99 using parallel stream: " + parallelSum);
        
        // Method 115: Performance comparison (simulated)
        System.out.println("\n115. Parallel vs sequential (conceptual):");
        System.out.println("   Parallel processing is beneficial for large arrays");
        System.out.println("   Uses Fork-Join framework internally");
    }
    
    /**
     * SECTION 13: Legacy Array Methods (Methods 116-120)
     */
    private static void demonstrateLegacyMethods() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("SECTION 13: LEGACY ARRAY METHODS (5 Methods)");
        System.out.println("=".repeat(80));
        
        int[] arr = {1, 2, 3, 4, 5};
        
        // Method 116: System.arraycopy (already covered)
        System.out.println("\n116. System.arraycopy - legacy native method");
        
        // Method 117: clone() method
        System.out.println("\n117. clone() method:");
        int[] cloned = arr.clone();
        System.out.println("   Original: " + Arrays.toString(arr));
        System.out.println("   Cloned: " + Arrays.toString(cloned));
        System.out.println("   arr == cloned: " + (arr == cloned));
        System.out.println("   Arrays.equals: " + Arrays.equals(arr, cloned));
        
        // Method 118: getClass() on array
        System.out.println("\n118. getClass() on array:");
        System.out.println("   Array class: " + arr.getClass());
        System.out.println("   Is array: " + arr.getClass().isArray());
        System.out.println("   Component type: " + arr.getClass().getComponentType());
        
        // Method 119: Array class in java.lang.reflect
        System.out.println("\n119. java.lang.reflect.Array methods:");
        try {
            Object newArray = java.lang.reflect.Array.newInstance(int.class, 5);
            java.lang.reflect.Array.setInt(newArray, 0, 100);
            java.lang.reflect.Array.setInt(newArray, 1, 200);
            int value = java.lang.reflect.Array.getInt(newArray, 0);
            System.out.println("   Array created via reflection: " + 
                Arrays.toString((int[])newArray));
            System.out.println("   Length via reflection: " + 
                java.lang.reflect.Array.getLength(newArray));
        } catch (Exception e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 120: Array as varargs parameter
        System.out.println("\n120. Array as varargs parameter:");
        varargsMethod("Hello", "World", "!");
        varargsMethod(new String[]{"A", "B", "C"});
    }
    
    private static void varargsMethod(String... strings) {
        System.out.println("   Varargs received: " + Arrays.toString(strings));
    }
}