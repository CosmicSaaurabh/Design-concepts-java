package com.saurabh.builderDesignPattern.following;

public class Client {
    public static void main(String[] args) {
        House house = new House.HouseBuilder("Concrete", "Wood", "Tile")
                .setGarden(true)
                .setSwimmingPool(true)
                .build();

        System.out.println(house);
    }
}
