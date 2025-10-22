package com.example.webfluxdemo.messenger;

import org.springframework.stereotype.Component;

@Component
public class MessengerSms implements Messenger {
    @Override
    public void send() {
        System.out.println("==================== SMS");
    }

}
