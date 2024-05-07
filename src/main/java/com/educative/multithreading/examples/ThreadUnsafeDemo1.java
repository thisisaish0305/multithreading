package com.educative.multithreading.examples;

import java.util.Random;

public class ThreadUnsafeDemo1 {
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        ThreadUnsafeCounter threadUnsafeCounter = new ThreadUnsafeCounter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++){
                    threadUnsafeCounter.increment();
                    sleepRandom();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++){
                    threadUnsafeCounter.decrement();
                    sleepRandom();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        threadUnsafeCounter.printFinalCounterValue();

    }

    static void sleepRandom(){
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadUnsafeCounter {

    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    void printFinalCounterValue() {
        System.out.println("counter is: " + count);
    }
}
