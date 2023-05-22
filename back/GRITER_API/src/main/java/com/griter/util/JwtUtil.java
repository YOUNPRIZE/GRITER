package com.griter.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.griter.model.dto.User;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component 
public class JwtUtil {
	private static final String SALT = "GRITER";
	
	// Create a Token
	// 인자로 키와 밸류가 넘어왔다라고만 처리 (한가지 정보만 넣는다고 가정)
	public String createToken(User user) throws UnsupportedEncodingException {
				return Jwts.builder()
				.setHeaderParam("alg", "HS256")
//				.setHeaderParam("typ", "JWT") // Header complete
//				.setHeaderParam(claimId, data)
//				.claim("userId", "ssafy")
				.claim("loginUser", user)
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60)) // Payload complete
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // signature complete
				.compact();
	}
	
	// Inspect validation
	public void valid(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
}
