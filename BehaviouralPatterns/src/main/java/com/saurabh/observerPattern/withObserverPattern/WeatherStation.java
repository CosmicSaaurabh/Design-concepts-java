package com.saurabh.observerPattern.withObserverPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherStation implements Subject{
    private int temperature;
    private List<Observer> observerList = new ArrayList<>();

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObserver();
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        Iterator<Observer> iterator = observerList.listIterator();
        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update(temperature);
        }
    }
}
