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
            synchronized (System.out) {
                System.out.println(Thread.currentThread().getName() + " - Starting download: " + fileName);
            }
            // TODO: Add a loop that simulates the download in steps, using sleep to indicate progress
            // TODO: Synchronize the output of each progress step to prevent overlap
            for (int i = 0; i < 100; i++) {
                synchronized (System.out) {
                    System.out.println("Downloading " + i + "% complete - " + fileName);
                }
                Thread.sleep(10);
            }

            synchronized (System.out) {
                System.out.println(Thread.currentThread().getName() + " - Completed download: " + fileName);
            }
        } catch (InterruptedException e) {
            synchronized (System.out) {
                System.out.println(Thread.currentThread().getName() + " - Download interrupted: " + fileName);
            }
        }
    }

    // TODO: Add a synchronized method called pauseDownload() that pauses the thread for 500ms
    public synchronized void pauseDownload() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}