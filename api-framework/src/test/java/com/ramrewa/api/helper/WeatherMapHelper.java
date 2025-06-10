package com.ramrewa.api.helper;

import java.util.HashMap;
import java.util.logging.Logger;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramrewa.api.model.WeatherResponse;
import com.ramrewa.api.util.TestProperties;
import com.ramrewa.api.util.URLResources;

public class WeatherMapHelper extends BaseHelper {
    private final static Logger logger = Logger.getLogger("WeatherMapHelper.class");

    public WeatherResponse theUserSelectsTheWeatherLatitudeAndLongitude(Float lat, Float lon) throws Throwable {
        WeatherResponse response = null;
        String endPoint = URLResources.ONECALL_V1 + "?lat={" + lat + "}&lon={" + lon + "}&exclude={current}&appid={" + TestProperties.get("xapi-key")
                + "}";
        /*
https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        Map<String, String> mapWebserviceResponse = new HashMap<String, String>();
        Map<String, String> queryParams = new HashMap<String, String>();

        WeatherResponse = invocationUtil.invoke(endPoint, authToken, queryParams);

        String responseStr = mapWebserviceResponse.get("response");

        response = mapper.readValue(responseStr, WeatherResponse.class);
        return response;
return response;
*/
        return response; 
    }
}
