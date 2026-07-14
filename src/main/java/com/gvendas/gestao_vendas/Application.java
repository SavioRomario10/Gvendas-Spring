package com.gvendas.gestao_vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.gvendas.gestao_vendas.entities"})
@ComponentScan(basePackages = {"com.gvendas.gestao_vendas.controller", "com.gvendas.gestao_vendas.service"})
@EnableJpaRepositories(basePackages = "com.gvendas.gestao_vendas.repository")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}