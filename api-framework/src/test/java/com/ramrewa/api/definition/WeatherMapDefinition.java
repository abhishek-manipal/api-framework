package com.ramrewa.api.definition;

import com.ramrewa.api.model.WeatherResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ramrewa.api.helper.WeatherMapHelper;

import java.util.logging.Logger;

public class WeatherMapDefinition extends WeatherMapHelper {
    private final static Logger logger = Logger.getLogger("WeatherMapDefinition.class");

    @When("^the user selects the weather with latitude \"([^\"]*)\" and longitude \"([^\"]*)\"$")
    public WeatherResponse theUserSelectsTheWeatherLatitudeAndLongitude(String latitude, String longitude) throws Throwable {
        logger.info("The user selects latitude and longitude");
        logger.info(latitude);
        logger.info(longitude);
        return null;
    }

    @Then("^the user should see information on weather map$")
    public void theUserShouldSeeInformationFromWeatherMap() {
        logger.info("This message is from API");
    }
}
