package com.saurabh.mediatorPattern.followingPattern;

import java.util.ArrayList;
import java.util.List;

public class AdminChatRoom implements ChatMediator {
    private List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public void sendMessage(String message, User userSending) {
        for (User user: userList) {
            if (user != userSending) user.receiveMessage(message, userSending);
        }
    }
}
