/*
    ISP - Ensure that a class should not be forced to implement method of interfaces which it does not use.
    * Interface Segregation Principle (ISP) violation example.
    * A simple printer is forced to implement methods it does not use.
 */

package com.saurabh.interface_segregation_principle.BadCode;

public class SimplePrinter implements Machine {
    @Override
    public void print(Document doc) {
        // Printing logic
    }

    // clear violation of ISP, should not be forced to implement
    @Override
    public void scan(Document doc) {
        throw new UnsupportedOperationException("Scan not supported");
    }

    @Override
    public void fax(Document doc) {
        throw new UnsupportedOperationException("Fax not supported");
    }
}
