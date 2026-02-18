package com.saurabh.topics.volatileLearn;


import java.util.concurrent.atomic.AtomicInteger;

/*
    In this code, the variable stop is declared as volatile, ensuring that any update made by one thread (in this case,
    the main thread) is immediately visible to the other threads (e.g., the worker thread).
 */
public class Main {
    //
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            long i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("Stopped at i = " + i);
        });
        worker.start();
        Thread.sleep(1);
        stop = true;
        System.out.println("stop set to true");
    }
}