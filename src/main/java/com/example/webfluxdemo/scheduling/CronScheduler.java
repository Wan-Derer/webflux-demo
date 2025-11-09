/*
https://hyperskill.org/learn/step/28125
 */

package com.example.webfluxdemo.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {

    @Scheduled(cron="0 30 12 * * ?")
//    @Scheduled(cron="@daily")
    public void dailyUpdate() {
        System.out.println("========== Cron Scheduled for daily update");
    }



}
