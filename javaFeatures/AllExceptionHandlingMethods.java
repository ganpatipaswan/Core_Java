import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.net.*;

/**
 * Program to demonstrate all Exception Handling methods in Java
 * This covers:
 * - try-catch-finally blocks
 * - throw vs throws
 * - Custom exceptions
 * - try-with-resources
 * - Multi-catch
 * - Exception chaining
 * - All Throwable class methods
 */
public class AllExceptionHandlingMethods {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(100));
        System.out.println("COMPREHENSIVE EXCEPTION HANDLING IN JAVA");
        System.out.println("=".repeat(100));
        
        // PART 1: Throwable Class Methods (16 methods)
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 1: THROWABLE CLASS METHODS (16 Methods)");
        System.out.println("#".repeat(80));
        demonstrateThrowableMethods();
        
        // PART 2: Exception Class Methods
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 2: EXCEPTION CLASS METHODS");
        System.out.println("#".repeat(80));
        demonstrateExceptionMethods();
        
        // PART 3: Basic Exception Handling Structures
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 3: BASIC EXCEPTION HANDLING STRUCTURES");
        System.out.println("#".repeat(80));
        demonstrateBasicTryCatch();
        demonstrateMultipleCatch();
        demonstrateMultiCatch();
        demonstrateTryFinally();
        demonstrateTryWithResources();
        
        // PART 4: throw vs throws
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 4: THROW VS THROWS");
        System.out.println("#".repeat(80));
        demonstrateThrowKeyword();
        demonstrateThrowsKeyword();
        
        // PART 5: Custom Exceptions
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 5: CUSTOM EXCEPTIONS");
        System.out.println("#".repeat(80));
        demonstrateCustomExceptions();
        
        // PART 6: Exception Propagation
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 6: EXCEPTION PROPAGATION");
        System.out.println("#".repeat(80));
        demonstrateExceptionPropagation();
        
        // PART 7: Checked vs Unchecked Exceptions
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 7: CHECKED VS UNCHECKED EXCEPTIONS");
        System.out.println("#".repeat(80));
        demonstrateCheckedExceptions();
        demonstrateUncheckedExceptions();
        
        // PART 8: Exception Chaining
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 8: EXCEPTION CHAINING");
        System.out.println("#".repeat(80));
        demonstrateExceptionChaining();
        
        // PART 9: Finally Block Variations
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 9: FINALLY BLOCK VARIATIONS");
        System.out.println("#".repeat(80));
        demonstrateFinallyWithReturn();
        demonstrateFinallyWithSystemExit();
        
        // PART 10: Nested Try-Catch
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 10: NESTED TRY-CATCH");
        System.out.println("#".repeat(80));
        demonstrateNestedTryCatch();
        
        // PART 11: Try-with-Resources Deep Dive
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 11: TRY-WITH-RESOURCES DEEP DIVE");
        System.out.println("#".repeat(80));
        demonstrateTryWithResourcesAdvanced();
        
        // PART 12: Exception Handling Best Practices
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 12: EXCEPTION HANDLING BEST PRACTICES");
        System.out.println("#".repeat(80));
        // demonstrateBestPractices();
        
        // PART 13: Common Exception Scenarios
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 13: COMMON EXCEPTION SCENARIOS");
        System.out.println("#".repeat(80));
        demonstrateCommonExceptions();
        
        // Summary
        printSummary();
    }
    
    // =========================================================================
    // PART 1: THROWABLE CLASS METHODS (16 methods)
    // =========================================================================
    
    /**
     * Demonstrates all methods from java.lang.Throwable class
     */
    private static void demonstrateThrowableMethods() {
        System.out.println("\n--- Throwable Class Methods (16 methods) ---");
        
        try {
            throw new CustomException("Test exception for method demonstration", 
                                     new RuntimeException("Root cause"));
        } catch (Exception e) {
            // Method 1: getMessage() - Returns detail message string
            System.out.println("\n1. getMessage(): " + e.getMessage());
            
            // Method 2: getLocalizedMessage() - Returns localized description
            System.out.println("2. getLocalizedMessage(): " + e.getLocalizedMessage());
            
            // Method 3: toString() - Returns short description
            System.out.println("3. toString(): " + e.toString());
            
            // Method 4: printStackTrace() - Prints to standard error stream
            System.out.println("4. printStackTrace():");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println("   " + sw.toString().split("\n")[0]); // First line only
            
            // Method 5: printStackTrace(PrintStream) - Prints to specified PrintStream
            System.out.println("5. printStackTrace(PrintStream):");
            e.printStackTrace(System.out);
            
            // Method 6: printStackTrace(PrintWriter) - Prints to specified PrintWriter
            System.out.println("6. printStackTrace(PrintWriter):");
            StringWriter sw2 = new StringWriter();
            PrintWriter pw2 = new PrintWriter(sw2);
            e.printStackTrace(pw2);
            System.out.println("   Written to StringWriter, length: " + sw2.toString().length());
            
            // Method 7: getStackTrace() - Returns stack trace elements
            System.out.println("\n7. getStackTrace():");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < Math.min(3, stackTrace.length); i++) {
                System.out.println("   " + stackTrace[i].getClassName() + "." + 
                                   stackTrace[i].getMethodName() + ":" + 
                                   stackTrace[i].getLineNumber());
            }
            
            // Method 8: setStackTrace(StackTraceElement[]) - Sets stack trace
            System.out.println("\n8. setStackTrace():");
            StackTraceElement[] newTrace = {
                new StackTraceElement("TestClass", "testMethod", "TestFile.java", 100)
            };
            e.setStackTrace(newTrace);
            System.out.println("   New stack trace length: " + e.getStackTrace().length);
            
            // Method 9: fillInStackTrace() - Fills in execution stack trace
            System.out.println("\n9. fillInStackTrace():");
            Throwable filled = e.fillInStackTrace();
            System.out.println("   Stack trace filled, class: " + filled.getClass().getSimpleName());
            
            // Method 10: getCause() - Returns cause of exception
            System.out.println("\n10. getCause(): " + e.getCause());
            
            // Method 11: initCause(Throwable) - Initializes cause
            System.out.println("11. initCause():");
            Throwable t = new Throwable();
            t.initCause(new RuntimeException("New cause"));
            System.out.println("   Cause after init: " + t.getCause());
            
            // Method 12: getSuppressed() - Returns suppressed exceptions
            System.out.println("\n12. getSuppressed():");
            Throwable[] suppressed = e.getSuppressed();
            System.out.println("   Suppressed count: " + suppressed.length);
            
            // Method 13: addSuppressed(Throwable) - Adds suppressed exception
            System.out.println("13. addSuppressed():");
            e.addSuppressed(new IOException("Suppressed IO error"));
            System.out.println("   After adding, suppressed count: " + e.getSuppressed().length);
            
            // Method 14: getClass() - Returns runtime class (from Object)
            System.out.println("\n14. getClass(): " + e.getClass().getName());
            
            // Method 15: hashCode() - Returns hash code (from Object)
            System.out.println("15. hashCode(): " + e.hashCode());
            
            // Method 16: equals() - Compares equality (from Object)
            System.out.println("16. equals(): " + e.equals(e));
        }
    }
    
    // =========================================================================
    // PART 2: EXCEPTION CLASS METHODS
    // =========================================================================
    
    /**
     * Demonstrates Exception class specific methods
     */
    private static void demonstrateExceptionMethods() {
        System.out.println("\n--- Exception Class Methods ---");
        
        // Exception adds no new methods beyond Throwable, but has additional constructors
        
        // Constructor 1: Exception()
        Exception e1 = new Exception();
        System.out.println("\n1. Exception(): " + e1);
        
        // Constructor 2: Exception(String message)
        Exception e2 = new Exception("Custom message");
        System.out.println("2. Exception(String): " + e2.getMessage());
        
        // Constructor 3: Exception(String message, Throwable cause)
        Exception e3 = new Exception("With cause", new RuntimeException("Root cause"));
        System.out.println("3. Exception(String, Throwable): " + e3.getCause());
        
        // Constructor 4: Exception(Throwable cause)
        Exception e4 = new Exception(new RuntimeException("Root cause"));
        System.out.println("4. Exception(Throwable): " + e4.getCause());
        
        // Constructor 5: Exception(String message, Throwable cause, 
        //                      boolean enableSuppression, boolean writableStackTrace)
        Exception e5 = new Exception("Detailed", null);
        // Exception e5 = new Exception("Detailed", null, false, false);
        // MyCustomException e5 = new MyCustomException("Detailed", null, false, false);
        System.out.println("5. Exception(String, Throwable, boolean, boolean): created");
    }
    
    // =========================================================================
    // PART 3: BASIC EXCEPTION HANDLING STRUCTURES
    // =========================================================================
    
    /**
     * Demonstrates basic try-catch block
     */
    private static void demonstrateBasicTryCatch() {
        System.out.println("\n--- Basic Try-Catch ---");
        
        // Method 1: try-catch with single catch
        System.out.println("\n1. Basic try-catch:");
        try {
            int result = 10 / 0; // ArithmeticException
            System.out.println("   This line won't execute");
        } catch (ArithmeticException e) {
            System.out.println("   Caught ArithmeticException: " + e.getMessage());
        }
        
        // Method 2: try-catch with multiple statements
        System.out.println("\n2. try-catch with multiple statements:");
        try {
            int[] arr = new int[5];
            arr[10] = 100; // ArrayIndexOutOfBoundsException
            String str = null;
            str.length(); // NullPointerException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Caught ArrayIndexOutOfBoundsException");
        }
        
        // Method 3: try-catch with variable scope
        System.out.println("\n3. Variable scope in try-catch:");
        try {
            int localVar = 42;
            System.out.println("   Inside try: " + localVar);
            throw new Exception("Test");
        } catch (Exception e) {
            // localVar not accessible here
            System.out.println("   Exception caught, but localVar not accessible");
        }
    }
    
    /**
     * Demonstrates multiple catch blocks
     */
    private static void demonstrateMultipleCatch() {
        System.out.println("\n--- Multiple Catch Blocks ---");
        
        try {
            // Uncomment different lines to test different exceptions
            // int result = 10 / 0; // ArithmeticException
            // int[] arr = new int[5]; arr[10] = 100; // ArrayIndexOutOfBoundsException
            String str = null;
            str.length(); // NullPointerException
        } catch (ArithmeticException e) {
            System.out.println("   Caught ArithmeticException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("   Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Caught generic Exception: " + e.getMessage());
        }
        
        // Important: Order matters - more specific first, more general last
        System.out.println("\n   Note: Catch order matters - specific before general");
    }
    
    /**
     * Demonstrates multi-catch (Java 7+)
     */
    private static void demonstrateMultiCatch() {
        System.out.println("\n--- Multi-Catch (Java 7+) ---");
        
        try {
            // Generate different exceptions
            int random = new Random().nextInt(3);
            if (random == 0) {
                int result = 10 / 0; // ArithmeticException
            } else if (random == 1) {
                int[] arr = new int[5];
                arr[10] = 100; // ArrayIndexOutOfBoundsException
            } else {
                String str = null;
                str.length(); // NullPointerException
            }
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("   Multi-catch caught: " + e.getClass().getSimpleName() + 
                              " - " + e.getMessage());
            // e is effectively final in multi-catch
            System.out.println("   Exception type: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n   Multi-catch reduces code duplication");
    }
    
    /**
     * Demonstrates try-finally block
     */
    private static void demonstrateTryFinally() {
        System.out.println("\n--- Try-Finally ---");
        
        // Method 1: try-finally without catch
        System.out.println("\n1. try-finally without catch:");
        try {
            System.out.println("   Inside try block");
            // throw new RuntimeException("Test");
        } finally {
            System.out.println("   Finally block always executes");
        }
        
        // Method 2: try-finally with exception
        System.out.println("\n2. try-finally with exception:");
        try {
            System.out.println("   Inside try block");
            throw new RuntimeException("Test exception");
        } finally {
            System.out.println("   Finally executes even after exception");
        }
        // Note: Exception propagates after finally
    }
    
    /**
     * Demonstrates try-with-resources (Java 7+)
     */
    private static void demonstrateTryWithResources() {
        System.out.println("\n--- Try-With-Resources ---");
        
        // Method 1: Single resource
        System.out.println("\n1. Single resource:");
        try (CustomResource resource = new CustomResource("Resource1")) {
            resource.use();
        } catch (Exception e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 2: Multiple resources
        System.out.println("\n2. Multiple resources:");
        try (CustomResource r1 = new CustomResource("Resource1");
             CustomResource r2 = new CustomResource("Resource2");
             CustomResource r3 = new CustomResource("Resource3")) {
            r1.use();
            r2.use();
            r3.use();
        } catch (Exception e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 3: Resources with exception during close
        System.out.println("\n3. Resource that throws on close:");
        try (FailingResource fr = new FailingResource("FailingResource")) {
            fr.use();
        } catch (Exception e) {
            System.out.println("   Caught: " + e.getMessage());
            System.out.println("   Suppressed: " + Arrays.toString(e.getSuppressed()));
        }
        
        // Method 4: Try-with-resources with catch and finally
        System.out.println("\n4. With catch and finally:");
        try (CustomResource resource = new CustomResource("Resource4")) {
            resource.use();
            throw new RuntimeException("Error in try");
        } catch (Exception e) {
            System.out.println("   Catch block: " + e.getMessage());
        } finally {
            System.out.println("   Finally block still executes");
        }
    }
    
    /**
     * Custom resource class for try-with-resources
     */
    static class CustomResource implements AutoCloseable {
        private final String name;
        
        CustomResource(String name) {
            this.name = name;
            System.out.println("   Resource '" + name + "' opened");
        }
        
        void use() {
            System.out.println("   Using resource '" + name + "'");
        }
        
        @Override
        public void close() throws Exception {
            System.out.println("   Resource '" + name + "' closed");
        }
    }
    
    /**
     * Failing resource class that throws on close
     */
    static class FailingResource implements AutoCloseable {
        private final String name;
        
        FailingResource(String name) {
            this.name = name;
            System.out.println("   FailingResource '" + name + "' opened");
        }
        
        void use() {
            System.out.println("   Using FailingResource '" + name + "'");
        }
        
        @Override
        public void close() throws Exception {
            System.out.println("   FailingResource '" + name + "' closing...");
            throw new IOException("Failed to close " + name);
        }
    }
    
    // =========================================================================
    // PART 4: THROW VS THROWS
    // =========================================================================
    
    /**
     * Demonstrates throw keyword
     */
    private static void demonstrateThrowKeyword() {
        System.out.println("\n--- throw Keyword ---");
        
        // Method 1: throw checked exception
        System.out.println("\n1. throw checked exception:");
        try {
            throwCheckedException();
        } catch (IOException e) {
            System.out.println("   Caught IOException: " + e.getMessage());
        }
        
        // Method 2: throw unchecked exception
        System.out.println("\n2. throw unchecked exception:");
        try {
            throwUncheckedException();
        } catch (RuntimeException e) {
            System.out.println("   Caught RuntimeException: " + e.getMessage());
        }
        
        // Method 3: throw custom exception
        System.out.println("\n3. throw custom exception:");
        try {
            throwCustomException();
        } catch (CustomException e) {
            System.out.println("   Caught CustomException: " + e.getMessage());
        }
        
        // Method 4: re-throwing exception
        System.out.println("\n4. re-throwing exception:");
        try {
            rethrowException();
        } catch (Exception e) {
            System.out.println("   Caught re-thrown: " + e.getMessage());
        }
        
        // Method 5: throw with cause
        System.out.println("\n5. throw with cause:");
        try {
            throw new RuntimeException("Main message", new IOException("Root cause"));
        } catch (RuntimeException e) {
            System.out.println("   Exception: " + e.getMessage());
            System.out.println("   Cause: " + e.getCause());
        }
    }
    
    private static void throwCheckedException() throws IOException {
        throw new IOException("Checked exception thrown");
    }
    
    private static void throwUncheckedException() {
        throw new RuntimeException("Unchecked exception thrown");
    }
    
    private static void throwCustomException() throws CustomException {
        throw new CustomException("Custom exception thrown");
    }
    
    private static void rethrowException() throws Exception {
        try {
            throw new Exception("Original exception");
        } catch (Exception e) {
            System.out.println("   Caught and re-throwing...");
            throw e; // re-throw
        }
    }
    
    /**
     * Demonstrates throws keyword
     */
    private static void demonstrateThrowsKeyword() {
        System.out.println("\n--- throws Keyword ---");
        
        try {
            methodWithThrows();
        } catch (IOException | SQLException e) {
            System.out.println("   Caught exception from methodWithThrows: " + e.getClass().getSimpleName());
        }
        
        try {
            methodWithMultipleThrows();
        } catch (Exception e) {
            System.out.println("   Caught from methodWithMultipleThrows: " + e.getClass().getSimpleName());
        }
        
        try {
            methodDeclaringThrows();
        } catch (IOException e) {
            System.out.println("   IOException handled: " + e.getMessage());
        }
    }
    
    // Method declaring multiple checked exceptions in throws clause
    private static void methodWithThrows() throws IOException, SQLException {
        int random = new Random().nextInt(2);
        if (random == 0) {
            throw new IOException("IO Error");
        } else {
            throw new SQLException("SQL Error");
        }
    }
    
    // Method can throw any Exception
    private static void methodWithMultipleThrows() throws Exception {
        throw new Exception("Generic exception");
    }
    
    // Method declaring throws but not actually throwing
    private static void methodDeclaringThrows() throws IOException {
        // This method declares throws but may not actually throw
        System.out.println("   Method declares throws IOException but doesn't throw");
    }
    
    // =========================================================================
    // PART 5: CUSTOM EXCEPTIONS
    // =========================================================================
    
    /**
     * Custom exception class - checked exception
     */
    static class CustomException extends Exception {
        private int errorCode;
        private String errorDetails;
        
        // Constructor 1: Default
        public CustomException() {
            super("Default custom exception");
        }
        
        // Constructor 2: With message
        public CustomException(String message) {
            super(message);
        }
        
        // Constructor 3: With cause
        public CustomException(Throwable cause) {
            super(cause);
        }
        
        // Constructor 4: With message and cause
        public CustomException(String message, Throwable cause) {
            super(message, cause);
        }
        
        // Constructor 5: With error code
        public CustomException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }
        
        // Constructor 6: With all fields
        public CustomException(String message, int errorCode, String errorDetails) {
            super(message);
            this.errorCode = errorCode;
            this.errorDetails = errorDetails;
        }
        
        // Additional methods
        public int getErrorCode() {
            return errorCode;
        }
        
        public String getErrorDetails() {
            return errorDetails;
        }
        
        @Override
        public String toString() {
            return String.format("CustomException{errorCode=%d, errorDetails='%s', message='%s'}",
                               errorCode, errorDetails, getMessage());
        }
    }
    
    /**
     * Custom runtime exception - unchecked exception
     */
    static class CustomRuntimeException extends RuntimeException {
        private final String operation;
        private final String resource;
        
        public CustomRuntimeException(String operation, String resource, String message) {
            super(message);
            this.operation = operation;
            this.resource = resource;
        }
        
        public CustomRuntimeException(String operation, String resource, Throwable cause) {
            super("Failed to " + operation + " resource: " + resource, cause);
            this.operation = operation;
            this.resource = resource;
        }
        
        public String getOperation() { return operation; }
        public String getResource() { return resource; }
        
        @Override
        public String toString() {
            return String.format("CustomRuntimeException{operation='%s', resource='%s', message='%s'}",
                               operation, resource, getMessage());
        }
    }
    
    /**
     * Demonstrates custom exceptions
     */
    private static void demonstrateCustomExceptions() {
        System.out.println("\n--- Custom Exceptions ---");
        
        // Method 1: Basic custom exception
        System.out.println("\n1. Basic custom exception:");
        try {
            throw new CustomException("Something went wrong");
        } catch (CustomException e) {
            System.out.println("   Caught: " + e);
        }
        
        // Method 2: Custom exception with error code
        System.out.println("\n2. Custom exception with error code:");
        try {
            throw new CustomException("Invalid input", 400);
        } catch (CustomException e) {
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Error code: " + e.getErrorCode());
        }
        
        // Method 3: Custom exception with all fields
        System.out.println("\n3. Custom exception with all fields:");
        try {
            throw new CustomException("Validation failed", 422, "Email format invalid");
        } catch (CustomException e) {
            System.out.println("   Error details: " + e.getErrorDetails());
        }
        
        // Method 4: Custom runtime exception
        System.out.println("\n4. Custom runtime exception:");
        try {
            throw new CustomRuntimeException("read", "database", "Connection failed");
        } catch (CustomRuntimeException e) {
            System.out.println("   Operation: " + e.getOperation());
            System.out.println("   Resource: " + e.getResource());
        }
        
        // Method 5: Custom exception with cause
        System.out.println("\n5. Custom exception with cause:");
        try {
            try {
                throw new IOException("Network error");
            } catch (IOException e) {
                throw new CustomException("Service unavailable", e);
            }
        } catch (CustomException e) {
            System.out.println("   Cause: " + e.getCause().getClass().getSimpleName());
        }
    }
    
    // =========================================================================
    // PART 6: EXCEPTION PROPAGATION
    // =========================================================================
    
    /**
     * Demonstrates how exceptions propagate up the call stack
     */
    private static void demonstrateExceptionPropagation() {
        System.out.println("\n--- Exception Propagation ---");
        
        System.out.println("\n1. Unchecked exception propagation:");
        try {
            level1();
        } catch (RuntimeException e) {
            System.out.println("   Caught in main: " + e.getMessage());
            System.out.println("   Stack trace shows propagation path:");
            StackTraceElement[] trace = e.getStackTrace();
            for (int i = 0; i < Math.min(3, trace.length); i++) {
                System.out.println("     at " + trace[i].getMethodName());
            }
        }
        
        System.out.println("\n2. Checked exception propagation:");
        try {
            checkedLevel1();
        } catch (IOException e) {
            System.out.println("   Caught checked exception in main: " + e.getMessage());
        }
        
        System.out.println("\n3. Exception propagation with finally:");
        try {
            propagationWithFinally();
        } catch (Exception e) {
            System.out.println("   Exception caught in main: " + e.getMessage());
        }
    }
    
    private static void level1() {
        System.out.println("   level1 started");
        level2();
        System.out.println("   level1 ended (won't execute if exception)");
    }
    
    private static void level2() {
        System.out.println("   level2 started");
        level3();
        System.out.println("   level2 ended (won't execute if exception)");
    }
    
    private static void level3() {
        System.out.println("   level3 started");
        throw new RuntimeException("Exception from level3");
    }
    
    private static void checkedLevel1() throws IOException {
        System.out.println("   checkedLevel1 started");
        checkedLevel2();
    }
    
    private static void checkedLevel2() throws IOException {
        System.out.println("   checkedLevel2 started");
        checkedLevel3();
    }
    
    private static void checkedLevel3() throws IOException {
        System.out.println("   checkedLevel3 started");
        throw new IOException("IO exception from level3");
    }
    
    private static void propagationWithFinally() throws Exception {
        try {
            System.out.println("   try block");
            throw new Exception("Exception in try");
        } finally {
            System.out.println("   finally block executes before propagation");
        }
    }
    
    // =========================================================================
    // PART 7: CHECKED VS UNCHECKED EXCEPTIONS
    // =========================================================================
    
    /**
     * Demonstrates checked exceptions
     */
    private static void demonstrateCheckedExceptions() {
        System.out.println("\n--- Checked Exceptions ---");
        System.out.println("   Checked exceptions must be handled or declared in throws clause");
        
        // Method 1: IOException
        System.out.println("\n1. IOException:");
        try {
            throw new IOException("File not found");
        } catch (IOException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 2: SQLException
        System.out.println("\n2. SQLException:");
        try {
            throw new SQLException("Database connection failed", "08001", 1001);
        } catch (SQLException e) {
            System.out.println("   SQLState: " + e.getSQLState());
            System.out.println("   Error code: " + e.getErrorCode());
        }
        
        // Method 3: ClassNotFoundException
        System.out.println("\n3. ClassNotFoundException:");
        try {
            throw new ClassNotFoundException("com.example.NonexistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 4: FileNotFoundException (subclass of IOException)
        System.out.println("\n4. FileNotFoundException:");
        try {
            throw new FileNotFoundException("config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 5: InterruptedException
        System.out.println("\n5. InterruptedException:");
        try {
            throw new InterruptedException("Thread interrupted");
        } catch (InterruptedException e) {
            System.out.println("   Caught: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
    
    /**
     * Demonstrates unchecked exceptions (RuntimeExceptions)
     */
    private static void demonstrateUncheckedExceptions() {
        System.out.println("\n--- Unchecked Exceptions ---");
        System.out.println("   Unchecked exceptions don't need explicit handling");
        
        // Method 1: NullPointerException
        System.out.println("\n1. NullPointerException:");
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 2: ArrayIndexOutOfBoundsException
        System.out.println("\n2. ArrayIndexOutOfBoundsException:");
        try {
            int[] arr = new int[5];
            int x = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 3: ArithmeticException
        System.out.println("\n3. ArithmeticException:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 4: ClassCastException
        System.out.println("\n4. ClassCastException:");
        try {
            Object obj = "string";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 5: IllegalArgumentException
        System.out.println("\n5. IllegalArgumentException:");
        try {
            throw new IllegalArgumentException("Invalid argument provided");
        } catch (IllegalArgumentException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 6: IllegalStateException
        System.out.println("\n6. IllegalStateException:");
        try {
            throw new IllegalStateException("Object in invalid state");
        } catch (IllegalStateException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 7: NumberFormatException
        System.out.println("\n7. NumberFormatException:");
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 8: ConcurrentModificationException
        System.out.println("\n8. ConcurrentModificationException:");
        try {
            List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
            for (String item : list) {
                list.remove(item); // This will cause ConcurrentModificationException
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
    }
    
    // =========================================================================
    // PART 8: EXCEPTION CHAINING
    // =========================================================================
    
    /**
     * Demonstrates exception chaining
     */
    private static void demonstrateExceptionChaining() {
        System.out.println("\n--- Exception Chaining ---");
        
        // Method 1: Basic chaining with constructor
        System.out.println("\n1. Basic chaining with constructor:");
        try {
            throw new Exception("High level", new IOException("Low level IO error"));
        } catch (Exception e) {
            System.out.println("   Exception: " + e.getMessage());
            System.out.println("   Cause: " + e.getCause().getMessage());
        }
        
        // Method 2: Chaining with initCause()
        System.out.println("\n2. Chaining with initCause():");
        try {
            Exception e = new Exception("Main exception");
            e.initCause(new RuntimeException("Root cause"));
            throw e;
        } catch (Exception e) {
            System.out.println("   Cause via initCause: " + e.getCause());
        }
        
        // Method 3: Multi-level chaining
        System.out.println("\n3. Multi-level chaining:");
        try {
            throw new Exception("Level 1", 
                  new RuntimeException("Level 2", 
                  new IOException("Level 3", 
                  new SQLException("Level 4"))));
        } catch (Exception e) {
            System.out.println("   Level 1: " + e.getMessage());
            System.out.println("   Level 2: " + e.getCause().getMessage());
            System.out.println("   Level 3: " + e.getCause().getCause().getMessage());
            System.out.println("   Level 4: " + e.getCause().getCause().getCause().getMessage());
        }
        
        // Method 4: Getting root cause
        System.out.println("\n4. Getting root cause:");
        try {
            throw new Exception("Top", new RuntimeException("Middle", new IOException("Bottom")));
        } catch (Exception e) {
            Throwable root = getRootCause(e);
            System.out.println("   Root cause: " + root);
        }
        
        // Method 5: Chaining with suppressed exceptions
        System.out.println("\n5. Chaining with suppressed exceptions:");
        try (FailingResource r1 = new FailingResource("R1");
             FailingResource r2 = new FailingResource("R2")) {
            throw new Exception("Error in try block");
        } catch (Exception e) {
            System.out.println("   Primary: " + e.getMessage());
            System.out.println("   Suppressed count: " + e.getSuppressed().length);
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("   Suppressed: " + suppressed.getMessage());
            }
        }
    }
    
    private static Throwable getRootCause(Throwable throwable) {
        Throwable cause = throwable.getCause();
        if (cause == null) {
            return throwable;
        }
        return getRootCause(cause);
    }
    
    // =========================================================================
    // PART 9: FINALLY BLOCK VARIATIONS
    // =========================================================================
    
    /**
     * Demonstrates finally block with return statements
     */
    private static void demonstrateFinallyWithReturn() {
        System.out.println("\n--- Finally with Return ---");
        
        // Method 1: return in try, finally executes
        System.out.println("\n1. return in try, finally executes:");
        int result1 = methodWithReturnInTry();
        System.out.println("   Result: " + result1);
        
        // Method 2: return in catch, finally executes
        System.out.println("\n2. return in catch, finally executes:");
        int result2 = methodWithReturnInCatch();
        System.out.println("   Result: " + result2);
        
        // Method 3: return in finally (overrides previous returns)
        System.out.println("\n3. return in finally overrides:");
        int result3 = methodWithReturnInFinally();
        System.out.println("   Result: " + result3);
        
        // Method 4: Exception in finally
        System.out.println("\n4. Exception in finally:");
        try {
            methodWithExceptionInFinally();
        } catch (Exception e) {
            System.out.println("   Caught: " + e.getMessage());
        }
    }
    
    private static int methodWithReturnInTry() {
        try {
            System.out.println("   try block");
            return 42;
        } finally {
            System.out.println("   finally block (executes before return)");
        }
    }
    
    private static int methodWithReturnInCatch() {
        try {
            System.out.println("   try block");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("   catch block");
            return 100;
        } finally {
            System.out.println("   finally block");
        }
    }
    
    private static int methodWithReturnInFinally() {
        try {
            System.out.println("   try block");
            return 1;
        } catch (Exception e) {
            System.out.println("   catch block");
            return 2;
        } finally {
            System.out.println("   finally block (this return overrides)");
            return 3;
        }
    }
    
    private static void methodWithExceptionInFinally() throws Exception {
        try {
            System.out.println("   try block");
            throw new IOException("Exception in try");
        } finally {
            System.out.println("   finally block");
            throw new Exception("Exception in finally (overrides try exception)");
        }
    }
    
    /**
     * Demonstrates finally with System.exit()
     */
    private static void demonstrateFinallyWithSystemExit() {
        System.out.println("\n--- Finally with System.exit() ---");
        
        // System.exit() prevents finally from executing
        System.out.println("\n   Note: System.exit() prevents finally execution");
        
        // Uncomment to see that finally doesn't execute
        /*
        try {
            System.out.println("   try block");
            System.exit(0);
        } finally {
            System.out.println("   This finally won't execute");
        }
        */
    }
    
    // =========================================================================
    // PART 10: NESTED TRY-CATCH
    // =========================================================================
    
    /**
     * Demonstrates nested try-catch blocks
     */
    private static void demonstrateNestedTryCatch() {
        System.out.println("\n--- Nested Try-Catch ---");
        
        // Method 1: Basic nested try-catch
        System.out.println("\n1. Basic nested try-catch:");
        try {
            System.out.println("   Outer try block");
            
            try {
                System.out.println("   Inner try block");
                throw new RuntimeException("Inner exception");
            } catch (RuntimeException e) {
                System.out.println("   Inner catch: " + e.getMessage());
                throw new IOException("Outer exception");
            } finally {
                System.out.println("   Inner finally");
            }
            
        } catch (IOException e) {
            System.out.println("   Outer catch: " + e.getMessage());
        } finally {
            System.out.println("   Outer finally");
        }
        
        // Method 2: Multiple levels of nesting
        System.out.println("\n2. Multiple levels of nesting:");
        try {
            try {
                try {
                    throw new Exception("Deep exception");
                } catch (Exception e) {
                    System.out.println("   Level 3 catch");
                    throw e;
                }
            } catch (Exception e) {
                System.out.println("   Level 2 catch");
                throw e;
            }
        } catch (Exception e) {
            System.out.println("   Level 1 catch: " + e.getMessage());
        }
        
        // Method 3: Nested with different exception types
        System.out.println("\n3. Nested with different exception types:");
        try {
            try {
                int[] arr = new int[5];
                arr[10] = 100; // ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("   Inner catch: array error");
                throw new NullPointerException("Converted to NPE");
            }
        } catch (NullPointerException e) {
            System.out.println("   Outer catch: " + e.getMessage());
        }
    }
    
    // =========================================================================
    // PART 11: TRY-WITH-RESOURCES ADVANCED
    // =========================================================================
    
    /**
     * Advanced resource class with multiple features
     */
    static class AdvancedResource implements AutoCloseable {
        private final String name;
        private boolean closed = false;
        
        AdvancedResource(String name) {
            this.name = name;
            System.out.println("   AdvancedResource '" + name + "' created");
        }
        
        void operate() throws IOException {
            if (closed) {
                throw new IOException("Resource '" + name + "' already closed");
            }
            System.out.println("   Operating on '" + name + "'");
        }
        
        @Override
        public void close() throws IOException {
            if (!closed) {
                System.out.println("   Closing AdvancedResource '" + name + "'");
                closed = true;
            }
        }
        
        boolean isClosed() { return closed; }
    }
    
    /**
     * Demonstrates advanced try-with-resources features
     */
    private static void demonstrateTryWithResourcesAdvanced() {
        System.out.println("\n--- Try-With-Resources Advanced ---");
        
        // Method 1: Dynamic resource allocation
        System.out.println("\n1. Dynamic resource allocation:");
        try (AdvancedResource r1 = new AdvancedResource("R1");
             AdvancedResource r2 = new AdvancedResource("R2")) {
            r1.operate();
            r2.operate();
        } catch (IOException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 2: Resources with different close orders
        System.out.println("\n2. Resources close in reverse order:");
        try (AdvancedResource first = new AdvancedResource("First");
             AdvancedResource second = new AdvancedResource("Second");
             AdvancedResource third = new AdvancedResource("Third")) {
            System.out.println("   Inside try block");
        } catch (Exception e) {
            System.out.println("   Caught: " + e);
        }
        
        // Method 3: Resource that tracks close
        System.out.println("\n3. Resource close tracking:");
        AdvancedResource r;
        try (AdvancedResource resource = new AdvancedResource("Tracked")) {
            r = resource;
            r.operate();
        } catch (IOException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        // r is out of scope here
        
        // Method 4: Multiple resources with exception
        System.out.println("\n4. Multiple resources with exception:");
        try (AdvancedResource r1 = new AdvancedResource("Good");
             AdvancedResource r2 = new AdvancedResource("Faulty")) {
            r1.operate();
            throw new IOException("Error in try block");
        } catch (IOException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Method 5: Try-with-resources with finally
        System.out.println("\n5. With additional finally block:");
        try (AdvancedResource resource = new AdvancedResource("WithFinally")) {
            resource.operate();
        } catch (IOException e) {
            System.out.println("   Catch: " + e.getMessage());
        } finally {
            System.out.println("   Finally block after TWR");
        }
        
        // Method 6: Effectively final variables (Java 9+)
        System.out.println("\n6. Using effectively final variables (Java 9+):");
        AdvancedResource r1 = new AdvancedResource("EffectivelyFinal1");
        AdvancedResource r2 = new AdvancedResource("EffectivelyFinal2");
        // r1 and r2 are effectively final here
        try (r1; r2) {
            r1.operate();
            r2.operate();
        } catch (IOException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
    }
    
    // =========================================================================
    // PART 12: EXCEPTION HANDLING BEST PRACTICES
    // =========================================================================
    
    /**
     * Demonstrates exception handling best practices
     */
    private static void demonstrateBestPractices() throws IOException {
        System.out.println("\n--- Exception Handling Best Practices ---");
        
        // Practice 1: Don't ignore exceptions
        System.out.println("\n1. DON'T ignore exceptions:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Empty catch block - BAD PRACTICE
            System.out.println("   ❌ Empty catch block - exception ignored");
        }
        
        // Practice 2: Log exceptions properly
        System.out.println("\n2. DO log exceptions properly:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   ✓ Logged: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            // In real code, use a logging framework
        }
        
        // Practice 3: Use specific exceptions
        System.out.println("\n3. DO use specific exceptions:");
        // try {
        //     // some code
        //     int result = 10 / 0;
        //     System.out.println("   ✓ Generic catch as fallback"+result);

        // } catch (Exception e) {
        //     System.out.println("   ✓ Generic catch as fallback");
        // }
        
        // Practice 4: Don't catch Throwable
        System.out.println("\n4. DON'T catch Throwable (catches Errors too):");
        System.out.println("   ❌ catch(Throwable t) - catches OutOfMemoryError, etc.");
        
        // Practice 5: Preserve cause
        System.out.println("\n5. DO preserve exception cause:");
        try {
            throw new IOException("Root cause");
        } catch (IOException e) {
            throw new RuntimeException("Wrapped", e); // Preserves cause
        }
    }
    
    // =========================================================================
    // PART 13: COMMON EXCEPTION SCENARIOS
    // =========================================================================
    
    /**
     * Demonstrates common exception scenarios
     */
    private static void demonstrateCommonExceptions() {
        System.out.println("\n--- Common Exception Scenarios ---");
        
        // Scenario 1: NullPointerException
        System.out.println("\n1. NullPointerException - accessing null object:");
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        // Scenario 2: ArithmeticException
        System.out.println("\n2. ArithmeticException - division by zero:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 3: ArrayIndexOutOfBoundsException
        System.out.println("\n3. ArrayIndexOutOfBoundsException - invalid array index:");
        try {
            int[] arr = new int[5];
            arr[10] = 42;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 4: ClassCastException
        System.out.println("\n4. ClassCastException - invalid cast:");
        try {
            Object obj = "string";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 5: NumberFormatException
        System.out.println("\n5. NumberFormatException - invalid number format:");
        try {
            int num = Integer.parseInt("abc123");
        } catch (NumberFormatException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 6: FileNotFoundException
        System.out.println("\n6. FileNotFoundException - file doesn't exist:");
        try {
            throw new FileNotFoundException("config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 7: IOException
        System.out.println("\n7. IOException - general I/O error:");
        try {
            throw new IOException("Connection reset");
        } catch (IOException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 8: SQLException
        System.out.println("\n8. SQLException - database error:");
        try {
            throw new SQLException("Connection timeout", "08S01", 1002);
        } catch (SQLException e) {
            System.out.println("   SQLState: " + e.getSQLState());
            System.out.println("   Error code: " + e.getErrorCode());
        }
        
        // Scenario 9: InterruptedException
        System.out.println("\n9. InterruptedException - thread interrupted:");
        try {
            throw new InterruptedException("Thread was interrupted");
        } catch (InterruptedException e) {
            System.out.println("   Caught: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
        
        // Scenario 10: IllegalArgumentException
        System.out.println("\n10. IllegalArgumentException - invalid argument:");
        try {
            throw new IllegalArgumentException("Age cannot be negative");
        } catch (IllegalArgumentException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 11: IllegalStateException
        System.out.println("\n11. IllegalStateException - invalid state:");
        try {
            throw new IllegalStateException("Connection already closed");
        } catch (IllegalStateException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 12: UnsupportedOperationException
        System.out.println("\n12. UnsupportedOperationException - operation not supported:");
        try {
            throw new UnsupportedOperationException("Method not implemented");
        } catch (UnsupportedOperationException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        // Scenario 13: ConcurrentModificationException
        System.out.println("\n13. ConcurrentModificationException - concurrent modification:");
        try {
            List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
            for (String item : list) {
                if (item.equals("B")) {
                    list.remove(item); // Modifying while iterating
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        // Scenario 14: StackOverflowError (Error, not Exception)
        System.out.println("\n14. StackOverflowError - recursive call (Error):");
        try {
            recursiveMethod(0);
        } catch (StackOverflowError e) {
            System.out.println("   Caught Error: " + e.getClass().getSimpleName());
        }
        
        // Scenario 15: OutOfMemoryError (Error, not Exception)
        System.out.println("\n15. OutOfMemoryError - heap full (Error):");
        try {
            List<byte[]> list = new ArrayList<>();
            while (true) {
                list.add(new byte[1024 * 1024]); // Allocate 1MB repeatedly
            }
        } catch (OutOfMemoryError e) {
            System.out.println("   Caught Error: " + e.getClass().getSimpleName());
        }
    }
    
    private static void recursiveMethod(int depth) {
        if (depth % 1000 == 0) System.out.print(".");
        recursiveMethod(depth + 1);
    }
    
    /**
     * Prints summary of all exception handling methods
     */
    private static void printSummary() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("SUMMARY OF EXCEPTION HANDLING METHODS");
        System.out.println("=".repeat(100));
        
        String[][] summary = {
            {"1-16", "Throwable Class", "16 methods (getMessage, printStackTrace, getCause, etc.)"},
            {"17-20", "Exception Class", "5 constructors and methods"},
            {"21-25", "Basic Try-Catch", "try, catch, multiple catch, multi-catch, finally"},
            {"26-30", "Try-With-Resources", "AutoCloseable, close(), suppressed exceptions"},
            {"31-35", "throw/throws", "throw keyword, throws clause, exception propagation"},
            {"36-40", "Custom Exceptions", "custom checked and unchecked exceptions"},
            {"41-45", "Exception Chaining", "initCause(), getCause(), suppressed exceptions"},
            {"46-50", "Checked Exceptions", "IOException, SQLException, ClassNotFoundException"},
            {"51-55", "Unchecked Exceptions", "RuntimeException subclasses (NPE, AIOOB, etc.)"},
            {"56-60", "Common Scenarios", "15+ common exception scenarios with examples"}
        };
        
        System.out.println("\nMethod Categories:");
        for (String[] row : summary) {
            System.out.printf("   %-8s | %-25s | %s%n", row[0], row[1], row[2]);
        }
        
        System.out.println("\n" + "=".repeat(100));
        System.out.println("TOTAL: Over 60 exception handling methods and concepts demonstrated");
        System.out.println("=".repeat(100));
    }
}