package com.saurabh.topics.join;

import static java.lang.Thread.sleep;

class MyThread extends Thread {
    String name;
    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Running + "  + name);
    }
}

class SecondThread implements Runnable{
    @Override
    public void run() {
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("We have completed after waiting...");
    }
}
public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread("thread-1");
        Thread thread2 = new Thread(new SecondThread());

        // main thread will wait for thread2 to complete before moving further that is starting the thread1
        // when we apply join to a thread, then main threads and wait till this thread completes its execution.
        thread2.start();
//        thread2.join();

        thread1.start();

    }
}
