package com.angelina.apiproject.angelina;

import com.angelina.apiproject.angelina.model.Fact;
import com.angelina.apiproject.ryan.model.Riddle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AngelinaAPIService {

    //update this
    private final String API_URL = "https://api.api-ninjas.com/v1/facts";

    public Fact getRandomFact() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        //Create header
        HttpHeaders headers = new HttpHeaders();
        //replace this key with you api key
        headers.set("X-Api-Key", "NKIVdJ8jlyjFXqxHNTpVqw==ncRQl2ihjqusVxuC");

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
        //replace this Riddle model with your custom model object depending on what your API Response looks like
        Fact[] facts = objectMapper.readValue(response.getBody(), Fact[].class);

        //update this with whatever is relevant
        return facts[0];
    }

}
