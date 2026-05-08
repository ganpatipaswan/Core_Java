
public class Printformat {
    public static void main(String[] args) {
//         System.out.println()
// Function: println is short for "print line". It prints the given argument(s) to the console and then moves the cursor to the next line.
System.out.println("Hello, world!"); 
System.out.println("Next line.");
  // Output is: 
  // Hello, world!
  //  Next line. 


// System.out.printf()
// Function: printf is short for "print formatted" and provides detailed control over the output's layout, precision, and data type formatting using format specifiers.
double number = 1.2345678;
String name = "Alice";
System.out.printf("Hello, %s! The number is %.2f%n", name, number);


// Output is: Hello, Alice! The number is 1.23
}

}
