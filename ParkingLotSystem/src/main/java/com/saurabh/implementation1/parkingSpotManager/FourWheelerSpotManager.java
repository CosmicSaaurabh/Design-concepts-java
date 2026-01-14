package com.saurabh.implementation1.parkingSpotManager;

import com.saurabh.implementation1.ParkingSpot;
import com.saurabh.implementation1.parkingSpotStrategy.ParkingSpotLookUpStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FourWheelerSpotManager implements ParkingSpotManager{
    protected final List<ParkingSpot> parkingSpotList;
    protected final ParkingSpotLookUpStrategy parkingSpotLookUpStrategy;
    ReentrantLock lock = new ReentrantLock();

    public FourWheelerSpotManager(List<ParkingSpot> parkingSpotList, ParkingSpotLookUpStrategy parkingSpotLookUpStrategy) {
        this.parkingSpotList = parkingSpotList;
        this.parkingSpotLookUpStrategy = parkingSpotLookUpStrategy;
    }

    @Override
    public ParkingSpot park() {
        ParkingSpot parkingSpot = null;
        lock.lock();
        try {
            parkingSpot = parkingSpotLookUpStrategy.selectSpot(parkingSpotList);
            if (parkingSpot != null) parkingSpot.occupySpot();
        } finally {
            lock.unlock();
        }
        return parkingSpot;
    }

    @Override
    public void unPark(ParkingSpot parkingSpot) {
        lock.lock();
        try{
            parkingSpot.releaseSpot();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean hasFreeSpot() {
        for (ParkingSpot parkingSpot: parkingSpotList) {
            if (parkingSpot.isSpotFree()) {
                return true;
            }
        }

        return false;
    }
}
