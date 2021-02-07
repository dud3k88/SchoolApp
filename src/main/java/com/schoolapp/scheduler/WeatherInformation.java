package com.schoolapp.scheduler;

import com.schoolapp.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class WeatherInformation {
    @Autowired
    private WeatherService weatherService;

    public String sendInformationAboutWeather() {
        float temperature = weatherService.getWeather().getTemperature();
        LocalDate dateNow = LocalDate.now();

        if (temperature < 0) {
            return "Be careful on the road it can be slippery. Temperature below 0. " + dateNow;
        } else {
            return "You can drive safely. It is not slippery on the road, the temperature is above 0.  " + dateNow;
        }
    }

}
