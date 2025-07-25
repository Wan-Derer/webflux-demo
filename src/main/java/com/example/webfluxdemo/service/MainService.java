package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Item;
import com.example.webfluxdemo.config.Iface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class MainService {

  List<String> strings = List.of("First", "Second", "Third", "Fourth");

  public Flux<Item> getNormal() {
    return Flux.fromIterable(strings)
      .map(Item::new);
  }

  public Flux<Item> getError(){
    return Flux.create(sink -> {

      strings.forEach(s -> sink.next(new Item(s)));

      sink.error(new Exception("ERROR!!!"));

      sink.next(new Item("Fifth"));

    });
  }


}
