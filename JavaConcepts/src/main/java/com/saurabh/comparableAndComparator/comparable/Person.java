package com.saurabh.comparableAndComparator.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Use Comparable when:
    There is one obvious “natural” order (e.g., numbers, dates, names, IDs).

    You’re okay with that order being the default everywhere.

    You control the class code and can modify it.

    Comparable is simpler to implement for basic sorting needs.
    Sorting rule is defined within the class itself by implementing the compareTo() method.
 */
public class Person implements Comparable<Person>{
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Saurabh", 30);
        Person p2 = new Person("John", 25);
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        Collections.sort(people);
        for (Person p : people) {
            System.out.println(p.name + " - " + p.age);
        }
        System.out.println(p1.compareTo(p2)); // Output: 1 (since 30 > 25)
    }
}
