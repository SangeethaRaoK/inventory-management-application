package com.sangeetha.inventoryauthenticationservice.security;

import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component

public class JwtProvider {
	@Value("${jwt.expiration}")
	private Long jwtExpirationInMillis;
	@Value("${jwt.secret}")
	private String secret;
	@Autowired
	private SecretKey secretKey;
	SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	public boolean validateToken(String jwt) {
		Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt);
		return true;
	}
	public String getUsernameFromJwt(String token) {
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	public String generateTokenWithUsername(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(Date.from(Instant.now()))
				.signWith(signatureAlgorithm, secretKey)
				.setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis))).compact();
	}
	@Bean
	public SecretKey getSecretKey () {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
}