package com.saurabh.decoratorDesignPattern.following;

abstract class PizzaDecorator implements Pizza {
    Pizza decoratedPizza;

    PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost();
    }
}
