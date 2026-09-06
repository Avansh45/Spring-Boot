package com.example.demo;

import org.springframework.stereotype.Component;;

//@Component
public class UserService {

    private NotificationService notification;

    UserService(NotificationService notification){
        this.notification = notification;
    }

    public void userNotificatiion(){

        notification.sendNotification();
        System.out.println("User Notification received ");
    }

}
