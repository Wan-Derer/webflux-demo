package com.example.webfluxdemo.securuty.repository;

import com.example.webfluxdemo.securuty.model.AppUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface AppUserRepository extends R2dbcRepository<AppUser, Integer> {
  Mono<AppUser> findUserByUsername(String username);

}
