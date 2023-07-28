package com.example.mockmvc_sample;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

  @Value(value = "${local.server.port}")
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void greetingShouldReturnDefaultMessage() throws Exception {
    // 統合テストに適した RestTemplate の便利な代替。TestRestTemplate はフォールトトレラントです。これは、4xx および 5xx
    // がスローされる例外にはならず、代わりに response entity およびその status code を介して検出できる
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
        String.class)).contains("Hello, World");
  }
}