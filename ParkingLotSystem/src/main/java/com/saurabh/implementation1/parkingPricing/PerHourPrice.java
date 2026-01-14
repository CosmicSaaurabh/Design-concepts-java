package com.saurabh.implementation1.parkingPricing;

import com.saurabh.implementation1.Ticket;

import java.time.LocalDateTime;

public class PerHourPrice implements PricingStrategy{
    private final int perHourPrice = 10;

    private int calculateHour(LocalDateTime entryTime) {
        int hours = LocalDateTime.now().getHour() - entryTime.getHour();
        if (hours == 0) hours = 1;
        return hours;
    }

    @Override
    public double calculateCost(Ticket ticket) {
        return calculateHour(ticket.getEntryTime()) * perHourPrice;
    }
}
