package com.saurabh.observerPattern.withObserverPattern;

public class MobileDevice implements Observer{
    private String name;

    MobileDevice(String name) {
        this.name = name;
    }
    @Override
    public void update(int temperature) {
        System.out.println("Temperature in device: " + name + " is: " + temperature);
    }
}
