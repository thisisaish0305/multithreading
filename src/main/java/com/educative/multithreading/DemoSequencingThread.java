package com.educative.multithreading;

/*
Thread t1 calls printFirst(), thread t2 calls printSecond(), and thread t3 calls printThird(). The threads can run in any order.
You have to synchronize the threads so that the functions printFirst(), printSecond() and printThird() are executed in order.
 */

public class DemoSequencingThread {

    public static void main(String[] args) {
        OrderedPrinting op = new OrderedPrinting();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                op.printFirst();
            }
        }) ;

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    op.printSecond();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }) ;

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    op.printThird();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //can change this order, still print order remains same.
        t3.start();
        t2.start();
        t1.start();


    }
}

 class OrderedPrinting {
    int count = 1;
    public synchronized void printFirst() {
        System.out.println("First");
        count++;
        notifyAll();
    }

    public synchronized void printSecond() throws InterruptedException {
        while (count!=2) {
            wait();
        }
        System.out.println("Second");
        count++;
        notifyAll();
    }

    public synchronized void printThird() throws InterruptedException {
        while (count!=3) {
           wait();
        }
        System.out.println("Third");
        count++;
        notifyAll();
    }
}

