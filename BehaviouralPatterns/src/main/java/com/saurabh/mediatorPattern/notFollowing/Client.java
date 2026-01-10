package com.saurabh.mediatorPattern.notFollowing;

public class Client {
    public static void main(String[] args) {
        // each user needs to be aware of all other users to send messages
        User saurabh = new User("Rahul");
        User sweta = new User("Neha");
        User anjali = new User("Anjali");

        saurabh.sendMessage("Hello", anjali);
        saurabh.sendMessage("hi", sweta);
    }
}
