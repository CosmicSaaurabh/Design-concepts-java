package com.saurabh.models;

public class Balance {
    int amount;
    String currency;
    public Balance(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
