package com.multithreading;

public class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread name "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample();
        t1.start();

        ThreadExample t2 = new ThreadExample();
        t2.start();
    }
}


