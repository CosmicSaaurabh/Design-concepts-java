package com.saurabh.implementation1;

import com.saurabh.implementation1.parkingInfra.ParkingLevel;

import java.time.LocalDateTime;

public class Ticket {
    private final ParkingSpot spot;
    private final Vehicle vehicle;
    private final ParkingLevel parkingLevel;


    private final LocalDateTime entryTime;

    public Ticket(ParkingSpot spot, Vehicle vehicle, ParkingLevel parkingLevel) {
        this.spot = spot;
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        entryTime = LocalDateTime.now();
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "spot=" + spot +
                ", vehicle=" + vehicle +
                ", parkingLevel=" + parkingLevel +
                ", entryTime=" + entryTime +
                '}';
    }
}
