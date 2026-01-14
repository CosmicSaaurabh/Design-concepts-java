package com.saurabh.implementation1.parkingLevel;

import com.saurabh.implementation1.ParkingSpot;
import com.saurabh.implementation1.Vehicle;
import com.saurabh.implementation1.VehicleType;
import com.saurabh.implementation1.parkingSpotManager.ParkingSpotManager;

import java.util.Map;

// not following SIP
public class ParkingLevel {
    private final int levelNumber;
    private final Map<VehicleType, ParkingSpotManager> vehicleTypeParkingSpotManagerMap;

    private ParkingSpotManager getParkingSpotManager(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager = vehicleTypeParkingSpotManagerMap.get(vehicleType);
        if (parkingSpotManager == null) {
            throw new IllegalArgumentException("Vehicle type is unknown");
        }
        return parkingSpotManager;
    }

    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> vehicleTypeParkingSpotManagerMap) {
        this.levelNumber = levelNumber;
        this.vehicleTypeParkingSpotManagerMap = vehicleTypeParkingSpotManagerMap;
    }

    public boolean hasAvailability(VehicleType vehicleType) {
        ParkingSpotManager parkingSpotManager = getParkingSpotManager(vehicleType);
        return parkingSpotManager.hasFreeSpot();
    }

    public ParkingSpot park(VehicleType vehicleType) {
        ParkingSpot parkingSpot = null;
        ParkingSpotManager parkingSpotManager = getParkingSpotManager(vehicleType);
        if (parkingSpotManager.hasFreeSpot()) {
            parkingSpot = parkingSpotManager.park();
        }

        return parkingSpot;
    }

    public void unPark(ParkingSpot parkingSpot, VehicleType vehicleType) {
        ParkingSpotManager parkingSpotManager = getParkingSpotManager(vehicleType);
        parkingSpotManager.unPark(parkingSpot);
    }
}
