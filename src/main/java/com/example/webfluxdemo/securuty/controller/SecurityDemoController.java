package com.example.webfluxdemo.securuty.controller;

import com.example.webfluxdemo.securuty.dto.RegistrationRequest;
import com.example.webfluxdemo.securuty.model.AppUser;
import com.example.webfluxdemo.securuty.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SecurityDemoController {

  private final AppUserRepository appUserRepo;
  private final PasswordEncoder passwordEncoder;


  @GetMapping("/public")
  public String getPublic() {
    return "Access to 'GET /public' granted";
  }

  @PostMapping("/public")
  public String postPublic() {
    return "Access to 'POST /public' granted";
  }

  @GetMapping("/secured")
  public String getSecured() {
    return "Access to 'GET /secured' granted";
  }

  @GetMapping("/user")
  public String getUser() {
    return "Access to 'GET /user' granted";
  }

  @GetMapping("/admin")
  public String getAdmin() {
    return "Access to 'GET /admin' granted";
  }

  @GetMapping("/test")
  public String getTest() {
    return "Access to 'GET /test' granted";
  }

  @PostMapping("/register")
  public Mono<ResponseEntity<String>> postRegister(@RequestBody RegistrationRequest request) {
    return appUserRepo.save(new AppUser(
        null, // ID должен быть null для автоинкремента
        request.username(),
        passwordEncoder.encode(request.password()),
        request.authority()))
      .map(savedUser -> ResponseEntity.status(HttpStatus.CREATED)
        .body("User '" + savedUser.id() + ": " + savedUser.username() + "' registered"))
      .onErrorResume(e -> {
        log.error("Error registering user", e);
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("Registration failed: " + e.getMessage()));
      });
  }

}
