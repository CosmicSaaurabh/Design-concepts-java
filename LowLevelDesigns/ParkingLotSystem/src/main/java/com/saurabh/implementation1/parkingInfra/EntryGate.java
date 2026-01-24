package com.saurabh.implementation1.parkingInfra;

import com.saurabh.implementation1.Ticket;
import com.saurabh.implementation1.Vehicle;

public class EntryGate {
    private final int gateNumber;

    public EntryGate(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Ticket generateTicket(ParkingBuilding parkingBuilding, Vehicle vehicle) {
        Ticket ticket = parkingBuilding.allocate(vehicle);
        return ticket;
    }
}
