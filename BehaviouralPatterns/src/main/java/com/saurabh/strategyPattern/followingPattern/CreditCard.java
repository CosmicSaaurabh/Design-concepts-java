package com.saurabh.strategyPattern.followingPattern;

public class CreditCard implements PaymentStrategy {
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing payment via credit card and amount is: " + amount);
    }
}
