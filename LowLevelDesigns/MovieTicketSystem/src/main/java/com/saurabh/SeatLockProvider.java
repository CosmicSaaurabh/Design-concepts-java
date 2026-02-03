package com.saurabh;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SeatLockProvider {
    Map<Show, Map<Seat, SeatLock>> locks = new ConcurrentHashMap<>();

    public synchronized boolean checkIfSeatAvailable(List<Seat> seats, Show show) {
        return true;
    }

    public synchronized boolean lockSeat(List<Seat> seats, Show show, int timeOutInSeconds) {
        return true;
    }

    public synchronized boolean unLockSeat(List<Seat> seats, Show show) {
        return true;
    }
}
