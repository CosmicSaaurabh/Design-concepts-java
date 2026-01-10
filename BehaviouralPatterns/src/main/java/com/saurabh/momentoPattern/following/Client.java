package com.saurabh.momentoPattern.following;

public class Client {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.write("Hello,");
        System.out.println(editor.getText());

//        editor.save();

        editor.write(" World!");
        System.out.println(editor.getText());
//        editor.save();

        editor.undo();
        System.out.println(editor.getText());

        editor.write(" Saurabh Mishra");
        System.out.println(editor.getText());
//        editor.save();

        editor.undo();
        System.out.println(editor.getText());

        editor.undo();
        System.out.println(editor.getText());

        editor.undo();
        System.out.println(editor.getText());
    }
}
