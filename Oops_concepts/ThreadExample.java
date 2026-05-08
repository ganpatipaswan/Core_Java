// wait() and notify() Example
class SharedResource {
    private int data;
    private boolean available = false;

    synchronized void produce(int value) {
        while (available) { // Wait if data is available
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        System.out.println("Produced: " + value);
        available = true;
        notify(); // Notify consumer thread
    }

    synchronized void consume() {
        while (!available) { // Wait if data is not available
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify(); // Notify producer thread
    }
}

class Producer extends Thread {
    SharedResource resource;

    Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    SharedResource resource;

    Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample { // ThreadCommExample
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }
}

// // Synchronization Example
// class Table {
// synchronized void printTable(int num) { // Synchronized method
// for (int i = 1; i <= 5; i++) {
// System.out.println(num + " x " + i + " = " + (num * i));
// try {
// Thread.sleep(500);
// } catch (InterruptedException e) {
// e.printStackTrace();
// }
// }
// }
// }

// class MyThread extends Thread {
// Table table;
// int num;

// MyThread(Table table, int num) {
// this.table = table;
// this.num = num;
// }

// public void run() {
// table.printTable(num);
// }
// }

// public class ThreadExample { // SyncExample
// public static void main(String[] args) {
// Table obj = new Table();

// MyThread t1 = new MyThread(obj, 5);
// MyThread t2 = new MyThread(obj, 10);

// t1.start();
// t2.start();
// }
// }

// class MyRunnable implements Runnable {
// public void run() {
// for (int i = 1; i <= 5; i++) {
// System.out.println(Thread.currentThread().getName() + " - Count: " + i);
// try {
// Thread.sleep(500);
// } catch (InterruptedException e) {
// e.printStackTrace();
// }
// }
// }
// }

// public class ThreadExample { // RunnableExample
// public static void main(String[] args) {
// Thread t1 = new Thread(new MyRunnable());
// Thread t2 = new Thread(new MyRunnable());

// t1.start();
// t2.start();
// }
// }

// class MyThread extends Thread {
// public void run() {
// for (int i = 1; i <= 5; i++) {
// System.out.println(Thread.currentThread().getName() + " - Count: " + i);
// try {
// Thread.sleep(500); // Pause execution for 500ms
// } catch (InterruptedException e) {
// e.printStackTrace();
// }
// }
// }
// }

// public class ThreadExample {
// public static void main(String[] args) {
// MyThread t1 = new MyThread();
// MyThread t2 = new MyThread();

// t1.start(); // Start first thread
// t2.start(); // Start second thread
// }
// }
