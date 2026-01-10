package com.saurabh.momentoPattern.GraphicEditorExample;


import javax.swing.text.AsyncBoxView;
import java.util.Scanner;

/*
        Graphic Editor Application Exercise
        You are designing a graphic editor application that enables users to create and manipulate various shapes,
        such as circles, squares, and rectangles. Each shape has attributes, including:

        1. Position (x, y)
        2. Color
        3. Size

        Users should be able to modify these attributes. Additionally, implement an undo feature that allows users
        to revert any changes made to a shape's attributes.

        Task:
        Implement the undo feature for shape attribute changes using the Memento Design Pattern ensuring that
        your solution is flexible enough to easily incorporate new shapes or attributes in the future
        while maintaining the ability to revert all changes.
 */
public class Client {
    // Do not modify the run method. It is designed to gather user input and manage shape states.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GraphicEditor graphicEditor = new GraphicEditor();
        Caretaker caretaker = new Caretaker();

        for (int i = 0; i < 3; i++) {
            String shape = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            String color = sc.next();
            int size = sc.nextInt();

            // TODO: Update the graphic editor with the new shape attributes from user input.

            graphicEditor.setShape(shape, x, y, color, size);
            System.out.println(graphicEditor.getShape());

            // TODO: Save the current state of the graphic editor to the history
            caretaker.saveState(graphicEditor);
        }
        sc.close();
        System.out.println(graphicEditor.getShape());
        // TODO: Implement the undo operation to revert to the previous shape state
        caretaker.undo(graphicEditor);

        // TODO: Output the current shape attributes after the undo operation to verify the restored state.
        System.out.println(graphicEditor.getShape());

    }
}
