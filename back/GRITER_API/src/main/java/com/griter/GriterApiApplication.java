package com.griter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GriterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GriterApiApplication.class, args);
	}
}
