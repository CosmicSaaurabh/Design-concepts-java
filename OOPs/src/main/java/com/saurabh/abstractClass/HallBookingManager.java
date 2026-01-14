package com.saurabh.abstractClass;

import java.util.List;

public class HallBookingManager extends BookingManager{
    HallBookingManager(List<Seat> seatsList) {
        super(seatsList);
    }
}
