package com.saurabh.factoryDesignPattern.following;

public class Client {
    public static void main(String[] args) {
        Transport vehicle = TransportFactory.createTransport("car");
        vehicle.deliver();
    }
}
