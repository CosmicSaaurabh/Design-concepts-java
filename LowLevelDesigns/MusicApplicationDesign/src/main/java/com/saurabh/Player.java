package com.saurabh;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class Player {
    private static Player playerInstance = null;
    Logger logger = Logger.getLogger(Player.class.toString());
    private final PlaybackQueue queue = new PlaybackQueue();
    private volatile PlaybackState state = PlaybackState.STOPPED;
    private final Queue<PlayerListener> listeners = new ConcurrentLinkedDeque<>();
    private volatile int position = 0; // in ms
    private volatile int volume = 4; // 10 is max, 0 is min

    public static Player getInstance() {
        if (playerInstance == null) {
            playerInstance = new Player();
        }

        return playerInstance;
    }

    public void play(Song song) {
        state = PlaybackState.PLAYING;
    }

    public void pause() {
        state = PlaybackState.PAUSED;
        notifyStateChanged();
    }

    public void playNext(Song song){
        // need to implement proper play next as if the queue is empty we can play the next song from playlist's next song
        Song nextSong = queue.getNext();
        play(nextSong);
        notifySongChanged(nextSong);
    }

    // Observer pattern: Notify ALL listeners
    private void notifyStateChanged() {
        notifyListeners(playerListener -> playerListener.onStateChanged(this));
    }

    private void notifySongChanged(Song song) {
        notifyListeners(playerListener -> playerListener.onSongChanged(song));
    }

    private void notifyPositionChanged(double position) {
        notifyListeners(PlayerListener -> PlayerListener.onPositionChanged(position));
    }

    // Generic notification (handles all event types)
    private void notifyListeners(Consumer<PlayerListener> action) {
        // ConcurrentLinkedQueue safe iteration
        for (PlayerListener listener : listeners) {
            try {
                action.accept(listener);
            } catch (Exception e) {
                // Don't let one observer crash others
                logger.info("Observer failed: " + listener);
            }
        }
    }

}
