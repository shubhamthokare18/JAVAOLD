package com.example.currencyconverter.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ExchangeRateClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${app.external.base-url}")
    private String baseUrl;

    public double getRate(String from, String to) {

        String url = baseUrl + "/latest/" + from;

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null || !response.containsKey("rates")) {
            throw new RuntimeException("Invalid response from exchange rate API");
        }

        Map<String, Double> rates = (Map<String, Double>) response.get("rates");

        if (!rates.containsKey(to)) {
            throw new RuntimeException("Currency not supported: " + to);
        }

        return rates.get(to);
    }
}
