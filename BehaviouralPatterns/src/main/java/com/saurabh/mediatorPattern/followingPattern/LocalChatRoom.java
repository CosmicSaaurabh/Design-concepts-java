package com.saurabh.mediatorPattern.followingPattern;

import java.util.ArrayList;
import java.util.List;

public class LocalChatRoom implements ChatMediator{
    private List<User> users = new ArrayList<>();
    @Override
    public void sendMessage(String message, User userSending) {
        for (User user: users) {
            if (user != userSending) user.receiveMessage(message, userSending);
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
