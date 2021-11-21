package com.salesianostriana.dam.Proyecto3SpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Proyecto3SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto3SpringSecurityApplication.class, args);
	}

}
