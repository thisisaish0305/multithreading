package com.multithreading;

public class ThreadSleepExample {
    public static void main(String[] args) {

        String[] arr = new String[]{"It is always","nice to see you",
                "says the man at the counter",
                "to the woman who was coming",
                "she was checking her umbrella",
                "and I see the other way round",
                "And pretended not to see them",
                "Instead I pour the milk",
                "ta ta tara ta ta tara ta ta tara ta ta tara"
        };

        Runnable runnable = () -> {
            System.out.println("Inside thread.." + Thread.currentThread().getThreadGroup());

            for (String s : arr){
                System.out.println(s);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();



    }
}
