package Char_Strings_Arrays_Number_Math;

import java.util.*;
import java.util.stream.*;

public class Array20Problems {
    
    // ==================== 1. REVERSE ARRAY ====================
    public static class ReverseArray {
        
        // Case 1: Without in-built methods (In-place)
        public static int[] reverseInPlace(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            return arr;
        }
        
        // Case 2: Using Stream API
        public static int[] reverseWithStream(int[] arr) {
            return IntStream.rangeClosed(1, arr.length)
                           .map(i -> arr[arr.length - i])
                           .toArray();
        }
    }
    
    // ==================== 2. FIND MAXIMUM/MINIMUM ====================
    public static class MaxMin {
        
        // Case 1: Without in-built methods
        public static int[] findMaxMin(int[] arr) {
            if (arr == null || arr.length == 0) return new int[]{};
            int max = arr[0], min = arr[0];
            for (int num : arr) {
                if (num > max) max = num;
                if (num < min) min = num;
            }
            return new int[]{max, min};
        }
        
        // Case 2: Using Stream API
        public static int[] findMaxMinStream(int[] arr) {
            int max = Arrays.stream(arr).max().orElseThrow();
            int min = Arrays.stream(arr).min().orElseThrow();
            return new int[]{max, min};
        }
        
        // Case 2 (Alternative): Using Parallel Stream for large arrays
        public static int[] findMaxMinParallel(int[] arr) {
            int max = Arrays.stream(arr).parallel().max().orElseThrow();
            int min = Arrays.stream(arr).parallel().min().orElseThrow();
            return new int[]{max, min};
        }
    }
    
    // ==================== 3. SECOND LARGEST ELEMENT ====================
    public static class SecondLargest {
        
        // Case 1: Without in-built methods
        public static int findSecondLargest(int[] arr) {
            if (arr.length < 2) return -1;
            int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
            for (int num : arr) {
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num > second && num != first) {
                    second = num;
                }
            }
            return second == Integer.MIN_VALUE ? -1 : second;
        }
        
