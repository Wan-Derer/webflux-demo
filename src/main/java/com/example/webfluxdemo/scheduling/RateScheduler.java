/*
https://hyperskill.org/learn/step/28125
 */

package com.example.webfluxdemo.scheduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@EnableAsync // enables async methods
public class RateScheduler {
    private final AtomicInteger counter = new AtomicInteger(0);

    @Scheduled(fixedRate = 1000)
    @Async
    public void greetUser() throws InterruptedException {
        final int num = counter.incrementAndGet();
        System.out.println("Task " + num + " started!");
        Thread.sleep(2000);
        System.out.println("Task " + num + " completed!");
    }








}
