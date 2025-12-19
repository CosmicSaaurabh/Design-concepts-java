package com.saurabh.open_closed_principle.GoodCode;

public class PaymentProcessor {
    public void processPayment(PaymentType paymentType, double amount) {
        paymentType.processPayment(amount);
    }
}
