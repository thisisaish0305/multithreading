package com.educative.multithreading;


/*
* Question for tomorrow
Print n numbers via 2 threads, where one thread prints only even and
* another thread only odd numbers but the output should be sequential
* */
public class EvenOddSequencing {


    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pn.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pn.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class PrintNumber{
    int count = 1;
    int N= 10;
    boolean flag = false; //false -> odd
    synchronized void printEven() throws InterruptedException {
        while (count<N) {
            while (count%2==1){
                wait();
            }
            System.out.println("Even: " + count);
            count++;
            notify();
        }
    }

    synchronized void printOdd() throws InterruptedException {

        while (count<N) {
            while (count%2==0) {
                wait();
            }
            System.out.println("Odd: " + count);
            count++;
            notify();
        }
    }
}
