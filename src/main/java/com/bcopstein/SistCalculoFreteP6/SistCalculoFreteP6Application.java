package com.bcopstein.SistCalculoFreteP6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.bcopstein" })
@EntityScan(basePackages = { "com.bcopstein" })
public class SistCalculoFreteP6Application {
	public static void main(String[] args) {
		SpringApplication.run(SistCalculoFreteP6Application.class, args);
	}
}
