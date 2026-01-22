package com.saurabh.decoratorDesignPattern.following;

public class MushroomDecorator extends PizzaDecorator{
    MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return decoratedPizza.getDescription() + " with mushrooms";
    }

    public double getCost() {
        return decoratedPizza.getCost() + 30;
    }
}
