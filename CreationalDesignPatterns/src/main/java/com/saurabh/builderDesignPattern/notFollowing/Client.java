package com.saurabh.builderDesignPattern.notFollowing;

public class Client {
    public static void main(String[] args) {
        House house = new House("concrete", "wood", "shingles", true, false);
//        House house = new House("concrete", "wood"); // create another constructor
        // Difficult to understand and main the code

        System.out.println(house.toString());
    }
}
