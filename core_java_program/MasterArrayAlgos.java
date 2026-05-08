import java.util.*;

public class MasterArrayAlgos {

    public static void main(String[] args) {
        // --- Examples of usage ---
        int[] nums = {2, 7, 11, 15};
        System.out.println("Two Sum: " + Arrays.toString(twoSum(nums, 9)));

        int[] kadaneArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Subarray (Kadane): " + maxSubArray(kadaneArr));

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merge Intervals: " + Arrays.deepToString(merge(intervals)));

        int[] productArr = {1, 2, 3, 4};
        System.out.println("Product Except Self: " + Arrays.toString(productExceptSelf(productArr)));

        int[] rainWater = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapping Rain Water: " + trap(rainWater));

        System.out.println("Longest Substring: " + lengthOfLongestSubstring("abcabcbb"));

        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Search Rotated: " + search(rotated, 0));

        int[] duplicates = {1, 3, 4, 2, 2};
        System.out.println("Find Duplicate: " + findDuplicate(duplicates));

        int[] sortArr = {2, 0, 2, 1, 1, 0};
        sortColors(sortArr);
        System.out.println("Sort 0s, 1s, 2s: " + Arrays.toString(sortArr));

        int[] kthArr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("Kth Largest: " + findKthLargest(kthArr, 4));

        int[] zeros = {0, 1, 0, 3, 12};
        moveZeroes(zeros);
        System.out.println("Move Zeros: " + Arrays.toString(zeros));

        int[] subSumK = {1, 1, 1,8,9};
        System.out.println("Subarray Sum = K: " + subarraySum(subSumK, 2));

        int[] longConsec = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive: " + longestConsecutive(longConsec));

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println("Set Matrix Zeroes: " + Arrays.deepToString(matrix));

        int[][] spiralMat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Spiral Matrix: " + spiralOrder(spiralMat));
    }

    // 1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // 2. Maximum Subarray (Kadane's Algorithm)
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // 3. Merge Intervals
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) current[1] = Math.max(current[1], interval[1]);
            else {
                current = interval;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    // 4. Product of Array Except Self
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length, left = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) { res[i] = left; left *= nums[i]; }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) { res[i] *= right; right *= nums[i]; }
        return res;
    }

    // 5. Trapping Rain Water
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1, lMax = 0, rMax = 0, res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lMax) lMax = height[l]; else res += lMax - height[l];
                l++;
            } else {
                if (height[r] >= rMax) rMax = height[r]; else res += rMax - height[r];
                r--;
            }
        }
        return res;
    }

    // 6. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) left = Math.max(left, map.get(s.charAt(right)) + 1);
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // 7. Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) high = mid - 1; else low = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[high]) low = mid + 1; else high = mid - 1;
            }
        }
        return -1;
    }

    // 8. Find Duplicate Number
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do { slow = nums[slow]; fast = nums[nums[fast]]; } while (slow != fast);
        fast = nums[0];
        while (slow != fast) { slow = nums[slow]; fast = nums[fast]; }
        return slow;
    }

    // 9. Sort 0s, 1s, 2s (Dutch National Flag)
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) { swap(nums, low++, mid++); }
            else if (nums[mid] == 1) { mid++; }
            else { swap(nums, mid, high--); }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
    }

    // 10. Kth Largest Element
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) { pq.add(val); if (pq.size() > k) pq.poll(); }
        return pq.peek();
    }

    // 11. Move Zeros
    public static void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] != 0) nums[lastNonZero++] = nums[i];
        for (int i = lastNonZero; i < nums.length; i++) nums[i] = 0;
    }

    // 12. Subarray Sum = K
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 13. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int max = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int curr = n, count = 1;
                while (set.contains(curr + 1)) { curr++; count++; }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    // 14. Set Matrix Zeroes
    public static void setZeroes(int[][] matrix) {
        boolean col0 = false;
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j = 1; j < cols; j++) if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            if (col0) matrix[i][0] = 0;
        }
    }

    // 15. Spiral Matrix
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) res.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) res.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) res.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) res.add(matrix[r][c1]);
            }
            r1++; r2--; c1++; c2--;
        }
        return res;
    }
}
