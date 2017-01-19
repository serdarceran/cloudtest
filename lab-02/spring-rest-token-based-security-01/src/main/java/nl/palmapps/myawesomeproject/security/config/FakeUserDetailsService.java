package nl.palmapps.myawesomeproject.security.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FakeUserDetailsService implements UserDetailsService {

	@Autowired
	private PersonRespository personRespository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRespository.findByFirstNameEquals(username);
		if (person == null) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return new User(username, person.getPassword(), getGrantedAuthorities(person.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		return roles.stream()
				.map(role-> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());
	}
}