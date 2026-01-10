package com.saurabh.momentoPattern.following;

// stores the snapshot of the text or content
class EditorMomento {
    private String text;

    EditorMomento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
