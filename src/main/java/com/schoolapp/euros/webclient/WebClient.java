package com.schoolapp.euros.webclient;

import com.schoolapp.euros.model.Euro;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class WebClient {

    RestTemplate restTemplate = new RestTemplate();

    public Optional<Double> getEuroValue() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/EUR/";

        Euro euroValue = restTemplate.getForObject(url, Euro.class);

        Optional<Double> euroVal = euroValue.getRates().stream()
                .map(t -> t.getMid())
                .findAny();

        return euroVal;
    }
}
