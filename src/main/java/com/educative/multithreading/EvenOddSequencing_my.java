package com.educative.multithreading;

/*
* Question for tomorrow
Print n numbers via 2 threads, where one thread prints only even and
* another thread only odd numbers but the output should be sequential
* */
public class EvenOddSequencing_my {


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

        t2.start();
        t1.start();

    }
}

class PrintNumberN{
    int count = 1;
    int N= 10;
    boolean flag = false; //false -> odd
    synchronized void printEven() throws InterruptedException {
        while(flag==false) {
            wait();
        }

        if(count%2==0 && count<N) {
            System.out.println("Even: " + count);
            count++;
            flag=false;
        }

        notify();
    }

    synchronized void printOdd() throws InterruptedException {

        while(flag==true) {
            wait();
        }

        if(count%2==1 && count<N) {
            System.out.println("Odd: " + count);
            count++;
            flag=true;
        }
        notify();
    }
}
