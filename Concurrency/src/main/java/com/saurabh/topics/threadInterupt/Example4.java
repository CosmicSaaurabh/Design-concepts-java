package com.saurabh.topics.threadInterupt;

public class Example4 {
    public static void main(String [] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        thread.interrupt();
        // Without handling InterruptedException properly inside the run method, ie returning a return statement
        // the thread will keep running even after being interrupted during sleep.
        // To properly handle the interrupt, we need to exit the run method when InterruptedException is caught.
    }

    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println("Thread was interrupted, exiting...");
//                        return;
//                    }
                    System.out.println("Thread is going to sleep...");
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted during sleep, exiting...");
                    return;
//                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
