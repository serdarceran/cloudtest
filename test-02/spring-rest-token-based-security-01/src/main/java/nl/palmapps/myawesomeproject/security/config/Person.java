package nl.palmapps.myawesomeproject.security.config;

import java.util.Arrays;
import java.util.List;

public class Person {

	private String username;
	private String password;
	private List<String> roles;
	
	public Person(String username, String password, String... roles) {
		this.username = username;
		this.password = password;
		this.roles = Arrays.asList(roles);
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<String> getRoles() {
		return roles;
	}	
	
	
}
