package com.saurabh.adapterDesignPattern;

import com.saurabh.adapterDesignPattern.followingPattern.SendGridAdapter;
import com.saurabh.adapterDesignPattern.notFollowing.EmailNotificationService;
import com.saurabh.adapterDesignPattern.notFollowing.NotificationService;
import com.saurabh.adapterDesignPattern.notFollowing.SendGridNotificationService;

public class Client {
    public static void main(String[] args) {
        // we have to send notification
//        NotificationService notificationService = new EmailNotificationService();
//        SendGridNotificationService sendGridNotificationService = new SendGridNotificationService();
//        notificationService.send("Hello Saurabh", "2bsaurabh@gmail.com");
//        sendGridNotificationService.sendEmail("2bsaurabh@gmail.com", "Greetings", "Hello Saurabh");


        NotificationService sendEmailViaSendGrid = new SendGridAdapter();
        NotificationService notificationService = new EmailNotificationService();
        sendEmailViaSendGrid.send("Hello via SendGrid Adapter", "2bsaurabh@gmail.com");
        notificationService.send("Hello via EmailNotificationService", "2bsaurabh@gmail.com");

    }
}
