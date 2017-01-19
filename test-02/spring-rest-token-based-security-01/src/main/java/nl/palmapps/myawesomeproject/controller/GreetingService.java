package nl.palmapps.myawesomeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import nl.palmapps.myawesomeproject.model.Greeting;
import nl.palmapps.myawesomeproject.model.LoginResult;
import nl.palmapps.myawesomeproject.security.config.FakeUserDetailsService;
import nl.palmapps.myawesomeproject.security.transfer.JwtUserDto;
import nl.palmapps.myawesomeproject.security.util.JwtTokenGenerator;

@Service
public class GreetingService {

	@Autowired
	private FakeUserDetailsService fakeUserDetailsService;
	
	public Greeting getHello() {
		return new Greeting(0, "hello there");
	}

	@PreAuthorize("#username == authentication.name")
	public Greeting getHi(String username) {
		return new Greeting(0, "hello " + username);
	}

	@PreAuthorize("@mySecurityService.hasPermission(authentication, #username)")
	public Greeting getHi2(String username) {
		return new Greeting(0, "helloww " + username);
	}

	public LoginResult getToken(String username, String password) {
		LoginResult result = new LoginResult();
		UserDetails userByUsername = fakeUserDetailsService.loadUserByUsername(username);
		if(userByUsername != null && userByUsername.getPassword().equals(password)) {
			JwtUserDto user = new JwtUserDto();
			user.setId(123L);
			user.setUsername(username);
			user.setRoles(userByUsername.getAuthorities());
			result.setTokenKey(JwtTokenGenerator.generateToken(user, "my-very-secret-key"));
		}
		return result;
	}

}
