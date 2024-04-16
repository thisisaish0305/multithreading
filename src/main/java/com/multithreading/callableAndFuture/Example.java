package com.multithreading.callableAndFuture;

import java.util.concurrent.Callable;

//What if you want to return a result from your tasks?
public class Example {
    Callable<String> callable = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000); // not try catch as can throw a checked exception.
            return "computed string result";
        }
    };


    //using lambda
    Callable<String> callable2 = () -> {
        // Perform some computation
        Thread.sleep(2000);
        return "Return some result";
    };
}
