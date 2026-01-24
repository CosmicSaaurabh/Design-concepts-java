package com.saurabh.implementation1;

import java.util.concurrent.atomic.AtomicLong;

public class Cache<K, V>{

    private  final CacheConfig config;
    CacheStorage<K, V> cacheStorage;
    private final AtomicLong hits = new AtomicLong();
    private final AtomicLong misses = new AtomicLong();

    public Cache(CacheConfig config) {
        this.config = config;
        this.cacheStorage = new CacheStorage<>(config);
    }

    public V get(K key) {
        V value = cacheStorage.get(key);
        if (value != null) {
            hits.incrementAndGet();
        } else {
            misses.incrementAndGet();
        }

        return value;
    }

    public void put(K key, V value) {
        cacheStorage.put(key, value);
    }
    public void remove(K key) {
        cacheStorage.remove(key);
    }
    public long getMisses() {
        return misses.get();
    }

    public long getHits() {
        return hits.get();
    }

    public int getCacheSize() {
        return this.cacheStorage.size();
    }
}
