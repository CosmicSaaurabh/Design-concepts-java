package com.saurabh.decoratorDesignPattern.notFollowing;

public class Client {
    public static void main(String[] args) {
        // Basic Pizza
        Pizza basicPizza = new BasicPizza();
        System.out.println(basicPizza.getDescription() + " and Cost is: " + basicPizza.getCost());

        // Pizza with Cheese topping
        Pizza cheesePizza = new CheesePizza();
        System.out.println(cheesePizza.getDescription() + " and Cost is: " + cheesePizza.getCost());

        // Pizza with Cheese and Olive toppings
        Pizza cheeseOlivePizza = new CheeseOlivePizza();
        System.out.println(cheeseOlivePizza.getDescription() + " and  Cost is: " + cheeseOlivePizza.getCost());

    }
}
