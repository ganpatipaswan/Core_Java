/**
 * Comprehensive Java I/O Program for Beginners
 * 
 * This program demonstrates all fundamental I/O operations in Java
 * with simple, easy-to-understand examples.
 * 
 * Topics covered:
 * 1. Console Input/Output
 * 2. File Operations (Create, Read, Write, Delete)
 * 3. Different Stream Types
 * 4. BufferedReader and Scanner
 * 5. FileReader and FileWriter
 * 6. Buffered Streams
 * 7. Data Streams
 * 8. Object Serialization
 * 9. NIO (New I/O) Basics
 * 10. Working with Directories
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaIOForBeginners {
    
    // Track current directory for demonstrations
    private static final String BASE_DIR = "java_io_demo";
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("JAVA INPUT/OUTPUT (I/O) - BEGINNER'S GUIDE");
        System.out.println("=".repeat(80));
        
        // Create base directory for our demonstrations
        createBaseDirectory();
        
        // Section 1: Console I/O
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 1: CONSOLE INPUT/OUTPUT");
        System.out.println("#".repeat(60));
        demonstrateConsoleIO();
        
        // Section 2: File Creation and Basic Operations
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 2: FILE CREATION AND BASIC OPERATIONS");
        System.out.println("#".repeat(60));
        demonstrateFileOperations();
        
        // Section 3: Reading Files
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 3: READING FILES");
        System.out.println("#".repeat(60));
        demonstrateFileReading();
        
        // Section 4: Writing Files
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 4: WRITING FILES");
        System.out.println("#".repeat(60));
        demonstrateFileWriting();
        
        // Section 5: Buffered Streams
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 5: BUFFERED STREAMS (EFFICIENT I/O)");
        System.out.println("#".repeat(60));
        demonstrateBufferedStreams();
        
        // Section 6: Data Streams (Primitive Types)
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 6: DATA STREAMS (PRIMITIVE TYPES)");
        System.out.println("#".repeat(60));
        demonstrateDataStreams();
        
        // Section 7: Object Serialization
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 7: OBJECT SERIALIZATION");
        System.out.println("#".repeat(60));
        demonstrateObjectSerialization();
        
        // Section 8: NIO (New I/O) Basics
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 8: NIO (NEW I/O) BASICS");
        System.out.println("#".repeat(60));
        demonstrateNIOBasics();
        
        // Section 9: Directory Operations
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 9: DIRECTORY OPERATIONS");
        System.out.println("#".repeat(60));
        demonstrateDirectoryOperations();
        
        // Section 10: File Properties and Metadata
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 10: FILE PROPERTIES AND METADATA");
        System.out.println("#".repeat(60));
        demonstrateFileProperties();
        
        // Clean up
        cleanupDemonstration();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("🎉 CONGRATULATIONS! You've learned Java I/O basics!");
        System.out.println("=".repeat(80));
    }
    
    // =========================================================================
    // HELPER METHODS
    // =========================================================================
    
    private static void createBaseDirectory() {
        File dir = new File(BASE_DIR);
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("📁 Created base directory: " + BASE_DIR);
        }
    }
    
    private static void cleanupDemonstration() {
        System.out.println("\n" + "#".repeat(60));
        System.out.println("CLEANING UP DEMONSTRATION FILES");
        System.out.println("#".repeat(60));
        
        deleteDirectory(new File(BASE_DIR));
        System.out.println("🧹 Cleaned up all demonstration files");
    }
    
    private static void deleteDirectory(File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                        System.out.println("   Deleted: " + file.getName());
                    }
                }
            }
            dir.delete();
        }
    }
    
    // =========================================================================
    // SECTION 1: CONSOLE INPUT/OUTPUT
    // =========================================================================
    
    private static void demonstrateConsoleIO() {
        System.out.println("\n📌 Console I/O - Reading from keyboard and writing to screen");
        
        // Method 1: System.out.println() - Output
        System.out.println("\n1. System.out.println() - Basic Output:");
        System.out.println("   Hello, World!");
        System.out.print("   This is print() - no newline");
        System.out.println("   and this continues on same line");
        
        // Method 2: System.out.printf() - Formatted Output
        System.out.println("\n2. System.out.printf() - Formatted Output:");
        String name = "John";
        int age = 25;
        double salary = 50000.50;
        System.out.printf("   Name: %s, Age: %d, Salary: $%.2f%n", name, age, salary);
        
        // Method 3: System.out.format() - Another way to format
        System.out.println("\n3. System.out.format() - Alternative formatting:");
        System.out.format("   %-10s %-10s %-10s%n", "Name", "Age", "City");
        System.out.format("   %-10s %-10d %-10s%n", "Alice", 30, "NYC");
        System.out.format("   %-10s %-10d %-10s%n", "Bob", 35, "LA");
        
        // Method 4: Scanner for input
        System.out.println("\n4. Scanner - Reading Input:");
        System.out.println("   (This would wait for user input - commented out for automation)");
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("   Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("   Enter your age: ");
        int userAge = scanner.nextInt();
        System.out.println("   Hello " + userName + ", you are " + userAge + " years old!");
        scanner.close();
        */
        
        // Method 5: BufferedReader (older way)
        System.out.println("\n5. BufferedReader - Alternative input method:");
        System.out.println("   (Similar to Scanner but older and faster for large input)");
        /*
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("   Enter something: ");
            String input = reader.readLine();
            System.out.println("   You entered: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        
        // Method 6: Console class (for password input)
        System.out.println("\n6. Console class - For password input:");
        Console console = System.console();
        if (console != null) {
            // This will only work in real console, not in IDE
            char[] password = console.readPassword("   Enter password: ");
            System.out.println("   Password length: " + password.length);
        } else {
            System.out.println("   Console not available (running in IDE)");
        }
        
        System.out.println("\n   ✅ Console I/O demonstrated");
    }
    
    // =========================================================================
    // SECTION 2: FILE CREATION AND BASIC OPERATIONS
    // =========================================================================
    
    private static void demonstrateFileOperations() {
        System.out.println("\n📌 File Creation and Basic Operations");
        
        try {
            // Method 1: Create file using File class
            System.out.println("\n1. Creating file with File class:");
            File file1 = new File(BASE_DIR + "/test1.txt");
            if (file1.createNewFile()) {
                System.out.println("   ✅ File created: " + file1.getName());
            } else {
                System.out.println("   File already exists");
            }
            
            // Method 2: Create file using FileOutputStream
            System.out.println("\n2. Creating file with FileOutputStream:");
            File file2 = new File(BASE_DIR + "/test2.txt");
            FileOutputStream fos = new FileOutputStream(file2);
            fos.close(); // Just creates empty file
            System.out.println("   ✅ File created: " + file2.getName());
            
            // Method 3: Check if file exists
            System.out.println("\n3. Checking if file exists:");
            System.out.println("   test1.txt exists? " + file1.exists());
            System.out.println("   nonexistent.txt exists? " + new File("nonexistent.txt").exists());
            
            // Method 4: Rename file
            System.out.println("\n4. Renaming file:");
            File renamedFile = new File(BASE_DIR + "/renamed.txt");
            if (file1.renameTo(renamedFile)) {
                System.out.println("   ✅ Renamed to: " + renamedFile.getName());
            } else {
                System.out.println("   ❌ Rename failed");
            }
            
            // Method 5: Delete file
            System.out.println("\n5. Deleting file:");
            if (file2.delete()) {
                System.out.println("   ✅ Deleted: " + file2.getName());
            }
            
            // Method 6: Create temporary file
            System.out.println("\n6. Creating temporary file:");
            File tempFile = File.createTempFile("temp", ".tmp", new File(BASE_DIR));
            System.out.println("   ✅ Temp file created: " + tempFile.getName());
            tempFile.deleteOnExit(); // Deletes when JVM exits
            System.out.println("   (Will be deleted when program exits)");
            
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ File operations demonstrated");
    }
    
    // =========================================================================
    // SECTION 3: READING FILES
    // =========================================================================
    
    private static void demonstrateFileReading() {
        System.out.println("\n📌 Reading Files - Different Methods");
        
        // First, create a sample file to read
        String sampleContent = "Line 1: Hello World\nLine 2: Java I/O is fun\nLine 3: Learning by doing!";
        String filePath = BASE_DIR + "/sample_read.txt";
        
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(sampleContent);
            System.out.println("\n   Created sample file with content:");
            System.out.println("   " + sampleContent.replace("\n", "\n   "));
        } catch (IOException e) {
            System.out.println("   Error creating sample: " + e.getMessage());
        }
        
        // Method 1: FileReader + BufferedReader (efficient)
        System.out.println("\n1. FileReader + BufferedReader (line by line):");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("   Line " + lineNum++ + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 2: FileReader (character by character)
        System.out.println("\n2. FileReader (character by character):");
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            System.out.print("   Content: ");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 3: Scanner
        System.out.println("\n3. Scanner (with delimiter):");
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                System.out.println("   Scanner read: " + scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 4: Read all bytes at once
        System.out.println("\n4. Read all bytes (Files.readAllBytes):");
        try {
            byte[] allBytes = Files.readAllBytes(Paths.get(filePath));
            System.out.println("   Content as bytes: " + Arrays.toString(allBytes));
            System.out.println("   Converted to string: " + new String(allBytes));
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 5: Read all lines at once
        System.out.println("\n5. Read all lines (Files.readAllLines):");
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            System.out.println("   All lines: " + allLines);
            System.out.println("   Number of lines: " + allLines.size());
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 6: Using Files.lines() (Java 8+ streaming)
        System.out.println("\n6. Files.lines() with stream (Java 8+):");
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            System.out.println("   Lines count: " + lines.count());
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ File reading demonstrated");
    }
    
    // =========================================================================
    // SECTION 4: WRITING FILES
    // =========================================================================
    
    private static void demonstrateFileWriting() {
        System.out.println("\n📌 Writing Files - Different Methods");
        
        String filePath = BASE_DIR + "/sample_write.txt";
        
        // Method 1: FileWriter (overwrite mode)
        System.out.println("\n1. FileWriter - Overwrite mode:");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("This is line 1\n");
            writer.write("This is line 2\n");
            writer.write("This is line 3");
            System.out.println("   ✅ Written 3 lines (overwrite)");
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 2: FileWriter (append mode)
        System.out.println("\n2. FileWriter - Append mode:");
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("\nThis is appended line 4");
            System.out.println("   ✅ Appended line 4");
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Verify content
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\n   Current file content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("   " + line);
            }
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 3: BufferedWriter (more efficient)
        System.out.println("\n3. BufferedWriter - Efficient writing:");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BASE_DIR + "/buffered.txt"))) {
            writer.write("Buffered writing is more efficient");
            writer.newLine();
            writer.write("Especially for many small writes");
            writer.newLine();
            writer.write("It reduces disk I/O operations");
            System.out.println("   ✅ Written with BufferedWriter");
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 4: PrintWriter (convenient for formatted text)
        System.out.println("\n4. PrintWriter - Formatted writing:");
        try (PrintWriter writer = new PrintWriter(new FileWriter(BASE_DIR + "/print.txt"))) {
            writer.printf("Name: %s, Age: %d%n", "Alice", 30);
            writer.printf("Score: %.2f%n", 95.5);
            writer.println("Simple text line");
            System.out.println("   ✅ Written with PrintWriter");
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 5: Files.write() - Convenience method
        System.out.println("\n5. Files.write() - NIO convenience method:");
        try {
            List<String> lines = Arrays.asList(
                "Line A from Files.write",
                "Line B from Files.write",
                "Line C from Files.write"
            );
            Files.write(Paths.get(BASE_DIR + "/nio_write.txt"), lines);
            System.out.println("   ✅ Written with Files.write()");
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 6: Write bytes
        System.out.println("\n6. Writing bytes:");
        try (FileOutputStream fos = new FileOutputStream(BASE_DIR + "/bytes.dat")) {
            byte[] data = {65, 66, 67, 68, 69}; // A, B, C, D, E
            fos.write(data);
            System.out.println("   ✅ Written bytes: " + Arrays.toString(data));
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ File writing demonstrated");
    }
    
    // =========================================================================
    // SECTION 5: BUFFERED STREAMS
    // =========================================================================
    
    private static void demonstrateBufferedStreams() {
        System.out.println("\n📌 Buffered Streams - Efficient I/O");
        
        System.out.println("\n   Why use buffered streams?");
        System.out.println("   - Without buffer: Each read/write hits the disk");
        System.out.println("   - With buffer: Reads/writes in chunks, much faster");
        
        // BufferedInputStream example
        System.out.println("\n1. BufferedInputStream - Efficient reading:");
        try {
            // First create a file with some data
            String data = "This is some sample data for buffered stream demonstration. ".repeat(10);
            Files.write(Paths.get(BASE_DIR + "/buffered_input.dat"), data.getBytes());
            
            // Read with buffered stream
            try (BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(BASE_DIR + "/buffered_input.dat"))) {
                
                byte[] buffer = new byte[100];
                int bytesRead;
                int totalBytes = 0;
                
                while ((bytesRead = bis.read(buffer)) != -1) {
                    totalBytes += bytesRead;
                }
                System.out.println("   ✅ Read " + totalBytes + " bytes using buffer");
            }
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // BufferedOutputStream example
        System.out.println("\n2. BufferedOutputStream - Efficient writing:");
        try (BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(BASE_DIR + "/buffered_output.dat"))) {
            
            byte[] data = "Buffered output is efficient! ".repeat(20).getBytes();
            bos.write(data);
            bos.flush(); // Force write to disk
            System.out.println("   ✅ Written " + data.length + " bytes with buffer");
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Performance comparison
        System.out.println("\n3. Performance comparison (conceptual):");
        System.out.println("   Unbuffered: Each byte = 1 disk operation");
        System.out.println("   Buffered: 8192 bytes = 1 disk operation");
        System.out.println("   ⚡ Buffered streams can be 100x faster!");
        
        // flush() and close()
        System.out.println("\n4. flush() and close() - Important methods:");
        System.out.println("   flush(): Forces any buffered output to be written");
        System.out.println("   close(): Flushes and releases resources");
        
        System.out.println("\n   ✅ Buffered streams demonstrated");
    }
    
    // =========================================================================
    // SECTION 6: DATA STREAMS (PRIMITIVE TYPES)
    // =========================================================================
    
    private static void demonstrateDataStreams() {
        System.out.println("\n📌 Data Streams - Reading/Writing Primitive Types");
        
        String filePath = BASE_DIR + "/data.dat";
        
        // Writing primitive types
        System.out.println("\n   Writing primitive types:");
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream(filePath)))) {
            
            dos.writeInt(42);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Hello Data Stream");
            dos.writeLong(123456789L);
            dos.writeFloat(2.718f);
            dos.writeChar('A');
            
            System.out.println("   ✅ Written multiple primitive types");
            
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Reading primitive types (must read in same order!)
        System.out.println("\n   Reading primitive types (same order):");
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                    new FileInputStream(filePath)))) {
            
            int intVal = dis.readInt();
            double doubleVal = dis.readDouble();
            boolean boolVal = dis.readBoolean();
            String strVal = dis.readUTF();
            long longVal = dis.readLong();
            float floatVal = dis.readFloat();
            char charVal = dis.readChar();
            
            System.out.println("   int: " + intVal);
            System.out.println("   double: " + doubleVal);
            System.out.println("   boolean: " + boolVal);
            System.out.println("   String: " + strVal);
            System.out.println("   long: " + longVal);
            System.out.println("   float: " + floatVal);
            System.out.println("   char: " + charVal);
            
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ⚠️ Important: Must read in exactly the same order as written!");
        System.out.println("\n   ✅ Data streams demonstrated");
    }
    
    // =========================================================================
    // SECTION 7: OBJECT SERIALIZATION
    // =========================================================================
    
    /**
     * Serializable class for demonstration
     */
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private String name;
        private int age;
        private transient String password; // transient = don't serialize
        private static String species = "Human"; // static = not serialized
        
        public Person(String name, int age, String password) {
            this.name = name;
            this.age = age;
            this.password = password;
        }
        
        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d, password='%s', species='%s'}",
                               name, age, password, species);
        }
    }
    
    private static void demonstrateObjectSerialization() {
        System.out.println("\n📌 Object Serialization - Saving Objects to File");
        
        String filePath = BASE_DIR + "/person.ser";
        
        // Create an object
        Person originalPerson = new Person("John Doe", 30, "secret123");
        System.out.println("\n   Original object: " + originalPerson);
        
        // Serialize (save object to file)
        System.out.println("\n1. Serialization - Writing object to file:");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            
            oos.writeObject(originalPerson);
            System.out.println("   ✅ Object serialized to: " + filePath);
            
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Deserialize (read object from file)
        System.out.println("\n2. Deserialization - Reading object from file:");
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {
            
            Person loadedPerson = (Person) ois.readObject();
            System.out.println("   ✅ Object deserialized: " + loadedPerson);
            
            // Notice: password is null (transient) and species is default (static)
            System.out.println("\n   Observations:");
            System.out.println("   - password is null (transient field not serialized)");
            System.out.println("   - species is 'Human' (static fields aren't serialized)");
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   📌 Key concepts:");
        System.out.println("   - Serializable interface: Marker interface");
        System.out.println("   - serialVersionUID: Version control");
        System.out.println("   - transient: Skip field during serialization");
        System.out.println("   - static fields: Not serialized");
        
        System.out.println("\n   ✅ Object serialization demonstrated");
    }
    
    // =========================================================================
    // SECTION 8: NIO (NEW I/O) BASICS
    // =========================================================================
    
    private static void demonstrateNIOBasics() {
        System.out.println("\n📌 NIO (New I/O) Basics - java.nio package");
        
        Path testPath = Paths.get(BASE_DIR, "nio_test.txt");
        
        // Method 1: Writing with NIO
        System.out.println("\n1. Files.write() - Simple writing:");
        try {
            List<String> lines = Arrays.asList(
                "NIO Line 1",
                "NIO Line 2",
                "NIO Line 3"
            );
            Files.write(testPath, lines, StandardCharsets.UTF_8);
            System.out.println("   ✅ Written to: " + testPath);
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 2: Reading with NIO
        System.out.println("\n2. Files.readAllLines() - Simple reading:");
        try {
            List<String> readLines = Files.readAllLines(testPath, StandardCharsets.UTF_8);
            System.out.println("   Content: " + readLines);
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 3: Files.lines() - Stream processing
        System.out.println("\n3. Files.lines() - Stream processing:");
        try (Stream<String> lines = Files.lines(testPath)) {
            System.out.println("   Line count: " + lines.count());
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 4: Path operations
        System.out.println("\n4. Path operations:");
        Path path = Paths.get(BASE_DIR, "subdir", "file.txt");
        System.out.println("   Path: " + path);
        System.out.println("   File name: " + path.getFileName());
        System.out.println("   Parent: " + path.getParent());
        System.out.println("   Root: " + path.getRoot());
        System.out.println("   Name count: " + path.getNameCount());
        System.out.println("   Is absolute: " + path.isAbsolute());
        
        // Method 5: Copy file
        System.out.println("\n5. Files.copy() - Copying files:");
        Path copyPath = Paths.get(BASE_DIR, "nio_copy.txt");
        try {
            Files.copy(testPath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("   ✅ Copied to: " + copyPath);
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 6: Move file
        System.out.println("\n6. Files.move() - Moving/Renaming files:");
        Path movedPath = Paths.get(BASE_DIR, "nio_moved.txt");
        try {
            Files.move(copyPath, movedPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("   ✅ Moved to: " + movedPath);
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ NIO basics demonstrated");
    }
    
    // =========================================================================
    // SECTION 9: DIRECTORY OPERATIONS
    // =========================================================================
    
    private static void demonstrateDirectoryOperations() {
        System.out.println("\n📌 Directory Operations");
        
        // Method 1: Create directory
        System.out.println("\n1. Creating directories:");
        File newDir = new File(BASE_DIR + "/test_dir");
        if (newDir.mkdir()) {
            System.out.println("   ✅ Directory created: " + newDir.getName());
        }
        
        // Method 2: Create nested directories
        System.out.println("\n2. Creating nested directories:");
        File nestedDir = new File(BASE_DIR + "/dir1/dir2/dir3");
        if (nestedDir.mkdirs()) {
            System.out.println("   ✅ Nested directories created: " + nestedDir.getPath());
        }
        
        // Method 3: List directory contents
        System.out.println("\n3. Listing directory contents:");
        File baseDir = new File(BASE_DIR);
        String[] contents = baseDir.list();
        if (contents != null) {
            System.out.println("   Contents of " + BASE_DIR + ":");
            for (String item : contents) {
                File f = new File(baseDir, item);
                System.out.println("   " + (f.isDirectory() ? "📁 " : "📄 ") + item);
            }
        }
        
        // Method 4: Filtered listing
        System.out.println("\n4. Filtered listing (only .txt files):");
        FilenameFilter txtFilter = (dir, name) -> name.endsWith(".txt");
        String[] txtFiles = baseDir.list(txtFilter);
        if (txtFiles != null) {
            for (String file : txtFiles) {
                System.out.println("   📄 " + file);
            }
        }
        
        // Method 5: Walk file tree (Java 8+)
        System.out.println("\n5. Walking file tree with Files.walk():");
        try (Stream<Path> walk = Files.walk(Paths.get(BASE_DIR))) {
            System.out.println("   All files and directories:");
            walk.forEach(p -> System.out.println("   " + p));
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // Method 6: Find files
        System.out.println("\n6. Finding files with Files.find():");
        try (Stream<Path> find = Files.find(Paths.get(BASE_DIR), 
                                            Integer.MAX_VALUE,
                                            (path, attrs) -> path.toString().endsWith(".txt"))) {
            System.out.println("   All .txt files:");
            find.forEach(p -> System.out.println("   " + p.getFileName()));
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ Directory operations demonstrated");
    }
    
    // =========================================================================
    // SECTION 10: FILE PROPERTIES AND METADATA
    // =========================================================================
    
    private static void demonstrateFileProperties() {
        System.out.println("\n📌 File Properties and Metadata");
        
        File testFile = new File(BASE_DIR + "/sample_read.txt");
        
        if (testFile.exists()) {
            System.out.println("\n   Properties of: " + testFile.getName());
            
            // Basic properties
            System.out.println("   ✅ Exists: " + testFile.exists());
            System.out.println("   ✅ Is file: " + testFile.isFile());
            System.out.println("   ✅ Is directory: " + testFile.isDirectory());
            System.out.println("   ✅ Can read: " + testFile.canRead());
            System.out.println("   ✅ Can write: " + testFile.canWrite());
            System.out.println("   ✅ Can execute: " + testFile.canExecute());
            System.out.println("   ✅ Is hidden: " + testFile.isHidden());
            
            // Size and timestamps
            System.out.println("   ✅ Size: " + testFile.length() + " bytes");
            System.out.println("   ✅ Last modified: " + new Date(testFile.lastModified()));
            
            // Path information
            System.out.println("   ✅ Absolute path: " + testFile.getAbsolutePath());
            System.out.println("   ✅ Parent: " + testFile.getParent());
            System.out.println("   ✅ Name: " + testFile.getName());
            
        } else {
            System.out.println("   File not found");
        }
        
        // NIO Attributes (more detailed)
        System.out.println("\n   NIO BasicFileAttributes:");
        try {
            Path path = Paths.get(BASE_DIR + "/sample_read.txt");
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            
            System.out.println("   ✅ Size: " + attrs.size() + " bytes");
            System.out.println("   ✅ Creation time: " + attrs.creationTime());
            System.out.println("   ✅ Last access time: " + attrs.lastAccessTime());
            System.out.println("   ✅ Last modified time: " + attrs.lastModifiedTime());
            System.out.println("   ✅ Is directory: " + attrs.isDirectory());
            System.out.println("   ✅ Is regular file: " + attrs.isRegularFile());
            System.out.println("   ✅ Is symbolic link: " + attrs.isSymbolicLink());
            
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ File properties demonstrated");
    }
}

/**
 * 📚 BEGINNER'S GUIDE TO JAVA I/O
 * ================================
 * 
 * 1. STREAMS TYPES:
 *    - Byte Streams: InputStream, OutputStream (for binary data)
 *    - Character Streams: Reader, Writer (for text data)
 *    - Buffered Streams: BufferedReader, BufferedWriter (efficient)
 *    - Data Streams: DataInputStream, DataOutputStream (primitives)
 *    - Object Streams: ObjectInputStream, ObjectOutputStream (objects)
 * 
 * 2. KEY CLASSES:
 *    ┌────────────────┬─────────────────┬──────────────────┐
 *    │ Purpose        │ Byte Streams    │ Character Streams │
 *    ├────────────────┼─────────────────┼──────────────────┤
 *    │ Input          │ InputStream     │ Reader           │
 *    │ Output         │ OutputStream    │ Writer           │
 *    │ File Input     │ FileInputStream │ FileReader       │
 *    │ File Output    │ FileOutputStream│ FileWriter       │
 *    │ Buffered Input │ BufferedInput-  │ BufferedReader   │
 *    │                │ Stream          │                  │
 *    │ Buffered Output│ BufferedOutput- │ BufferedWriter   │
 *    │                │ Stream          │                  │
 *    └────────────────┴─────────────────┴──────────────────┘
 * 
 * 3. IMPORTANT METHODS:
 *    - read(): Read single byte/character
 *    - read(byte[]): Read into buffer
 *    - write(int): Write single byte/character
 *    - write(byte[]): Write buffer
 *    - close(): Release resources
 *    - flush(): Force write of buffered data
 * 
 * 4. BEST PRACTICES:
 *    ✅ Always close streams (use try-with-resources)
 *    ✅ Use buffered streams for better performance
 *    ✅ Handle IOException properly
 *    ✅ Specify character encoding (UTF-8 recommended)
 *    ✅ Use NIO for modern applications
 * 
 * 5. COMMON USE CASES:
 *    - Reading configuration files
 *    - Writing log files
 *    - Data persistence
 *    - File upload/download
 *    - Object serialization
 * 
 * 6. EXCEPTIONS TO HANDLE:
 *    - IOException (parent of most I/O exceptions)
 *    - FileNotFoundException
 *    - EOFException
 *    - ClassNotFoundException (for object deserialization)
 */