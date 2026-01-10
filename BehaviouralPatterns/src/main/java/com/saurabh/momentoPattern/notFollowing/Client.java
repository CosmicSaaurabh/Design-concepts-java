package com.saurabh.momentoPattern.notFollowing;

public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.write("Hello world");
        // - undo changes

        System.out.println(textEditor.read());

        textEditor.write(" i am saurabh");
        System.out.println(textEditor.read());
        textEditor.undo();
        textEditor.write(" i am Saurabh Mishra");
        System.out.println(textEditor.read());
        textEditor.undo();
        System.out.println(textEditor.read());
    }
}
