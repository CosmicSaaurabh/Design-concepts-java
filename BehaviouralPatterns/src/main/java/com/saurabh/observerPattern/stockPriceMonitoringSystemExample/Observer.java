package com.saurabh.observerPattern.stockPriceMonitoringSystemExample;

public interface Observer {
    void update(String stockSymbol, double newPrice);
}