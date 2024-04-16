package com.multithreading.concurrencyApi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> {
            System.out.println("Runnable thread is "+ Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        System.out.println("Submit the task");
        executorService.submit(runnable);
        //If you run the above program, you will notice that the program never exits, because,
        // the executor service keeps listening for new tasks until we shut it down explicitly.

        System.out.println("Shutting down the executor");
        //executorService.shutdown();
        System.out.println("Notice difference in shutdown and shutdownNow()");
        executorService.shutdownNow();
    }
}
