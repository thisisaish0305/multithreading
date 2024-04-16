package com.multithreading.callableAndFuture;

import java.util.concurrent.*;

public class FutureAndCallable {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> c1 = () -> {
            System.out.println("Inside callable thread");
            Thread.sleep(5000);
            return "This is the processed output of callable";
        };

        Future<String> f1= executorService.submit(c1);

        while(!f1.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(1000);
        }

        try {
            System.out.println("Going to get callable result now ");
            String callableResult = f1.get();
            System.out.println("Callable result received :- "+ callableResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
