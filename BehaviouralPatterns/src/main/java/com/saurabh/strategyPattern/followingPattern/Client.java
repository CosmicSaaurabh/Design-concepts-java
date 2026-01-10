package com.saurabh.strategyPattern.followingPattern;

public class Client {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
        DebitCard debitCard = new DebitCard();
        PayPal payPal = new PayPal();
        PaymentService service = new PaymentService(debitCard, 10);
        service.pay();
    }
}

