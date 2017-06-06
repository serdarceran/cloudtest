package com.example;

import com.exampl2.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

//@ActiveProfiles({"integration"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class},
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoTestingApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		String message = restTemplate.getForObject("/hi", String.class);
		Assert.assertEquals("Message From Fake Service::Message From Real Service 2", message);
	}

}
