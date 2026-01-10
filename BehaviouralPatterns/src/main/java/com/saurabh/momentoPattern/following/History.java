package com.saurabh.momentoPattern.following;

import java.util.ArrayDeque;
import java.util.Deque;

// Care taker - managing the states - state manager - one responsibility ie manage states
// History have composition relationship with editor momento, it needs the Editor momento
public class History {
    private Deque<EditorMomento> history = new ArrayDeque<>();
    public void push(EditorMomento momento) {
        history.offerLast(momento);
    }

    public EditorMomento pop() {
        if (!history.isEmpty()) history.pollLast();
        EditorMomento lastMomento = null;
        if (!history.isEmpty()) lastMomento = history.peekLast();
        return lastMomento;
    }

    public EditorMomento last() {
        EditorMomento last = new EditorMomento("");
        if (!history.isEmpty()) last = history.peekLast();
        return last;
    }
}
