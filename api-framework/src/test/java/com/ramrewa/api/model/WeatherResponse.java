package com.ramrewa.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WeatherResponse {
    private Rain rain;
    private int visibility;
    private int timezone;
    private WeatherHumidity weatherHumidity;
    private Clouds clouds;
    private Sys sys;
    private int dt;
    private Coord coord;
    private List<WeatherItem> weather;
    private String name;
    private int cod;
    private int id;
    private String base;
    private Wind wind;
}