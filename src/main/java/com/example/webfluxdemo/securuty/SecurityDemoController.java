package com.example.webfluxdemo.securuty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

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

}
