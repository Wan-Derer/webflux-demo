package com.example.webfluxdemo.virtual_threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UsingCallable {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Callable<String> callable = () -> Thread.currentThread().toString();
    FutureTask<String> futureTask = new FutureTask<>(callable);

    Thread virtialThread = Thread.ofVirtual().start(futureTask);

    while (!futureTask.isDone()) {
      System.out.println("wait ...");
    }

    System.out.println(futureTask.get());

  }

}
