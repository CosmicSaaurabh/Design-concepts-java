package com.saurabh.implementation1;

public class ParkingSpot {
    String spotNumber;
    boolean isFree;

    public boolean isSpotFree() {
        return isFree;
    }

    public void occupySpot() {
        isFree = true;
    }

    public void releaseSpot() {
        isFree = false;
    }
}
