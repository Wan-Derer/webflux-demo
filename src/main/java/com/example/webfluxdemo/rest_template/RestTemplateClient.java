package com.example.webfluxdemo.rest_template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateClient {


  public void getPosts() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/posts";

    ResponseEntity<List<Post>> response = restTemplate.exchange(
      url,
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<>() {
      });

    List<Post> posts = response.getBody();
    posts.forEach(System.out::println);

  }

  public Post getPost(int postId) {
    RestTemplate restTemplate = new RestTemplate();
    String apiUrl = "https://jsonplaceholder.typicode.com/posts/{id}";

    Map<String, String> params = new HashMap<>();
    params.put("id", String.valueOf(postId));

    ResponseEntity<Post> response = restTemplate.getForEntity(apiUrl, Post.class, params);

//    HttpStatusCode statusCode = response.getStatusCode();
//    System.out.println(statusCode);
//
//    HttpHeaders headers = response.getHeaders();
//    headers.forEach((key, value) -> System.out.println(key + ": " + value));

    return response.getBody();
  }


  public Post createPost(){
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/posts";

    Post post = new Post(null, 1, "Title", "Description");

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Post> request = new HttpEntity<>(post, headers);
    ResponseEntity<Post> response = restTemplate.postForEntity(url, request, Post.class);

    return response.getBody();
  }

  public Post updatePost(Post newPost){
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/posts/" + newPost.id();

//    Map<String, String> params = new HashMap<>();
//    params.put("id", String.valueOf(newPost.id()));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Post> request = new HttpEntity<>(newPost, headers);
    ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.PUT, request, Post.class);

    return response.getBody();
  }

  public HttpStatusCode deletePost(int postId) {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/posts/" + postId;

    ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    return response.getStatusCode();
  }

}


