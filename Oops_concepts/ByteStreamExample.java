import java.util.Scanner;

public class ByteStreamExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read string input

        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read integer input

        System.out.println("Hello " + name + ", you are " + age + " years old.");

        scanner.close();
    }
}

// import java.io.*;

// public class ByteStreamExample {
// public static void main(String[] args) {
// try {
// BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
// writer.write("Buffered Writer Example!");
// writer.newLine(); // Add a new line
// writer.write("Writing multiple lines.");
// writer.close();
// System.out.println("File written successfully!");
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }

// import java.io.*;

// //Example: Reading a File using BufferedReader

// public class ByteStreamExample {
// public static void main(String[] args) {
// try {
// BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
// String line;
// while ((line = reader.readLine()) != null) { // Read line by line
// System.out.println(line);
// }
// reader.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }

// //FileOutputExample
// import java.io.*;

// public class ByteStreamExample {
// public static void main(String[] args) {
// try {
// FileOutputStream file = new FileOutputStream("output.txt");
// String text = "Hello, Java File I/O!";
// file.write(text.getBytes()); // Convert string to bytes
// file.close();
// System.out.println("File written successfully!");
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }

// // Example: Reading a File using FileInputStream

// import java.io.*;

// public class ByteStreamExample {
// public static void main(String[] args) {
// try {
// FileInputStream file = new FileInputStream("input.txt");
// int data;
// while ((data = file.read()) != -1) {
// System.out.print((char) data); // Convert byte to char
// }
// file.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }

// // //Example: Reading and Writing Bytes

// import java.io.*;

// public class ByteStreamExample {
// public static void main(String[] args) {
// try {
// FileReader reader = new FileReader("input.txt");
// FileWriter writer = new FileWriter("output.txt");

// int charData;
// while ((charData = reader.read()) != -1) { // Read char-by-char
// writer.write(charData); // Write char to output file
// }

// reader.close();
// writer.close();
// System.out.println("File copied successfully!");
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }

// //Example: Reading and Writing Bytes
// import java.io.*;

// public class ByteStreamExample {
// public static void main(String[] args) {
// try {
// FileInputStream in = new FileInputStream("input.txt");
// FileOutputStream out = new FileOutputStream("output.txt");

// int byteData;
// while ((byteData = in.read()) != -1) { // Read byte-by-byte
// out.write(byteData); // Write byte to output file
// }

// in.close();
// out.close();
// System.out.println("File copied successfully!");
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }
