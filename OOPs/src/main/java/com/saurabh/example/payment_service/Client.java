package com.saurabh.example.payment_service;

public class Client {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService();
        ps.addPaymentMethod("Saurabh's Debit card", new DebitCard("Saurabh Mishra", "1213123"));
        ps.addPaymentMethod("rahul's credit Card", new CreditCard("rahul", "12312321"));

        ps.addPaymentMethod("anjali's upi id", new UPI("id_qwew"));
        ps.addPaymentMethod("SaurabhWallet", new Wallet());

        ps.makePayment("Saurabh's Debit card");
        ps.makePayment("rahul's credit Card");
        ps.makePayment("anjali's upi id");
        ps.makePayment("SaurabhWallet");

    }
}
