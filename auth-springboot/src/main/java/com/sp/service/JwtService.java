package com.sp.service;
import java.util.Optional;

import java.io.Serializable;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import com.sp.model.Auth;
import org.springframework.context.annotation.PropertySource;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService implements Serializable {

	@Autowired
	AuthService authService;
	
	@Value("${server.config.secret:default_value}")
   	private String secret;
    
	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	public String generateToken(Auth userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getId().toString());
	}

    public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

    private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
    
    private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

    public Boolean validateToken(String token) {
		final String user_id = getUsernameFromToken(token);
        Optional<Auth> user = this.authService.getUserById(Integer.parseInt(user_id));
        if(user != null) return true;
        else return false;
	}

}
