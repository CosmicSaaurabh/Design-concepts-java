package com.saurabh.examples.producer_consumer_problem;

public class Main {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }


        System.out.println("Production and Consumption completed.");

    }
}