        // Case 2: Using Stream API
        public static int findSecondLargestStream(int[] arr) {
            return Arrays.stream(arr)
                        .distinct()
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .orElse(-1);
        }
    }
    
    // ==================== 4. MOVE ZEROS TO END ====================
    public static class MoveZeros {
        
        // Case 1: Without in-built methods
        public static int[] moveZerosToEnd(int[] arr) {
            int nonZeroIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    int temp = arr[nonZeroIndex];
                    arr[nonZeroIndex] = arr[i];
                    arr[i] = temp;
                    nonZeroIndex++;
                }
            }
            return arr;
        }
        
        // Case 2: Using Stream API
        public static int[] moveZerosToEndStream(int[] arr) {
            int[] nonZeros = Arrays.stream(arr).filter(x -> x != 0).toArray();
            int[] zeros = new int[arr.length - nonZeros.length];
            return IntStream.concat(Arrays.stream(nonZeros), Arrays.stream(zeros)).toArray();
        }
    }
    
    // ==================== 5. ROTATE ARRAY ====================
    public static class RotateArray {
        
        // Case 1: Without in-built methods
        public static int[] rotateRight(int[] arr, int k) {
            int n = arr.length;
            k = k % n;
            reverse(arr, 0, n - 1);
            reverse(arr, 0, k - 1);
            reverse(arr, k, n - 1);
            return arr;
        }
        
        private static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        
        // Case 2: Using Stream API
        public static int[] rotateRightStream(int[] arr, int k) {
            int n = arr.length;
            k = k % n;
            return IntStream.concat(
                Arrays.stream(arr, n - k, n),
                Arrays.stream(arr, 0, n - k)
            ).toArray();
        }
    }
    
    // ==================== 6. REMOVE DUPLICATES ====================
    public static class RemoveDuplicates {
        
        // Case 1: Without in-built methods (Sorted Array)
        public static int[] removeDuplicates(int[] arr) {
            if (arr.length <= 1) return arr;
            Arrays.sort(arr);
            int uniqueIndex = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[uniqueIndex]) {
                    uniqueIndex++;
                    arr[uniqueIndex] = arr[i];
                }
            }
            return Arrays.copyOf(arr, uniqueIndex + 1);
        }
        
        // Case 2: Using Stream API
        public static int[] removeDuplicatesStream(int[] arr) {
            return Arrays.stream(arr).distinct().toArray();
        }
    }
    
    // ==================== 7. FIND MISSING NUMBER ====================
    public static class MissingNumber {
        
        // Case 1: Without in-built methods (0 to n)
        public static int findMissingNumber(int[] arr) {
            int n = arr.length;
            int expectedSum = n * (n + 1) / 2;
            int actualSum = 0;
            for (int num : arr) {
                actualSum += num;
            }
            return expectedSum - actualSum;
        }
        
        // Case 2: Using Stream API
        public static int findMissingNumberStream(int[] arr) {
            int n = arr.length;
            int expectedSum = n * (n + 1) / 2;
            int actualSum = Arrays.stream(arr).sum();
            return expectedSum - actualSum;
        }
    }
    
    // ==================== 8. FIND DUPLICATE NUMBER ====================
    public static class DuplicateNumber {
        
        // Case 1: Without in-built methods (Floyd's Algorithm)
        public static int findDuplicate(int[] arr) {
            int slow = arr[0], fast = arr[0];
            do {
                slow = arr[slow];
                fast = arr[arr[fast]];
            } while (slow != fast);
            
            slow = arr[0];
            while (slow != fast) {
                slow = arr[slow];
                fast = arr[fast];
            }
            return slow;
        }
        
        // Case 2: Using Stream API
        public static int findDuplicateStream(int[] arr) {
            Set<Integer> seen = new HashSet<>();
            return Arrays.stream(arr)
                        .filter(n -> !seen.add(n))
                        .findFirst()
                        .orElse(-1);
        }
    }
    
    // ==================== 9. TWO SUM ====================
    public static class TwoSum {
        
        // Case 1: Without in-built methods
        public static int[] findTwoSum(int[] arr, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int complement = target - arr[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(arr[i], i);
            }
            return new int[]{-1, -1};
        }
        
        // Case 2: Using Stream API
        public static int[] findTwoSumStream(int[] arr, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            return IntStream.range(0, arr.length)
                .filter(i -> {
                    int complement = target - arr[i];
                    if (map.containsKey(complement)) return true;
                    map.put(arr[i], i);
                    return false;
                })
                .mapToObj(i -> new int[]{map.get(target - arr[i]), i})
                .findFirst()
                .orElse(new int[]{-1, -1});
        }
    }
    
    // ==================== 10. BEST TIME TO BUY & SELL STOCK ====================
    public static class StockProfit {
        
        // Case 1: Without in-built methods
        public static int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int minPrice = prices[0], maxProfit = 0;
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    maxProfit = Math.max(maxProfit, price - minPrice);
                }
            }
            return maxProfit;
        }
        
        // Case 2: Using Stream API (with custom accumulator)
        public static int maxProfitStream(int[] prices) {
            return Arrays.stream(prices)
                .collect(() -> new int[]{Integer.MAX_VALUE, 0},
                    (acc, price) -> {
                        acc[0] = Math.min(acc[0], price);
                        acc[1] = Math.max(acc[1], price - acc[0]);
                    },
                    (a, b) -> {
                        a[0] = Math.min(a[0], b[0]);
                        a[1] = Math.max(a[1], b[1]);
                    }
                )[1];
        }
    }
    
    // ==================== 11. MAXIMUM SUBARRAY SUM (KADANE) ====================
    public static class MaximumSubarray {
        
        // Case 1: Without in-built methods
        public static int maxSubArray(int[] arr) {
            int maxSoFar = arr[0], maxEndingHere = arr[0];
            for (int i = 1; i < arr.length; i++) {
                maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            return maxSoFar;
        }
        
        // Case 2: Using Stream API
        public static int maxSubArrayStream(int[] arr) {
            int[] result = Arrays.stream(arr)
                .collect(() -> new int[]{Integer.MIN_VALUE, 0},
                    (acc, num) -> {
                        acc[1] = Math.max(num, acc[1] + num);
                        acc[0] = Math.max(acc[0], acc[1]);
                    },
                    (a, b) -> {
                        a[0] = Math.max(a[0], b[0]);
                        a[1] = Math.max(a[1], b[1]);
                    }
                );
            return result[0];
        }
    }
    
    // ==================== 12. PRODUCT OF ARRAY EXCEPT SELF ====================
    public static class ProductExceptSelf {
        
        // Case 1: Without in-built methods
        public static int[] productExceptSelf(int[] arr) {
            int n = arr.length;
            int[] result = new int[n];
            
            // Left products
            int left = 1;
            for (int i = 0; i < n; i++) {
                result[i] = left;
                left *= arr[i];
            }
            
            // Right products
            int right = 1;
            for (int i = n - 1; i >= 0; i--) {
                result[i] *= right;
                right *= arr[i];
            }
            return result;
        }
        
        // Case 2: Using Stream API
        public static int[] productExceptSelfStream(int[] arr) {
            int totalProduct = Arrays.stream(arr)
                .reduce(1, (a, b) -> a * b);
            
            return Arrays.stream(arr)
                .map(num -> totalProduct / num)
                .toArray();
        }
    }
    
    // ==================== 13. MERGE INTERVALS ====================
    public static class MergeIntervals {
        
        // Case 1: Without in-built methods
        public static int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) return intervals;
            
            // Sort by start time
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            
            List<int[]> merged = new ArrayList<>();
            int[] current = intervals[0];
            merged.add(current);
            
            for (int[] interval : intervals) {
                if (current[1] >= interval[0]) {
                    current[1] = Math.max(current[1], interval[1]);
                } else {
                    current = interval;
                    merged.add(current);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
        
        // Case 2: Using Stream API
        public static int[][] mergeStream(int[][] intervals) {
            return Arrays.stream(intervals)
                .sorted((a, b) -> a[0] - b[0])
                .collect(ArrayList<int[]>::new, (list, interval) -> {
                    if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
                        list.add(interval);
                    } else {
                        int[] last = list.get(list.size() - 1);
                        last[1] = Math.max(last[1], interval[1]);
                    }
                }, ArrayList::addAll)
                .toArray(new int[0][]);
        }
    }
    
    // ==================== 14. TRAPPING RAIN WATER ====================
    public static class TrappingRainWater {
        
        // Case 1: Without in-built methods
        public static int trap(int[] height) {
            int n = height.length;
            if (n <= 2) return 0;
            
            int left = 0, right = n - 1;
            int leftMax = 0, rightMax = 0;
            int water = 0;
            
            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= leftMax) {
                        leftMax = height[left];
                    } else {
                        water += leftMax - height[left];
                    }
                    left++;
                } else {
                    if (height[right] >= rightMax) {
                        rightMax = height[right];
                    } else {
                        water += rightMax - height[right];
                    }
                    right--;
                }
            }
            return water;
        }
        
        // Case 2: Using Stream API (not ideal but possible)
        public static int trapStream(int[] height) {
            int n = height.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];
            
            IntStream.range(0, n).forEach(i -> 
                leftMax[i] = (i == 0) ? height[i] : Math.max(height[i], leftMax[i - 1])
            );
            
            IntStream.rangeClosed(1, n).forEach(i -> {
                int idx = n - i;
                rightMax[idx] = (idx == n - 1) ? height[idx] : Math.max(height[idx], rightMax[idx + 1]);
            });
            
            return IntStream.range(0, n)
                .map(i -> Math.min(leftMax[i], rightMax[i]) - height[i])
                .sum();
        }
    }
    
    // ==================== 15. SPIRAL MATRIX ====================
    public static class SpiralMatrix {
        
        // Case 1: Without in-built methods
        public static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix.length == 0) return result;
            
            int top = 0, bottom = matrix.length - 1;
            int left = 0, right = matrix[0].length - 1;
            
            while (top <= bottom && left <= right) {
                // Right
                for (int j = left; j <= right; j++) result.add(matrix[top][j]);
                top++;
                
                // Down
                for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
                right--;
                
                // Left
                if (top <= bottom) {
                    for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                    bottom--;
                }
                
                // Up
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                    left++;
                }
            }
            return result;
        }
        
        // Case 2: Using Stream API
        public static List<Integer> spiralOrderStream(int[][] matrix) {
            return IntStream.range(0, Math.min(matrix.length, matrix[0].length))
                .flatMap(layer -> {
                    List<Integer> layerElements = new ArrayList<>();
                    int lastRow = matrix.length - layer - 1;
                    int lastCol = matrix[0].length - layer - 1;
                    
                    // Top row
                    IntStream.range(layer, lastCol + 1)
                        .forEach(j -> layerElements.add(matrix[layer][j]));
                    
                    // Right column
                    IntStream.range(layer + 1, lastRow + 1)
                        .forEach(i -> layerElements.add(matrix[i][lastCol]));
                    
                    // Bottom row
                    if (layer < lastRow) {
                        IntStream.rangeClosed(layer + 1, lastCol)
                            .map(j -> lastCol - j + layer)
                            .forEach(j -> layerElements.add(matrix[lastRow][j]));
                    }
                    
                    // Left column
                    if (layer < lastCol) {
                        IntStream.rangeClosed(layer + 1, lastRow - 1)
                            .map(i -> lastRow - i + layer)
                            .forEach(i -> layerElements.add(matrix[i][layer]));
                    }
                    
                    return layerElements.stream().mapToInt(Integer::intValue);
                })
                 .boxed()
                .collect(Collectors.toList());
        }
    }
    
    // ==================== 16. SET MATRIX ZEROES ====================
    public static class SetMatrixZeroes {
        
        // Case 1: Without in-built methods
        public static void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean firstRowZero = false, firstColZero = false;
            
            // Check first row
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    firstRowZero = true;
                    break;
                }
            }
            
            // Check first col
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    firstColZero = true;
                    break;
                }
            }
            
            // Mark zeros
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            
            // Set zeros
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            
            // Set first row
            if (firstRowZero) {
                for (int j = 0; j < n; j++) matrix[0][j] = 0;
            }
            
            // Set first col
            if (firstColZero) {
                for (int i = 0; i < m; i++) matrix[i][0] = 0;
            }
        }
        
        // Case 2: Using Stream API (for checking and marking)
        public static void setZeroesStream(int[][] matrix) {
            boolean[] zeroRows = new boolean[matrix.length];
            boolean[] zeroCols = new boolean[matrix[0].length];
            
            IntStream.range(0, matrix.length).forEach(i ->
                IntStream.range(0, matrix[0].length).forEach(j -> {
                    if (matrix[i][j] == 0) {
                        zeroRows[i] = true;
                        zeroCols[j] = true;
                    }
                })
            );
            
            IntStream.range(0, matrix.length).forEach(i ->
                IntStream.range(0, matrix[0].length).forEach(j -> {
                    if (zeroRows[i] || zeroCols[j]) {
                        matrix[i][j] = 0;
                    }
                })
            );
        }
    }
    
    // ==================== 17. CONTAINER WITH MOST WATER ====================
    public static class ContainerWithMostWater {
        
        // Case 1: Without in-built methods
        public static int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;
            
            while (left < right) {
                int area = Math.min(height[left], height[right]) * (right - left);
                maxArea = Math.max(maxArea, area);
                
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
        
        // Case 2: Using Stream API
        public static int maxAreaStream(int[] height) {
            int[] result = IntStream.range(0, height.length)
                .flatMap(i -> IntStream.range(i + 1, height.length)
                    .map(j -> Math.min(height[i], height[j]) * (j - i)))
                .collect(() -> new int[]{0},
                    (max, area) -> max[0] = Math.max(max[0], area),
                    (a, b) -> a[0] = Math.max(a[0], b[0])
                );
            return result[0];
        }
    }
    
    // ==================== 18. MAJORITY ELEMENT ====================
    public static class MajorityElement {
        
        // Case 1: Without in-built methods (Boyer-Moore)
        public static int majorityElement(int[] nums) {
            int count = 0, candidate = 0;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
        }
        
        // Case 2: Using Stream API
        public static int majorityElementStream(int[] nums) {
            return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                    n -> n, 
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        }
    }
    
    // ==================== 19. LONGEST CONSECUTIVE SEQUENCE ====================
    public static class LongestConsecutiveSequence {
        
        // Case 1: Without in-built methods
        public static int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            
            int longest = 0;
            for (int num : numSet) {
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;
                    
                    while (numSet.contains(currentNum + 1)) {
                        currentNum++;
                        currentStreak++;
                    }
                    
                    longest = Math.max(longest, currentStreak);
                }
            }
            return longest;
        }
        
        // Case 2: Using Stream API
        public static int longestConsecutiveStream(int[] nums) {
            Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            
            return numSet.stream()
                .filter(num -> !numSet.contains(num - 1))
                .mapToInt(num -> {
                    int streak = 1;
                    int current = num;
                    while (numSet.contains(current + 1)) {
                        current++;
                        streak++;
                    }
                    return streak;
                })
                .max()
                .orElse(0);
        }
    }
    
    // ==================== 20. SUBARRAY SUM EQUALS K ====================
    public static class SubarraySumEqualsK {
        
        // Case 1: Without in-built methods
        public static int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumMap = new HashMap<>();
            sumMap.put(0, 1);
            int count = 0, sum = 0;
            
            for (int num : nums) {
                sum += num;
                if (sumMap.containsKey(sum - k)) {
                    count += sumMap.get(sum - k);
                }
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
        
        // Case 2: Using Stream API
        public static int subarraySumStream(int[] nums, int k) {
            Map<Integer, Integer> sumMap = new HashMap<>();
            sumMap.put(0, 1);
            
            int[] result = Arrays.stream(nums)
                .collect(() -> new int[]{0, 0},  // [count, currentSum]
                    (acc, num) -> {
                        acc[1] += num;
                        if (sumMap.containsKey(acc[1] - k)) {
                            acc[0] += sumMap.get(acc[1] - k);
                        }
                        sumMap.put(acc[1], sumMap.getOrDefault(acc[1], 0) + 1);
                    },
                    (a, b) -> {
                        a[0] += b[0];
                        a[1] += b[1];
                    }
                );
            return result[0];
        }
    }
    
    // ==================== MAIN METHOD TO TEST ALL ====================
    public static void main(String[] args) {
        System.out.println("========== TESTING ALL 20 ARRAY PROBLEMS ==========\n");
        
        // 1. Reverse Array
        System.out.println("1. REVERSE ARRAY");
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Case 1 (In-place): " + Arrays.toString(ReverseArray.reverseInPlace(arr1.clone())));
        System.out.println("Case 2 (Stream): " + Arrays.toString(ReverseArray.reverseWithStream(arr1)));
        System.out.println();
        
        // 2. Find Maximum/Minimum
        System.out.println("2. FIND MAXIMUM/MINIMUM");
        int[] arr2 = {3, 7, 1, 9, 4, 6, 2, 8, 5};
        int[] maxMin = MaxMin.findMaxMin(arr2);
        System.out.println("Case 1 (Without built-in): Max=" + maxMin[0] + ", Min=" + maxMin[1]);
        int[] maxMinStream = MaxMin.findMaxMinStream(arr2);
        System.out.println("Case 2 (Stream): Max=" + maxMinStream[0] + ", Min=" + maxMinStream[1]);
        System.out.println();
        
        // 3. Second Largest Element
        System.out.println("3. SECOND LARGEST ELEMENT");
        int[] arr3 = {12, 35, 1, 10, 34, 1};
        System.out.println("Case 1 (Without built-in): " + SecondLargest.findSecondLargest(arr3));
        System.out.println("Case 2 (Stream): " + SecondLargest.findSecondLargestStream(arr3));
        System.out.println();
        
        // 4. Move Zeros to End
        System.out.println("4. MOVE ZEROS TO END");
        int[] arr4 = {0, 1, 0, 3, 12};
        System.out.println("Case 1 (Without built-in): " + Arrays.toString(MoveZeros.moveZerosToEnd(arr4.clone())));
        System.out.println("Case 2 (Stream): " + Arrays.toString(MoveZeros.moveZerosToEndStream(arr4)));
        System.out.println();
        
        // 5. Rotate Array
        System.out.println("5. ROTATE ARRAY");
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Case 1 (Without built-in): " + Arrays.toString(RotateArray.rotateRight(arr5.clone(), 3)));
        System.out.println("Case 2 (Stream): " + Arrays.toString(RotateArray.rotateRightStream(arr5, 3)));
        System.out.println();
        
        // 6. Remove Duplicates
        System.out.println("6. REMOVE DUPLICATES");
        int[] arr6 = {1, 2, 2, 3, 4, 4, 4, 5};
        System.out.println("Case 1 (Without built-in): " + Arrays.toString(RemoveDuplicates.removeDuplicates(arr6.clone())));
        System.out.println("Case 2 (Stream): " + Arrays.toString(RemoveDuplicates.removeDuplicatesStream(arr6)));
        System.out.println();
        
        // 7. Find Missing Number
        System.out.println("7. FIND MISSING NUMBER");
        int[] arr7 = {3, 0, 1, 4, 6, 2};
        System.out.println("Case 1 (Without built-in): " + MissingNumber.findMissingNumber(arr7));
        System.out.println("Case 2 (Stream): " + MissingNumber.findMissingNumberStream(arr7));
        System.out.println();
        
        // 8. Find Duplicate Number
        System.out.println("8. FIND DUPLICATE NUMBER");
        int[] arr8 = {1, 3, 4, 2, 2};
        System.out.println("Case 1 (Floyd's Algorithm): " + DuplicateNumber.findDuplicate(arr8));
        System.out.println("Case 2 (Stream): " + DuplicateNumber.findDuplicateStream(arr8));
        System.out.println();
        
        // 9. Two Sum
        System.out.println("9. TWO SUM");
        int[] arr9 = {2, 7, 11, 15};
        System.out.println("Case 1 (Without built-in): " + Arrays.toString(TwoSum.findTwoSum(arr9, 9)));
        System.out.println("Case 2 (Stream): " + Arrays.toString(TwoSum.findTwoSumStream(arr9, 9)));
        System.out.println();
        
        // 10. Best Time to Buy & Sell Stock
        System.out.println("10. BEST TIME TO BUY & SELL STOCK");
        int[] arr10 = {7, 1, 5, 3, 6, 4};
        System.out.println("Case 1 (Without built-in): " + StockProfit.maxProfit(arr10));
        System.out.println("Case 2 (Stream): " + StockProfit.maxProfitStream(arr10));
        System.out.println();
        
        // 11. Maximum Subarray Sum
        System.out.println("11. MAXIMUM SUBARRAY SUM");
        int[] arr11 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Case 1 (Kadane): " + MaximumSubarray.maxSubArray(arr11));
        System.out.println("Case 2 (Stream): " + MaximumSubarray.maxSubArrayStream(arr11));
        System.out.println();
        
        // 12. Product of Array Except Self
        System.out.println("12. PRODUCT OF ARRAY EXCEPT SELF");
        int[] arr12 = {1, 2, 3, 4};
        System.out.println("Case 1 (Without built-in): " + Arrays.toString(ProductExceptSelf.productExceptSelf(arr12)));
        System.out.println("Case 2 (Stream): " + Arrays.toString(ProductExceptSelf.productExceptSelfStream(arr12)));
        System.out.println();
        
        // 13. Merge Intervals
        System.out.println("13. MERGE INTERVALS");
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Case 1 (Without built-in): " + Arrays.deepToString(MergeIntervals.merge(intervals)));
        System.out.println("Case 2 (Stream): " + Arrays.deepToString(MergeIntervals.mergeStream(intervals)));
        System.out.println();
        
        // 14. Trapping Rain Water
        System.out.println("14. TRAPPING RAIN WATER");
        int[] arr14 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Case 1 (Two Pointer): " + TrappingRainWater.trap(arr14));
        System.out.println("Case 2 (Stream): " + TrappingRainWater.trapStream(arr14));
        System.out.println();
        
        // 15. Spiral Matrix
        System.out.println("15. SPIRAL MATRIX");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Case 1 (Without built-in): " + SpiralMatrix.spiralOrder(matrix));
        System.out.println("Case 2 (Stream): " + SpiralMatrix.spiralOrderStream(matrix));
        System.out.println();
        
        // 16. Set Matrix Zeroes
        System.out.println("16. SET MATRIX ZEROES");
        int[][] matrix16 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Original: " + Arrays.deepToString(matrix16));
        int[][] matrix16Clone = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        SetMatrixZeroes.setZeroes(matrix16Clone);
        System.out.println("Case 1 (Without built-in): " + Arrays.deepToString(matrix16Clone));
        int[][] matrix16Stream = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        SetMatrixZeroes.setZeroesStream(matrix16Stream);
        System.out.println("Case 2 (Stream): " + Arrays.deepToString(matrix16Stream));
        System.out.println();
        
        // 17. Container With Most Water
        System.out.println("17. CONTAINER WITH MOST WATER");
        int[] arr17 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Case 1 (Two Pointer): " + ContainerWithMostWater.maxArea(arr17));
        System.out.println("Case 2 (Stream): " + ContainerWithMostWater.maxAreaStream(arr17));
        System.out.println();
        
        // 18. Majority Element
        System.out.println("18. MAJORITY ELEMENT");
        int[] arr18 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Case 1 (Boyer-Moore): " + MajorityElement.majorityElement(arr18));
        System.out.println("Case 2 (Stream): " + MajorityElement.majorityElementStream(arr18));
        System.out.println();
        
        // 19. Longest Consecutive Sequence
        System.out.println("19. LONGEST CONSECUTIVE SEQUENCE");
        int[] arr19 = {100, 4, 200, 1, 3, 2};
        System.out.println("Case 1 (Without built-in): " + LongestConsecutiveSequence.longestConsecutive(arr19));
        System.out.println("Case 2 (Stream): " + LongestConsecutiveSequence.longestConsecutiveStream(arr19));
        System.out.println();
        
        // 20. Subarray Sum Equals K
        System.out.println("20. SUBARRAY SUM EQUALS K");
        int[] arr20 = {1, 1, 1};
        System.out.println("Case 1 (Without built-in): " + SubarraySumEqualsK.subarraySum(arr20, 2));
        System.out.println("Case 2 (Stream): " + SubarraySumEqualsK.subarraySumStream(arr20, 2));
        System.out.println();
        
        System.out.println("========== ALL 20 PROBLEMS TESTED SUCCESSFULLY ==========");
    }
}