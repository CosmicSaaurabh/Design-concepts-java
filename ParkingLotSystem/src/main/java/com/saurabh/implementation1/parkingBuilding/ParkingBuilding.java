package com.saurabh.implementation1.parkingBuilding;

import com.saurabh.implementation1.ParkingSpot;
import com.saurabh.implementation1.Ticket;
import com.saurabh.implementation1.Vehicle;
import com.saurabh.implementation1.parkingLevel.ParkingLevel;

import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel> parkingLevelList;

    public ParkingBuilding(List<ParkingLevel> parkingLevelList) {
        this.parkingLevelList = parkingLevelList;
    }

    public Ticket allocate(Vehicle vehicle) {
        ParkingSpot spot = null;
        for (ParkingLevel parkingLevel: parkingLevelList){
            if (parkingLevel.hasAvailability(vehicle.getVehicleType())) {
                spot = parkingLevel.park(vehicle.getVehicleType());
            }
        }

        if (spot != null) {
            return new Ticket(spot);
        }

        return null;
    }
}
