package com.amin.gestiondestock.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amin.gestiondestock.model.auth.ExtendedUser;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
	
	private String SECRET_KEY = "secret";
	public static final long JWT_TOKEN_VALIDITY = 10 * 60 * 60;
	
    public String extractUsername(String token) {
        return extractClaimFrom(token, Claims::getSubject);
    }
    
    public String extractIdEntreprise(String token) {
    	final Claims claims = getAllClaimsFromToken(token);
        return claims.get("idEntreprise", String.class);
    }

    public Date  extractExpiration(String token) {
        return extractClaimFrom(token, Claims::getExpiration);
    }

    public <T> T extractClaimFrom(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = extractExpiration(token);
        return expiration.before(new Date());
    }

    public String generateToken(ExtendedUser userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails);
    }

    private String doGenerateToken(Map<String, Object> claims, ExtendedUser userDeatils) {
        return Jwts.builder().setClaims(claims)
        		.setSubject(userDeatils.getUsername())
        		.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .claim("idEntreprise", userDeatils.getIdEntreprise().toString())
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
