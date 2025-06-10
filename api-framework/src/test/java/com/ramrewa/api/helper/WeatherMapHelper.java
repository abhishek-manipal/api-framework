package com.ramrewa.api.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.ramrewa.api.model.WeatherResponse;
import com.ramrewa.api.util.TestProperties;
import com.ramrewa.api.util.URLResources;
import com.ramrewa.api.util.RestInvocationUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherMapHelper extends BaseHelper {
    private final static Logger logger = Logger.getLogger("WeatherMapHelper.class");
    protected ObjectMapper mapper = new ObjectMapper();

    public WeatherResponse theUserSelectsTheWeatherWithLatitudeAndLongitude(Float lat, Float lon) throws Throwable {
        WeatherResponse response = null;
        String endPoint = URLResources.ONECALL_V1 + "?lat={" + lat + "}&lon={" + lon + "}&exclude={current}&appid={" + TestProperties.get("xapi-key")
                + "}";

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        Map<String, String> mapWebserviceResponse = new HashMap<String, String>();
        Map<String, String> queryParams = new HashMap<String, String>();

        //WeatherResponse = invocationUtil.invoke(endPoint, authToken, queryParams);

        String responseStr = mapWebserviceResponse.get("response");

        response = mapper.readValue(responseStr, WeatherResponse.class);
        return response;

    }
}
