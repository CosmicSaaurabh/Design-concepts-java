package com.saurabh.single_responsibility_principle.bad_code;

public class InvoiceNotFollowing {
    double amount;

    public InvoiceNotFollowing(double amount) {
        this.amount = amount;
    }

    // multiple responsibilities in a single class
    public void GenerateInvoicePDF() {
        System.out.println("Generating PDF invoice for amount: " + amount);
    }

    // multiple responsibilities in a single class
    public void SaveToDatabase() {
        System.out.println("Saving invoice of amount " + amount + " to database.");
    }

    // multiple responsibilities in a single class
    public void sendInvoiceEmail() {
        System.out.println("Sending invoice email for amount: " + amount);
    }
}
