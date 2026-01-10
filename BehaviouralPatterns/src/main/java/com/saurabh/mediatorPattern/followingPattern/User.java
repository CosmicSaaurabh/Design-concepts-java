package com.saurabh.mediatorPattern.followingPattern;

public class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public void sendMessage(String message, ChatMediator mediator) {
        System.out.println("Sending message :- " + message + " by user: " + name);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message, User user) {
        System.out.println("Received message :- " + message + " from user: " + user.getName() + " to user: " + name);
    }

    public String getName() {
        return name;
    }
}
