package com.example.webfluxdemo.rest_template;

/*
https://hyperskill.org/learn/step/25934
 */

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestTemplateDemo implements CommandLineRunner {

  private final RestTemplateClient client;


  @Override
  public void run(String... args) {

    Post post = client.getPost(1);
    System.out.println("=== Source:\n" + post);

    Post toUpdate = new Post(post.id(), post.userId(), "UPDATED", "updated");
    Post updated = client.updatePost(toUpdate);
    System.out.println("=== Updated:\n" + updated);

    HttpStatusCode code = client.deletePost(post.id());
    System.out.println("=== Deleted:\n" + code);

  }
}
