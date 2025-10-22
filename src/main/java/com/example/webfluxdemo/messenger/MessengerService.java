package com.example.webfluxdemo.messenger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MessengerService {
    private final Set<Messenger> messengers;

    public void sendAll(){
        messengers.forEach(msgr -> {
            System.out.println(">>>>>>>>>>>>>>>>>> " + msgr.getClass().getSimpleName());
            msgr.send();
        });
    }

}
