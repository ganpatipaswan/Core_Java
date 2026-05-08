
import java.util.Arrays;

public class CharArrayPrintDemo {
    public static void main(String[] args) {
        char[] letters = {'J', 'a', 'v', 'a'};
        
        // Different ways to print with prefix
        System.out.println("=== Different Approaches ===");
        
        // 1. Convert to String first
        System.out.println("1. " + new String(letters));
        
        // 2. Using String.valueOf()
        System.out.println("2. " + String.valueOf(letters));
        
        // 3. Using StringBuilder
        System.out.println("3. " + new StringBuilder("--").append(letters));
        
        // 4. Using printf
        System.out.printf("4. %s%n", new String(letters));
        
        // 5. Multiple print statements
        System.out.print("5. ");
        System.out.println(letters);
        
        // 6. Compare with other arrays
        int[] nums = {1, 2, 3};
        System.out.println("int[]: " + nums);              // Wrong way
        System.out.println("int[]: " + Arrays.toString(nums));  // Right way
    }
}

// output
// === Different Approaches ===
// 1. Java
// 2. Java
// 3. --Java
// 4. Java
// 5. Java
// int[]: [I@15db9742
// int[]: [1, 2, 3]