class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Exception_Handling { // CustomExceptionExample
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to register!");
        }
        System.out.println("Registration successful.");
    }

    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// // Example: throws Keyword
// import java.io.*;

// public class Exception_Handling {
// public static void readFile() throws IOException {
// FileReader file = new FileReader("nonexistent.txt"); // May cause an
// exception
// }

// public static void main(String[] args) {
// try {
// readFile();
// } catch (IOException e) {
// System.out.println("File not found: " + e.getMessage());
// }
// }
// }

// // Example: throw Keyword
// public class Exception_Handling {
// public static void validateAge(int age) {
// if (age < 18) {
// throw new ArithmeticException("Not eligible to vote");
// }
// System.out.println("Eligible to vote");
// }

// public static void main(String[] args) {
// validateAge(16); // This will throw an exception
// }
// }

// // Example: try-catch-finally
// public class Exception_Handling {
// public static void main(String[] args) {
// try {
// int result = 10 / 0; // Will cause an exception
// } catch (ArithmeticException e) {
// System.out.println("Cannot divide by zero!");
// } finally {
// System.out.println("Finally block executed.");
// }
// }
// }

// // Example: try-catch
// public class Exception_Handling {
// public static void main(String[] args) {
// try {
// int[] numbers = { 1, 2, 3 };
// System.out.println(numbers[5]); // Invalid index access
// } catch (ArrayIndexOutOfBoundsException e) {
// System.out.println("Array index out of bounds: " + e.getMessage());
// }
// }
// }

// Example: Handling Unchecked Exception
// import java.io.*;

// public class Exception_Handling {
// public static void main(String[] args) {
// try {
// int result = 10 / 0; // Division by zero
// } catch (ArithmeticException e) {
// System.out.println("Error: " + e.getMessage());
// }
// }
// }

// Example: Handling checked Exception
// import java.io.*;

// public class Exception_Handling {
// public static void main(String[] args) {
// try {
// FileReader file = new FileReader("nonexistent.txt"); // File does not exist
// BufferedReader br = new BufferedReader(file);
// } catch (FileNotFoundException e) {
// System.out.println("File not found: " + e.getMessage());
// }
// }
// }
