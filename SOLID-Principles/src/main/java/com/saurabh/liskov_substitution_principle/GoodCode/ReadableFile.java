package com.saurabh.liskov_substitution_principle.GoodCode;

public class ReadableFile implements Readable {
    @Override
    public void read() {
        System.out.println("Reading from file");
    }
}
