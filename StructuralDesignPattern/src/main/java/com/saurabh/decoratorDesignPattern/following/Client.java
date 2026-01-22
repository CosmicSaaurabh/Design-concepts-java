package com.saurabh.decoratorDesignPattern.following;

public class Client {
    public static void main(String[] args) {
        // Basic Pizza
        Pizza pizza = new BasicPizza();
        System.out.println(pizza.getDescription() + " and Cost is: " + pizza.getCost());

        // Pizza with Cheese topping
        pizza = new CheeseDecorator(pizza);
        Pizza pizza2 = new MushroomDecorator(pizza);
        System.out.println(pizza.getDescription() + " and Cost is: " + pizza.getCost());

        // Pizza with Cheese and Olive toppings
        pizza = new OliveDecorator(pizza);
        pizza2 = new OliveDecorator(pizza2);
        System.out.println(pizza.getDescription() + " and  Cost is: " + pizza.getCost());

        System.out.println(pizza2.getDescription() + " and  Cost is: " + pizza2.getCost());
    }
}
