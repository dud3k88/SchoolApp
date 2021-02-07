
package com.schoolapp.euros.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {
    @JsonProperty("mid")
    private Double mid;

    @JsonProperty("mid")
    public Double getMid() {
        return mid;
    }
    @JsonProperty("mid")
    public void setMid(Double mid) {
        this.mid = mid;
    }
}
