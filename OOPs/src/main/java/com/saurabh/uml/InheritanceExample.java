package com.saurabh.uml;

class Animal {
    public void eat() {
        System.out.println("Animal eats");
    }
}
class Dog extends Animal  {
    public void bark () {
        System.out.println("Dog barks");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.eat();
    }
}
