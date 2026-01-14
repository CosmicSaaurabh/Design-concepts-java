package com.saurabh.implementation1.parkingInfra;

import com.saurabh.implementation1.Ticket;
import com.saurabh.implementation1.Vehicle;

public class ParkingLot {
    private final ParkingBuilding building;
    private final EntryGate entranceGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding building, EntryGate entranceGate, ExitGate exitGate) {
        this.building = building;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle) {
        return entranceGate.generateTicket(building, vehicle);
    }

    public void vehicleExits(Ticket ticket) {
        exitGate.CompleteExit(building, ticket);
    }


}
