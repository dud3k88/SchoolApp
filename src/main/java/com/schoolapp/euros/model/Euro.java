
package com.schoolapp.euros.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Euro {

    @JsonProperty("rates")
    private List<Rate> rates;

    @JsonProperty("rates")
    public List<Rate> getRates() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

}
