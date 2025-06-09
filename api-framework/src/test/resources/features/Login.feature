@REGRESSION
Feature: Fetching the weather using latitude and longitude

  Scenario: Fetching the weather details
    Given a user logs in the Open Weather Map using "xapi-key"
    When the user fetches the weather using "latitude" and "longitude"
    Then the weather should be fetched successfully
