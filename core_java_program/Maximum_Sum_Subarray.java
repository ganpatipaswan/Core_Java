//***  Maximum Sum Subarray of Size ≤ K // Find the maximum sum of any contiguous subarray with length at most k. 
// Example: let nums = [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]; 
// let k = 3
 // Output: 16

public class Maximum_Sum_Subarray{
    public static void main(String[] args){
      int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
      int k = 3;
      int result= targetSum(nums, k);
      System.out.println("result--"+result); // ✅ 16
    }
  
  public static int targetSum(int[] nums, int k){
  int left=0;
  int sum=0;
  int maxSum=-Integer.MIN_VALUE;
  
    for(int right=0; right<nums.length; right++) {
         
        sum +=nums[right]; 
  
        while(right-left+1 >k){
          sum-=nums[left];
          left++ ; 
        }
        maxSum=Math.max(maxSum,sum);
    }
     
    return maxSum;
  }
  }

//   import java.util.stream.IntStream;

// public class TargetSumStream {
    
//     public static int targetSum(int[] nums, int k) {
//         if (nums == null || nums.length < k || k <= 0) return 0;
        
//         return IntStream.rangeClosed(0, nums.length - k)
//             .map(i -> IntStream.range(i, i + k).map(j -> nums[j]).sum())
//             .max()
//             .orElse(0);
//     }
    
//     public static void main(String[] args) {
//         int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
//         int k = 3;
        
//         int result = targetSum(nums, k);
//         System.out.println("Maximum sum of subarray size " + k + ": " + result); // ✅ 16
//     }
// }

// import java.util.stream.IntStream;
// import java.util.concurrent.atomic.AtomicInteger;

// public class TargetSumStream {
    
//     public static int targetSum(int[] nums, int k) {
//         if (nums.length < k) return 0;
        
//         // Calculate first window sum
//         int firstWindowSum = IntStream.range(0, k).map(i -> nums[i]).sum();
        
//         AtomicInteger maxSum = new AtomicInteger(firstWindowSum);
//         AtomicInteger currentSum = new AtomicInteger(firstWindowSum);
        
//         IntStream.range(k, nums.length)
//             .forEach(i -> {
//                 // Slide window: remove left element, add new element
//                 int newSum = currentSum.addAndGet(nums[i] - nums[i - k]);
//                 maxSum.set(Math.max(maxSum.get(), newSum));
//             });
        
//         return maxSum.get();
//     }
    
//     public static void main(String[] args) {
//         int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
//         int k = 3;
        
//         int result = targetSum(nums, k);
//         System.out.println("Maximum sum of subarray size " + k + ": " + result); // ✅ 16
//     }
// }