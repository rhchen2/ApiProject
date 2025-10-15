package com.angelina.apiproject.ryan;

import com.angelina.apiproject.ryan.model.Riddle;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RyanAPIController {


    private final RyanAPIService ryanAPIService;

    public RyanAPIController(RyanAPIService ryanAPIService) {
        this.ryanAPIService = ryanAPIService;
    }

    @GetMapping("/riddle")
    public Riddle getRiddle() throws JsonProcessingException {

        Riddle riddle = ryanAPIService.getRandomRiddle();

        System.out.print(riddle.getQuestion());

        return riddle;
    }

}
