package com.ramrewa.api.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ramrewa.api.helper.WeatherMapHelper;

public class WeatherMapDefinition extends WeatherMapHelper {

    @When("^the user selects the weather with latitude \"([^\"]*)\" and longitude \"([^\"]*)\"$")
    public void theUserSelectsTheWeatherLatitudeAndLongitude(Float latitude, Float longitude) throws Throwable {
//        InputStream iStream = DiscoverDefinition.class.getResourceAsStream("/gqlQueries/metis/queries/rewards/discoverFeed.graphql");
//        ObjectNode variables = new ObjectMapper().createObjectNode();
//
//        variables.put("latitude", latitude);
//        variables.put("longitude", longitude);
//        String graphqlQuery = GraphqlParser.parseGraphql(iStream, variables);
//        rewardsDiscoverResponse = iRetrieveDiscoverFeed(graphqlQuery);
        System.out.println("The user selects latitude and longitude.");
    }

    @Then("^the user should see information on stores nearby$")
    public void theUserShouldSeeInformationOnStoresNearby() {
        System.out.println("Success message displayed.");
    }
}
