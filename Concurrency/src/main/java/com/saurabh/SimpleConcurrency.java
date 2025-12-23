package com.saurabh;

public class SimpleConcurrency {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread 1 - Count: " + i);
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i =1; i <= 10; i++) {
                System.out.println("Thread 2 - Count: " + i);
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Count: " + counter.getCount());
    }
}

class Counter {
    private int count = 0;
    public synchronized void increment() {
        count ++;
    }

    public int getCount() {
        return count;
    }
}
