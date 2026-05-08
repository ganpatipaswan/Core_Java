public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            
            // Check overflow BEFORE multiplying
            if (result > Integer.MAX_VALUE / 10) return 0;
            if (result < Integer.MIN_VALUE / 10) return 0;
            
            result = result * 10 + digit;
            x = x / 10;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(reverse(123));    // 321
        System.out.println(reverse(-123));   // -321
        System.out.println(reverse(120));    // 21
    }
}