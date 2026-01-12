package com.saurabh.observerPattern.stockPriceMonitoringSystemExample;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String stockSymbol, double newPrice);
}