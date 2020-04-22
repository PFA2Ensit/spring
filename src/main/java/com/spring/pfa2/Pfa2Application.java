package com.spring.pfa2;

import java.util.Arrays;
import java.util.Collections;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.entity.Etudiant;
import com.spring.repository.EtudiantRepository;
@Configuration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class },scanBasePackages={
		"com.spring.service","com.spring.controller"})
@ComponentScan(basePackageClasses = {EtudiantRepository.class})
@EntityScan(basePackageClasses = {Etudiant.class})
@EnableJpaRepositories(basePackageClasses = {EtudiantRepository.class})
public class Pfa2Application {

	public static void main(String[] args) {
		SpringApplication.run(Pfa2Application.class, args);
		
		
	}
	
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/*").allowedOrigins("http://localhost:4200");
			}
		};
	}
	
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); // Provide list of origins if you want multiple origins
	    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept","WWW-Authenticate"));
	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
	    config.setAllowCredentials(true);
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter();
	}*/

}
