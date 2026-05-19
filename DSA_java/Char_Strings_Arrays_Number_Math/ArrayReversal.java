package Char_Strings_Arrays_Number_Math;

// import java.util.Stack;
// import java.util.Arrays;
// import java.util.Collections;
import java.util.*;
import java.util.stream.IntStream;

public class ArrayReversal {

    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    // For Integer arrays (not int[])
    // public static void reverseUsingCollections(Integer[] arr) {
    // Collections.reverse(Arrays.asList(arr));
    // }

    // For primitive int[], convert first
    public static int[] reversePrimitiveWithStream(int[] arr) {
        return IntStream.rangeClosed(1, arr.length)
                .map(i -> arr[arr.length - i])
                .toArray();
    }

    public static int[] reverseWithNewArray(int[] arr) {
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }

        return reversed;
    }

    public static void reverseRecursive(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        // Swap
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursive call
        reverseRecursive(arr, start + 1, end - 1);
    }

    // Wrapper method
    public static void reverseArray(int[] arr) {
        reverseRecursive(arr, 0, arr.length - 1);
    }

    public static void reverseUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Push all elements to stack
        for (int num : arr) {
            stack.push(num);
        }

        // Pop back to array (LIFO reverses order)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // // Test method 1 (Best - In-place)
        int[] arr1 = original.clone();
        reverseInPlace(arr1);
        System.out.println("In-place: " + Arrays.toString(arr1));
        // Output: [9, 8, 7, 6, 5, 4, 3, 2, 1]

        // Test method 2 (Preserves original)
        int[] arr2 = reverseWithNewArray(original);
        System.out.println("New array: " + Arrays.toString(arr2));
        System.out.println("Original preserved: " + Arrays.toString(original));

        // Test method 3 (Collections for Integer array)
        Integer[] arr3 = { 1, 2, 3, 4, 5 };
        Collections.reverse(Arrays.asList(arr3));
        System.out.println("Collections: " + Arrays.toString(arr3));

        // Test method 4 (Recursive)
        int[] arr4 = original.clone();
        reverseArray(arr4);
        System.out.println("Recursive: " + Arrays.toString(arr4));
        // Test method 5 (stack)
        int[] arr5 = original.clone();
        reverseUsingStack(arr5);
        System.out.println("stack: " + Arrays.toString(arr5));

        // Test method 4 (Recursive)
        int[] arr6 = original.clone();
        reversePrimitiveWithStream(arr6);
        System.out.println("reversePrimitiveWithStream: " + Arrays.toString(arr6));
    }

    // Include the methods here...
}