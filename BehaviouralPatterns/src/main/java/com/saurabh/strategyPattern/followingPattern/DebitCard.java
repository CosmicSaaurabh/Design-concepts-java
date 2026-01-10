package com.saurabh.strategyPattern.followingPattern;

public class DebitCard implements PaymentStrategy{

    @Override
    public void processPayment(int amount) {
        System.out.println("Processing payment via debit card with amount: " + amount);
    }
}
