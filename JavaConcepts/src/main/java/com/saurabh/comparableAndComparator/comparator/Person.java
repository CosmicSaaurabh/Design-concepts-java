package com.saurabh.comparableAndComparator.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person p1 = new Person("Saurabh", 30);
        Person p2 = new Person("Alice", 25);
        Person p5 = new Person("Michael", 28);
        Person p3 = new Person("John", 28);
        Person p4 = new Person("Bob", 35);

        System.out.println(p1);
        System.out.println(p2);


        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        // comparator implementation using anonymous class or lambda and it is a functional interface
        Comparator<Person> byAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        };

        Comparator<Person> byName = (o1, o2) -> o1.name.compareTo(o2.name);

        Comparator<Person> byAgeThenName =
                Comparator.comparingInt(Person::getAge)
                        .thenComparing(Person::getName);

        Collections.sort(people, byAge);

        System.out.println("Sorted by age:");
        for (Person p : people) {
            System.out.println(p);
        }

        Collections.sort(people, byName);
        System.out.println("Sorted by name:");
        for (Person p : people) {
            System.out.println(p);
        }

        Collections.sort(people, byAgeThenName);
        System.out.println("Sorted by age then name:");
        for (Person p : people) {
            System.out.println(p);
        }

    }
}
