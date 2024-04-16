package com.multithreading;

//Any class whose instance needs to be executed by a thread should implement the Runnable interface.
public class ThreadRunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside runnable "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnableThread = new ThreadRunnableExample();
        Thread t1 = new Thread(runnableThread);
        t1.start();
    }
}
