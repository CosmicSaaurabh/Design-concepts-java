package com.saurabh.mediatorPattern.followingPattern;

public class Client {
    public static void main(String[] args) {
        ChatMediator adminChatRoom = new AdminChatRoom();
        ChatMediator localChatRoom = new LocalChatRoom();

        User saurabh = new User("saurabh");
        User anjali = new User("anjali");
        User sweta = new User("sweta");
        User seetu = new User("seetu");

        adminChatRoom.addUser(saurabh);
        adminChatRoom.addUser(sweta);

        localChatRoom.addUser(seetu);
        localChatRoom.addUser(anjali);

        saurabh.sendMessage("Hello, How are you?", adminChatRoom);
        seetu.sendMessage("I love you Anjali", localChatRoom);
    }
}

