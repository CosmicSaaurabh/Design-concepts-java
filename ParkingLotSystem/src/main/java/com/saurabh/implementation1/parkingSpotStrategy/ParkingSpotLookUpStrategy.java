package com.saurabh.implementation1.parkingSpotStrategy;

import com.saurabh.implementation1.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookUpStrategy {
    ParkingSpot selectSpot(List<ParkingSpot> parkingSpotList);
}
