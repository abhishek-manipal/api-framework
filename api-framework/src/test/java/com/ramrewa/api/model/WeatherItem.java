package com.ramrewa.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WeatherItem {
    private String icon;
    private String description;
    private String main;
    private int id;
}
