package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.Model.Item;
import com.example.webfluxdemo.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

  private final MainService mainService;

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
  public Flux<Item> getNormal(){
    return mainService.getNormal();
  }

  @GetMapping("error")
  public Flux<Item> getError(){
    return mainService.getError();
  }


}
