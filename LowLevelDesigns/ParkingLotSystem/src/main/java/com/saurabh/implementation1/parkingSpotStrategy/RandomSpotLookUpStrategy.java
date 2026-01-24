package com.saurabh.implementation1.parkingSpotStrategy;

import com.saurabh.implementation1.ParkingSpot;
import com.saurabh.implementation1.parkingSpotManager.ParkingSpotManager;

import java.util.List;

public class RandomSpotLookUpStrategy implements ParkingSpotLookUpStrategy{
    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpotList) {
        for(ParkingSpot spot: parkingSpotList) {
            if(spot.isSpotFree()) return spot;
        }
        return null;
    }
}
