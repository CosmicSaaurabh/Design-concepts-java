package com.saurabh.topics.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
    Key features
        Reentrancy (like synchronized): same thread can acquire it multiple times.
        tryLock() – attempt to acquire without blocking.
        tryLock(timeout) – wait for some time.
        lockInterruptibly() – acquire but be interruptible.
        Can be fair: new ReentrantLock(true) gives roughly FIFO ordering.

    Use ReentrantLock when you need advanced features like:
    - tryLock() to attempt lock acquisition without blocking.
    - lockInterruptibly() to allow interruption while waiting for a lock.
    - Multiple condition variables for more complex thread coordination.

    When to use
        Advanced locking features (tryLock, timed waits, multiple conditions).
        You need more control over lock acquisition and release.
        You want to implement custom locking policies.

        This is perfect when:
        The critical section is long or complex.
        The shared state is large or involves multiple data structures.
        You need fine-grained control over thread interactions.

        So ReentrantLock is ideal when:
            You need to avoid deadlocks with tryLock() or timed waits.
            You want to separate lock acquisition from critical section execution.
            You require multiple condition variables for complex thread coordination.
            Need timed waits to avoid deadlock.
            Need non‑blocking try semantics:
            Need fairness when many threads contend.
            Implementing more complex concurrency structures.
 */
class IncrementDecrement implements Runnable {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        // or we can use tryLock with timeout to wait for sometimes to acquire the lock when locks is available
        // say lock.tryLock(100, TimeUnit.MILLISECONDS)
        if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
            try {
                counter--;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Could not acquire lock to decrement");
            // do something else
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }

        System.out.println("Counter after incrementing: " + getCounter());

        for (int i = 0; i < 1000; i++) {
            try {
                decrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}

/*
    ReentrantLock allows the same thread to acquire the lock multiple times without causing a deadlock.

        Fair vs non‑fair locking
    You can create a fair lock:

    ReentrantLock fairLock = new ReentrantLock(true);  // fairness = true
    Fair lock tries to give access in roughly FIFO order: threads acquire the lock in the order they requested it.
    Non‑fair lock (default) may “barge” and let a thread that just asked jump ahead; this often has better throughput under heavy contention.

    Intrinsic locks don’t offer explicit fairness control.
 */

class Service {
    private final ReentrantLock lock = new ReentrantLock(true); // fair lock

    public void outer() {
        lock.lock();
        try {
            inner();     // same thread calls another locked method
        } finally {
            lock.unlock();
        }
    }

    public void inner() {
        lock.lock();     // allowed: same thread re-enters
        try {
            // work
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLocks {
    public static void main(String[] args) throws InterruptedException {
        IncrementDecrement incrementDecrement = new IncrementDecrement();
        Thread incrementThread1 = new Thread(incrementDecrement);
        Thread incrementThread2 = new Thread(incrementDecrement);
        Thread incrementThread3 = new Thread(incrementDecrement);

        incrementThread1.start();
        incrementThread2.start();
        incrementThread3.start();

        incrementThread1.join();
        incrementThread2.join();
        incrementThread3.join();

        System.out.println("Final Counter Value: " + incrementDecrement.getCounter());
    }
}
