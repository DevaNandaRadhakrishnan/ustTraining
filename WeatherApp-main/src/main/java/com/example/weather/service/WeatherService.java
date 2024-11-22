package com.example.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public Mono<String> getWeatherByCity(String city) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/weather")
                        .queryParam("q", city)
                        .queryParam("appid", "9c88fc92a8f1b40a82698ebdfd84663b")
                        .queryParam("units", "metric")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
