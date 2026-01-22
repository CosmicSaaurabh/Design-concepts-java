package com.saurabh.decoratorDesignPattern.following;

public class CheeseDecorator extends PizzaDecorator{
    CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return decoratedPizza.getDescription() + " with cheese";
    }

    public double getCost() {
        return decoratedPizza.getCost() + 20;
    }
}
