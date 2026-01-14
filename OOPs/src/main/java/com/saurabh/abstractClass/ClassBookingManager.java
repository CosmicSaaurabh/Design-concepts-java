package com.saurabh.abstractClass;

import java.util.List;

public class ClassBookingManager extends BookingManager{
    ClassBookingManager(List<Seat> seatsList) {
        super(seatsList);
    }
}
