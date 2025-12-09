package com.saurabh.example.payment_service;

public class DebitCard extends Card {
    DebitCard(String cardNumber, String cardName) {
        super(cardNumber, cardName);
    }

    @Override
    public void pay() {
        System.out.println("Making payment via Debit card");
    }
}
