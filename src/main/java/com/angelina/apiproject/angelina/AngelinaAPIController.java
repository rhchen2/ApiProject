package com.angelina.apiproject.angelina;

import com.angelina.apiproject.ryan.RyanAPIService;
import com.angelina.apiproject.ryan.model.Riddle;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AngelinaAPIController {


    private final AngelinaAPIService angelinaAPIService;

    public AngelinaAPIController(AngelinaAPIService angelinaAPIService) {
        this.angelinaAPIService = angelinaAPIService;
    }


    //rename this to what your api does
    @GetMapping("/quote")
    public Riddle getQuote() throws JsonProcessingException {

        Riddle riddle = angelinaAPIService.getRandomRiddle(); //change this to whatever your api does

        //change what you print out depending on what you api is
        System.out.print(riddle.getQuestion());

        return riddle;
    }

}
