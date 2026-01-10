package com.saurabh.strategyPattern.followingPattern;


// Strategy pattern is same as open-closed principle - same example is used in both principles
public class PaymentService {
    private PaymentStrategy paymentStrategy;
    private int amount;

    PaymentService(PaymentStrategy strategy, int amount)  {
        this.paymentStrategy = strategy;
        this.amount = amount;
    }

    public void pay() {
        paymentStrategy.processPayment(amount);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        paymentStrategy = strategy;
    }
}
