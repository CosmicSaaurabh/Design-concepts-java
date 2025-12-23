package com.saurabh.producer_consumer_problem;

public class Producer extends Thread {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(10); // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
