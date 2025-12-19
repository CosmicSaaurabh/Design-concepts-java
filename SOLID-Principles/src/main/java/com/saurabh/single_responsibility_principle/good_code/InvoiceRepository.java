package com.saurabh.single_responsibility_principle.good_code;


// purpose of this class is to handle all database operations related to Invoice
public class InvoiceRepository {
    public void saveToDatabase(InvoiceFollowing invoice) {
        // Logic to save invoice to database
        System.out.println("Invoice saved to database.");
    }
}
