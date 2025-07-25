package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Item;
import com.example.webfluxdemo.service.MainService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

  private static final Logger log = LoggerFactory.getLogger(MainController.class);
  private final MainService mainService;
  private final ApplicationContext context;


  @GetMapping
  public Flux<Item> getList() {
    return Flux.just(
            "First",
            "Second",
            "Third",
            "Fourth"
        )
        .map(Item::new)
        ;
  }


  @GetMapping("normal")
  public Flux<Item> getNormal() {
    return mainService.getNormal();
  }

  @GetMapping("error")
  public Flux<Item> getError() {
    return mainService.getError();
  }


  @GetMapping("stop")
  public Mono<String> stopApp() {

    new Thread(() -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      log.info("Stopping application by '/stop' endpoint");
      SpringApplication.exit(context);
    }).start();

    return Mono.just("STOP");
  }

}
