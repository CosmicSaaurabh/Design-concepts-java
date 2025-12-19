package com.saurabh.single_responsibility_principle.good_code;

public class EmailService {
    public void sendEmail(String to, String subject, String body) {
        // Logic to send email
        System.out.println("Email sent to " + to);
    }
}
