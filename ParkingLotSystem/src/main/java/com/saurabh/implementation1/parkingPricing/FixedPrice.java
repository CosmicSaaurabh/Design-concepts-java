package com.saurabh.implementation1.parkingPricing;

import com.saurabh.implementation1.Ticket;

public class FixedPrice implements PricingStrategy{
    @Override
    public double calculateCost(Ticket ticket) {
        return 100;
    }
}
