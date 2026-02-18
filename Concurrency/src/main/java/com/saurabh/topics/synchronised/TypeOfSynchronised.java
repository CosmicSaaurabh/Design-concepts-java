package com.saurabh.topics.synchronised;

public class TypeOfSynchronised {
    int count = 0;
    static int staticMember = 0;
    // synchronised method
    public synchronized void increment() {
        count++;
    }

    // static synchronised with lock the whole class
    public static synchronized void staticMethod() {
        // Critical section
        // only static member can be updated
        staticMember++;
    }

    // synchronised block inside the method
    public void increment1() {
        synchronized (this) {
            count++;
        }
    }

    // synchronised block inside static method
    public static void staticMethod1() {
        // Synchronize on the class itself to ensure that this block is
        // accessed by only one thread at a time across all instances
        synchronized (TypeOfSynchronised.class) {
            // Critical section
        }
    }
}
