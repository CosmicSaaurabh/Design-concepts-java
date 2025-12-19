package com.saurabh.liskov_substitution_principle.GoodCode;

public class WritableFile extends ReadableFile implements Writable {

    @Override
    public void write() {
        System.out.println("Writing to writable file");
    }
}
