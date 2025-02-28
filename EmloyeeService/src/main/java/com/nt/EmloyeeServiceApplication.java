package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmloyeeServiceApplication {
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**") // Allow all paths
	                        .allowedOrigins("http://localhost:4200") // Allow specific origin
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific methods
	                        .allowedHeaders("*") // Allow all headers
	                        .allowCredentials(true); // Allow cookies
	            }
	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(EmloyeeServiceApplication.class, args);
	}

}
