package com.saurabh.implementation1.parkingInfra;

import com.saurabh.implementation1.ParkingSpot;
import com.saurabh.implementation1.Ticket;
import com.saurabh.implementation1.Vehicle;

import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel> parkingLevelList;

    public ParkingBuilding(List<ParkingLevel> parkingLevelList) {
        this.parkingLevelList = parkingLevelList;
    }

    Ticket allocate(Vehicle vehicle) {
        Ticket ticket = null;
        for (ParkingLevel parkingLevel: parkingLevelList){
            if (parkingLevel.hasAvailability(vehicle.getVehicleType())) {
                ParkingSpot spot = parkingLevel.park(vehicle.getVehicleType());
                ticket = new Ticket(spot, vehicle, parkingLevel);
            }
        }

        return ticket;
    }

    void release(Ticket ticket) {
        ticket.getParkingLevel().unPark(ticket.getSpot(), ticket.getVehicle().getVehicleType());
    }

}
