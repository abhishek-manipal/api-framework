package com.ramrewa.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Sys {
    private String country;
    private int sunrise;
    private int sunset;
    private int id;
    private int type;
}
