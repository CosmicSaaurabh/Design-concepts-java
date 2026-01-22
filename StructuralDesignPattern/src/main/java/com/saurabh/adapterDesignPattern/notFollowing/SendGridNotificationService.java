package com.saurabh.adapterDesignPattern.notFollowing;

public class SendGridNotificationService {

    public void sendEmail(String receiver, String title, String body) {
        // Logic to send email via SendGrid
        System.out.println("SendGrid Email sent to " + receiver + " with title: " + title + " and body: " + body);

    }
}
