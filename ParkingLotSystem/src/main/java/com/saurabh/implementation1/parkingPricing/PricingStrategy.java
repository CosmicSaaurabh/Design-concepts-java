package com.saurabh.implementation1.parkingPricing;

import com.saurabh.implementation1.Ticket;

public interface PricingStrategy {
    double calculateCost(Ticket ticket);
}
