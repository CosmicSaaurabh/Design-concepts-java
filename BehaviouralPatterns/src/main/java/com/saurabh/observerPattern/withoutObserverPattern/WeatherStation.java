package com.saurabh.observerPattern.withoutObserverPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherStation {
    private int temperature;
    private List<DisplayDevice> displayDevice;

    public WeatherStation(List<DisplayDevice> device) {
        displayDevice = device;
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        notifyDevices();
    }
    // there is tight coupling between devices and weather station functionalities
    public void notifyDevices() {
        Iterator<DisplayDevice> iterator = displayDevice.iterator();
        while(iterator.hasNext()) {
            DisplayDevice device = iterator.next();
            device.showTemperature(temperature);
        }
    }
}
