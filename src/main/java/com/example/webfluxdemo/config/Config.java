package com.example.webfluxdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${impl}")
    private String impl;

    @Bean
    public Iface getIface(){
        if("i1".equals(impl)){
            return new Impl1();
        } else {
            return new Impl2();
        }
    }



}
