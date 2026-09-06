package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//@ComponentScan
public class AppConfig {

    @Bean
    public UserService createUserService(@Qualifier("sms") NotificationService notificationService){
        return new UserService(notificationService);
    }
    @Bean
    @Primary
    public EmailService createEmailService(){
        return new EmailService();
    }

    @Bean
    @Qualifier("sms")
    public SmsService createSmsService(){
        return new SmsService();
    }

}
