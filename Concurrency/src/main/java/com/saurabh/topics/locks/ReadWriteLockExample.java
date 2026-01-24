package com.saurabh.topics.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
    ReadWriteLock allows multiple threads to read a resource concurrently (shared access)
    while ensuring exclusive access for write operations. This is particularly useful in scenarios
    where reads are more frequent than writes, as it improves concurrency and performance.

    Key Features:
    - Multiple readers can hold the read lock simultaneously.
    - Only one writer can hold the write lock at a time, blocking all other readers and writers.
    - Writers have exclusive access to the resource.

    Use Cases:
    - Caches where data is read frequently but updated infrequently.
    - Configuration settings that are read often but changed rarely.
    - Any scenario with a high read-to-write ratio.

    When to Use:
    - When read operations significantly outnumber write operations.
    - When you want to improve performance by allowing concurrent reads.
*/
class ReadMostlyCache {
    private Map<String, String> cache = new HashMap<>();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();

    public String get(String key) {
        rLock.lock();
        try {
            return cache.get(key);
        } finally {
            rLock.unlock();
        }
    }

    public String put(String key, String value) {
        wLock.lock();
        try {
            return cache.put(key, value);
        } finally {
            wLock.unlock();
        }
    }

}

public class ReadWriteLockExample {
    public static void main(String[] args) throws InterruptedException {
        ReadMostlyCache cache = new ReadMostlyCache();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println(cache.get("key1"));

        Thread reader1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Reader 1: " + cache.get("key1"));
            }

        });

        Thread reader2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Reader 2: " + cache.get("key2"));
            }
        });

        Thread writer = new Thread(() -> {
            String newValue = "newValue1" + System.currentTimeMillis();
            cache.put("key1", newValue);
            System.out.println("Writer updated key1");
            try {
                Thread.sleep(10000); // Simulate some delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        reader1.start();
        reader2.start();
        writer.start();

        reader1.join();
        reader2.join();
        writer.join();
    }
}
