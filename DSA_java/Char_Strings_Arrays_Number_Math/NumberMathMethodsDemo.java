package Char_Strings_Arrays_Number_Math;

public class NumberMathMethodsDemo {

    public static void main(String[] args) {

        // int num = 25;
        double d = 4.7;

        // =========================================
        // NUMBER METHODS
        // =========================================

        // 1. Integer.parseInt()
        System.out.println("1. parseInt()");
        System.out.println(Integer.parseInt("100"));

        // 2. Integer.toString()
        System.out.println("\n2. toString()");
        System.out.println(Integer.toString(500));

        // 3. Integer.max()
        System.out.println("\n3. max()");
        System.out.println(Integer.max(10, 20));

        // 4. Integer.min()
        System.out.println("\n4. min()");
        System.out.println(Integer.min(10, 20));

        // 5. Integer.sum()
        System.out.println("\n5. sum()");
        System.out.println(Integer.sum(5, 10));

        // 6. Integer.compare()
        System.out.println("\n6. compare()");
        System.out.println(Integer.compare(10, 20));

        // 7. Integer.valueOf()
        System.out.println("\n7. valueOf()");
        System.out.println(Integer.valueOf("200"));

        // 8. Integer.toBinaryString()
        System.out.println("\n8. toBinaryString()");
        System.out.println(Integer.toBinaryString(10));

        // 9. Integer.toOctalString()
        System.out.println("\n9. toOctalString()");
        System.out.println(Integer.toOctalString(10));

        // 10. Integer.toHexString()
        System.out.println("\n10. toHexString()");
        System.out.println(Integer.toHexString(255));

        // =========================================
        // MATH METHODS
        // =========================================

        // 11. Math.abs()
        System.out.println("\n11. abs()");
        System.out.println(Math.abs(-10));

        // 12. Math.sqrt()
        System.out.println("\n12. sqrt()");
        System.out.println(Math.sqrt(25));

        // 13. Math.pow()
        System.out.println("\n13. pow()");
        System.out.println(Math.pow(2, 3));

        // 14. Math.max()
        System.out.println("\n14. max()");
        System.out.println(Math.max(100, 200));

        // 15. Math.min()
        System.out.println("\n15. min()");
        System.out.println(Math.min(100, 200));

        // 16. Math.random()
        System.out.println("\n16. random()");
        System.out.println(Math.random());

        // 17. Math.ceil()
        System.out.println("\n17. ceil()");
        System.out.println(Math.ceil(d));

        // 18. Math.floor()
        System.out.println("\n18. floor()");
        System.out.println(Math.floor(d));

        // 19. Math.round()
        System.out.println("\n19. round()");
        System.out.println(Math.round(d));

        // 20. Math.cbrt()
        System.out.println("\n20. cbrt()");
        System.out.println(Math.cbrt(27));

        // 21. Math.sin()
        System.out.println("\n21. sin()");
        System.out.println(Math.sin(90));

        // 22. Math.cos()
        System.out.println("\n22. cos()");
        System.out.println(Math.cos(0));

        // 23. Math.log()
        System.out.println("\n23. log()");
        System.out.println(Math.log(10));

        // 24. Math.exp()
        System.out.println("\n24. exp()");
        System.out.println(Math.exp(2));

        // 25. Math.PI
        System.out.println("\n25. PI");
        System.out.println(Math.PI);

        // 26. Math.E
        System.out.println("\n26. E");
        System.out.println(Math.E);
    }
}