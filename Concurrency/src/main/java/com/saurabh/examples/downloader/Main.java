package com.saurabh.examples.downloader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Creating downloader threads
        Thread t1 = new Thread(new Downloader("file1.txt"));
        Thread t2 = new Thread(new Downloader("file2.txt"));
        Thread t3 = new Thread(new Downloader("file3.txt"));

        // Setting different thread names for better identification
        t1.setName("Downloader-1");
        t2.setName("Downloader-2");
        t3.setName("Downloader-3");

        // Setting different priorities to illustrate effect on scheduling (optional, depends on JVM)
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        // Use join to ensure main thread waits for all download threads to finish
        t1.join();
        t2.join();
        t3.join();

        // Indicate that all downloads are complete
        System.out.println("All downloads completed");
    }
}