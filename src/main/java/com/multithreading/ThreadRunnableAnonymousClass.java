package com.multithreading;

public class ThreadRunnableAnonymousClass {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
