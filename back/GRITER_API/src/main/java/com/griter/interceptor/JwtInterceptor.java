package com.griter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.griter.util.JwtUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		// preflight를 위한 OPTIONS 요청은 그냥 전달
		if (req.getMethod().equals("OPTIONS")) return true;
		
		// request의 헤더에서  access-token으로 넘어온 것을 찾아본다.
		String authToken = req.getHeader("access-token");
		
		if (authToken != null) {
			// 유효한 토큰이면 진행, 그렇지 않으면 예외를 발생시킴.
			jwtUtil.valid(authToken);
			return true;
		} else throw new RuntimeException("인증된 토큰이 없습니다.");
	}
}
