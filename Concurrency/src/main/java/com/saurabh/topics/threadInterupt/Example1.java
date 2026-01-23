package com.saurabh.topics.threadInterupt;

public class Example1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        try {
            Thread.sleep(3000); // Let the task run for a while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is interrupting the task thread.");
        thread.interrupt(); // Interrupt the task thread
    }

    public static class BlockingTask implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Task is running...");
                    Thread.sleep(1000); // Simulate work
                }
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted during sleep.");
                Thread.currentThread().interrupt(); // Preserve interrupt status
            }
        }
    }
}
