package com.saurabh.momentoPattern.notFollowing;


import java.util.ArrayDeque;
import java.util.Deque;

/*
    A Text Editor where users can undo changes, such as text addition deletion of formatting. The editor
    stores snapshots of its state (text content) after each change, enabling users to revert to the previous state.
    it is exploting Single responsibility principle.

    In the TextEditor example, undo holds full String copies of text. Any code accessing the editor instance can indirectly read or
    even manipulate these list (if made public or via reflection), exposing internals broadly.
    Methods like saveState() duplicate private data openly, breaking the "black box" principle—clients know and handle the exact state format ("String text"),
    risking mismatches if text changes internally.
 */
public class TextEditor {
    private StringBuilder content = new StringBuilder();
    public Deque<String> state = new ArrayDeque<>();

    public void write(String text) {
        content.append(text);
        state.offerLast(content.toString());
    }

    public void undo() {
        if (!state.isEmpty()) state.pollLast();
        if (!state.isEmpty()) content = new StringBuilder(state.peekLast());
        else content = new StringBuilder();
    }

    public String read() {
        return content.toString();
    }
}
