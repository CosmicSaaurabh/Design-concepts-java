package com.saurabh.abstractClass;

abstract class Shape {
    // abstract method
    abstract void draw();
}

// subclass of Shape
class Circle extends Shape {
    // overriding the draw() method
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

// subclass of Shape
class Rectangle extends Shape {
    // overriding the draw() method
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// main class
public class Main {
    public static void main(String[] args) {
// creating an object of Circle class
        Shape circle = new Circle();
// calling the draw() method on circle object
        circle.draw();
// creating an object of Rectangle class
        Shape rectangle = new Rectangle();
// calling the draw() method on rectangle object
        rectangle.draw();
    }
}