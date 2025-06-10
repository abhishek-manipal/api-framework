package com.ramrewa.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Wind {
    private int deg;
    private Object speed;
    private Object gust;
}
