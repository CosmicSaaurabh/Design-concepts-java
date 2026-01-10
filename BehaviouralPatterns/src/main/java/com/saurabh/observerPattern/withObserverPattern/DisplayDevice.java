package com.saurabh.observerPattern.withObserverPattern;

public class DisplayDevice implements Observer{
    private String name;

    DisplayDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println("Temperature in Device: " + name + " is: " + temperature);
    }
}
