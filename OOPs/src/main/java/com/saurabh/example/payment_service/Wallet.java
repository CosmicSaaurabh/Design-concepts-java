package com.saurabh.example.payment_service;

public class Wallet implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("We are paying via wallet");
    }
}
