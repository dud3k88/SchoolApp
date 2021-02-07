package com.schoolapp.controller;

import com.schoolapp.scheduler.WeatherInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school/schedule")
public class ScheduleController {
    @Autowired
    private WeatherInformation weatherInformation;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public String getInformation() {
       return weatherInformation.sendInformationAboutWeather();
    }
}
