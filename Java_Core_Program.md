### 1. Maximum Sum Subarray of Size ≤ K 
// Find the maximum sum of any contiguous subarray with length at most k. 
// Example: let nums = [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]; // let k = 3 // Output: 16

``` java id="dup01"
public class Maximum_Sum_Subarray {

    public static void main(String[] args) {

        int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;

        int result = targetSum(nums, k);

        System.out.println("Result --> " + result);
    }

    public static int targetSum(int[] nums, int k) {

        int left = 0;
        int sum = 0;

        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // Keep window size <= k
            while (right - left + 1 > k) {

                sum -= nums[left];
                left++;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
```


## ✅ 2.Remove Duplicates from Array in Java

---

## ✅ 1. Best Interview Approach — Using `Set`

## 🔥 Preserves unique elements

```java id="dup1"
import java.util.*;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 4, 1, 5};

        Set<Integer> set = new LinkedHashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        System.out.println(set);
    }
}
```

---

# ✅ Output

```java id="dupout1"
[1, 2, 3, 4, 5]
```

---

# ✅ Why `LinkedHashSet`?

| Set Type      | Order                       |
| ------------- | --------------------------- |
| HashSet       | No order                    |
| LinkedHashSet | Maintains insertion order ✅ |
| TreeSet       | Sorted order                |

---

# ✅ 2. Using Java 8 Stream API

## 🔥 Most modern way

```java id="dup2"
import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 4, 1, 5};

        int[] unique = Arrays.stream(arr)
                             .distinct()
                             .toArray();

        System.out.println(Arrays.toString(unique));
    }
}
```

---

# ✅ Output

```java id="dupout2"
[1, 2, 3, 4, 5]
```

---

# ✅ 3. Without Using Set (Interview Favorite 🔥)

## 🔥 Nested Loop Approach

```java id="dup3"
public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 4, 1, 5};

        for (int i = 0; i < arr.length; i++) {

            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {

                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
```


# 3.Find duplicate from array;

``` java id="dup4"
// import java.util.Arrays;
// import java.util.Set;
// import java.util.HashSet;
import java.util.*;
import java.util.stream.Collectors;
public class FindDuplicates {

    public static void main(String[] args) {
// Method-1 List
List<Integer> list =Arrays.asList(1, 2, 3, 2, 4, 1, 5);

List<Integer> duplicates=list.stream()
.filter(item-> Collections.frequency(list,item)>1)
.distinct()
.collect(Collectors.toList());
  System.out.println(duplicates);
  
  // Method-2 Arrays
          
          int[] arr = {1, 2, 3, 2, 4, 1, 5};

        Set<Integer> seen = new HashSet<>();

        int[] duplicates1 = Arrays.stream(arr)

                .filter(num -> !seen.add(num))

                .distinct()

                .toArray();
               
        System.out.println(Arrays.toString(duplicates1));
    }
}
```
## First Non Repeating from string ;
```  java id="dup5"
import java.util.*;
import java.util.stream.Collectors;
public class FirstNonRepeating {

    public static void main(String[] args) {
String s="madam";
 Character ch= s.chars() // IntStream of characters
        .mapToObj(c -> (char) c) // Convert to Stream<Character>
        .collect(Collectors.groupingBy(
        c->c, // c->c //Function.identity(), 
        LinkedHashMap::new, // Keeps the order of characters!
        Collectors.counting()
        ))
        .entrySet().stream()
        .filter(entry -> entry.getValue() == 1)
        .map(Map.Entry::getKey)
        .skip(0) //optional find firstskip(0) // find second skip(1)
        .findFirst() // Gets the first one that matched the filter
        .orElse(null);

               
        System.out.println(ch);
    }
}

```