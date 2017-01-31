package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = "com")
public class Demotest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demotest1Application.class, args);
	}

	@Bean
	public MyService getCustomServicem() {
		return new MyCustomServicem();
	}

	@Component
	private class RunNow implements CommandLineRunner {

		@Autowired
		private MyService ms;

		@Override
		public void run(String... strings) throws Exception {
			System.out.println(">>> " + ms.getMessage());
		}
	}
}
