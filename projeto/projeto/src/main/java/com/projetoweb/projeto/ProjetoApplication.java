package com.projetoweb.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@org.springframework.boot.autoconfigure.SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
