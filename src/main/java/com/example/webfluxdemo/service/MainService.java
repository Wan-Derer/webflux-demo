package com.example.webfluxdemo.service;

import com.example.webfluxdemo.Model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MainService {

  public Flux<Item> getNormal() {
    return Flux.just("First", "Second", "Third", "Fourth")
      .map(Item::new);
  }

  public Flux<Item> getError(){
    return Flux.create(sink -> {
      sink.error(new Exception("ERROR!!!"));
    });
  }


}
