package com.griter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.jsonwebtoken.ExpiredJwtException;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class LoginException {
	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<String> makeCookie(ExpiredJwtException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
	} 
}
