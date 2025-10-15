package com.angelina.apiproject.ryan;

import com.angelina.apiproject.ryan.model.Riddle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Service
public class RyanAPIService {

    private final String API_URL = "https://api.api-ninjas.com/v1/riddles";

    @Value("${API_KEY}") // Assuming API_KEY is set as an environment variable
    private String apiKey;

    public Riddle getRandomRiddle() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        //Create header
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);

        // Create HttpEntity with headers (and optionally a request body)
        HttpEntity<String> requestEntity = new HttpEntity<>("Request Body", headers);

        ResponseEntity<String> response = restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        //once we have the response from the api we need to mold it into our custom object "Riddle"
        ObjectMapper objectMapper = new ObjectMapper();
        Riddle[] riddles = objectMapper.readValue(response.getBody(), Riddle[].class);

        //return riddle
        return riddles[0];
    }

}
