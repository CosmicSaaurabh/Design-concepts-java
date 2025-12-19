package com.saurabh.open_closed_principle.GoodCode;

public class CreditCardPayment implements PaymentType{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of amount: " + amount);
    }
}
