package com.saurabh.sets.concurrentSkipListSet;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetExample {
    public static void main(String[] args) {
        // keep sorted order and is thread-safe
        ConcurrentSkipListSet<String> names = new ConcurrentSkipListSet<>();
        names.add("Saurabh");
        names.add("John");
        names.add("Alice");
        System.out.println("ConcurrentSkipListSet contains: " + names);

        for (String name : names) {
            System.out.println("Name: " + name);
        }

        names.remove("John");
        System.out.println("After removal: " + names);

    }
}
