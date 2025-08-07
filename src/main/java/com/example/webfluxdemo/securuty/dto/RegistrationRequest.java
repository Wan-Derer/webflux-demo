package com.example.webfluxdemo.securuty.dto;

public record RegistrationRequest (
    String username,
    String password,
    String authority
) {

}
