@REGRESSION
Feature: Fetching the weather using latitude and longitude

  Scenario Outline: Fetching the weather details
    Given a user logs in the Open Weather Map using "xapi-key"
    When the user fetches the weather using "latitude" and "longitude"
    Then the weather should be fetched successfully

Examples:
  | latitude        | longitude      |
  | 33.44           | -94.04         |
  | 33.86           | 151.20         |