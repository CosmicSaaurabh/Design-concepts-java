package com.saurabh.interface_segregation_principle.GoodCode;

public class MultiPurposePrinter implements Printer, Scanner, Fax {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }

    @Override
    public void fax() {
        System.out.println("Faxing document...");
    }
}
