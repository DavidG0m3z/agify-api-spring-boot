package com.davidgomez.agifyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class AgifyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgifyapiApplication.class, args);
	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder()
				.baseUrl("http://api.agify.io")
				.build();
	}

}
