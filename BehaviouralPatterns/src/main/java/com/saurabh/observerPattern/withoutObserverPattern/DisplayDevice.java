package com.saurabh.observerPattern.withoutObserverPattern;

// if we have different display devices of different types like mobile phone display or a screen display then we have to create
// each device and add to the list.
public class DisplayDevice {
    private String name;

    DisplayDevice(String name) {
        this.name = name;
    }

    public void showTemperature(int temperature) {
        System.out.println("Current temperature is in device: " + name +  " is: " + temperature);
    }
}
