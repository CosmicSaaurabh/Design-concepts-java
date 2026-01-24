package com.saurabh.implementation1;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheStorage<K, V> {
    private final CacheConfig config;
    private final Map<K,V> storage;
    private final Deque<K> lruOrder; // to maintain LRU order

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final Lock lruLock = new ReentrantLock();

    public CacheStorage(CacheConfig config) {
        this.config = config;
        storage = new HashMap<>();
        lruOrder = new LinkedList<>();
    }

    private void updateLRUOrder(K key) {
        lruLock.lock();

        try {
            lruOrder.remove(key);
        } finally {
            lruLock.unlock();
        }
    }

    public V get(K key) {
        readLock.lock();
        V value;
        try {
            // get the value of the key from map and update the LRU order as a single transaction
            value = storage.get(key);
            updateLRUOrder(key);
        } finally {
            readLock.unlock();
        }
        return value;
    }

    public void put(K key, V value) {
        writeLock.lock();
        try {
            if (storage.containsKey(key)) {
                storage.put(key, value);
            } else {
                if (storage.size() >= config.capacity()) {
                    // evict the least recently used item
                    K lruKey = lruOrder.removeLast();
                    storage.remove(lruKey);
                    System.out.println("Evicted key: " + lruKey);
                }
                storage.put(key, value);
            }
            // update the LRU order
            updateLRUOrder(key);
        } finally {
            writeLock.unlock();
        }
    }

    public V remove(K key) {
        writeLock.lock();
        V value;
        try {
            value = storage.remove(key);
            lruOrder.remove(key);
        } finally {
            writeLock.unlock();
        }
        return value;
    }

    public int size() {
        return storage.size();
    }
}
