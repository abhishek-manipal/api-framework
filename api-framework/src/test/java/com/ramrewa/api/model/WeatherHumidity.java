package com.ramrewa.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WeatherHumidity {
    private Object temp;
    private Object tempMin;
    private int grndLevel;
    private int humidity;
    private int pressure;
    private int seaLevel;
    private Object feelsLike;
    private Object tempMax;
}
