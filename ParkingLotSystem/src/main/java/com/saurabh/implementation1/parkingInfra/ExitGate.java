package com.saurabh.implementation1.parkingInfra;

import com.saurabh.implementation1.Ticket;
import com.saurabh.implementation1.parkingPricing.CostComputation;

public class ExitGate {
    private final int gateNumber;
    private final CostComputation costComputation;

    public ExitGate(int gateNumber, CostComputation costComputation) {
        this.gateNumber = gateNumber;
        this.costComputation = costComputation;
    }

    public void CompleteExit(ParkingBuilding building, Ticket ticket) {
        double cost = costComputation.getCost(ticket);
        // pay this cost;
        building.release(ticket);
    }
}
