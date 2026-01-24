package com.saurabh.records;

/*
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override public boolean equals(Object o) {  }
    @Override public int hashCode() {  }
    @Override public String toString() {  }
}

*/

// instead of above person class we can write
record Person(String name, int age) {}

public class recordClass {
}
