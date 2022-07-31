package com.app.socialmedia_api.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenHelper {

	public static final long JWT_TOKEN_VALIDITY=5 * 60 *60 ;
	private String secret= "jwttokenkey";
	
	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpiryDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T>T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
		final Claims claims=getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration=getExpiryDateFromToken(token);
		return expiration.before(new java.util.Date());
	}
	
	public String generatedToken(UserDetails userDetails) {
		Map<String, Object> claims=new HashMap<>();
		return doGeneratedToken(claims, userDetails.getUsername());
	}
	
	//HS521 JWS-COMAPT_SERLIZATION 
	
	private String doGeneratedToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY *100))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username=getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
