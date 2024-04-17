package com.multithreading.ThreadSynchronization;

/**
 * # Ideal Output
 * Say Hello..
 * Hello World!
 * Say Bye..
 * Good Bye!
 * But do we get the desired output after running the above program? Well, If you run the program, you will see the following output -
 *
 * # Actual Output
 * Say Hello..
 * Say Bye..
 * Also, the program doesn’t even terminate.
 *
 * Wait. What? How is that possible?
 *
 * Yes! That is what Memory Consistency Error is. The first thread is unaware of the changes done by the main thread to the sayHello variable.
 * */

public class MemoryConsistencyErrorExample {
    private static boolean sayHello = false;

    public static void main(String[] args) throws InterruptedException {
//IMP : The first thread is unaware of the changes done by the main thread to the sayHello variable.
        Thread thread = new Thread(() -> {
            while(!sayHello) {
            }

            System.out.println("Hello World!");

            while(sayHello) {
            }

            System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(3000);
        System.out.println("Say Hello..");
        sayHello = true;

        Thread.sleep(3000);
        System.out.println("Say Bye..");
        sayHello = false;

    }
}
