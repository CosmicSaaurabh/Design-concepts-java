package com.saurabh.observerPattern.withObserverPattern;

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);

    void notifyObserver();
}
