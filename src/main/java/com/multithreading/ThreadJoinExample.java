package com.multithreading;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("In thread t1");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Exiting thread t1");
        });

        Thread t2 = new Thread(()-> {
            System.out.println("In thread t2");
            try{
                Thread.sleep(7000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Exiting thread t2");
        });


        t1.start();
        t2.start();
    }


}
