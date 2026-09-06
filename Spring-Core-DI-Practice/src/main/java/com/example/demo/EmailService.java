package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
public class EmailService implements NotificationService{

    public void sendNotification(){
        System.out.println("Email Notification Sent Successfully ....");
    }
}
