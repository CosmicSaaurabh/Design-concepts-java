package com.saurabh.implementation1;

public class ParkingSpot {
    private final String spotNumber;
    boolean isFree = true;

    public ParkingSpot(String spotNumber) {
        this.spotNumber = spotNumber;
    }

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
