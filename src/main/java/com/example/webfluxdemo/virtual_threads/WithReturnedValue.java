package com.example.webfluxdemo.virtual_threads;

import java.util.concurrent.CompletableFuture;

public class WithReturnedValue {

  public static void main(String[] args) throws InterruptedException {
    CompletableFuture<String> future = new CompletableFuture<>();
    future.thenAccept(System.out::println);
    doOnThread(future);

    while (!future.isDone()) {
      System.out.println("wait...");
    }

  }

  private static void doOnThread(CompletableFuture<String> future) {
    Thread.ofVirtual()
      .name("VT example")
      .start(() -> future.complete(Thread.currentThread().toString()));
  }

}
