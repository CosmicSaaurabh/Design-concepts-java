package com.saurabh.linkedList;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> name = new LinkedList<>();
        name.add("Saurabh");
        name.add("John");
        name.add("Alice");

        System.out.println("LinkedList contains: " + name);

        for (String n : name) {
            System.out.println("Name: " + n);
        }

    }
}
