package com.saurabh.examples.downloader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Creating downloader threads
        Downloader downloader1 = new Downloader("file1.txt");
        Downloader downloader2 = new Downloader("file2.txt");
        Downloader downloader3 = new Downloader("file3.txt");
        Downloader downloader4 = new Downloader("file4.txt");
        Downloader downloader5 = new Downloader("file5.txt");

        Thread t1 = new Thread(downloader1);
        Thread t2 = new Thread(downloader2);
        Thread t3 = new Thread(downloader3);
        Thread t4 = new Thread(downloader4);
        Thread t5 = new Thread(downloader5);

        // Setting different thread names for better identification
        t1.setName("Downloader-1");
        t2.setName("Downloader-2");
        t3.setName("Downloader-3");
        t4.setName("Downloader-4");
        t5.setName("Downloader-5");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // TODO: Use the pauseDownload() method to simulate network latency after starting threads
        downloader1.pauseDownload();
        downloader2.pauseDownload();
        downloader3.pauseDownload();
        downloader4.pauseDownload();
        downloader5.pauseDownload();

        // Use join to ensure main thread waits for all download threads to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        // Indicate that all downloads are complete
        System.out.println("All downloads completed");
    }
}