package com.saurabh;

public interface PlayerListener {
    void onStateChanged(Player player);
    void onSongChanged(Song song);
    void onPositionChanged(double positionMs);
}
