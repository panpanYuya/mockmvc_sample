package com.example.mockmvc_sample;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
// mockを自動で生成してくれるもの
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultMessage() throws Exception {
    // printを実行することでリクエストやレスポンスなどを出力してくれる
    this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, World")));
    System.out.println("test");
  }
}