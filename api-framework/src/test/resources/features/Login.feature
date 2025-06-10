@REGRESSION
Feature: Fetching the weather using latitude and longitude

  Scenario Outline: Fetching the weather details
    When the user selects the weather with latitude "latitude" and longitude "longitude"
    Then the user should see information on weather map

Examples:
  | latitude        | longitude      |
  | 33.44           | -94.04         |
  | 33.86           | 151.20         |