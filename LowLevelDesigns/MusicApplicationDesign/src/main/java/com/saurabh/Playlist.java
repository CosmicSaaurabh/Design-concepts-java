package com.saurabh;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Playlist {
    private final int name;
    List<Song> songList = new CopyOnWriteArrayList<>();

    public Playlist(int name) {
        this.name = name;
    }

    public void addSong(Song song) { songList.add(song); }
    public void removeSong(Song song) { songList.remove(song); }
    public List<Song> getSongList() { return this.songList; }

}
