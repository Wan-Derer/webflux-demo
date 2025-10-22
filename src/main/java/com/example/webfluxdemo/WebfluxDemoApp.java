/*
https://devanswers.ru/deploy-ru/heroku-bolshe-ne-besplaten-poetomu-ya-nauchu-vas-kak-razvernut-vashi-servisy-spring-boot-na-rendercom-s-pomoshchyu-maven-i-docker/
https://youtu.be/g4kQ3ELo49Y
 */

package com.example.webfluxdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableScheduling
@RequiredArgsConstructor
public class WebfluxDemoApp {

//  private final Iface iFaceImpl;

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(WebfluxDemoApp.class, args);

  }


//  @Bean
//  public CommandLineRunner runner() {
//    return args -> {
//      System.out.println(
//          iFaceImpl.getName()
//      );
//    };
//  }

//  @Bean
//  public CommandLineRunner runner() {
//    return args -> {
//      TextEncryptor textEncryptor = hexEncodingTextEncryptor();
//
//      String inputData = "helloHELLO!";
//      String encryptedData = textEncryptor.encrypt(inputData);
//      String decryptedData = textEncryptor.decrypt(encryptedData);
//
//      System.out.println("========================");
//      System.out.println("Input data: " + inputData);
//      System.out.println("Encrypted data: " + encryptedData);
//      System.out.println("Decrypted data: " + decryptedData);
//      System.out.println("========================");
//
//    };
//  }
//
//  @Bean
//  public BytesEncryptor aesBytesEncryptor() {
//    String password = "hackme"; // should be kept in a secure place and not be shared
//    String salt = "8560b4f4b3"; // should be hex-encoded with even number of chars
//    return Encryptors.standard(password, salt);
//  }
//
//  @Bean
//  public TextEncryptor hexEncodingTextEncryptor() {
//    String password = "hackme"; // should be kept in a secure place and not be shared
////    String salt = "8560b4f4b3"; // should be hex-encoded with even number of chars
//    String salt = KeyGenerators.string().generateKey();
//    System.out.println(">>>>>>>>> " + salt);
//    return Encryptors.text(password, salt);
//  }




}
