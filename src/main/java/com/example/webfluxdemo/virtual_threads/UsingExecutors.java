package com.example.webfluxdemo.virtual_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutors {

  public static void main(String[] args) {
    try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 10; i++) {
        es.submit(() -> System.out.println(Thread.currentThread()));
      }
    }

  }

}
