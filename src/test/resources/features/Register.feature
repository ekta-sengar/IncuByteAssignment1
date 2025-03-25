Feature: Register Functionality

  Scenario: Successful registration
    Given I am on home page
    When I open the register page
    And I fill up the registration form
    And I click the register button
    Then I should be registered successfully