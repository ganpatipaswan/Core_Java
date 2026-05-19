package Multithreading_Concurrency;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class RunnableInterface {
    public static void main(String[] args) {

        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}


// Why Runnable is Better?
// Java supports multiple inheritance through interfaces
// Better design
// Separates task from thread