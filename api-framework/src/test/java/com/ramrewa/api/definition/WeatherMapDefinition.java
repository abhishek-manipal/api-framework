package com.ramrewa.api.definition;

import com.ramrewa.api.model.WeatherResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ramrewa.api.helper.WeatherMapHelper;

import java.util.logging.Logger;

public class WeatherMapDefinition extends WeatherMapHelper {
    private final static Logger logger = Logger.getLogger("WeatherMapDefinition.class");

    @When("^the user selects the weather with latitude \"([^\"]*)\" and longitude \"([^\"]*)\"$")
    public WeatherResponse theUserSelectsTheWeatherWithLatitudeAndLongitude(String latitude, String longitude) throws Throwable {
        logger.info("The user selects latitude and longitude");
        logger.info(latitude);
        logger.info(longitude);
        return null;
    }

    @Then("^the user should see information on weather map$")
    public void theUserShouldSeeInformationFromWeatherMap() {
        logger.info("This message is from API");
        /*List<Location> locations = rewardsDiscoverResponse.getData().getRewardsDiscover().getItems().get(0).getLocations();
        for (Location location : locations) {
            Assert.assertTrue(location.getIcon().matches(".*(openweathermap)"), "Location icon is not returned");
            Assert.assertTrue(location.getAddress().matches("^[ A-Za-z0-9-]*$"), "Location address is not returned");
            Assert.assertTrue(location.getDistance().contains("km"), "Location distance is not returned");
            Assert.assertNotNull(location.getStoreNo(), "Location store no is not returned");
            Assert.assertNotNull(location.getLatitude(), "Location latitude is not returned");
            Assert.assertNotNull(location.getLongitude(), "Location longitude is not returned");*/
        }
    }
}
