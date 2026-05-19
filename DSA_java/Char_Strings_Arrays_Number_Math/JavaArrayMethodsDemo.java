package Char_Strings_Arrays_Number_Math;


import java.util.Arrays;
import java.util.stream.IntStream;

public class JavaArrayMethodsDemo {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7};

        // Original Array
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // =========================================
        // 1. Access element
        // =========================================
        System.out.println("\n1. Access Element");
        System.out.println(arr[1]);

        // =========================================
        // 2. Copy Array
        // =========================================
        System.out.println("\n2. Copy Array");

        int[] copy = Arrays.copyOf(arr, arr.length);

        System.out.println(Arrays.toString(copy));

        // =========================================
        // 3. Fill Array
        // =========================================
        System.out.println("\n3. Fill Array");

        int[] fillArr = new int[4];

        Arrays.fill(fillArr, 1);

        System.out.println(Arrays.toString(fillArr));

        // =========================================
        // 4. Sort Array
        // =========================================
        System.out.println("\n4. Sort Array");

        int[] sortArr = {9, 2, 7, 1};

        Arrays.sort(sortArr);

        System.out.println(Arrays.toString(sortArr));

        // =========================================
        // 5. Compare Arrays
        // =========================================
        System.out.println("\n5. Compare Arrays");

        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};

        System.out.println(Arrays.equals(a1, a2));

        // =========================================
        // 6. Binary Search
        // =========================================
        System.out.println("\n6. Binary Search");

        int index = Arrays.binarySearch(sortArr, 7);

        System.out.println("Index of 7 = " + index);

        // =========================================
        // 7. Reverse Array
        // =========================================
        System.out.println("\n7. Reverse Array");

        int[] reverse = {1, 2, 3, 4, 5};

        for(int i = reverse.length - 1; i >= 0; i--) {

            System.out.print(reverse[i] + " ");
        }

        // =========================================
        // 8. Sum of Array
        // =========================================
        System.out.println("\n\n8. Sum of Array");

        int[] sumArr = {1, 2, 3, 4};

        int sum = 0;

        for(int num : sumArr) {

            sum += num;
        }

        System.out.println("Sum = " + sum);

        // =========================================
        // 9. Max Element
        // =========================================
        System.out.println("\n9. Max Element");

        int[] maxArr = {10, 50, 30, 90};

        int max = maxArr[0];

        for(int num : maxArr) {

            if(num > max) {

                max = num;
            }
        }

        System.out.println("Max = " + max);

        // =========================================
        // 10. Min Element
        // =========================================
        System.out.println("\n10. Min Element");

        int min = maxArr[0];

        for(int num : maxArr) {

            if(num < min) {

                min = num;
            }
        }

        System.out.println("Min = " + min);

        // =========================================
        // 11. Convert Array to String
        // =========================================
        System.out.println("\n11. Array to String");

        System.out.println(Arrays.toString(arr));

        // =========================================
        // 12. Clone Array
        // =========================================
        System.out.println("\n12. Clone Array");

        int[] cloneArr = arr.clone();

        System.out.println(Arrays.toString(cloneArr));

        // =========================================
        // 13. Stream Operations
        // =========================================
        System.out.println("\n13. Stream Operations");

        int[] streamArr = {2, 4, 6, 8};

        // map operation
        int[] doubled = Arrays.stream(streamArr)
                              .map(x -> x * 2)
                              .toArray();

        System.out.println("Map (double values):");
        System.out.println(Arrays.toString(doubled));

        // filter operation
        int[] filtered = Arrays.stream(streamArr)
                               .filter(x -> x > 4)
                               .toArray();

        System.out.println("Filter (>4):");
        System.out.println(Arrays.toString(filtered));

        // reduce operation
        int total = Arrays.stream(streamArr)
                          .reduce(0, (a, b) -> a + b);

        System.out.println("Reduce Sum:");
        System.out.println(total);

        // =========================================
        // 14. Check Contains
        // =========================================
        System.out.println("\n14. Check Contains");

        boolean contains = IntStream.of(arr)
                                    .anyMatch(x -> x == 6);

        System.out.println(contains);

        // =========================================
        // 15. Multi-Dimensional Array
        // =========================================
        System.out.println("\n15. 2D Array");

        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        for(int i = 0; i < matrix.length; i++) {

            for(int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        // =========================================
        // 16. Parallel Sort
        // =========================================
        System.out.println("\n16. Parallel Sort");

        int[] pArr = {9, 5, 1, 7};

        Arrays.parallelSort(pArr);

        System.out.println(Arrays.toString(pArr));

        // =========================================
        // 17. Deep To String
        // =========================================
        System.out.println("\n17. Deep To String");

        int[][] deep = {
                {1,2},
                {3,4}
        };

        System.out.println(Arrays.deepToString(deep));

        // =========================================
        // 18. Mismatch
        // =========================================
        System.out.println("\n18. Mismatch");

        int[] m1 = {1,2,3};
        int[] m2 = {1,2,4};

        System.out.println(Arrays.mismatch(m1, m2));

        // =========================================
        // 19. Set All
        // =========================================
        System.out.println("\n19. Set All");

        int[] setAll = new int[5];

        Arrays.setAll(setAll, i -> i * 2);

        System.out.println(Arrays.toString(setAll));

        // =========================================
        // 20. Parallel Prefix
        // =========================================
        System.out.println("\n20. Parallel Prefix");

        int[] prefix = {1,2,3,4};

        Arrays.parallelPrefix(prefix, (x, y) -> x + y);

        System.out.println(Arrays.toString(prefix));
    }
}