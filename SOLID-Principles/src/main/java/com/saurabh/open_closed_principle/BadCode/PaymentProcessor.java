package com.saurabh.open_closed_principle.BadCode;

public class PaymentProcessor {

    // if we want to add a new payment type, say UPI then we have to modify this class which is already tested and breaks the OCP
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CREDIT_CARD")) {
            // Logic to process credit card payment
        } else if (paymentType.equals("PAYPAL")) {

        } else if (paymentType.equals("BITCOIN")) {

        } else {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}
