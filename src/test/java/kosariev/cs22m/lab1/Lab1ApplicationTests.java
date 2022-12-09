package kosariev.cs22m.lab1;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Lab1ApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	public void checkGetAllStudents() {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/test/students", String.class)).contains("passportSeries");
	}

	@Test
	@Order(2)
	public void getStudentWithId() {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/test/student/1", String.class)).contains("Test");
	}

	@Test
	@Order(3)
	public void getStudentWithIdNegative() {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/test/student/1", String.class)).doesNotContain("Another");
	}

//	@Test
//	@Order(4)
//	public void deleteStudent() {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("id", "1");
//		this.restTemplate.delete("http://localhost:8080/test/student/1", params);
//	}
}
