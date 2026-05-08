// public class functional_programming {

// }
import java.util.function.Function;

public class Functional_programming {
    public static void main(String[] args) {
        
        // 1. The FUNCTION (The variable type/contract)
        // This says: "I need something that takes a String and returns an Integer"
        Function<String, Integer> lengthFunction;

        // 2. The LAMBDA (The actual logic/implementation)
        // This is the "inline" code that fulfills the contract above
        lengthFunction = (str) -> str.length();

        // Testing it
        Integer result = lengthFunction.apply("Hello World");
        System.out.println("Length is: " + result);
    }
}
