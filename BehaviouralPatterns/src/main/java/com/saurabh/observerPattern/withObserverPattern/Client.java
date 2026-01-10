package com.saurabh.observerPattern.withObserverPattern;

public class Client {
    public static void main(String[] args) {
        DisplayDevice ledDevice = new DisplayDevice("my_display_device");
        MobileDevice mobileDevice = new MobileDevice("my_mobile_device");

        WeatherStation weatherStation = new WeatherStation();
        weatherStation.attach(ledDevice);
        weatherStation.attach(mobileDevice);

        weatherStation.setTemperature(10);
        weatherStation.setTemperature(20);
        weatherStation.setTemperature(30);

    }
}
