package nl.palmapps.myawesomeproject.security.config;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class PersonRespository {
	private static Person[] persons = new Person[] {
		new Person("serdar", "serdar", "ROLE_ADMIN", "ROLE_BASIC"),
		new Person("ahmet", "ahmet", "ROLE_BASIC")
	};
	
	public Person findByFirstNameEquals(String username) {
		return Arrays.stream(persons)
		.filter(p-> p.getUsername().equals(username))
		.findFirst()
		.orElse(null);
	}

}
