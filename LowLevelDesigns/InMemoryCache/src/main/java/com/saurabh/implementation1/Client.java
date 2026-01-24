package com.saurabh.implementation1;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to In-Memory Cache Implementation!");
        CacheConfig config = new CacheConfig(10, Duration.ofMillis(10));

        Cache<String, String> cache = new Cache<>(config);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            int threadId = i;
            executorService.submit(()  -> {
                String key = "key" + threadId;
                String value = "value" + threadId;

                System.out.println("Thread " + threadId + " putting " + key + " -> " + value);
                cache.put(key, value);
                System.out.println("Currently cache size is: " + cache.getCacheSize());

                // Access cache multiple times
                for (int j = 0; j < 20; j++) {
                    String k = "key" + (j);
                    String cachedValue = cache.get(k);
                    System.out.println("Thread " + threadId + " got " + k + " -> " + cachedValue);
                }
            });
        }



        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Currently cache size is: " + cache.getCacheSize());
        System.out.println("Cache miss is: " + cache.getMisses());
        System.out.println("Cache hit is: " + cache.getHits());

    }
}
