package com.saurabh.strategyPattern.withoutFollwingStrategyPattern;


// if we want to add another payment type then we have modified this class PaymentService ie add an else if condition to check for payment type and call pay method
// which is also breaking open-closed principle
// it is also breaking single responsibility principle as it have multiple responsibility ie deciding the payment type and processing payment
public class PaymentService {
    public void processPayment(String paymentType) {
        if (paymentType.toLowerCase() == "CreditCard".toLowerCase()) {
            System.out.println("Making payment via credit card");
        } else if (paymentType.toLowerCase() == "DebitCard".toLowerCase()) {
            System.out.println("Making payment via debit card");
        } else {
            System.out.println("Payment type not supported");
        }
    }
}
