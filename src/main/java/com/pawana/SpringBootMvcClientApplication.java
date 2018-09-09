package com.pawana;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootMvcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcClientApplication.class, args);
	}

	@Bean
	public RestTemplate getresttemplate() {

		return new RestTemplateBuilder().build();
	}

}
