package com.schoolapp.weather.service;

import com.schoolapp.weather.model.WeatherDto;
import com.schoolapp.weather.webclient.WeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather() {
        return weatherClient.getWeatherForCity("Wroclaw");
    }
}
