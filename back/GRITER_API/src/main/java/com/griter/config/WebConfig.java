package com.griter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.griter.interceptor.JwtInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//		registry.addResourceHandler("/**").addResourceLocations("file:/static/");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
	}
	
	@Autowired
	private JwtInterceptor jwtInterceptor;
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**") // 기본 적용 경로
////				.excludePathPatterns(Arrays.asList("/users/login")); // 적용 제외 경로
//				.excludePathPatterns("/api/users/jwt",
//						"/api/users/login",
//						"/swagger-resources/**",
//						"/swagger-ui/**",
//						"/v2/api-docs");
//	}
}