package com.saurabh.sets.hashSet;

public class HashSet {
    public static void main(String[] args) {
        java.util.HashSet<String> names = new java.util.HashSet<>();
        names.add("Saurabh");
        names.add("John");
        names.add("Alice");
        names.add("Alice"); // Duplicate entry

        System.out.println("HashSet contains:" + names);
        boolean containsAlice = names.contains("Alice");
        System.out.println("Contains 'Alice': " + containsAlice);

        names.remove("Bob");
        System.out.println("After removal: " + names);
    }
}
