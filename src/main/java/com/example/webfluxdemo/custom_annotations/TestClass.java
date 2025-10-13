package com.example.webfluxdemo.custom_annotations;

public class TestClass {

  @Description(author = "John Doe", description = "Testing method")
  @Description(author = "Richard Roe", description = "Repeatable description", version = 1)
  public void testMethod() {
    System.out.println("The method to test the @Description annotation");
  }


}
