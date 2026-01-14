package com.saurabh.abstractClass;

import java.util.List;

public class TheaterBookingManager extends BookingManager{
    TheaterBookingManager(List<Seat> seatsList) {
        super(seatsList);
    }
}
