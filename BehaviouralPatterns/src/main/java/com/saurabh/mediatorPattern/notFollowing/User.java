package com.saurabh.mediatorPattern.notFollowing;

public class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public void sendMessage(String message, User recipient) {
        System.out.println("Sendin message: " + message + " to user: " + recipient.getName());
    }

    public String getName() {
        return name;
    }

}
