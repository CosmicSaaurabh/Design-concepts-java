package com.saurabh.open_closed_principle.GoodCode;

public class DebitCardPayment implements PaymentType {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of amount: " + amount);
    }
}
