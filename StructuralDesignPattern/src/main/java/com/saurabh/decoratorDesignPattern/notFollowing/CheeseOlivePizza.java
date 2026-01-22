package com.saurabh.decoratorDesignPattern.notFollowing;

public class CheeseOlivePizza extends CheesePizza{
    @Override
    public String getDescription() {
        return super.getDescription() + " and Olive topping";
    }

    @Override
    public double getCost() {
        return super.getCost() + 15;
    }
}
