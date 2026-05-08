import java.util.*;
import java.util.stream.Collectors;

public class Array_manipulation_100 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println("ArrayMinMax---> " + ArrayMinMax(arr));
        System.out.println("ArrayMinMax---> " + Arrays.toString(ReverseArray(arr)));
        int[] input = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Water trapped: " + TrappingRainWater(input)); // Output: 6

        int[] nums = { 1, 1, 2, 2, 3, 4, 4 };

        System.out.println("Water trapped: " + Arrays.toString(RemoveDuplicatesStream(nums)));
        System.out.println("Water trapped: " + findDuplicatesStream(nums));


    }

    public static int ArrayMinMax(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }

        System.out.println("Min: " + min + ", Max: " + max);
        return max;
    }

    public static int[] ReverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }

        return (arr);
    }

    public static int TrappingRainWater(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Process the smaller side to ensure we are bounded by the shorter wall
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update new boundary
                } else {
                    totalWater += leftMax - height[left]; // Trap water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update new boundary
                } else {
                    totalWater += rightMax - height[right]; // Trap water
                }
                right--;
            }
        }
        return totalWater;
    }

    public static int[] RemoveDuplicatesStream(int[] nums) {
        // Use Stream API to get unique elements
        int[] uniqueNums = Arrays.stream(nums)
        .distinct()
        .toArray();

        System.out.println("Unique count: " + uniqueNums.length);
        System.out.println("Unique array: " + Arrays.toString(uniqueNums));
        return uniqueNums;

    }
    public static Set<Integer> findDuplicatesStream(int[] nums) {
        // Use Stream API to get unique elements
        // int[] uniqueNums = Arrays.stream(nums)
        // .distinct()
        // .toArray();

        // System.out.println("Unique count: " + uniqueNums.length);
        // System.out.println("Unique array: " + Arrays.toString(uniqueNums));
        // return uniqueNums;

        // Use Stream API to get dublicates elements
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 4, 4);

        Set<Integer> uniqueNums = list.stream()
                .filter(item-> Collections.frequency(list,item)>1)
                .collect(Collectors.toSet());

        return uniqueNums;
    }

}