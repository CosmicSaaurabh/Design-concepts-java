package com.saurabh.observerPattern.withoutObserverPattern;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        DisplayDevice device1 = new DisplayDevice("Device1");
        DisplayDevice device2 = new DisplayDevice("Device2");
        DisplayDevice device3 = new DisplayDevice("Device3");

        WeatherStation station = new WeatherStation(Arrays.asList(device1, device2, device3));
        station.setTemperature(10);
        station.setTemperature(20);
    }
}
