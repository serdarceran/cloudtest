package nl.palmapps.myawesomeproject.security.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Simple placeholder for info extracted from the JWT
 *
 * @author pascal alma
 */
public class JwtUserDto {

    private Long id;

    private String username;

	private List<GrantedAuthority> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public void setRoles(String... roles) {
		this.roles = AuthorityUtils.createAuthorityList(roles);
	}
	
	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles.stream().collect(Collectors.toList());
	}
	
	public List<GrantedAuthority>  getRoles() {
		return  roles;
	}
}