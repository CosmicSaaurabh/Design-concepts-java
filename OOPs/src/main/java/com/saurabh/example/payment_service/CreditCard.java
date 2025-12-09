package com.saurabh.example.payment_service;

class CreditCard extends Card {
    CreditCard(String cardNumber, String cardName) {
        super(cardNumber, cardName);
    }

    @Override
    public void pay() {
        System.out.println("Making payment via credit card");
    }
}
