package com.example.webfluxdemo.mock_tests;

import com.example.webfluxdemo.util.WordRandomizer;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class WordRandomizerTest {

  @MockitoBean
  public WordRandomizer wordRandomizer;

  @Test
  void shouldReturnDefaultValues() {
    var randomWordsList1 = wordRandomizer.get3RandomWords();
    System.out.println("===> " + randomWordsList1);
    Mockito.when(wordRandomizer.get3RandomWords()).thenReturn(List.of("mock1", "mock2", "mock3"));
    var randomWordsList2 = wordRandomizer.get3RandomWords();
    System.out.println("===> " + randomWordsList2);
    String randomWord = wordRandomizer.getRandomWord();
    System.out.println("===> " + randomWord);

    System.out.println();
  }
}

