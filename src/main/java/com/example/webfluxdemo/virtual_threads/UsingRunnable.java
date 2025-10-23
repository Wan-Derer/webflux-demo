package com.example.webfluxdemo.virtual_threads;

public class UsingRunnable {

  public static void main(String[] args) throws InterruptedException {

    Thread virtualThread = Thread.ofVirtual()
      .name("Virtual Thread")
      .unstarted(() -> System.out.println("Virtual thread: " + Thread.currentThread()));

    virtualThread.start();
    virtualThread.join();

  }
}
