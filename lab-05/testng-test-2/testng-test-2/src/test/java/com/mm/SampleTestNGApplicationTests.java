package com.mm;

import com.example.EmailGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(locations = {"classpath:spring-test-config2.xml"})
public class SampleTestNGApplicationTests extends AbstractTestNGSpringContextTests {

	@Autowired
	EmailGenerator emailGenerator;

	@Test()
	void testEmailGenerator() {

		String email = emailGenerator.generate();
		System.out.println(email);

		Assert.assertNotNull(email);
		Assert.assertEquals(email, "random2.email@ddd.com");


	}


}
