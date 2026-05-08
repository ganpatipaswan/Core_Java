/**
 * Comprehensive Multithreading Program for Beginners
 * 
 * This program demonstrates all fundamental concepts of multithreading in Java
 * with simple, easy-to-understand examples.
 * 
 * Topics covered:
 * 1. Creating threads (Thread class vs Runnable interface)
 * 2. Thread lifecycle
 * 3. Thread synchronization
 * 4. Inter-thread communication
 * 5. Thread pools
 * 6. Common problems and solutions
 */

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class MultithreadingForBeginners {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("MULTITHREADING IN JAVA - BEGINNER'S GUIDE");
        System.out.println("=".repeat(80));
        
        // Print main thread information
        System.out.println("\n📌 Main Thread Information:");
        Thread mainThread = Thread.currentThread();
        System.out.println("   Thread name: " + mainThread.getName());
        System.out.println("   Thread ID: " + mainThread.getId());
        System.out.println("   Thread priority: " + mainThread.getPriority());
        System.out.println("   Thread state: " + mainThread.getState());
        
        // Section 1: Creating Threads
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 1: CREATING THREADS");
        System.out.println("#".repeat(60));
        
        // Method 1: Extending Thread class
        demonstrateExtendingThread();
        
        // Method 2: Implementing Runnable interface
        demonstrateImplementingRunnable();
        
        // Method 3: Using lambda expression (Java 8+)
        demonstrateLambdaThread();
        
        // Section 2: Thread Lifecycle
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 2: THREAD LIFECYCLE");
        System.out.println("#".repeat(60));
        
        demonstrateThreadLifecycle();
        
        // Section 3: Thread Sleep and Join
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 3: THREAD SLEEP AND JOIN");
        System.out.println("#".repeat(60));
        
        demonstrateSleepAndJoin();
        
        // Section 4: Thread Priority
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 4: THREAD PRIORITY");
        System.out.println("#".repeat(60));
        
        demonstrateThreadPriority();
        
        // Section 5: Synchronization
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 5: THREAD SYNCHRONIZATION");
        System.out.println("#".repeat(60));
        
        demonstrateSynchronization();
        
        // Section 6: Inter-thread Communication
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 6: INTER-THREAD COMMUNICATION");
        System.out.println("#".repeat(60));
        
        demonstrateInterThreadCommunication();
        
        // Section 7: Thread Pool
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 7: THREAD POOL (EXECUTOR SERVICE)");
        System.out.println("#".repeat(60));
        
        demonstrateThreadPool();
        
        // Section 8: Common Problems
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 8: COMMON THREADING PROBLEMS");
        System.out.println("#".repeat(60));
        
        demonstrateCommonProblems();
        
        // Section 9: Thread Safety with Collections
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 9: THREAD-SAFE COLLECTIONS");
        System.out.println("#".repeat(60));
        
        demonstrateThreadSafeCollections();
        
        // Section 10: Atomic Variables
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 10: ATOMIC VARIABLES");
        System.out.println("#".repeat(60));
        
        demonstrateAtomicVariables();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("🎉 CONGRATULATIONS! You've learned multithreading basics!");
        System.out.println("=".repeat(80));
    }
    
    // =========================================================================
    // SECTION 1: CREATING THREADS
    // =========================================================================
    
    /**
     * Method 1: Extending Thread class
     */
    private static void demonstrateExtendingThread() {
        System.out.println("\n📌 Method 1: Extending Thread class");
        
        // Create and start thread
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        
        thread1.start();
        thread2.start();
        
        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("   ✅ Thread class extension demonstrated");
    }
    
    /**
     * Custom Thread class extending Thread
     */
    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }
        
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("   Thread " + getName() + " - Count: " + i);
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Method 2: Implementing Runnable interface
     */
    private static void demonstrateImplementingRunnable() {
        System.out.println("\n📌 Method 2: Implementing Runnable interface");
        
        // Create Runnable objects
        MyRunnable runnable1 = new MyRunnable("Runnable-1");
        MyRunnable runnable2 = new MyRunnable("Runnable-2");
        
        // Create Thread objects with Runnable
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        
        thread1.start();
        thread2.start();
        
        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("   ✅ Runnable interface demonstrated");
    }
    
    /**
     * Custom Runnable class
     */
    static class MyRunnable implements Runnable {
        private String name;
        
        public MyRunnable(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("   " + name + " - Count: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Method 3: Using Lambda Expression (Java 8+)
     */
    private static void demonstrateLambdaThread() {
        System.out.println("\n📌 Method 3: Using Lambda Expression");
        
        // Create threads using lambda
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("   Lambda Thread-1 - Count: " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("   Lambda Thread-2 - Count: " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("   ✅ Lambda expression demonstrated");
    }
    
    // =========================================================================
    // SECTION 2: THREAD LIFECYCLE
    // =========================================================================
    
    /**
     * Demonstrates different thread states
     */
    private static void demonstrateThreadLifecycle() {
        System.out.println("\n📌 Thread States: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED");
        
        Thread thread = new Thread(() -> {
            try {
                System.out.println("   Thread state in run(): " + Thread.currentThread().getState());
                
                // TIMED_WAITING state
                Thread.sleep(500);
                System.out.println("   After sleep, state: " + Thread.currentThread().getState());
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // NEW state
        System.out.println("   After creation, state: " + thread.getState());
        
        // RUNNABLE state
        thread.start();
        System.out.println("   After start(), state: " + thread.getState());
        
        // Let the thread run for a bit
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        // Check state while thread is running/sleeping
        System.out.println("   During execution, state: " + thread.getState());
        
        // Wait for thread to finish
        try { thread.join(); } catch (InterruptedException e) {}
        
        // TERMINATED state
        System.out.println("   After completion, state: " + thread.getState());
        
        System.out.println("   ✅ Thread lifecycle demonstrated");
    }
    
    // =========================================================================
    // SECTION 3: THREAD SLEEP AND JOIN
    // =========================================================================
    
    /**
     * Demonstrates sleep() and join() methods
     */
    private static void demonstrateSleepAndJoin() {
        System.out.println("\n📌 Thread.sleep() and join()");
        
        Thread slowThread = new Thread(() -> {
            System.out.println("   Slow thread started");
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(200); // Sleep for 200ms
                    System.out.println("   Slow thread working... step " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("   Slow thread finished");
        });
        
        Thread fastThread = new Thread(() -> {
            System.out.println("   Fast thread started");
            for (int i = 1; i <= 3; i++) {
                System.out.println("   Fast thread working... step " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
            System.out.println("   Fast thread finished");
        });
        
        System.out.println("\n   Starting threads...");
        slowThread.start();
        fastThread.start();
        
        try {
            // Wait for fast thread to finish (max 1 second)
            fastThread.join(1000);
            System.out.println("   Fast thread joined (waited for it)");
            
            // Wait for slow thread to finish
            slowThread.join();
            System.out.println("   Slow thread joined");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("   ✅ sleep() and join() demonstrated");
    }
    
    // =========================================================================
    // SECTION 4: THREAD PRIORITY
    // =========================================================================
    
    /**
     * Demonstrates thread priorities
     */
    private static void demonstrateThreadPriority() {
        System.out.println("\n📌 Thread Priorities (1-10)");
        
        class PriorityThread extends Thread {
            public PriorityThread(String name) {
                super(name);
            }
            
            @Override
            public void run() {
                System.out.println("   " + getName() + " with priority " + 
                                 getPriority() + " is running");
                long count = 0;
                for (int i = 0; i < 1000000; i++) {
                    count += i;
                }
                System.out.println("   " + getName() + " completed work");
            }
        }
        
        PriorityThread minPriority = new PriorityThread("Min-Priority");
        PriorityThread normPriority = new PriorityThread("Norm-Priority");
        PriorityThread maxPriority = new PriorityThread("Max-Priority");
        
        // Set priorities
        minPriority.setPriority(Thread.MIN_PRIORITY);  // 1
        normPriority.setPriority(Thread.NORM_PRIORITY); // 5
        maxPriority.setPriority(Thread.MAX_PRIORITY);   // 10
        
        System.out.println("\n   Starting threads with different priorities...");
        System.out.println("   (Note: Priority is just a hint to the scheduler)");
        
        minPriority.start();
        normPriority.start();
        maxPriority.start();
        
        try {
            minPriority.join();
            normPriority.join();
            maxPriority.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("   ✅ Thread priorities demonstrated");
    }
    
    // =========================================================================
    // SECTION 5: THREAD SYNCHRONIZATION
    // =========================================================================
    
    /**
     * Demonstrates synchronization to prevent race conditions
     */
    private static void demonstrateSynchronization() {
        System.out.println("\n📌 Thread Synchronization (Preventing Race Conditions)");
        
        class Counter {
            private int count = 0;
            
            // Without synchronization
            public void incrementWithoutSync() {
                count++;
            }
            
            // With synchronization
            public synchronized void incrementWithSync() {
                count++;
            }
            
            public int getCount() {
                return count;
            }
        }
        
        final Counter counter = new Counter();
        
        // Without synchronization (race condition)
        System.out.println("\n   🔴 WITHOUT SYNCHRONIZATION (Race Condition):");
        
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementWithoutSync();
                }
            });
            threads[i].start();
        }
        
        // Wait for all threads
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("   Expected count: 10000");
        System.out.println("   Actual count without sync: " + counter.getCount());
        System.out.println("   ❌ Race condition! Count is incorrect!");
        
        // Reset counter
        // counter = new Counter();
        
        // With synchronization
        System.out.println("\n   🟢 WITH SYNCHRONIZATION (Thread-safe):");
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementWithSync();
                }
            });
            threads[i].start();
        }
        
        // Wait for all threads
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("   Expected count: 10000");
        System.out.println("   Actual count with sync: " + counter.getCount());
        System.out.println("   ✅ Correct! Synchronization works!");
        
        // Synchronized block example
        System.out.println("\n   📌 Synchronized Block (more fine-grained):");
        
        class BankAccount {
            private int balance = 1000;
            private final Object lock = new Object();
            
            public void withdraw(int amount) {
                System.out.println("   Attempting to withdraw: " + amount);
                
                synchronized(lock) {
                    if (balance >= amount) {
                        System.out.println("   Processing withdrawal...");
                        try { Thread.sleep(100); } catch (InterruptedException e) {}
                        balance -= amount;
                        System.out.println("   Withdrawal successful. New balance: " + balance);
                    } else {
                        System.out.println("   Insufficient balance!");
                    }
                }
            }
            
            public int getBalance() {
                return balance;
            }
        }
        
        BankAccount account = new BankAccount();
        
        Thread withdraw1 = new Thread(() -> account.withdraw(800));
        Thread withdraw2 = new Thread(() -> account.withdraw(500));
        
        withdraw1.start();
        withdraw2.start();
        
        try {
            withdraw1.join();
            withdraw2.join();
        } catch (InterruptedException e) {}
        
        System.out.println("   Final balance: " + account.getBalance());
    }
    
    // =========================================================================
    // SECTION 6: INTER-THREAD COMMUNICATION
    // =========================================================================
    
    /**
     * Demonstrates wait(), notify(), and notifyAll()
     */
    private static void demonstrateInterThreadCommunication() {
        System.out.println("\n📌 Inter-thread Communication (wait/notify)");
        
        class Message {
            private String content;
            private boolean hasMessage = false;
            
            public synchronized void produce(String message) {
                while (hasMessage) {
                    try {
                        System.out.println("   Producer waiting (buffer full)...");
                        wait();
                    } catch (InterruptedException e) {}
                }
                
                content = message;
                hasMessage = true;
                System.out.println("   Produced: " + message);
                notifyAll(); // Notify consumers
            }
            
            public synchronized String consume() {
                while (!hasMessage) {
                    try {
                        System.out.println("   Consumer waiting (buffer empty)...");
                        wait();
                    } catch (InterruptedException e) {}
                }
                
                hasMessage = false;
                System.out.println("   Consumed: " + content);
                notifyAll(); // Notify producers
                return content;
            }
        }
        
        Message message = new Message();
        
        // Producer thread
        Thread producer = new Thread(() -> {
            String[] messages = {"Hello", "World", "Java", "Multithreading"};
            for (String msg : messages) {
                message.produce(msg);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                message.consume();
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });
        
        System.out.println("\n   Starting producer-consumer example...");
        producer.start();
        consumer.start();
        
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {}
        
        System.out.println("   ✅ Inter-thread communication demonstrated");
    }
    
    // =========================================================================
    // SECTION 7: THREAD POOL
    // =========================================================================
    
    /**
     * Demonstrates ExecutorService and thread pools
     */
    private static void demonstrateThreadPool() {
        System.out.println("\n📌 Thread Pool (ExecutorService)");
        
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        System.out.println("\n   Submitting 6 tasks to a pool of 3 threads...");
        
        // Submit tasks
        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("   Task " + taskId + " started by " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {}
                System.out.println("   Task " + taskId + " completed");
            });
        }
        
        // Shutdown the executor
        executor.shutdown();
        
        try {
            // Wait for all tasks to complete
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {}
        
        System.out.println("\n   ✅ Thread pool demonstrated");
        
        // Different types of thread pools
        System.out.println("\n   📌 Types of thread pools:");
        System.out.println("   - FixedThreadPool: Fixed number of threads");
        System.out.println("   - CachedThreadPool: Creates threads as needed");
        System.out.println("   - SingleThreadExecutor: Single thread");
        System.out.println("   - ScheduledThreadPool: For scheduled tasks");
    }
    
    // =========================================================================
    // SECTION 8: COMMON PROBLEMS
    // =========================================================================
    
    /**
     * Demonstrates common threading problems
     */
    private static void demonstrateCommonProblems() {
        System.out.println("\n📌 Common Threading Problems");
        
        // Problem 1: Deadlock
        System.out.println("\n   🔴 Problem 1: Deadlock");
        System.out.println("   (This example would cause deadlock if uncommented)");
        
        class DeadlockExample {
            private final Object lock1 = new Object();
            private final Object lock2 = new Object();
            
            public void method1() {
                synchronized(lock1) {
                    System.out.println("   Method1 acquired lock1");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    synchronized(lock2) {
                        System.out.println("   Method1 acquired lock2");
                    }
                }
            }
            
            public void method2() {
                synchronized(lock2) {
                    System.out.println("   Method2 acquired lock2");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    synchronized(lock1) {
                        System.out.println("   Method2 acquired lock1");
                    }
                }
            }
        }
        
        System.out.println("   ⚠️ Deadlock occurs when two threads wait for each other's locks");
        System.out.println("   Solution: Always acquire locks in the same order");
        
        // Problem 2: Starvation
        System.out.println("\n   🔴 Problem 2: Starvation");
        System.out.println("   Low priority threads may never get CPU time if high priority threads are always running");
        
        // Problem 3: Livelock
        System.out.println("\n   🔴 Problem 3: Livelock");
        System.out.println("   Threads are not blocked but keep changing state in response to each other");
        
        // Problem 4: Race Condition
        System.out.println("\n   🔴 Problem 4: Race Condition");
        System.out.println("   Already demonstrated in synchronization section");
        System.out.println("   Solution: Use synchronization or atomic variables");
    }
    
    // =========================================================================
    // SECTION 9: THREAD-SAFE COLLECTIONS
    // =========================================================================
    
    /**
     * Demonstrates thread-safe collections
     */
    private static void demonstrateThreadSafeCollections() {
        System.out.println("\n📌 Thread-Safe Collections");
        
        // Non-thread-safe collection
        System.out.println("\n   🔴 ArrayList (NOT thread-safe):");
        // List<Integer> arrayList = new ArrayList()<>();
        List<Integer> arrayList = new ArrayList<>();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    arrayList.add(index * 100 + j);
                }
            });
            threads[i].start();
        }
        
        // Wait for threads
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("   ArrayList size: " + arrayList.size() + " (may be incorrect)");
        
        // Thread-safe collection
        System.out.println("\n   🟢 CopyOnWriteArrayList (thread-safe):");
        List<Integer> safeList = new CopyOnWriteArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    safeList.add(index * 100 + j);
                }
            });
            threads[i].start();
        }
        
        // Wait for threads
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("   CopyOnWriteArrayList size: " + safeList.size() + " (always correct)");
        
        // Other thread-safe collections
        System.out.println("\n   📌 Other thread-safe collections:");
        System.out.println("   - ConcurrentHashMap (thread-safe Map)");
        System.out.println("   - CopyOnWriteArraySet (thread-safe Set)");
        System.out.println("   - BlockingQueue (for producer-consumer)");
        System.out.println("   - ConcurrentLinkedQueue (lock-free queue)");
    }
    
    // =========================================================================
    // SECTION 10: ATOMIC VARIABLES
    // =========================================================================
    
    /**
     * Demonstrates atomic variables
     */
    private static void demonstrateAtomicVariables() {
        System.out.println("\n📌 Atomic Variables (java.util.concurrent.atomic)");
        
        class AtomicCounter {
            private java.util.concurrent.atomic.AtomicInteger count = 
                new java.util.concurrent.atomic.AtomicInteger(0);
            
            public void increment() {
                count.incrementAndGet();
            }
            
            public int getCount() {
                return count.get();
            }
        }
        
        AtomicCounter counter = new AtomicCounter();
        
        System.out.println("\n   Using AtomicInteger (no synchronization needed):");
        
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        
        // Wait for all threads
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }
        
        System.out.println("   Final count: " + counter.getCount() + " (correct!)");
        
        System.out.println("\n   📌 Other atomic classes:");
        System.out.println("   - AtomicLong");
        System.out.println("   - AtomicBoolean");
        System.out.println("   - AtomicReference");
        System.out.println("   - AtomicIntegerArray");
        System.out.println("   - LongAdder (better for high contention)");
    }
}

/**
 * Additional Examples for Self-Study
 * 
 * Try these exercises on your own:
 * 
 * Exercise 1: Create a program that prints numbers 1 to 10 from two threads alternately
 * 
 * Exercise 2: Implement a simple bank with multiple accounts and transactions
 * 
 * Exercise 3: Create a multithreaded file downloader
 * 
 * Exercise 4: Implement a thread-safe queue
 * 
 * Exercise 5: Create a simple web crawler using multiple threads
 */