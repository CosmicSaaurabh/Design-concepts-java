package com.saurabh.adapterDesignPattern.followingPattern;

import com.saurabh.adapterDesignPattern.notFollowing.NotificationService;
import com.saurabh.adapterDesignPattern.notFollowing.SendGridNotificationService;

public class SendGridAdapter implements NotificationService {
    private SendGridNotificationService sendGridNotificationService;
    public SendGridAdapter() {
        this.sendGridNotificationService = new SendGridNotificationService();
    }
    @Override
    public void send(String message, String sendToEmail) {
        // Adapt SendGrid's API to match the NotificationService interface
        sendGridNotificationService.sendEmail(sendToEmail, "Notification", message);
    }
}
