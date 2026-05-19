package Multithreading_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);
//newSingleThreadExecutor
        for(int i = 1; i <= 10; i++) {

            int task = i;

            executor.submit(() -> {
                System.out.println(
                        "Executing Task " + task +
                        " by " +
                        Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}