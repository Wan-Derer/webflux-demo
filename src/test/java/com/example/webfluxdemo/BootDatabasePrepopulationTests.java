package com.example.webfluxdemo;

/*

https://hyperskill.org/learn/step/27304
 */

import com.example.webfluxdemo.securuty.model.AppUser;
import com.example.webfluxdemo.securuty.repository.AppUserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

@ActiveProfiles("test")
@DataR2dbcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Sql({"/schema.sql", "/data.sql"})
public class BootDatabasePrepopulationTests {

  @Autowired
  private AppUserRepository appUserRepo;

  @Test
  @Order(1)
  public void fillingTableTest() {
    System.out.println(">>>>>>>>>");

    StepVerifier.create(
        appUserRepo.save(new AppUser(null, "another test user", null, null))
          .then(appUserRepo.findAll().count())
      )
      .expectNext(2L)
      .verifyComplete();
  }

  @Test
  @Order(2)
  public void fillingTableTest2() {
    System.out.println("<<<<<<<<<<");
    StepVerifier.create(appUserRepo.findAll().count())
      .expectNext(2L)
      .verifyComplete();
  }


}
