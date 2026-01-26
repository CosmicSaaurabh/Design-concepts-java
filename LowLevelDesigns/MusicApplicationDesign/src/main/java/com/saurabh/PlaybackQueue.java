package com.saurabh;

import java.util.ArrayDeque;
import java.util.Deque;

public class PlaybackQueue {
    private final Deque<Song> nextSongs = new ArrayDeque<>();
    private volatile Song currentSongName; // prevent threads from saving it to thread cache, hence always read write from memory
    private PlaybackMode playbackMode = PlaybackMode.NORMAL;

    public void addNextSong(Song song) {
        nextSongs.addFirst(song);
    }

    public void addToEnd(Song song) {
        nextSongs.addLast(song);
    }

    public Song getNext() {
        return playbackMode == PlaybackMode.SHUFFLE ? shuffleNext() : nextSongs.pollFirst();
    }

    private Song shuffleNext() {
        // implement random shuffle
        return null;
    }

}
