package com.saurabh.producer_consumer_problem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();

    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer is full, producer is waiting...");
            wait();
        }

        buffer.offer(item);
        System.out.println("Produced: " + item);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while(buffer.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting...");
            wait();
        }

        int element = buffer.peek();
        buffer.poll();
        System.out.println("Consumed: " + element);
        notifyAll();
        return element;
    }
}
