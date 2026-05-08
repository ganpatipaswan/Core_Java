import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreamManipulate {
    public static void main(String[] args) {
        // List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        String[] words = { "Apple", "Banana", "Cherry", "Date" };
        List<String> newStr = Arrays.stream(words)
                .map(item -> new StringBuilder(item).toString().toUpperCase())
                .collect(Collectors.toList());
        System.out.println(newStr);

        List<String> newStr1 = Arrays.stream(words)
                .map(String::toUpperCase) // Method reference - most efficient
                .collect(Collectors.toList());
        System.out.println(newStr1);


        
        List<String> words1 = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        System.out.println("   Original: " + words);
       List<String> upperCase = new ArrayList<>();
        words1.stream()
                .map(String::toUpperCase)
                .forEach(upperCase::add);
        System.out.println("   Uppercase via stream: " + upperCase);
    }
}
