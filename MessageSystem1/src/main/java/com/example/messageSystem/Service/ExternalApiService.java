package com.example.messageSystem.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ExternalApiService {

    private final WebClient webClient;

    public ExternalApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.ipify.org").build();
    }

    public Mono<String> getExternalIp() {
        return this.webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .onErrorReturn("Unable to retrieve external IP");
    }

    public Mono<String> getLocationFromIp(String ipAddress) {
        WebClient client = WebClient.create("https://ipapi.co");
        return client.get()
                .uri("/{ip}/json", ipAddress)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    if (response != null && response.get("city") != null && response.get("country_name") != null) {
                        return response.get("city") + ", " + response.get("country_name");
                    }
                    return "Location not available";
                })
                .onErrorReturn("Unable to retrieve location");
    }
}
