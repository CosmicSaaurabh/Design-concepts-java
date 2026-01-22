package com.saurabh.adapterDesignPattern.notFollowing;

public class EmailNotificationService implements NotificationService{
    public void send(String message, String sendToEmail) {
        // Logic to send email
        System.out.println("Email sent to " + sendToEmail + " with message: " + message);
    }
}
