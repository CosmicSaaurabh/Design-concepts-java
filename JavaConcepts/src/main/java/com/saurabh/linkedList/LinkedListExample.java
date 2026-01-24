package com.saurabh.linkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> name = new LinkedList<>();
        name.add("Saurabh");
        name.add("John");
        name.add("Alice");

        System.out.println("LinkedList contains: " + name);

        for (String n : name) {
            System.out.println("Name: " + n);
        }

    }
}
