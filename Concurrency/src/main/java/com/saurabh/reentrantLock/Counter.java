package com.saurabh.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try{
            counter++;
        } finally {
            lock.unlock();
        }
    }

    // Reentrant exmaple - same thread 2 lock counts
    public void methodA() {
        lock.lock(); // lock hold count = 1
        try {
            System.out.println("Outer: " + lock.getHoldCount());
            methodB(); // lock hold count = 2
        } finally {
            lock.unlock(); // hold count = 1
        }
    }

    public void methodB() {
        lock.lock();
        try{
            // some logic
        } finally {
            lock.unlock();
        }
    }
}
