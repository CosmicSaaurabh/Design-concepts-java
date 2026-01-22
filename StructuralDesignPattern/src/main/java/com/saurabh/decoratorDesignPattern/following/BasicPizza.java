package com.saurabh.decoratorDesignPattern.following;

public class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "This is pizza";
    }

    @Override
    public double getCost() {
        return 100;
    }
}
