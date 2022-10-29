package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void checkTestDataJson() {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/test/data/json", String.class)).contains("HHHH");
	}

	@Test
	public void checkTestDataParamsOneTwo() {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/test/data/params/1?second=2", String.class)).isEqualTo("12");
	}
}
