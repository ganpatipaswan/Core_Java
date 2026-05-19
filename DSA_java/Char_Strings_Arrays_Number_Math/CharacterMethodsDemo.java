package Char_Strings_Arrays_Number_Math;

public class CharacterMethodsDemo {

    public static void main(String[] args) {

        char ch = 'A';
        char digit = '5';
        char small = 'b';
        char space = ' ';

        // =========================================
        // 1. isLetter()
        // =========================================
        System.out.println("1. isLetter()");
        System.out.println(Character.isLetter(ch));

        // =========================================
        // 2. isDigit()
        // =========================================
        System.out.println("\n2. isDigit()");
        System.out.println(Character.isDigit(digit));

        // =========================================
        // 3. isWhitespace()
        // =========================================
        System.out.println("\n3. isWhitespace()");
        System.out.println(Character.isWhitespace(space));

        // =========================================
        // 4. isUpperCase()
        // =========================================
        System.out.println("\n4. isUpperCase()");
        System.out.println(Character.isUpperCase(ch));

        // =========================================
        // 5. isLowerCase()
        // =========================================
        System.out.println("\n5. isLowerCase()");
        System.out.println(Character.isLowerCase(small));

        // =========================================
        // 6. toUpperCase()
        // =========================================
        System.out.println("\n6. toUpperCase()");
        System.out.println(Character.toUpperCase('a'));

        // =========================================
        // 7. toLowerCase()
        // =========================================
        System.out.println("\n7. toLowerCase()");
        System.out.println(Character.toLowerCase('Z'));

        // =========================================
        // 8. isAlphabetic()
        // =========================================
        System.out.println("\n8. isAlphabetic()");
        System.out.println(Character.isAlphabetic('K'));

        // =========================================
        // 9. isLetterOrDigit()
        // =========================================
        System.out.println("\n9. isLetterOrDigit()");
        System.out.println(Character.isLetterOrDigit('9'));

        // =========================================
        // 10. getNumericValue()
        // =========================================
        System.out.println("\n10. getNumericValue()");
        System.out.println(Character.getNumericValue('8'));

        // =========================================
        // 11. compare()
        // =========================================
        System.out.println("\n11. compare()");
        System.out.println(Character.compare('A', 'B'));

        // =========================================
        // 12. toString()
        // =========================================
        System.out.println("\n12. toString()");
        System.out.println(Character.toString('J'));

        // =========================================
        // 13. charValue()
        // =========================================
        System.out.println("\n13. charValue()");

        Character obj = 'X';

        System.out.println(obj.charValue());

        // =========================================
        // 14. hashCode()
        // =========================================
        System.out.println("\n14. hashCode()");
        System.out.println(Character.hashCode('A'));

        // =========================================
        // 15. Unicode Value
        // =========================================
        System.out.println("\n15. Unicode Value");

        int unicode = (int)'A';

        System.out.println(unicode);

        // =========================================
        // 16. ASCII to Character
        // =========================================
        System.out.println("\n16. ASCII to Character");

        char ascii = (char)66;

        System.out.println(ascii);

        // =========================================
        // 17. Check Special Character
        // =========================================
        System.out.println("\n17. Special Character Check");

        char special = '@';

        if(!Character.isLetterOrDigit(special)) {

            System.out.println("Special Character");
        }

        // =========================================
        // 18. Count Vowels
        // =========================================
        System.out.println("\n18. Count Vowels");

        String str = "Java Programming";

        int count = 0;

        for(int i = 0; i < str.length(); i++) {

            char c = Character.toLowerCase(str.charAt(i));

            if(c == 'a' || c == 'e' || c == 'i'
                    || c == 'o' || c == 'u') {

                count++;
            }
        }

        System.out.println("Vowels = " + count);

        // =========================================
        // 19. Reverse Characters
        // =========================================
        System.out.println("\n19. Reverse Characters");

        String name = "JAVA";

        for(int i = name.length() - 1; i >= 0; i--) {

            System.out.print(name.charAt(i));
        }

        // =========================================
        // 20. Character Array
        // =========================================
        System.out.println("\n\n20. Character Array");

        char[] arr = {'J', 'A', 'V', 'A'};

        for(char c : arr) {

            System.out.print(c + " ");
        }
    }
}
