package com.example.webfluxdemo.lookup_annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FromContext {

  private final ApplicationContext context;

  public void getBeanFromContext() {
    context.getBean(PrototypeDemo.class);
  }


}
