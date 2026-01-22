package com.saurabh.decoratorDesignPattern.notFollowing;

public class CheesePizza extends BasicPizza{
    @Override
    public String getDescription() {
        return super.getDescription() + " with Cheese topping";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }
}
