package com.example.Plabs_Proj02;

import springfox.documentation.builders.RequestHandlerSelectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("com.example.Plabs_Proj02.repositories")
@EnableSwagger2
public class PlabsProj02Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PlabsProj02Application.class, args);
	}

	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.example.Plabs_Proj02.controllers")).build();
	}
}
