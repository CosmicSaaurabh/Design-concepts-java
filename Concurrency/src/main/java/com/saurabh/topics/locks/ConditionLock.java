package com.saurabh.topics.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Condition variables in Java are used in conjunction with locks to facilitate
    communication between threads. They allow threads to wait for certain conditions
    to be met before proceeding, enabling more complex synchronization scenarios.

    Key Features:
    - Condition variables are associated with a specific Lock.
    - Threads can wait on a Condition, releasing the associated Lock while waiting.
    - Other threads can signal the Condition to wake up waiting threads.

    Use Cases:
    - Producer-consumer scenarios where producers wait for space and consumers wait for items.
    - Coordinating multiple threads that depend on certain conditions being true.

    When to Use:
    - When you need fine-grained control over thread synchronization beyond simple locking.
    - When threads need to wait for specific conditions to be met before continuing execution.
*/
class BoundedBuffer<E> {
    private final E[] buffer;
    private int putIndex, takeIndex, count;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public BoundedBuffer (int size) {
        buffer = (E[]) new Object[size];
    }

    public void put(E item) throws InterruptedException {
        lock.lock();
        try {
            while (count == buffer.length) {
                notFull.await();
            }

            buffer[putIndex] = item;
            putIndex = (putIndex + 1) % buffer.length;
            count++;
            notEmpty.notify();
        } finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0) {
                notEmpty.wait();
            }

            E item = buffer[takeIndex];
            takeIndex = (takeIndex + 1) % buffer.length;
            count--;
            notFull.notify();
        } finally {
            lock.unlock();
        }
    }
}
public class ConditionLock {
}
