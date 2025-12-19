package com.saurabh.single_responsibility_principle.good_code;

public class InvoiceFollowing {
    private Double amount;

    public InvoiceFollowing(Double amount) {
        this.amount = amount;
    }

    public void generateInvoice() {
        // Logic to generate invoice
        System.out.println("Invoice generated for amount: " + amount);
    }
}
