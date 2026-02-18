package com.saurabh.topics.volatileLearn;

import java.util.concurrent.atomic.AtomicInteger;

public class learn2 {
    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) example.incrementCounter();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) example.incrementCounter();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + example.getCounter());
    }
}

class VolatileExample {
    private volatile AtomicInteger counter = new AtomicInteger();

    public void incrementCounter() {
        // TODO: Replace the synchronized block with the volatile keyword for counter
        counter.incrementAndGet();

    }

    public int getCounter() {
        // TODO: Replace the synchronized block with the volatile keyword for counter
        return counter.get();

    }
}
