package com.saurabh.example.payment_service;

public class UPI implements PaymentMethod{

    private String upiId;

    UPI(String Id) {
        upiId = Id;
    }
    @Override
    public void pay() {
        System.out.println("Making payment via upi with UPI id: " + upiId);
    }
}
