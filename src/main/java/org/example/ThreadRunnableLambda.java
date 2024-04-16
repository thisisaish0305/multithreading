package org.example;

public class ThreadRunnableLambda {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread runnable using lambda exp "+ Thread.currentThread().getName());
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
