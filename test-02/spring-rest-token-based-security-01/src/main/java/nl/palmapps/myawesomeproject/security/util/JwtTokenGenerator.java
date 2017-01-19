package nl.palmapps.myawesomeproject.security.util;

import org.joda.time.DateTime;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.palmapps.myawesomeproject.security.transfer.JwtUserDto;

/**
 * convenience class to generate a token for testing your requests.
 * Make sure the used secret here matches the on in your application.yml
 *
 * @author pascal alma
 */
public class JwtTokenGenerator {

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public static String generateToken(JwtUserDto u, String secret) {
    	DateTime currentTime = new DateTime();
    	
		Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("userId", u.getId() + "");
        claims.put("roles", u.getRoles());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(currentTime.toDate())
                .setExpiration(currentTime.plusMinutes(1).toDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    /*
     * 
     *  Claims claims = Jwts.claims().setSubject(userContext.getUsername());
        claims.put("scopes", userContext.getAuthorities().stream().map(s -> s.toString()).collect(Collectors.toList()));

        DateTime currentTime = new DateTime();

        String token = Jwts.builder()
          .setClaims(claims)
          .setIssuer(settings.getTokenIssuer())
          .setIssuedAt(currentTime.toDate())
          .setExpiration(currentTime.plusMinutes(settings.getTokenExpirationTime()).toDate())
          .signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey())
        .compact();
     */

    /**
     * @param args
     */
    public static void main(String[] args) {

        JwtUserDto user = new JwtUserDto();
        user.setId(123L);
//        user.setUsername("ahmet");
//        user.setRole("ROLE_ADMIN");
        user.setUsername("serdar");
        user.setRoles("ROLE_ADMIN", "ROLE_BASIC"); 

        System.out.println("**************************************\n\n" + generateToken(user, "my-very-secret-key") + "\n\n**************************************");
    }
}
