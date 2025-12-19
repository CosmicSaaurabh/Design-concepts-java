package com.saurabh.liskov_substitution_principle.GoodCode;

public class Main {
    public static void ReadAnyFile(ReadableFile file) {
        file.read();
    }
    public static void main(String[] args) {
        ReadableFile read_file1 = new ReadableFile();
        read_file1.read();

        // this is following Liskov Substitution Principle, as if we replace
        // ReadableFile with WritableFile or ReadOnlyFile, it will still work fine.
        WritableFile writableFile = new WritableFile();
        writableFile.read();
        writableFile.write();

        ReadableFile readOnlyFile = new ReadOnlyFile();
        readOnlyFile.read();

        ReadAnyFile(read_file1);
        ReadAnyFile(writableFile);
        ReadAnyFile(readOnlyFile);

    }
}
