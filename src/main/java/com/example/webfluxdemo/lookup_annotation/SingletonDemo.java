package com.example.webfluxdemo.lookup_annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonDemo {

  // Объявляем метод (может быть абстрактным!), который будет переопределен Spring'ом
  @Lookup
  public PrototypeDemo getPrototypeDemo() {
    // Эта реализация никогда не выполняется.
    // Spring предоставляет свою реализацию.
    System.out.println("===================== OLOLO!");
    return null;
  }


  public void getProto() {
    PrototypeDemo p1 = getPrototypeDemo();
    p1.whyAmI();
  }
}
