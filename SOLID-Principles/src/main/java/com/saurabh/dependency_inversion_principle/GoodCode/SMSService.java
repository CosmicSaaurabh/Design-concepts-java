package com.saurabh.dependency_inversion_principle.GoodCode;

public class SMSService implements NotificationChannel{
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
