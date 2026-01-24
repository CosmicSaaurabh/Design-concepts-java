package com.saurabh.sets.linkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // keeps insertion order
        Set<String> names = new LinkedHashSet<>();
        names.add("Saurabh");
        names.add("John");
        names.add("Alice");
        names.add("Bob"); // Duplicate entry
        System.out.println("LinkedHashSet contains: " + names);
        boolean containsAlice = names.contains("Alice");
        System.out.println("Contains 'Alice': " + containsAlice);

        names.remove("Bob");
        System.out.println("After removal: of Bob " + names);

    }
}
