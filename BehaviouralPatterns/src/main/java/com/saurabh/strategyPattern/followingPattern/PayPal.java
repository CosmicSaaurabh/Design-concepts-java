package com.saurabh.strategyPattern.followingPattern;

public class PayPal implements PaymentStrategy{
    @Override
    public void processPayment(int amount) {
        System.out.println("Making payment via paypal: " + amount);
    }
}
