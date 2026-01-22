package com.saurabh.topics.basics;

public class SimpleConcurrency {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i + " and priority: " + Thread.currentThread().getPriority());
                counter.increment();
            }
            System.out.println("We are in thread: " + Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            for (int i =1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i + " and priority: " + Thread.currentThread().getPriority());
                counter.increment();
            }

            System.out.println("We are in thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // This is another way to create a thread using Runnable interface
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " - Count: " + i + " and priority: " + Thread.currentThread().getPriority());
                    counter.increment();
                }

                System.out.println("We are in thread: " + Thread.currentThread().getName());
            }
        });

        Thread thread4 = new Thread(() -> {
            throw new RuntimeException("Intentional Exception in thread: " + Thread.currentThread().getName());
        });

        thread1.setName("worker-thread-1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setName("worker-thread-2");
        thread3.setName("worker-thread-3");
        thread4.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Caught exception: " + e.getMessage() + " from thread: " + t.getName());
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

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
