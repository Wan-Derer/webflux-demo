package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.Model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class MainController {

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


}
