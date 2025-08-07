package com.example.webfluxdemo.securuty.service;

import com.example.webfluxdemo.securuty.model.AppUserAdapter;
import com.example.webfluxdemo.securuty.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AppUserDetailsServiceImpl implements ReactiveUserDetailsService {

  private final AppUserRepository appUserRepo;

  @Override
  public Mono<UserDetails> findByUsername(String username) {
    return appUserRepo.findUserByUsername(username)
      .switchIfEmpty(Mono.error(new UsernameNotFoundException("User '" + username + "' not found")))
      .map(AppUserAdapter::new);
  }


}
