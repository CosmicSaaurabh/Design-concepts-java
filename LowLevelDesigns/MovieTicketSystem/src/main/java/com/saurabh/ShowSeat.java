package com.saurabh;

public class ShowSeat {
    private final Seat seat;
    private final double price;
    private final SeatType seatType;

    public ShowSeat(Seat seat, double price, SeatType seatType) {
        this.seat = seat;
        this.price = price;
        this.seatType = seatType;
    }
}
