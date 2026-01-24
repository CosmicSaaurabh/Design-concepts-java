package com.saurabh.implementation1.parkingSpotManager;

import com.saurabh.implementation1.ParkingSpot;

public interface ParkingSpotManager {
    ParkingSpot park();
    void unPark(ParkingSpot parkingSpot);
    boolean hasFreeSpot();
}
