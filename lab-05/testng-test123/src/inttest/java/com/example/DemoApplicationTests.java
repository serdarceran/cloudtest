package com.example;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class DemoApplicationTests extends AbstractTestNGSpringContextTests {

	@Test
	public void contextLoads() {
		System.out.println("Integration test is executed.");
	}

}
