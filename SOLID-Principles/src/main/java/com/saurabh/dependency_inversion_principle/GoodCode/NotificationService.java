package com.saurabh.dependency_inversion_principle.GoodCode;

public class NotificationService {
    private NotificationChannel notificationChannel;
    public NotificationService (NotificationChannel channel) {
        this.notificationChannel = channel;
    }
    public void  sendNotification(String message) {
        notificationChannel.send(message);
    }
}
