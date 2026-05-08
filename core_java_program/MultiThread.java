class MultiThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running");
    }

    public static void main(String[] args) {
        // 1. Start the thread defined by the class
        MultiThread t1 = new MultiThread();
        t1.start();

        // 2. Start a thread using the Lambda expression
        new Thread(() -> System.out.println("Runnable thread")).start();
    }
}