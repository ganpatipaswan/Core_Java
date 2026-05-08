public class ThreadLifeCycleDemo {

    public static void main(String[] args) throws Exception {

        // Create thread (NEW state)
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread is RUNNING");

                // TIMED_WAITING state
                Thread.sleep(1000);

                System.out.println("Thread finished execution");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // NEW
        System.out.println("State after creation: " + t1.getState());

        // RUNNABLE
        t1.start();
        System.out.println("State after start(): " + t1.getState());

        // Give time to enter sleep
        Thread.sleep(200);
        System.out.println("State during sleep: " + t1.getState());

        // WAIT for thread to finish
        t1.join();

        // TERMINATED
        System.out.println("State after completion: " + t1.getState());
    }
}