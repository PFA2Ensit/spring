package com.spring.pfa2;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

import com.spring.entity.Annonce;
import com.spring.entity.Annonceur;
import com.spring.entity.Etudiant;
import com.spring.repository.AnnonceRepository;
import com.spring.repository.AnnonceurRepository;
import com.spring.repository.EtudiantRepository;
@Configuration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class },scanBasePackages={
		"com.spring.service","com.spring.controller"})
@ComponentScan(basePackageClasses = {EtudiantRepository.class})
@EntityScan(basePackageClasses = {Etudiant.class})
@EnableJpaRepositories(basePackageClasses = {EtudiantRepository.class})
public class Pfa2Application /*implements CommandLineRunner*/{
	@Autowired
	private AnnonceurRepository rep;
	@Autowired
	private AnnonceRepository repann;
	public static void main(String[] args) {
		SpringApplication.run(Pfa2Application.class, args);
		
		
	}

	/*@Override
	public void run(String... args) throws Exception {
		saveData("a@a.com");
		showData();
	}
	 @Transactional
	    private void saveData(String email){
		 Annonceur owner = rep.findByEmail(email);
		 System.out.println(owner.getId());
		 Annonce a = new Annonce("Isamm",250,"hdydyd",1,"Foyer","ensit.png",true,"garçon",owner);
		 repann.save(a);
	    }
	
	@Transactional
    private void showData() {
		
		 
		Optional<Annonce> productLst = repann.findById(39);
		 System.out.println("===================Annonce List:==================");
	         System.out.println(productLst);
	}
	*/
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
