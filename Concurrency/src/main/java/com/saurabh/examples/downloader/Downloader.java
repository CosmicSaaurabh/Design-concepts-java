package com.saurabh.examples.downloader;

import java.util.Random;

public class Downloader implements Runnable {
    private final String fileName;
    private final Random rnd;

    public Downloader(String fileName) {
        this.fileName = fileName;
        this.rnd = new Random();
    }

    @Override
    public void run() {
        try {
            synchronized (System.out) { // Synchronize output to prevent message overlap
                System.out.println(Thread.currentThread().getName() + " - Starting download: " + fileName);
            }
            Thread.sleep(rnd.nextInt(100) + 100); // Simulate time taken to download
            synchronized (System.out) {
                System.out.println(Thread.currentThread().getName() + " - Completed download: " + fileName);
            }
        } catch (InterruptedException e) {
            synchronized (System.out) {
                System.out.println(Thread.currentThread().getName() + " - Download interrupted: " + fileName);
            }
        }
    }
}