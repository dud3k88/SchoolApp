package com.schoolapp.controller;

import com.schoolapp.euros.webclient.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/school/euro")
public class EuroController {

    @Autowired
    private WebClient webClient;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public Optional<Double> getEuro() {
        return webClient.getEuroValue();
    }
}
