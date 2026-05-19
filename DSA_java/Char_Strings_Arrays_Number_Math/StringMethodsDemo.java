package Char_Strings_Arrays_Number_Math;

public class StringMethodsDemo {

    public static void main(String[] args) {

        String str = "Java Programming";

        // =========================================
        // 1. length()
        // =========================================
        System.out.println("1. length()");
        System.out.println(str.length());

        // =========================================
        // 2. charAt()
        // =========================================
        System.out.println("\n2. charAt()");
        System.out.println(str.charAt(2));

        // =========================================
        // 3. toUpperCase()
        // =========================================
        System.out.println("\n3. toUpperCase()");
        System.out.println(str.toUpperCase());

        // =========================================
        // 4. toLowerCase()
        // =========================================
        System.out.println("\n4. toLowerCase()");
        System.out.println(str.toLowerCase());

        // =========================================
        // 5. substring()
        // =========================================
        System.out.println("\n5. substring()");
        System.out.println(str.substring(0, 4));

        // =========================================
        // 6. contains()
        // =========================================
        System.out.println("\n6. contains()");
        System.out.println(str.contains("Java"));

        // =========================================
        // 7. equals()
        // =========================================
        System.out.println("\n7. equals()");
        System.out.println(str.equals("Java Programming"));

        // =========================================
        // 8. equalsIgnoreCase()
        // =========================================
        System.out.println("\n8. equalsIgnoreCase()");
        System.out.println(str.equalsIgnoreCase("JAVA PROGRAMMING"));

        // =========================================
        // 9. startsWith()
        // =========================================
        System.out.println("\n9. startsWith()");
        System.out.println(str.startsWith("Java"));

        // =========================================
        // 10. endsWith()
        // =========================================
        System.out.println("\n10. endsWith()");
        System.out.println(str.endsWith("ing"));

        // =========================================
        // 11. replace()
        // =========================================
        System.out.println("\n11. replace()");
        System.out.println(str.replace("Java", "Python"));

        // =========================================
        // 12. trim()
        // =========================================
        System.out.println("\n12. trim()");
        String space = "   Hello Java   ";
        System.out.println(space.trim());

        // =========================================
        // 13. indexOf()
        // =========================================
        System.out.println("\n13. indexOf()");
        System.out.println(str.indexOf("P"));

        // =========================================
        // 14. lastIndexOf()
        // =========================================
        System.out.println("\n14. lastIndexOf()");
        System.out.println(str.lastIndexOf("a"));

        // =========================================
        // 15. isEmpty()
        // =========================================
        System.out.println("\n15. isEmpty()");
        System.out.println(str.isEmpty());

        // =========================================
        // 16. concat()
        // =========================================
        System.out.println("\n16. concat()");
        System.out.println(str.concat(" Language"));

        // =========================================
        // 17. split()
        // =========================================
        System.out.println("\n17. split()");

        String[] arr = str.split(" ");

        for(String s : arr) {
            System.out.println(s);
        }

        // =========================================
        // 18. valueOf()
        // =========================================
        System.out.println("\n18. valueOf()");
        int num = 100;
        System.out.println(String.valueOf(num));

        // =========================================
        // 19. compareTo()
        // =========================================
        System.out.println("\n19. compareTo()");
        System.out.println("Java".compareTo("Python"));

        // =========================================
        // 20. repeat()
        // =========================================
        System.out.println("\n20. repeat()");
        System.out.println("Hi ".repeat(3));

        // =========================================
        // 21. reverse String
        // =========================================
        System.out.println("\n21. Reverse String");

        String reverse = "";

        for(int i = str.length() - 1; i >= 0; i--) {

            reverse += str.charAt(i);
        }

        System.out.println(reverse);

        // =========================================
        // 22. StringBuilder
        // =========================================
        System.out.println("\n22. StringBuilder");

        StringBuilder sb = new StringBuilder("Java");

        sb.append(" Programming");

        System.out.println(sb);

        // =========================================
        // 23. StringBuffer
        // =========================================
        System.out.println("\n23. StringBuffer");

        StringBuffer sf = new StringBuffer("Hello");

        sf.append(" World");

        System.out.println(sf);
    }
}