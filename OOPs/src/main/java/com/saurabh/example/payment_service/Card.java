package com.saurabh.example.payment_service;

abstract class Card implements PaymentMethod{
    private String cardNo;

    private String cardName;

    public Card(String cardNo, String cardName) {
        this.cardName = cardName;
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getCardName() {
        return this.cardName;
    }
}