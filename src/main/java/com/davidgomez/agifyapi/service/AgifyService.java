package com.davidgomez.agifyapi.service;

import com.davidgomez.agifyapi.model.AgifyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@AllArgsConstructor
public class AgifyService {

    private final WebClient webClient;

    public AgifyResponse predictAge(String name) {
        try {
            String fullAgifyUrl = "https://api.agify.io/?name=" + name;

            AgifyResponse response = webClient.get()
                    .uri(fullAgifyUrl)
                    .retrieve()
                    .bodyToMono(AgifyResponse.class)
                    .block();

            return response;

        } catch (WebClientResponseException e) {
            System.err.println("ERROR: Agify.io respondió con un error HTTP: " + e.getStatusCode() + " - Body: " + e.getResponseBodyAsString());
            return null;
        }
    }
}