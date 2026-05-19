package Char_Strings_Arrays_Number_Math;

import java.util.*;
import java.util.stream.*;

public class ArrayDSAProblems {

    // =========================================================
    // 1. Reverse Array
    // =========================================================

    static void reverseArray(int[] arr) {

        System.out.println("Without In-Build:");

        for(int i = arr.length - 1; i >= 0; i--) {

            System.out.print(arr[i] + " ");
        }

        System.out.println("\nUsing Stream:");

        IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .forEach(x -> System.out.print(x + " "));
    }

    // =========================================================
    // 2. Find Max/Min
    // =========================================================

    static void maxMin(int[] arr) {

        int max = arr[0];
        int min = arr[0];

        for(int num : arr) {

            if(num > max) max = num;
            if(num < min) min = num;
        }

        System.out.println("\nMax = " + max);
        System.out.println("Min = " + min);

        System.out.println("Using Stream:");

        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println(Arrays.stream(arr).min().getAsInt());
    }

    // =========================================================
    // 3. Second Largest
    // =========================================================

    static void secondLargest(int[] arr) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num : arr) {

            if(num > first) {

                second = first;
                first = num;
            }
            else if(num > second && num != first) {

                second = num;
            }
        }

        System.out.println("Second Largest = " + second);

        System.out.println("Using Stream:");

        int value = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(value);
    }

    // =========================================================
    // 4. Move Zeros To End
    // =========================================================

    static void moveZeros(int[] arr) {

        int index = 0;

        for(int num : arr) {

            if(num != 0) {

                arr[index++] = num;
            }
        }

        while(index < arr.length) {

            arr[index++] = 0;
        }

        System.out.println(Arrays.toString(arr));

        System.out.println("Using Stream:");

        int[] result = IntStream.concat(
                Arrays.stream(arr).filter(x -> x != 0),
                Arrays.stream(arr).filter(x -> x == 0)
        ).toArray();

        System.out.println(Arrays.toString(result));
    }

    // =========================================================
    // 5. Rotate Array
    // =========================================================

    static void rotateArray(int[] arr, int k) {

        int n = arr.length;

        int[] temp = new int[n];

        for(int i = 0; i < n; i++) {

            temp[(i + k) % n] = arr[i];
        }

        System.out.println(Arrays.toString(temp));

        System.out.println("Using Stream:");

        int[] rotated = IntStream.range(0, n)
                .map(i -> arr[(n - k + i) % n])
                .toArray();

        System.out.println(Arrays.toString(rotated));
    }

    // =========================================================
    // 6. Remove Duplicates
    // =========================================================

    static void removeDuplicates(int[] arr) {

        Set<Integer> set = new LinkedHashSet<>();

        for(int num : arr) {

            set.add(num);
        }

        System.out.println(set);

        System.out.println("Using Stream:");

        int[] unique = Arrays.stream(arr)
                .distinct()
                .toArray();

        System.out.println(Arrays.toString(unique));
    }

    // =========================================================
    // 7. Missing Number
    // =========================================================

    static void missingNumber(int[] arr, int n) {

        int total = n * (n + 1) / 2;

        int sum = 0;

        for(int num : arr) {

            sum += num;
        }

        System.out.println("Missing = " + (total - sum));

        System.out.println("Using Stream:");

        int streamSum = Arrays.stream(arr).sum();

        System.out.println(total - streamSum);
    }

    // =========================================================
    // 8. Duplicate Number
    // =========================================================

    static void duplicateNumber(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for(int num : arr) {

            if(!set.add(num)) {

                System.out.println("Duplicate = " + num);
            }
        }

        System.out.println("Using Stream:");

        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .forEach(System.out::println);
    }

    // =========================================================
    // 9. Two Sum
    // =========================================================

    static void twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {

            int diff = target - arr[i];

            if(map.containsKey(diff)) {

                System.out.println(map.get(diff) + " " + i);
            }

            map.put(arr[i], i);
        }
    }

    // =========================================================
    // 10. Buy & Sell Stock
    // =========================================================

    static void buySellStock(int[] prices) {

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices) {

            min = Math.min(min, price);

            profit = Math.max(profit, price - min);
        }

        System.out.println("Profit = " + profit);

        System.out.println("Using Stream:");

                
        int maxProfit = Arrays.stream(prices)
        .boxed()
                .reduce(new int[]{Integer.MAX_VALUE, 0},
                        (a, b) -> {
                            a[0] = Math.min(a[0], b);
                            a[1] = Math.max(a[1], b - a[0]);
                            return a;
                        },
                        (x, y) -> x)[1];

        System.out.println(maxProfit);
        
         System.out.println("Using Stream collect:");
        int maxProfit1 = Arrays.stream(prices)
        .collect(
                () -> new int[]{Integer.MAX_VALUE, 0}, // Initial state: {min, profit}
                (a, b) -> {
                    a[0] = Math.min(a[0], b);          // Update min
                    a[1] = Math.max(a[1], b - a[0]);   // Update profit
                },
                (x, y) -> {
                    // Combiner for parallel streams (not strictly used here but required by syntax)
                    x[1] = Math.max(x[1], y[1]);
                }
        )[1];
                System.out.println(maxProfit1);

    }

    // =========================================================
    // 11. Maximum Subarray Sum
    // =========================================================

    static void maximumSubarray(int[] arr) {

        int current = 0;
        int max = Integer.MIN_VALUE;

        for(int num : arr) {

            current += num;

            max = Math.max(max, current);

            if(current < 0) {

                current = 0;
            }
        }

        System.out.println("Max Sum = " + max);
    }

    // =========================================================
    // 12. Product Except Self
    // =========================================================

    static void productExceptSelf(int[] arr) {

        int n = arr.length;

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {

            int product = 1;

            for(int j = 0; j < n; j++) {

                if(i != j) {

                    product *= arr[j];
                }
            }

            result[i] = product;
        }

        System.out.println(Arrays.toString(result));
    }

    // =========================================================
    // 13. Merge Intervals
    // =========================================================

    static void mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();

        int[] current = intervals[0];

        for(int[] interval : intervals) {

            if(interval[0] <= current[1]) {

                current[1] = Math.max(current[1], interval[1]);
            }
            else {

                list.add(current);

                current = interval;
            }
        }

        list.add(current);

        for(int[] i : list) {

            System.out.println(Arrays.toString(i));
        }
    }

    // =========================================================
    // 14. Trapping Rain Water
    // =========================================================

    static void trappingRainWater(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while(left < right) {

            if(height[left] < height[right]) {

                if(height[left] >= leftMax) {

                    leftMax = height[left];
                }
                else {

                    water += leftMax - height[left];
                }

                left++;
            }
            else {

                if(height[right] >= rightMax) {

                    rightMax = height[right];
                }
                else {

                    water += rightMax - height[right];
                }

                right--;
            }
        }

        System.out.println("Water = " + water);
    }

    // =========================================================
    // 15. Spiral Matrix
    // =========================================================

    static void spiralMatrix(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right) {

            for(int i = left; i <= right; i++) {

                System.out.print(matrix[top][i] + " ");
            }

            top++;

            for(int i = top; i <= bottom; i++) {

                System.out.print(matrix[i][right] + " ");
            }

            right--;

            for(int i = right; i >= left; i--) {

                System.out.print(matrix[bottom][i] + " ");
            }

            bottom--;

            for(int i = bottom; i >= top; i--) {

                System.out.print(matrix[i][left] + " ");
            }

            left++;
        }
    }

    // =========================================================
    // 16. Set Matrix Zeroes
    // =========================================================

    static void setMatrixZeroes(int[][] matrix) {

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {

            for(int j = 0; j < matrix[0].length; j++) {

                if(matrix[i][j] == 0) {

                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {

            for(int j = 0; j < matrix[0].length; j++) {

                if(rows[i] || cols[j]) {

                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    // =========================================================
    // 17. Container With Most Water
    // =========================================================

    static void containerWater(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while(left < right) {

            int area = Math.min(height[left], height[right])
                    * (right - left);

            max = Math.max(max, area);

            if(height[left] < height[right]) {

                left++;
            }
            else {

                right--;
            }
        }

        System.out.println("Max Area = " + max);
    }

    // =========================================================
    // 18. Majority Element
    // =========================================================

    static void majorityElement(int[] arr) {

        int count = 0;
        int candidate = 0;

        for(int num : arr) {

            if(count == 0) {

                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        System.out.println(candidate);
    }

    // =========================================================
    // 19. Longest Consecutive Sequence
    // =========================================================

    static void longestConsecutive(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for(int num : arr) {

            set.add(num);
        }

        int longest = 0;

        for(int num : set) {

            if(!set.contains(num - 1)) {

                int current = num;

                int streak = 1;

                while(set.contains(current + 1)) {

                    current++;

                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        System.out.println(longest);
    }

    // =========================================================
    // 20. Subarray Sum Equals K
    // =========================================================

    static void subarraySumK(int[] arr, int k) {

        int count = 0;

        for(int i = 0; i < arr.length; i++) {

            int sum = 0;

            for(int j = i; j < arr.length; j++) {

                sum += arr[j];

                if(sum == k) {

                    count++;
                }
            }
        }

        System.out.println("Count = " + count);
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        reverseArray(arr);

        maxMin(arr);

        secondLargest(new int[]{10,20,30,40});

        moveZeros(new int[]{1,0,2,0,3,4});

        rotateArray(new int[]{1,2,3,4,5}, 2);

        removeDuplicates(new int[]{1,2,2,3,4,4});

        missingNumber(new int[]{1,2,4,5}, 5);

        duplicateNumber(new int[]{1,2,3,2,4,4});

        twoSum(new int[]{2,7,11,15}, 9);

        buySellStock(new int[]{7,1,5,3,6,4});

        maximumSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

        productExceptSelf(new int[]{1,2,3,4});

        mergeIntervals(new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        });

        trappingRainWater(new int[]{4,2,0,3,2,5});

        spiralMatrix(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });

        setMatrixZeroes(new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        });

        containerWater(new int[]{1,8,6,2,5,4,8,3,7});

        majorityElement(new int[]{2,2,1,1,1,2,2});

        longestConsecutive(new int[]{100,4,200,1,3,2});

        subarraySumK(new int[]{1,1,1}, 2);
    }
}


// 1. Reverse Array
// 2. Find Maximum/Minimum
// 3. Second Largest Element
// 4. Move Zeros to End
// 5. Rotate Array
// 6. Remove Duplicates
// 7. Find Missing Number
// 8. Find Duplicate Number
// 9. Two Sum
// 10. Best Time to Buy & Sell Stock
// 11. Maximum Subarray Sum
// 12. Product of Array Except Self
// 13. Merge Intervals
// 14. Trapping Rain Water
// 15. Spiral Matrix
// 16. Set Matrix Zeroes
// 17. Container With Most Water
// 18. Majority Element
// 19. Longest Consecutive Sequence
// 20. Subarray Sum Equals K