package com.saurabh.implementation1.parkingPricing;

import com.saurabh.implementation1.Ticket;

public class CostComputation {
    private final PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double getCost(Ticket ticket) {
        return pricingStrategy.calculateCost(ticket);
    }
}
