package com.saurabh.interface_segregation_principle.BadCode;

public class MultiPurposePrinter implements Machine{
    @Override
    public void print(Document doc) {

    }

    @Override
    public void scan(Document doc) {

    }

    @Override
    public void fax(Document doc) {

    }
}
