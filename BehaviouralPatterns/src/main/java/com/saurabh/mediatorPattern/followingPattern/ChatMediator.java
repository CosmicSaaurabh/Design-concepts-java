package com.saurabh.mediatorPattern.followingPattern;

public interface ChatMediator {
    void sendMessage(String message, User userSending);
    void addUser(User user);
}
