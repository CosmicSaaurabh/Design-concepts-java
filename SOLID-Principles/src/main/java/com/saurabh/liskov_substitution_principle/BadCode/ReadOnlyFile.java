package com.saurabh.liskov_substitution_principle.BadCode;

public class ReadOnlyFile extends File{
    @Override
    public void read() {
        System.out.println("Reading from read-only file");
    }

    @Override
    public void write() {
        throw new UnsupportedOperationException("Cannot write to a read-only file");
    }
}
