package com.saurabh.examples.producer_consumer_problem;

public class Consumer extends Thread{
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i  < 10; i++) {
            try {
                int x = buffer.consume();
                System.out.println("Working on consumed item: " + x);
                Thread.sleep(100); // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
