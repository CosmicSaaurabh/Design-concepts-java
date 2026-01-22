package com.saurabh.decoratorDesignPattern.following;

public class OliveDecorator extends PizzaDecorator{
    OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return decoratedPizza.getDescription() + " with olives";
    }

    public double getCost() {
        return decoratedPizza.getCost() + 50;
    }
}
