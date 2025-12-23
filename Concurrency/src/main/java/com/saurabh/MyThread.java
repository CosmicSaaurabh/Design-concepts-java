package com.saurabh;

public class MyThread extends Thread {
    private int count = 0;

    public MyThread(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i  < 5; i++) {
            increment();
            System.out.println("Thread " + getName() + " - Count: " + count);
            try {
                Thread.sleep(1000); // Simulate some work with sleep
            } catch (InterruptedException e) {
                System.out.println("Thread " + getName() + " was interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread(3);
        MyThread thread2 = new MyThread(100);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Both threads have finished execution.");
    }

}
