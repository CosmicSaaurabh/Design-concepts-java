package com.saurabh.implementation1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CacheStorageRe<K, V> {
    private final int capacity;
    private final Map<K, V> storage;
    private final Deque<K> lruOrder; // to maintain LRU order

    private final Lock lruLock = new ReentrantLock();

    public CacheStorageRe(int capacity) {
        this.capacity = capacity;
        storage = new ConcurrentHashMap<>();
        lruOrder = new ConcurrentLinkedDeque<>();
    }

    private void updateLRUOrder(K key) {
        lruOrder.remove(key);
        lruOrder.addFirst(key);
    }

    private void evictOne() {
        if (!lruOrder.isEmpty()) {
            K lruKey = lruOrder.removeLast();
            storage.remove(lruKey);
            System.out.println("Evicted key: " + lruKey);
        }
    }

    public V get(K key) {
        V value = storage.get(key);
        if (value != null) {
            // update LRU order
            lruLock.lock();
            try {
                updateLRUOrder(key);
            } finally {
                lruLock.unlock();
            }
        }

        return value;
    }

    public void put(K key, V value) {
        // ConcurrentHashMap put is atomic
        if (storage.containsKey(key)) {
            storage.put(key, value);
        } else {
            if (storage.size() >= capacity) {
                // evict the least recently used item
                lruLock.lock();
                K lruKey;
                try {
                    evictOne();
                } finally {
                    lruLock.unlock();
                }
            }

            storage.put(key, value);
        }

        // update the LRU order
        lruLock.lock();
        try {
            updateLRUOrder(key);
        } finally {
            lruLock.unlock();
        }
    }
    public V remove(K key) {
        V value = storage.remove(key);
        lruLock.lock();
        try {
            lruOrder.remove(key);
        } finally {
            lruLock.unlock();
        }
        return value;
    }
}
