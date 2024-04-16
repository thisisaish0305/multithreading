package com.multithreading;

public class ThreadJoinExampleII {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("In thread t1");

            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Exiting thread t1");
        });

        Thread t2 = new Thread(()-> {
            System.out.println("In thread t2");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Exiting thread t2");
        });


        System.out.println("Going to start Thread 1");
        t1.start();
        System.out.println("Waiting for Thread 1 to complete");

        try {
            t1.join(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Waited enough for Thread1, starting thread2 now");
        t2.start();
    }


}
