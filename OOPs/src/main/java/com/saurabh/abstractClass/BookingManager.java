package com.saurabh.abstractClass;

import java.util.List;

public abstract class BookingManager {
    List<Seat> seatsList;
    boolean isAvailableSeat;

    BookingManager(List<Seat> seatsList) {
        this.seatsList = seatsList;
    }

    public Seat BookSeat() {
        for (Seat seat: seatsList) {
            if (!seat.isOccupied()) {
                return seat;
            }
        }

        return null;
    }

}
