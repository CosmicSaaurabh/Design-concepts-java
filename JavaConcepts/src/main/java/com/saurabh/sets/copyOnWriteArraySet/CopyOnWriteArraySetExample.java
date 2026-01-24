package com.saurabh.sets.copyOnWriteArraySet;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        // keep insertion order and is thread-safe
        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("Saurabh");
        set.add("John");
        set.add("Alice");

        System.out.println("CopyOnWriteArraySet contains: " + set);
        for (String name : set) {
            System.out.println("Name: " + name);
        }
    }
}
