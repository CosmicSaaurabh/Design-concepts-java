package com.saurabh;

public class Song implements Comparable<Song>{
    private final String title;
    private final String artist;
    private final String album;
    private final int durationMs;

    public Song(String title, String artist, String album, int durationMs) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationMs = durationMs;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Song o) {
        return this.title.compareToIgnoreCase(o.title);
    }
}
