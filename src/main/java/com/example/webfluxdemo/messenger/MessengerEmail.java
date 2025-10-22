package com.example.webfluxdemo.messenger;

import org.springframework.stereotype.Component;

@Component
public class MessengerEmail implements Messenger {
    @Override
    public void send() {
        System.out.println("==================== EMAIL");
    }
}
