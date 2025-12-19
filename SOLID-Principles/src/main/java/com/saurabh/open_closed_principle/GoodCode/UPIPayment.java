package com.saurabh.open_closed_principle.GoodCode;

public class UPIPayment implements PaymentType{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of amount: " + amount);
    }
}
