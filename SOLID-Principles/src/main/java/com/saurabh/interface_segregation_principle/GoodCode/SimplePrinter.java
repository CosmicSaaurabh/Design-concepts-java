/*
    ISP (Interface Segregation Principle) states that no client should be forced to depend on methods it does not use.
    In this example, we have segregated the Printer interface into two smaller interfaces: Printer and Scanner.
    This way, classes that only need printing functionality can implement the Printer interface without being forced
    to implement scanning functionality.
 */
package com.saurabh.interface_segregation_principle.GoodCode;

public class SimplePrinter implements Printer{
    @Override
    public void print() {
        System.out.println("Printing document...");
    }
}
