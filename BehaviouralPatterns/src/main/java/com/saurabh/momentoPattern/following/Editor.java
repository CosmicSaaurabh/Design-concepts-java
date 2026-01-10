package com.saurabh.momentoPattern.following;


// It is called originator, it has method to save current text as a snapshot
// Originator have a dependency relationship with momento class ie editor momento
public class Editor {
    private String text = "";
    private History history = new History();
    public void write (String newText) {
        text += newText;
        history.push(new EditorMomento(text));
    }

    public void undo() {
        EditorMomento last = history.pop();
        if (last != null) text = last.getText();
        else text = "Nothing to undo";
    }

    public String getText() {
        return text;
    }

}
