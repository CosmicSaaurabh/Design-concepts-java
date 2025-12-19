package com.saurabh.dependency_inversion_principle.BadCode;

/*
    * In this example, NotificationService directly depends on concrete implementations of EmailService and SMSService.
    * This violates the Dependency Inversion Principle because high-level modules (NotificationService)
    * should not depend on low-level modules (EmailService, SMSService). Both should depend on abstractions.
    * To adhere to the DIP, we should introduce interfaces for EmailService and SMSService and have NotificationService depend on those interfaces instead.
 */

public class NotificationService {
    private EmailService emailService;
    private SMSService smsService;

    public NotificationService() {
        this.emailService = new EmailService();
        this.smsService = new SMSService();
    }

    public void sendEmailNotification(String message) {
        // Logic to send email using emailService
    }

    public void sendSMSNotification(String message) {
        // Logic to send SMS using smsService
    }
}
