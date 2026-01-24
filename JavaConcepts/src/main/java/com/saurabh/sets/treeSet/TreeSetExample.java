package com.saurabh.sets.treeSet;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>();
        names.add("Saurabh");
        names.add("John");
        names.add("Alice");

        System.out.println("TreeSet contains: " + names);

        for (String name : names) {
            System.out.println("Name: " + name);
        }

        System.out.println(names.contains("Alice"));
        names.remove("John");
        System.out.println("After removal: " + names);
        System.out.println("Higer than Saurabh: " + names.higher("Saurabh"));
        System.out.println("Lower than Saurabh: " + names.lower("Saurabh"));
//        System.out.println(names.comparator().compare("Saurabh", "Alice"));

        System.out.println("Size is: " + names.size());

    }
}
