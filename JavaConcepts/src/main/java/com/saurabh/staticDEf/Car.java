package com.saurabh.staticDEf;

/*
    Static members belong to the class (shared across all objects), not individual instances.
    They're loaded once when the class is first referenced, saving memory for shared data/utilities
 */
public class Car {
    static int totalCar = 0;

    Car() {
        totalCar++;
    }

    public static int getTotalCar() {
        return totalCar;
    }
}

