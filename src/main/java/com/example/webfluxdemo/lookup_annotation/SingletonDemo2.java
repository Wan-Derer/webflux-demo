package com.example.webfluxdemo.lookup_annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SingletonDemo2 {

  private final ObjectProvider<PrototypeDemo> prototypeDemoProvider;


  public void getProto() {
    PrototypeDemo pd = prototypeDemoProvider.getObject();
    pd.whyAmI();
  }
}
