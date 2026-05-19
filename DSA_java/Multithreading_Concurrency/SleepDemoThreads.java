package Multithreading_Concurrency;

class SleepDemo extends Thread {

    public void run() {

        try {
            for(int i = 1; i <= 5; i++) {
                System.out.println(i);

                Thread.sleep(1000);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

public class SleepDemoThreads {
    public static void main(String[] args) {

        SleepDemo t1 = new SleepDemo();
        t1.start();
    }
}