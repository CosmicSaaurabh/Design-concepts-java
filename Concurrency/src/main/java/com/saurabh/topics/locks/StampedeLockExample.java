package com.saurabh.topics.locks;

import java.util.concurrent.locks.StampedLock;

/*
    StampedLock is a synchronization mechanism introduced in Java 8 that
    provides three modes of locking: read, write, and optimistic read.
    It is designed to improve performance in scenarios with a high ratio
    of read operations to write operations by allowing multiple threads
    to read concurrently while still providing exclusive access for writes.

    Key Features:
    - Read Lock: Allows multiple threads to read the shared resource concurrently.
    - Write Lock: Provides exclusive access to a single thread for writing.
    - Optimistic Read: Allows threads to read without acquiring a lock,
      with the ability to validate if the data was modified during the read.

    Use Cases:
    - Caches where reads are frequent and writes are infrequent.
    - Scenarios where optimistic reads can significantly reduce contention.

    When to Use:
    - When read operations vastly outnumber write operations.
    - When you want to leverage optimistic concurrency control for better performance.
*/
class Point{
    private double x, y;
    private final StampedLock stampedeLock = new StampedLock();

    double distanceFromOrigin() {
        long stamp = stampedeLock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;

        if (!stampedeLock.validate(stamp)) {
            stamp = stampedeLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedeLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void move(double deltaX, double deltaY) {
        long stamp = stampedeLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedeLock.unlockWrite(stamp);
        }
    }
}
public class StampedeLockExample {
    public static void main(String[] args) throws InterruptedException {
        Point point = new Point();

        Thread writeThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                point.move(1,2);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread readThread = new Thread(() -> {
            for (int counter = 0; counter < 1000; counter++) {
                System.out.println("Distance from origin: " + point.distanceFromOrigin());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        writeThread.start();
        readThread.start();

        writeThread.join();
        readThread.join();
    }
}
