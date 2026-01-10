// The Caretaker class manages the history of shape states, allowing for saving and undoing changes in the Memento pattern.

package com.saurabh.momentoPattern.GraphicEditorExample;

import java.util.Stack;

public class Caretaker {

    private final Stack<EditorMemento> history = new Stack<>();

    public void saveState(GraphicEditor graphicEditor) {
        history.push(graphicEditor.save());
    }

    public void undo(GraphicEditor graphicEditor){
        if(!history.isEmpty()) {
            history.pop();
            graphicEditor.restore(history.peek());
        }
    }
}
