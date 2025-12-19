package com.saurabh.dependency_inversion_principle.GoodCode;

public class Client {
    public static void main(String[] args) {
        NotificationChannel emailService  = new EmailService();
        NotificationService notificationService = new NotificationService(emailService);
        notificationService.sendNotification("Hello, this is a test notification!");

        NotificationService smsNotificationService = new NotificationService(new SMSService());
        smsNotificationService.sendNotification("Hello, this is a test notification!");

    }
}
