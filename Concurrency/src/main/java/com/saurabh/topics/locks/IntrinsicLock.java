package com.saurabh.topics.locks;


/*
    Use an intrinsic lock (synchronized) when your problem is just:
    “only one thread should execute this code at a time,” and you don’t need any fancy locking features.
    When to use
        Simple mutual exclusion (one thread at a time).
        You don’t need lock polling, timed waits, or multiple conditions.
        Clean, idiomatic Java; JVM handles release on exceptions.

        This is perfect when:
        The critical section is short (few instructions).
        The shared state is small (a few fields, a small collection).
        You just want to prevent race conditions (partial updates, inconsistent reads).

        So synchronized is ideal when:
            It’s okay for a thread to wait until the lock is available.
            You don’t have logic like:
            “If I can’t grab the lock in 10ms, log and skip.”
            “If the lock is busy, do alternative work.”
            The lack of tryLock() / timeout keeps the model simpler.
 */
class Counter implements Runnable {
    int counter = 0;
    private final Object lock = new Object();

    public synchronized void increment() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }

    void doSomething() {
        synchronized (lock) { // only one thread can execute this block at a time
            // critical section

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }
}
public class IntrinsicLock {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread counterThread1 = new Thread(counter);
        Thread counterThread2 = new Thread(counter);
        Thread counterThread3 = new Thread(counter);

        counterThread1.start();
        counterThread2.start();
        counterThread3.start();

        counterThread1.join();
        counterThread2.join();
        counterThread3.join();

        System.out.println("Final Counter Value: " + counter.getCounter());
    }
}
