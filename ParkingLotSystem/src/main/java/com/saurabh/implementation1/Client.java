package com.saurabh.implementation1;

import com.saurabh.implementation1.parkingInfra.*;
import com.saurabh.implementation1.parkingPricing.CostComputation;
import com.saurabh.implementation1.parkingPricing.FixedPrice;
import com.saurabh.implementation1.parkingSpotManager.ParkingSpotManager;
import com.saurabh.implementation1.parkingSpotManager.TwoWheelerSpotManager;
import com.saurabh.implementation1.parkingSpotStrategy.ParkingSpotLookUpStrategy;
import com.saurabh.implementation1.parkingSpotStrategy.RandomSpotLookUpStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Client
{
    public static void main( String[] args )
    {

        ParkingSpotLookUpStrategy strategy = new RandomSpotLookUpStrategy();
        Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();
        levelOneManagers.put(VehicleType.BIKE,
                new TwoWheelerSpotManager(Arrays.asList(new ParkingSpot("L1-S1"),
                        new ParkingSpot("L1-S2")), strategy));

        levelOneManagers.put(VehicleType.CAR,
                new TwoWheelerSpotManager(Arrays.asList(new ParkingSpot("L1-S3"),
                        new ParkingSpot("L1-4")), strategy));

        ParkingLevel level1 = new ParkingLevel(
                1, levelOneManagers
        );


        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();

        levelTwoManagers.put(VehicleType.BIKE,
                new TwoWheelerSpotManager(Arrays.asList(new ParkingSpot("L2-S1"),
                        new ParkingSpot("L2-S2")), strategy));

        levelTwoManagers.put(VehicleType.CAR,
                new TwoWheelerSpotManager(Arrays.asList(new ParkingSpot("L2-S3"),
                        new ParkingSpot("L2-S4")), strategy));

        ParkingLevel level2 = new ParkingLevel(
                2, levelTwoManagers
        );

        ParkingBuilding parkingBuilding = new ParkingBuilding(Arrays.asList(level1, level2));

        ParkingLot parkingLot = new ParkingLot(
                parkingBuilding,
                new EntryGate(2),
                new ExitGate(1, new CostComputation(new FixedPrice()))
        );


        Vehicle bike = new Vehicle("BIKE-101", VehicleType.BIKE);
        Vehicle car = new Vehicle("CAR-201", VehicleType.CAR);

        Ticket t1 = parkingLot.vehicleArrives(bike);
        if (t1 == null) {
            System.out.println("No spot left");
        }

        System.out.println(t1);

        Ticket t2 = parkingLot.vehicleArrives(car);
        if (t2 == null) {
            System.out.println("No spot left");
        }

        System.out.println(t2);
        if (t1 != null) parkingLot.vehicleExits(t1);
        if (t2 != null) parkingLot.vehicleExits(t2);

    }
}
