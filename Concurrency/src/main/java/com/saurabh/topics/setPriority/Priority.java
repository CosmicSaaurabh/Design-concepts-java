package com.saurabh.topics.setPriority;

public class Priority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            System.out.println("This is high priority task");
        });

        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(() -> {
            System.out.println("This is a low priority task");
        });
        t2.setPriority(Thread.MIN_PRIORITY);

        Thread t3 = new Thread(()-> {
            System.out.println("This is a norm priority task");
        });
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
