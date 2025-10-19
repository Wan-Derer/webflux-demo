package com.example.webfluxdemo.lookup_annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeDemo {

  public PrototypeDemo() {
    System.out.println(">>>>>>>>>>>>>> PrototypeDemo constructor: " + this.hashCode());
  }

  public void whyAmI(){
    System.out.println("<<<<<<<<<<<<<< PrototypeDemo whyAmI:      " + this.hashCode());
  }

}
