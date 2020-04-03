package com.spring.pfa2;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.entity.Etudiant;
import com.spring.repository.EtudiantRepository;

@SpringBootApplication
@ComponentScan(basePackageClasses = {EtudiantRepository.class})
@EntityScan(basePackageClasses = {Etudiant.class})
@EnableJpaRepositories(basePackageClasses = {EtudiantRepository.class})
public class Pfa2Application {

	public static void main(String[] args) {
		SpringApplication.run(Pfa2Application.class, args);
	}

}
