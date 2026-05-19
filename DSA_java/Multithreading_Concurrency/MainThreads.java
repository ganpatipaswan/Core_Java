
// Method 1: Extending Thread Class
package Multithreading_Concurrency;
class MyThread extends Thread {

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}

public class MainThreads {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();

        for(int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
