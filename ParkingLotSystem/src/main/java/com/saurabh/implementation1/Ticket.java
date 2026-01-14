package com.saurabh.implementation1;

import java.time.LocalDateTime;

public class Ticket {
    private final ParkingSpot spot;
    String entryTime;

    public Ticket(ParkingSpot spot) {
        this.spot = spot;
        entryTime = LocalDateTime.now().toString();
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}
