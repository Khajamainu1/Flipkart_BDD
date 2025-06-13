Feature: Verify login functionality

  Scenario: Test with invalid data
    Given : User navigates to the url
    When : User enter the invalid phone number
    And : Click on request otp button
    Then : Verify invalid phone number message is be shown.
