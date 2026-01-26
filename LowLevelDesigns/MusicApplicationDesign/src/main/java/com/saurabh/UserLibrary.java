package com.saurabh;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserLibrary {
    private List<Playlist> userListOfPlayList = new CopyOnWriteArrayList<>();
    private final User user;

    public UserLibrary(User user) {
        this.user = user;
    }

    public void addPlayList(Playlist playlist) { userListOfPlayList.add(playlist); }

    public void removePlayList(Playlist playlist) { userListOfPlayList.remove(playlist); }

    public List<Playlist> getUserListOfPlayList() { return userListOfPlayList; }
}
