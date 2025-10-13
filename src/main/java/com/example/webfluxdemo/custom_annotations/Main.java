package com.example.webfluxdemo.custom_annotations;

public class Main {
  public static void main(String[] args) {
    // Creating processor object
    DescriptionProcessor processor = new DescriptionProcessor();
    // Creating test object with annotated method
    TestClass test = new TestClass();
    // Call processing method
    processor.printDescription(test);
  }
}
