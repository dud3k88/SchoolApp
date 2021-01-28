package com.schoolapp.weather.webclient;

import com.schoolapp.weather.model.WeatherDto;
import com.schoolapp.weather.webclient.dto.OpenWeatherWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "219ff36e16c0b68cda9f7b319539c2e7";
    private RestTemplate restTemplate = new RestTemplate();

        public WeatherDto getWeatherForCity(String city){
            OpenWeatherWeatherDto openWeatherWeatherDto =
            callGetMethod("weather?q={city}&appid={apiKey}&units=metric",
                    OpenWeatherWeatherDto.class,
                    city, API_KEY);
            return WeatherDto.builder()
                    .temperature(openWeatherWeatherDto.getMain().getTemp())
                    .pressure(openWeatherWeatherDto.getMain().getPressure())
                    .humidity(openWeatherWeatherDto.getMain().getHumidity())
                    .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                    .build();
        }

        private <T> T callGetMethod(String url, Class<T> responseType, Object...object) {
            return restTemplate.getForObject(WEATHER_URL + url, responseType, object );
    }
}
