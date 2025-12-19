package com.saurabh.open_closed_principle.GoodCode;

public class Main {

    public static void main(String[] args) {
        PaymentType credicardPayment = new CreditCardPayment();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(credicardPayment, 1000.0);
    }
}
