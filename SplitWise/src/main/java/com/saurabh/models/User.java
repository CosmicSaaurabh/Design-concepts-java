package com.saurabh.models;

public class User {
    private final String userId;
    private final String name;
    private final String bio;

    public User(String userId, String name, String bio) {
        this.userId = userId;
        this.name = name;
        this.bio = bio;
    }
}
